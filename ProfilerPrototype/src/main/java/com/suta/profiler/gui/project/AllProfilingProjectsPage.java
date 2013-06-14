package com.suta.profiler.gui.project;

import com.suta.profiler.gui.util.ProfilingPage;
import com.suta.profiler.types.ProjectType;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.ArrayList;
import java.util.List;

/**
 *  This class represents class part of wicket html page, it contains necessary functionality needed to
 *  run interaction between profiler and user working with it
 *
 *  @author Erik Suta
 * */
public class AllProfilingProjectsPage extends ProfilingPage{

    /* Attributes */
    List<ProjectType> projectList = new ArrayList<ProjectType>();
    private ProjectType helpProject;

    /* GUI attributes */

    /**
     *  Constructor
     * */
    public AllProfilingProjectsPage(final PageParameters parameters){
        super(parameters);

        projectList = ProjectType.retrieveProfilingProjects();
        /**
         *  Populate table with listView of ProjectType
         * */
        ListView projectListView = new ListView<ProjectType>("projectList", projectList) {

            @Override
            protected void populateItem(ListItem listItem) {
                final ProjectType actProject = (ProjectType)listItem.getModelObject();
                //System.out.println(actProject);
                //helpProject = actProject;
                listItem.add(new Label("projectName", actProject.getName()));
                listItem.add(new Label("projectPid", actProject.getPid()));
                listItem.add(new Label("projectProgram", actProject.getProgramName()));
                listItem.add(new Label("ProjectScenario", actProject.getSelectedProfilingScenarioName()));
                listItem.add(new Label("ProjectLevel", actProject.getSelectedProfilingLevelName()));

                //editOption
                listItem.add(new Link("editOption") {

                    @Override
                    public void onClick(){
                        setResponsePage(new ActualProfilingProjectPage(parameters, 0, actProject));
                    }
                });

                //removeOption
                listItem.add(new Link("deleteOption") {

                    @Override
                    public void onClick(){
                        actProject.deleteProject(actProject);
                        setResponsePage(new AllProfilingProjectsPage(parameters));
                    }
                });

                //launchOption
                listItem.add(new Link("launchOption") {

                    @Override
                    public void onClick(){
                        //TODO - some action will be done here
                    }
                });
            }
        };  //projectListView end

        add(projectListView);
    }   //constructor end


}
