package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Definition of a variable. This type declares a variable name
 * and defines the initial content of the variable.
 * <p/>
 * <p/>
 * <p>Java class for VariableDefinitionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="VariableDefinitionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}QName"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}description" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="objectRef" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectReferenceType"/>
 *           &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VariableDefinitionType", propOrder = {
        "name",
        "description",
        "objectRef",
        "value"
})
public class VariableDefinitionType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected QName name;
    protected String description;
    protected ObjectReferenceType objectRef;
    protected String value;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "VariableDefinitionType");
    public final static QName F_NAME = new QName(SchemaConstants.NS_COMMON, "name");
    public final static QName F_DESCRIPTION = new QName(SchemaConstants.NS_COMMON, "description");
    public final static QName F_OBJECT_REF = new QName(SchemaConstants.NS_COMMON, "objectRef");
    public final static QName F_VALUE = new QName(SchemaConstants.NS_COMMON, "value");

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     *         {@link QName }
     */
    public QName getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link QName }
     */
    public void setName(QName value) {
        this.name = value;
    }

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
     * Gets the value of the objectRef property.
     *
     * @return possible object is
     *         {@link ObjectReferenceType }
     */
    public ObjectReferenceType getObjectRef() {
        return objectRef;
    }

    /**
     * Sets the value of the objectRef property.
     *
     * @param value allowed object is
     *              {@link ObjectReferenceType }
     */
    public void setObjectRef(ObjectReferenceType value) {
        this.objectRef = value;
    }

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValue(String value) {
        this.value = value;
    }

}
