package org.w3._2000._09.xmldsig;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for RSAKeyValueType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="RSAKeyValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Modulus" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary"/>
 *         &lt;element name="Exponent" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RSAKeyValueType", propOrder = {
        "modulus",
        "exponent"
})
public class RSAKeyValueType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(name = "Modulus", required = true)
    protected byte[] modulus;
    @XmlElement(name = "Exponent", required = true)
    protected byte[] exponent;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_XML_DSIG, "RSAKeyValueType");
    public final static QName F_MODULUS = new QName(SchemaConstants.NS_XML_DSIG, "modulus");
    public final static QName F_EXPONENT = new QName(SchemaConstants.NS_XML_DSIG, "exponent");

    /**
     * Gets the value of the modulus property.
     *
     * @return possible object is
     *         byte[]
     */
    public byte[] getModulus() {
        return modulus;
    }

    /**
     * Sets the value of the modulus property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setModulus(byte[] value) {
        this.modulus = ((byte[]) value);
    }

    /**
     * Gets the value of the exponent property.
     *
     * @return possible object is
     *         byte[]
     */
    public byte[] getExponent() {
        return exponent;
    }

    /**
     * Sets the value of the exponent property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setExponent(byte[] value) {
        this.exponent = ((byte[]) value);
    }

}
