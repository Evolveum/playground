package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import org.w3._2001._04.xmlenc.EncryptedDataType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * ONLY COPIED AND PASTED FROM ProtectedStringType, please update if needed later
 * TODO
 * <p/>
 * <p/>
 * <p>Java class for ProtectedByteArrayType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ProtectedByteArrayType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.w3.org/2001/04/xmlenc#}EncryptedData"/>
 *         &lt;element name="clearValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProtectedByteArrayType", propOrder = {
        "encryptedData",
        "clearValue"
})
public class ProtectedByteArrayType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(name = "EncryptedData", namespace = "http://www.w3.org/2001/04/xmlenc#")
    protected EncryptedDataType encryptedData;
    protected String clearValue;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ProtectedByteArrayType");
    public final static QName F_ENCRYPTED_DATA = new QName(SchemaConstants.NS_COMMON, "encryptedData");
    public final static QName F_CLEAR_VALUE = new QName(SchemaConstants.NS_COMMON, "clearValue");

    /**
     * Use of XML Encryption standard EncryptionData element.
     *
     * @return possible object is
     *         {@link EncryptedDataType }
     */
    public EncryptedDataType getEncryptedData() {
        return encryptedData;
    }

    /**
     * Sets the value of the encryptedData property.
     *
     * @param value allowed object is
     *              {@link EncryptedDataType }
     */
    public void setEncryptedData(EncryptedDataType value) {
        this.encryptedData = value;
    }

    /**
     * Gets the value of the clearValue property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getClearValue() {
        return clearValue;
    }

    /**
     * Sets the value of the clearValue property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setClearValue(String value) {
        this.clearValue = value;
    }

}
