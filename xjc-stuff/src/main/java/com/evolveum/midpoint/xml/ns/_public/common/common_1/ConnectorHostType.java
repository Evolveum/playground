package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Host definition for remote connector, remote
 * connector framework or a remote "gateway".
 * <p/>
 * Note that this is a generic concept of a connector host, not specific to
 * any connector framework. It can be extended with a framework-specific
 * configuration using the usual "extension" element.
 * <p/>
 * <p/>
 * <p>Java class for ConnectorHostType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
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
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ConnectorHostType");
    public final static QName F_HOSTNAME = new QName(SchemaConstants.NS_COMMON, "hostname");
    public final static QName F_PORT = new QName(SchemaConstants.NS_COMMON, "port");
    public final static QName F_SHARED_SECRET = new QName(SchemaConstants.NS_COMMON, "sharedSecret");
    public final static QName F_TIMEOUT = new QName(SchemaConstants.NS_COMMON, "timeout");

    @XmlElement(required = true)
    public String getHostname() {
        return getPropertyValue(F_HOSTNAME, String.class);
    }

    public void setHostname(String value) {
        setPropertyValue(F_HOSTNAME, value);
    }

    public String getPort() {
        return getPropertyValue(F_PORT, String.class);
    }

    public void setPort(String value) {
        setPropertyValue(F_PORT, value);
    }

    public String getSharedSecret() {
        return getPropertyValue(F_SHARED_SECRET, String.class);
    }

    public void setSharedSecret(String value) {
        setPropertyValue(F_SHARED_SECRET, value);
    }

    public Integer getTimeout() {
        return getPropertyValue(F_TIMEOUT, Integer.class);
    }

    public void setTimeout(Integer value) {
        setPropertyValue(F_TIMEOUT, value);
    }

}
