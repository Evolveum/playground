package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.List;


/**
 * User object type. Represents physical user of the system.
 * <p/>
 * TODO: More details
 * <p/>
 * Inspired by FOAF, but still quite LDAP-ish.
 * <p/>
 * <p/>
 * <p>Java class for UserType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UserType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExtensibleObjectType">
 *       &lt;sequence>
 *         &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="givenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="familyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="additionalNames" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="honorificPrefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="honorificSuffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eMailAddress" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="telephoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="employeeNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="employeeType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="organizationalUnit" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="locality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="credentials" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}CredentialsType" minOccurs="0"/>
 *         &lt;element name="activation" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ActivationType" minOccurs="0"/>
 *         &lt;element name="assignment" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}AssignmentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="account" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}AccountShadowType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="accountRef" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectReferenceType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserType", propOrder = {
        "fullName",
        "givenName",
        "familyName",
        "additionalNames",
        "honorificPrefix",
        "honorificSuffix",
        "eMailAddress",
        "telephoneNumber",
        "employeeNumber",
        "employeeType",
        "organizationalUnit",
        "locality",
        "credentials",
        "activation",
        "assignment",
        "account",
        "accountRef"
})
public class UserType
        extends ExtensibleObjectType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected CredentialsType credentials;
    protected ActivationType activation;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "UserType");
    public final static QName F_FULL_NAME = new QName(SchemaConstants.NS_COMMON, "fullName");
    public final static QName F_GIVEN_NAME = new QName(SchemaConstants.NS_COMMON, "givenName");
    public final static QName F_FAMILY_NAME = new QName(SchemaConstants.NS_COMMON, "familyName");
    public final static QName F_ADDITIONAL_NAMES = new QName(SchemaConstants.NS_COMMON, "additionalNames");
    public final static QName F_HONORIFIC_PREFIX = new QName(SchemaConstants.NS_COMMON, "honorificPrefix");
    public final static QName F_HONORIFIC_SUFFIX = new QName(SchemaConstants.NS_COMMON, "honorificSuffix");
    public final static QName F_E_MAIL_ADDRESS = new QName(SchemaConstants.NS_COMMON, "eMailAddress");
    public final static QName F_TELEPHONE_NUMBER = new QName(SchemaConstants.NS_COMMON, "telephoneNumber");
    public final static QName F_EMPLOYEE_NUMBER = new QName(SchemaConstants.NS_COMMON, "employeeNumber");
    public final static QName F_EMPLOYEE_TYPE = new QName(SchemaConstants.NS_COMMON, "employeeType");
    public final static QName F_ORGANIZATIONAL_UNIT = new QName(SchemaConstants.NS_COMMON, "organizationalUnit");
    public final static QName F_LOCALITY = new QName(SchemaConstants.NS_COMMON, "locality");
    public final static QName F_CREDENTIALS = new QName(SchemaConstants.NS_COMMON, "credentials");
    public final static QName F_ACTIVATION = new QName(SchemaConstants.NS_COMMON, "activation");
    public final static QName F_ASSIGNMENT = new QName(SchemaConstants.NS_COMMON, "assignment");
    public final static QName F_ACCOUNT = new QName(SchemaConstants.NS_COMMON, "account");
    public final static QName F_ACCOUNT_REF = new QName(SchemaConstants.NS_COMMON, "accountRef");

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

    @XmlElement(required = true)
    public String getFullName() {
        return getPropertyValue(F_FULL_NAME, String.class);
    }

    public void setFullName(String value) {
        setPropertyValue(F_FULL_NAME, value);
    }

    @XmlElement(required = true)
    public String getGivenName() {
        return getPropertyValue(F_GIVEN_NAME, String.class);
    }

    public void setGivenName(String value) {
        setPropertyValue(F_GIVEN_NAME, value);
    }

    @XmlElement(required = true)
    public String getFamilyName() {
        return getPropertyValue(F_FAMILY_NAME, String.class);
    }

    public void setFamilyName(String value) {
        setPropertyValue(F_FAMILY_NAME, value);
    }

    public List<String> getAdditionalNames() {
        return getPropertyValues(F_ADDITIONAL_NAMES, String.class);
    }

    public String getHonorificPrefix() {
        return getPropertyValue(F_HONORIFIC_PREFIX, String.class);
    }

    public void setHonorificPrefix(String value) {
        setPropertyValue(F_HONORIFIC_PREFIX, value);
    }

    public String getHonorificSuffix() {
        return getPropertyValue(F_HONORIFIC_SUFFIX, String.class);
    }

    public void setHonorificSuffix(String value) {
        setPropertyValue(F_HONORIFIC_SUFFIX, value);
    }

    public List<String> getEMailAddress() {
        return getPropertyValues(F_E_MAIL_ADDRESS, String.class);
    }

    public List<String> getTelephoneNumber() {
        return getPropertyValues(F_TELEPHONE_NUMBER, String.class);
    }

    public String getEmployeeNumber() {
        return getPropertyValue(F_EMPLOYEE_NUMBER, String.class);
    }

    public void setEmployeeNumber(String value) {
        setPropertyValue(F_EMPLOYEE_NUMBER, value);
    }

    public List<String> getEmployeeType() {
        return getPropertyValues(F_EMPLOYEE_TYPE, String.class);
    }

    public List<String> getOrganizationalUnit() {
        return getPropertyValues(F_ORGANIZATIONAL_UNIT, String.class);
    }

    public String getLocality() {
        return getPropertyValue(F_LOCALITY, String.class);
    }

    public void setLocality(String value) {
        setPropertyValue(F_LOCALITY, value);
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

    public List<AssignmentType> getAssignment() {
        return getPropertyValues(F_ASSIGNMENT, AssignmentType.class);
    }

    public List<AccountShadowType> getAccount() {
        return getPropertyValues(F_ACCOUNT, AccountShadowType.class);
    }

    public List<ObjectReferenceType> getAccountRef() {
        return getPropertyValues(F_ACCOUNT_REF, ObjectReferenceType.class);
    }

}
