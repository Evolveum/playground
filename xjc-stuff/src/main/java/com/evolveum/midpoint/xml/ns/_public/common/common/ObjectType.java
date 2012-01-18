package com.evolveum.midpoint.xml.ns._public.common.common;

import com.evolveum.midpoint.schema.SchemaConstants;
import com.evolveum.midpoint.schema.XmlUtil;
import com.evolveum.midpoint.schema.processor.MidPointObject;
import com.evolveum.midpoint.xml.ns._public.common.common_1.PasswordPolicyType;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.List;

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
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ObjectType");
    public final static QName F_NAME = new QName(SchemaConstants.NS_COMMON, "name");
    public final static QName F_DESCRIPTION = new QName(SchemaConstants.NS_COMMON, "description");
    public final static QName F_VERSION = new QName(SchemaConstants.NS_COMMON, "version");
    @XmlTransient
    private MidPointObject container;

    public MidPointObject getContainer() {
        if (container == null) {
            container = new MidPointObject(COMPLEX_TYPE);
        }
        return container;
    }

    public void setContainer(MidPointObject container) {
        if (container == null) {
            container = null;
            return;
        }
        if (!COMPLEX_TYPE.equals(container.getName())) {
            throw new IllegalArgumentException((((("Container qname '" + container.getName())
                    + "' doesn't equals to '") + COMPLEX_TYPE) + "'."));
        }
        this.container = container;
    }

    <T> List<T> getPropertyValues(QName name, Class<T> clazz) {
        return XmlUtil.getPropertyValues(getContainer(), name, clazz);
    }

    <T> T getPropertyValue(QName name, Class<T> clazz) {
        return XmlUtil.getPropertyValue(getContainer(), name, clazz);
    }

    <T> void setPropertyValue(QName name, T value) {
        XmlUtil.setPropertyValue(getContainer(), name, value);
    }

    public String getName() {
        return getPropertyValue(F_NAME, String.class);
    }

    public void setName(String value) {
        setPropertyValue(F_NAME, value);
    }

    public String getDescription() {
        return getPropertyValue(F_DESCRIPTION, String.class);
    }

    public void setDescription(String value) {
        setPropertyValue(F_DESCRIPTION, value);
    }

    @XmlAttribute(name = "oid")
    public String getOid() {
        return getContainer().getOid();
    }

    public void setOid(String value) {
        getContainer().setOid(value);
    }

    @XmlAttribute(name = "version")
    public String getVersion() {
        return getPropertyValue(F_VERSION, String.class);
    }

    public void setVersion(String value) {
        setPropertyValue(F_VERSION, value);
    }
}
