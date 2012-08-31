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

package com.evolveum.midpoint.forms.web.forms.util;

import com.evolveum.midpoint.forms.web.forms.object.*;
import com.evolveum.midpoint.forms.web.forms.ui.UiRegistry;
import com.evolveum.midpoint.forms.xml.*;
import com.evolveum.midpoint.prism.PrismPropertyDefinition;
import com.evolveum.midpoint.util.DOMUtil;
import com.evolveum.midpoint.util.exception.SystemException;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import com.evolveum.midpoint.xml.ns._public.common.common_2.ProtectedStringType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;

/**
 * @author lazyman
 */
public class StructuredFormUtils {

    private static final Trace LOGGER = TraceManager.getTrace(StructuredFormUtils.class);
    private static final JAXBContext context;

    static {
        try {
            context = JAXBContext.newInstance(FormType.class.getPackage().getName());
        } catch (Exception ex) {
            throw new SystemException("Couldn't initialize jaxb context for structured forms.", ex);
        }
    }

    public static FormType loadForm(File file) throws JAXBException {
        JAXBElement<FormType> element = (JAXBElement<FormType>) createUnmarshaller().unmarshal(file);
        return element.getValue();
    }

    public static FormType loadForm(InputStream stream) throws JAXBException {
        JAXBElement<FormType> element = (JAXBElement<FormType>) createUnmarshaller().unmarshal(stream);
        return element.getValue();
    }

    private static Unmarshaller createUnmarshaller() throws JAXBException {
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return unmarshaller;
    }

    public static BaseFieldToken createItemToken(Token parent, BaseFieldType item) {
        BaseFieldToken token;
        if (item instanceof FieldType) {
            token = new FieldToken(parent, (FieldType) item);
        } else if (item instanceof FieldGroupType) {
            token = new FieldGroupToken(parent, (FieldGroupType) item);
        } else if (item instanceof FieldReferenceType) {
            token = new FieldRefToken(parent, (FieldReferenceType) item);
        } else {
            throw new SystemException("Unsupported token type '" + item.getClass().getName() + "'.");
        }

        return token;
    }

    public static void cloneDisplay(DisplayType oldDisplay, DisplayType newDisplay) {
        if (oldDisplay == null) {
            return;
        }

        newDisplay.setCssClass(oldDisplay.getCssClass());
        newDisplay.setCssStyle(oldDisplay.getCssStyle());
        newDisplay.setHelp(oldDisplay.getHelp());
        newDisplay.setLabel(oldDisplay.getLabel());
        newDisplay.setTooltip(oldDisplay.getTooltip());
        newDisplay.setType(oldDisplay.getType());

        for (PropertyType property : oldDisplay.getProperty()) {
            PropertyType newProperty = new PropertyType();
            newProperty.setName(property.getName());
            newProperty.setValue(property.getValue());

            newDisplay.getProperty().add(newProperty);
        }
    }

    public static void cloneFieldDisplay(FieldDisplayType oldDisplay, FieldDisplayType newDisplay) {
        if (oldDisplay == null) {
            return;
        }

        cloneDisplay(oldDisplay, newDisplay);
        newDisplay.setNewLine(oldDisplay.isNewLine());
    }

    public static String getDefaultWidget(PrismPropertyDefinition definition) {
        if (DOMUtil.XSD_DATETIME.equals(definition.getTypeName())) {
            return UiRegistry.WIDGET_DATE;
        } else if (ProtectedStringType.COMPLEX_TYPE.equals(definition.getTypeName())) {
            return UiRegistry.WIDGET_PASSWORD;
        } else if (DOMUtil.XSD_BOOLEAN.equals(definition.getTypeName())) {
            return UiRegistry.WIDGET_CHECKBOX;
        }

        return UiRegistry.WIDGET_DEFAULT;
    }
}
