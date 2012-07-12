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
import com.evolveum.midpoint.forms.xml.AbstractFieldType;
import com.evolveum.midpoint.forms.xml.DisplayType;
import com.evolveum.midpoint.forms.xml.FormItemType;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.io.Serializable;
import java.lang.reflect.Constructor;
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

    public static Class<? extends UiFieldGroup> getFieldGroup(String type, String clazz) {
        if (StringUtils.isNotEmpty(type)) {
            return FIELD_GROUP_TYPES.get(type);
        }

        if (StringUtils.isEmpty(clazz)) {
            return FIELD_GROUP_TYPES.get(FIELD_GROUP_DEFAULT);
        }

        Class<? extends UiFieldGroup> field =  getItemByClass(clazz, UiFieldGroup.class);
        if (field == null) {
            LOGGER.warn("Unknown field group type/class {}/{} using defaults.", new Object[]{type, clazz});
            return FIELD_GROUP_TYPES.get(FIELD_TEXT);
        }

        return field;
    }

    public static Class<? extends UiField> getField(String type, String clazz) {
        if (StringUtils.isNotEmpty(type)) {
            return FIELD_TYPES.get(type);
        }

        if (StringUtils.isEmpty(clazz)) {
            return FIELD_TYPES.get(FIELD_TEXT);
        }

        Class<? extends UiField> field =  getItemByClass(clazz, UiField.class);
        if (field == null) {
            LOGGER.warn("Unknown field type/class {}/{} using defaults.", new Object[]{type, clazz});
            return FIELD_TYPES.get(FIELD_TEXT);
        }

        return field;
    }

    private static <T> Class<T> getItemByClass(String clazzName, Class<T> type) {
        Validate.notEmpty(clazzName, "Input field class name must not be null.");

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

    public static Component createUiItem(String componentId, IModel<? extends ItemToken> itemModel,
                                         IModel<FormModel> formModel) {
        ItemToken token = itemModel.getObject();
        if (token instanceof FieldRefToken) {
            itemModel = new PropertyModel<ItemToken>(itemModel, "referencedToken");
        }

        DisplayType display = null;

        token = itemModel.getObject();
        if (token instanceof AbstractFieldToken) {
            AbstractFieldToken<AbstractFieldType> fieldToken = (AbstractFieldToken<AbstractFieldType>)token;
            AbstractFieldType abstractField = fieldToken.getItem();
            display = abstractField.getDisplay();
        }

        try {
            if (token instanceof FieldGroupToken) {
                Class<? extends UiFieldGroup> clazz = getFieldGroup(display.getType(), display.getClazz());
                Constructor constructor = clazz.getConstructor(String.class, IModel.class, IModel.class);
                return (UiFieldGroup) constructor.newInstance(componentId, itemModel, formModel);
            } else if (token instanceof FieldToken) {
                Class<? extends UiField> clazz = getField(display.getType(), display.getClazz());
                Constructor constructor = clazz.getConstructor(String.class, IModel.class, IModel.class);
                return (UiField) constructor.newInstance(componentId, itemModel, formModel);
            }
        } catch (Exception ex) {
            LOGGER.warn("Couldn't initialize component from token, reason: {}", new Object[]{ex.getMessage()});
            LOGGER.debug("Couldn't initialize component from token.", ex);
        }

        LOGGER.warn("Using default for component initialization.");

        if (token instanceof FieldGroupToken) {
            return new DefaultFieldGroup(componentId, (IModel<FieldGroupToken>) itemModel, formModel);
        } else if (token instanceof FieldToken) {
            return new TextInputField(componentId, (IModel<FieldToken>) itemModel, formModel);
        }

        //todo add some warn stuff here about that we couldn't create component
        return new Label(componentId);
    }
}