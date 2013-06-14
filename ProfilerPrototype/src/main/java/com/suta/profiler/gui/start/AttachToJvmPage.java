package com.suta.profiler.gui.start;

import com.suta.profiler.gui.util.ProfilingPage;
import com.suta.profiler.types.JavaVirtualMachineType;
import com.suta.profiler.types.ProjectType;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class AttachToJvmPage extends ProfilingPage {

    /* Attributes */
    ProjectType actProject;

    /**
     *  Constructor
     * */
    public AttachToJvmPage(final PageParameters parameters, ProjectType project){
        super(parameters);
        actProject = project;

        JavaVirtualMachineType.scanRunningJVMList();

        /**
         *  List of JVMs
         * */
        ListView jvms = new ListView<JavaVirtualMachineType>("jvms", JavaVirtualMachineType.jvmList) {

            @Override
            protected void populateItem(ListItem listItem) {
                final JavaVirtualMachineType jvm = (JavaVirtualMachineType)listItem.getModelObject();
                //TODO - jvm name should never be empty - FIX THIS
                listItem.add(new Label("jvmName", jvm.getDisplayName()));
                listItem.add(new Label("jvmId", jvm.getId()));

                //launch option
                listItem.add(new Link<JavaVirtualMachineType>("select", listItem.getModel()) {

                    @Override
                    public void onClick(){
                        actProject.setPid(jvm.getId());
                        setResponsePage(new NewProjectPage(parameters, actProject, true));
                    }
                });
            }
        };
        add(jvms);

        // End of JVM list
        //TODO - make list of JVM refresh dynamically with AJAX
        add(new Link("refreshJVM") {

            @Override
            public void onClick(){
                JavaVirtualMachineType.jvmList.removeAll(JavaVirtualMachineType.jvmList);
                setResponsePage(new AttachToJvmPage(parameters, actProject));
            }
        });

    }
    //  Constructor end
}
