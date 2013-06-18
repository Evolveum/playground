package com.profiler.agent;


import java.io.Serializable;

/**
 *  @author Erik Suta
 *
 * */
public class MethodRun implements Serializable {

    /* Attributes */
    long startTime;
    long endTime;
    long estimatedTime;
    //int run;

    /**
     *  Constructor
     * */
    public MethodRun(){
        this.startTime = System.nanoTime();
        //this.run = TimeMeasurement.runCounter;
    }

    /**
     *  Finish methodRun
     * */
    public void finishMethodRun(long endTime){
        this.endTime = endTime;
        calculateEstimatedTime();
    }

    /**
     *  Calculate estimatedTime
     * */
    public void calculateEstimatedTime(){
        this.estimatedTime = this.endTime - this.startTime;
    }

    /* GETTERS AND SETTERS */
    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getEstimatedTime() {
        return estimatedTime;
    }

}   //MethodRun class end