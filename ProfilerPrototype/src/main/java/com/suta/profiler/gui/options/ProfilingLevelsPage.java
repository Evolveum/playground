package com.suta.profiler.gui.options;

import com.suta.profiler.Attributes;
import com.suta.profiler.gui.util.ProfilingPage;
import com.suta.profiler.types.ProfilingLevel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.ArrayList;
import java.util.List;

/**
 *  Ah i really don't want to write anything in here
 *
 *  @author
 * */
public class ProfilingLevelsPage extends ProfilingPage{

    /* Attributes */
    List<ProfilingLevel> profilingLevelList = new ArrayList<ProfilingLevel>();
    //ProfilingLevel level;
    private String methodText;
    private String cpuText;
    private String memoryText;
    private String threadText;
    private String classText;

    /* GUI attributes */

    /**
     *  Constructor
     * */
    public ProfilingLevelsPage(final PageParameters parameters){
        super(parameters);

        profilingLevelList = ProfilingLevel.retrieveProfilingLevels();

        /**
         *  Populate table with list of ProfilingLevel type
         * */
        ListView levelListView = new ListView<ProfilingLevel>("levelList", profilingLevelList) {

            @Override
            protected void populateItem(ListItem listItem) {
                final ProfilingLevel level = (ProfilingLevel)listItem.getModelObject();
                //System.out.println("Instruction: " + level.getLevelInstruction());

                if(level.isCpuProfiling())
                    cpuText = "yes["+level.getCpuInterval()+"]";
                else
                    cpuText = "no["+level.getCpuInterval()+"]";
                if(level.isMemoryProfiling())
                    memoryText = "yes["+level.getMemoryInterval()+"]";
                else
                    memoryText = "no["+level.getMemoryInterval()+"]";
                if(level.isThreadProfiling())
                    threadText = "yes["+level.getThreadInterval()+"]["+level.getTraceDepth()+"]";
                else
                    threadText = "no["+level.getThreadInterval()+"]["+level.getTraceDepth()+"]";
                if(level.isClassProfiling())
                    classText = "yes["+level.getClassInterval()+"]";
                else
                    classText = "no["+level.getClassInterval()+"]";
                if(level.isMethodProfiling())
                    methodText = "yes";
                else
                    methodText = "no";

                listItem.add(new Label("levelName", level.getName()));
                listItem.add(new Label("levelDescription", level.getDescription()));
                listItem.add(new Label("methodProfiling", methodText));
                listItem.add(new Label("cpuProfiling", cpuText));
                listItem.add(new Label("memoryProfiling",memoryText));
                listItem.add(new Label("ThreadProfiling",threadText));
                listItem.add(new Label("classProfiling",classText));

                //editOption
                listItem.add(new Link("editButton") {

                    @Override
                    public void onClick(){
                        setResponsePage(new CreateProfilingLevel(parameters, level));
                    }
                });

                //deleteOption
                listItem.add(new Link("deleteButton") {

                    @Override
                    public void onClick(){
                        level.deleteLevel(level);
                        setResponsePage(new ProfilingLevelsPage(parameters));
                    }
                });
            }
        };  //scenarioListView end

        add(levelListView);

    }   //constructor end


}
