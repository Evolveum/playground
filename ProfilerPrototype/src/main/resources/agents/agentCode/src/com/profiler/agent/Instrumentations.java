package com.profiler.agent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  This class provides functionality needed to instrument target compiled code with profiling code.
 *  We profile all aspects of performance of java applications.
 *
 *  @author Erik Suta
 * */
public class Instrumentations {

    /* Attributes */
    public static Map<String, ArrayList<String>> profiledMethodMap = new HashMap<String, ArrayList<String>>();

    /* Profiling attributes */
    public static Map<String, TimeMeasurement> times = new HashMap<String, TimeMeasurement>();
    public static List<MemoryMeasurement> memoryUsageList = new ArrayList<MemoryMeasurement>();
    public static List<ThreadMeasurement> threadList = new ArrayList<ThreadMeasurement>();
    public static List<CPUmeasurement> cpuUsageList = new ArrayList<CPUmeasurement>();
    public static List<ClassMeasurement> classUsageList = new ArrayList<ClassMeasurement>();

    /**
     *  Inserts stopwatch before method body
     * */
    public static void insertStopwatchBefore(String methodName){
        if(!times.containsKey(methodName)){
            //System.out.println("Measuring method: " + methodName);
            TimeMeasurement timeMeasurementUnit = new TimeMeasurement();
            timeMeasurementUnit.methodName = methodName;
            times.put(methodName, timeMeasurementUnit);
        }else{
            times.get(methodName).createNewMethodRun();
        }
        //System.out.println(times.size());
    }

    /**
     *  Stop stopwatch
     * */
    public static void insertStopwatchAfter(String methodName){
        if(times.containsKey(methodName)){
            times.get(methodName).closeMethodRun(System.nanoTime());
            System.out.println("Method name: " + methodName + " ,total: " + times.get(methodName).actMethodRun.estimatedTime + ", startTime: " + times.get(methodName).actMethodRun.startTime + ", endTime: " + times.get(methodName).actMethodRun.endTime);
            //System.out.println("MethodRunListSize: " + times.get(methodName).methodRunList.size());
        }
    }

    /**
     *  Create profiling thread
     * */
    public static void createProfilingThread(){
        new ProfilingThread();
    }

    /**
     *  Collects information about current memory usage of java application
     * */
    public static void getMemoryUsage(){
        MemoryMeasurement actMemoryStatus = new MemoryMeasurement();
        //MemoryMeasurement.printMemoryUsage(actMemoryStatus);
        memoryUsageList.add(actMemoryStatus);
    }

    /**
     *  Get current Thread Information
     * */
    public static void getThreadInfo(){
        ThreadMeasurement currentThreadState = new ThreadMeasurement();
        threadList.add(currentThreadState);
        //ThreadMeasurement.printThreadState(currentThreadState);
    }

    /**
     *  Get current CPU usage information
     * */
    public static void getCpuUsage(){
        CPUmeasurement currentCpuUsage = new CPUmeasurement();
        cpuUsageList.add(currentCpuUsage);
        //CPUmeasurement.printCpuUsage(currentCpuUsage);
    }

    /**
     *  Get current class load state
     * */
    public static void getClassUsage(){
        ClassMeasurement classMeasurement = new ClassMeasurement();
        classUsageList.add(classMeasurement);
        //ClassMeasurement.printClassMeasurement(classMeasurement);
    }

    /**
     *  Test, if method is profiled
     * */
    public static boolean isMethodProfiled(String className, String methodName){

        System.out.println("Class: " + className + ",Method: " + methodName);

        for (String clazz: profiledMethodMap.keySet()){
            if(clazz.equals(className)){
                for(String method: profiledMethodMap.get(clazz)){
                    if(methodName.equals(method))
                        return true;
                }
            }
        }
        return false;
    }

    /**
     *  Stupid empty test method
     * */
    public static void dummyTest(){}

}
