package com.suta.profiler.gui.profiling;

import com.profiler.agent.MemoryMeasurement;
import com.suta.profiler.Attributes;
import com.suta.profiler.gui.util.ProfilingPage;
import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *  TODO - JIT compiler name
 *  TODO - Process CPU time
 *  TODO - Total compile time
 *  ========================================
 *  TODO - Daemon threads
 *  TODO - Total threads started
 *  TODO - Total class loaded
 *  TODO - Total class unloaded
 *  ========================================
 *  TODO - Garbage Collectors
 *  TODO - Objects pending finalization
 *  ========================================
 *  TODO - Committed virtual memory
 *  TODO - Total physical memory
 *  TODO - Free physical memory
 *  TODO - Total Swap space
 *  TODO - Free swap space
 *  ========================================
 *
 *  TODO - find a nice way to delimit categories of VM information
 *  TODO - format large numbers
 *  TODO - opravit zalamovanie riadkov pri classPath a tomu podobnych INFO
 *
 *  @author Erik Suta
 * */
public class ProfilingVMSummaryPage extends ProfilingPage{

    /* Attributes */
    private static final long serialVersionUID = 1L;

    private static int maxLiveThreads = 0;

    private static String processLabelValue = "-";
    private static String virtualMachineLabelValue = "-";
    private static String vendorLabelValue = "-";
    private static String pcNameLabelValue = "-";
    private static String uptimeLabelValue = "-";
    private static String processCPUTimeLabelValue = "-";
    private static String jitCompilerLabelValue = "-";
    private static String compileTimeLabelValue = "-";

    private static String liveThreadsLabelValue = "-";
    private static String peakLiveThreadsLabelValue = "-";
    private static String daemonLabelValue = "-";
    private static String totalThreadsStartedLabelValue = "-";
    private static String currentClassLoadedLabelValue = "-";
    private static String totalClassLoadedLabelValue = "-";
    private static String totalClassUnloadedLabelValue = "-";

    private static String currentHeapSizeLabelValue = "-";
    private static String maxHeapSizeLabelValue = "-";
    private static String garbageCollectorLabelValue = "-";
    private static String committedMemoryLabelValue = "-";
    private static String objectsPendingFinalizationLabelValue = "-";

    private static String osNameLabelValue = "-";
    private static String architectureLabelValue = "-";
    private static String numberOfCPULabelValue = "-";
    private static String committedVirtualMemoryLabelValue = "-";
    private static String totalRAMLabelValue = "-";
    private static String freeRAMLabelValue = "-";
    private static String totalSwapLabelValue = "-";
    private static String freeSwapLabelValue = "-";

    private static String vmArgumentsLabelValue = "-";
    private static String classPathLabelValue = "-";
    private static String libraryPathLabelValue = "-";
    private static String bootClassPathLabelValue = "-";

    /* GUI attributes */
    WebMarkupContainer summaryPanel = new WebMarkupContainer("summaryPanel");

    private Label processLabel = new Label("process", new PropertyModel<String>(this,"processLabelValue"));
    private Label virtualMachineLabel = new Label("vmName", new PropertyModel<String>(this,"virtualMachineLabelValue"));
    private Label vendorLabel = new Label("vendor", new PropertyModel<String>(this,"vendorLabelValue"));
    private Label pcNameLabel = new Label("machineName", new PropertyModel<String>(this,"pcNameLabelValue"));
    private Label uptimeLabel = new Label("uptime", new PropertyModel<String>(this,"uptimeLabelValue"));
    private Label processCPUTimeLabel = new Label("cpuTime", new PropertyModel<String>(this,"processCPUTimeLabelValue"));
    private Label jitCompilerLabel = new Label("jitCompiler", new PropertyModel<String>(this,"jitCompilerLabelValue"));
    private Label compileTimeLabel = new Label("compileTime", new PropertyModel<String>(this,"compileTimeLabelValue"));

    private Label liveThreadsLabel = new Label("liveThreads", new PropertyModel<String>(this,"liveThreadsLabelValue"));
    private Label peakLiveThreadsLabel = new Label("peakClasses", new PropertyModel<String>(this,"peakLiveThreadsLabelValue"));
    private Label daemonLabel = new Label("daemonThreads", new PropertyModel<String>(this,"daemonLabelValue"));
    private Label totalThreadsStartedLabel = new Label("threadsStarted", new PropertyModel<String>(this,"totalThreadsStartedLabelValue"));
    private Label currentClassLoadedLabel = new Label("loadedClasses", new PropertyModel<String>(this,"currentClassLoadedLabelValue"));
    private Label totalClassLoadedLabel = new Label("totalLoadedClasses", new PropertyModel<String>(this,"totalClassLoadedLabelValue"));
    private Label totalClassUnloadedLabel = new Label("unloadedClasses", new PropertyModel<String>(this,"totalClassUnloadedLabelValue"));

    private Label currentHeapSizeLabel = new Label("heapSize", new PropertyModel<String>(this,"currentHeapSizeLabelValue"));
    private Label maxHeapSizeLabel = new Label("maxHeapSize", new PropertyModel<String>(this,"maxHeapSizeLabelValue"));
    private Label garbageCollectorLabel = new Label("garbageCollectors", new PropertyModel<String>(this,"garbageCollectorLabelValue"));
    private Label committedMemoryLabel = new Label("committedMemory", new PropertyModel<String>(this,"committedMemoryLabelValue"));
    private Label objectsPendingFinalizationLabel = new Label("objectsPendingFinalization", new PropertyModel<String>(this,"objectsPendingFinalizationLabelValue"));

    private Label osNameLabel = new Label("operatingSystem", new PropertyModel<String>(this,"osNameLabelValue"));
    private Label architectureLabel = new Label("architecture", new PropertyModel<String>(this,"architectureLabelValue"));
    private Label numberOfCPULabel = new Label("cpuNumber", new PropertyModel<String>(this,"numberOfCPULabelValue"));
    private Label committedVirtualMemoryLabel = new Label("committedVirtualMemory", new PropertyModel<String>(this,"committedVirtualMemoryLabelValue"));
    private Label totalRAMLabel = new Label("totalRAM", new PropertyModel<String>(this,"totalRAMLabelValue"));
    private Label freeRAMLabel = new Label("freeRAM", new PropertyModel<String>(this,"freeRAMLabelValue"));
    private Label totalSwapLabel = new Label("totalSwap", new PropertyModel<String>(this,"totalSwapLabelValue"));
    private Label freeSwapLabel = new Label("freeSwap", new PropertyModel<String>(this,"freeSwapLabelValue"));

    private Label vmArgumentsLabel = new Label("vmArguments", new PropertyModel<String>(this,"vmArgumentsLabelValue"));
    private Label classPathLabel = new Label("classPath", new PropertyModel<String>(this,"classPathLabelValue"));
    private Label libraryPathLabel = new Label("libraryPath", new PropertyModel<String>(this,"libraryPathLabelValue"));
    private Label bootClassPathLabel = new Label("bootClassPath", new PropertyModel<String>(this,"bootClassPathLabelValue"));

    /**
     *  Constructor
     * */
    public ProfilingVMSummaryPage(final PageParameters parameters){
        super(parameters);

        summaryPanel.add(processLabel);
        summaryPanel.add(virtualMachineLabel);
        summaryPanel.add(vendorLabel);
        summaryPanel.add(pcNameLabel);
        summaryPanel.add(uptimeLabel);
        summaryPanel.add(processCPUTimeLabel);
        summaryPanel.add(jitCompilerLabel);
        summaryPanel.add(compileTimeLabel);

        summaryPanel.add(liveThreadsLabel);
        summaryPanel.add(peakLiveThreadsLabel);
        summaryPanel.add(daemonLabel);
        summaryPanel.add(totalThreadsStartedLabel);
        summaryPanel.add(currentClassLoadedLabel);
        summaryPanel.add(totalClassLoadedLabel);
        summaryPanel.add(totalClassUnloadedLabel);

        summaryPanel.add(currentHeapSizeLabel);
        summaryPanel.add(maxHeapSizeLabel);
        summaryPanel.add(garbageCollectorLabel);
        summaryPanel.add(committedMemoryLabel);
        summaryPanel.add(objectsPendingFinalizationLabel);

        summaryPanel.add(osNameLabel);
        summaryPanel.add(architectureLabel);
        summaryPanel.add(numberOfCPULabel);
        summaryPanel.add(committedVirtualMemoryLabel);
        summaryPanel.add(totalRAMLabel);
        summaryPanel.add(freeRAMLabel);
        summaryPanel.add(totalSwapLabel);
        summaryPanel.add(freeSwapLabel);

        summaryPanel.add(vmArgumentsLabel);
        summaryPanel.add(classPathLabel);
        summaryPanel.add(libraryPathLabel);
        summaryPanel.add(bootClassPathLabel);

        summaryPanel.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(SELF_UPDATE_INTERVAL)));
        add(summaryPanel);
    }   //Constructor end

    /**
     *  Collects and summarizes data about VM
     * */
    public static void collectVMData() throws UnknownHostException {

        //Basic system info section
        processLabelValue = "Pid: " + Attributes.currentProject.getPid() + ", " + Attributes.currentProject.getProgramName();
        virtualMachineLabelValue = System.getProperty("java.vm.name") + ", version: " + System.getProperty("java.vm.version");
        vendorLabelValue = System.getProperty("java.vendor");
        pcNameLabelValue = InetAddress.getLocalHost().getHostName();
        uptimeLabelValue = Long.toString(ManagementFactory.getRuntimeMXBean().getUptime()/1000) + " seconds";

        //Threads and classes info section
        liveThreadsLabelValue = Integer.toString(ProfilingThreadsPage.getLiveThreads());

        if(Integer.parseInt(liveThreadsLabelValue) > maxLiveThreads){
            maxLiveThreads = Integer.parseInt(liveThreadsLabelValue);
            peakLiveThreadsLabelValue = liveThreadsLabelValue;
        }else
            peakLiveThreadsLabelValue = Integer.toString(maxLiveThreads);

         currentClassLoadedLabelValue = Integer.toString(ProfilingClassesPage.getLoadedClasses());

        //memory info section
        MemoryMeasurement actMemoryMeasurement = ProfilingMemoryPage.getActMemMeasurement();

        if(actMemoryMeasurement != null){
            currentHeapSizeLabelValue = Long.toString(actMemoryMeasurement.getUsedMemory()/1024) + " kbytes";
            maxHeapSizeLabelValue = Long.toString(actMemoryMeasurement.getMaxMemory()/1024) + " kbytes";
            committedMemoryLabelValue = Long.toString(actMemoryMeasurement.getNonHeapCommitted()/1024) + " kbytes";
        }
        //operating system and HW info section
        osNameLabelValue = System.getProperty("os.name") + ", version: " + System.getProperty("os.version");
        architectureLabelValue = System.getProperty("os.arch");
        numberOfCPULabelValue = Integer.toString(Runtime.getRuntime().availableProcessors());

        //vm config info section
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

        StringBuilder vmArgs = new StringBuilder();

        for(String s: runtimeMXBean.getInputArguments()){
            vmArgs.append(s + " ");
        }
        vmArgumentsLabelValue = vmArgs.toString();

        classPathLabelValue = runtimeMXBean.getClassPath();
        libraryPathLabelValue = runtimeMXBean.getLibraryPath();
        bootClassPathLabelValue = runtimeMXBean.getBootClassPath();
    }


}
