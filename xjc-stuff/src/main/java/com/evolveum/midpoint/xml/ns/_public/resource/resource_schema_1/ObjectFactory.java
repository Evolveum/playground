package com.evolveum.midpoint.xml.ns._public.resource.resource_schema_1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import java.util.List;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.evolveum.midpoint.xml.ns._public.resource.resource_schema_1 package.
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

    private final static QName _NamingAttribute_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", "namingAttribute");
    private final static QName _Identifier_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", "identifier");
    private final static QName _NativeAttributeName_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", "nativeAttributeName");
    private final static QName _NativeObjectClass_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", "nativeObjectClass");
    private final static QName _DisplayName_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", "displayName");
    private final static QName _AttributeFlag_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", "attributeFlag");
    private final static QName _Operation_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", "operation");
    private final static QName _CompositeIdentifier_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", "compositeIdentifier");
    private final static QName _ClassifiedAttribute_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", "classifiedAttribute");
    private final static QName _DescriptionAttribute_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", "descriptionAttribute");
    private final static QName _Container_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", "container");
    private final static QName _ResourceObject_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", "resourceObject");
    private final static QName _SecondaryIdentifier_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", "secondaryIdentifier");
    private final static QName _AccountType_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", "accountType");
    private final static QName _ObjectClassAttribute_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", "objectClassAttribute");
    private final static QName _AttributeDisplayName_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", "attributeDisplayName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.evolveum.midpoint.xml.ns._public.resource.resource_schema_1
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObjectClassAttributeType }
     */
    public ObjectClassAttributeType createObjectClassAttributeType() {
        return new ObjectClassAttributeType();
    }

    /**
     * Create an instance of {@link ResourceObjectReference }
     */
    public ResourceObjectReference createResourceObjectReference() {
        return new ResourceObjectReference();
    }

    /**
     * Create an instance of {@link ClassifiedAttributeType }
     */
    public ClassifiedAttributeType createClassifiedAttributeType() {
        return new ClassifiedAttributeType();
    }

    /**
     * Create an instance of {@link AccountTypeType }
     */
    public AccountTypeType createAccountTypeType() {
        return new AccountTypeType();
    }

    /**
     * Create an instance of {@link Objects }
     */
    public Objects createObjects() {
        return new Objects();
    }

    /**
     * Create an instance of {@link OperationType }
     */
    public OperationType createOperationType() {
        return new OperationType();
    }

    /**
     * Create an instance of {@link AttributeReferenceType }
     */
    public AttributeReferenceType createAttributeReferenceType() {
        return new AttributeReferenceType();
    }

    /**
     * Create an instance of {@link ObjectClassReferenceType }
     */
    public ObjectClassReferenceType createObjectClassReferenceType() {
        return new ObjectClassReferenceType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttributeReferenceType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", name = "namingAttribute")
    public JAXBElement<AttributeReferenceType> createNamingAttribute(AttributeReferenceType value) {
        return new JAXBElement<AttributeReferenceType>(_NamingAttribute_QNAME, AttributeReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttributeReferenceType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", name = "identifier")
    public JAXBElement<AttributeReferenceType> createIdentifier(AttributeReferenceType value) {
        return new JAXBElement<AttributeReferenceType>(_Identifier_QNAME, AttributeReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", name = "nativeAttributeName")
    public JAXBElement<String> createNativeAttributeName(String value) {
        return new JAXBElement<String>(_NativeAttributeName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", name = "nativeObjectClass")
    public JAXBElement<String> createNativeObjectClass(String value) {
        return new JAXBElement<String>(_NativeObjectClass_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttributeReferenceType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", name = "displayName")
    public JAXBElement<AttributeReferenceType> createDisplayName(AttributeReferenceType value) {
        return new JAXBElement<AttributeReferenceType>(_DisplayName_QNAME, AttributeReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", name = "attributeFlag")
    public JAXBElement<List<String>> createAttributeFlag(List<String> value) {
        return new JAXBElement<List<String>>(_AttributeFlag_QNAME, ((Class) List.class), null, ((List<String>) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", name = "operation")
    public JAXBElement<OperationType> createOperation(OperationType value) {
        return new JAXBElement<OperationType>(_Operation_QNAME, OperationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttributeReferenceType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", name = "compositeIdentifier")
    public JAXBElement<AttributeReferenceType> createCompositeIdentifier(AttributeReferenceType value) {
        return new JAXBElement<AttributeReferenceType>(_CompositeIdentifier_QNAME, AttributeReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClassifiedAttributeType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", name = "classifiedAttribute")
    public JAXBElement<ClassifiedAttributeType> createClassifiedAttribute(ClassifiedAttributeType value) {
        return new JAXBElement<ClassifiedAttributeType>(_ClassifiedAttribute_QNAME, ClassifiedAttributeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttributeReferenceType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", name = "descriptionAttribute")
    public JAXBElement<AttributeReferenceType> createDescriptionAttribute(AttributeReferenceType value) {
        return new JAXBElement<AttributeReferenceType>(_DescriptionAttribute_QNAME, AttributeReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", name = "container")
    public JAXBElement<Boolean> createContainer(Boolean value) {
        return new JAXBElement<Boolean>(_Container_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", name = "resourceObject")
    public JAXBElement<Object> createResourceObject(Object value) {
        return new JAXBElement<Object>(_ResourceObject_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttributeReferenceType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", name = "secondaryIdentifier")
    public JAXBElement<AttributeReferenceType> createSecondaryIdentifier(AttributeReferenceType value) {
        return new JAXBElement<AttributeReferenceType>(_SecondaryIdentifier_QNAME, AttributeReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountTypeType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", name = "accountType")
    public JAXBElement<AccountTypeType> createAccountType(AccountTypeType value) {
        return new JAXBElement<AccountTypeType>(_AccountType_QNAME, AccountTypeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObjectClassAttributeType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", name = "objectClassAttribute")
    public JAXBElement<ObjectClassAttributeType> createObjectClassAttribute(ObjectClassAttributeType value) {
        return new JAXBElement<ObjectClassAttributeType>(_ObjectClassAttribute_QNAME, ObjectClassAttributeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd", name = "attributeDisplayName")
    public JAXBElement<String> createAttributeDisplayName(String value) {
        return new JAXBElement<String>(_AttributeDisplayName_QNAME, String.class, null, value);
    }

}
