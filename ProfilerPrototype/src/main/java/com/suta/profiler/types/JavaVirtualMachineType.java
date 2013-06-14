package com.suta.profiler.types;

import sun.tools.jconsole.LocalVirtualMachine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaVirtualMachineType implements Serializable {

    // static elements
    private static Map<Integer, LocalVirtualMachine> virtualMachines = new HashMap<Integer, LocalVirtualMachine>();
    public static List<JavaVirtualMachineType> jvmList = new ArrayList<JavaVirtualMachineType>();

    // non-static elements
    private String displayName;
    private String connectorAddress;
    private Boolean isAttachable;
    private Boolean isManageable;
    private Integer id;
    private String agentId = "";

    /**
     *  This method scans local hardware system for running JVMs. It retrieves list of running JVMs and
     *  with this data set, we are able to fill profiler representation of running JVMs.
     * */
    public static void scanRunningJVMList(){
        virtualMachines.clear();
        virtualMachines = LocalVirtualMachine.getAllVirtualMachines();

        for(Map.Entry<Integer, LocalVirtualMachine> entry: virtualMachines.entrySet()){
            JavaVirtualMachineType newJvm = new JavaVirtualMachineType();
            newJvm.displayName = entry.getValue().displayName();
            newJvm.connectorAddress = entry.getValue().connectorAddress();
            newJvm.isAttachable = entry.getValue().isAttachable();
            newJvm.isManageable = entry.getValue().isManageable();
            newJvm.id = entry.getValue().vmid();
            jvmList.add(newJvm);
        }
    }

    /**
     *  Getters and Setters
     * */
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getConnectorAddress() {
        return connectorAddress;
    }

    public void setConnectorAddress(String connectorAddress) {
        this.connectorAddress = connectorAddress;
    }

    public Boolean getAttachable() {
        return isAttachable;
    }

    public void setAttachable(Boolean attachable) {
        isAttachable = attachable;
    }

    public Boolean getManageable() {
        return isManageable;
    }

    public void setManageable(Boolean manageable) {
        isManageable = manageable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
}
