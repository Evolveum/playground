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
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.util.List;

/**
 * @author lazyman
 */
public class LineListView extends Panel {

    private static final String ID_FIELD = "field";

    public LineListView(String id, IModel<List<LineModel>> model) {
        super(id);
        setRenderBodyOnly(true);

        initLayout(model);
    }

    private void initLayout(IModel<List<LineModel>> model) {
        ListView<LineModel> line = new ListView<LineModel>("line", model) {

            @Override
            protected void populateItem(ListItem<LineModel> components) {
                populateLineItem(components);
            }
        };
        add(line);
    }

    private void populateLineItem(ListItem<LineModel> listItem) {
        ListView<DisplayableModel> fields = new ListView<DisplayableModel>("fields",
                new PropertyModel<List<? extends DisplayableModel>>(listItem.getModel(), "fields")) {

            @Override
            protected void populateItem(ListItem<DisplayableModel> listItem) {
                listItem.setRenderBodyOnly(true);

                DisplayableModel displayable = listItem.getModelObject();
                Component field;
                if (displayable instanceof FieldModel) {
                    field = new UiField(ID_FIELD, (IModel) listItem.getModel());
                } else if (displayable instanceof FieldGroupModel) {
                    field = new UiFieldGroup(ID_FIELD, (IModel) listItem.getModel());
                } else if (displayable instanceof FieldLoopModel) {
                    field = new UiFieldLoop(ID_FIELD, (IModel) listItem.getModel());
                } else {
                    field = UiFactory.createErrorLabel(ID_FIELD, new Model<String>("error"));

                }

                field.setRenderBodyOnly(true);
                listItem.add(field);
            }
        };
        listItem.add(fields);
    }
}
