package org.w3._2001._04.xmlenc;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for EncryptedKeyType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="EncryptedKeyType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.w3.org/2001/04/xmlenc#}EncryptedType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.w3.org/2001/04/xmlenc#}ReferenceList" minOccurs="0"/>
 *         &lt;element name="CarriedKeyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Recipient" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EncryptedKeyType", propOrder = {
        "referenceList",
        "carriedKeyName"
})
public class EncryptedKeyType
        extends EncryptedType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(name = "ReferenceList")
    protected ReferenceList referenceList;
    @XmlElement(name = "CarriedKeyName")
    protected String carriedKeyName;
    @XmlAttribute(name = "Recipient")
    protected String recipient;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_XML_ENC, "EncryptedKeyType");
    public final static QName F_REFERENCE_LIST = new QName(SchemaConstants.NS_XML_ENC, "referenceList");
    public final static QName F_CARRIED_KEY_NAME = new QName(SchemaConstants.NS_XML_ENC, "carriedKeyName");
    public final static QName F_RECIPIENT = new QName(SchemaConstants.NS_XML_ENC, "recipient");

    /**
     * Gets the value of the referenceList property.
     *
     * @return possible object is
     *         {@link ReferenceList }
     */
    public ReferenceList getReferenceList() {
        return referenceList;
    }

    /**
     * Sets the value of the referenceList property.
     *
     * @param value allowed object is
     *              {@link ReferenceList }
     */
    public void setReferenceList(ReferenceList value) {
        this.referenceList = value;
    }

    /**
     * Gets the value of the carriedKeyName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCarriedKeyName() {
        return carriedKeyName;
    }

    /**
     * Sets the value of the carriedKeyName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCarriedKeyName(String value) {
        this.carriedKeyName = value;
    }

    /**
     * Gets the value of the recipient property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * Sets the value of the recipient property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRecipient(String value) {
        this.recipient = value;
    }

}
