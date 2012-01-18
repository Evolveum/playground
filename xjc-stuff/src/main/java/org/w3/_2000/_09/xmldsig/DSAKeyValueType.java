package org.w3._2000._09.xmldsig;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for DSAKeyValueType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="DSAKeyValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;sequence minOccurs="0">
 *           &lt;element name="P" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary"/>
 *           &lt;element name="Q" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary"/>
 *         &lt;/sequence>
 *         &lt;element name="J" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary" minOccurs="0"/>
 *         &lt;element name="G" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary" minOccurs="0"/>
 *         &lt;element name="Y" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary"/>
 *         &lt;sequence minOccurs="0">
 *           &lt;element name="Seed" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary"/>
 *           &lt;element name="PgenCounter" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSAKeyValueType", propOrder = {
        "p",
        "q",
        "j",
        "g",
        "y",
        "seed",
        "pgenCounter"
})
public class DSAKeyValueType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(name = "P")
    protected byte[] p;
    @XmlElement(name = "Q")
    protected byte[] q;
    @XmlElement(name = "J")
    protected byte[] j;
    @XmlElement(name = "G")
    protected byte[] g;
    @XmlElement(name = "Y", required = true)
    protected byte[] y;
    @XmlElement(name = "Seed")
    protected byte[] seed;
    @XmlElement(name = "PgenCounter")
    protected byte[] pgenCounter;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_XML_DSIG, "DSAKeyValueType");
    public final static QName F_P = new QName(SchemaConstants.NS_XML_DSIG, "p");
    public final static QName F_Q = new QName(SchemaConstants.NS_XML_DSIG, "q");
    public final static QName F_J = new QName(SchemaConstants.NS_XML_DSIG, "j");
    public final static QName F_G = new QName(SchemaConstants.NS_XML_DSIG, "g");
    public final static QName F_Y = new QName(SchemaConstants.NS_XML_DSIG, "y");
    public final static QName F_SEED = new QName(SchemaConstants.NS_XML_DSIG, "seed");
    public final static QName F_PGEN_COUNTER = new QName(SchemaConstants.NS_XML_DSIG, "pgenCounter");

    /**
     * Gets the value of the p property.
     *
     * @return possible object is
     *         byte[]
     */
    public byte[] getP() {
        return p;
    }

    /**
     * Sets the value of the p property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setP(byte[] value) {
        this.p = ((byte[]) value);
    }

    /**
     * Gets the value of the q property.
     *
     * @return possible object is
     *         byte[]
     */
    public byte[] getQ() {
        return q;
    }

    /**
     * Sets the value of the q property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setQ(byte[] value) {
        this.q = ((byte[]) value);
    }

    /**
     * Gets the value of the j property.
     *
     * @return possible object is
     *         byte[]
     */
    public byte[] getJ() {
        return j;
    }

    /**
     * Sets the value of the j property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setJ(byte[] value) {
        this.j = ((byte[]) value);
    }

    /**
     * Gets the value of the g property.
     *
     * @return possible object is
     *         byte[]
     */
    public byte[] getG() {
        return g;
    }

    /**
     * Sets the value of the g property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setG(byte[] value) {
        this.g = ((byte[]) value);
    }

    /**
     * Gets the value of the y property.
     *
     * @return possible object is
     *         byte[]
     */
    public byte[] getY() {
        return y;
    }

    /**
     * Sets the value of the y property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setY(byte[] value) {
        this.y = ((byte[]) value);
    }

    /**
     * Gets the value of the seed property.
     *
     * @return possible object is
     *         byte[]
     */
    public byte[] getSeed() {
        return seed;
    }

    /**
     * Sets the value of the seed property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setSeed(byte[] value) {
        this.seed = ((byte[]) value);
    }

    /**
     * Gets the value of the pgenCounter property.
     *
     * @return possible object is
     *         byte[]
     */
    public byte[] getPgenCounter() {
        return pgenCounter;
    }

    /**
     * Sets the value of the pgenCounter property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setPgenCounter(byte[] value) {
        this.pgenCounter = ((byte[]) value);
    }

}
