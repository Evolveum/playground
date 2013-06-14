package com.suta.profiler.gui.options;

import com.suta.profiler.gui.util.ProfilingPage;
import com.suta.profiler.types.ProfilingLevel;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *  //TODO - default values of profiling aspect intervals
 *
 *  This class is java representation of Profiling Level add/edit page using wicket framework.
 *
 *  @author Erik Suta
 * */
public class CreateProfilingLevel extends ProfilingPage{

    /* Attributes */
    ProfilingLevel workLevel;
    private String levelName;
    private String levelDescription;
    private boolean cpuProfiling;
    private boolean memoryProfiling;
    private boolean threadProfiling;
    private boolean classProfiling;
    private boolean methodProfiling;

    private int cpuInterval;
    private int memoryInterval;
    private int threadInterval;
    private int classInterval;
    private int stackDepthInterval;

    /* GUI Attributes */
    final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
    private Form<?> form;
    private TextField nameField;
    private TextArea descriptionArea;
    private CheckBox cpuCheckbox;
    private CheckBox memoryCheckbox;
    private CheckBox threadCheckbox;
    private CheckBox classCheckbox;
    private CheckBox methodCheckbox;

    private TextField cpuIntervalField;
    private TextField memoryIntervalField;
    private TextField threadIntervalField;
    private TextField classIntervalField;
    private TextField stackDepthField;

    private Button submitButton;

    /**
     *  Constructor
     * */
    public CreateProfilingLevel(final PageParameters parameters, ProfilingLevel level){
        super(parameters);

        if(level == null){
            workLevel = new ProfilingLevel();
            levelName = "";
            levelDescription = "";
            cpuProfiling = false;
            memoryProfiling = false;
            threadProfiling = false;
            classProfiling = false;
            methodProfiling = false;
        }else{
            workLevel = level;
            //System.out.println(level);
            levelName = workLevel.getName();
            levelDescription = workLevel.getDescription();
            cpuProfiling = workLevel.isCpuProfiling();
            memoryProfiling = workLevel.isMemoryProfiling();
            threadProfiling = workLevel.isThreadProfiling();
            classProfiling = workLevel.isClassProfiling();
            methodProfiling = workLevel.isMethodProfiling();

            cpuInterval = workLevel.getCpuInterval();
            memoryInterval = workLevel.getMemoryInterval();
            threadInterval = workLevel.getThreadInterval();
            stackDepthInterval = workLevel.getTraceDepth();
            classInterval = workLevel.getClassInterval();
        }

        form = new Form<Void>("form");
        nameField = new TextField<String>("levelName", new PropertyModel<String>(this, "levelName"));
        nameField.setRequired(true);
        descriptionArea = new TextArea<String>("levelDescription", new PropertyModel<String>(this, "levelDescription"));

        cpuIntervalField = new TextField<Integer>("cpuInterval", new PropertyModel<Integer>(this, "cpuInterval"));
        memoryIntervalField = new TextField<Integer>("memoryInterval", new PropertyModel<Integer>(this, "memoryInterval"));
        classIntervalField = new TextField<Integer>("threadInterval", new PropertyModel<Integer>(this, "threadInterval"));
        threadIntervalField = new TextField<Integer>("classInterval", new PropertyModel<Integer>(this, "classInterval"));
        stackDepthField = new TextField<Integer>("stackDepth", new PropertyModel<Integer>(this, "stackDepthInterval"));

        if(cpuProfiling)
            cpuCheckbox = new CheckBox("cpuCheckbox", Model.of(Boolean.TRUE));
        else
            cpuCheckbox = new CheckBox("cpuCheckbox", Model.of(Boolean.FALSE));

        if(memoryProfiling)
            memoryCheckbox = new CheckBox("memoryCheckbox", Model.of(Boolean.TRUE));
        else
            memoryCheckbox = new CheckBox("memoryCheckbox", Model.of(Boolean.FALSE));

        if(threadProfiling)
            threadCheckbox = new CheckBox("threadCheckbox", Model.of(Boolean.TRUE));
        else
            threadCheckbox = new CheckBox("threadCheckbox", Model.of(Boolean.FALSE));

        if(classProfiling)
            classCheckbox = new CheckBox("classCheckbox", Model.of(Boolean.TRUE));
        else
            classCheckbox = new CheckBox("classCheckbox", Model.of(Boolean.FALSE));
        if(methodProfiling)
            methodCheckbox = new CheckBox("methodCheckbox", Model.of(Boolean.TRUE));
        else
            methodCheckbox = new CheckBox("methodCheckbox", Model.of(Boolean.FALSE));


        submitButton = new Button("submitButton"){

            @Override
            public void onSubmit(){
                //TODO - successMessage
                workLevel.setName(levelName);
                workLevel.setDescription(levelDescription);
                workLevel.setMethodProfiling(methodCheckbox.getModelObject());
                workLevel.setCpuProfiling(cpuCheckbox.getModelObject());
                workLevel.setMemoryProfiling(memoryCheckbox.getModelObject());
                workLevel.setThreadProfiling(threadCheckbox.getModelObject());
                workLevel.setClassProfiling(classCheckbox.getModelObject());
                workLevel.constructLevelInstruction();
                workLevel.setCpuInterval(cpuInterval);
                workLevel.setMemoryInterval(memoryInterval);
                workLevel.setThreadInterval(threadInterval);
                workLevel.setClassInterval(classInterval);
                workLevel.setTraceDepth(stackDepthInterval);
                ProfilingLevel.saveObject(workLevel);
                success("Profiling Level: " + workLevel.getName() + "has been successfully created!");
                setResponsePage(new ProfilingLevelsPage(parameters));
            }
        };

        add(feedbackPanel);
        add(form);

        form.add(nameField);
        form.add(descriptionArea);
        form.add(methodCheckbox);
        form.add(cpuCheckbox);
        form.add(memoryCheckbox);
        form.add(threadCheckbox);
        form.add(classCheckbox);

        form.add(cpuIntervalField);
        form.add(memoryIntervalField);
        form.add(threadIntervalField);
        form.add(classIntervalField);
        form.add(stackDepthField);

        form.add(submitButton);
    }   //constructor end



}
