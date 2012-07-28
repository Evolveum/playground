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

import com.evolveum.midpoint.forms.web.forms.model.FormModel;
import com.evolveum.midpoint.forms.web.forms.model.LineModel;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.PackageResourceReference;

import java.io.Serializable;
import java.util.List;

/**
 * @author lazyman
 */
public class UiForm extends UiComponent<FormModel> {

    private static final String THEME_FOLDER = "theme/";

    public UiForm(String id, IModel<FormModel> model) {
        super(id, model);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        String theme = "UiClean"; //todo get theme from form model -> form token -> form type
        response.renderCSSReference(new PackageResourceReference(UiForm.class, THEME_FOLDER + theme + ".css"));
    }

    @Override
    protected void initLayout() {
        ListView<LineModel> line = new ListView<LineModel>("line", createLineModel()) {

            @Override
            protected void populateItem(ListItem item) {
                item.add(new Label("lineBody", new Model<Serializable>("asdf")));
                //todo create fields, field groups, field loops
            }
        };
        add(line);
    }

    private IModel<List<LineModel>> createLineModel() {
        return new AbstractReadOnlyModel<List<LineModel>>() {

            @Override
            public List<LineModel> getObject() {
                FormModel formModel = model.getObject();

                return LineModel.createLineModels(formModel, formModel.getBaseFieldModels());
            }
        };
    }
}
