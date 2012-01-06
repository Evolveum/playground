
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
 * 
 *                 Account object type. Represents account on a target system. In the minimal form it
 *                 contains only identifiers and meta-data, but it may also be used for locally caching
 *                 the account data (in local repository).
 * 
 *                 This object is supposed to be stored in LOCAL REPOSITORY, it is NOT the object on
 *                 provisioning resource. For that please see the resource schema which is dynamic and may
 *                 be different for each resource.
 *             
 * 
 * <p>Java class for AccountShadowType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountShadowType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ResourceObjectShadowType">
 *       &lt;sequence>
 *         &lt;element name="accountType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="credentials" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}CredentialsType" minOccurs="0"/>
 *         &lt;element name="activation" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ActivationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountShadowType", propOrder = {
    "accountType",
    "credentials",
    "activation"
})
public class AccountShadowType
    extends ResourceObjectShadowType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected String accountType;
    protected CredentialsType credentials;
    protected ActivationType activation;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "AccountShadowType");

    /**
     * Gets the value of the accountType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountType(String value) {
        this.accountType = value;
    }

    /**
     * Gets the value of the credentials property.
     * 
     * @return
     *     possible object is
     *     {@link CredentialsType }
     *     
     */
    public CredentialsType getCredentials() {
        return credentials;
    }

    /**
     * Sets the value of the credentials property.
     * 
     * @param value
     *     allowed object is
     *     {@link CredentialsType }
     *     
     */
    public void setCredentials(CredentialsType value) {
        this.credentials = value;
    }

    /**
     * Gets the value of the activation property.
     * 
     * @return
     *     possible object is
     *     {@link ActivationType }
     *     
     */
    public ActivationType getActivation() {
        return activation;
    }

    /**
     * Sets the value of the activation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivationType }
     *     
     */
    public void setActivation(ActivationType value) {
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
        int currentHashCode = super.hashCode(locator, strategy);
        {
            String theAccountType;
            theAccountType = this.getAccountType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accountType", theAccountType), currentHashCode, theAccountType);
        }
        {
            CredentialsType theCredentials;
            theCredentials = this.getCredentials();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "credentials", theCredentials), currentHashCode, theCredentials);
        }
        {
            ActivationType theActivation;
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
        if (!(object instanceof AccountShadowType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final AccountShadowType that = ((AccountShadowType) object);
        {
            String lhsAccountType;
            lhsAccountType = this.getAccountType();
            String rhsAccountType;
            rhsAccountType = that.getAccountType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "accountType", lhsAccountType), LocatorUtils.property(thatLocator, "accountType", rhsAccountType), lhsAccountType, rhsAccountType)) {
                return false;
            }
        }
        {
            CredentialsType lhsCredentials;
            lhsCredentials = this.getCredentials();
            CredentialsType rhsCredentials;
            rhsCredentials = that.getCredentials();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "credentials", lhsCredentials), LocatorUtils.property(thatLocator, "credentials", rhsCredentials), lhsCredentials, rhsCredentials)) {
                return false;
            }
        }
        {
            ActivationType lhsActivation;
            lhsActivation = this.getActivation();
            ActivationType rhsActivation;
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
