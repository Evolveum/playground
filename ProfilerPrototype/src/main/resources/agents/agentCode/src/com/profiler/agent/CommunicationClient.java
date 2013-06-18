package com.profiler.agent;

//import java.io.*;
//import java.net.Socket;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *  This class is agent implementation of communication socket based client. This class contains
 *  all methods and functionality needed to receive information from server (Profiler application) and
 *  to send all collected information from profiling java application
 *
 *  @author Erik Suta
 * */
public class CommunicationClient {

    /* Attributes */
    public static boolean TRANSMISSION_END = false;
    public static Integer PACKET_SEND_INTERVAL = 3000;
    public static boolean receivedInstructions = false;

    public static Integer PORT = 22558;
    public static java.net.Socket socket;
    public static java.io.ObjectInputStream clientObjectInputStream;
    public static java.io.ObjectOutputStream clientObjectOutputStream;

    /**
     *  create new communication thread and perform startup initialization
     * */
    public static void initCommunicationClientThread(){
        new CommunicationClientThread();
    }

    /**
     *  This method performs initialization of socket client
     * */
    public static void initSocketClient(){

        try{
            //connectToProfilingServer();
            //setupClientStreams();
            handleData();
        }catch (EOFException eofe){
            eofe.printStackTrace();
            //TODO - send error message to server, we won't handle it here
        }catch (java.io.IOException ioe){
            ioe.printStackTrace();
            //TODO - send error message to server, we won't handle it here
        }catch (ClassNotFoundException ccne){
            ccne.printStackTrace();
            //TODO - send error message to server, we won't handle it here
        }finally {
            //closeSocketClient();
        }
    }

    /**
     *  Close all communication streams
     * */
    public static void closeSocketClient(){

        try{
            clientObjectInputStream.close();
            clientObjectOutputStream.close();
            socket.close();

            System.out.println("Client: Socket and all streams were closed successfully!");

        }catch (java.io.IOException ioe){
            ioe.printStackTrace();
            //TODO - send error message to server, we won't handle it here
        }
    }

    /**
     *  Stupid empty test method
     * */
    public static void dummyTest(){}

    /**
     *  Performs attempt to connect to profiling server
     * */
    public static void connectToProfilingServer() throws IOException {
        socket = new Socket(InetAddress.getLocalHost(), PORT);
        System.out.println("Client: now connected to server with address: " + socket.getInetAddress());
    }

    /**
     *  Setup all necessary streams
     * */
    public static void setupClientStreams() throws IOException{
        clientObjectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        clientObjectOutputStream.flush();
        clientObjectInputStream = new ObjectInputStream(socket.getInputStream());
        System.out.println("Client: streams are now configured!");
        //sendProfilingPacket();
    }

    /**
     *  Handles all data
     * */
    private static void handleData() throws ClassNotFoundException, EOFException, IOException {

        do{
            System.out.println("CLIENT - HANDLING DATA!");

            if(!receivedInstructions)
                receiveProfilingPacket();

            sendProfilingPacket();

            try{
                Thread.sleep(PACKET_SEND_INTERVAL);
            }catch (InterruptedException ite){
                //TODO
                ite.printStackTrace();
            }

        }while (!TRANSMISSION_END);
    }   //handleData end

    /**
     *  Attempt to receive ProfilingPacketType from server
     * */
    private static void receiveProfilingPacket() throws ClassNotFoundException, IOException{

        String message = (String)clientObjectInputStream.readObject();

        if(message.equals("INST")){
            receivedInstructions = true;
            Instruction inst = Instruction.readInstruction();
            //Instruction.printInstruction(inst);
            getProfilingLevelSettings(inst);
            Instrumentations.profiledMethodMap = inst.getProfiledMethodList();

            printProfilingMethodList();
            ProfilingThread.methodProfiling = true;
            AgentMain.modifyClasses();
        }


        System.out.println("Client - received packet from server: " + message);
    }

    /**
     *  //TODO - repair the bug with levelMap, may cause some trouble
     *  Get profilingLevelSettings
     * */
    public static void getProfilingLevelSettings(Instruction inst){
        Map<String, Integer> levelMap = inst.getProfilingLevelMap();
        Instruction.printInstruction(inst);

        for(String s: levelMap.keySet()){
            if(s.equals("method")){
                ProfilingThread.methodProfiling = true;
            }
            if(s.endsWith("memory") && levelMap.get(s) != 0){
                ProfilingThread.memoryProfiling = true;
                ProfilingThread.MEMORY_PROFILING_INTERVAL = levelMap.get(s);
            }
            if(s.endsWith("cpu")  && levelMap.get(s) != 0){
                ProfilingThread.cpuProfiling = true;
                ProfilingThread.CPU_PROFILING_INTERVAL = levelMap.get(s);
            }
            if(s.endsWith("thread")  && levelMap.get(s) != 0){
                ProfilingThread.threadProfiling = true;
                ProfilingThread.THREAD_PROFILING_INTERVAL = levelMap.get(s);
            }
            if(s.endsWith("class")  && levelMap.get(s) != 0){
                ProfilingThread.classProfiling = true;
                ProfilingThread.CLASS_PROFILING_INTERVAL = levelMap.get(s);
            }
        }

        System.out.println("Meth: " + ProfilingThread.methodProfiling + ", MEM: " + ProfilingThread.memoryProfiling + ", CPU: " + ProfilingThread.cpuProfiling + ", CLASS: " + ProfilingThread.classProfiling + ", THREAD: " + ProfilingThread.threadProfiling);

    }

    /**
     *  Attempt to send profilingPacket, then sleep profiling thread for next communication iteration
     * */
    private static void sendProfilingPacket() throws IOException{
        ProfilingPacketType profilingPacket = new ProfilingPacketType();
        ProfilingPacketType.serializePacket(profilingPacket);

        System.out.println("Client - sending datagram!");
        //printSendProfilingPacket(profilingPacket);
        clientObjectOutputStream.writeObject(new String("DATA"));
        //clientObjectOutputStream.flush();

        try{
            Thread.sleep(PACKET_SEND_INTERVAL);
        }catch (InterruptedException interE){
            interE.printStackTrace();
            //TODO - log error etc.
        }
    }   //sendProfilingPacket end

    /**
     *  This method server simple purpose - it sends ProfilingPacketType Object in special situations,
     *  like program end etc.
     * */
    private static void sendSpecialPacket(ProfilingPacketType packet){

        try{
            clientObjectOutputStream.writeObject(packet);
            clientObjectOutputStream.flush();
        }catch (IOException ioe){
            ioe.printStackTrace();
            //TODO - log and stuff
        }
    }   //sendSpecialPacket end

    /**
     *  Sends terminating packet to Profiling server, so it knows, that it can close current connection
     * */
    public static void sendTerminationPacket(){
        ProfilingPacketType packet = new ProfilingPacketType();
        //sendSpecialPacket(packet);
    }

    /**
     *  Print profiling method list
     * */
    public static void printProfilingMethodList(){
        for(Map.Entry entry: Instrumentations.profiledMethodMap.entrySet()){
            for(String s: (ArrayList<String>)entry.getValue()){
                System.out.println("Class: " + entry.getKey() + ", method: " + s);
            }
        }
    }

    /**
     *  Prints profiling packet which is about to sent
     * */
    /*public static void printSendProfilingPacket(ProfilingPacketType packet){
        for(Map.Entry entry: packet.methodTimeList.entrySet()){
            for(TimeMeasurement t: (ArrayList<TimeMeasurement>)entry.getValue()){
                long estimatedTime = t.endTime - t.startTime;
                System.out.println("Method: " + entry.getKey() + ", time: " + estimatedTime + ", startTime: " + t.startTime + ", endTime: " + t.endTime);
            }
        }
    }*/


}
