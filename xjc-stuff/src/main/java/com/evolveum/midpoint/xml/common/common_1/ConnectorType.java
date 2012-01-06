
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
 *                 Description of a generic connector. Connector in midPoint is any method of connection to the resource.
 *                 The
 *                 actual implementation, connector framework or protocol does not matter.
 * 
 *                 More specific types derived from this type may
 *                 exists. E.g. a
 *                 connector framework may create a derived type and return that instead of this type.
 * 
 *                 The values of "framework", "connectorType" and "connectorVersion" (if present) together form a unique
 *                 identification of the connector. That means that two ConnectorType objects that have these values same
 *                 represent the same connector. Only one such instance of ConnectorType should exist in the repository.
 * 
 *                 Note: The ConnectorType does not describe
 *                 only Identity Connector Framework (ICF) connectors, it is much more generic.
 *             
 * 
 * <p>Java class for ConnectorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
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
 * 
 * 
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
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    @javax.xml.bind.annotation.XmlSchemaType(name = "anyURI")
    protected String framework;
    @XmlElement(required = true)
    protected String connectorType;
    protected String connectorVersion;
    protected String connectorBundle;
    @javax.xml.bind.annotation.XmlSchemaType(name = "anyURI")
    protected List<String> targetSystemType;
    @XmlElement(required = true)
    @javax.xml.bind.annotation.XmlSchemaType(name = "anyURI")
    protected String namespace;
    protected ConnectorHostType connectorHost;
    protected ObjectReferenceType connectorHostRef;
    protected com.evolveum.midpoint.xml.common.common_1.XmlSchemaType schema;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ConnectorType");

    /**
     * Gets the value of the framework property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFramework() {
        return framework;
    }

    /**
     * Sets the value of the framework property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFramework(String value) {
        this.framework = value;
    }

    /**
     * Gets the value of the connectorType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectorType() {
        return connectorType;
    }

    /**
     * Sets the value of the connectorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnectorType(String value) {
        this.connectorType = value;
    }

    /**
     * Gets the value of the connectorVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectorVersion() {
        return connectorVersion;
    }

    /**
     * Sets the value of the connectorVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnectorVersion(String value) {
        this.connectorVersion = value;
    }

    /**
     * Gets the value of the connectorBundle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectorBundle() {
        return connectorBundle;
    }

    /**
     * Sets the value of the connectorBundle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnectorBundle(String value) {
        this.connectorBundle = value;
    }

    /**
     * Gets the value of the targetSystemType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targetSystemType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTargetSystemType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTargetSystemType() {
        if (targetSystemType == null) {
            targetSystemType = new ArrayList<String>();
        }
        return this.targetSystemType;
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
     * Gets the value of the connectorHost property.
     * 
     * @return
     *     possible object is
     *     {@link ConnectorHostType }
     *     
     */
    public ConnectorHostType getConnectorHost() {
        return connectorHost;
    }

    /**
     * Sets the value of the connectorHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConnectorHostType }
     *     
     */
    public void setConnectorHost(ConnectorHostType value) {
        this.connectorHost = value;
    }

    /**
     * Gets the value of the connectorHostRef property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectReferenceType }
     *     
     */
    public ObjectReferenceType getConnectorHostRef() {
        return connectorHostRef;
    }

    /**
     * Sets the value of the connectorHostRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectReferenceType }
     *     
     */
    public void setConnectorHostRef(ObjectReferenceType value) {
        this.connectorHostRef = value;
    }

    /**
     * 
     *                                 Connector configuration schema.
     * 
     *                                 This element contains the XSD-formatted definition of connector
     *                                 configuration schema. It defines connector configuration variables and data types such
     *                                 as host names, ports,
     *                                 administrator names and so on.
     * 
     *                                 Connector schema will most likely be only
     *                                 available at run-time
     *                                 and will be diffrent
     *                                 for
     *                                 every connector. It
     *                                 is supposed to be
     *                                 dynamically
     *                                 interpreted in run-time.
     * 
     *                                 Connector schema is
     *                                 read-only.
     *                                 Changing the
     *                                 schema
     *                                 is not supported.
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
            String theFramework;
            theFramework = this.getFramework();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "framework", theFramework), currentHashCode, theFramework);
        }
        {
            String theConnectorType;
            theConnectorType = this.getConnectorType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "connectorType", theConnectorType), currentHashCode, theConnectorType);
        }
        {
            String theConnectorVersion;
            theConnectorVersion = this.getConnectorVersion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "connectorVersion", theConnectorVersion), currentHashCode, theConnectorVersion);
        }
        {
            String theConnectorBundle;
            theConnectorBundle = this.getConnectorBundle();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "connectorBundle", theConnectorBundle), currentHashCode, theConnectorBundle);
        }
        {
            List<String> theTargetSystemType;
            theTargetSystemType = (((this.targetSystemType!= null)&&(!this.targetSystemType.isEmpty()))?this.getTargetSystemType():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "targetSystemType", theTargetSystemType), currentHashCode, theTargetSystemType);
        }
        {
            String theNamespace;
            theNamespace = this.getNamespace();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "namespace", theNamespace), currentHashCode, theNamespace);
        }
        {
            ConnectorHostType theConnectorHost;
            theConnectorHost = this.getConnectorHost();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "connectorHost", theConnectorHost), currentHashCode, theConnectorHost);
        }
        {
            ObjectReferenceType theConnectorHostRef;
            theConnectorHostRef = this.getConnectorHostRef();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "connectorHostRef", theConnectorHostRef), currentHashCode, theConnectorHostRef);
        }
        {
            com.evolveum.midpoint.xml.common.common_1.XmlSchemaType theSchema;
            theSchema = this.getSchema();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "schema", theSchema), currentHashCode, theSchema);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ConnectorType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final ConnectorType that = ((ConnectorType) object);
        {
            String lhsFramework;
            lhsFramework = this.getFramework();
            String rhsFramework;
            rhsFramework = that.getFramework();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "framework", lhsFramework), LocatorUtils.property(thatLocator, "framework", rhsFramework), lhsFramework, rhsFramework)) {
                return false;
            }
        }
        {
            String lhsConnectorType;
            lhsConnectorType = this.getConnectorType();
            String rhsConnectorType;
            rhsConnectorType = that.getConnectorType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "connectorType", lhsConnectorType), LocatorUtils.property(thatLocator, "connectorType", rhsConnectorType), lhsConnectorType, rhsConnectorType)) {
                return false;
            }
        }
        {
            String lhsConnectorVersion;
            lhsConnectorVersion = this.getConnectorVersion();
            String rhsConnectorVersion;
            rhsConnectorVersion = that.getConnectorVersion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "connectorVersion", lhsConnectorVersion), LocatorUtils.property(thatLocator, "connectorVersion", rhsConnectorVersion), lhsConnectorVersion, rhsConnectorVersion)) {
                return false;
            }
        }
        {
            String lhsConnectorBundle;
            lhsConnectorBundle = this.getConnectorBundle();
            String rhsConnectorBundle;
            rhsConnectorBundle = that.getConnectorBundle();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "connectorBundle", lhsConnectorBundle), LocatorUtils.property(thatLocator, "connectorBundle", rhsConnectorBundle), lhsConnectorBundle, rhsConnectorBundle)) {
                return false;
            }
        }
        {
            List<String> lhsTargetSystemType;
            lhsTargetSystemType = (((this.targetSystemType!= null)&&(!this.targetSystemType.isEmpty()))?this.getTargetSystemType():null);
            List<String> rhsTargetSystemType;
            rhsTargetSystemType = (((that.targetSystemType!= null)&&(!that.targetSystemType.isEmpty()))?that.getTargetSystemType():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "targetSystemType", lhsTargetSystemType), LocatorUtils.property(thatLocator, "targetSystemType", rhsTargetSystemType), lhsTargetSystemType, rhsTargetSystemType)) {
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
            ConnectorHostType lhsConnectorHost;
            lhsConnectorHost = this.getConnectorHost();
            ConnectorHostType rhsConnectorHost;
            rhsConnectorHost = that.getConnectorHost();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "connectorHost", lhsConnectorHost), LocatorUtils.property(thatLocator, "connectorHost", rhsConnectorHost), lhsConnectorHost, rhsConnectorHost)) {
                return false;
            }
        }
        {
            ObjectReferenceType lhsConnectorHostRef;
            lhsConnectorHostRef = this.getConnectorHostRef();
            ObjectReferenceType rhsConnectorHostRef;
            rhsConnectorHostRef = that.getConnectorHostRef();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "connectorHostRef", lhsConnectorHostRef), LocatorUtils.property(thatLocator, "connectorHostRef", rhsConnectorHostRef), lhsConnectorHostRef, rhsConnectorHostRef)) {
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
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = new DomAwareEqualsStrategy();
        return equals(null, null, object, strategy);
    }

}
