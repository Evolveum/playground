package com.suta.profiler.profiling;

import com.suta.profiler.Attributes;
import com.suta.profiler.gui.util.ProfilingPage;
import com.suta.profiler.types.ProjectType;

import javax.naming.directory.AttributeInUseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  This class provides functionality needed to launch application with
 *  attached java agents
 *
 *  @author Erik Suta
 * */
public class ApplicationLauncher {

    /* Attributes */
    private static String ERROR_LOG_FILE = "C:\\Profiler\\error.txt";

    /**
     *  Constructs startup script for individual analysed program launch
     * */
    public static String createStartupScript(String jarPath){

        String command = "java -javaagent:" + Attributes.AGENT_FILE_PATH + " -jar " + jarPath;

        return command;
    }

    /**
     *  Runs profiled java application from command line in Windows
     * */
    public static void launchApplication(ProjectType project){

        //String command = "java -javaagent:" + Attributes.AGENT_FILE_PATH + " -jar " + project.getJarPath();

        String[] command = new String[Attributes.COMMAND_FIELD_MAX_SIZE];
        command[0] = "cmd.exe";
        command[1] = Attributes.TEMP_FILE_PATH;
        command[2] = "java -javaagent:" + Attributes.AGENT_FILE_PATH + " -jar " + project.getJarPath();
        //TODO - add arbitrary JVM options, that user provided here

        try{
            Runtime runtime = Runtime.getRuntime();
            System.out.println("Executing: " + command[0] + " " + command[1] + " " + command[2]);
            Process process = runtime.exec(command);

            //Collect error messages
            ApplicationThread appThreadError = new ApplicationThread(process.getErrorStream(), "ERROR");

            //Collect output
            ApplicationThread appThreadOutput = new ApplicationThread(process.getInputStream(), "OUTPUT");

            appThreadError.start();
            appThreadOutput.start();

            int exitValue = process.waitFor();
            System.out.println();

        }catch (IOException ioe){
            //ioe.printStackTrace();
            //ProfilingPage.LOGGER.error("Problem when launching new JVM: " + ioe.getStackTrace().toString());
            //TODO - log this error with proper error message
        }catch (InterruptedException inte){
            //inte.printStackTrace();
            //ProfilingPage.LOGGER.error("Creation of new JVM was interrupted: " + inte.getStackTrace().toString());
            //TODO - log this error with proper error message
        }
    }   //launchApplication end

    /**
     *  Use this method to catch output from java command line application
     * */
    public static void catchOutputStream(Process process){

        try{
            //process.waitFor();
            BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader buf2 = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line="";

            while((line = buf.readLine())!=null || (line = buf2.readLine())!=null)
                System.out.println(line);

        }/*catch (InterruptedException ie){
            ie.printStackTrace();
            //TODO - log this error with proper error message
        }*/catch (IOException ioe){
            ioe.printStackTrace();
            //TODO - log this error with proper error message
        }
    }   //catchOutputStream end

}
