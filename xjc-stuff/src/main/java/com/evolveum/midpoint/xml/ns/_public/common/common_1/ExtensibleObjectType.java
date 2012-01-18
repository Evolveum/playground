package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Object with generic extensibility mechanism. It contains a
 * special XML element where almost any extension can be placed.
 * The extension is treated exactly the same as other object
 * properties by the code (storage, modifications, etc), except
 * that the system may not be able to understand their meaning.
 * <p/>
 * <p/>
 * <p>Java class for ExtensibleObjectType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ExtensibleObjectType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}extension" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
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
    protected Extension extension;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ExtensibleObjectType");
    public final static QName F_EXTENSION = new QName(SchemaConstants.NS_COMMON, "extension");

    /**
     * Gets the value of the extension property.
     *
     * @return possible object is
     *         {@link Extension }
     */
    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension value) {
        //todo do not use setValue but remove container from parent property container, update if user set/remove method
        this.extension = value;
        if (value == null) {
            setPropertyValue(F_EXTENSION, null);
        } else {
            setPropertyValue(F_EXTENSION, value.getContainer());
        }
    }

}
