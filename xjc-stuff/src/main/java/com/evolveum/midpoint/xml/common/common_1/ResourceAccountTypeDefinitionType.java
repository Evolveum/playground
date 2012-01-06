
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *                 Defiens a type from the resource schema (object class)
 *                 that can be used for creating accounts.
 *             
 * 
 * <p>Java class for ResourceAccountTypeDefinitionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourceAccountTypeDefinitionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}name"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}displayName" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}description" minOccurs="0"/>
 *         &lt;element name="default" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="objectClass" type="{http://www.w3.org/2001/XMLSchema}QName"/>
 *         &lt;element name="attribute" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ResourceAttributeDefinitionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="credentials" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ResourceCredentialsDefinitionType" minOccurs="0"/>
 *         &lt;element name="activation" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ResourceActivationDefinitionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceAccountTypeDefinitionType", propOrder = {
    "name",
    "displayName",
    "description",
    "_default",
    "objectClass",
    "attribute",
    "credentials",
    "activation"
})
public class ResourceAccountTypeDefinitionType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected String name;
    protected String displayName;
    protected String description;
    @XmlElement(name = "default", defaultValue = "false")
    protected Boolean _default;
    @XmlElement(required = true)
    protected QName objectClass;
    protected List<ResourceAttributeDefinitionType> attribute;
    protected ResourceCredentialsDefinitionType credentials;
    protected ResourceActivationDefinitionType activation;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ResourceAccountTypeDefinitionType");

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the displayName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the value of the displayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the default property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDefault() {
        return _default;
    }

    /**
     * Sets the value of the default property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDefault(Boolean value) {
        this._default = value;
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
     * Gets the value of the attribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceAttributeDefinitionType }
     * 
     * 
     */
    public List<ResourceAttributeDefinitionType> getAttribute() {
        if (attribute == null) {
            attribute = new ArrayList<ResourceAttributeDefinitionType>();
        }
        return this.attribute;
    }

    /**
     * Gets the value of the credentials property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceCredentialsDefinitionType }
     *     
     */
    public ResourceCredentialsDefinitionType getCredentials() {
        return credentials;
    }

    /**
     * Sets the value of the credentials property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceCredentialsDefinitionType }
     *     
     */
    public void setCredentials(ResourceCredentialsDefinitionType value) {
        this.credentials = value;
    }

    /**
     * Gets the value of the activation property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceActivationDefinitionType }
     *     
     */
    public ResourceActivationDefinitionType getActivation() {
        return activation;
    }

    /**
     * Sets the value of the activation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceActivationDefinitionType }
     *     
     */
    public void setActivation(ResourceActivationDefinitionType value) {
        this.activation = value;
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
            String theName;
            theName = this.getName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "name", theName), currentHashCode, theName);
        }
        {
            String theDisplayName;
            theDisplayName = this.getDisplayName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "displayName", theDisplayName), currentHashCode, theDisplayName);
        }
        {
            String theDescription;
            theDescription = this.getDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "description", theDescription), currentHashCode, theDescription);
        }
        {
            Boolean theDefault;
            theDefault = this.isDefault();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "_default", theDefault), currentHashCode, theDefault);
        }
        {
            QName theObjectClass;
            theObjectClass = this.getObjectClass();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "objectClass", theObjectClass), currentHashCode, theObjectClass);
        }
        {
            List<ResourceAttributeDefinitionType> theAttribute;
            theAttribute = (((this.attribute!= null)&&(!this.attribute.isEmpty()))?this.getAttribute():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "attribute", theAttribute), currentHashCode, theAttribute);
        }
        {
            ResourceCredentialsDefinitionType theCredentials;
            theCredentials = this.getCredentials();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "credentials", theCredentials), currentHashCode, theCredentials);
        }
        {
            ResourceActivationDefinitionType theActivation;
            theActivation = this.getActivation();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "activation", theActivation), currentHashCode, theActivation);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ResourceAccountTypeDefinitionType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ResourceAccountTypeDefinitionType that = ((ResourceAccountTypeDefinitionType) object);
        {
            String lhsName;
            lhsName = this.getName();
            String rhsName;
            rhsName = that.getName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "name", lhsName), LocatorUtils.property(thatLocator, "name", rhsName), lhsName, rhsName)) {
                return false;
            }
        }
        {
            String lhsDisplayName;
            lhsDisplayName = this.getDisplayName();
            String rhsDisplayName;
            rhsDisplayName = that.getDisplayName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "displayName", lhsDisplayName), LocatorUtils.property(thatLocator, "displayName", rhsDisplayName), lhsDisplayName, rhsDisplayName)) {
                return false;
            }
        }
        {
            String lhsDescription;
            lhsDescription = this.getDescription();
            String rhsDescription;
            rhsDescription = that.getDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "description", lhsDescription), LocatorUtils.property(thatLocator, "description", rhsDescription), lhsDescription, rhsDescription)) {
                return false;
            }
        }
        {
            Boolean lhsDefault;
            lhsDefault = this.isDefault();
            Boolean rhsDefault;
            rhsDefault = that.isDefault();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "_default", lhsDefault), LocatorUtils.property(thatLocator, "_default", rhsDefault), lhsDefault, rhsDefault)) {
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
            List<ResourceAttributeDefinitionType> lhsAttribute;
            lhsAttribute = (((this.attribute!= null)&&(!this.attribute.isEmpty()))?this.getAttribute():null);
            List<ResourceAttributeDefinitionType> rhsAttribute;
            rhsAttribute = (((that.attribute!= null)&&(!that.attribute.isEmpty()))?that.getAttribute():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "attribute", lhsAttribute), LocatorUtils.property(thatLocator, "attribute", rhsAttribute), lhsAttribute, rhsAttribute)) {
                return false;
            }
        }
        {
            ResourceCredentialsDefinitionType lhsCredentials;
            lhsCredentials = this.getCredentials();
            ResourceCredentialsDefinitionType rhsCredentials;
            rhsCredentials = that.getCredentials();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "credentials", lhsCredentials), LocatorUtils.property(thatLocator, "credentials", rhsCredentials), lhsCredentials, rhsCredentials)) {
                return false;
            }
        }
        {
            ResourceActivationDefinitionType lhsActivation;
            lhsActivation = this.getActivation();
            ResourceActivationDefinitionType rhsActivation;
            rhsActivation = that.getActivation();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "activation", lhsActivation), LocatorUtils.property(thatLocator, "activation", rhsActivation), lhsActivation, rhsActivation)) {
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
