
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;
import org.w3c.dom.Element;


/**
 * 
 *                 Local copy of any object on the provisioning resource that is related to provisioning.
 *                 It may be account, group, role (on the target system), privilege, security label,
 *                 organizational unit or anything else that is worth managing in identity management.
 * 
 *                 This XML object provides a representation of the resource object in the IDM system, in
 *                 the LOCAL REPOSITORY. It may represents a minimal data structure in IDM repository
 *                 that contains only identifier and nothing else. It may also represent a rich structure
 *                 with a lot of cached or fetched data. The actual content of this object depends on usage:
 *                 on the specific interface and operation used and even on the system state and configuration.
 *             
 * 
 * <p>Java class for ResourceObjectShadowType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourceObjectShadowType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExtensibleObjectType">
 *       &lt;sequence>
 *         &lt;element name="resourceRef" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectReferenceType" minOccurs="0"/>
 *         &lt;element name="resource" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ResourceType" minOccurs="0"/>
 *         &lt;element name="objectClass" type="{http://www.w3.org/2001/XMLSchema}QName"/>
 *         &lt;element name="attributes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceObjectShadowType", propOrder = {
    "resourceRef",
    "resource",
    "objectClass",
    "attributes"
})
@XmlSeeAlso({
    AccountShadowType.class
})
public class ResourceObjectShadowType
    extends ExtensibleObjectType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected ObjectReferenceType resourceRef;
    protected ResourceType resource;
    @XmlElement(required = true)
    protected QName objectClass;
    @XmlElement(required = true)
    protected ResourceObjectShadowType.Attributes attributes;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ResourceObjectShadowType");

    /**
     * Gets the value of the resourceRef property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectReferenceType }
     *     
     */
    public ObjectReferenceType getResourceRef() {
        return resourceRef;
    }

    /**
     * Sets the value of the resourceRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectReferenceType }
     *     
     */
    public void setResourceRef(ObjectReferenceType value) {
        this.resourceRef = value;
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
     * Gets the value of the objectClass property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getObjectClass() {
        return objectClass;
    }

    /**
     * Sets the value of the objectClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setObjectClass(QName value) {
        this.objectClass = value;
    }

    /**
     * Gets the value of the attributes property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceObjectShadowType.Attributes }
     *     
     */
    public ResourceObjectShadowType.Attributes getAttributes() {
        return attributes;
    }

    /**
     * Sets the value of the attributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceObjectShadowType.Attributes }
     *     
     */
    public void setAttributes(ResourceObjectShadowType.Attributes value) {
        this.attributes = value;
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
        int currentHashCode = super.hashCode(locator, strategy);
        {
            ObjectReferenceType theResourceRef;
            theResourceRef = this.getResourceRef();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resourceRef", theResourceRef), currentHashCode, theResourceRef);
        }
        {
            ResourceType theResource;
            theResource = this.getResource();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resource", theResource), currentHashCode, theResource);
        }
        {
            QName theObjectClass;
            theObjectClass = this.getObjectClass();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "objectClass", theObjectClass), currentHashCode, theObjectClass);
        }
        {
            ResourceObjectShadowType.Attributes theAttributes;
            theAttributes = this.getAttributes();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "attributes", theAttributes), currentHashCode, theAttributes);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new com.evolveum.midpoint.schema.DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ResourceObjectShadowType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final ResourceObjectShadowType that = ((ResourceObjectShadowType) object);
        {
            ObjectReferenceType lhsResourceRef;
            lhsResourceRef = this.getResourceRef();
            ObjectReferenceType rhsResourceRef;
            rhsResourceRef = that.getResourceRef();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "resourceRef", lhsResourceRef), LocatorUtils.property(thatLocator, "resourceRef", rhsResourceRef), lhsResourceRef, rhsResourceRef)) {
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
        {
            QName lhsObjectClass;
            lhsObjectClass = this.getObjectClass();
            QName rhsObjectClass;
            rhsObjectClass = that.getObjectClass();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "objectClass", lhsObjectClass), LocatorUtils.property(thatLocator, "objectClass", rhsObjectClass), lhsObjectClass, rhsObjectClass)) {
                return false;
            }
        }
        {
            ResourceObjectShadowType.Attributes lhsAttributes;
            lhsAttributes = this.getAttributes();
            ResourceObjectShadowType.Attributes rhsAttributes;
            rhsAttributes = that.getAttributes();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "attributes", lhsAttributes), LocatorUtils.property(thatLocator, "attributes", rhsAttributes), lhsAttributes, rhsAttributes)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = new com.evolveum.midpoint.schema.DomAwareEqualsStrategy();
        return equals(null, null, object, strategy);
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class Attributes
        implements Serializable, Equals, HashCode
    {

        private final static long serialVersionUID = 201105211233L;
        @XmlAnyElement(lax = true)
        protected List<Object> any;

        /**
         * Gets the value of the any property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the any property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Element }
         * {@link Object }
         * 
         * 
         */
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
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
                List<Object> theAny;
                theAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "any", theAny), currentHashCode, theAny);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = new com.evolveum.midpoint.schema.DomAwareHashCodeStrategy();
            return this.hashCode(null, strategy);
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof ResourceObjectShadowType.Attributes)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final ResourceObjectShadowType.Attributes that = ((ResourceObjectShadowType.Attributes) object);
            {
                List<Object> lhsAny;
                lhsAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
                List<Object> rhsAny;
                rhsAny = (((that.any!= null)&&(!that.any.isEmpty()))?that.getAny():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "any", lhsAny), LocatorUtils.property(thatLocator, "any", rhsAny), lhsAny, rhsAny)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object object) {
            final EqualsStrategy strategy = new com.evolveum.midpoint.schema.DomAwareEqualsStrategy();
            return equals(null, null, object, strategy);
        }

    }

}
