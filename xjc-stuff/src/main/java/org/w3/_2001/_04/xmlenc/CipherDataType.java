package org.w3._2001._04.xmlenc;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for CipherDataType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="CipherDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="CipherValue" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element ref="{http://www.w3.org/2001/04/xmlenc#}CipherReference"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CipherDataType", propOrder = {
        "cipherValue",
        "cipherReference"
})
public class CipherDataType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(name = "CipherValue")
    protected byte[] cipherValue;
    @XmlElement(name = "CipherReference")
    protected CipherReferenceType cipherReference;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_XML_ENC, "CipherDataType");
    public final static QName F_CIPHER_VALUE = new QName(SchemaConstants.NS_XML_ENC, "cipherValue");
    public final static QName F_CIPHER_REFERENCE = new QName(SchemaConstants.NS_XML_ENC, "cipherReference");

    /**
     * Gets the value of the cipherValue property.
     *
     * @return possible object is
     *         byte[]
     */
    public byte[] getCipherValue() {
        return cipherValue;
    }

    /**
     * Sets the value of the cipherValue property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setCipherValue(byte[] value) {
        this.cipherValue = ((byte[]) value);
    }

    /**
     * Gets the value of the cipherReference property.
     *
     * @return possible object is
     *         {@link CipherReferenceType }
     */
    public CipherReferenceType getCipherReference() {
        return cipherReference;
    }

    /**
     * Sets the value of the cipherReference property.
     *
     * @param value allowed object is
     *              {@link CipherReferenceType }
     */
    public void setCipherReference(CipherReferenceType value) {
        this.cipherReference = value;
    }

}
