
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 * <p>Java class for PasswordType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PasswordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="protectedString" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ProtectedStringType"/>
 *         &lt;element name="failedLogins" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="lastFailedLoginTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PasswordType", propOrder = {
    "protectedString",
    "failedLogins",
    "lastFailedLoginTimestamp"
})
public class PasswordType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected ProtectedStringType protectedString;
    protected BigInteger failedLogins;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastFailedLoginTimestamp;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "PasswordType");

    /**
     * Gets the value of the protectedString property.
     * 
     * @return
     *     possible object is
     *     {@link ProtectedStringType }
     *     
     */
    public ProtectedStringType getProtectedString() {
        return protectedString;
    }

    /**
     * Sets the value of the protectedString property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProtectedStringType }
     *     
     */
    public void setProtectedString(ProtectedStringType value) {
        this.protectedString = value;
    }

    /**
     * Gets the value of the failedLogins property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFailedLogins() {
        return failedLogins;
    }

    /**
     * Sets the value of the failedLogins property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFailedLogins(BigInteger value) {
        this.failedLogins = value;
    }

    /**
     * Gets the value of the lastFailedLoginTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastFailedLoginTimestamp() {
        return lastFailedLoginTimestamp;
    }

    /**
     * Sets the value of the lastFailedLoginTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastFailedLoginTimestamp(XMLGregorianCalendar value) {
        this.lastFailedLoginTimestamp = value;
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
            ProtectedStringType theProtectedString;
            theProtectedString = this.getProtectedString();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "protectedString", theProtectedString), currentHashCode, theProtectedString);
        }
        {
            BigInteger theFailedLogins;
            theFailedLogins = this.getFailedLogins();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "failedLogins", theFailedLogins), currentHashCode, theFailedLogins);
        }
        {
            XMLGregorianCalendar theLastFailedLoginTimestamp;
            theLastFailedLoginTimestamp = this.getLastFailedLoginTimestamp();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lastFailedLoginTimestamp", theLastFailedLoginTimestamp), currentHashCode, theLastFailedLoginTimestamp);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PasswordType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PasswordType that = ((PasswordType) object);
        {
            ProtectedStringType lhsProtectedString;
            lhsProtectedString = this.getProtectedString();
            ProtectedStringType rhsProtectedString;
            rhsProtectedString = that.getProtectedString();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "protectedString", lhsProtectedString), LocatorUtils.property(thatLocator, "protectedString", rhsProtectedString), lhsProtectedString, rhsProtectedString)) {
                return false;
            }
        }
        {
            BigInteger lhsFailedLogins;
            lhsFailedLogins = this.getFailedLogins();
            BigInteger rhsFailedLogins;
            rhsFailedLogins = that.getFailedLogins();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "failedLogins", lhsFailedLogins), LocatorUtils.property(thatLocator, "failedLogins", rhsFailedLogins), lhsFailedLogins, rhsFailedLogins)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsLastFailedLoginTimestamp;
            lhsLastFailedLoginTimestamp = this.getLastFailedLoginTimestamp();
            XMLGregorianCalendar rhsLastFailedLoginTimestamp;
            rhsLastFailedLoginTimestamp = that.getLastFailedLoginTimestamp();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lastFailedLoginTimestamp", lhsLastFailedLoginTimestamp), LocatorUtils.property(thatLocator, "lastFailedLoginTimestamp", rhsLastFailedLoginTimestamp), lhsLastFailedLoginTimestamp, rhsLastFailedLoginTimestamp)) {
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
