package com.profiler.agent;

/**
 *  CommunicationClientThread is class, which implements Runnable interface. It is second
 *  thread, that agent creates and it serves communication purposes. In other words, in
 *  this thread, all incoming communication from profiler server is received and
 *  all profiling data are send to profiling server to be processed.
 *
 *  @author Erik Suta
 * */
public class CommunicationClientThread implements Runnable {

    /* Attributes */
    Thread communicationThread;

    /**
     *  Constructor
     * */
    public CommunicationClientThread(){
        communicationThread = new Thread(this, "comClientThread");
        communicationThread.start();
        System.out.println("Client: Communication thread: " + communicationThread.getId() + " has been created.");
    }

    /**
     *  run() method, entry point of communication thread
     * */
    public void run(){
        CommunicationClient.initSocketClient();
    }


}
