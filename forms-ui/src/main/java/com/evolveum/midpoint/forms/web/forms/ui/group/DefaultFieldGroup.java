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

package com.evolveum.midpoint.forms.web.forms.ui.group;

import com.evolveum.midpoint.forms.web.forms.object.FieldGroupToken;
import com.evolveum.midpoint.forms.web.forms.object.ItemToken;
import com.evolveum.midpoint.forms.web.forms.ui.UiFieldGroup;
import com.evolveum.midpoint.forms.web.forms.ui.UiRegistry;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * @author lazyman
 */
public class DefaultFieldGroup extends UiFieldGroup {

    public DefaultFieldGroup(String id, IModel<FieldGroupToken> fieldGroup) {
        super(id, fieldGroup);

        initLayout();
    }

    private void initLayout() {
        ListView<ItemToken> group = new ListView<ItemToken>("group",
                new AbstractReadOnlyModel<List<? extends ItemToken>>() {
                    @Override
                    public List<ItemToken> getObject() {
                        return createChildrenList();
                    }
                }) {

            @Override
            protected void populateItem(ListItem listItem) {
                //method for populating list with fields/field groups
                Component groupItem = UiRegistry.createUiItem("groupItem", listItem.getModel());
                groupItem.setRenderBodyOnly(true);
                listItem.add(groupItem);
            }
        };
        add(group);
    }

    private List<ItemToken> createChildrenList() {
        FieldGroupToken groupToken = getFieldGroup().getObject();
        return groupToken.getItems();
    }
}
