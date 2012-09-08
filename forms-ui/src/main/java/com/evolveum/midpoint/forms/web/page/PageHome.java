/*
 * Copyright (c) 2012 Evolveum
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://www.opensource.org/licenses/cddl1 or
 * CDDLv1.0.txt file in the source code distribution.
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 *
 * Portions Copyrighted 2012 [name of copyright owner]
 */

package com.evolveum.midpoint.forms.web.page;

import com.evolveum.midpoint.forms.component.button.AjaxLinkButton;
import com.evolveum.midpoint.forms.component.button.AjaxSubmitLinkButton;
import com.evolveum.midpoint.forms.component.tab.FormTabbedPanel;
import com.evolveum.midpoint.forms.component.util.LoadableModel;
import com.evolveum.midpoint.forms.web.MidPointApplication;
import com.evolveum.midpoint.forms.web.forms.FormContextItem;
import com.evolveum.midpoint.forms.web.forms.StructuredForm;
import com.evolveum.midpoint.forms.web.forms.StructuredFormContext;
import com.evolveum.midpoint.forms.web.forms.interpreter.FormResolver;
import com.evolveum.midpoint.forms.web.forms.model.ValueStatus;
import com.evolveum.midpoint.forms.web.page.component.EditorTab;
import com.evolveum.midpoint.forms.web.page.dto.*;
import com.evolveum.midpoint.prism.Item;
import com.evolveum.midpoint.prism.PrismContext;
import com.evolveum.midpoint.prism.PrismObject;
import com.evolveum.midpoint.util.logging.LoggingUtils;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import com.evolveum.midpoint.xml.ns._public.common.common_2.UserType;
import org.apache.commons.io.IOUtils;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.tree.LinkTree;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lazyman
 */
public class PageHome extends PageBase {

    private static final Trace LOGGER = TraceManager.getTrace(PageHome.class);

    private static final String DEFAULT_FORM_NAME = "Form";
    private static final String DEFAULT_VARIABLE_NAME = "Variable";
    private static final String FORM_ID_EDITOR = "editorForm";
    private static final String FORM_ID_STRUCTURED_FORM = "structuredFormForm";
    private static final String ID_TABBED_PANEL = "tabpanel";
    private static final String ID_TREE = "tree";
    private static final String ID_DELTAS = "deltas";

    private LoadableModel<Project> projectModel;
    private LoadableModel<StructuredFormContext> structuredFormModel;
    private IModel<String> deltasModel;

    public PageHome() {
        projectModel = new LoadableModel<Project>(false) {

            @Override
            protected Project load() {
                return new Project();
            }
        };
        structuredFormModel = new LoadableModel<StructuredFormContext>(false) {

            @Override
            protected StructuredFormContext load() {
                return loadStructuredFormContextModel();
            }
        };
    }

    @Override
    protected void initLayout() {
        super.initLayout();
        initTree();

        initButtons();

        initEditorLayout();
        initFormLayout();

        deltasModel = new Model<String>();
        MultiLineLabel deltas = new MultiLineLabel(ID_DELTAS, deltasModel);
        deltas.setOutputMarkupId(true);
        add(deltas);
    }

    private void initTree() {
        LinkTree tree = new LinkTree(ID_TREE, new LoadableModel<TreeModel>() {

            @Override
            public TreeModel load() {
                return createTreeModel();
            }
        }) {
            @Override
            protected void onJunctionLinkClicked(AjaxRequestTarget target, Object node) {
                super.onJunctionLinkClicked(target, node);    //To change body of overridden methods use File | Settings | File Templates.
            }
        };
        tree.getTreeState().expandAll();
        tree.setOutputMarkupId(true);
        add(tree);
    }

    private TreeModel createTreeModel() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Project");
        DefaultMutableTreeNode forms = new DefaultMutableTreeNode("Forms");
        root.add(forms);
        DefaultMutableTreeNode variables = new DefaultMutableTreeNode("Variables");
        root.add(variables);

        Project project = projectModel.getObject();
        for (FormDto form : project.getForms()) {
            forms.add(new DefaultMutableTreeNode(form.getName()));
        }

        for (VariableDto variable : project.getVariables()) {
            variables.add(new DefaultMutableTreeNode(variable.getName()));
        }

        return new DefaultTreeModel(root);
    }

    private void initFormLayout() {
        Form formForm = new Form(FORM_ID_STRUCTURED_FORM);
        formForm.setOutputMarkupId(true);
        add(formForm);

        StructuredForm uiForm = new StructuredForm("structuredForm", structuredFormModel);
        formForm.add(uiForm);

        AjaxSubmitLinkButton save = new AjaxSubmitLinkButton("save", createStringResource("pageHome.button.save")) {

            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                savePerformed(target);
            }

            @Override
            protected void onError(AjaxRequestTarget target, Form<?> form) {
                target.add(getFeedbackPanel());
            }
        };
        formForm.add(save);
    }

    private void initButtons() {
        AjaxLinkButton clear = new AjaxLinkButton("clear",
                createStringResource("pageHome.button.clear")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                clearPerformed(target);
            }
        };
        add(clear);

        AjaxLinkButton loadSample = new AjaxLinkButton("loadSample1",
                createStringResource("pageHome.button.loadSample1")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                loadSample1Performed(target);
            }
        };
        add(loadSample);

        loadSample = new AjaxLinkButton("loadSample2",
                createStringResource("pageHome.button.loadSample2")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                loadSample2Performed(target);
            }
        };
        add(loadSample);

        loadSample = new AjaxLinkButton("loadSample3",
                createStringResource("pageHome.button.loadSample3")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                loadSample3Performed(target);
            }
        };
        add(loadSample);

        loadSample = new AjaxLinkButton("loadSample4",
                createStringResource("pageHome.button.loadSample4")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                loadSample4Performed(target);
            }
        };
        add(loadSample);

        loadSample = new AjaxLinkButton("loadSample5",
                createStringResource("pageHome.button.loadSample5")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                loadSample5Performed(target);
            }
        };
        add(loadSample);
    }

    private void initEditorLayout() {
        Form editorForm = new Form(FORM_ID_EDITOR);
        editorForm.setOutputMarkupId(true);
        add(editorForm);

        List<EditorTab> tabs = loadEditorTabs();
        FormTabbedPanel tabpanel = new FormTabbedPanel(ID_TABBED_PANEL, tabs);
        tabpanel.setOutputMarkupId(true);
        editorForm.add(tabpanel);
        reloadTabs(null);

        initEditorButtons(editorForm);
    }

    private AjaxTabbedPanel getEditorTabPanel() {
        return (AjaxTabbedPanel) get(FORM_ID_EDITOR + ":" + ID_TABBED_PANEL);
    }

    private void initEditorButtons(Form editorForm) {
        AjaxLinkButton addEditor = new AjaxLinkButton("addForm",
                createStringResource("pageHome.button.addForm")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                addFormPerformed(target);
            }
        };
        editorForm.add(addEditor);

        AjaxLinkButton addVariable = new AjaxLinkButton("addVariable",
                createStringResource("pageHome.button.addVariable")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                addVariablePerformed(target);
            }
        };
        editorForm.add(addVariable);

        AjaxLinkButton deleteTab = new AjaxLinkButton("deleteTab",
                createStringResource("pageHome.button.deleteTab")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                deleteTabPerformed(target);
            }
        };
        editorForm.add(deleteTab);

        AjaxSubmitLinkButton reloadForm = new AjaxSubmitLinkButton("reloadForm",
                createStringResource("pageHome.button.reloadForm")) {

            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                reloadFormPerformed(target);
            }

            @Override
            protected void onError(AjaxRequestTarget target, Form<?> form) {
                target.add(getFeedbackPanel());
            }
        };
        editorForm.add(reloadForm);
    }

    private void addFormPerformed(AjaxRequestTarget target) {
        List<FormDto> editors = projectModel.getObject().getForms();
        FormDto editor = new FormDto(DEFAULT_FORM_NAME + " " + (editors.size() + 1));
        editors.add(editor);

        addEditorTab(target, editor);
    }

    private void addVariablePerformed(AjaxRequestTarget target) {
        List<VariableDto> editors = projectModel.getObject().getVariables();
        VariableDto editor = new VariableDto(DEFAULT_VARIABLE_NAME + " " + (editors.size() + 1));
        editors.add(editor);

        addEditorTab(target, editor);
    }

    private void addEditorTab(AjaxRequestTarget target, EditorDto dto) {
        AjaxTabbedPanel panel = getEditorTabPanel();
        panel.getTabs().add(new EditorTab(new Model<EditorDto>(dto)));

        target.add(getEditorTabPanel());
        target.add(get(ID_TREE));
    }

    private void deleteTabPerformed(AjaxRequestTarget target) {
        warn("not implemented yet.");
        target.add(getFeedbackPanel());
    }

    private List<EditorTab> loadEditorTabs() {
        List<EditorTab> tabs = new ArrayList<EditorTab>();

        Project project = projectModel.getObject();
        List<FormDto> forms = project.getForms();
        if (forms.isEmpty()) {
            FormDto form = new FormDto(DEFAULT_FORM_NAME + " " + (forms.size() + 1));
            project.setMainForm(form.getName());
            forms.add(form);
        }
        for (EditorDto editor : forms) {
            tabs.add(new EditorTab(new Model<EditorDto>(editor)));
        }

        List<VariableDto> variables = project.getVariables();
        if (variables.isEmpty()) {
            VariableDto variable = new VariableDto(DEFAULT_VARIABLE_NAME + " " + (variables.size() + 1));
            variables.add(variable);
        }
        for (EditorDto editor : variables) {
            tabs.add(new EditorTab(new Model<EditorDto>(editor)));
        }


        return tabs;
    }

    private void reloadTabs(AjaxRequestTarget target) {
        AjaxTabbedPanel panel = getEditorTabPanel();

        List<ITab> tabs = panel.getTabs();
        tabs.clear();
        tabs.addAll(loadEditorTabs());

        panel.setSelectedTab(0);

        if (target != null) {
            target.add(get(FORM_ID_EDITOR));
        }
    }

    private void clearPerformed(AjaxRequestTarget target) {
        projectModel.reset();

        reloadTabs(target);
        reloadFormPerformed(target);
    }

    private void loadSample1Performed(AjaxRequestTarget target) {
        projectModel.reset();

        Project project = projectModel.getObject();
        project.setMainForm("main");
        FormDto editor = new FormDto("main", loadFileContent("1/userForm.xml"));
        project.getForms().add(editor);

        VariableDto variable = new VariableDto("user", loadFileContent("1/user.xml"));
        project.getVariables().add(variable);

        reloadTabs(target);
        reloadFormPerformed(target);
    }

    private void loadSample3Performed(AjaxRequestTarget target) {
        projectModel.reset();

        Project project = projectModel.getObject();
        project.setMainForm("main");
        FormDto editor = new FormDto("main", loadFileContent("3/main.xml"));
        project.getForms().add(editor);

        VariableDto variable = new VariableDto("user", loadFileContent("3/user.xml"));
        project.getVariables().add(variable);

        reloadTabs(target);
        reloadFormPerformed(target);
    }

    public void loadSample4Performed(AjaxRequestTarget target) {
        projectModel.reset();

        Project project = projectModel.getObject();
        project.setMainForm("main.xml");
        FormDto form = new FormDto("main.xml", loadFileContent("4/main.xml"));
        project.getForms().add(form);

        VariableDto variable = new VariableDto("user", loadFileContent("4/user.xml"));
        project.getVariables().add(variable);

        reloadTabs(target);
        reloadFormPerformed(target);
    }

    public void loadSample5Performed(AjaxRequestTarget target) {
        projectModel.reset();

        Project project = projectModel.getObject();
        project.setMainForm("main.xml");
        FormDto form = new FormDto("main.xml", loadFileContent("5/main.xml"));
        project.getForms().add(form);

        VariableDto variable = new VariableDto("user", loadFileContent("5/user.xml"));
        project.getVariables().add(variable);

        reloadTabs(target);
        reloadFormPerformed(target);
    }

    private void loadSample2Performed(AjaxRequestTarget target) {
        projectModel.reset();

        Project project = projectModel.getObject();
        project.setMainForm("main.xml");
        FormDto form = new FormDto("main.xml", loadFileContent("2/main.xml"));
        project.getForms().add(form);

        form = new FormDto("other.xml", loadFileContent("2/other.xml"));
        project.getForms().add(form);

        VariableDto variable = new VariableDto("user", loadFileContent("2/user.xml"));
        project.getVariables().add(variable);

        reloadTabs(target);
        reloadFormPerformed(target);
    }

    private String loadFileContent(String fileName) {
        String content = null;

        InputStream stream = null;
        try {
            ClassLoader loader = PageHome.class.getClassLoader();
            stream = loader.getResourceAsStream("sample/" + fileName);

            content = IOUtils.toString(stream, "utf-8");
            stream.close();
        } catch (Exception ex) {
            throw new RuntimeException("Unknown error.", ex);
        } finally {
            IOUtils.closeQuietly(stream);
        }

        return content;
    }

    private void reloadFormPerformed(AjaxRequestTarget target) {
        structuredFormModel.reset();

        Form form = (Form) get(FORM_ID_STRUCTURED_FORM);
        form.addOrReplace(new StructuredForm("structuredForm", structuredFormModel));

        target.add(form);
        target.add(getFeedbackPanel());
    }

    private StructuredFormContext loadStructuredFormContextModel() {
        try {
            Project project = projectModel.getObject();

            List<FormDto> forms = project.getForms();
            FormResolver resolver = new EditorFormResolver(forms);

            MidPointApplication app = (MidPointApplication) getApplication();
            PrismContext prismContext = app.getPrismContext();

            Map<String, FormContextItem> objects = new HashMap<String, FormContextItem>();
            List<VariableDto> variables = project.getVariables();
            for (VariableDto variable : variables) {
                if (!variable.isValid()) {
                    continue;
                }
                Item item = prismContext.parseObject(variable.getXml());
                objects.put(variable.getName(), new FormContextItem(item, ValueStatus.EXISTING));
            }

            PrismObject<UserType> owner = null;
            return new StructuredFormContext(project.getMainForm(), owner, objects, resolver);
        } catch (Exception ex) {
            //this feedback won be shown because of it's added to feedback too late...
            error(createMessage(ex, new StringBuilder()));

            ex.printStackTrace();
        }

        return null;
    }

    private String createMessage(Throwable ex, StringBuilder builder) {
        builder.append(ex.getMessage());

        if (ex.getCause() != null) {
            builder.append("Cause by: ");
            builder.append(createMessage(ex.getCause(), builder));
            builder.append(" ");
        }

        return builder.toString();
    }

    private void savePerformed(AjaxRequestTarget target) {
        StructuredFormContext context = structuredFormModel.getObject();
        StringBuilder builder = new StringBuilder();

        Map<String, FormContextItem> objects = context.getObjects();
        for (String key : objects.keySet()) {
            builder.append("Key '").append(key).append("'\n");
            try {
                builder.append(context.getObjectDelta(key).debugDump(3)).append('\n');
            } catch (Exception ex) {
                builder.append("error: ").append(ex.getMessage()).append('\n');
                LoggingUtils.logException(LOGGER, "Couldn't create delta", ex);

                error(ex.getMessage());
            }
            builder.append('\n');
        }

        deltasModel.setObject(builder.toString());
        target.add(getFeedbackPanel(), get("deltas"));
    }
}
