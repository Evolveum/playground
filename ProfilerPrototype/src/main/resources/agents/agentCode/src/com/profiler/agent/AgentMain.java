package com.profiler.agent;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.security.ProtectionDomain;
import java.util.*;

/**
 *
 *  This is the main class of custom java agent build for purposes
 *  of custom java profiler
 *
 *  @author Erik Suta
 *
 * */
public class AgentMain implements ClassFileTransformer {

    /* OWN CLASSES */
    public static List<String> ownClassList = new ArrayList<String>(Arrays.asList(
            "com/profiler/agent/CommunicationClient",
            "com/profiler/agent/CommunicationClientThread",
            "com/profiler/agent/Instrumentations",
            "com/profiler/agent/AgentMain",
            "com/profiler/agent/TimeMeasurement",
            "com/profiler/agent/ProfilingPacketType",
            "com/profiler/agent/TimeMeasurement$MethodRun",
            "com/profiler/agent/MemoryMeasurement",
            "com/profiler/agent/ThreadMeasurement",
            "com/profiler/agent/CPUmeasurement",
            "com/profiler/agent/ClassMeasurement",
            "com/profiler/agent/ProfilingThread",
            "com/profiler/agent/MethodRun"
    ));

    /* Attributes */
    protected static Instrumentation instrumentation = null;
    protected ClassPool classPool;

    /**
     *  Constructor
     * */
    public AgentMain(Instrumentation inst, boolean what){
        //Object dummyObject = new Object().getClass();
        instrumentation = inst;
        classPool = ClassPool.getDefault();
        instrumentation.addTransformer(this, true);

        //Empty methods invocation to load agent Classes
        CommunicationClient.dummyTest();
        com.profiler.agent.Instrumentations.dummyTest();
    }

    /**
     *  Modify classes
     * */
    public static void modifyClasses(){
        System.out.println("MODIFYING CLASSES!");
        Class[] classList = instrumentation.getAllLoadedClasses();

        List<Class> modifiableClassList = new ArrayList<Class>();
        int counter = 0;
        for(int i = 0; i < classList.length; i++){

            for(String clName: Instrumentations.profiledMethodMap.keySet())
                if(clName.equals(classList[i].getName().replace("/",".")))
                    if(instrumentation.isModifiableClass(classList[i])){
                        System.out.println("Added class: " + clName);
                        modifiableClassList.add(counter, classList[i]);
                        counter++;
                    }
        }

        Class[] modifiableClassField = new Class[modifiableClassList.size()];
        for(int i = 0; i < modifiableClassList.size();i++)
            modifiableClassField[i] = modifiableClassList.get(i);

        System.out.println("NUMBER OF CLASSES MODIFIED: " + modifiableClassField.length);
        try{
            System.out.println("MODIFIABLE CLASS?: " + instrumentation.isRetransformClassesSupported());
            instrumentation.retransformClasses(modifiableClassField);
        }catch (UnmodifiableClassException uce){
            //TODO
            uce.printStackTrace();
        }
    }

    /**
     *  Premain Method
     *
     *  In this method, agent decides what to do based on arguments passed on
     *  agent load.
     * */
    public static void premain(String agentArgs, Instrumentation inst){
        System.out.println("PreMain was called!");

        AgentMain agent = new AgentMain(inst, false);
    }

    /**
     *  Agent main
     * */
    public static void agentmain(String agentArgs, Instrumentation inst){
        System.out.println("AgentMain was called!");

        //Instrumentations.createProfilingThread();

        try{
            CommunicationClient.connectToProfilingServer();
            CommunicationClient.setupClientStreams();
            CommunicationClient.initCommunicationClientThread();
        }catch (IOException ioe){
            //TODO
            ioe.printStackTrace();
        }

        Instrumentations.createProfilingThread();

        AgentMain agent = new AgentMain(inst, true);
    }

    /**
     *  Here we will transform the bytecode of loaded classes and much more
     * */
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

        System.out.println("Client - Class loaded: (" + className + ") (" + classfileBuffer.length + " bytes)");

        if(className.startsWith("sun/reflect/Generated"))
            return null;

        try{
            classPool.insertClassPath(new ByteArrayClassPath(className, classfileBuffer));
            CtClass cc = classPool.get(className.replace("/","."));
            CtMethod[] methods = cc.getMethods();

            //do some necessary administration stuff
            if(ownClassList.contains(className)){
                return cc.toBytecode();
            }

            for(int i = 0; i < methods.length; i++){
                if(methods[i].getLongName().startsWith(className.replace("/", "."))){
                    if(methods[i].getName().equals("main")){
                        //beforeMain(methods[i]);
                        afterMain(methods[i]);
                        continue;
                    }

                    //if(ProfilingThread.methodProfiling){
                            //System.out.println("METHOD PROFILING!");
                            if(methods[i].getName().equals("memoryTest") && methods[i].getName().endsWith("doSomething")){
                                System.out.println("Profiling method: " + className + "." + methods[i].getName());
                                methods[i].insertBefore("com.profiler.agent.Instrumentations.insertStopwatchBefore("+"\""+methods[i].getName()+"\""+");");
                                methods[i].insertAfter("com.profiler.agent.Instrumentations.insertStopwatchAfter("+"\""+methods[i].getName()+"\""+");");

                            }
                    //}
                }
            }

            //return byte array of instrumented class
            byte[] newClassfileBuffer = cc.toBytecode();
            return newClassfileBuffer;

        }catch(IOException ioe){
            System.out.println("Oops, something went wrong! IO" + ioe.getMessage());
            ioe.printStackTrace();
            //TODO - send error information to logger via sockets
        }catch (NotFoundException nfe){
            System.out.println("Oops, something went wrong! NotFound" + nfe.getMessage());
            nfe.printStackTrace();
            //TODO - send error information to logger via sockets
        }catch(CannotCompileException cce){
            System.out.println("Oops, something went wrong! CannotCompile" + cce.getMessage());
            cce.printStackTrace();
            //TODO - send error information to logger via sockets
        }

        return null;
    }

    /**
     *  Method intercepts main method and performs all necessary bytecode injections before main method
     * */
    public static void beforeMain(CtMethod main){

        try{
            main.insertBefore("com.profiler.agent.Instrumentations.createProfilingThread();" +
                              "com.profiler.agent.CommunicationClient.connectToProfilingServer();" +
                              "com.profiler.agent.CommunicationClient.setupClientStreams();" +
                              "com.profiler.agent.CommunicationClient.initCommunicationClientThread();"
                             );

        }catch (CannotCompileException cce){
            cce.printStackTrace();
            //TODO - print some meaningful error message
        }
    }   //beforeMain end

    /**
     *  Method intercepts main method and performs all necessary bytecode injections before after method
     * */
    public static void afterMain(CtMethod main){

        try{
            main.insertAfter("com.profiler.agent.CommunicationClient.TRANSMISSION_END = true;" +
                             "com.profiler.agent.CommunicationClient.sendTerminationPacket();" +
                             "com.profiler.agent.CommunicationClient.closeSocketClient();"
                            );
        }catch (CannotCompileException cce){
            cce.printStackTrace();
            //TODO - print some meaningfull error message
        }
    }   //afterMain end

}
