
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
 *                 This is a container type for various credentials types: passwords, public keys, one-time password
 *                 scheme identifiers, etc. However, we expect that password will be the most widely used credential
 *                 type and that's actually also the only supported type.
 * 
 *                 The reason to "formalize" this structure is the ability to synchronize credentials. If the password
 *                 would be just an ordinary attribute, we cannot automatically synchronize user and account passwords.
 *                 Similarly as other credential types.
 *                 Note: marking password with a special attribute type will not be enough. There may be numerous passwords
 *                 with various meanings, we need to distinguish the "primary" one to synchronize. We also need to store
 *                 user password somewhere.
 * 
 *                 This is not perfect. It may change in the future.
 * 
 *                 TODO: support for "old password", e.g. some resource need it to change password.
 *             
 * 
 * <p>Java class for CredentialsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CredentialsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="password" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}PasswordType" minOccurs="0"/>
 *         &lt;element name="allowedIdmGuiAccess" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CredentialsType", propOrder = {
    "password",
    "allowedIdmGuiAccess"
})
public class CredentialsType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected PasswordType password;
    @XmlElement(defaultValue = "false")
    protected Boolean allowedIdmGuiAccess;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "CredentialsType");

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link PasswordType }
     *     
     */
    public PasswordType getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link PasswordType }
     *     
     */
    public void setPassword(PasswordType value) {
        this.password = value;
    }

    /**
     * Gets the value of the allowedIdmGuiAccess property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowedIdmGuiAccess() {
        return allowedIdmGuiAccess;
    }

    /**
     * Sets the value of the allowedIdmGuiAccess property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowedIdmGuiAccess(Boolean value) {
        this.allowedIdmGuiAccess = value;
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
            PasswordType thePassword;
            thePassword = this.getPassword();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "password", thePassword), currentHashCode, thePassword);
        }
        {
            Boolean theAllowedIdmGuiAccess;
            theAllowedIdmGuiAccess = this.isAllowedIdmGuiAccess();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "allowedIdmGuiAccess", theAllowedIdmGuiAccess), currentHashCode, theAllowedIdmGuiAccess);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CredentialsType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CredentialsType that = ((CredentialsType) object);
        {
            PasswordType lhsPassword;
            lhsPassword = this.getPassword();
            PasswordType rhsPassword;
            rhsPassword = that.getPassword();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "password", lhsPassword), LocatorUtils.property(thatLocator, "password", rhsPassword), lhsPassword, rhsPassword)) {
                return false;
            }
        }
        {
            Boolean lhsAllowedIdmGuiAccess;
            lhsAllowedIdmGuiAccess = this.isAllowedIdmGuiAccess();
            Boolean rhsAllowedIdmGuiAccess;
            rhsAllowedIdmGuiAccess = that.isAllowedIdmGuiAccess();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "allowedIdmGuiAccess", lhsAllowedIdmGuiAccess), LocatorUtils.property(thatLocator, "allowedIdmGuiAccess", rhsAllowedIdmGuiAccess), lhsAllowedIdmGuiAccess, rhsAllowedIdmGuiAccess)) {
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
