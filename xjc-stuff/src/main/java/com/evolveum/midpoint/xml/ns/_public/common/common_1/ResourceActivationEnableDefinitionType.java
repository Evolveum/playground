package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for ResourceActivationEnableDefinitionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ResourceActivationEnableDefinitionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="outbound" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ValueConstructionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceActivationEnableDefinitionType", propOrder = {
        "outbound"
})
public class ResourceActivationEnableDefinitionType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected ValueConstructionType outbound;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ResourceActivationEnableDefinitionType");
    public final static QName F_OUTBOUND = new QName(SchemaConstants.NS_COMMON, "outbound");

    /**
     * Gets the value of the outbound property.
     *
     * @return possible object is
     *         {@link ValueConstructionType }
     */
    public ValueConstructionType getOutbound() {
        return outbound;
    }

    /**
     * Sets the value of the outbound property.
     *
     * @param value allowed object is
     *              {@link ValueConstructionType }
     */
    public void setOutbound(ValueConstructionType value) {
        this.outbound = value;
    }

}
