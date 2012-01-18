package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Definition of construction of a (general) property. The property
 * may be constructed as a static value of as a result of an
 * expression (See ValueConstructionType documentation).
 * This can be used e.g. to constuct a value for user's fullName
 * in User Template or also on other places in the future.
 * <p/>
 * <p/>
 * <p>Java class for PropertyConstructionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PropertyConstructionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}PropertyReferenceType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}description" minOccurs="0"/>
 *         &lt;element name="valueConstruction" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ValueConstructionType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyConstructionType", propOrder = {
        "description",
        "valueConstruction"
})
public class PropertyConstructionType
        extends PropertyReferenceType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected String description;
    @XmlElement(required = true)
    protected ValueConstructionType valueConstruction;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "PropertyConstructionType");
    public final static QName F_DESCRIPTION = new QName(SchemaConstants.NS_COMMON, "description");
    public final static QName F_VALUE_CONSTRUCTION = new QName(SchemaConstants.NS_COMMON, "valueConstruction");

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the valueConstruction property.
     *
     * @return possible object is
     *         {@link ValueConstructionType }
     */
    public ValueConstructionType getValueConstruction() {
        return valueConstruction;
    }

    /**
     * Sets the value of the valueConstruction property.
     *
     * @param value allowed object is
     *              {@link ValueConstructionType }
     */
    public void setValueConstruction(ValueConstructionType value) {
        this.valueConstruction = value;
    }

}
