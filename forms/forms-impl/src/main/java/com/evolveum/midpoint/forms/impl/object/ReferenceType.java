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

package com.evolveum.midpoint.forms.impl.object;

import org.apache.commons.lang.Validate;
import org.w3c.dom.Element;

/**
 * @author lazyman
 */
public class ReferenceType {

    private static final String ATTR_KEY = "key";
    private Element element;

    public ReferenceType(Element element) {
        Validate.notNull(element, "Reference element must not be null.");
        this.element = element;
    }

    public String getKey() {
        return element.getAttribute(ATTR_KEY);
    }

    public String getValue() {
        return element.getTextContent();
    }

    public Element getElement() {
        return element;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Ref{key=");
        builder.append(getKey());
        builder.append(",path=");
        builder.append(getValue());
        builder.append("}");

        return builder.toString();
    }
}
