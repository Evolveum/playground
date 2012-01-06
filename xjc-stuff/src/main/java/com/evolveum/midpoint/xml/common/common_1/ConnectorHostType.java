
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
 *                 Host definition for remote connector, remote
 *                 connector framework or a remote "gateway".
 * 
 *                 Note that this is a
 *                 generic concept of a connector host, not specific to
 *                 any
 *                 connector
 *                 framework. It can be extended with a framework-specific
 *                 configuration
 *                 using the usual "extension" element.
 *             
 * 
 * <p>Java class for ConnectorHostType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConnectorHostType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExtensibleObjectType">
 *       &lt;sequence>
 *         &lt;element name="hostname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="port" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sharedSecret" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeout" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConnectorHostType", propOrder = {
    "hostname",
    "port",
    "sharedSecret",
    "timeout"
})
public class ConnectorHostType
    extends ExtensibleObjectType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected String hostname;
    protected String port;
    protected String sharedSecret;
    protected Integer timeout;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ConnectorHostType");

    /**
     * Gets the value of the hostname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * Sets the value of the hostname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostname(String value) {
        this.hostname = value;
    }

    /**
     * Gets the value of the port property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPort(String value) {
        this.port = value;
    }

    /**
     * Gets the value of the sharedSecret property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSharedSecret() {
        return sharedSecret;
    }

    /**
     * Sets the value of the sharedSecret property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSharedSecret(String value) {
        this.sharedSecret = value;
    }

    /**
     * Gets the value of the timeout property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTimeout() {
        return timeout;
    }

    /**
     * Sets the value of the timeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTimeout(Integer value) {
        this.timeout = value;
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
            String theHostname;
            theHostname = this.getHostname();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "hostname", theHostname), currentHashCode, theHostname);
        }
        {
            String thePort;
            thePort = this.getPort();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "port", thePort), currentHashCode, thePort);
        }
        {
            String theSharedSecret;
            theSharedSecret = this.getSharedSecret();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sharedSecret", theSharedSecret), currentHashCode, theSharedSecret);
        }
        {
            Integer theTimeout;
            theTimeout = this.getTimeout();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "timeout", theTimeout), currentHashCode, theTimeout);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ConnectorHostType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final ConnectorHostType that = ((ConnectorHostType) object);
        {
            String lhsHostname;
            lhsHostname = this.getHostname();
            String rhsHostname;
            rhsHostname = that.getHostname();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "hostname", lhsHostname), LocatorUtils.property(thatLocator, "hostname", rhsHostname), lhsHostname, rhsHostname)) {
                return false;
            }
        }
        {
            String lhsPort;
            lhsPort = this.getPort();
            String rhsPort;
            rhsPort = that.getPort();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "port", lhsPort), LocatorUtils.property(thatLocator, "port", rhsPort), lhsPort, rhsPort)) {
                return false;
            }
        }
        {
            String lhsSharedSecret;
            lhsSharedSecret = this.getSharedSecret();
            String rhsSharedSecret;
            rhsSharedSecret = that.getSharedSecret();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sharedSecret", lhsSharedSecret), LocatorUtils.property(thatLocator, "sharedSecret", rhsSharedSecret), lhsSharedSecret, rhsSharedSecret)) {
                return false;
            }
        }
        {
            Integer lhsTimeout;
            lhsTimeout = this.getTimeout();
            Integer rhsTimeout;
            rhsTimeout = that.getTimeout();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "timeout", lhsTimeout), LocatorUtils.property(thatLocator, "timeout", rhsTimeout), lhsTimeout, rhsTimeout)) {
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
