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
import com.evolveum.midpoint.forms.web.forms.model.FieldGroupModel;
import com.evolveum.midpoint.forms.web.forms.model.FieldLoopModel;
import com.evolveum.midpoint.forms.web.forms.model.FieldModel;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * @author lazyman
 */
public class LineListView<T extends BaseFieldModel> extends ListView<T> {

    public static final String LINE_BODY = "line";

    public LineListView(String id, IModel<List<T>> model) {
        super(id, model);
    }

    @Override
    protected void populateItem(ListItem<T> listItem) {
        T object = listItem.getModelObject();
        Component component;
//        if (object instanceof FieldModel) {
//            component = new UiField(LINE_BODY, (IModel) item.getModel());
//        } else if (object instanceof FieldGroupModel) {
//            component = new UiFieldGroup(LINE_BODY, (IModel) item.getModel());
//        } else if (object instanceof FieldLoopModel) {
//            component = new UiFieldLoop(LINE_BODY, (IModel) item.getModel());
//        } else {
            //todo error handling
            component = new Label(LINE_BODY, "Unknown component type....");
//        }
        listItem.add(component);
    }
}
