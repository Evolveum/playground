package com.suta.profiler.gui.project;

import com.suta.profiler.gui.util.ProfilingPage;
import com.suta.profiler.types.ProfilingLevel;
import com.suta.profiler.types.ProjectType;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.text.Normalizer;
import java.util.List;

/**
 *  //TODO - add functionality to create and edit profiling levels and scenarios
 *  //TODO - Launch project functionality
 *
 *  This is class part of Actual Profiling Page - in this page, user will
 *  be able to view selected or current Profiling Project or he will be able to edit
 *  some of the Profiling Project Attributes
 *
 *  @author Erik Suta
 * */
public class ActualProfilingProjectPage extends ProfilingPage{

    /* Attributes */
    private ProjectType modifiedProject;
    private List<String> PROFILING_SCENARIOS_NAMES;
    private List<String> PROFILING_LEVEL_NAMES;

    private String projectName;
    private int projectPid;
    private String projectDescription;
    private String selectedProfilingLevel;
    private String selectedProfilingScenario;

    /* GUI Attributes */
    final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
    private Form<?> form;
    private TextField<String> nameField;
    private TextField<String> pidField;
    private TextArea<String> descriptionArea;
    private DropDownChoice<String> profilingScenarioDropDownChoice;
    private DropDownChoice<String> profilingLevelDropDownChoice;
    private Label selectedLevelLabel;
    private Label selectedScenarioLabel;
    private Label sourcePathLabel;
    private Label programNameLabel;

    private Button submitButton;

    private Link modeSwitchLink;

    /**
     *  Constructor
     * */
    public ActualProfilingProjectPage(final PageParameters parameters, int type, ProjectType actualProject){
        super(parameters);

        //If no profiling project is selected
        if(actualProject == null){
            add(new Label("mode", "No profiling project selected"));
            return;
            //TODO - find a solution to situation with null entry project and following NPE
        }

        PROFILING_LEVEL_NAMES = ProfilingLevel.retrieveProfilingLevelNamesList();
        PROFILING_SCENARIOS_NAMES = actualProject.getProfilingScenariosNames();

        if(ProfilingLevel.profilingLevelList.isEmpty() || !(actualProject.getSelectedProfilingLevel() == null))
            selectedProfilingLevel = "none";
        else
            selectedProfilingLevel = actualProject.getSelectedProfilingLevel().getName();

        if(actualProject.getSelectedProfilingScenario() == null)
            selectedProfilingScenario = "none";
        else
            selectedProfilingScenario = actualProject.getSelectedProfilingScenario().getName();

        modifiedProject = actualProject;
        projectName = modifiedProject.getName();
        projectPid = modifiedProject.getPid();
        projectDescription = modifiedProject.getDescription();

        form = new Form<Void>("form");
        nameField = new TextField<String>("projectName", new PropertyModel<String>(this, "projectName"));
        pidField = new TextField<String>("pid", new PropertyModel<String>(this, "projectPid"));
        descriptionArea = new TextArea<String>("projectDescription", new PropertyModel<String>(this, "projectDescription"));

        profilingLevelDropDownChoice = new DropDownChoice<String>("profilingLevels", new PropertyModel<String>(this, "selectedProfilingLevel"), PROFILING_LEVEL_NAMES);
        profilingScenarioDropDownChoice = new DropDownChoice<String>("profilingScenarios",new PropertyModel<String>(this,"selectedProfilingScenario"),PROFILING_SCENARIOS_NAMES);
        selectedLevelLabel = new Label("selectedLevel", selectedProfilingLevel);
        selectedScenarioLabel = new Label("selectedScenarioLabel", selectedProfilingScenario);
        sourcePathLabel = new Label("projectSourcePath", modifiedProject.getJarPath());
        programNameLabel = new Label("programName", modifiedProject.getProgramName());

        submitButton = new Button("submitButton"){

            @Override
            public void onSubmit(){
                modifiedProject.setName(projectName);
                modifiedProject.setDescription(projectDescription);

                //TODO - modifications of selected profiling levels and scenarios

                ProjectType.saveObject(modifiedProject);

                setResponsePage(new ActualProfilingProjectPage(parameters, 0, modifiedProject));
            }
        };

        //View mode rendering
        if(type == 0){
            add(new Label("mode", "View Mode"));
            nameField.setEnabled(false);
            descriptionArea.setEnabled(false);
            profilingLevelDropDownChoice.setEnabled(false);
            profilingScenarioDropDownChoice.setEnabled(false);
            pidField.setEnabled(false);
            submitButton.setEnabled(false);

            modeSwitchLink = new Link("modeSwitchLink") {

                @Override
                public void onClick() {
                    setResponsePage(new ActualProfilingProjectPage(parameters, 1, modifiedProject));
                }
            };
            modeSwitchLink.setModel(new Model<String>("Edit mode"));
        }
        //Edit mode rendering
        else{
            add(new Label("mode", "Edit Mode"));

            nameField.setEnabled(true);
            descriptionArea.setEnabled(true);
            profilingLevelDropDownChoice.setEnabled(true);
            profilingScenarioDropDownChoice.setEnabled(true);
            pidField.setEnabled(true);
            submitButton.setEnabled(true);

            modeSwitchLink = new Link("modeSwitchLink") {

                @Override
                public void onClick() {
                    setResponsePage(new ActualProfilingProjectPage(parameters, 0, modifiedProject));
                }
            };
            modeSwitchLink.setModel(new Model<String>("View mode"));
        }

        feedbackPanel.setEscapeModelStrings(false);
        add(feedbackPanel);

        form.add(nameField);
        form.add(descriptionArea);
        form.add(programNameLabel);
        form.add(pidField);
        form.add(selectedLevelLabel);
        form.add(selectedScenarioLabel);
        form.add(sourcePathLabel);
        form.add(profilingLevelDropDownChoice);
        form.add(profilingScenarioDropDownChoice);

        form.add(submitButton);

        add(modeSwitchLink);
        add(form);
    }   //constructor end


}
