
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import com.evolveum.midpoint.schema.DomAwareEqualsStrategy;
import com.evolveum.midpoint.schema.DomAwareHashCodeStrategy;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * 
 *                 Resource represents a system or component external
 *                 to the IDM
 *                 system which we manage. It is
 *                 sometimes called
 *                 _IT
 *                 resource_,
 *                 _target system_, _source system_, _provisioning target_,
 *                 etc.
 *                 IDM system connects to
 *                 it to create accounts, assign
 *                 accounts
 *                 to
 *                 groups, etc. But it also may be an authoritative source of
 *                 data,
 *                 system that
 *                 maintains lookup tables, database that
 *                 contains
 *                 organizational structure, etc. The {{Resource}} will
 *                 most likely
 *                 provide a combination of several functions (e.g.
 *                 both
 *                 provisioning
 *                 and authoritative data for some attributes).
 *             
 * 
 * <p>Java class for ResourceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
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
 * 
 * 
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
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected ConnectorType connector;
    protected ObjectReferenceType connectorRef;
    @XmlElement(required = true)
    @javax.xml.bind.annotation.XmlSchemaType(name = "anyURI")
    protected String namespace;
    @XmlElement(required = true)
    protected ResourceConfigurationType configuration;
    protected com.evolveum.midpoint.xml.common.common_1.XmlSchemaType schema;
    protected SchemaHandlingType schemaHandling;
    protected CapabilitiesType nativeCapabilities;
    protected CapabilitiesType capabilities;
    protected ScriptsType scripts;
    protected SynchronizationType synchronization;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ResourceType");

    /**
     * Gets the value of the connector property.
     * 
     * @return
     *     possible object is
     *     {@link ConnectorType }
     *     
     */
    public ConnectorType getConnector() {
        return connector;
    }

    /**
     * Sets the value of the connector property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConnectorType }
     *     
     */
    public void setConnector(ConnectorType value) {
        this.connector = value;
    }

    /**
     * Gets the value of the connectorRef property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectReferenceType }
     *     
     */
    public ObjectReferenceType getConnectorRef() {
        return connectorRef;
    }

    /**
     * Sets the value of the connectorRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectReferenceType }
     *     
     */
    public void setConnectorRef(ObjectReferenceType value) {
        this.connectorRef = value;
    }

    /**
     * Gets the value of the namespace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * Sets the value of the namespace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamespace(String value) {
        this.namespace = value;
    }

    /**
     * Gets the value of the configuration property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceConfigurationType }
     *     
     */
    public ResourceConfigurationType getConfiguration() {
        return configuration;
    }

    /**
     * Sets the value of the configuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceConfigurationType }
     *     
     */
    public void setConfiguration(ResourceConfigurationType value) {
        this.configuration = value;
    }

    /**
     * 
     *                                 Schema for resource objects.
     * 
     *                                 This element
     *                                 contains the XSD-formatted definition
     *                                 of resource
     *                                 schema. It
     *                                 defines data types for
     *                                 accounts, groups, roles, entitlements,
     *                                 organizational units or any other objects
     *                                 related to identity
     *                                 management that the resource
     *                                 supports.
     * 
     *                                 Resource schema will be
     *                                 only available at run-time
     *                                 and
     *                                 can be diffrent for every
     *                                 resource
     *                                 instance,
     *                                 even for resource instances of the same type.
     *                                 It is
     *                                 supposed to be
     *                                 dynamically interpreted in
     *                                 run-time.
     * 
     *                                 Schema defines
     *                                 data types (XSD types), but it
     *                                 does NOT define how these types
     *                                 are handled.
     *                                 E.g. it defines attributes and
     *                                 object class for
     *                                 inetOrgPerson, it defines that inetOrgPerson
     *                                 extends
     *                                 organizationalPerson and persona, that
     *                                 cn is
     *                                 multi-valued string
     *                                 attributed of Person,
     *                                 etc. But it does NOT define
     *                                 that
     *                                 inetOrgPerson
     *                                 object class should be used as
     *                                 account and that
     *                                 modifyTimestamp attribute is read-only. Such
     *                                 additional details
     *                                 are specified in
     *                                 schemaHandling element
     *                                 defined below.
     * 
     *                                 Resource
     *                                 schema is read-only. Changing
     *                                 resource
     *                                 schema is
     *                                 not supported.
     * 
     *                                 TODO: annotations in the schema
     *                             
     * 
     * @return
     *     possible object is
     *     {@link com.evolveum.midpoint.xml.common.common_1.XmlSchemaType }
     *     
     */
    public com.evolveum.midpoint.xml.common.common_1.XmlSchemaType getSchema() {
        return schema;
    }

    /**
     * Sets the value of the schema property.
     * 
     * @param value
     *     allowed object is
     *     {@link com.evolveum.midpoint.xml.common.common_1.XmlSchemaType }
     *     
     */
    public void setSchema(com.evolveum.midpoint.xml.common.common_1.XmlSchemaType value) {
        this.schema = value;
    }

    /**
     * Gets the value of the schemaHandling property.
     * 
     * @return
     *     possible object is
     *     {@link SchemaHandlingType }
     *     
     */
    public SchemaHandlingType getSchemaHandling() {
        return schemaHandling;
    }

    /**
     * Sets the value of the schemaHandling property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemaHandlingType }
     *     
     */
    public void setSchemaHandling(SchemaHandlingType value) {
        this.schemaHandling = value;
    }

    /**
     * Gets the value of the nativeCapabilities property.
     * 
     * @return
     *     possible object is
     *     {@link CapabilitiesType }
     *     
     */
    public CapabilitiesType getNativeCapabilities() {
        return nativeCapabilities;
    }

    /**
     * Sets the value of the nativeCapabilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapabilitiesType }
     *     
     */
    public void setNativeCapabilities(CapabilitiesType value) {
        this.nativeCapabilities = value;
    }

    /**
     * Gets the value of the capabilities property.
     * 
     * @return
     *     possible object is
     *     {@link CapabilitiesType }
     *     
     */
    public CapabilitiesType getCapabilities() {
        return capabilities;
    }

    /**
     * Sets the value of the capabilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapabilitiesType }
     *     
     */
    public void setCapabilities(CapabilitiesType value) {
        this.capabilities = value;
    }

    /**
     * Gets the value of the scripts property.
     * 
     * @return
     *     possible object is
     *     {@link ScriptsType }
     *     
     */
    public ScriptsType getScripts() {
        return scripts;
    }

    /**
     * Sets the value of the scripts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScriptsType }
     *     
     */
    public void setScripts(ScriptsType value) {
        this.scripts = value;
    }

    /**
     * Gets the value of the synchronization property.
     * 
     * @return
     *     possible object is
     *     {@link SynchronizationType }
     *     
     */
    public SynchronizationType getSynchronization() {
        return synchronization;
    }

    /**
     * Sets the value of the synchronization property.
     * 
     * @param value
     *     allowed object is
     *     {@link SynchronizationType }
     *     
     */
    public void setSynchronization(SynchronizationType value) {
        this.synchronization = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            ConnectorType theConnector;
            theConnector = this.getConnector();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "connector", theConnector), currentHashCode, theConnector);
        }
        {
            ObjectReferenceType theConnectorRef;
            theConnectorRef = this.getConnectorRef();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "connectorRef", theConnectorRef), currentHashCode, theConnectorRef);
        }
        {
            String theNamespace;
            theNamespace = this.getNamespace();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "namespace", theNamespace), currentHashCode, theNamespace);
        }
        {
            ResourceConfigurationType theConfiguration;
            theConfiguration = this.getConfiguration();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "configuration", theConfiguration), currentHashCode, theConfiguration);
        }
        {
            com.evolveum.midpoint.xml.common.common_1.XmlSchemaType theSchema;
            theSchema = this.getSchema();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "schema", theSchema), currentHashCode, theSchema);
        }
        {
            SchemaHandlingType theSchemaHandling;
            theSchemaHandling = this.getSchemaHandling();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "schemaHandling", theSchemaHandling), currentHashCode, theSchemaHandling);
        }
        {
            CapabilitiesType theNativeCapabilities;
            theNativeCapabilities = this.getNativeCapabilities();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nativeCapabilities", theNativeCapabilities), currentHashCode, theNativeCapabilities);
        }
        {
            CapabilitiesType theCapabilities;
            theCapabilities = this.getCapabilities();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "capabilities", theCapabilities), currentHashCode, theCapabilities);
        }
        {
            ScriptsType theScripts;
            theScripts = this.getScripts();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "scripts", theScripts), currentHashCode, theScripts);
        }
        {
            SynchronizationType theSynchronization;
            theSynchronization = this.getSynchronization();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "synchronization", theSynchronization), currentHashCode, theSynchronization);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ResourceType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final ResourceType that = ((ResourceType) object);
        {
            ConnectorType lhsConnector;
            lhsConnector = this.getConnector();
            ConnectorType rhsConnector;
            rhsConnector = that.getConnector();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "connector", lhsConnector), LocatorUtils.property(thatLocator, "connector", rhsConnector), lhsConnector, rhsConnector)) {
                return false;
            }
        }
        {
            ObjectReferenceType lhsConnectorRef;
            lhsConnectorRef = this.getConnectorRef();
            ObjectReferenceType rhsConnectorRef;
            rhsConnectorRef = that.getConnectorRef();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "connectorRef", lhsConnectorRef), LocatorUtils.property(thatLocator, "connectorRef", rhsConnectorRef), lhsConnectorRef, rhsConnectorRef)) {
                return false;
            }
        }
        {
            String lhsNamespace;
            lhsNamespace = this.getNamespace();
            String rhsNamespace;
            rhsNamespace = that.getNamespace();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "namespace", lhsNamespace), LocatorUtils.property(thatLocator, "namespace", rhsNamespace), lhsNamespace, rhsNamespace)) {
                return false;
            }
        }
        {
            ResourceConfigurationType lhsConfiguration;
            lhsConfiguration = this.getConfiguration();
            ResourceConfigurationType rhsConfiguration;
            rhsConfiguration = that.getConfiguration();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "configuration", lhsConfiguration), LocatorUtils.property(thatLocator, "configuration", rhsConfiguration), lhsConfiguration, rhsConfiguration)) {
                return false;
            }
        }
        {
            com.evolveum.midpoint.xml.common.common_1.XmlSchemaType lhsSchema;
            lhsSchema = this.getSchema();
            com.evolveum.midpoint.xml.common.common_1.XmlSchemaType rhsSchema;
            rhsSchema = that.getSchema();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "schema", lhsSchema), LocatorUtils.property(thatLocator, "schema", rhsSchema), lhsSchema, rhsSchema)) {
                return false;
            }
        }
        {
            SchemaHandlingType lhsSchemaHandling;
            lhsSchemaHandling = this.getSchemaHandling();
            SchemaHandlingType rhsSchemaHandling;
            rhsSchemaHandling = that.getSchemaHandling();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "schemaHandling", lhsSchemaHandling), LocatorUtils.property(thatLocator, "schemaHandling", rhsSchemaHandling), lhsSchemaHandling, rhsSchemaHandling)) {
                return false;
            }
        }
        {
            CapabilitiesType lhsNativeCapabilities;
            lhsNativeCapabilities = this.getNativeCapabilities();
            CapabilitiesType rhsNativeCapabilities;
            rhsNativeCapabilities = that.getNativeCapabilities();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nativeCapabilities", lhsNativeCapabilities), LocatorUtils.property(thatLocator, "nativeCapabilities", rhsNativeCapabilities), lhsNativeCapabilities, rhsNativeCapabilities)) {
                return false;
            }
        }
        {
            CapabilitiesType lhsCapabilities;
            lhsCapabilities = this.getCapabilities();
            CapabilitiesType rhsCapabilities;
            rhsCapabilities = that.getCapabilities();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "capabilities", lhsCapabilities), LocatorUtils.property(thatLocator, "capabilities", rhsCapabilities), lhsCapabilities, rhsCapabilities)) {
                return false;
            }
        }
        {
            ScriptsType lhsScripts;
            lhsScripts = this.getScripts();
            ScriptsType rhsScripts;
            rhsScripts = that.getScripts();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "scripts", lhsScripts), LocatorUtils.property(thatLocator, "scripts", rhsScripts), lhsScripts, rhsScripts)) {
                return false;
            }
        }
        {
            SynchronizationType lhsSynchronization;
            lhsSynchronization = this.getSynchronization();
            SynchronizationType rhsSynchronization;
            rhsSynchronization = that.getSynchronization();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "synchronization", lhsSynchronization), LocatorUtils.property(thatLocator, "synchronization", rhsSynchronization), lhsSynchronization, rhsSynchronization)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = new DomAwareEqualsStrategy();
        return equals(null, null, object, strategy);
    }

}
