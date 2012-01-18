package com.evolveum.midpoint.xml.ns._public.resource.resource_schema_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for ClassifiedAttributeType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ClassifiedAttributeType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd}AttributeReferenceType">
 *       &lt;all>
 *         &lt;element name="encryption">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="HASH"/>
 *               &lt;enumeration value="NONE"/>
 *               &lt;enumeration value="SYMMETRIC"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="classificationLevel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassifiedAttributeType", propOrder = {
        "encryption",
        "classificationLevel"
})
public class ClassifiedAttributeType
        extends AttributeReferenceType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected String encryption;
    @XmlElement(required = true)
    protected String classificationLevel;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_RESOURCE, "ClassifiedAttributeType");
    public final static QName F_ENCRYPTION = new QName(SchemaConstants.NS_RESOURCE, "encryption");
    public final static QName F_CLASSIFICATION_LEVEL = new QName(SchemaConstants.NS_RESOURCE, "classificationLevel");

    /**
     * Gets the value of the encryption property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getEncryption() {
        return encryption;
    }

    /**
     * Sets the value of the encryption property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEncryption(String value) {
        this.encryption = value;
    }

    /**
     * Gets the value of the classificationLevel property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getClassificationLevel() {
        return classificationLevel;
    }

    /**
     * Sets the value of the classificationLevel property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setClassificationLevel(String value) {
        this.classificationLevel = value;
    }

}
