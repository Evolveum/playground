package com.suta.profiler.util;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import com.suta.profiler.Attributes;

import java.io.IOException;

/**
 *  Handling dynamic JVM attachment
 *
 *
 *  @author Erik Suta
 */

public class AttachHandler {

    /* Attributes */

    /**
     *  Attach to JVM
     * */
    public static void attachToJvm(int jvmPid){

        try{
            VirtualMachine vm = VirtualMachine.attach(String.valueOf(jvmPid));
            vm.loadAgent(Attributes.AGENT_FILE_PATH);
            vm.detach();

        }catch (AttachNotSupportedException anse){
            //TODO
            anse.printStackTrace();
        }catch (IOException ioe){
            //TODO
            ioe.printStackTrace();
        }catch (AgentInitializationException aie){
            //TODO
            aie.printStackTrace();
        }catch (AgentLoadException ale){
            //TODO
            ale.printStackTrace();
        }


    }



}
