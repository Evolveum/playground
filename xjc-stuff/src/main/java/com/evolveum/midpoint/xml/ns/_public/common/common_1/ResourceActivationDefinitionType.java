package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for ResourceActivationDefinitionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ResourceActivationDefinitionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enabled" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ResourceActivationEnableDefinitionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceActivationDefinitionType", propOrder = {
        "enabled"
})
public class ResourceActivationDefinitionType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected ResourceActivationEnableDefinitionType enabled;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ResourceActivationDefinitionType");
    public final static QName F_ENABLED = new QName(SchemaConstants.NS_COMMON, "enabled");

    /**
     * Gets the value of the enabled property.
     *
     * @return possible object is
     *         {@link ResourceActivationEnableDefinitionType }
     */
    public ResourceActivationEnableDefinitionType getEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     *
     * @param value allowed object is
     *              {@link ResourceActivationEnableDefinitionType }
     */
    public void setEnabled(ResourceActivationEnableDefinitionType value) {
        this.enabled = value;
    }

}
