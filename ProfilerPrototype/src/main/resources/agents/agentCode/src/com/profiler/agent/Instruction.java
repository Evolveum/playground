package com.profiler.agent;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *  This class represents format for Instruction transmission between
 *  profiling server and profiling agent
 *
 *  @author Erik Suta
 * */
public class Instruction implements Serializable {

    /* Attributes */
    public static long serialVersionUID = 1L;
    private boolean isProfilingScenario;

    private Map<String, ArrayList<String>> profiledMethodList = new HashMap<String, ArrayList<String>>();
    private Map<String, Integer> profilingLevelMap = new HashMap<String, Integer>();

    /**
     *  Write current Instruction
     * */
    public static void writeInstruction(Instruction inst){

        ObjectOutputStream out;

        try{
            FileOutputStream instructionFileOut = new FileOutputStream(ProfilingPacketType.TEMP_FILE_PATH + "\\instr.prof");

            out = new ObjectOutputStream(instructionFileOut);
            out.writeObject(inst);

            out.close();
            instructionFileOut.close();

        }catch (FileNotFoundException fnfe){
            //TODO
            fnfe.printStackTrace();
        }catch (IOException ioe){
            //TODO
            ioe.printStackTrace();
        }
    }

    /**
     *  Read current instruction
     * */
    public static Instruction readInstruction(){
        ObjectInputStream in;
        Instruction instruction = null;

        try{
            FileInputStream instructionFileIn = new FileInputStream(ProfilingPacketType.TEMP_FILE_PATH + "\\instr.prof");

            in = new ObjectInputStream(instructionFileIn);
            instruction = (Instruction)in.readObject();

            in.close();
            instructionFileIn.close();

        }catch (FileNotFoundException fnfe){
            //TODO
            fnfe.printStackTrace();
        }catch (IOException ioe){
            //TODO
            ioe.printStackTrace();
        }catch (ClassNotFoundException cnfe){
            //TODO
            cnfe.printStackTrace();
        }
        //TODO - add finally block - close all streams

        return instruction;
    }

    /**
     *  Prints instruction
     * */
    public static void printInstruction(Instruction inst){

        for(String s: inst.getProfilingLevelMap().keySet())
            System.out.print(s + ": " + inst.getProfilingLevelMap().get(s) + ", ");

        System.out.println();
    }


    /* GETTERS AND SETTERS */
    public boolean isProfilingScenario() {
        return isProfilingScenario;
    }

    public void setProfilingScenario(boolean profilingScenario) {
        isProfilingScenario = profilingScenario;
    }

    public Map<String, ArrayList<String>> getProfiledMethodList() {
        return profiledMethodList;
    }

    public void setProfiledMethodList(Map<String, ArrayList<String>> profiledMethodList) {
        this.profiledMethodList = profiledMethodList;
    }

    public Map<String, Integer> getProfilingLevelMap() {
        return profilingLevelMap;
    }

    public void setProfilingLevelMap(Map<String, Integer> profilingLevelMap) {
        this.profilingLevelMap = profilingLevelMap;
    }
}
