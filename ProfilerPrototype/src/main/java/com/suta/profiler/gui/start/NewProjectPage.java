package com.suta.profiler.gui.start;


import com.suta.profiler.Attributes;
import com.suta.profiler.gui.profiling.ProfilingOverviewPage;
import com.suta.profiler.gui.scenarios.CreateProfilingScenarioPage;
import com.suta.profiler.gui.util.FeedbackPanelMessages;
import com.suta.profiler.gui.util.ProfilingPage;
import com.suta.profiler.profiling.ApplicationLauncher;
import com.suta.profiler.types.ProfilingLevel;
import com.suta.profiler.types.ProfilingScenario;
import com.suta.profiler.types.ProjectType;
import com.suta.profiler.util.AttachHandler;
import com.suta.profiler.util.CommunicationServer;
import com.suta.profiler.util.JarFileHandler;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.ajax.markup.html.form.AjaxCheckBox;
import org.apache.wicket.extensions.ajax.markup.html.AjaxEditableMultiLineLabel;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.List;

//TODO - add CPU and MEMORY SELECTING OPTION later, when it is implemented
//TODO - functionality of check button - choose, if file will be saved or only path will be kept
//TODO - FIELD VALIDATORS!!!
//TODO - edit and create buttons to profiling levels and scenarios

/**
 *  NewProjectPage
 *
 *  @author Erik Suta
 *
 * */
public class NewProjectPage extends ProfilingPage{

    /* Attributes */
    private static ProjectType newProject = new ProjectType();

    private boolean attachOnStart = true;
    private int pid;

    private List<String> PROFILING_SCENARIO_NAMES;
    private List<String> PROFILING_LEVEL_NAMES;
    private String selectedProfilingScenarioName;
    private String selectedProfilingLevelName;
    private String projectName;
    private String projectDescription;
    private int projectPid;

    /* GUI Attributes */
    private FileUploadField fileUploadField;
    private FileUpload fileUpload = null;
    final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
    private Form<?> form;

    private TextField<String> nameField;
    private TextField<String> pidField;


    private TextArea<String> descriptionField;
    private CheckBox attachCheckbox;

    private DropDownChoice<String> profilingScenarioDropDownChoice;
    private DropDownChoice<String> profilingLevelDropDownChoice;

    /**
     *  Constructor - for rendering page when clicked from menu
     * */
    public NewProjectPage(final PageParameters parameters, ProjectType project, final boolean fileAlreadyUploaded){
        super(parameters);

        if(project != null){
            projectName = project.getName();
            projectDescription = project.getDescription();
            projectPid = project.getPid();
        }else {
            projectName = "";
            projectDescription = "";
            projectPid = 0;
        }

        newProject = project;
        PROFILING_SCENARIO_NAMES = newProject.getProfilingScenariosNames();
        ProfilingLevel.profilingLevelList = ProfilingLevel.retrieveProfilingLevels();
        PROFILING_LEVEL_NAMES = ProfilingLevel.retrieveProfilingLevelNamesList();
        selectedProfilingScenarioName = newProject.getSelectedProfilingScenarioName();
        selectedProfilingLevelName = newProject.getSelectedProfilingLevelName();

        form = new Form<Void>("form");
        nameField = new TextField<String>("name", new PropertyModel<String>(this, "projectName"));
        nameField.setRequired(true);

        pidField = new TextField<String>("pid", new PropertyModel<String>(this, "projectPid"));

        descriptionField = new TextArea<String>("description", new PropertyModel<String>(this, "projectDescription"));

        attachCheckbox = new CheckBox("attachCheckbox", new PropertyModel<Boolean>(this, "attachOnStart"));

        profilingScenarioDropDownChoice = new DropDownChoice<String>("profilingScenarioSelector", new PropertyModel<String>(this, "selectedProfilingScenarioName"), PROFILING_SCENARIO_NAMES);
        profilingLevelDropDownChoice = new DropDownChoice<String>("profilingLevelSelector", new PropertyModel<String>(this, "selectedProfilingLevelName"), PROFILING_LEVEL_NAMES);


        //Submit button
        form.add(new Button("button") {

            @Override
            public void onSubmit() {

                if(profilingLevelDropDownChoice.getModelObject().equals("none"))
                    newProject.setSelectedProfilingLevel(ProfilingLevel.createDefaultProfilingLevel());
                else
                    newProject.setSelectedProfilingLevel(ProfilingLevel.findLevelByName(profilingLevelDropDownChoice.getModelObject()));
                //System.out.println("Selected scenario: " + newProject.getSelectedProfilingLevel().getName());

                newProject.setSelectedProfilingScenario(newProject.findScenarioByName(profilingScenarioDropDownChoice.getModelObject()));

                //TODO - add filename and file Validator (if selected file really is .jar file)
                if(!fileAlreadyUploaded){
                    fileUpload= fileUploadField.getFileUpload();
                    String jarPath = JarFileHandler.loadAndStoreJarFile(fileUpload);
                    newProject.setJarPath(jarPath);
                    newProject.setAttachOnStart(attachOnStart);
                    newProject.setName(projectName);
                    newProject.setDescription(projectDescription);
                }

                Attributes.currentProject = newProject;

                if(newProject.getSelectedProfilingScenario() != null)
                    Attributes.currentProfilingScenario = newProject.getSelectedProfilingScenario();

                if(newProject.getSelectedProfilingLevel() != null){
                    Attributes.currentProfilingLevel = newProject.getSelectedProfilingLevel();
                }

                JarFileHandler.runJarDiscovery(newProject);
                ProjectType.saveObject(newProject);
                CommunicationServer.initCommunicationServerThread(newProject);

                AttachHandler.attachToJvm(newProject.getPid());
                //CommunicationServer.prepareInstructionPacket(newProject);


                setResponsePage(new ProfilingOverviewPage(parameters));

                //TEST
                success(FeedbackPanelMessages.generateSuccessMessage("Project created: " + newProject.getName() + "<br>File: " + newProject.getJarPath() + "."));
            }
        });

        //Create new profiling scenario button
        form.add(new Button("createScenarioButton") {

            @Override
            public void onSubmit() {
                //TODO - let know, that jar is already copied when submitting form after creation of user scenario
                FileUpload helpUploadedFile = fileUploadField.getFileUpload();
                String jarPath = JarFileHandler.loadAndStoreJarFile(helpUploadedFile);
                newProject.setJarPath(jarPath);
                newProject.setAttachOnStart(attachOnStart);
                newProject.setName(projectName);
                newProject.setDescription(projectDescription);
                JarFileHandler.runJarDiscovery(newProject);
                setResponsePage(new CreateProfilingScenarioPage(parameters, newProject, new ProfilingScenario(), true));
            }

        });

        //EditProfilingScenario button
        form.add(new Button("editScenarioButton"){
            //TODO - Ovverride onSubmit method and add appropriate functionality
        });

        //Create profiling level button
        form.add(new Button("createLevelButton"){
            //TODO - Ovverride onSubmit method and add appropriate functionality
        });

        //Edit profiling level button
        form.add(new Button("editLevelButton"){
            //TODO - Ovverride onSubmit method and add appropriate functionality
        });



        //SelectPidButton
        form.add(new Button("selectPid"){

            @Override
            public void onSubmit(){
                if(!fileAlreadyUploaded){
                    fileUpload= fileUploadField.getFileUpload();
                    String jarPath = JarFileHandler.loadAndStoreJarFile(fileUpload);
                    newProject.setJarPath(jarPath);
                    newProject.setAttachOnStart(attachOnStart);
                    newProject.setName(projectName);
                    newProject.setDescription(projectDescription);
                }
                setResponsePage(new AttachToJvmPage(parameters, newProject));

            }
        });

        feedbackPanel.setEscapeModelStrings(false);
        add(feedbackPanel);
        add(form);

        form.add(nameField);
        form.add(pidField);
        form.add(descriptionField);
        form.add(attachCheckbox);
        form.add(profilingScenarioDropDownChoice);
        form.add(profilingLevelDropDownChoice);

        form.setMultiPart(true);

        fileUploadField = new FileUploadField("upload");

        if(!fileAlreadyUploaded)
            fileUploadField.setRequired(true);

        form.add(fileUploadField);

    }   //end constructor
}
