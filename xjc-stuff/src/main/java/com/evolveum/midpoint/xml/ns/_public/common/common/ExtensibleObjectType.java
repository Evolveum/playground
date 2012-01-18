package com.evolveum.midpoint.xml.ns._public.common.common;

import com.evolveum.midpoint.schema.SchemaConstants;
import com.evolveum.midpoint.xml.ns._public.common.common_1.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtensibleObjectType", propOrder = {
        "extension"
})
@XmlSeeAlso({
        GenericObjectType.class,
        RoleType.class,
        ConnectorType.class,
        ConnectorHostType.class,
        SystemConfigurationType.class,
        UserTemplateType.class,
        TaskType.class,
        ResourceType.class,
        ResourceObjectShadowType.class,
        UserType.class,
        ProtoStructureType.class
})
public class ExtensibleObjectType
        extends ObjectType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected com.evolveum.midpoint.xml.ns._public.common.common.Extension extension;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ExtensibleObjectType");
    public final static QName F_EXTENSION = new QName(SchemaConstants.NS_COMMON, "extension");

    public com.evolveum.midpoint.xml.ns._public.common.common.Extension getExtension() {
        return extension;
    }

    public void setExtension(com.evolveum.midpoint.xml.ns._public.common.common.Extension value) {
        //todo do not use setValue but remove container from parent property container,
        // update if user set/remove method
        this.extension = value;
//        if (value == null) {
//            setPropertyValue(F_EXTENSION, null);
//        } else {
//            setPropertyValue(F_EXTENSION, value.getContainer());
//        }
    }

}
