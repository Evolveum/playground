
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
 * <p>Java class for PasswordLifeTimeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PasswordLifeTimeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="expiration" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="warnBeforeExpiration" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="lockAfterExpiration" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="minPasswordAge" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="passwordHistoryLength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PasswordLifeTimeType", propOrder = {
    "expiration",
    "warnBeforeExpiration",
    "lockAfterExpiration",
    "minPasswordAge",
    "passwordHistoryLength"
})
public class PasswordLifeTimeType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(defaultValue = "-1")
    protected Integer expiration;
    @XmlElement(defaultValue = "0")
    protected Integer warnBeforeExpiration;
    @XmlElement(defaultValue = "0")
    protected Integer lockAfterExpiration;
    @XmlElement(defaultValue = "0")
    protected Integer minPasswordAge;
    @XmlElement(defaultValue = "0")
    protected Integer passwordHistoryLength;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "PasswordLifeTimeType");

    /**
     * Gets the value of the expiration property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getExpiration() {
        return expiration;
    }

    /**
     * Sets the value of the expiration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExpiration(Integer value) {
        this.expiration = value;
    }

    /**
     * Gets the value of the warnBeforeExpiration property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWarnBeforeExpiration() {
        return warnBeforeExpiration;
    }

    /**
     * Sets the value of the warnBeforeExpiration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWarnBeforeExpiration(Integer value) {
        this.warnBeforeExpiration = value;
    }

    /**
     * Gets the value of the lockAfterExpiration property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLockAfterExpiration() {
        return lockAfterExpiration;
    }

    /**
     * Sets the value of the lockAfterExpiration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLockAfterExpiration(Integer value) {
        this.lockAfterExpiration = value;
    }

    /**
     * Gets the value of the minPasswordAge property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinPasswordAge() {
        return minPasswordAge;
    }

    /**
     * Sets the value of the minPasswordAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinPasswordAge(Integer value) {
        this.minPasswordAge = value;
    }

    /**
     * Gets the value of the passwordHistoryLength property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPasswordHistoryLength() {
        return passwordHistoryLength;
    }

    /**
     * Sets the value of the passwordHistoryLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPasswordHistoryLength(Integer value) {
        this.passwordHistoryLength = value;
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
            Integer theExpiration;
            theExpiration = this.getExpiration();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "expiration", theExpiration), currentHashCode, theExpiration);
        }
        {
            Integer theWarnBeforeExpiration;
            theWarnBeforeExpiration = this.getWarnBeforeExpiration();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "warnBeforeExpiration", theWarnBeforeExpiration), currentHashCode, theWarnBeforeExpiration);
        }
        {
            Integer theLockAfterExpiration;
            theLockAfterExpiration = this.getLockAfterExpiration();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lockAfterExpiration", theLockAfterExpiration), currentHashCode, theLockAfterExpiration);
        }
        {
            Integer theMinPasswordAge;
            theMinPasswordAge = this.getMinPasswordAge();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "minPasswordAge", theMinPasswordAge), currentHashCode, theMinPasswordAge);
        }
        {
            Integer thePasswordHistoryLength;
            thePasswordHistoryLength = this.getPasswordHistoryLength();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "passwordHistoryLength", thePasswordHistoryLength), currentHashCode, thePasswordHistoryLength);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PasswordLifeTimeType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PasswordLifeTimeType that = ((PasswordLifeTimeType) object);
        {
            Integer lhsExpiration;
            lhsExpiration = this.getExpiration();
            Integer rhsExpiration;
            rhsExpiration = that.getExpiration();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "expiration", lhsExpiration), LocatorUtils.property(thatLocator, "expiration", rhsExpiration), lhsExpiration, rhsExpiration)) {
                return false;
            }
        }
        {
            Integer lhsWarnBeforeExpiration;
            lhsWarnBeforeExpiration = this.getWarnBeforeExpiration();
            Integer rhsWarnBeforeExpiration;
            rhsWarnBeforeExpiration = that.getWarnBeforeExpiration();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "warnBeforeExpiration", lhsWarnBeforeExpiration), LocatorUtils.property(thatLocator, "warnBeforeExpiration", rhsWarnBeforeExpiration), lhsWarnBeforeExpiration, rhsWarnBeforeExpiration)) {
                return false;
            }
        }
        {
            Integer lhsLockAfterExpiration;
            lhsLockAfterExpiration = this.getLockAfterExpiration();
            Integer rhsLockAfterExpiration;
            rhsLockAfterExpiration = that.getLockAfterExpiration();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lockAfterExpiration", lhsLockAfterExpiration), LocatorUtils.property(thatLocator, "lockAfterExpiration", rhsLockAfterExpiration), lhsLockAfterExpiration, rhsLockAfterExpiration)) {
                return false;
            }
        }
        {
            Integer lhsMinPasswordAge;
            lhsMinPasswordAge = this.getMinPasswordAge();
            Integer rhsMinPasswordAge;
            rhsMinPasswordAge = that.getMinPasswordAge();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "minPasswordAge", lhsMinPasswordAge), LocatorUtils.property(thatLocator, "minPasswordAge", rhsMinPasswordAge), lhsMinPasswordAge, rhsMinPasswordAge)) {
                return false;
            }
        }
        {
            Integer lhsPasswordHistoryLength;
            lhsPasswordHistoryLength = this.getPasswordHistoryLength();
            Integer rhsPasswordHistoryLength;
            rhsPasswordHistoryLength = that.getPasswordHistoryLength();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "passwordHistoryLength", lhsPasswordHistoryLength), LocatorUtils.property(thatLocator, "passwordHistoryLength", rhsPasswordHistoryLength), lhsPasswordHistoryLength, rhsPasswordHistoryLength)) {
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
