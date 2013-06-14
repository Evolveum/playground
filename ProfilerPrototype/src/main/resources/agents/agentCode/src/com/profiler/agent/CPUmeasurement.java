package com.profiler.agent;

import com.sun.management.OperatingSystemMXBean;
import sun.management.ManagementFactory;

import java.io.Serializable;
import java.lang.management.RuntimeMXBean;


/**
 *  In this class, we measure total JVM CPU usage and time
 *
 *  @author Erik Suta
 *
 * */
public class CPUmeasurement implements Serializable {

    /* Attributes */
    private double cpuUsage;
    private long elapsedCpu;
    private long elapsedTime;


    /**
     *  Constructor
     * */
    public CPUmeasurement(){
        OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

        int avaibleProcessors = operatingSystemMXBean.getAvailableProcessors();

        long prevUpTime = runtimeMXBean.getUptime();
        long prevProcessCpuTime = operatingSystemMXBean.getProcessCpuTime();

        try{
            Thread.sleep(20);
        }catch (InterruptedException ite){
            //ignored
        }
        operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long upTime = runtimeMXBean.getUptime();
        long processCpuTime = operatingSystemMXBean.getProcessCpuTime();
        elapsedCpu = processCpuTime - prevProcessCpuTime;
        elapsedTime = upTime - prevUpTime;
        cpuUsage = Math.min(99F, elapsedCpu/(elapsedTime*10000F*avaibleProcessors));
    }   //Constructor end

    /* GETTERS AND SETTERS */
    public double getCpuUsage() {
        return cpuUsage;
    }

    public long getElapsedCpu() {
        return elapsedCpu;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    /**
     *  Print info about CPU Usage
     * */
    public static void printCpuUsage(CPUmeasurement cpum){
        System.out.println("CPU USAGE: ["+cpum.cpuUsage+"], elapsedCpu["+cpum.elapsedCpu+"], elapsedTime["+cpum.elapsedTime+"].");
    }
}
