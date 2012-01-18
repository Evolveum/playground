package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Describes a change of a specific resource object
 * together with definitions of the source.
 * <p/>
 * Note: This is quite an atrificial structure. In fact it should
 * be splint into WSDL message parts instead one XSD type. But the
 * ObjectChangeType is polymorphic and OpenESB has problems with such types if placed
 * directly into message parts.
 * <p/>
 * <p/>
 * <p>Java class for ResourceObjectShadowChangeDescriptionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ResourceObjectShadowChangeDescriptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="objectChange" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectChangeType"/>
 *         &lt;element name="sourceChannel" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="shadow" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ResourceObjectShadowType"/>
 *         &lt;element name="resource" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ResourceType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceObjectShadowChangeDescriptionType", propOrder = {
        "objectChange",
        "sourceChannel",
        "shadow",
        "resource"
})
public class ResourceObjectShadowChangeDescriptionType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected ObjectChangeType objectChange;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String sourceChannel;
    @XmlElement(required = true)
    protected ResourceObjectShadowType shadow;
    @XmlElement(required = true)
    protected ResourceType resource;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ResourceObjectShadowChangeDescriptionType");
    public final static QName F_OBJECT_CHANGE = new QName(SchemaConstants.NS_COMMON, "objectChange");
    public final static QName F_SOURCE_CHANNEL = new QName(SchemaConstants.NS_COMMON, "sourceChannel");
    public final static QName F_SHADOW = new QName(SchemaConstants.NS_COMMON, "shadow");
    public final static QName F_RESOURCE = new QName(SchemaConstants.NS_COMMON, "resource");

    /**
     * Gets the value of the objectChange property.
     *
     * @return possible object is
     *         {@link ObjectChangeType }
     */
    public ObjectChangeType getObjectChange() {
        return objectChange;
    }

    /**
     * Sets the value of the objectChange property.
     *
     * @param value allowed object is
     *              {@link ObjectChangeType }
     */
    public void setObjectChange(ObjectChangeType value) {
        this.objectChange = value;
    }

    /**
     * Gets the value of the sourceChannel property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSourceChannel() {
        return sourceChannel;
    }

    /**
     * Sets the value of the sourceChannel property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSourceChannel(String value) {
        this.sourceChannel = value;
    }

    /**
     * Gets the value of the shadow property.
     *
     * @return possible object is
     *         {@link ResourceObjectShadowType }
     */
    public ResourceObjectShadowType getShadow() {
        return shadow;
    }

    /**
     * Sets the value of the shadow property.
     *
     * @param value allowed object is
     *              {@link ResourceObjectShadowType }
     */
    public void setShadow(ResourceObjectShadowType value) {
        this.shadow = value;
    }

    /**
     * Gets the value of the resource property.
     *
     * @return possible object is
     *         {@link ResourceType }
     */
    public ResourceType getResource() {
        return resource;
    }

    /**
     * Sets the value of the resource property.
     *
     * @param value allowed object is
     *              {@link ResourceType }
     */
    public void setResource(ResourceType value) {
        this.resource = value;
    }

}
