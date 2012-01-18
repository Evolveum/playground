package com.evolveum.midpoint.xml.ns._public.resource.resource_schema_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for OperationType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="OperationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="readAttribute" type="{http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd}AttributeReferenceType" minOccurs="0"/>
 *         &lt;element name="writeAttribute" type="{http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd}AttributeReferenceType" minOccurs="0"/>
 *         &lt;element name="valueFormula" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationType", propOrder = {
        "readAttribute",
        "writeAttribute",
        "valueFormula"
})
public class OperationType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected AttributeReferenceType readAttribute;
    protected AttributeReferenceType writeAttribute;
    protected String valueFormula;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "action", required = true)
    protected String action;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_RESOURCE, "OperationType");
    public final static QName F_READ_ATTRIBUTE = new QName(SchemaConstants.NS_RESOURCE, "readAttribute");
    public final static QName F_WRITE_ATTRIBUTE = new QName(SchemaConstants.NS_RESOURCE, "writeAttribute");
    public final static QName F_VALUE_FORMULA = new QName(SchemaConstants.NS_RESOURCE, "valueFormula");
    public final static QName F_NAME = new QName(SchemaConstants.NS_RESOURCE, "name");
    public final static QName F_ACTION = new QName(SchemaConstants.NS_RESOURCE, "action");

    /**
     * Gets the value of the readAttribute property.
     *
     * @return possible object is
     *         {@link AttributeReferenceType }
     */
    public AttributeReferenceType getReadAttribute() {
        return readAttribute;
    }

    /**
     * Sets the value of the readAttribute property.
     *
     * @param value allowed object is
     *              {@link AttributeReferenceType }
     */
    public void setReadAttribute(AttributeReferenceType value) {
        this.readAttribute = value;
    }

    /**
     * Gets the value of the writeAttribute property.
     *
     * @return possible object is
     *         {@link AttributeReferenceType }
     */
    public AttributeReferenceType getWriteAttribute() {
        return writeAttribute;
    }

    /**
     * Sets the value of the writeAttribute property.
     *
     * @param value allowed object is
     *              {@link AttributeReferenceType }
     */
    public void setWriteAttribute(AttributeReferenceType value) {
        this.writeAttribute = value;
    }

    /**
     * Gets the value of the valueFormula property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getValueFormula() {
        return valueFormula;
    }

    /**
     * Sets the value of the valueFormula property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValueFormula(String value) {
        this.valueFormula = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the action property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAction(String value) {
        this.action = value;
    }

}
