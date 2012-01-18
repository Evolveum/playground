package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Resource represents a system or component external to the IDM
 * system which we manage. It is sometimes called _IT resource_,
 * _target system_, _source system_, _provisioning target_,
 * etc.
 * IDM system connects to it to create accounts, assign
 * accounts to groups, etc. But it also may be an authoritative source of
 * data, system that maintains lookup tables, database that
 * contains organizational structure, etc. The {{Resource}} will
 * most likely provide a combination of several functions (e.g.
 * both provisioning and authoritative data for some attributes).
 * <p/>
 * <p/>
 * <p>Java class for ResourceType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ResourceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExtensibleObjectType">
 *       &lt;sequence>
 *         &lt;element name="connector" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ConnectorType" minOccurs="0"/>
 *         &lt;element name="connectorRef" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectReferenceType" minOccurs="0"/>
 *         &lt;element name="namespace" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="configuration" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ResourceConfigurationType"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}schema" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}schemaHandling" minOccurs="0"/>
 *         &lt;element name="nativeCapabilities" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}CapabilitiesType" minOccurs="0"/>
 *         &lt;element name="capabilities" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}CapabilitiesType" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}scripts" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}synchronization" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceType", propOrder = {
        "connector",
        "connectorRef",
        "namespace",
        "configuration",
        "schema",
        "schemaHandling",
        "nativeCapabilities",
        "capabilities",
        "scripts",
        "synchronization"
})
public class ResourceType
        extends ExtensibleObjectType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected ConnectorType connector;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ResourceType");
    public final static QName F_CONNECTOR = new QName(SchemaConstants.NS_COMMON, "connector");
    public final static QName F_CONNECTOR_REF = new QName(SchemaConstants.NS_COMMON, "connectorRef");
    public final static QName F_NAMESPACE = new QName(SchemaConstants.NS_COMMON, "namespace");
    public final static QName F_CONFIGURATION = new QName(SchemaConstants.NS_COMMON, "configuration");
    public final static QName F_SCHEMA = new QName(SchemaConstants.NS_COMMON, "schema");
    public final static QName F_SCHEMA_HANDLING = new QName(SchemaConstants.NS_COMMON, "schemaHandling");
    public final static QName F_NATIVE_CAPABILITIES = new QName(SchemaConstants.NS_COMMON, "nativeCapabilities");
    public final static QName F_CAPABILITIES = new QName(SchemaConstants.NS_COMMON, "capabilities");
    public final static QName F_SCRIPTS = new QName(SchemaConstants.NS_COMMON, "scripts");
    public final static QName F_SYNCHRONIZATION = new QName(SchemaConstants.NS_COMMON, "synchronization");

    /**
     * Gets the value of the connector property.
     *
     * @return possible object is
     *         {@link ConnectorType }
     */
    public ConnectorType getConnector() {
        return connector;
    }

    public void setConnector(ConnectorType value) {
        //todo do not use setValue but remove container from parent property container, update if user set/remove method
        this.connector = value;
        if (value == null) {
            setPropertyValue(F_CONNECTOR, null);
        } else {
            setPropertyValue(F_CONNECTOR, value.getContainer());
        }
    }

    public ObjectReferenceType getConnectorRef() {
        return getPropertyValue(F_CONNECTOR_REF, ObjectReferenceType.class);
    }

    public void setConnectorRef(ObjectReferenceType value) {
        setPropertyValue(F_CONNECTOR_REF, value);
    }

    @XmlElement(required = true)
    @javax.xml.bind.annotation.XmlSchemaType(name = "anyURI")
    public String getNamespace() {
        return getPropertyValue(F_NAMESPACE, String.class);
    }

    public void setNamespace(String value) {
        setPropertyValue(F_NAMESPACE, value);
    }

    @XmlElement(required = true)
    public ResourceConfigurationType getConfiguration() {
        return getPropertyValue(F_CONFIGURATION, ResourceConfigurationType.class);
    }

    public void setConfiguration(ResourceConfigurationType value) {
        setPropertyValue(F_CONFIGURATION, value);
    }

    public com.evolveum.midpoint.xml.ns._public.common.common_1.XmlSchemaType getSchema() {
        return getPropertyValue(F_SCHEMA, com.evolveum.midpoint.xml.ns._public.common.common_1.XmlSchemaType.class);
    }

    public void setSchema(com.evolveum.midpoint.xml.ns._public.common.common_1.XmlSchemaType value) {
        setPropertyValue(F_SCHEMA, value);
    }

    public SchemaHandlingType getSchemaHandling() {
        return getPropertyValue(F_SCHEMA_HANDLING, SchemaHandlingType.class);
    }

    public void setSchemaHandling(SchemaHandlingType value) {
        setPropertyValue(F_SCHEMA_HANDLING, value);
    }

    public CapabilitiesType getNativeCapabilities() {
        return getPropertyValue(F_NATIVE_CAPABILITIES, CapabilitiesType.class);
    }

    public void setNativeCapabilities(CapabilitiesType value) {
        setPropertyValue(F_NATIVE_CAPABILITIES, value);
    }

    public CapabilitiesType getCapabilities() {
        return getPropertyValue(F_CAPABILITIES, CapabilitiesType.class);
    }

    public void setCapabilities(CapabilitiesType value) {
        setPropertyValue(F_CAPABILITIES, value);
    }

    public ScriptsType getScripts() {
        return getPropertyValue(F_SCRIPTS, ScriptsType.class);
    }

    public void setScripts(ScriptsType value) {
        setPropertyValue(F_SCRIPTS, value);
    }

    public SynchronizationType getSynchronization() {
        return getPropertyValue(F_SYNCHRONIZATION, SynchronizationType.class);
    }

    public void setSynchronization(SynchronizationType value) {
        setPropertyValue(F_SYNCHRONIZATION, value);
    }

}
