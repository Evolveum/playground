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

package com.evolveum.midpoint.forms.impl.util;

import com.evolveum.midpoint.xml.ns._public.gui.form_1.*;
import com.evolveum.midpoint.util.exception.SystemException;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;

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

    public static void cloneBaseDisplay(BaseDisplayType oldDisplay, BaseDisplayType newDisplay) {
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

    public static void cloneDisplay(DisplayType oldDisplay, DisplayType newDisplay) {
        if (oldDisplay == null) {
            return;
        }

        cloneBaseDisplay(oldDisplay, newDisplay);
        newDisplay.setNewLine(oldDisplay.isNewLine());
    }

    public static void cloneFieldDisplay(FieldDisplayType oldDisplay, FieldDisplayType newDisplay) {
        if (oldDisplay == null) {
            return;
        }

        cloneDisplay(oldDisplay, newDisplay);
        newDisplay.setMinOccurs(oldDisplay.getMinOccurs());
        newDisplay.setMaxOccurs(oldDisplay.getMaxOccurs());
    }

    public static String createMessage(Throwable ex, StringBuilder builder) {
        builder.append("Caused by: \"");
        builder.append(ex.getMessage());
        builder.append("\" ");

        if (ex.getCause() != null) {
            createMessage(ex.getCause(), builder);
        }

        return builder.toString();
    }
}
