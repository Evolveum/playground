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

package com.evolveum.midpoint.forms.web.forms.ui.widget;

import com.evolveum.midpoint.forms.xml.PropertyType;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import org.apache.commons.lang.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * @author lazyman
 */
public class TextWidget<T> extends UiWidget {

    public static final String PROPERTY_SIZE = "size";
    public static final String PROPERTY_CLASS = "class";
    private static final Trace LOGGER = TraceManager.getTrace(TextWidget.class);
    private static final String ID_INPUT = "input";

    public TextWidget(String id, IModel<T> model) {
        super(id, model);
    }

    @Override
    protected void initLayout() {
        TextField text = new TextField(ID_INPUT, getModel(), String.class);
        add(text);

        List<PropertyType> properties = getProperties();
        for (PropertyType property : properties) {
            try {
                if (PROPERTY_SIZE.equals(property.getName())) {
                    addSize(text, property);
                } else if (PROPERTY_CLASS.equals(property.getName())) {
                    addClass(text, property);
                }
            } catch (Exception ex) {
                LOGGER.warn("Couldn't use property {} with value {}, reason: {}.",
                        new Object[]{property.getName(), property.getValue(), ex.getMessage()});
                LOGGER.debug("Couldn't use property, exception occurred.", ex);
            }
        }
    }

    @Override
    public FormComponent getBaseFormComponent() {
        return (FormComponent) get(ID_INPUT);
    }

    private void addClass(TextField text, PropertyType property) throws ClassNotFoundException {
        String value = property.getValue();
        if (StringUtils.isEmpty(value)) {
            return;
        }

        ClassLoader classLoader = TextWidget.class.getClassLoader();
        Class type = classLoader.loadClass(value);
        text.setType(type);
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
