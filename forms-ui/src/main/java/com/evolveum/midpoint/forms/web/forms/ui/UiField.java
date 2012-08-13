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

import com.evolveum.midpoint.forms.web.forms.model.FieldModel;
import com.evolveum.midpoint.forms.web.forms.model.ValueModel;
import com.evolveum.midpoint.forms.xml.FieldDisplayType;
import org.apache.commons.lang.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import java.util.List;

/**
 * @author lazyman
 */
public class UiField extends UiComponent<FieldModel> {

    public UiField(String id, IModel<FieldModel> field) {
        super(id, field);
    }

    @Override
    protected void initLayout() {
        WebMarkupContainer main = new WebMarkupContainer("main");
        add(main);

        FieldModel fieldModel = model.getObject();
        FieldDisplayType display = fieldModel.getDefaultDisplay();
        if (StringUtils.isNotEmpty(display.getCssClass())) {
            main.add(new AttributeAppender("class", UiFactory.createReadOnlyModel(display.getCssClass()), " "));
        }
        if (StringUtils.isNotEmpty(display.getCssStyle())) {
            main.add(new AttributeModifier("style", display.getCssStyle()));
        }

        ListView<ValueModel> values = new ListView<ValueModel>("value",
                new PropertyModel<List<? extends ValueModel>>(model, "values")) {

            @Override
            protected void populateItem(ListItem<ValueModel> item) {
                UiValue value = new UiValue("valueBody", item.getModel());
                value.setRenderBodyOnly(true);

                //todo properly add values
                item.add(value);
            }
        };
        main.add(values);
    }
}
