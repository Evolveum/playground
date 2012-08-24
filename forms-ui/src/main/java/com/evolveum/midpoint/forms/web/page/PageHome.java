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
import com.evolveum.midpoint.forms.component.util.LoadableModel;
import com.evolveum.midpoint.forms.web.MidPointApplication;
import com.evolveum.midpoint.forms.web.forms.StructuredForm;
import com.evolveum.midpoint.forms.web.forms.StructuredFormContext;
import com.evolveum.midpoint.forms.web.forms.interpreter.DefaultFormResolver;
import com.evolveum.midpoint.forms.web.forms.interpreter.FormResolver;
import com.evolveum.midpoint.forms.web.page.component.EditorTab;
import com.evolveum.midpoint.forms.web.page.dto.Editor;
import com.evolveum.midpoint.forms.web.page.dto.Project;
import com.evolveum.midpoint.prism.Item;
import com.evolveum.midpoint.prism.PrismObject;
import com.evolveum.midpoint.xml.ns._public.common.common_2.UserType;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lazyman
 */
public class PageHome extends PageBase {

    private LoadableModel<Project> model;

    public PageHome() {
        model = new LoadableModel<Project>(false) {

            @Override
            protected Project load() {
                return new Project();
            }
        };
    }

    @Override
    protected void initLayout() {
        super.initLayout();

        Form mainForm = new Form("mainForm");
        add(mainForm);

        IModel<StructuredFormContext> model = new LoadableDetachableModel<StructuredFormContext>() {

            @Override
            protected StructuredFormContext load() {
                try {
                    ClassLoader loader = PageHome.class.getClassLoader();
                    URL url = loader.getResource("sample");
                    File file = new File(url.toURI());

                    File userFile = new File(file, "user.xml");

                    MidPointApplication app = (MidPointApplication) getApplication();
                    PrismObject<UserType> user = app.getPrismContext().parseObject(userFile);

                    Map<String, Item> objects = new HashMap<String, Item>();
                    objects.put("user", user);

                    File formFile = new File(file, "userForm.xml");
                    FormResolver resolver = new DefaultFormResolver(formFile.getAbsolutePath());

                    return new StructuredFormContext(user, objects, resolver);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new RuntimeException("Unknown error.", ex);
                }
            }
        };

        StructuredForm uiForm = new StructuredForm("sampleStructuredForm", model);
        mainForm.add(uiForm);

        initButtons(mainForm);

        initEditorLayout();
        initVariablesLayout();
        initFormLayout();
    }

    private void initVariablesLayout() {
        Form variablesForm = new Form("variablesForm");
        add(variablesForm);
    }

    private void initFormLayout() {
        Form formForm = new Form("formForm");
        add(formForm);

        StructuredForm uiForm = new StructuredForm("structuredForm", new Model<StructuredFormContext>());
        formForm.add(uiForm);
    }

    private void initButtons(Form mainForm) {
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
        Form editorForm = new Form("editorForm");
        add(editorForm);

        AjaxTabbedPanel<EditorTab> tabpanel = new AjaxTabbedPanel("tabpanel", new ArrayList());
        Editor editor = new Editor("Unknown 1");
        model.getObject().getEditors().add(editor);
        tabpanel.getTabs().add(new EditorTab(new Model<Editor>(editor)));

        tabpanel.setOutputMarkupId(true);
        editorForm.add(tabpanel);

        initEditorButtons(editorForm);
    }

    private AjaxTabbedPanel getEditorTabPanel() {
        return (AjaxTabbedPanel) get("mainForm:tabpanel");
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
    }

    private void addEditorPerformed(AjaxRequestTarget target) {
        List<Editor> editors = model.getObject().getEditors();
        Editor editor = new Editor("Unknown " + (editors.size() + 1));
        editors.add(editor);

        AjaxTabbedPanel panel = getEditorTabPanel();
        panel.getTabs().add(new EditorTab(new Model<Editor>(editor)));

        target.add(getEditorTabPanel());
    }

    private void loadSamplePerformed(AjaxRequestTarget target) {
        model.reset();
        //todo implement
    }
}
