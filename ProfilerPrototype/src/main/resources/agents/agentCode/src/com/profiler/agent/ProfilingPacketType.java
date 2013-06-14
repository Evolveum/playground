package com.profiler.agent;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  This class is a representation of typical Profiling object, the exact same
 *  copy of this class is also in Profiling agent.
 *
 *  This object is simple wrapper for all profiling data and also for
 *  configuration messages.
 *
 *  @author Erik Suta
 * */
public class ProfilingPacketType implements Serializable {

    /* Attributes */
    public static String COMMON_FILE_PATH_ABSOLUTE = "C:\\Profiler";
    public static String TEMP_FILE_PATH = COMMON_FILE_PATH_ABSOLUTE + "\\temp\\";
    public static long serialVersionUID = 45487654154564L;

    private String type;

    public static Map<String, TimeMeasurement> methodTimeList = new HashMap<String, TimeMeasurement>();
    public static List<MemoryMeasurement> memoryUsageList = new ArrayList<MemoryMeasurement>();
    public static List<ThreadMeasurement> threadList = new ArrayList<ThreadMeasurement>();
    public static List<CPUmeasurement> cpuUsageList = new ArrayList<CPUmeasurement>();
    public static List<ClassMeasurement> classUsageList = new ArrayList<ClassMeasurement>();

    /**
     *  Constructor
     * */
    public ProfilingPacketType(){

        Instrumentations.times.clear();
        methodTimeList.clear();
        memoryUsageList.clear();
        threadList.clear();
        cpuUsageList.clear();
        classUsageList.clear();

        methodTimeList.putAll(Instrumentations.times);
        memoryUsageList.addAll(Instrumentations.memoryUsageList);
        threadList.addAll(Instrumentations.threadList);
        cpuUsageList.addAll(Instrumentations.cpuUsageList);
        classUsageList.addAll(Instrumentations.classUsageList);

        Instrumentations.times.clear();
        Instrumentations.memoryUsageList.clear();
        Instrumentations.threadList.clear();
        Instrumentations.cpuUsageList.clear();
        Instrumentations.classUsageList.clear();
    }

    /**
     *  Serializes ProfilingPacket
     * */
    public static void serializePacket(ProfilingPacketType packet){

        ObjectOutputStream out = null;

        try{
            //File file = new File(TEMP_FILE_PATH + "packet.pct");
            System.out.println("SERIALIZING STUFF!");
            FileOutputStream memoryFileOut = new FileOutputStream(TEMP_FILE_PATH + "\\memory.prof");
            FileOutputStream cpuFileOut = new FileOutputStream(TEMP_FILE_PATH + "\\cpu.prof");
            FileOutputStream threadFileOut = new FileOutputStream(TEMP_FILE_PATH + "\\thread.prof");
            FileOutputStream classFileOut = new FileOutputStream(TEMP_FILE_PATH + "\\class.prof");

            out = new ObjectOutputStream(memoryFileOut);
            out.writeObject(memoryUsageList);

            out = new ObjectOutputStream(cpuFileOut);
            out.writeObject(cpuUsageList);

            out = new ObjectOutputStream(threadFileOut);
            out.writeObject(threadList);

            out = new ObjectOutputStream(classFileOut);
            out.writeObject(classUsageList);

            out.close();
            memoryFileOut.close();
            cpuFileOut.close();
            threadFileOut.close();
            classFileOut.close();

        }catch (FileNotFoundException fnfe){
            //TODO
            fnfe.printStackTrace();
        }catch (IOException ioe){
            //TODO
            ioe.printStackTrace();
        }

    }

    /**
     *  Deserialize ProfilingPacket
     * */
    public static void deserializePacket(){
        ObjectInputStream in;

        try{

            FileInputStream memoryFileIn = new FileInputStream(TEMP_FILE_PATH + "\\memory.prof");
            FileInputStream cpuFileIn = new FileInputStream(TEMP_FILE_PATH + "\\cpu.prof");
            FileInputStream threadFileIn = new FileInputStream(TEMP_FILE_PATH + "\\thread.prof");
            FileInputStream classFileIn = new FileInputStream(TEMP_FILE_PATH + "\\class.prof");

            in = new ObjectInputStream(memoryFileIn);
            memoryUsageList = (ArrayList<MemoryMeasurement>)in.readObject();

            in = new ObjectInputStream(cpuFileIn);
            cpuUsageList = (ArrayList<CPUmeasurement>)in.readObject();

            in = new ObjectInputStream(threadFileIn);
            threadList = (ArrayList<ThreadMeasurement>)in.readObject();

            in = new ObjectInputStream(classFileIn);
            classUsageList = (ArrayList<ClassMeasurement>)in.readObject();

            in.close();
            memoryFileIn.close();
            cpuFileIn.close();
            threadFileIn.close();
            classFileIn.close();

        }catch (FileNotFoundException fnfe){
            //TODO
            fnfe.printStackTrace();
        }catch (IOException ioe){
            //TODO
            ioe.printStackTrace();
        }catch (ClassNotFoundException cnfe){
            //TODO
            cnfe.printStackTrace();
        }
        //TODO - add finally block - close all streams
    }

    /* GETTERS AND SETTERS */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}



