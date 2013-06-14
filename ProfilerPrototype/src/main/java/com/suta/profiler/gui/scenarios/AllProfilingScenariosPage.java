package com.suta.profiler.gui.scenarios;

import com.suta.profiler.Attributes;
import com.suta.profiler.gui.util.ProfilingPage;
import com.suta.profiler.types.ProfilingScenario;
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
 *  Class represents java part of List Profiling Scenarios web page and implements
 *  needed functionality
 *
 *  @author Erik Suta
 * */
public class AllProfilingScenariosPage extends ProfilingPage{

    /* Attributes */
    List<ProfilingScenario> profilingScenarioList = new ArrayList<ProfilingScenario>();
    private ProfilingScenario helpScenario;
    private ProjectType scenarioProject;

    /* GUI attributes */

    /**
     *  Constructor
     * */
    public AllProfilingScenariosPage(final PageParameters parameters){
        super(parameters);

        profilingScenarioList = ProfilingScenario.retrieveProfilingScenarios();
        //System.out.println("Profiling scenario list Size["+profilingScenarioList.size()+"]");

        /**
         *  Populate table with list of ProfilingScenario type
         * */
        ListView scenarioListView = new ListView<ProfilingScenario>("scenarioList", profilingScenarioList) {

            @Override
            protected void populateItem(ListItem listItem) {
                final ProfilingScenario actScenario = (ProfilingScenario)listItem.getModelObject();

                scenarioProject = (ProjectType)ProjectType.deserializeObject(Attributes.PROJECT_FILE_PATH, actScenario.getProjectType().getName() + ".prj");
                actScenario.setProjectType(scenarioProject);

                listItem.add(new Label("scenarioName", actScenario.getName()));
                listItem.add(new Label("scenarioProjectName", actScenario.getProjectType().getName()));
                listItem.add(new Label("scenarioProjectProgram", actScenario.getProjectType().getProgramName()));
                listItem.add(new Label("scenarioDescription",actScenario.getDescription()));

                //editOption
                listItem.add(new Link("editButton") {

                    @Override
                    public void onClick(){
                        setResponsePage(new ActualProfilingScenarioPage(parameters, actScenario, 0));
                    }
                });

                //deleteOption
                listItem.add(new Link("deleteButton") {

                    @Override
                    public void onClick(){
                        actScenario.deleteScenario(actScenario);
                        actScenario.getProjectType().profilingScenarioList.remove(actScenario);
                        ProjectType.saveObject(actScenario.getProjectType());
                        setResponsePage(new AllProfilingScenariosPage(parameters));
                    }
                });
            }
        };  //scenarioListView end

        add(scenarioListView);

    }   //constructor end



}
