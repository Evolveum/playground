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

package com.evolveum.midpoint.forms.web.forms.ui;

import com.evolveum.midpoint.forms.web.forms.model.BaseFieldModel;
import com.evolveum.midpoint.forms.web.forms.model.FormModel;
import org.apache.commons.lang.Validate;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.PackageResourceReference;

import java.util.List;

/**
 * @author lazyman
 */
public class UiForm extends Panel {

    private static final String THEME_FOLDER = "theme/";
    private IModel<FormModel> model;
    private boolean initialized;

    public UiForm(String id, IModel<FormModel> model) {
        super(id);
        Validate.notNull(model, "Form model must not be null.");

        this.model = model;
    }

    @Override
    protected void onBeforeRender() {
        super.onBeforeRender();

        if (!initialized) {
            initLayout();
            initialized = true;
        }
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        String theme = "UiClean"; //todo get theme from form model -> form token -> form type
        response.renderCSSReference(new PackageResourceReference(UiForm.class, THEME_FOLDER + theme + ".css"));
    }

    private void initLayout() {
        ListView line = new ListView("line", createLineModel()) {

            @Override
            protected void populateItem(ListItem item) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
        add(line);
    }

    private IModel<List<BaseFieldModel>> createLineModel() {
        return new AbstractReadOnlyModel<List<BaseFieldModel>>() {

            @Override
            public List<BaseFieldModel> getObject() {
                FormModel formModel = model.getObject();
                return formModel.getBaseFieldModels();
            }
        };
    }
}
