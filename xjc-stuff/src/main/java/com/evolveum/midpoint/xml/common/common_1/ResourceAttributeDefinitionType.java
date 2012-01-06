
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
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
import org.w3c.dom.Element;


/**
 * 
 *                 Description of the attribute handling details, such as display name,
 *                 read/write access and value and synchronization expressions.
 * 
 *                 This is supposed to be used in schemaHandling part and therefore
 *                 describe the decisions of the system administrator about the
 *                 way how that attribute is used in midPoint.
 * 
 *                 This is supposed to be used only in schemaHandling. It is not a reusable
 *                 data structure now (composition).
 *             
 * 
 * <p>Java class for ResourceAttributeDefinitionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourceAttributeDefinitionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ref" type="{http://www.w3.org/2001/XMLSchema}QName"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}displayName" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}description" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ignore" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}access" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="outbound" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ValueConstructionType" minOccurs="0"/>
 *         &lt;element name="inbound" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ValueAssignmentType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceAttributeDefinitionType", propOrder = {
    "ref",
    "displayName",
    "description",
    "ignore",
    "access",
    "outbound",
    "inbound"
})
public class ResourceAttributeDefinitionType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected QName ref;
    protected String displayName;
    protected String description;
    @XmlElement(defaultValue = "true")
    protected Boolean ignore;
    protected List<AccessType> access;
    protected ValueConstructionType outbound;
    @XmlAnyElement
    protected List<Element> inbound;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ResourceAttributeDefinitionType");

    /**
     * Gets the value of the ref property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setRef(QName value) {
        this.ref = value;
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
     * Gets the value of the ignore property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIgnore() {
        return ignore;
    }

    /**
     * Sets the value of the ignore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIgnore(Boolean value) {
        this.ignore = value;
    }

    /**
     * 
     *                         Access to the attribute as defined by the system administrator or deployer.
     *                         This can constrain the access defined by resource schema annotations.
     *                         Specifying broader access that the resource connector can handle is an
     *                         error.
     * 
     *                         If no access is specified, it defaults to access definition specified in the
     *                         resource schema annotations.
     *                     Gets the value of the access property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the access property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccess().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccessType }
     * 
     * 
     */
    public List<AccessType> getAccess() {
        if (access == null) {
            access = new ArrayList<AccessType>();
        }
        return this.access;
    }

    /**
     * Gets the value of the outbound property.
     * 
     * @return
     *     possible object is
     *     {@link ValueConstructionType }
     *     
     */
    public ValueConstructionType getOutbound() {
        return outbound;
    }

    /**
     * Sets the value of the outbound property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueConstructionType }
     *     
     */
    public void setOutbound(ValueConstructionType value) {
        this.outbound = value;
    }

    /**
     * Gets the value of the inbound property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inbound property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInbound().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * 
     * 
     */
    public List<Element> getInbound() {
        if (inbound == null) {
            inbound = new ArrayList<Element>();
        }
        return this.inbound;
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
            QName theRef;
            theRef = this.getRef();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ref", theRef), currentHashCode, theRef);
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
            Boolean theIgnore;
            theIgnore = this.isIgnore();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ignore", theIgnore), currentHashCode, theIgnore);
        }
        {
            List<AccessType> theAccess;
            theAccess = (((this.access!= null)&&(!this.access.isEmpty()))?this.getAccess():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "access", theAccess), currentHashCode, theAccess);
        }
        {
            ValueConstructionType theOutbound;
            theOutbound = this.getOutbound();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "outbound", theOutbound), currentHashCode, theOutbound);
        }
        {
            List<Element> theInbound;
            theInbound = (((this.inbound!= null)&&(!this.inbound.isEmpty()))?this.getInbound():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inbound", theInbound), currentHashCode, theInbound);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ResourceAttributeDefinitionType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ResourceAttributeDefinitionType that = ((ResourceAttributeDefinitionType) object);
        {
            QName lhsRef;
            lhsRef = this.getRef();
            QName rhsRef;
            rhsRef = that.getRef();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ref", lhsRef), LocatorUtils.property(thatLocator, "ref", rhsRef), lhsRef, rhsRef)) {
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
            Boolean lhsIgnore;
            lhsIgnore = this.isIgnore();
            Boolean rhsIgnore;
            rhsIgnore = that.isIgnore();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ignore", lhsIgnore), LocatorUtils.property(thatLocator, "ignore", rhsIgnore), lhsIgnore, rhsIgnore)) {
                return false;
            }
        }
        {
            List<AccessType> lhsAccess;
            lhsAccess = (((this.access!= null)&&(!this.access.isEmpty()))?this.getAccess():null);
            List<AccessType> rhsAccess;
            rhsAccess = (((that.access!= null)&&(!that.access.isEmpty()))?that.getAccess():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "access", lhsAccess), LocatorUtils.property(thatLocator, "access", rhsAccess), lhsAccess, rhsAccess)) {
                return false;
            }
        }
        {
            ValueConstructionType lhsOutbound;
            lhsOutbound = this.getOutbound();
            ValueConstructionType rhsOutbound;
            rhsOutbound = that.getOutbound();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "outbound", lhsOutbound), LocatorUtils.property(thatLocator, "outbound", rhsOutbound), lhsOutbound, rhsOutbound)) {
                return false;
            }
        }
        {
            List<Element> lhsInbound;
            lhsInbound = (((this.inbound!= null)&&(!this.inbound.isEmpty()))?this.getInbound():null);
            List<Element> rhsInbound;
            rhsInbound = (((that.inbound!= null)&&(!that.inbound.isEmpty()))?that.getInbound():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "inbound", lhsInbound), LocatorUtils.property(thatLocator, "inbound", rhsInbound), lhsInbound, rhsInbound)) {
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
