package com.evolveum.midpoint.xml.ns._public.resource.capabilities_1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.evolveum.midpoint.xml.ns._public.resource.capabilities_1 package.
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

    private final static QName _TestConnection_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/capabilities-1.xsd", "testConnection");
    private final static QName _Credentials_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/capabilities-1.xsd", "credentials");
    private final static QName _Activation_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/capabilities-1.xsd", "activation");
    private final static QName _LiveSync_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/capabilities-1.xsd", "liveSync");
    private final static QName _Script_QNAME = new QName("http://midpoint.evolveum.com/xml/ns/public/resource/capabilities-1.xsd", "script");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.evolveum.midpoint.xml.ns._public.resource.capabilities_1
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ActivationCapabilityType.EnableDisable }
     */
    public ActivationCapabilityType.EnableDisable createActivationCapabilityTypeEnableDisable() {
        return new ActivationCapabilityType.EnableDisable();
    }

    /**
     * Create an instance of {@link PasswordCapabilityType }
     */
    public PasswordCapabilityType createPasswordCapabilityType() {
        return new PasswordCapabilityType();
    }

    /**
     * Create an instance of {@link ActivationCapabilityType }
     */
    public ActivationCapabilityType createActivationCapabilityType() {
        return new ActivationCapabilityType();
    }

    /**
     * Create an instance of {@link ScriptCapabilityType.Host }
     */
    public ScriptCapabilityType.Host createScriptCapabilityTypeHost() {
        return new ScriptCapabilityType.Host();
    }

    /**
     * Create an instance of {@link ScriptCapabilityType }
     */
    public ScriptCapabilityType createScriptCapabilityType() {
        return new ScriptCapabilityType();
    }

    /**
     * Create an instance of {@link LiveSyncCapabilityType }
     */
    public LiveSyncCapabilityType createLiveSyncCapabilityType() {
        return new LiveSyncCapabilityType();
    }

    /**
     * Create an instance of {@link TestConnectionCapabilityType }
     */
    public TestConnectionCapabilityType createTestConnectionCapabilityType() {
        return new TestConnectionCapabilityType();
    }

    /**
     * Create an instance of {@link CredentialsCapabilityType }
     */
    public CredentialsCapabilityType createCredentialsCapabilityType() {
        return new CredentialsCapabilityType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestConnectionCapabilityType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/capabilities-1.xsd", name = "testConnection")
    public JAXBElement<TestConnectionCapabilityType> createTestConnection(TestConnectionCapabilityType value) {
        return new JAXBElement<TestConnectionCapabilityType>(_TestConnection_QNAME, TestConnectionCapabilityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CredentialsCapabilityType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/capabilities-1.xsd", name = "credentials")
    public JAXBElement<CredentialsCapabilityType> createCredentials(CredentialsCapabilityType value) {
        return new JAXBElement<CredentialsCapabilityType>(_Credentials_QNAME, CredentialsCapabilityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivationCapabilityType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/capabilities-1.xsd", name = "activation")
    public JAXBElement<ActivationCapabilityType> createActivation(ActivationCapabilityType value) {
        return new JAXBElement<ActivationCapabilityType>(_Activation_QNAME, ActivationCapabilityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LiveSyncCapabilityType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/capabilities-1.xsd", name = "liveSync")
    public JAXBElement<LiveSyncCapabilityType> createLiveSync(LiveSyncCapabilityType value) {
        return new JAXBElement<LiveSyncCapabilityType>(_LiveSync_QNAME, LiveSyncCapabilityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScriptCapabilityType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://midpoint.evolveum.com/xml/ns/public/resource/capabilities-1.xsd", name = "script")
    public JAXBElement<ScriptCapabilityType> createScript(ScriptCapabilityType value) {
        return new JAXBElement<ScriptCapabilityType>(_Script_QNAME, ScriptCapabilityType.class, null, value);
    }

}
