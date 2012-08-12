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

import com.evolveum.midpoint.forms.web.forms.model.DisplayableModel;
import com.evolveum.midpoint.forms.web.forms.model.LineModel;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import java.util.List;

/**
 * @author lazyman
 */
public class LineListView extends ListView<LineModel> {

    public LineListView(String id, IModel<List<LineModel>> model) {
        super(id, model);
    }

    @Override
    protected void populateItem(ListItem<LineModel> listItem) {
        ListView<DisplayableModel> line = new ListView<DisplayableModel>("line",
                new PropertyModel<List<? extends DisplayableModel>>(listItem.getModel(), "baseFieldModels")) {

            @Override
            protected void populateItem(ListItem<DisplayableModel> listItem) {
                populateFields(listItem);
            }
        };
        listItem.add(line);
    }

    private void populateFields(ListItem<DisplayableModel> listItem) {
        Component component;
//        if (object instanceof FieldModel) {
//            component = new UiField(LINE_BODY, (IModel) item.getModel());
//        } else if (object instanceof FieldGroupModel) {
//            component = new UiFieldGroup(LINE_BODY, (IModel) item.getModel());
//        } else if (object instanceof FieldLoopModel) {
//            component = new UiFieldLoop(LINE_BODY, (IModel) item.getModel());
//        } else {
        //todo error handling
        component = new Label("field", "Unknown component type....");
//        }
        listItem.add(component);
    }
}
