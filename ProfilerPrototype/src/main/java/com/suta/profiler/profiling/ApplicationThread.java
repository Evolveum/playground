package com.suta.profiler.profiling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *  This class serves as a template for Thread of new profiled application,
 *  we take care of all streams and other important stuff here
 *
 *  @author erik suta
 * */
public class ApplicationThread extends Thread{

    /* Attributes */
    InputStream inputStream;
    String type;

    /* Constructor */
    ApplicationThread(InputStream is, String type){
        this.inputStream = is;
        this.type = type;
    }

    /**
     *  run() defines Thread activity
     * */
    public void run(){

        try{
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);
            String line = null;

            while((line = br.readLine()) != null){
                System.out.println("CLIENT: " + type + ">" + line);
            }

        }catch (IOException ioe){
            ioe.printStackTrace();
            //TODO - log this error and handle it like a boss
        }
    }
}
