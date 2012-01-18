package com.evolveum.midpoint.xml.ns._public.resource.resource_schema_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for ObjectClassAttributeType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ObjectClassAttributeType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd}AttributeReferenceType">
 *       &lt;all>
 *         &lt;element name="discriminatorFormula" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObjectClassAttributeType", propOrder = {
        "discriminatorFormula"
})
public class ObjectClassAttributeType
        extends AttributeReferenceType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected String discriminatorFormula;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_RESOURCE, "ObjectClassAttributeType");
    public final static QName F_DISCRIMINATOR_FORMULA = new QName(SchemaConstants.NS_RESOURCE, "discriminatorFormula");

    /**
     * Gets the value of the discriminatorFormula property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDiscriminatorFormula() {
        return discriminatorFormula;
    }

    /**
     * Sets the value of the discriminatorFormula property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDiscriminatorFormula(String value) {
        this.discriminatorFormula = value;
    }

}
