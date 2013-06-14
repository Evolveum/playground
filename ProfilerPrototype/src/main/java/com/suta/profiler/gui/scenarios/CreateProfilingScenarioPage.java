package com.suta.profiler.gui.scenarios;

import com.suta.profiler.Attributes;
import com.suta.profiler.gui.start.NewProjectPage;
import com.suta.profiler.gui.util.ProfilingPage;
import com.suta.profiler.types.ProfilingScenario;
import com.suta.profiler.types.ProjectType;
import com.suta.profiler.util.JarFileHandler;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.io.Serializable;
import java.util.*;

/**
 *
 *  @author Erik Suta
 * */
public class CreateProfilingScenarioPage extends ProfilingPage{

    /* Attributes */
    private static ProfilingScenario newScenario;

    private static List<String> classNameList = new ArrayList<String>();
    private static ProjectType helpProject = null;

    private String scenarioName = "";
    private String scenarioDescription = "";
    private boolean objectMethodsShown;

    private static Map<CheckBox, MethodSelector> selectedMethodMap = new HashMap<CheckBox, MethodSelector>();

    /* GUI attributes */
    private final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
    private Form<?> form = new Form<Void>("form");
    private TextField<String> nameField;
    private TextArea<String> descriptionField;

    //private DropDownChoice<String> classListField;
    private ListView classListViewField;
    private ListView classMethodListField;

    private CheckBox objectClassOptionCheckBox;

    /**
     *  Second Constructor - this one is accessed when we came here from NewProjectPage
     * */
    public CreateProfilingScenarioPage(final PageParameters parameters, ProjectType project, ProfilingScenario scenario, boolean showObjectMethods){
        super(parameters);

        helpProject = project;
        newScenario = scenario;
        objectMethodsShown = showObjectMethods;

        if(!classNameList.isEmpty())
            classNameList.removeAll(classNameList);
        classNameList.addAll(project.getClassNames());

        nameField = new TextField<String>("name", new PropertyModel<String>(this, "scenarioName"));
        descriptionField = new TextArea<String>("description", new PropertyModel<String>(this, "scenarioDescription"));

        //CheckBox functionality
        //TODO - add functionallity to show/hide Object Class methods
        objectClassOptionCheckBox = new CheckBox("selectObjectMethodsOption", Model.of(Boolean.TRUE)){

            @Override
            public void onSelectionChanged(){
                setResponsePage(new CreateProfilingScenarioPage(parameters, helpProject, newScenario, objectClassOptionCheckBox.getModelObject()));
            }
        };

        //Class ListView
        classListViewField = new ListView<String>("methodList", classNameList) {

            @Override
            protected void populateItem(ListItem listItem) {
                final String className = (String)listItem.getModelObject();
                listItem.add(new Label("className", className));

                //Method ListView
                listItem.add(classMethodListField = new ListView<String>("methods", helpProject.getMethodMultiMap().get(className)) {
                    //TODO - add functionallity to show/hide Object Class methods
                    @Override
                    protected void populateItem(ListItem listItem) {
                        String methodName = (String)listItem.getModelObject();

                        if(methodName.equals(helpProject.getMethodMultiMap().get(className).get(0)))
                            listItem.add(new Label("methodLabel", "Methods:"));
                        else
                            listItem.add(new Label("methodLabel", ""));

                        CheckBox checkBox;

                        listItem.add(checkBox = new CheckBox("selectedMethodCheckBox", Model.of(Boolean.FALSE)));
                        listItem.add(new Label("methodName", methodName));

                        selectedMethodMap.put(checkBox, new MethodSelector(className, methodName, checkBox.getModelObject()));

                    }
                });      //method ListView end
            }
        };     //class ListView

        feedbackPanel.setEscapeModelStrings(false);
        add(feedbackPanel);
        add(form);


        nameField.setRequired(true);
        form.add(objectClassOptionCheckBox);
        form.add(nameField);
        form.add(descriptionField);
        //form.add(classListField);
        form.add(classListViewField);

        form.add(new Button("button"){

            @Override
            public void onSubmit(){
                HashMap<String, ArrayList<String>> methodList = new HashMap<String, ArrayList<String>>();
                collectSelectedMethods();
                methodList = fillMethodList(methodList);
                newScenario.setName(scenarioName);
                newScenario.setDescription(scenarioDescription);
                newScenario.setMethodList(methodList);
                newScenario.setProjectType(helpProject);
                ProfilingScenario.saveObject(newScenario);
                updateProject(newScenario);
                setResponsePage(new NewProjectPage(parameters, helpProject, true));
            }
        });
    }   //constructor end

    /**
     *  Updates project with created Profiling Scenario
     * */
    private static void updateProject(ProfilingScenario profilingScenario){
        helpProject.profilingScenarioList.add(profilingScenario);
        helpProject.setSelectedProfilingScenario(profilingScenario);
        //profilingScenario.printMethodList();
    }

    /**
     *  Perform actualisation of user selected methods
     * */
    public static void collectSelectedMethods(){
        for(CheckBox ch: selectedMethodMap.keySet()){
            selectedMethodMap.get(ch).selected = ch.getModelObject();
        }
    }

    /**
     *  Method performs check upon user selected methods and creates Map with selected methods and their classes
     * */
    public static HashMap<String, ArrayList<String>> fillMethodList(HashMap<String, ArrayList<String>> methodList){
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
