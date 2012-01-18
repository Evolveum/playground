package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for ResourceCredentialsDefinitionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ResourceCredentialsDefinitionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="password" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ResourcePasswordDefinitionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceCredentialsDefinitionType", propOrder = {
        "password"
})
public class ResourceCredentialsDefinitionType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected ResourcePasswordDefinitionType password;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ResourceCredentialsDefinitionType");
    public final static QName F_PASSWORD = new QName(SchemaConstants.NS_COMMON, "password");

    /**
     * Gets the value of the password property.
     *
     * @return possible object is
     *         {@link ResourcePasswordDefinitionType }
     */
    public ResourcePasswordDefinitionType getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value allowed object is
     *              {@link ResourcePasswordDefinitionType }
     */
    public void setPassword(ResourcePasswordDefinitionType value) {
        this.password = value;
    }

}
