package com.suta.profiler.util;

import com.suta.profiler.types.ProjectType;

import java.net.SocketTimeoutException;

/**
 *  This class implements Runnable interface. It represents simple thread used to receive
 *  profiling data from JVM, on which profiling agent is attached. We also use this thread to send
 *  various information about profiling configuration, so that agent can work based
 *  on these parameters
 *
 *  @author Erik Suta
 * */
public class CommunicationServerThread implements Runnable{

    /* Attributes */
    Thread communicationThread;
    ProjectType project;

    /**
     *  Constructor
     * */
    CommunicationServerThread(ProjectType project){
        this.project = project;
        communicationThread = new Thread(this, "communication thread");
        communicationThread.start();
        System.out.println("Server: Communication thread: " + communicationThread.getId() + " has been created!");
    }

    /**
     *  run() method, entry point of communication thread
     * */
    public void run(){
        CommunicationServer.initServerSocket(project);
    }   //run end

}
