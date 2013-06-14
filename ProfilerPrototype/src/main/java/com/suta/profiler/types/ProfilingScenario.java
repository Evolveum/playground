package com.suta.profiler.types;

import com.suta.profiler.Attributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  This class representes profiling scenario object
 *
 *  @author Erik Suta
 * */
public class ProfilingScenario extends ObjectType{

    /* Attributes */
    private String name;
    private String description;
    private ProjectType projectType;

    public Map<String, ArrayList<String>> methodList = new HashMap<String, ArrayList<String>>();

    /**
     *  Saves object to hard drive
     * */
    public static void saveObject(ProfilingScenario profilingScenario){
        serializeObject(profilingScenario, Attributes.PROFILING_SCENARIO_FILE_PATH, profilingScenario.getName());
    }

    /**
     *  Delete selected profiling scenario
     * */
    public void deleteScenario(ProfilingScenario scenario){
        deleteObject(Attributes.PROFILING_SCENARIO_FILE_PATH, scenario.getName());
    }

    /**
     *  Reads all profiling scenarios from hard drive
     * */
    public static List<ProfilingScenario> retrieveProfilingScenarios(){
        List<ObjectType> objectList = getAllObjects(Attributes.PROFILING_SCENARIO_FILE_PATH);
        List<ProfilingScenario> profilingScenarioList  = new ArrayList<ProfilingScenario>();

        for(ObjectType o: objectList)
            profilingScenarioList.add((ProfilingScenario)o);

        return profilingScenarioList;
    }

    /**
     *  Prints actual methodList
     * */
    public void printMethodList(){
        System.out.println("Selected methods: ");
        for(Map.Entry entry: methodList.entrySet()){
            for(String methodName: (ArrayList<String>)entry.getValue()){
                System.out.println("Class: " + entry.getKey() + ", method: " + methodName);
            }
        }
    }

    /**
     *  Getters and Setters
     * */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, ArrayList<String>> getMethodList() {
        return methodList;
    }

    public void setMethodList(Map<String, ArrayList<String>> methodList) {
        this.methodList = methodList;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }
}
