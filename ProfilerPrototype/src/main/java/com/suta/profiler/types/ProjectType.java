package com.suta.profiler.types;

import com.suta.profiler.Attributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 *  @author Erik Suta
 * */
public class ProjectType extends ObjectType{

    /* Attributes */
    public Map<String, ArrayList<String>> methodMultiMap = new HashMap<String, ArrayList<String>>();

    private String name;
    private String description = "";
    private String jarPath = "";
    private String programName;
    private boolean attachOnStart;
    private int pid;

    private ProfilingLevel selectedProfilingLevel = null;
    private ProfilingScenario selectedProfilingScenario = null;
    public List<ProfilingScenario> profilingScenarioList = new ArrayList<ProfilingScenario>();

    /**
     *  Saves profiling project
     * */
    public static void saveObject(ProjectType project){
        String[] programNameField = project.getJarPath().split("\\\\");
        String programName = programNameField[programNameField.length-1];
        project.setProgramName(programName.substring(0,programName.length()-4));

        serializeObject(project, Attributes.PROJECT_FILE_PATH, project.getName());
    }

    /**
     *  Delete selected project
     * */
    public void deleteProject(ProjectType project){
        deleteObject(Attributes.PROJECT_FILE_PATH, project.getName());
    }

    /**
     *  Reads all profiling projects from hard drive
     * */
    public static List<ProjectType> retrieveProfilingProjects(){
        List<ObjectType> objectList = getAllObjects(Attributes.PROJECT_FILE_PATH);
        List<ProjectType> projectList  = new ArrayList<ProjectType>();

        for(ObjectType o: objectList)
            projectList.add((ProjectType)o);

        return projectList;
    }

    /**
     *  Creates ArrayList containing all class names stored in HashMap
     * */
    public ArrayList<String> getClassNames(){
        ArrayList<String> helpList = new ArrayList<String>();

        for(Map.Entry<String, ArrayList<String>> entry: methodMultiMap.entrySet()){
            helpList.add(entry.getKey());
        }

        return helpList;
    }

    /**
     *  Retrieves list of all Project's Profiling Scenarios, specifically list containing ist names
     * */
    public ArrayList<String> getProfilingScenariosNames(){
        ArrayList<String> helpList = new ArrayList<String>();
        helpList.add(0, "none");

        for(ProfilingScenario profilingScenario: profilingScenarioList)
            helpList.add(profilingScenario.getName());

        return helpList;
    }

    /**
     *  Retrieves actually selected profilingScenario
     * */
    public String getSelectedProfilingScenarioName(){
        if(selectedProfilingScenario == null)
            return "none";
        else
            return selectedProfilingScenario.getName();
    }

    /**
     *  Retrieves actually selected profilingLevel name
     * */
    public String getSelectedProfilingLevelName(){
        if(selectedProfilingLevel == null)
            return "none";
        else
            return selectedProfilingLevel.getName();
    }

    /**
     *  Finds ProfilingScenario by provide name
     * */
    public ProfilingScenario findScenarioByName(String name){

        if(!profilingScenarioList.isEmpty())
            for(ProfilingScenario scenario: profilingScenarioList){
                if(scenario.getName().equals(name))
                    return scenario;
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

    public String getJarPath() {
        return jarPath;
    }

    public void setJarPath(String jarPath) {
        this.jarPath = jarPath;
    }

    public boolean isAttachOnStart() {
        return attachOnStart;
    }

    public void setAttachOnStart(boolean attachOnStart) {
        this.attachOnStart = attachOnStart;
    }

    public Map<String, ArrayList<String>> getMethodMultiMap() {
        return methodMultiMap;
    }

    public void setMethodMultiMap(Map<String, ArrayList<String>> methodMultiMap) {
        methodMultiMap = methodMultiMap;
    }

    public ProfilingScenario getSelectedProfilingScenario() {
        return selectedProfilingScenario;
    }

    public void setSelectedProfilingScenario(ProfilingScenario selectedProfilingScenario) {
        this.selectedProfilingScenario = selectedProfilingScenario;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public ProfilingLevel getSelectedProfilingLevel() {
        return selectedProfilingLevel;
    }

    public void setSelectedProfilingLevel(ProfilingLevel selectedProfilingLevel) {
        this.selectedProfilingLevel = selectedProfilingLevel;
    }
}
