package com.suta.profiler.gui.util;

import com.suta.profiler.Attributes;
import com.suta.profiler.gui.options.CreateProfilingLevel;
import com.suta.profiler.gui.options.ProfilingLevelsPage;
import com.suta.profiler.gui.profiling.*;
import com.suta.profiler.gui.project.ActualProfilingProjectPage;
import com.suta.profiler.gui.project.AllProfilingProjectsPage;
import com.suta.profiler.gui.scenarios.ActualProfilingScenarioPage;
import com.suta.profiler.gui.scenarios.AllProfilingScenariosPage;
import com.suta.profiler.gui.start.AttachToJvmPage;
import com.suta.profiler.gui.home.Index;
import com.suta.profiler.gui.start.NewProjectPage;
import com.suta.profiler.types.JavaVirtualMachineType;
import com.suta.profiler.types.ProfilingLevel;
import com.suta.profiler.types.ProfilingScenario;
import com.suta.profiler.types.ProjectType;
import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.io.Serializable;

/**
 *  //TODO - add button to stop/start automatic Ajax refresh to all profiling pages
 *
 *  @author Erik Suta
 * */
public abstract class ProfilingPage extends WebPage{

    /* GUI ATTRIBUTES */
    protected static final int SELF_UPDATE_INTERVAL = 5;

    /* LOGGER */
    //public static Logger LOGGER = Logger.getLogger(ProfilingPage.class.getName());

    /**
     *  Constructor
     * */
    public ProfilingPage(PageParameters parameters){
        super(parameters);
        generateMenu(parameters);
    }

    /**
     *  Generates menu
     * */
    public void generateMenu(final PageParameters parameters){

        /* Home */
        add(new Link("home") {

            @Override
            public void onClick(){
                setResponsePage(new Index(parameters));
            }
        });

        /* Profiling */
        add(new Link("profilingOverview") {

            @Override
            public void onClick(){
                if(Attributes.currentProject == null){
                    String message = "There is no running profiling running at the moment!";
                    setResponsePage(new NoProfilingActive(parameters, message));
                }else
                    setResponsePage(new ProfilingOverviewPage(parameters));
            }
        });
        add(new Link("profilingMethods") {

            @Override
            public void onClick(){
                if(Attributes.currentProject == null || (Attributes.currentProfilingLevel != null && !Attributes.currentProfilingLevel.isMethodProfiling())){
                    String message = "There is no running profiling running at the moment or METHOD profiling is not selected!";
                    setResponsePage(new NoProfilingActive(parameters, message));
                }else
                    setResponsePage(new NoProfilingActive(parameters, "NOT IMPLEMENTED YET"));
            }
        });
        add(new Link("profilingMemory") {

            @Override
            public void onClick(){
                if(Attributes.currentProject == null || (Attributes.currentProfilingLevel != null && !Attributes.currentProfilingLevel.isMemoryProfiling())){
                    String message = "There is no running profiling running at the moment or MEMORY profiling is not selected!";
                    setResponsePage(new NoProfilingActive(parameters, message));
                }else
                    setResponsePage(new ProfilingMemoryPage(parameters));
            }
        });
        add(new Link("profilingCPU") {

            @Override
            public void onClick(){
                if(Attributes.currentProject == null || (Attributes.currentProfilingLevel != null && !Attributes.currentProfilingLevel.isCpuProfiling())){
                    String message = "There is no running profiling running at the moment or CPU profiling is not selected!";
                    setResponsePage(new NoProfilingActive(parameters, message));
                }else
                    setResponsePage(new ProfilingCPUPage(parameters));
            }
        });
        add(new Link("profilingThreads") {

            @Override
            public void onClick(){
                if(Attributes.currentProject == null || (Attributes.currentProfilingLevel != null && !Attributes.currentProfilingLevel.isThreadProfiling())){
                    String message = "There is no running profiling running at the moment or THREAD profiling is not selected!";
                    setResponsePage(new NoProfilingActive(parameters, message));
                }else
                    setResponsePage(new ProfilingThreadsPage(parameters));
            }
        });
        add(new Link("profilingClasses") {

            @Override
            public void onClick(){
                if(Attributes.currentProject == null || (Attributes.currentProfilingLevel != null && !Attributes.currentProfilingLevel.isClassProfiling())){
                    String message = "There is no running profiling running at the moment or CLASS profiling is not selected!";
                    setResponsePage(new NoProfilingActive(parameters, message));
                }else
                    setResponsePage(new ProfilingClassesPage(parameters));
            }
        });
        add(new Link("profilingSummaryVM") {

            @Override
            public void onClick(){
                if(Attributes.currentProject == null){
                    String message = "There is no running profiling running at the moment!";
                    setResponsePage(new NoProfilingActive(parameters, message));
                }else
                    setResponsePage(new ProfilingVMSummaryPage(parameters));
            }
        });

        /* Start Profiling */
        add(new Link("attachToJvmLink") {

            @Override
            public void onClick(){
                //JavaVirtualMachineType.jvmList.removeAll(JavaVirtualMachineType.jvmList);
                setResponsePage(new NewProjectPage(parameters, new ProjectType(), false));
            }
        });
        add(new Link("newProject") {

            @Override
            public void onClick(){
                setResponsePage(new NewProjectPage(parameters, new ProjectType(), false));
            }
        });

        /* Profiling Projects */
        add(new Link("actualProfilingProject") {

            @Override
            public void onClick(){
                setResponsePage(new ActualProfilingProjectPage(parameters, 0, Attributes.currentProject));
            }
        });
        add(new Link("allProfilingProjects") {

            @Override
            public void onClick(){
                setResponsePage(new AllProfilingProjectsPage(parameters));
            }
        });

        /* Profiling Scenarios */
        add(new Link("actualProfilingScenario") {

            @Override
            public void onClick(){
                setResponsePage(new ActualProfilingScenarioPage(parameters, Attributes.currentProfilingScenario, 0));
            }
        });
        add(new Link("createProfilingScenario") {

            @Override
            public void onClick(){
                setResponsePage(new AllProfilingScenariosPage(parameters));
            }
        });
        add(new Link("allProfilingScenarios") {

            @Override
            public void onClick(){
                setResponsePage(new AllProfilingScenariosPage(parameters));
            }
        });

        /* Options */
        add(new Link("overall") {

            @Override
            public void onClick(){
                setResponsePage(new Index(parameters));
            }
        });
        add(new Link("methodFilters") {

            @Override
            public void onClick(){
                setResponsePage(new Index(parameters));
            }
        });
        add(new Link("addMethodFilter") {

            @Override
            public void onClick(){
                setResponsePage(new Index(parameters));
            }
        });
        add(new Link("profilingLevels") {

            @Override
            public void onClick(){
                setResponsePage(new ProfilingLevelsPage(parameters));
            }
        });
        add(new Link("addProfilingLevel") {

            @Override
            public void onClick(){
                setResponsePage(new CreateProfilingLevel(parameters, Attributes.currentProfilingLevel));
            }
        });


    }   //end generateMenu

    /* Getters and Setters */

    public ProjectType getCurrentProject() {
        return Attributes.currentProject;
    }

    public void setCurrentProject(ProjectType currentProject) {
        Attributes.currentProject = currentProject;
    }
}
