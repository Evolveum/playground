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

package com.evolveum.midpoint.forms.web.forms.ui.field;

import com.evolveum.midpoint.forms.web.forms.FormModel;
import com.evolveum.midpoint.forms.web.forms.object.FieldToken;
import com.evolveum.midpoint.forms.web.forms.ui.UiField;
import com.evolveum.midpoint.forms.xml.DisplayType;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

/**
 * @author lazyman
 */
public class TextInputField extends UiField {

    public TextInputField(String id, IModel<FieldToken> field, IModel<FormModel> formModel) {
        super(id, field, formModel);

        initLayout();
    }

    private void initLayout() {
        Label label = new Label("label", new AbstractReadOnlyModel<String>() {

            @Override
            public String getObject() {
                return getLabelText();
            }
        });
        add(label);

        TextField text = new TextField("input");
        add(text);

        //todo impl text value, style, etc...
    }

    private String getLabelText() {
        FieldToken field = getField().getObject();
        DisplayType display = field.getItem().getDisplay();
        return display.getLabel();
    }
}
