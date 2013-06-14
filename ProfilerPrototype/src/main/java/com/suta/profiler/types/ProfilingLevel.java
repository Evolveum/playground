package com.suta.profiler.types;

import com.suta.profiler.Attributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  This class represents Profiling Level functionality. Profiling levels in context of this
 *  applications are objects, using whose we monitor profiling aspects and provide user with functionality
 *  to choose, which aspects of profiling will be used and analysed
 *
 *  @author Erik Suta
 * */
public class ProfilingLevel extends ObjectType{

    /* Class Attributes */
    public static List<ProfilingLevel> profilingLevelList = new ArrayList<ProfilingLevel>();

    /* Object attributes */
    private String name;
    private String description;
    private boolean memoryProfiling = false;
    private boolean cpuProfiling = false;
    private boolean threadProfiling = false;
    private boolean classProfiling = false;
    private boolean methodProfiling = false;
    private Map<String, Integer> levelMap = new HashMap<String, Integer>();

    private int cpuInterval;
    private int memoryInterval;
    private int threadInterval;
    private int classInterval;
    private int traceDepth;

    /* Class methods */
    public static List<String> retrieveProfilingLevelNamesList(){
        List<String> profilingLevelsNames = new ArrayList<String>();

        for(ProfilingLevel pl: profilingLevelList)
            profilingLevelsNames.add(pl.getName());

        profilingLevelsNames.add("none");

        return profilingLevelsNames;
    }

    /**
     *  Constructs profiling level instruction string sent as instruction packet to profiling agent
     * */
    public void constructLevelInstruction(){

        if(memoryProfiling)
            levelMap.put("memory", memoryInterval);
        if(cpuProfiling)
            levelMap.put("cpu", cpuInterval);
        if(threadProfiling)
            levelMap.put("thread", threadInterval);
        if(classProfiling)
            levelMap.put("class", classInterval);
        if(methodProfiling)
            levelMap.put("method", 0);

    }

    /**
     *  Saves object to hard drive
     * */
    public static void saveObject(ProfilingLevel level){
        serializeObject(level, Attributes.PROFILING_LEVEL_FILE_PATH, level.getName());
    }

    /**
     *  Delete selected profiling scenario
     * */
    public void deleteLevel(ProfilingLevel level){
        deleteObject(Attributes.PROFILING_LEVEL_FILE_PATH, level.getName());
    }

    /**
     *  Reads all profiling levels from hard drive
     * */
    public static List<ProfilingLevel> retrieveProfilingLevels(){
        List<ObjectType> objectList = getAllObjects(Attributes.PROFILING_LEVEL_FILE_PATH);
        List<ProfilingLevel> profilingLevelList  = new ArrayList<ProfilingLevel>();

        for(ObjectType o: objectList)
            profilingLevelList.add((ProfilingLevel)o);

        System.out.println("Profiling Levels: " + profilingLevelList.size());
        return profilingLevelList;
    }

    /**
     *  Creates default Profiling Level
     * */
    public static ProfilingLevel createDefaultProfilingLevel(){
        ProfilingLevel level = new ProfilingLevel();
        level.setClassProfiling(true);
        level.setClassInterval(2000);
        level.setMemoryProfiling(true);
        level.setMemoryInterval(2000);
        level.setCpuProfiling(true);
        level.setCpuInterval(2000);
        level.setThreadProfiling(true);
        level.setThreadInterval(2000);
        level.setTraceDepth(10);
        level.setMethodProfiling(false);
        level.setDescription("Default Profiling Level");

        Map<String, Integer> defaultLevelMap = new HashMap<String, Integer>();
        defaultLevelMap.put("memory", 2000);
        defaultLevelMap.put("cpu", 2000);
        defaultLevelMap.put("thread", 2000);
        defaultLevelMap.put("class", 2000);

        level.setLevelMap(defaultLevelMap);

        level.setName("DEFAULT PROFILING LEVEL");

        return level;
    }

    /**
     *  Finds ProfilingLevel based on its name
     * */
    public static ProfilingLevel findLevelByName(String name){

        for(ProfilingLevel level: profilingLevelList){
            if(level.getName().equals(name))
                return level;
        }

        return null;
    }

    /* Getters and Setters */
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

    public boolean isMemoryProfiling() {
        return memoryProfiling;
    }

    public void setMemoryProfiling(boolean memoryProfiling) {
        this.memoryProfiling = memoryProfiling;
    }

    public boolean isCpuProfiling() {
        return cpuProfiling;
    }

    public void setCpuProfiling(boolean cpuProfiling) {
        this.cpuProfiling = cpuProfiling;
    }

    public boolean isThreadProfiling() {
        return threadProfiling;
    }

    public void setThreadProfiling(boolean threadProfiling) {
        this.threadProfiling = threadProfiling;
    }

    public boolean isClassProfiling() {
        return classProfiling;
    }

    public void setClassProfiling(boolean classProfiling) {
        this.classProfiling = classProfiling;
    }

    public boolean isMethodProfiling() {
        return methodProfiling;
    }

    public void setMethodProfiling(boolean methodProfiling) {
        this.methodProfiling = methodProfiling;
    }

    public int getCpuInterval() {
        return cpuInterval;
    }

    public void setCpuInterval(int cpuInterval) {
        this.cpuInterval = cpuInterval;
    }

    public int getMemoryInterval() {
        return memoryInterval;
    }

    public void setMemoryInterval(int memoryInterval) {
        this.memoryInterval = memoryInterval;
    }

    public int getThreadInterval() {
        return threadInterval;
    }

    public void setThreadInterval(int threadInterval) {
        this.threadInterval = threadInterval;
    }

    public int getClassInterval() {
        return classInterval;
    }

    public void setClassInterval(int classInterval) {
        this.classInterval = classInterval;
    }

    public int getTraceDepth() {
        return traceDepth;
    }

    public void setTraceDepth(int traceDepth) {
        this.traceDepth = traceDepth;
    }

    public Map<String, Integer> getLevelMap() {
        return levelMap;
    }

    public void setLevelMap(Map<String, Integer> levelMap) {
        this.levelMap = levelMap;
    }
}
