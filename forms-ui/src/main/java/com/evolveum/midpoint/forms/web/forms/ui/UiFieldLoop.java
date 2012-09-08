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
import com.evolveum.midpoint.forms.web.forms.model.FieldLoopItemModel;
import com.evolveum.midpoint.forms.web.forms.model.FieldLoopModel;
import com.evolveum.midpoint.forms.web.forms.model.LineModel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazyman
 */
public class UiFieldLoop extends UiComponent<FieldLoopModel> {

    private static final String ID_MAIN = "main";
    private static final String ID_LOOP_TITLE = "loopTitle";
    private static final String ID_LOOP_ITEM = "loopItem";
    private static final String ID_LINE = "line";

    public UiFieldLoop(String id, IModel<FieldLoopModel> model) {
        super(id, model);
    }

    @Override
    protected void initLayout() {
        WebMarkupContainer main = new WebMarkupContainer(ID_MAIN);
        add(main);

        Label groupTitle = new Label(ID_LOOP_TITLE, new PropertyModel<String>(model, "defaultDisplay.label"));
        main.add(groupTitle);

        ListView<FieldLoopItemModel> loopItem = new ListView<FieldLoopItemModel>(ID_LOOP_ITEM, createLoopItemModel()) {

            @Override
            protected void populateItem(ListItem<FieldLoopItemModel> listItem) {
                listItem.add(new LineListView(ID_LINE, createLineModel(listItem.getModel())));
            }
        };
        main.add(loopItem);
    }

    private IModel<List<FieldLoopItemModel>> createLoopItemModel() {
        return new AbstractReadOnlyModel<List<FieldLoopItemModel>>() {

            @Override
            public List<FieldLoopItemModel> getObject() {
                FieldLoopModel loopModel = model.getObject();

                //todo fix this list copying - problem with casting. FieldLoopModel must return List<FieldLoopItemModel>
                List<FieldLoopItemModel> loopItems = new ArrayList<FieldLoopItemModel>();
                List<DisplayableModel> displayables = loopModel.getFields();
                for (DisplayableModel displayable : displayables) {
                    if (displayable instanceof FieldLoopItemModel) {
                        loopItems.add((FieldLoopItemModel) displayable);
                    }
                }

                return loopItems;
            }
        };
    }

    private IModel<List<LineModel>> createLineModel(final IModel<FieldLoopItemModel> model) {
        return new AbstractReadOnlyModel<List<LineModel>>() {

            @Override
            public List<LineModel> getObject() {
                //todo implement
                return new ArrayList<LineModel>();
            }
        };
    }
}
