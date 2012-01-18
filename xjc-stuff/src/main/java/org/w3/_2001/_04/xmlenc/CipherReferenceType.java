package org.w3._2001._04.xmlenc;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for CipherReferenceType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="CipherReferenceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Transforms" type="{http://www.w3.org/2001/04/xmlenc#}TransformsType" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="URI" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CipherReferenceType", propOrder = {
        "transforms"
})
public class CipherReferenceType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(name = "Transforms")
    protected TransformsType transforms;
    @XmlAttribute(name = "URI", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String uri;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_XML_ENC, "CipherReferenceType");
    public final static QName F_TRANSFORMS = new QName(SchemaConstants.NS_XML_ENC, "transforms");
    public final static QName F_URI = new QName(SchemaConstants.NS_XML_ENC, "uri");

    /**
     * Gets the value of the transforms property.
     *
     * @return possible object is
     *         {@link TransformsType }
     */
    public TransformsType getTransforms() {
        return transforms;
    }

    /**
     * Sets the value of the transforms property.
     *
     * @param value allowed object is
     *              {@link TransformsType }
     */
    public void setTransforms(TransformsType value) {
        this.transforms = value;
    }

    /**
     * Gets the value of the uri property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getURI() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setURI(String value) {
        this.uri = value;
    }

}
