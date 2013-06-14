package com.profiler.agent;

import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

/**
 *  //TODO - add monitoring of Garbage Collection activity
 *  //TODO - add non-heap memory monitoring
 *
 *
 *  @author Erik Suta
 * */
public class MemoryMeasurement implements Serializable {

    static int MB = 1024*1024;
    static int KB = 1024;

    /* Attributes */
    long usedMemory;
    long freeMemory;
    long totalMemory;
    long maxMemory;

    int objectPendingFinalization;

    long nonHeapCommitted;
    long nonHeapInit;
    long nonHeapMax;
    long nonHeapUsed;

    /**
     *  Constructor
     * */
    public MemoryMeasurement(){
        Runtime runtime = Runtime.getRuntime();
        this.freeMemory = runtime.freeMemory();
        this.totalMemory = runtime.totalMemory();
        this.maxMemory = runtime.maxMemory();
        calculateUsedMemory();

        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage memoryUsage = memoryMXBean.getNonHeapMemoryUsage();

        objectPendingFinalization = memoryMXBean.getObjectPendingFinalizationCount();
        nonHeapCommitted = memoryUsage.getCommitted();
        nonHeapInit = memoryUsage.getInit();
        nonHeapMax = memoryUsage.getInit();
        nonHeapUsed = memoryUsage.getUsed();
    }

    /**
     *  Calculates Used Memory
     * */
    public void calculateUsedMemory(){
        this.usedMemory = this.totalMemory - this.freeMemory;
    }

    /**
     *  Prints memory Usage
     * */
    public static void printMemoryUsage(MemoryMeasurement unit){
        //System.out.println("MEMORY STATUS[B]: free["+unit.freeMemory+"], user["+unit.usedMemory+"], max["+unit.maxMemory+"], total["+unit.totalMemory+"]");
        System.out.println("HEAP MEMORY STATUS[KB]: free["+unit.freeMemory/KB+"], user["+unit.usedMemory/KB+"], max["+unit.maxMemory/KB+"], total["+unit.totalMemory/KB+"]");
        //System.out.println("MEMORY STATUS[MB]: free["+unit.freeMemory/MB+"], user["+unit.usedMemory/MB+"], max["+unit.maxMemory/MB+"], total["+unit.totalMemory/MB+"]");
        System.out.println("NON-HEAP MEMORY STATUS[KB]: committed["+unit.nonHeapCommitted/KB+"], init["+unit.nonHeapInit/KB+"], max["+unit.nonHeapMax/KB+"], used["+unit.nonHeapUsed/KB+"]");
    }

    /* Getters and Setters */

    public long getUsedMemory() {
        return usedMemory;
    }

    public long getFreeMemory() {
        return freeMemory;
    }

    public long getTotalMemory() {
        return totalMemory;
    }

    public long getMaxMemory() {
        return maxMemory;
    }

    public int getObjectPendingFinalization() {
        return objectPendingFinalization;
    }

    public long getNonHeapCommitted() {
        return nonHeapCommitted;
    }

    public long getNonHeapInit() {
        return nonHeapInit;
    }

    public long getNonHeapMax() {
        return nonHeapMax;
    }

    public long getNonHeapUsed() {
        return nonHeapUsed;
    }
}
