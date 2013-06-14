package com.profiler.agent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  In this class, we perform class load profiling, that means we try to
 *  count all classes loaded in JVM once in time
 *
 *  @author Erik Suta
 * */
public class ClassMeasurement implements Serializable {

    /* Static Attributes */
     private static Class[] classField;

    /* Object attributes */
    private int loadedClasses;

    /**
     *  Constructor
     * */
    public ClassMeasurement(){
        classField = AgentMain.instrumentation.getAllLoadedClasses();
        loadedClasses = classField.length;
    }

    /* GETTERS AND SETTERS */

    public int getLoadedClasses() {
        return loadedClasses;
    }

    /**
     *  Prints Class Measurement
     * */
    public static void printClassMeasurement(ClassMeasurement clm){
        System.out.println("LOADED CLASSES = ["+clm.loadedClasses+"]");
    }
}
