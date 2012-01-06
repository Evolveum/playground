
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * 
 *                 Type that defines activation properties. Determines whether something is active
 *                 (and working) or inactive (e.g. disabled).
 * 
 *                 It applies to several object types. It may apply to user, account, assignement, etc.
 *                 The data in this type define if the described concept is active, from when it is active
 *                 and until when. The "active" means that it works. If something is not active, it should
 *                 not work or not cause any effect. E.g. inactive user should not be able to log in or run
 *                 any tasks, the non-active role should not be assigned and if assigned it should not be
 *                 taken into account when computing the accounts.
 *             
 * 
 * <p>Java class for ActivationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActivationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="validFrom" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="validTo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivationType", propOrder = {
    "enabled",
    "validFrom",
    "validTo"
})
public class ActivationType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected Boolean enabled;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validFrom;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validTo;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ActivationType");

    /**
     * Gets the value of the enabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnabled(Boolean value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the validFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidFrom() {
        return validFrom;
    }

    /**
     * Sets the value of the validFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidFrom(XMLGregorianCalendar value) {
        this.validFrom = value;
    }

    /**
     * Gets the value of the validTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidTo() {
        return validTo;
    }

    /**
     * Sets the value of the validTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidTo(XMLGregorianCalendar value) {
        this.validTo = value;
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
            Boolean theEnabled;
            theEnabled = this.isEnabled();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "enabled", theEnabled), currentHashCode, theEnabled);
        }
        {
            XMLGregorianCalendar theValidFrom;
            theValidFrom = this.getValidFrom();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validFrom", theValidFrom), currentHashCode, theValidFrom);
        }
        {
            XMLGregorianCalendar theValidTo;
            theValidTo = this.getValidTo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validTo", theValidTo), currentHashCode, theValidTo);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ActivationType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ActivationType that = ((ActivationType) object);
        {
            Boolean lhsEnabled;
            lhsEnabled = this.isEnabled();
            Boolean rhsEnabled;
            rhsEnabled = that.isEnabled();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "enabled", lhsEnabled), LocatorUtils.property(thatLocator, "enabled", rhsEnabled), lhsEnabled, rhsEnabled)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsValidFrom;
            lhsValidFrom = this.getValidFrom();
            XMLGregorianCalendar rhsValidFrom;
            rhsValidFrom = that.getValidFrom();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "validFrom", lhsValidFrom), LocatorUtils.property(thatLocator, "validFrom", rhsValidFrom), lhsValidFrom, rhsValidFrom)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsValidTo;
            lhsValidTo = this.getValidTo();
            XMLGregorianCalendar rhsValidTo;
            rhsValidTo = that.getValidTo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "validTo", lhsValidTo), LocatorUtils.property(thatLocator, "validTo", rhsValidTo), lhsValidTo, rhsValidTo)) {
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
