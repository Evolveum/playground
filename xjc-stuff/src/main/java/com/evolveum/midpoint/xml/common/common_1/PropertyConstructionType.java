
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
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
 *                 Definition of construction of a (general)
 *                 property. The property
 *                 may be constructed as a static
 *                 value of as a
 *                 result of an
 *                 expression (See ValueConstructionType documentation).
 *                 This can be used e.g. to constuct a
 *                 value for user's
 *                 fullName
 *                 in User
 *                 Template or also on other places in the future.
 *             
 * 
 * <p>Java class for PropertyConstructionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyConstructionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}PropertyReferenceType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}description" minOccurs="0"/>
 *         &lt;element name="valueConstruction" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ValueConstructionType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyConstructionType", propOrder = {
    "description",
    "valueConstruction"
})
public class PropertyConstructionType
    extends PropertyReferenceType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected String description;
    @XmlElement(required = true)
    protected ValueConstructionType valueConstruction;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "PropertyConstructionType");

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
     * Gets the value of the valueConstruction property.
     * 
     * @return
     *     possible object is
     *     {@link ValueConstructionType }
     *     
     */
    public ValueConstructionType getValueConstruction() {
        return valueConstruction;
    }

    /**
     * Sets the value of the valueConstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueConstructionType }
     *     
     */
    public void setValueConstruction(ValueConstructionType value) {
        this.valueConstruction = value;
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
            String theDescription;
            theDescription = this.getDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "description", theDescription), currentHashCode, theDescription);
        }
        {
            ValueConstructionType theValueConstruction;
            theValueConstruction = this.getValueConstruction();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "valueConstruction", theValueConstruction), currentHashCode, theValueConstruction);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PropertyConstructionType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final PropertyConstructionType that = ((PropertyConstructionType) object);
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
            ValueConstructionType lhsValueConstruction;
            lhsValueConstruction = this.getValueConstruction();
            ValueConstructionType rhsValueConstruction;
            rhsValueConstruction = that.getValueConstruction();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "valueConstruction", lhsValueConstruction), LocatorUtils.property(thatLocator, "valueConstruction", rhsValueConstruction), lhsValueConstruction, rhsValueConstruction)) {
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
