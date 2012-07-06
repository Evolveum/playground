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

import com.evolveum.midpoint.forms.web.forms.ui.field.TextInputField;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import org.apache.commons.lang.Validate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lazyman
 */
public class FormUiRegistry {

    public static final String FIELD_TEXT = "text";

    private static final Trace LOGGER = TraceManager.getTrace(FormUiRegistry.class);
    private static final Map<String, Class<? extends InputField>> FIELD_TYPES =
            new HashMap<String, Class<? extends InputField>>();
    private static final Map<String, Class<? extends FieldGroup>> FIELD_GROUP_TYPES =
            new HashMap<String, Class<? extends FieldGroup>>();

    static {
        FIELD_TYPES.put(FIELD_TEXT, TextInputField.class);


    }

    public static Class<? extends InputField> getInputFieldByType(String type) {
        Validate.notEmpty(type, "Input field type must not be null.");

        return FIELD_TYPES.get(type);
    }

    public static Class<? extends InputField> getInputFieldByClass(String clazzName) {
        Validate.notEmpty(clazzName, "Input field class name must not be null.");

        try {
            ClassLoader classLoader = FormUiRegistry.class.getClassLoader();
            Class<?> clazz = classLoader.loadClass(clazzName);

            if (InputField.class.isAssignableFrom(clazz)) {
                return (Class<? extends InputField>) clazz;
            } else {
                LOGGER.error("Class '{}' doesn't extends '{}' therefore can't be used.",
                        new Object[]{clazzName, InputField.class.getName()});
            }
        } catch (Exception ex) {
            //todo error handling
            ex.printStackTrace();
        }

        return null;
    }
}
