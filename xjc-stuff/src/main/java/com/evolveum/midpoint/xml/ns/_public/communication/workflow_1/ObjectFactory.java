package com.evolveum.midpoint.xml.ns._public.communication.workflow_1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.evolveum.midpoint.xml.ns._public.communication.workflow_1 package.
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

    private final static QName _WfProcessInstanceStartedEvent_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/communication/workflow-1.xsd", "WfProcessInstanceStartedEvent");
    private final static QName _WfQueryProcessInstanceCommand_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/communication/workflow-1.xsd", "WfQueryProcessInstanceCommand");
    private final static QName _WfProcessInstanceFinishedEvent_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/communication/workflow-1.xsd", "WfProcessInstanceFinishedEvent");
    private final static QName _WfProcessInstanceEvent_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/communication/workflow-1.xsd", "WfProcessInstanceEvent");
    private final static QName _WfStartProcessInstanceCommand_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/communication/workflow-1.xsd", "WfStartProcessInstanceCommand");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.evolveum.midpoint.xml.ns._public.communication.workflow_1
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WfProcessInstanceStartedEventType }
     */
    public WfProcessInstanceStartedEventType createWfProcessInstanceStartedEventType() {
        return new WfProcessInstanceStartedEventType();
    }

    /**
     * Create an instance of {@link WfProcessInstanceFinishedEventType }
     */
    public WfProcessInstanceFinishedEventType createWfProcessInstanceFinishedEventType() {
        return new WfProcessInstanceFinishedEventType();
    }

    /**
     * Create an instance of {@link WfStartProcessInstanceCommandType }
     */
    public WfStartProcessInstanceCommandType createWfStartProcessInstanceCommandType() {
        return new WfStartProcessInstanceCommandType();
    }

    /**
     * Create an instance of {@link WfQueryProcessInstanceCommandType }
     */
    public WfQueryProcessInstanceCommandType createWfQueryProcessInstanceCommandType() {
        return new WfQueryProcessInstanceCommandType();
    }

    /**
     * Create an instance of {@link WfProcessInstanceEventType }
     */
    public WfProcessInstanceEventType createWfProcessInstanceEventType() {
        return new WfProcessInstanceEventType();
    }

    /**
     * Create an instance of {@link WfProcessVariable }
     */
    public WfProcessVariable createWfProcessVariable() {
        return new WfProcessVariable();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WfProcessInstanceStartedEventType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/communication/workflow-1.xsd", name = "WfProcessInstanceStartedEvent")
    public JAXBElement<WfProcessInstanceStartedEventType> createWfProcessInstanceStartedEvent(
            WfProcessInstanceStartedEventType value) {
        return new JAXBElement<WfProcessInstanceStartedEventType>(_WfProcessInstanceStartedEvent_QNAME, WfProcessInstanceStartedEventType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WfQueryProcessInstanceCommandType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/communication/workflow-1.xsd", name = "WfQueryProcessInstanceCommand")
    public JAXBElement<WfQueryProcessInstanceCommandType> createWfQueryProcessInstanceCommand(
            WfQueryProcessInstanceCommandType value) {
        return new JAXBElement<WfQueryProcessInstanceCommandType>(_WfQueryProcessInstanceCommand_QNAME, WfQueryProcessInstanceCommandType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WfProcessInstanceFinishedEventType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/communication/workflow-1.xsd", name = "WfProcessInstanceFinishedEvent")
    public JAXBElement<WfProcessInstanceFinishedEventType> createWfProcessInstanceFinishedEvent(
            WfProcessInstanceFinishedEventType value) {
        return new JAXBElement<WfProcessInstanceFinishedEventType>(_WfProcessInstanceFinishedEvent_QNAME, WfProcessInstanceFinishedEventType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WfProcessInstanceEventType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/communication/workflow-1.xsd", name = "WfProcessInstanceEvent")
    public JAXBElement<WfProcessInstanceEventType> createWfProcessInstanceEvent(WfProcessInstanceEventType value) {
        return new JAXBElement<WfProcessInstanceEventType>(_WfProcessInstanceEvent_QNAME, WfProcessInstanceEventType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WfStartProcessInstanceCommandType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/communication/workflow-1.xsd", name = "WfStartProcessInstanceCommand")
    public JAXBElement<WfStartProcessInstanceCommandType> createWfStartProcessInstanceCommand(
            WfStartProcessInstanceCommandType value) {
        return new JAXBElement<WfStartProcessInstanceCommandType>(_WfStartProcessInstanceCommand_QNAME, WfStartProcessInstanceCommandType.class, null, value);
    }

}
