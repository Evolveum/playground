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
import com.evolveum.midpoint.forms.impl.model.ItemStatus;
import com.evolveum.midpoint.forms.web.MidPointApplication;
import com.evolveum.midpoint.forms.impl.FormContextItem;
import com.evolveum.midpoint.forms.impl.StructuredForm;
import com.evolveum.midpoint.forms.impl.StructuredFormContext;
import com.evolveum.midpoint.forms.impl.interpreter.FormResolver;
import com.evolveum.midpoint.forms.web.page.component.EditorTab;
import com.evolveum.midpoint.forms.web.page.dto.*;
import com.evolveum.midpoint.gui.common.LoadableModel;
import com.evolveum.midpoint.prism.Item;
import com.evolveum.midpoint.prism.PrismContext;
import com.evolveum.midpoint.prism.PrismObject;
import com.evolveum.midpoint.util.logging.LoggingUtils;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import com.evolveum.midpoint.xml.ns._public.common.common_2.UserType;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.tree.LinkTree;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * @author lazyman
 */
public class PageHome extends PageBase {

    private static final Trace LOGGER = TraceManager.getTrace(PageHome.class);

    private static final String SAMPLE_FOLDER = "sample";
    private static final String SAMPLE_PROPERTIES = "sample.properties";

    private static final String PROPERTY_NAME = "name";
    private static final String PROPERTY_DESCRIPTION = "description";
    private static final String PROPERTY_VARIABLE = "variable";
    private static final String PROPERTY_FORMS = "forms";
    private static final String PROPERTY_MAIN_FORM = "mainForm";

    private static final String DEFAULT_FORM_NAME = "Form";
    private static final String DEFAULT_VARIABLE_NAME = "Variable";
    private static final String FORM_ID_EDITOR = "editorForm";
    private static final String FORM_ID_STRUCTURED_FORM = "structuredFormForm";
    private static final String ID_TABBED_PANEL = "tabpanel";
    private static final String ID_TREE = "tree";
    private static final String ID_DELTAS = "deltas";
    private static final String ID_LOAD_SAMPLE = "loadSample";
    private static final String ID_CLEAR = "clear";
    private static final String ID_SAMPLE_COMBO = "sampleCombo";
    private static final String ID_MENU_FORM = "menuForm";

    private IModel<List<SampleDto>> samplesModel;

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
        samplesModel = new LoadableModel<List<SampleDto>>(false) {

            @Override
            protected List<SampleDto> load() {
                return loadSampleList();
            }
        };
    }

    private List<SampleDto> loadSampleList() {
        List<SampleDto> samples = new ArrayList<SampleDto>();

        try {
            ClassLoader loader = PageHome.class.getClassLoader();
            URL url = loader.getResource(SAMPLE_FOLDER);

            File root = new File(url.toURI());
            File[] sampleFolders = root.listFiles(new FileFilter() {

                @Override
                public boolean accept(File file) {
                    if (!file.isDirectory()) {
                        return false;
                    }

                    return true;
                }
            });

            for (File sampleFolder : sampleFolders) {
                SampleDto dto = createSample(sampleFolder);
                if (dto == null) {
                    continue;
                }
                samples.add(dto);
            }
        } catch (Exception ex) {
            LoggingUtils.logException(LOGGER, "Couldn't load samples", ex);
        }

        Collections.sort(samples);

        return samples;
    }

    private SampleDto createSample(File sampleFolder) throws Exception {
        SampleDto dto = new SampleDto();
        dto.setSamplePath(sampleFolder.getName());

        Properties properties = new Properties();
        ClassLoader loader = PageHome.class.getClassLoader();
        InputStream stream = loader.getResourceAsStream(SAMPLE_FOLDER + "/"
                + sampleFolder.getName() + "/" + SAMPLE_PROPERTIES);
        if (stream == null) {
            return null;
        }
        properties.load(stream);

        dto.setName(properties.getProperty(PROPERTY_NAME));
        if (StringUtils.isEmpty(dto.getName())) {
            dto.setName(sampleFolder.getName());
        }
        dto.setDescription(properties.getProperty(PROPERTY_DESCRIPTION));
        dto.setMainForm(properties.getProperty(PROPERTY_MAIN_FORM));

        for (Object object : properties.keySet()) {
            String key = (String) object;
            if (!key.startsWith(PROPERTY_VARIABLE)) {
                continue;
            }

            String name = key.replace(PROPERTY_VARIABLE + ".", "");
            dto.getVariables().put(name, properties.getProperty(key).trim());
        }

        String formsProperty = (String) properties.get(PROPERTY_FORMS);
        if (StringUtils.isEmpty(formsProperty)) {
            return dto;
        }

        String[] forms = formsProperty.split(",");
        for (String form : forms) {
            String trimmedForm = form.trim();
            dto.getForms().add(trimmedForm);
        }

        return dto;
    }

    @Override
    protected void initLayout() {
        super.initLayout();

        initMenuLayout();
        initTree();

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
                super.onJunctionLinkClicked(target, node);
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

    private void initMenuLayout() {
        Form menuForm = new Form(ID_MENU_FORM);
        menuForm.setOutputMarkupId(true);
        add(menuForm);

        DropDownChoice sampleCombo = new DropDownChoice(ID_SAMPLE_COMBO, new Model(), samplesModel,
                new IChoiceRenderer<SampleDto>() {

                    @Override
                    public Object getDisplayValue(SampleDto object) {
                        return object.getName();
                    }

                    @Override
                    public String getIdValue(SampleDto object, int index) {
                        return Integer.toString(index);
                    }
                });
        menuForm.add(sampleCombo);


        AjaxLinkButton clear = new AjaxLinkButton(ID_CLEAR,
                createStringResource("pageHome.button.clear")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                clearPerformed(target);
            }
        };
        menuForm.add(clear);

        AjaxSubmitLinkButton loadSample = new AjaxSubmitLinkButton(ID_LOAD_SAMPLE,
                createStringResource("pageHome.button.loadSample")) {

            @Override
            protected void onError(AjaxRequestTarget target, Form<?> form) {
                target.add(getFeedbackPanel());
            }

            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                loadSamplePerformed(target);
            }
        };
        menuForm.add(loadSample);
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
        DropDownChoice<SampleDto> sampleCombo = (DropDownChoice) get(ID_MENU_FORM + ":" + ID_SAMPLE_COMBO);
        sampleCombo.getModel().setObject(null);
        target.add(get(ID_MENU_FORM));


        projectModel.reset();

        reloadTabs(target);
        reloadFormPerformed(target);
    }

    private void loadSamplePerformed(AjaxRequestTarget target) {
        DropDownChoice<SampleDto> sampleCombo = (DropDownChoice) get(ID_MENU_FORM + ":" + ID_SAMPLE_COMBO);
        SampleDto dto = sampleCombo.getModelObject();

        projectModel.reset();
        Project project = projectModel.getObject();
        project.setMainForm(dto.getMainForm());

        String path = dto.getSamplePath() + "/";

        for (String form : dto.getForms()) {
            project.getForms().add(new FormDto(form, loadFileContent(path + form)));
        }

        for (Map.Entry<String, String> entry : dto.getVariables().entrySet()) {
            project.getVariables().add(new VariableDto(entry.getKey(), loadFileContent(path + entry.getValue())));
        }

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
            stream = loader.getResourceAsStream(SAMPLE_FOLDER + "/" + fileName);

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
                objects.put(variable.getName(), new FormContextItem(item, ItemStatus.EXISTING));
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
