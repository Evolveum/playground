
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import com.evolveum.midpoint.schema.DomAwareEqualsStrategy;
import com.evolveum.midpoint.schema.DomAwareHashCodeStrategy;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * 
 *                 Describes a change of a specific resource object
 *                 together with
 *                 definitions of the source.
 * 
 *                 Note: This
 *                 is quite
 *                 an
 *                 atrificial structure. In fact it should
 *                 be splint into WSDL message
 *                 parts instead one XSD type. But the
 *                 ObjectChangeType
 *                 is
 *                 polymorphic
 *                 and OpenESB has problems with such types if placed
 *                 directly into
 *                 message parts.
 *             
 * 
 * <p>Java class for ResourceObjectShadowChangeDescriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
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
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceObjectShadowChangeDescriptionType", propOrder = {
    "objectChange",
    "sourceChannel",
    "shadow",
    "resource"
})
public class ResourceObjectShadowChangeDescriptionType
    implements Serializable, Equals, HashCode
{

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
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ResourceObjectShadowChangeDescriptionType");

    /**
     * Gets the value of the objectChange property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectChangeType }
     *     
     */
    public ObjectChangeType getObjectChange() {
        return objectChange;
    }

    /**
     * Sets the value of the objectChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectChangeType }
     *     
     */
    public void setObjectChange(ObjectChangeType value) {
        this.objectChange = value;
    }

    /**
     * Gets the value of the sourceChannel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceChannel() {
        return sourceChannel;
    }

    /**
     * Sets the value of the sourceChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceChannel(String value) {
        this.sourceChannel = value;
    }

    /**
     * Gets the value of the shadow property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceObjectShadowType }
     *     
     */
    public ResourceObjectShadowType getShadow() {
        return shadow;
    }

    /**
     * Sets the value of the shadow property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceObjectShadowType }
     *     
     */
    public void setShadow(ResourceObjectShadowType value) {
        this.shadow = value;
    }

    /**
     * Gets the value of the resource property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceType }
     *     
     */
    public ResourceType getResource() {
        return resource;
    }

    /**
     * Sets the value of the resource property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceType }
     *     
     */
    public void setResource(ResourceType value) {
        this.resource = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            ObjectChangeType theObjectChange;
            theObjectChange = this.getObjectChange();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "objectChange", theObjectChange), currentHashCode, theObjectChange);
        }
        {
            String theSourceChannel;
            theSourceChannel = this.getSourceChannel();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sourceChannel", theSourceChannel), currentHashCode, theSourceChannel);
        }
        {
            ResourceObjectShadowType theShadow;
            theShadow = this.getShadow();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "shadow", theShadow), currentHashCode, theShadow);
        }
        {
            ResourceType theResource;
            theResource = this.getResource();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resource", theResource), currentHashCode, theResource);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ResourceObjectShadowChangeDescriptionType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ResourceObjectShadowChangeDescriptionType that = ((ResourceObjectShadowChangeDescriptionType) object);
        {
            ObjectChangeType lhsObjectChange;
            lhsObjectChange = this.getObjectChange();
            ObjectChangeType rhsObjectChange;
            rhsObjectChange = that.getObjectChange();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "objectChange", lhsObjectChange), LocatorUtils.property(thatLocator, "objectChange", rhsObjectChange), lhsObjectChange, rhsObjectChange)) {
                return false;
            }
        }
        {
            String lhsSourceChannel;
            lhsSourceChannel = this.getSourceChannel();
            String rhsSourceChannel;
            rhsSourceChannel = that.getSourceChannel();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sourceChannel", lhsSourceChannel), LocatorUtils.property(thatLocator, "sourceChannel", rhsSourceChannel), lhsSourceChannel, rhsSourceChannel)) {
                return false;
            }
        }
        {
            ResourceObjectShadowType lhsShadow;
            lhsShadow = this.getShadow();
            ResourceObjectShadowType rhsShadow;
            rhsShadow = that.getShadow();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "shadow", lhsShadow), LocatorUtils.property(thatLocator, "shadow", rhsShadow), lhsShadow, rhsShadow)) {
                return false;
            }
        }
        {
            ResourceType lhsResource;
            lhsResource = this.getResource();
            ResourceType rhsResource;
            rhsResource = that.getResource();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "resource", lhsResource), LocatorUtils.property(thatLocator, "resource", rhsResource), lhsResource, rhsResource)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = new DomAwareEqualsStrategy();
        return equals(null, null, object, strategy);
    }

}
