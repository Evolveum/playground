package com.suta.profiler.util;

import com.profiler.agent.*;
import com.suta.profiler.Attributes;
import com.suta.profiler.gui.profiling.*;
import com.suta.profiler.types.ProjectType;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *  This class contains all methods and functionality, that is necessary
 *  for communication between server JVM (profiler) and JVM, on which profiled program
 *  is being run. For Inter-process communication, we use Sockets from java.net package.
 *
 *  @author Erik Suta
 * */
public class CommunicationServer {

    /* Attributes */
    public static ServerSocket serverSocket;
    public static Socket socket;

    public static ObjectInputStream serverObjectInputStream;
    public static ObjectOutputStream serverObjectOutputStream;

    /**
     *  Creates new Thread for new profiling project. In this thread, all communication between
     *  profiling Server and profiling Client is performed.
     * */
    public static void initCommunicationServerThread(ProjectType project){
        try{
            serverSocket = new ServerSocket(Attributes.PROFILING_PORT, 2, InetAddress.getLocalHost());
            System.out.println("Server - ServerSocket created on port: " + serverSocket.getLocalPort());
        }catch (UnknownHostException uhe){
            uhe.printStackTrace();
            //TODO - log this stuff properly
        }catch (IOException ioe){
            ioe.printStackTrace();
            //TODO - log this stuff properly
        }
        new CommunicationServerThread(project);
    }


    /**
     *  Perform ServerSocket initialization
     * */
    public static void initServerSocket(ProjectType project){

        while (true){
            try{
                createServerSocket();
                setupServerStreams(project);
                collectProfilingData();

                //System.out.println("Server socket configuration was completed!");

            }catch (SocketTimeoutException ste){
                System.out.println("Connection TimeOut");
                ste.printStackTrace();
                //TODO - log error with good error code and stuff
            }catch (EOFException eofe){
                eofe.printStackTrace();
                System.out.println("Communication has been terminated! " + eofe.getMessage());
                break;
                //TODO - log error with good error code and stuff
            }catch (IOException ioe){
                ioe.printStackTrace();
                //TODO - log error with good error code and stuff
            }catch (ClassNotFoundException ccne){
                ccne.printStackTrace();
                //TODO - log error with good error code and stuff
            }finally {
                closeServerSocket();
            }
        }
    }   //initServerSocket end

    /**
     *  Closes all socket streams
     * */
    public static void closeServerSocket(){

        try{
            serverObjectInputStream.close();
            //serverInputStream.close();
            serverObjectOutputStream.close();
            //serverOutputStream.close();
            socket.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
            //TODO - log error with good error code and stuff
        }
    }   //closeServerSocket end

    /**
     *  Initializes server Socket
     * */
    private static void createServerSocket() throws SocketTimeoutException, IOException, SocketTimeoutException {
        serverSocket.setSoTimeout(10000);
        socket = serverSocket.accept();
        System.out.println("Server: connection to: " + socket.getInetAddress());
    }

    /**
     *  Setup all necessary streams for communication
     * */
    private static void setupServerStreams(ProjectType project) throws IOException{
        serverObjectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        serverObjectOutputStream.flush();
        serverObjectInputStream = new ObjectInputStream(socket.getInputStream());
        System.out.println("Server: Streams were configured properly!");
        prepareInstructionPacket(project);
    }

    /**
     *  Handles communication between profiling Server and profiling Client
     * */
    private static void collectProfilingData() throws ClassNotFoundException, IOException{

        //TODO - clean lists in each iteration (when data packet is received)
        List<MemoryMeasurement> memoryData;
        List<CPUmeasurement> cpuData;
        List<ThreadMeasurement> threadData;
        List<ClassMeasurement> classData;
        Map<String, TimeMeasurement> methodRunList;
        String message = null;

        do{
            message = (String)serverObjectInputStream.readObject();

            if(message.equals("DATA")){
                System.out.println("Server: packet received: " + message);

                ProfilingPacketType.deserializePacket();
                memoryData = ProfilingPacketType.memoryUsageList;
                //System.out.println("MemoryData: " + memoryData);
                ProfilingMemoryPage.prepareMemoryData(memoryData);
                cpuData = ProfilingPacketType.cpuUsageList;
                ProfilingCPUPage.prepareData(cpuData);
                //printCpuData(cpuData);
                threadData = ProfilingPacketType.threadList;
                ProfilingThreadsPage.prepareData(threadData);
                //System.out.println("Received thread data: " + threadData.size());
                classData = ProfilingPacketType.classUsageList;
                ProfilingClassesPage.prepareData(classData);
                //System.out.println(classData.size());
                methodRunList = ProfilingPacketType.methodTimeList;
                ProfilingMethodsPage.prepareData(methodRunList);
                //printMethodRuns(methodRunList);

                ProfilingOverviewPage.getProfilingData();
                ProfilingVMSummaryPage.collectVMData();

            }

        }while (!message.equals(Attributes.PROFILING_PACKET_MESSAGE_TERMINATE));
        throw new EOFException("Agent has finished it's job.");
    }

    /**
     *  Send profiling packet
     * */
    public static void sendProfilingPacket(Instruction inst){

        printInstruction(inst);

        try{
            do{
                if(serverObjectOutputStream != null){
                    serverObjectOutputStream.writeObject(new String("INST"));
                    serverObjectOutputStream.flush();
                    Instruction.writeInstruction(inst);
                }
            }while (serverObjectOutputStream == null);

            System.out.println("Server - sending INSTRUCTION test packet!");
        }catch (IOException ioe){
            ioe.printStackTrace();
            //TODO - log this error state properly
        }
    }

    /**
     *  Prepares packet with instructions about which methods in which class are to be profiled
     * */
    public static void prepareInstructionPacket(ProjectType project){
        Instruction inst = new Instruction();

        if(project.getSelectedProfilingScenario() != null){
            inst.setProfiledMethodList(project.getSelectedProfilingScenario().methodList);
            inst.setProfilingScenario(true);
        }else{
            inst.setProfilingScenario(false);
        }

        if(project.getSelectedProfilingLevel() != null){
            //System.out.println("Level Name: " + project.getSelectedProfilingLevel().getName());
            inst.setProfilingLevelMap(project.getSelectedProfilingLevel().getLevelMap());
        }else{
            Map<String, Integer> defaultLevelMap = new HashMap<String, Integer>();
            defaultLevelMap.put("memory", 2000);
            defaultLevelMap.put("cpu", 2000);
            defaultLevelMap.put("thread", 2000);
            defaultLevelMap.put("class", 2000);
            inst.setProfilingLevelMap(defaultLevelMap);
        }

        CommunicationServer.sendProfilingPacket(inst);
    }

    /**
     *  Prints Received profiling DATA - class CPU
     * */
    public static void printCpuData(List<CPUmeasurement> cpuData){
        for(CPUmeasurement c: cpuData){
            System.out.println("Usage[%]: " + c.getCpuUsage() + ", Elapsed[ns]: " + c.getElapsedCpu() + "Time[ns]: " + c.getElapsedTime());
        }
    }

    /**
     *  Prints instruction
     * */
    public static void printInstruction(Instruction inst){

        //for(String s: inst.getProfilingLevelMap().keySet())
        //    System.out.print(s + ": " + inst.getProfilingLevelMap().get(s) + ", ");

        for(Map.Entry entry: inst.getProfiledMethodList().entrySet()){
            for(String s: (ArrayList<String>)entry.getValue()){
                System.out.println("Class: " + entry.getKey() + ", method: " + s);
            }
        }

        System.out.println();
    }

    /**
     *  Prints out method run list
     * */
    public static void printMethodRuns(Map<String, TimeMeasurement> methodRunList){

        for(TimeMeasurement t: methodRunList.values()){
            System.out.println(t.getMethodName() + ":");

            for(MethodRun m: t.methodRunList){
                System.out.print(m.getEstimatedTime()/1000000 + " ");
            }
        }
        System.out.println();
    }



}
