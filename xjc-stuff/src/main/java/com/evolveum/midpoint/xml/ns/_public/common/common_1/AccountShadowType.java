package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Account object type. Represents account on a target system. In the minimal form it
 * contains only identifiers and meta-data, but it may also be used for locally caching
 * the account data (in local repository).
 * <p/>
 * This object is supposed to be stored in LOCAL REPOSITORY, it is NOT the object on
 * provisioning resource. For that please see the resource schema which is dynamic and may
 * be different for each resource.
 * <p/>
 * <p/>
 * <p>Java class for AccountShadowType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
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
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountShadowType", propOrder = {
        "accountType",
        "credentials",
        "activation"
})
public class AccountShadowType
        extends ResourceObjectShadowType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected CredentialsType credentials;
    protected ActivationType activation;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "AccountShadowType");
    public final static QName F_ACCOUNT_TYPE = new QName(SchemaConstants.NS_COMMON, "accountType");
    public final static QName F_CREDENTIALS = new QName(SchemaConstants.NS_COMMON, "credentials");
    public final static QName F_ACTIVATION = new QName(SchemaConstants.NS_COMMON, "activation");

    /**
     * Gets the value of the credentials property.
     *
     * @return possible object is
     *         {@link CredentialsType }
     */
    public CredentialsType getCredentials() {
        return credentials;
    }

    /**
     * Gets the value of the activation property.
     *
     * @return possible object is
     *         {@link ActivationType }
     */
    public ActivationType getActivation() {
        return activation;
    }

    public String getAccountType() {
        return getPropertyValue(F_ACCOUNT_TYPE, String.class);
    }

    public void setAccountType(String value) {
        setPropertyValue(F_ACCOUNT_TYPE, value);
    }

    public void setCredentials(CredentialsType value) {
        //todo do not use setValue but remove container from parent property container, update if user set/remove method
        this.credentials = value;
        if (value == null) {
            setPropertyValue(F_CREDENTIALS, null);
        } else {
            setPropertyValue(F_CREDENTIALS, value.getContainer());
        }
    }

    public void setActivation(ActivationType value) {
        //todo do not use setValue but remove container from parent property container, update if user set/remove method
        this.activation = value;
        if (value == null) {
            setPropertyValue(F_ACTIVATION, null);
        } else {
            setPropertyValue(F_ACTIVATION, value.getContainer());
        }
    }

}
