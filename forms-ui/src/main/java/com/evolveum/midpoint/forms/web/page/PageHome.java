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
import com.evolveum.midpoint.forms.component.util.LoadableModel;
import com.evolveum.midpoint.forms.web.MidPointApplication;
import com.evolveum.midpoint.forms.web.forms.StructuredForm;
import com.evolveum.midpoint.forms.web.forms.StructuredFormContext;
import com.evolveum.midpoint.forms.web.forms.interpreter.FormResolver;
import com.evolveum.midpoint.forms.web.page.component.EditorTab;
import com.evolveum.midpoint.forms.web.page.dto.Editor;
import com.evolveum.midpoint.forms.web.page.dto.EditorFormResolver;
import com.evolveum.midpoint.forms.web.page.dto.Project;
import com.evolveum.midpoint.forms.web.page.dto.Variable;
import com.evolveum.midpoint.prism.Item;
import com.evolveum.midpoint.prism.PrismContext;
import com.evolveum.midpoint.prism.PrismObject;
import com.evolveum.midpoint.xml.ns._public.common.common_2.UserType;
import org.apache.commons.io.IOUtils;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lazyman
 */
public class PageHome extends PageBase {

    private static final String DEFAULT_FORM_NAME = "Unknown";
    private static final String FORM_ID_EDITOR = "editorForm";
    private static final String FORM_ID_VARIABLES = "variablesForm";
    private static final String FORM_ID_STRUCTURED_FORM = "structuredFormForm";

    private LoadableModel<Project> projectModel;
    private LoadableModel<StructuredFormContext> structuredFormModel;

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

        initButtons();

        initEditorLayout();
        initVariablesLayout();
        initFormLayout();
    }

    private void initVariablesLayout() {
        Form variablesForm = new Form(FORM_ID_VARIABLES);
        add(variablesForm);
    }

    private void initFormLayout() {
        Form formForm = new Form(FORM_ID_STRUCTURED_FORM);
        formForm.setOutputMarkupId(true);
        add(formForm);

        StructuredForm uiForm = new StructuredForm("structuredForm", structuredFormModel);
        formForm.add(uiForm);
    }

    private void initButtons() {
        AjaxLinkButton loadSample = new AjaxLinkButton("loadSample",
                createStringResource("pageHome.button.loadSample")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                loadSamplePerformed(target);
            }
        };
        add(loadSample);
    }

    private void initEditorLayout() {
        Form editorForm = new Form(FORM_ID_EDITOR);
        editorForm.setOutputMarkupId(true);
        add(editorForm);

        List<ITab> tabs = loadTabs();
        AjaxTabbedPanel<EditorTab> tabpanel = new AjaxTabbedPanel("tabpanel", tabs);
        tabpanel.setOutputMarkupId(true);
        editorForm.add(tabpanel);
        reloadTabs(null);

        initEditorButtons(editorForm);
    }

    private AjaxTabbedPanel getEditorTabPanel() {
        return (AjaxTabbedPanel) get(FORM_ID_EDITOR + ":tabpanel");
    }

    private void initEditorButtons(Form editorForm) {
        AjaxLinkButton addEditor = new AjaxLinkButton("addEditor",
                createStringResource("pageHome.button.addEditor")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                addEditorPerformed(target);
            }
        };
        editorForm.add(addEditor);

        AjaxSubmitLinkButton reloadForm = new AjaxSubmitLinkButton("reloadForm",
                createStringResource("pageHome.button.reloadForm")) {

            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                reloadFormPeformed(target);
            }

            @Override
            protected void onError(AjaxRequestTarget target, Form<?> form) {
                target.add(getFeedbackPanel());
            }
        };
        editorForm.add(reloadForm);
    }

    private void addEditorPerformed(AjaxRequestTarget target) {
        List<Editor> editors = projectModel.getObject().getEditors();
        Editor editor = new Editor(DEFAULT_FORM_NAME + (editors.size() + 1));
        editors.add(editor);

        AjaxTabbedPanel panel = getEditorTabPanel();
        panel.getTabs().add(new EditorTab(new Model<Editor>(editor)));

        target.add(getEditorTabPanel());
    }

    private List<ITab> loadTabs() {
        List<ITab> tabs = new ArrayList<ITab>();

        Project project = projectModel.getObject();
        List<Editor> editors = project.getEditors();
        if (editors.isEmpty()) {
            Editor editor = new Editor(DEFAULT_FORM_NAME + (editors.size() + 1));
            editor.setMain(true);
            editors.add(editor);
        }

        for (Editor editor : editors) {
            tabs.add(new EditorTab(new Model<Editor>(editor)));
        }

        return tabs;
    }

    private void reloadTabs(AjaxRequestTarget target) {
        AjaxTabbedPanel panel = getEditorTabPanel();

        List<ITab> tabs = panel.getTabs();
        tabs.clear();
        tabs.addAll(loadTabs());

        panel.setSelectedTab(0);

        if (target != null) {
            target.add(get(FORM_ID_EDITOR));
        }
    }

    private void loadSamplePerformed(AjaxRequestTarget target) {
        projectModel.reset();

        Project project = projectModel.getObject();
        Editor editor = new Editor();
        editor.setFormIdentifier(DEFAULT_FORM_NAME);
        editor.setMain(true);
        editor.setXml(loadFileContent("userForm.xml"));
        project.getEditors().add(editor);

        Variable variable = new Variable();
        variable.setName("user");
        variable.setXml(loadFileContent("user.xml"));
        project.getVariables().add(variable);

        reloadTabs(target);
        reloadFormPeformed(target);
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

    private void reloadFormPeformed(AjaxRequestTarget target) {
        structuredFormModel.reset();

        Form form = (Form) get(FORM_ID_STRUCTURED_FORM);
        form.addOrReplace(new StructuredForm("structuredForm", structuredFormModel));

        target.add(form);
    }

    private StructuredFormContext loadStructuredFormContextModel() {
        try {
            Project project = projectModel.getObject();

            List<Editor> editors = project.getEditors();
            FormResolver resolver = new EditorFormResolver(editors);

            MidPointApplication app = (MidPointApplication) getApplication();
            PrismContext prismContext = app.getPrismContext();

            Map<String, Item> objects = new HashMap<String, Item>();
            List<Variable> variables = project.getVariables();
            for (Variable variable : variables) {
                Item item = prismContext.parseObject(variable.getXml());
                objects.put(variable.getName(), item);
            }

            PrismObject<UserType> owner = null;
            return new StructuredFormContext(owner, objects, resolver);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Unknown error.", ex);
        }
    }
}
