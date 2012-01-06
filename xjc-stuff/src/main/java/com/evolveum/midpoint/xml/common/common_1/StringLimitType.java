
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
 * Definition of valid single string limitation
 *             
 * 
 * <p>Java class for StringLimitType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StringLimitType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minOccurs" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxOccurs" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="mustBeFirst" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="characterClass" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}CharacterClassType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StringLimitType", propOrder = {
    "description",
    "minOccurs",
    "maxOccurs",
    "mustBeFirst",
    "characterClass"
})
public class StringLimitType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected String description;
    @XmlElement(defaultValue = "0")
    protected Integer minOccurs;
    @XmlElement(defaultValue = "-1")
    protected Integer maxOccurs;
    @XmlElement(defaultValue = "false")
    protected Boolean mustBeFirst;
    protected CharacterClassType characterClass;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "StringLimitType");

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
     * Gets the value of the minOccurs property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinOccurs() {
        return minOccurs;
    }

    /**
     * Sets the value of the minOccurs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinOccurs(Integer value) {
        this.minOccurs = value;
    }

    /**
     * Gets the value of the maxOccurs property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxOccurs() {
        return maxOccurs;
    }

    /**
     * Sets the value of the maxOccurs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxOccurs(Integer value) {
        this.maxOccurs = value;
    }

    /**
     * Gets the value of the mustBeFirst property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMustBeFirst() {
        return mustBeFirst;
    }

    /**
     * Sets the value of the mustBeFirst property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMustBeFirst(Boolean value) {
        this.mustBeFirst = value;
    }

    /**
     * Gets the value of the characterClass property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterClassType }
     *     
     */
    public CharacterClassType getCharacterClass() {
        return characterClass;
    }

    /**
     * Sets the value of the characterClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterClassType }
     *     
     */
    public void setCharacterClass(CharacterClassType value) {
        this.characterClass = value;
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
            String theDescription;
            theDescription = this.getDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "description", theDescription), currentHashCode, theDescription);
        }
        {
            Integer theMinOccurs;
            theMinOccurs = this.getMinOccurs();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "minOccurs", theMinOccurs), currentHashCode, theMinOccurs);
        }
        {
            Integer theMaxOccurs;
            theMaxOccurs = this.getMaxOccurs();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "maxOccurs", theMaxOccurs), currentHashCode, theMaxOccurs);
        }
        {
            Boolean theMustBeFirst;
            theMustBeFirst = this.isMustBeFirst();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mustBeFirst", theMustBeFirst), currentHashCode, theMustBeFirst);
        }
        {
            CharacterClassType theCharacterClass;
            theCharacterClass = this.getCharacterClass();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "characterClass", theCharacterClass), currentHashCode, theCharacterClass);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof StringLimitType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final StringLimitType that = ((StringLimitType) object);
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
            Integer lhsMinOccurs;
            lhsMinOccurs = this.getMinOccurs();
            Integer rhsMinOccurs;
            rhsMinOccurs = that.getMinOccurs();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "minOccurs", lhsMinOccurs), LocatorUtils.property(thatLocator, "minOccurs", rhsMinOccurs), lhsMinOccurs, rhsMinOccurs)) {
                return false;
            }
        }
        {
            Integer lhsMaxOccurs;
            lhsMaxOccurs = this.getMaxOccurs();
            Integer rhsMaxOccurs;
            rhsMaxOccurs = that.getMaxOccurs();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "maxOccurs", lhsMaxOccurs), LocatorUtils.property(thatLocator, "maxOccurs", rhsMaxOccurs), lhsMaxOccurs, rhsMaxOccurs)) {
                return false;
            }
        }
        {
            Boolean lhsMustBeFirst;
            lhsMustBeFirst = this.isMustBeFirst();
            Boolean rhsMustBeFirst;
            rhsMustBeFirst = that.isMustBeFirst();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "mustBeFirst", lhsMustBeFirst), LocatorUtils.property(thatLocator, "mustBeFirst", rhsMustBeFirst), lhsMustBeFirst, rhsMustBeFirst)) {
                return false;
            }
        }
        {
            CharacterClassType lhsCharacterClass;
            lhsCharacterClass = this.getCharacterClass();
            CharacterClassType rhsCharacterClass;
            rhsCharacterClass = that.getCharacterClass();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "characterClass", lhsCharacterClass), LocatorUtils.property(thatLocator, "characterClass", rhsCharacterClass), lhsCharacterClass, rhsCharacterClass)) {
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
