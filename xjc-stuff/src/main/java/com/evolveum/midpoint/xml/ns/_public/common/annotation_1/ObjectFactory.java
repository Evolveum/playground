package com.evolveum.midpoint.xml.ns._public.common.annotation_1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.evolveum.midpoint.xml.ns._public.common.annotation_1 package.
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

    private final static QName _MidPointContainer_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/common/annotation-1.xsd", "midPointContainer");
    private final static QName _PropertyContainer_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/common/annotation-1.xsd", "propertyContainer");
    private final static QName _Extension_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/common/annotation-1.xsd", "extension");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.evolveum.midpoint.xml.ns._public.common.annotation_1
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExtensionType }
     */
    public ExtensionType createExtensionType() {
        return new ExtensionType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/annotation-1.xsd", name = "midPointContainer")
    public JAXBElement<Object> createMidPointContainer(Object value) {
        return new JAXBElement<Object>(_MidPointContainer_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/annotation-1.xsd", name = "propertyContainer")
    public JAXBElement<Object> createPropertyContainer(Object value) {
        return new JAXBElement<Object>(_PropertyContainer_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExtensionType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/annotation-1.xsd", name = "extension")
    public JAXBElement<ExtensionType> createExtension(ExtensionType value) {
        return new JAXBElement<ExtensionType>(_Extension_QNAME, ExtensionType.class, null, value);
    }

}
