package com.evolveum.midpoint.web.component.autoform;

import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class FormAttributeDefinition implements Serializable {

    private QName elementName; //what is this for?
    private String displayName;
    private String description;
    private List<Object> availableValues;
    private boolean filledWithExpression = false;
    private int minOccurs = 1;
    private int maxOccurs = 1;
    private boolean readOnly = false;
    private AttributeType type;

    /**
     * What is this for?
     */
    @Deprecated
    public QName getElementName() {
        return elementName;
    }

    void setElementName(QName elementName) {
        this.elementName = elementName;
    }

    public String getDisplayName() {
        return displayName;
    }

    void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    public List<Object> getAvailableValues() {
        if (availableValues == null) {
            return null;
        }
        return Collections.unmodifiableList(availableValues);
    }

    void setAvailableValues(List<Object> availableValues) {
        this.availableValues = availableValues;
    }

    public boolean isFilledWithExpression() {
        return filledWithExpression;
    }

    void setFilledWithExpression(boolean filledWithExpression) {
        this.filledWithExpression = filledWithExpression;
    }

    public int getMinOccurs() {
        return minOccurs;
    }

    void setMinOccurs(int minOccurs) {
        this.minOccurs = minOccurs;
    }

    public int getMaxOccurs() {
        return maxOccurs;
    }

    void setMaxOccurs(int maxOccurs) {
        this.maxOccurs = maxOccurs;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public AttributeType getType() {
        return type;
    }

    void setType(AttributeType type) {
        this.type = type;
    }
}
