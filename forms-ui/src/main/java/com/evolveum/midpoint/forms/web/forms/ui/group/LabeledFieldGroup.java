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

import com.evolveum.midpoint.forms.web.forms.model.FieldGroupModel;
import com.evolveum.midpoint.forms.web.forms.ui.UiFieldGroup;
import org.apache.wicket.model.IModel;

/**
 * @author lazyman
 */
public class LabeledFieldGroup extends UiFieldGroup {

    public LabeledFieldGroup(String id, IModel<FieldGroupModel> fieldGroup) {
        super(id, fieldGroup);
    }

//    private void initLayout() {
//        Label label = new Label("label", new AbstractReadOnlyModel<Object>() {
//
//            @Override
//            public Object getObject() {
//                FieldGroupToken group = getFieldGroup().getObject();
//                FieldGroupType type = group.getItem();
//                DisplayType display = type.getDisplay();
//                if (display == null) {
//                    return null;
//                }
//
//                return display.getLabel();
//            }
//        });
//        add(label);
//
//        ListView<ItemToken> group = new ListView<ItemToken>("group",
//                new AbstractReadOnlyModel<List<? extends ItemToken>>() {
//                    @Override
//                    public List<ItemToken> getObject() {
//                        return createChildrenList();
//                    }
//                }) {
//
//            @Override
//            protected void populateItem(ListItem<ItemToken> listItem) {
//                //method for populating list with fields/field groups
//                Component groupItem = UiRegistry.createUiItem("groupItem", listItem.getModel());
//                groupItem.setRenderBodyOnly(true);
//
//                //todo move this if somewhere...
//                if (listItem.getModelObject() instanceof FieldToken) {
//                    FieldToken fieldToken = (FieldToken) listItem.getModelObject();
//                    if (!fieldToken.getItem().getDisplay().isNewLine()) {
//                        //todo fix new line style
////                        listItem.add(new AttributeAppender("style", new Model<String>("display: inline-block;"), " "));
//                    }
//                }
//
//                listItem.add(groupItem);
//            }
//        };
//        add(group);
//    }
//
//    private List<ItemToken> createChildrenList() {
//        FieldGroupToken groupToken = getFieldGroup().getObject();
//        return groupToken.getItems();
//    }
}
