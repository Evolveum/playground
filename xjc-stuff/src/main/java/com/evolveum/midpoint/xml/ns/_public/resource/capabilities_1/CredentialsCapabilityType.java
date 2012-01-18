package com.evolveum.midpoint.xml.ns._public.resource.capabilities_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Describes capability to present credentials in a structured way.
 * <p/>
 * <p/>
 * <p>Java class for CredentialsCapabilityType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="CredentialsCapabilityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="password" type="{http://midpoint.evolveum.com/xml/ns/public/resource/capabilities-1.xsd}PasswordCapabilityType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CredentialsCapabilityType", propOrder = {
        "password"
})
public class CredentialsCapabilityType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected PasswordCapabilityType password;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_CAPABILITIES, "CredentialsCapabilityType");
    public final static QName F_PASSWORD = new QName(SchemaConstants.NS_CAPABILITIES, "password");

    /**
     * Gets the value of the password property.
     *
     * @return possible object is
     *         {@link PasswordCapabilityType }
     */
    public PasswordCapabilityType getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value allowed object is
     *              {@link PasswordCapabilityType }
     */
    public void setPassword(PasswordCapabilityType value) {
        this.password = value;
    }

}
