package com.suta.profiler.gui.scenarios;

import com.suta.profiler.Attributes;
import com.suta.profiler.gui.util.ProfilingPage;
import com.suta.profiler.types.ProfilingScenario;
import com.suta.profiler.types.ProjectType;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *  TODO - not fully functional - does not apply changes to selected methods
 *  TODO - when name or something else is changed, dont create new object, rename old one
 *
 *  This is class part of Actual Profiling Page - in this page, user will
 *  be able to view selected or current Profiling Project or he will be able to edit
 *  some of the Profiling Project Attributes
 *
 *  @author Erik Suta
 * */
public class ActualProfilingScenarioPage extends ProfilingPage{

    /* Attributes */
    private ProfilingScenario modifiedScenario;
    private ProjectType actProject;
    private String scenarioName;
    private String scenarioDescription;
    private String programName;
    private String projectName;
    private int helpMode;

    private static List<String> classNameList = new ArrayList<String>();
    private static Map<CheckBox, MethodSelector> selectedMethodMap = new HashMap<CheckBox, MethodSelector>();

    /* GUI Attributes */
    final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
    private Form<?> form;
    private TextField nameField;
    private TextField projectNameField;
    private TextField programNameField;
    private TextArea descriptionArea;

    private ListView classListViewField;
    private ListView classMethodListField;

    private Button submitButton;
    private Link modeSwitchLink;

    /**
     *  Constructor
     * */
    public ActualProfilingScenarioPage(final PageParameters parameters, ProfilingScenario scenario, int mode){
        //mode = 0 - VIEW MODE
        //mode = 1 - EDIT MODE
        super(parameters);
        helpMode = mode;

        //If no profiling project is selected
        if(scenario == null){
            add(new Label("mode", "No profiling scenario selected"));
            return;
            //TODO - find a solution to situation with null entry project and following NPE
        }

        modifiedScenario = scenario;
        actProject = (ProjectType)ProjectType.deserializeObject(Attributes.PROJECT_FILE_PATH, modifiedScenario.getProjectType().getName() + ".prj");
        modifiedScenario.setProjectType(actProject);
        scenarioName = modifiedScenario.getName();
        scenarioDescription = modifiedScenario.getDescription();
        projectName = modifiedScenario.getProjectType().getName();
        programName = modifiedScenario.getProjectType().getProgramName();

        if(!classNameList.isEmpty())
            classNameList.removeAll(classNameList);
        classNameList.addAll(actProject.getClassNames());

        if(!selectedMethodMap.isEmpty())
            selectedMethodMap.clear();

        form = new Form<Void>("form");
        nameField = new TextField<String>("scenarioName", new PropertyModel<String>(this, "scenarioName"));
        projectNameField = new TextField<String>("projectName", new PropertyModel<String>(this, "projectName"));
        programNameField = new TextField<String>("programName", new PropertyModel<String>(this, "programName"));
        descriptionArea = new TextArea<String>("scenarioDescription", new PropertyModel<String>(this, "scenarioDescription"));

        /* Class and methods ListViews */
        classListViewField = new ListView<String>("methodList", classNameList) {

            @Override
            protected void populateItem(ListItem listItem) {
                final String className = (String)listItem.getModelObject();
                listItem.add(new Label("className", className));

                //Method ListView
                listItem.add(classMethodListField = new ListView<String>("methods", actProject.getMethodMultiMap().get(className)) {
                    //TODO - add functionality to show/hide Object Class methods
                    @Override
                    protected void populateItem(ListItem listItem) {
                        String methodName = (String)listItem.getModelObject();

                        if(methodName.equals(actProject.getMethodMultiMap().get(className).get(0)))
                            listItem.add(new Label("methodLabel", "Methods:"));
                        else
                            listItem.add(new Label("methodLabel", ""));

                        CheckBox checkBox;

                        //modifiedScenario.printMethodList();

                        //System.out.println("ClassName: " + className);
                        if(modifiedScenario.getMethodList().containsKey(className) && modifiedScenario.getMethodList().get(className).contains(methodName))
                            listItem.add(checkBox = new CheckBox("selectedMethodCheckBox", Model.of(Boolean.TRUE)));
                        else
                            listItem.add(checkBox = new CheckBox("selectedMethodCheckBox", Model.of(Boolean.FALSE)));


                        listItem.add(new Label("methodName", methodName));

                        selectedMethodMap.put(checkBox, new MethodSelector(className, methodName, checkBox.getModelObject()));

                    }
                });      //method ListView end
            }
        };     //class ListView

        //Submit button
        submitButton = new Button("submitButton"){

            @Override
            public void onSubmit(){
                HashMap<String, ArrayList<String>> methodList = new HashMap<String, ArrayList<String>>();
                collectSelectedMethods();
                methodList = fillMethodList(methodList);
                modifiedScenario.setName(scenarioName);
                modifiedScenario.setDescription(scenarioDescription);
                modifiedScenario.setMethodList(methodList);
                modifiedScenario.setProjectType(actProject);
                ProfilingScenario.saveObject(modifiedScenario);
                updateProject(modifiedScenario);
                ProjectType.saveObject(actProject);
                setResponsePage(new ActualProfilingScenarioPage(parameters, modifiedScenario, 1));
            }
        };

        //View mode rendering
        if(mode == 0){
            add(new Label("mode", "View Mode"));

            nameField.setEnabled(false);
            descriptionArea.setEnabled(false);
            programNameField.setEnabled(false);
            projectNameField.setEnabled(false);
            submitButton.setEnabled(false);

            modeSwitchLink = new Link("modeSwitchLink") {

                @Override
                public void onClick() {
                    setResponsePage(new ActualProfilingScenarioPage(parameters, modifiedScenario, 1));
                }
            };
            modeSwitchLink.setModel(new Model<String>("Edit mode"));
        }
        //Edit mode rendering
        else {
            add(new Label("mode", "Edit Mode"));

            nameField.setEnabled(true);
            descriptionArea.setEnabled(true);
            programNameField.setEnabled(true);
            projectNameField.setEnabled(true);
            submitButton.setEnabled(true);

            modeSwitchLink = new Link("modeSwitchLink") {

                @Override
                public void onClick() {
                    setResponsePage(new ActualProfilingScenarioPage(parameters, modifiedScenario, 0));
                }
            };
            modeSwitchLink.setModel(new Model<String>("View mode"));
        }

        //Add stuff to page
        feedbackPanel.setEscapeModelStrings(false);
        add(feedbackPanel);

        form.add(nameField);
        form.add(projectNameField);
        form.add(programNameField);
        form.add(descriptionArea);
        form.add(classListViewField);

        form.add(submitButton);

        add(modeSwitchLink);
        add(form);
    }   //Constructor end

    /**
     *  Updates project with created Profiling Scenario
     * */
    private void updateProject(ProfilingScenario profilingScenario){
        actProject.profilingScenarioList.add(profilingScenario);
        actProject.setSelectedProfilingScenario(profilingScenario);
        //profilingScenario.printMethodList();
    }

    /**
     *  Perform actualisation of user selected methods
     * */
    public static void collectSelectedMethods(){
        //selectedMethodMap.clear();
        for(CheckBox ch: selectedMethodMap.keySet()){
            selectedMethodMap.get(ch).selected = ch.getModelObject();
        }
    }

    /**
     *  Method performs check upon user selected methods and creates Map with selected methods and their classes
     * */
    public static HashMap<String, ArrayList<String>> fillMethodList(HashMap<String, ArrayList<String>> methodList){
        methodList.clear();

        for(MethodSelector methodSelector: selectedMethodMap.values()){
            if(methodSelector.selected){
                if(methodList.containsKey(methodSelector.className)){
                    methodList.get(methodSelector.className).add(methodSelector.methodName);
                }
                else{
                    ArrayList<String> tempMethodArray = new ArrayList<String>();
                    tempMethodArray.add(methodSelector.methodName);
                    methodList.put(methodSelector.className, tempMethodArray);
                }
            }
        }
        return methodList;
    }

    /**
     *  Inner help class used for storing method name and checkbox state in checkbox method list
     * */
    class MethodSelector implements Serializable {

        /* Attributes */
        String className;
        String methodName;
        Boolean selected;

        /* Constructor */
        MethodSelector(String className, String name, Boolean selected){
            this.className = className;
            this.methodName = name;
            this.selected = selected;
        }
    }   //Inner class end
}
