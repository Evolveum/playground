package com.profiler.agent;

import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 *  TODO -ThreadInfo serialization and transport to server
 *
 *  In this class we perform Thread and CPU activity measurement
 *
 *  @author Erik Suta
 * */
public class ThreadMeasurement implements Serializable {

    /* Static attributes */
    public static int THREAD_TRACE_DEPTH = 10;
    private static ThreadInfo[] threadsInfo;

    /* Attributes */
    private int threadCount;
    private long[] threadIds;
    private String[] threadNames;

    /**
     *  Constructor
     * */
    public ThreadMeasurement(){
        threadsInfo = null;

        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        threadIds = threadBean.getAllThreadIds();
        threadsInfo = threadBean.getThreadInfo(threadIds, THREAD_TRACE_DEPTH);
        threadCount = threadIds.length;

        threadNames = new String[threadCount];
        for(int i = 0; i < threadCount; i++){
            if(threadsInfo[i] != null)
                threadNames[i] = threadsInfo[i].getThreadName();
        }
    }   //Constructor end


    /* GETTERS AND SETTERS */
    public int getThreadCount() {
        return threadCount;
    }

    public long[] getThreadIds() {
        return threadIds;
    }

    public String[] getThreadNames() {
        return threadNames;
    }

    /**
     *  Prints Current thread state
     * */
    public static void printThreadState(ThreadMeasurement tcm){
        System.out.println("THREAD_INFO:\nThreadCount["+tcm.threadCount+"]");
        for(int i = 0; i < tcm.threadCount; i++)
            System.out.println("Thread["+tcm.threadIds[i]+"] = " + tcm.threadNames[i]);

    }   //printThreadState
}
