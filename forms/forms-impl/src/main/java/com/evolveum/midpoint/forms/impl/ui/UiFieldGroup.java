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

package com.evolveum.midpoint.forms.impl.ui;

import com.evolveum.midpoint.forms.impl.model.FieldGroupModel;
import com.evolveum.midpoint.forms.impl.model.LineModel;
import com.evolveum.midpoint.xml.ns._public.gui.form_1.DisplayType;
import org.apache.commons.lang.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import java.util.List;

/**
 * @author lazyman
 */
public class UiFieldGroup extends UiComponent<FieldGroupModel> {

    private static final String ID_MAIN = "main";
    private static final String ID_GROUP_TITLE = "groupTitle";
    private static final String ID_LINE = "line";

    public UiFieldGroup(String id, IModel<FieldGroupModel> model) {
        super(id, model);
    }

    @Override
    protected void initLayout() {
        WebMarkupContainer main = new WebMarkupContainer(ID_MAIN);
        add(main);

        FieldGroupModel groupModel = model.getObject();
        DisplayType display = groupModel.getDefaultDisplay();
        if (StringUtils.isNotEmpty(display.getCssClass())) {
            main.add(new AttributeModifier("class", display.getCssClass()));
        }
        if (StringUtils.isNotEmpty(display.getCssStyle())) {
            main.add(new AttributeModifier("style", display.getCssStyle()));
        }

        Label groupTitle = new Label(ID_GROUP_TITLE, new PropertyModel<String>(model, "defaultDisplay.label"));
        main.add(groupTitle);

        LineListView line = new LineListView(ID_LINE, createLineModel());
        main.add(line);
    }

    private IModel<List<LineModel>> createLineModel() {
        return new AbstractReadOnlyModel<List<LineModel>>() {

            @Override
            public List<LineModel> getObject() {
                FieldGroupModel groupModel = model.getObject();
                return groupModel.getLines();
            }
        };
    }
}
