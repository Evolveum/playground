package com.evolveum.midpoint.xml.ns._public.common.fault_1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.evolveum.midpoint.xml.ns._public.common.fault_1 package.
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

    private final static QName _SystemFault_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "systemFault");
    private final static QName _SchemaViolationFaul_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "schemaViolationFaul");
    private final static QName _ObjectNotFoundFault_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "objectNotFoundFault");
    private final static QName _UnsupportedOperationFault_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "unsupportedOperationFault");
    private final static QName _ReferentialIntegrityFault_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "referentialIntegrityFault");
    private final static QName _Fault_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "fault");
    private final static QName _IllegalArgumentFault_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "illegalArgumentFault");
    private final static QName _ObjectAlreadyExistsFault_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "objectAlreadyExistsFault");
    private final static QName _InapplicableOperationFault_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "inapplicableOperationFault");
    private final static QName _UnsupportedObjectTypeFault_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "unsupportedObjectTypeFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.evolveum.midpoint.xml.ns._public.common.fault_1
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReferentialIntegrityFaultType }
     */
    public ReferentialIntegrityFaultType createReferentialIntegrityFaultType() {
        return new ReferentialIntegrityFaultType();
    }

    /**
     * Create an instance of {@link ObjectAlreadyExistsFaultType }
     */
    public ObjectAlreadyExistsFaultType createObjectAlreadyExistsFaultType() {
        return new ObjectAlreadyExistsFaultType();
    }

    /**
     * Create an instance of {@link IllegalArgumentFaultType }
     */
    public IllegalArgumentFaultType createIllegalArgumentFaultType() {
        return new IllegalArgumentFaultType();
    }

    /**
     * Create an instance of {@link UnsupportedObjectTypeFaultType }
     */
    public UnsupportedObjectTypeFaultType createUnsupportedObjectTypeFaultType() {
        return new UnsupportedObjectTypeFaultType();
    }

    /**
     * Create an instance of {@link ObjectNotFoundFaultType }
     */
    public ObjectNotFoundFaultType createObjectNotFoundFaultType() {
        return new ObjectNotFoundFaultType();
    }

    /**
     * Create an instance of {@link SchemaViolationFaultType }
     */
    public SchemaViolationFaultType createSchemaViolationFaultType() {
        return new SchemaViolationFaultType();
    }

    /**
     * Create an instance of {@link InapplicableOperationFaultType }
     */
    public InapplicableOperationFaultType createInapplicableOperationFaultType() {
        return new InapplicableOperationFaultType();
    }

    /**
     * Create an instance of {@link SystemFaultType }
     */
    public SystemFaultType createSystemFaultType() {
        return new SystemFaultType();
    }

    /**
     * Create an instance of {@link UnsupportedOperationFaultType }
     */
    public UnsupportedOperationFaultType createUnsupportedOperationFaultType() {
        return new UnsupportedOperationFaultType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SystemFaultType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", name = "systemFault")
    public JAXBElement<SystemFaultType> createSystemFault(SystemFaultType value) {
        return new JAXBElement<SystemFaultType>(_SystemFault_QNAME, SystemFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SchemaViolationFaultType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", name = "schemaViolationFaul")
    public JAXBElement<SchemaViolationFaultType> createSchemaViolationFaul(SchemaViolationFaultType value) {
        return new JAXBElement<SchemaViolationFaultType>(_SchemaViolationFaul_QNAME, SchemaViolationFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObjectNotFoundFaultType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", name = "objectNotFoundFault")
    public JAXBElement<ObjectNotFoundFaultType> createObjectNotFoundFault(ObjectNotFoundFaultType value) {
        return new JAXBElement<ObjectNotFoundFaultType>(_ObjectNotFoundFault_QNAME, ObjectNotFoundFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnsupportedOperationFaultType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", name = "unsupportedOperationFault")
    public JAXBElement<UnsupportedOperationFaultType> createUnsupportedOperationFault(
            UnsupportedOperationFaultType value) {
        return new JAXBElement<UnsupportedOperationFaultType>(_UnsupportedOperationFault_QNAME, UnsupportedOperationFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferentialIntegrityFaultType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", name = "referentialIntegrityFault")
    public JAXBElement<ReferentialIntegrityFaultType> createReferentialIntegrityFault(
            ReferentialIntegrityFaultType value) {
        return new JAXBElement<ReferentialIntegrityFaultType>(_ReferentialIntegrityFault_QNAME, ReferentialIntegrityFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", name = "fault")
    public JAXBElement<FaultType> createFault(FaultType value) {
        return new JAXBElement<FaultType>(_Fault_QNAME, FaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IllegalArgumentFaultType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", name = "illegalArgumentFault")
    public JAXBElement<IllegalArgumentFaultType> createIllegalArgumentFault(IllegalArgumentFaultType value) {
        return new JAXBElement<IllegalArgumentFaultType>(_IllegalArgumentFault_QNAME, IllegalArgumentFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObjectAlreadyExistsFaultType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", name = "objectAlreadyExistsFault")
    public JAXBElement<ObjectAlreadyExistsFaultType> createObjectAlreadyExistsFault(
            ObjectAlreadyExistsFaultType value) {
        return new JAXBElement<ObjectAlreadyExistsFaultType>(_ObjectAlreadyExistsFault_QNAME, ObjectAlreadyExistsFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InapplicableOperationFaultType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", name = "inapplicableOperationFault")
    public JAXBElement<InapplicableOperationFaultType> createInapplicableOperationFault(
            InapplicableOperationFaultType value) {
        return new JAXBElement<InapplicableOperationFaultType>(_InapplicableOperationFault_QNAME, InapplicableOperationFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnsupportedObjectTypeFaultType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", name = "unsupportedObjectTypeFault")
    public JAXBElement<UnsupportedObjectTypeFaultType> createUnsupportedObjectTypeFault(
            UnsupportedObjectTypeFaultType value) {
        return new JAXBElement<UnsupportedObjectTypeFaultType>(_UnsupportedObjectTypeFault_QNAME, UnsupportedObjectTypeFaultType.class, null, value);
    }

}
