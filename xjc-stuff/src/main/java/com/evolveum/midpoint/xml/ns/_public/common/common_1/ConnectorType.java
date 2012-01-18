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
 * Description of a generic connector. Connector in midPoint is any method of connection to the resource.
 * The
 * actual implementation, connector framework or protocol does not matter.
 * <p/>
 * More specific types derived from this type may
 * exists. E.g. a
 * connector framework may create a derived type and return that instead of this type.
 * <p/>
 * The values of "framework", "connectorType" and "connectorVersion" (if present) together form a unique
 * identification of the connector. That means that two ConnectorType objects that have these values same
 * represent the same connector. Only one such instance of ConnectorType should exist in the repository.
 * <p/>
 * Note: The ConnectorType does not describe
 * only Identity Connector Framework (ICF) connectors, it is much more generic.
 * <p/>
 * <p/>
 * <p>Java class for ConnectorType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ConnectorType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExtensibleObjectType">
 *       &lt;sequence>
 *         &lt;element name="framework" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="connectorType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="connectorVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="connectorBundle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="targetSystemType" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="namespace" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="connectorHost" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ConnectorHostType" minOccurs="0"/>
 *         &lt;element name="connectorHostRef" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectReferenceType" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}schema" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConnectorType", propOrder = {
        "framework",
        "connectorType",
        "connectorVersion",
        "connectorBundle",
        "targetSystemType",
        "namespace",
        "connectorHost",
        "connectorHostRef",
        "schema"
})
public class ConnectorType
        extends ExtensibleObjectType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected ConnectorHostType connectorHost;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ConnectorType");
    public final static QName F_FRAMEWORK = new QName(SchemaConstants.NS_COMMON, "framework");
    public final static QName F_CONNECTOR_TYPE = new QName(SchemaConstants.NS_COMMON, "connectorType");
    public final static QName F_CONNECTOR_VERSION = new QName(SchemaConstants.NS_COMMON, "connectorVersion");
    public final static QName F_CONNECTOR_BUNDLE = new QName(SchemaConstants.NS_COMMON, "connectorBundle");
    public final static QName F_TARGET_SYSTEM_TYPE = new QName(SchemaConstants.NS_COMMON, "targetSystemType");
    public final static QName F_NAMESPACE = new QName(SchemaConstants.NS_COMMON, "namespace");
    public final static QName F_CONNECTOR_HOST = new QName(SchemaConstants.NS_COMMON, "connectorHost");
    public final static QName F_CONNECTOR_HOST_REF = new QName(SchemaConstants.NS_COMMON, "connectorHostRef");
    public final static QName F_SCHEMA = new QName(SchemaConstants.NS_COMMON, "schema");

    /**
     * Gets the value of the connectorHost property.
     *
     * @return possible object is
     *         {@link ConnectorHostType }
     */
    public ConnectorHostType getConnectorHost() {
        return connectorHost;
    }

    @XmlElement(required = true)
    @javax.xml.bind.annotation.XmlSchemaType(name = "anyURI")
    public String getFramework() {
        return getPropertyValue(F_FRAMEWORK, String.class);
    }

    public void setFramework(String value) {
        setPropertyValue(F_FRAMEWORK, value);
    }

    @XmlElement(required = true)
    public String getConnectorType() {
        return getPropertyValue(F_CONNECTOR_TYPE, String.class);
    }

    public void setConnectorType(String value) {
        setPropertyValue(F_CONNECTOR_TYPE, value);
    }

    public String getConnectorVersion() {
        return getPropertyValue(F_CONNECTOR_VERSION, String.class);
    }

    public void setConnectorVersion(String value) {
        setPropertyValue(F_CONNECTOR_VERSION, value);
    }

    public String getConnectorBundle() {
        return getPropertyValue(F_CONNECTOR_BUNDLE, String.class);
    }

    public void setConnectorBundle(String value) {
        setPropertyValue(F_CONNECTOR_BUNDLE, value);
    }

    @javax.xml.bind.annotation.XmlSchemaType(name = "anyURI")
    public List<String> getTargetSystemType() {
        return getPropertyValues(F_TARGET_SYSTEM_TYPE, String.class);
    }

    @XmlElement(required = true)
    @javax.xml.bind.annotation.XmlSchemaType(name = "anyURI")
    public String getNamespace() {
        return getPropertyValue(F_NAMESPACE, String.class);
    }

    public void setNamespace(String value) {
        setPropertyValue(F_NAMESPACE, value);
    }

    public void setConnectorHost(ConnectorHostType value) {
        //todo do not use setValue but remove container from parent property container, update if user set/remove method
        this.connectorHost = value;
        if (value == null) {
            setPropertyValue(F_CONNECTOR_HOST, null);
        } else {
            setPropertyValue(F_CONNECTOR_HOST, value.getContainer());
        }
    }

    public ObjectReferenceType getConnectorHostRef() {
        return getPropertyValue(F_CONNECTOR_HOST_REF, ObjectReferenceType.class);
    }

    public void setConnectorHostRef(ObjectReferenceType value) {
        setPropertyValue(F_CONNECTOR_HOST_REF, value);
    }

    public com.evolveum.midpoint.xml.ns._public.common.common_1.XmlSchemaType getSchema() {
        return getPropertyValue(F_SCHEMA, com.evolveum.midpoint.xml.ns._public.common.common_1.XmlSchemaType.class);
    }

    public void setSchema(com.evolveum.midpoint.xml.ns._public.common.common_1.XmlSchemaType value) {
        setPropertyValue(F_SCHEMA, value);
    }

}
