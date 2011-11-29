/*
 * Copyright (c) 2011 Evolveum
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
 * Portions Copyrighted 2011 [name of copyright owner]
 */

package com.evolveum.midpoint.web.component.autoform;

import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.List;

public class FormAttributeDefinitionBuilder implements Serializable {

    private FormAttributeDefinition definition = new FormAttributeDefinition();

    public void setAvailableValues(List<Object> availableValues) {
        definition.setAvailableValues(availableValues);
    }

    public void setDescription(String description) {
        definition.setDescription(description);
    }

    public void setDisplayName(String displayName) {
        definition.setDisplayName(displayName);
    }

    public void setElementName(QName elementName) {
        definition.setElementName(elementName);
    }

    public void setMaxOccurs(int maxOccurs) {
        definition.setMaxOccurs(maxOccurs);
    }

    public void setMinOccurs(int minOccurs) {
        definition.setMinOccurs(minOccurs);
    }

    public void setType(AttributeType type) {
        definition.setType(type);
    }

    public void setFilledWithExpression(boolean filledWithExpression) {
        definition.setFilledWithExpression(filledWithExpression);
    }

    public FormAttributeDefinition build() {
        if (definition.getElementName() == null) {
            throw new IllegalStateException("Element name not defined.");
        }
        if (definition.getType() == null) {
            throw new IllegalStateException("Type not defined for element '" + definition.getElementName()
                    + "'.");
        }
        if (definition.getDisplayName() == null) {
            throw new IllegalArgumentException("Display name not defined for element '"
                    + definition.getElementName() + "'.");
        }

        return definition;
    }
}
