package com.evolveum.midpoint.xml.common.common_1;

import com.evolveum.midpoint.xml.common.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public class UserType extends ExtensibleObjectType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    public final static QName ELEMENT_TYPE = new QName(SchemaConstants.NS_COMMON, "UserType");
    public static final QName F_GIVEN_NAME = new QName(SchemaConstants.NS_COMMON, "givenName");
    public static final QName F_FAMILY_NAME = new QName(SchemaConstants.NS_COMMON, "familyName");
    public static final QName F_FULL_NAME = new QName(SchemaConstants.NS_COMMON, "fullName");
    public static final QName F_ADDITIONAL_NAMES = new QName(SchemaConstants.NS_COMMON, "additionalNames");
    public static final QName F_HONORIFIC_PREFIX = new QName(SchemaConstants.NS_COMMON, "honorificPrefix");
    public static final QName F_HONORIFIC_SUFFIX = new QName(SchemaConstants.NS_COMMON, "honorificSuffix");
    public static final QName F_EMAIL_ADDRESS = new QName(SchemaConstants.NS_COMMON, "eMailAddress");
    public static final QName F_TELEPHONE_NUMBER = new QName(SchemaConstants.NS_COMMON, "telephoneNumber");
    public static final QName F_EMPLOYEE_NUMBER = new QName(SchemaConstants.NS_COMMON, "employeeNumber");
    public static final QName F_EMPLOYEE_TYPE = new QName(SchemaConstants.NS_COMMON, "employeeType");
    public static final QName F_ORGANIZATIONAL_UNIT = new QName(SchemaConstants.NS_COMMON, "organizationalUnit");
    public static final QName F_LOCALITY = new QName(SchemaConstants.NS_COMMON, "locality");
    public static final QName F_CREDENTIALS = new QName(SchemaConstants.NS_COMMON, "credentials");
    public static final QName F_ACTIVATION = new QName(SchemaConstants.NS_COMMON, "activation");
    public static final QName F_ASSIGNMENT = new QName(SchemaConstants.NS_COMMON, "assignment");
    public static final QName F_ACCOUNT = new QName(SchemaConstants.NS_COMMON, "account");
    public static final QName F_ACCOUNT_REF = new QName(SchemaConstants.NS_COMMON, "accountRef");

    @XmlElement(required = true)
    public String getGivenName() {
        return getPropertyValue(F_GIVEN_NAME);
    }

    public void setGivenName(String value) {
        setPropertyValue(F_GIVEN_NAME, value);
    }

    @XmlElement(required = true)
    public String getFamilyName() {
        return getPropertyValue(F_FAMILY_NAME);
    }

    public void setFamilyName(String value) {
        setPropertyValue(F_FAMILY_NAME, value);
    }

    public List<String> getAdditionalNames() {
        if (additionalNames == null) {
            additionalNames = new ArrayList<String>();
        }
        return this.additionalNames;
    }

    public String getHonorificPrefix() {
        return getPropertyValue(F_HONORIFIC_PREFIX);
    }

    public void setHonorificPrefix(String value) {
        setPropertyValue(F_HONORIFIC_PREFIX, value);
    }

    public String getHonorificSuffix() {
        return getPropertyValue(F_HONORIFIC_SUFFIX);
    }

    public void setHonorificSuffix(String value) {
        setPropertyValue(F_HONORIFIC_SUFFIX, value);
    }

    public List<String> getEMailAddress() {
        if (eMailAddress == null) {
            eMailAddress = new ArrayList<String>();
        }
        return this.eMailAddress;
    }

    public List<String> getTelephoneNumber() {
        if (telephoneNumber == null) {
            telephoneNumber = new ArrayList<String>();
        }
        return this.telephoneNumber;
    }

    public String getEmployeeNumber() {
        return getPropertyValue(F_EMPLOYEE_NUMBER);
    }

    public void setEmployeeNumber(String value) {
        setPropertyValue(F_EMPLOYEE_NUMBER, value);
    }

    public List<String> getEmployeeType() {
        if (employeeType == null) {
            employeeType = new ArrayList<String>();
        }
        return this.employeeType;
    }

    public List<String> getOrganizationalUnit() {
        if (organizationalUnit == null) {
            organizationalUnit = new ArrayList<String>();
        }
        return this.organizationalUnit;
    }

    public String getLocality() {
        return getPropertyValue(F_LOCALITY);
    }

    public void setLocality(String value) {
        setPropertyValue(F_LOCALITY, value);
    }

    public CredentialsType getCredentials() {
        return credentials;
    }

    public void setCredentials(CredentialsType value) {
        this.credentials = value;
    }

    public ActivationType getActivation() {
        return activation;
    }

    public void setActivation(ActivationType value) {
        this.activation = value;
    }

    public List<AssignmentType> getAssignment() {
        if (assignment == null) {
            assignment = new ArrayList<AssignmentType>();
        }
        return this.assignment;
    }

    public List<AccountShadowType> getAccount() {
        if (account == null) {
            account = new ArrayList<AccountShadowType>();
        }
        return this.account;
    }

    public List<ObjectReferenceType> getAccountRef() {
        if (accountRef == null) {
            accountRef = new ArrayList<ObjectReferenceType>();
        }
        return this.accountRef;
    }

    @XmlElement(required = true)
    public String getFullName() {
        return getPropertyValue(F_FULL_NAME);
    }

    public void setFullName(String fullName) {
        setPropertyValue(F_FULL_NAME, fullName);
    }
}
