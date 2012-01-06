
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * <p>Java class for StringPolicyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StringPolicyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="limitations" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}limitationsType" minOccurs="0"/>
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
@XmlType(name = "StringPolicyType", propOrder = {
    "description",
    "limitations",
    "characterClass"
})
public class StringPolicyType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected String description;
    protected LimitationsType limitations;
    protected CharacterClassType characterClass;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "StringPolicyType");

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
     * Gets the value of the limitations property.
     * 
     * @return
     *     possible object is
     *     {@link LimitationsType }
     *     
     */
    public LimitationsType getLimitations() {
        return limitations;
    }

    /**
     * Sets the value of the limitations property.
     * 
     * @param value
     *     allowed object is
     *     {@link LimitationsType }
     *     
     */
    public void setLimitations(LimitationsType value) {
        this.limitations = value;
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
            LimitationsType theLimitations;
            theLimitations = this.getLimitations();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "limitations", theLimitations), currentHashCode, theLimitations);
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
        if (!(object instanceof StringPolicyType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final StringPolicyType that = ((StringPolicyType) object);
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
            LimitationsType lhsLimitations;
            lhsLimitations = this.getLimitations();
            LimitationsType rhsLimitations;
            rhsLimitations = that.getLimitations();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "limitations", lhsLimitations), LocatorUtils.property(thatLocator, "limitations", rhsLimitations), lhsLimitations, rhsLimitations)) {
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
