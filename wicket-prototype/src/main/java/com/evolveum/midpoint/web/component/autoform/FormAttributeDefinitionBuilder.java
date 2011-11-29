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
