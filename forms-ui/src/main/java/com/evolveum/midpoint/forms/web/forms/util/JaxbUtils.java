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

import com.evolveum.midpoint.forms.xml.FormType;
import com.evolveum.midpoint.util.exception.SystemException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;

/**
 * @author lazyman
 */
public class JaxbUtils {

    private static final JAXBContext context;

    static {
        try {
            context = JAXBContext.newInstance(FormType.class.getPackage().getName());
        } catch (Exception ex) {
            throw new SystemException("Couldn't initialize jaxb context for structured forms.", ex);
        }
    }

    public static FormType loadForm(File file) throws JAXBException {
        JAXBElement<FormType> element = (JAXBElement<FormType>)createUnmarshaller().unmarshal(file);
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
}
