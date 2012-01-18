package com.evolveum.midpoint.xml.ns._public.connector.icf_1.connector_schema_1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import java.math.BigInteger;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.evolveum.midpoint.xml.ns._public.connector.icf_1.connector_schema_1 package.
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

    private final static QName _Timeouts_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/connector-schema-1.xsd", "timeouts");
    private final static QName _ProducerBufferSize_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/connector-schema-1.xsd", "producerBufferSize");
    private final static QName _ConnectorPoolConfiguration_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/connector-schema-1.xsd", "connectorPoolConfiguration");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.evolveum.midpoint.xml.ns._public.connector.icf_1.connector_schema_1
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConnectorPoolConfigurationType }
     */
    public ConnectorPoolConfigurationType createConnectorPoolConfigurationType() {
        return new ConnectorPoolConfigurationType();
    }

    /**
     * Create an instance of {@link TimeoutsType }
     */
    public TimeoutsType createTimeoutsType() {
        return new TimeoutsType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeoutsType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/connector-schema-1.xsd", name = "timeouts")
    public JAXBElement<TimeoutsType> createTimeouts(TimeoutsType value) {
        return new JAXBElement<TimeoutsType>(_Timeouts_QNAME, TimeoutsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/connector-schema-1.xsd", name = "producerBufferSize")
    public JAXBElement<BigInteger> createProducerBufferSize(BigInteger value) {
        return new JAXBElement<BigInteger>(_ProducerBufferSize_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnectorPoolConfigurationType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/connector-schema-1.xsd", name = "connectorPoolConfiguration")
    public JAXBElement<ConnectorPoolConfigurationType> createConnectorPoolConfiguration(
            ConnectorPoolConfigurationType value) {
        return new JAXBElement<ConnectorPoolConfigurationType>(_ConnectorPoolConfiguration_QNAME, ConnectorPoolConfigurationType.class, null, value);
    }

}
