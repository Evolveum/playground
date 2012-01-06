
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
 *                 Describes a change of attributes of a specific
 *                 object.
 *                 All changes are expected to happen
 *                 atomically, but
 *                 there may be
 *                 exceptions. Please check with the
 *                 documentation of the interface
 *                 using this type for
 *                 more
 *                 details.
 * 
 *                 This should
 *                 probably go to some kind
 *                 of common schema.
 *             
 * 
 * <p>Java class for ObjectModificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObjectModificationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}propertyModification" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObjectModificationType", propOrder = {
    "oid",
    "propertyModification"
})
public class ObjectModificationType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected String oid;
    @XmlElement(required = true)
    protected List<PropertyModificationType> propertyModification;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ObjectModificationType");

    /**
     * Gets the value of the oid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOid() {
        return oid;
    }

    /**
     * Sets the value of the oid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOid(String value) {
        this.oid = value;
    }

    /**
     * 
     *                         Describe a change to a single attribute of an
     *                         object.
     *                     Gets the value of the propertyModification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propertyModification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropertyModification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyModificationType }
     * 
     * 
     */
    public List<PropertyModificationType> getPropertyModification() {
        if (propertyModification == null) {
            propertyModification = new ArrayList<PropertyModificationType>();
        }
        return this.propertyModification;
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
            String theOid;
            theOid = this.getOid();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "oid", theOid), currentHashCode, theOid);
        }
        {
            List<PropertyModificationType> thePropertyModification;
            thePropertyModification = (((this.propertyModification!= null)&&(!this.propertyModification.isEmpty()))?this.getPropertyModification():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "propertyModification", thePropertyModification), currentHashCode, thePropertyModification);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ObjectModificationType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ObjectModificationType that = ((ObjectModificationType) object);
        {
            String lhsOid;
            lhsOid = this.getOid();
            String rhsOid;
            rhsOid = that.getOid();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "oid", lhsOid), LocatorUtils.property(thatLocator, "oid", rhsOid), lhsOid, rhsOid)) {
                return false;
            }
        }
        {
            List<PropertyModificationType> lhsPropertyModification;
            lhsPropertyModification = (((this.propertyModification!= null)&&(!this.propertyModification.isEmpty()))?this.getPropertyModification():null);
            List<PropertyModificationType> rhsPropertyModification;
            rhsPropertyModification = (((that.propertyModification!= null)&&(!that.propertyModification.isEmpty()))?that.getPropertyModification():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "propertyModification", lhsPropertyModification), LocatorUtils.property(thatLocator, "propertyModification", rhsPropertyModification), lhsPropertyModification, rhsPropertyModification)) {
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
