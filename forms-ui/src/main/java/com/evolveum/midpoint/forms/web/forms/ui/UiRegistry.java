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

import com.evolveum.midpoint.forms.web.forms.ui.widget.*;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lazyman
 */
public class UiRegistry {

    public static final String WIDGET_DEFAULT = "text";
    public static final String WIDGET_CHECKBOX = "checkbox";
    public static final String WIDGET_DATE = "date";
    public static final String WIDGET_PASSWORD = "password";
    public static final String WIDGET_COMBO_BOX = "combobox";

    private static final Trace LOGGER = TraceManager.getTrace(UiRegistry.class);
    private static final Map<String, Class<? extends UiWidget>> WIDGETS =
            new HashMap<String, Class<? extends UiWidget>>();

    static {
        WIDGETS.put(WIDGET_DEFAULT, TextWidget.class);
        WIDGETS.put(WIDGET_CHECKBOX, CheckBoxWidget.class);
        WIDGETS.put(WIDGET_DATE, DateWidget.class);
        WIDGETS.put(WIDGET_PASSWORD, PasswordWidget.class);
        WIDGETS.put(WIDGET_COMBO_BOX, ComboBoxWidget.class);
    }

    public static Class<? extends UiForm> getForm(String type) {
        if (StringUtils.isEmpty(type)) {
            return UiForm.class;
        }

        Class<UiForm> form = getItemByClass(type, UiForm.class);
        return form != null ? form : UiForm.class;
    }

    public static Class<? extends UiWidget> getWidget(String type) {
        if (StringUtils.isEmpty(type)) {
            type = WIDGET_DEFAULT;
        }

        Class<? extends UiWidget> clazz = WIDGETS.get(type);
        if (clazz == null) {
            clazz = getItemByClass(type, UiWidget.class);
        }

        return clazz != null ? clazz : WIDGETS.get(WIDGET_DEFAULT);
    }

    private static <T> Class<T> getItemByClass(String clazzName, Class<T> type) {
        Validate.notEmpty(clazzName, "Class name must not be null.");

        try {
            ClassLoader classLoader = UiRegistry.class.getClassLoader();
            Class<?> clazz = classLoader.loadClass(clazzName);

            if (type.isAssignableFrom(clazz)) {
                return (Class<T>) clazz;
            } else {
                LOGGER.warn("Class '{}' doesn't extends '{}' therefore can't be used.",
                        new Object[]{clazzName, type.getName()});
            }
        } catch (Exception ex) {
            LOGGER.warn("Couldn't get field '{}' by class '{}'", new Object[]{type, clazzName});
        }

        return null;
    }
}
