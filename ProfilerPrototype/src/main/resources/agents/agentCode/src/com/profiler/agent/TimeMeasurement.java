package com.profiler.agent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *  Small helping class
 *
 *  @author Erik Suta
 * */
public class TimeMeasurement implements Serializable {

    /* Static attributes */
    public static int runCounter = 0;

    /* Attributes */
    String methodName;
    MethodRun actMethodRun;
    public List<MethodRun> methodRunList = new ArrayList<MethodRun>();

    /**
     *  Constructor
     * */
    TimeMeasurement(){
        actMethodRun = new MethodRun();
    }


    public void closeMethodRun(long endTime){
        actMethodRun.finishMethodRun(endTime);
        methodRunList.add(runCounter, actMethodRun);
        runCounter++;
    }

    /**
     *  creates new method run
     * */
    public void createNewMethodRun(){
        actMethodRun = new MethodRun();
    }

    /**
     *  Getters and Setters
     * */
    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
