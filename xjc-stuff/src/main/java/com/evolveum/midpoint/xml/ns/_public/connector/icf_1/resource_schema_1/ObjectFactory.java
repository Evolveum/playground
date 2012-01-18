package com.evolveum.midpoint.xml.ns._public.connector.icf_1.resource_schema_1;

import com.evolveum.midpoint.xml.ns._public.common.common_1.ProtectedStringType;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.evolveum.midpoint.xml.ns._public.connector.icf_1.resource_schema_1 package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PasswordExpired_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", "passwordExpired");
    private final static QName _Enable_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", "enable");
    private final static QName _Password_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", "password");
    private final static QName _Uid_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", "uid");
    private final static QName _EnableDate_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", "enableDate");
    private final static QName _Description_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", "description");
    private final static QName _LastPasswordChangeDate_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", "lastPasswordChangeDate");
    private final static QName _DisableDate_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", "disableDate");
    private final static QName _Name_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", "name");
    private final static QName _CurrentPassword_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", "currentPassword");
    private final static QName _LastLoginDate_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", "lastLoginDate");
    private final static QName _Groups_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", "groups");
    private final static QName _PasswordExpirationDate_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", "passwordExpirationDate");
    private final static QName _LockOut_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", "lockOut");
    private final static QName _ShortName_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", "shortName");
    private final static QName _PasswordChangeInterval_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", "passwordChangeInterval");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.evolveum.midpoint.xml.ns._public.connector.icf_1.resource_schema_1
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", name = "passwordExpired")
    public JAXBElement<String> createPasswordExpired(String value) {
        return new JAXBElement<String>(_PasswordExpired_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", name = "enable")
    public JAXBElement<String> createEnable(String value) {
        return new JAXBElement<String>(_Enable_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProtectedStringType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", name = "password")
    public JAXBElement<ProtectedStringType> createPassword(ProtectedStringType value) {
        return new JAXBElement<ProtectedStringType>(_Password_QNAME, ProtectedStringType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", name = "uid")
    public JAXBElement<String> createUid(String value) {
        return new JAXBElement<String>(_Uid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", name = "enableDate")
    public JAXBElement<String> createEnableDate(String value) {
        return new JAXBElement<String>(_EnableDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", name = "description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", name = "lastPasswordChangeDate")
    public JAXBElement<String> createLastPasswordChangeDate(String value) {
        return new JAXBElement<String>(_LastPasswordChangeDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", name = "disableDate")
    public JAXBElement<String> createDisableDate(String value) {
        return new JAXBElement<String>(_DisableDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", name = "currentPassword")
    public JAXBElement<String> createCurrentPassword(String value) {
        return new JAXBElement<String>(_CurrentPassword_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", name = "lastLoginDate")
    public JAXBElement<String> createLastLoginDate(String value) {
        return new JAXBElement<String>(_LastLoginDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", name = "groups")
    public JAXBElement<String> createGroups(String value) {
        return new JAXBElement<String>(_Groups_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", name = "passwordExpirationDate")
    public JAXBElement<String> createPasswordExpirationDate(String value) {
        return new JAXBElement<String>(_PasswordExpirationDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", name = "lockOut")
    public JAXBElement<String> createLockOut(String value) {
        return new JAXBElement<String>(_LockOut_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", name = "shortName")
    public JAXBElement<String> createShortName(String value) {
        return new JAXBElement<String>(_ShortName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd", name = "passwordChangeInterval")
    public JAXBElement<String> createPasswordChangeInterval(String value) {
        return new JAXBElement<String>(_PasswordChangeInterval_QNAME, String.class, null, value);
    }

}
