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

package com.evolveum.midpoint.forms.impl.ui.widget;

import com.evolveum.midpoint.xml.ns._public.gui.form_1.PropertyType;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import org.apache.commons.lang.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazyman
 */
public class PasswordWidget extends UiWidget {

    public static final String PROPERTY_SIZE = "size";
    private static final Trace LOGGER = TraceManager.getTrace(PasswordWidget.class);
    private static final String ID_PASSWORD_ONE = "password1";
    private static final String ID_PASSWORD_TWO = "password2";

    public PasswordWidget(String id, IModel<String> model) {
        super(id, model);
    }

    @Override
    protected void initLayout() {
        PasswordTextField password1 = new PasswordTextField(ID_PASSWORD_ONE, getModel());
        password1.setRequired(false);
        password1.setResetPassword(false);
        add(password1);

        final PasswordTextField password2 = new PasswordTextField(ID_PASSWORD_TWO, new Model<String>());
        password2.setRequired(false);
        password2.setResetPassword(false);
        add(password2);

        password1.add(new PasswordWidgetValidator(password1, password2));

        List<PropertyType> properties = getProperties();
        for (PropertyType property : properties) {
            try {
                if (PROPERTY_SIZE.equals(property.getName())) {
                    addSize(password1, property);
                    addSize(password2, property);
                }
            } catch (Exception ex) {
                LOGGER.warn("Couldn't use property {} with value {}, reason: {}.",
                        new Object[]{property.getName(), property.getValue(), ex.getMessage()});
                LOGGER.debug("Couldn't use property, exception occurred.", ex);
            }
        }
    }

    @Override
    public List<FormComponent> getFormComponents() {
        List<FormComponent> list = new ArrayList<FormComponent>();
        list.add((FormComponent) get(ID_PASSWORD_ONE));
        list.add((FormComponent) get(ID_PASSWORD_TWO));

        return list;
    }

    @Override
    public FormComponent getBaseFormComponent() {
        return (FormComponent) get(ID_PASSWORD_ONE);
    }

    private void addSize(TextField text, PropertyType property) {
        String value = property.getValue();
        if (StringUtils.isEmpty(value) || !value.matches("[0]*[1-9]+[0-9]*")) {
            return;
        }

        int size = Integer.parseInt(value);
        text.add(new AttributeModifier("size", size));
    }
}
