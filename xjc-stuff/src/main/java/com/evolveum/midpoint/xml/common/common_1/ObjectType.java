package com.evolveum.midpoint.xml.common.common_1;

import com.evolveum.midpoint.schema.processor.Property;
import com.evolveum.midpoint.schema.processor.PropertyContainer;
import com.evolveum.midpoint.schema.processor.PropertyValue;
import com.evolveum.midpoint.xml.common.SchemaConstants;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObjectType", propOrder = {
        "name",
        "description"
})
@XmlSeeAlso({
        PasswordPolicyType.class,
        ExtensibleObjectType.class
})
public abstract class ObjectType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    public final static QName ELEMENT_TYPE = new QName(SchemaConstants.NS_COMMON, "ObjectType");
    public final static QName F_NAME = new QName(SchemaConstants.NS_COMMON, "name");
    public final static QName F_OID = new QName(SchemaConstants.NS_COMMON, "oid");
    public final static QName F_VERSION = new QName(SchemaConstants.NS_COMMON, "version");
    public final static QName F_DESCRIPTION = new QName(SchemaConstants.NS_COMMON, "description");

    private PropertyContainer container;

    public PropertyContainer getContainer() {
        if (container == null) {
            container = new PropertyContainer(ELEMENT_TYPE);
        }
        return container;
    }

    <T> T getPropertyValue(QName name) {
        Property property = getContainer().findProperty(name);
        if (property == null) {
            return null;
        }

        PropertyValue<Object> value = property.getValue();
        if (value == null) {
            return null;
        }

        return (T) value.getValue();
    }

    <T> void setPropertyValue(QName name, T value) {
        Property property = getContainer().findOrCreateProperty(name);
        property.setValue(new PropertyValue(value));
    }

    public String getName() {
        return getPropertyValue(F_NAME);
    }

    public void setName(String value) {
        setPropertyValue(F_NAME, value);
    }

    public String getDescription() {
        return getPropertyValue(F_DESCRIPTION);
    }

    public void setDescription(String value) {
        setPropertyValue(F_DESCRIPTION, value);
    }

    @XmlAttribute(name = "oid")
    public String getOid() {
        return getPropertyValue(F_OID);
    }

    public void setOid(String value) {
        setPropertyValue(F_OID, value);
    }

    @XmlAttribute(name = "version")
    public String getVersion() {
        return getPropertyValue(F_VERSION);
    }

    public void setVersion(String value) {
        setPropertyValue(F_VERSION, value);
    }
}
