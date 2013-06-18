package com.profiler.agent;

import java.util.Arrays;

/**
 *
 *  This class is a thread, that performs memory, thread and class monitoring once upon a time and sends these data
 *  to profiling server
 *
 *  @author Erik Suta
 * */
public class ProfilingThread implements Runnable{

    /* STATIC ATTRIBUTES */
    public static boolean methodProfiling = false;
    public static boolean memoryProfiling = false;
    public static boolean cpuProfiling = false;
    public static boolean threadProfiling = false;
    public static boolean classProfiling = false;

    public static int MEMORY_PROFILING_INTERVAL = 2000;
    public static int CPU_PROFILING_INTERVAL = 2000;
    public static int THREAD_PROFILING_INTERVAL = 2000;
    public static int CLASS_PROFILING_INTERVAL = 2000;

    public static int MINIMUM_INTERVAL;
    public static int MAX_VALUE;
    public static long counter = 0;

    /* Attributes */
    Thread profilingThread;

    /**
     *  Constructor
     * */
    public ProfilingThread(){
        profilingThread = new Thread(this, "profThread");
        profilingThread.start();
        System.out.println("Client: Profiling thread: " + profilingThread.getId() + " has been created.");
    }

    /**
     *  Run method of this Thread
     * */
    @Override
    public void run(){

        getMinimumInterval();

        while (true){

            //System.out.println("PROFILING THREAD ROUND: " + counter);

            if(memoryProfiling)
                if(counter >= MEMORY_PROFILING_INTERVAL){
                    Instrumentations.getMemoryUsage();
                    //System.out.println("PROFILING MEMORY!");
                }
            if(threadProfiling)
                if(counter >= THREAD_PROFILING_INTERVAL){
                    Instrumentations.getThreadInfo();
                    //System.out.println("PROFILING THREAD!");
                }
            if(cpuProfiling)
                if(counter >= CPU_PROFILING_INTERVAL){
                    Instrumentations.getCpuUsage();
                    //System.out.println("PROFILING CPU!");
                }
            if (classProfiling)
                if(counter >= CLASS_PROFILING_INTERVAL){
                    Instrumentations.getClassUsage();
                    //System.out.println("PROFILING CLASS!");
                }

            counter += MINIMUM_INTERVAL;
            if(counter >= 10*MAX_VALUE)
                counter = 0;

            try{
                Thread.sleep(MINIMUM_INTERVAL);
            }catch (InterruptedException ite){
                ite.printStackTrace();
            }
        }
    }   //run() end

    /**
     *  Get minimum interval
     * */
    public static void getMinimumInterval(){
        int[] helpArray = new int[4];
        helpArray[0] = MEMORY_PROFILING_INTERVAL;
        helpArray[1] = THREAD_PROFILING_INTERVAL;
        helpArray[2] = CPU_PROFILING_INTERVAL;
        helpArray[3] = CLASS_PROFILING_INTERVAL;

        Arrays.sort(helpArray);

        MINIMUM_INTERVAL = helpArray[0];
        MAX_VALUE = helpArray[3];
    }

}
