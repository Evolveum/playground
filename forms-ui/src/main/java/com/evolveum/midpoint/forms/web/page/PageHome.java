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

import com.evolveum.midpoint.forms.component.ace.AceEditor;
import com.evolveum.midpoint.forms.web.MidPointApplication;
import com.evolveum.midpoint.forms.web.forms.StructuredForm;
import com.evolveum.midpoint.forms.web.forms.StructuredFormContext;
import com.evolveum.midpoint.forms.web.forms.interpreter.DefaultFormResolver;
import com.evolveum.midpoint.forms.web.forms.interpreter.FormInterpreter;
import com.evolveum.midpoint.forms.web.forms.interpreter.FormResolver;
import com.evolveum.midpoint.forms.web.forms.model.FormModel;
import com.evolveum.midpoint.forms.web.forms.object.FormToken;
import com.evolveum.midpoint.forms.web.forms.ui.UiForm;
import com.evolveum.midpoint.forms.web.model.Editor;
import com.evolveum.midpoint.forms.web.page.component.EditorPanel;
import com.evolveum.midpoint.prism.Item;
import com.evolveum.midpoint.prism.PrismContext;
import com.evolveum.midpoint.prism.PrismObject;
import com.evolveum.midpoint.xml.ns._public.common.common_2.UserType;
import org.apache.wicket.Component;
import org.apache.wicket.devutils.debugbar.DebugBar;
import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.TabbedPanel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lazyman
 */
public class PageHome extends WebPage {

    public PageHome() {
        initLayout();
    }

    private void initLayout() {
        DebugBar debugPanel = new DebugBar("debugPanel");
        add(debugPanel);

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

                    MidPointApplication app = (MidPointApplication)getApplication();
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

        StructuredForm uiForm = new StructuredForm("structuredForm", model);
        mainForm.add(uiForm);

        List<EditorTab> tabs = new ArrayList<EditorTab>();
        Editor editor = new Editor();
        editor.setFileName("mainForm.xml");
        tabs.add(new EditorTab(new Model<Editor>(editor)));

        editor = new Editor();
        editor.setFileName("otherForm");
        tabs.add(new EditorTab(new Model<Editor>(editor)));

        AjaxTabbedPanel<EditorTab> tabpanel = new AjaxTabbedPanel("tabpanel", tabs);
        mainForm.add(tabpanel);
    }

    public static class EditorTab extends AbstractTab {

        private IModel<Editor> model;

        public EditorTab(IModel<Editor> model) {
            super(new PropertyModel<String>(model, "fileName"));
            this.model = model;
        }

        @Override
        public WebMarkupContainer getPanel(String panelId) {
            return new EditorPanel(panelId, model);
        }
    }
}
