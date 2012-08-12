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

import com.evolveum.midpoint.forms.web.forms.model.*;
import org.apache.commons.lang.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

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

        //todo get theme from form model -> form token -> form type
        String theme = null;

        if (StringUtils.isEmpty(theme)) {
            theme = "UiClean";
        }

        ResourceReference ref = new PackageResourceReference(UiForm.class, THEME_FOLDER + theme + ".css");
        response.renderCSSReference(ref);
    }

    @Override
    protected void initLayout() {
//        LineListView line = new LineListView("line", createLineModel());
//        add(line);
        ListView<LineModel> line = new ListView<LineModel>("line", createLineModel()) {

            @Override
            protected void populateItem(ListItem<LineModel> listItem) {
                ListView<DisplayableModel> field = new ListView<DisplayableModel>("field",
                        new PropertyModel<List<? extends DisplayableModel>>(listItem.getModel(), "fields")) {

                    @Override
                    protected void populateItem(ListItem<DisplayableModel> listItem) {
                        DisplayableModel displayable =  listItem.getModelObject();
                        if (displayable instanceof FieldModel) {
                            listItem.add(new AttributeModifier("class", "UiField"));
//                            component = new UiField(LINE_BODY, (IModel) item.getModel());
                        } else if (displayable instanceof FieldGroupModel) {
                            listItem.add(new AttributeModifier("class", "UiFieldGroup"));
//                            component = new UiFieldGroup(LINE_BODY, (IModel) item.getModel());
                        } else if (displayable instanceof FieldLoopModel) {
                            listItem.add(new AttributeModifier("class", "UiFieldLoop"));
//                            component = new UiFieldLoop(LINE_BODY, (IModel) item.getModel());
                        } else {
                            //todo error handling

                        }
                    }
                };
                listItem.add(field);
            }
        };
        add(line);
    }

    private IModel<List<LineModel>> createLineModel() {
        return new AbstractReadOnlyModel<List<LineModel>>() {

            @Override
            public List<LineModel> getObject() {
                FormModel formModel = model.getObject();

                return formModel.getLines();
            }
        };
    }
}
