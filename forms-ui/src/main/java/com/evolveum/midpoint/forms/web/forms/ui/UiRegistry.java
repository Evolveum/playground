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

import com.evolveum.midpoint.forms.web.forms.FormModel;
import com.evolveum.midpoint.forms.web.forms.object.*;
import com.evolveum.midpoint.forms.web.forms.ui.field.TextInputField;
import com.evolveum.midpoint.forms.web.forms.ui.group.DefaultFieldGroup;
import com.evolveum.midpoint.forms.web.forms.ui.group.LabeledFieldGroup;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import org.apache.commons.lang.Validate;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lazyman
 */
public class UiRegistry {

    public static final String FIELD_TEXT = "text";

    public static final String FIELD_GROUP_DEFAULT = "default";
    public static final String FIELD_GROUP_LABELED = "labeled";

    private static final Trace LOGGER = TraceManager.getTrace(UiRegistry.class);
    private static final Map<String, Class<? extends UiField>> FIELD_TYPES =
            new HashMap<String, Class<? extends UiField>>();
    private static final Map<String, Class<? extends UiFieldGroup>> FIELD_GROUP_TYPES =
            new HashMap<String, Class<? extends UiFieldGroup>>();

    static {
        FIELD_TYPES.put(FIELD_TEXT, TextInputField.class);


        FIELD_GROUP_TYPES.put(FIELD_GROUP_DEFAULT, DefaultFieldGroup.class);
        FIELD_GROUP_TYPES.put(FIELD_GROUP_LABELED, LabeledFieldGroup.class);

    }

    public static Class<? extends UiField> getInputFieldByType(String type) {
        Validate.notEmpty(type, "Input field type must not be null.");

        return FIELD_TYPES.get(type);
    }

    public static Class<? extends UiField> getInputFieldByClass(String clazzName) {
        Validate.notEmpty(clazzName, "Input field class name must not be null.");

        try {
            ClassLoader classLoader = UiRegistry.class.getClassLoader();
            Class<?> clazz = classLoader.loadClass(clazzName);

            if (UiField.class.isAssignableFrom(clazz)) {
                return (Class<? extends UiField>) clazz;
            } else {
                LOGGER.error("Class '{}' doesn't extends '{}' therefore can't be used.",
                        new Object[]{clazzName, UiField.class.getName()});
            }
        } catch (Exception ex) {
            //todo error handling
            ex.printStackTrace();
        }

        return null;
    }

    public static Component createUiItem(String componentId, IModel<? extends ItemToken> itemModel,
                                         IModel<FormModel> formModel) {
        ItemToken token = itemModel.getObject();
        if (token instanceof FieldRefToken) {
            itemModel = new PropertyModel<ItemToken>(itemModel, "referencedToken");
        }

        token = itemModel.getObject();
        if (token instanceof FieldGroupToken) {

        } else if (token instanceof FieldToken) {

        } else {
            //todo log some error
        }


        AbstractFieldToken fieldToken = (AbstractFieldToken) token;
        //todo remove sample and implement real stuff
        return new Label(componentId, new Model<Serializable>(fieldToken));
    }
}
