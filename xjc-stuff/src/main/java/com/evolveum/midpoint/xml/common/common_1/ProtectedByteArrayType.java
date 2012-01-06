
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import com.evolveum.midpoint.schema.DomAwareEqualsStrategy;
import com.evolveum.midpoint.schema.DomAwareHashCodeStrategy;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;
import org.w3._2001._04.xmlenc.EncryptedDataType;


/**
 * 
 *                 ONLY COPIED AND PASTED FROM ProtectedStringType, please update if needed later
 *                 TODO
 *             
 * 
 * <p>Java class for ProtectedByteArrayType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
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
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProtectedByteArrayType", propOrder = {
    "encryptedData",
    "clearValue"
})
public class ProtectedByteArrayType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(name = "EncryptedData", namespace = "http://www.w3.org/2001/04/xmlenc#")
    protected EncryptedDataType encryptedData;
    protected String clearValue;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ProtectedByteArrayType");

    /**
     * 
     *                         Use of XML Encryption standard EncryptionData element.
     *                     
     * 
     * @return
     *     possible object is
     *     {@link EncryptedDataType }
     *     
     */
    public EncryptedDataType getEncryptedData() {
        return encryptedData;
    }

    /**
     * Sets the value of the encryptedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link EncryptedDataType }
     *     
     */
    public void setEncryptedData(EncryptedDataType value) {
        this.encryptedData = value;
    }

    /**
     * Gets the value of the clearValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClearValue() {
        return clearValue;
    }

    /**
     * Sets the value of the clearValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClearValue(String value) {
        this.clearValue = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            EncryptedDataType theEncryptedData;
            theEncryptedData = this.getEncryptedData();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "encryptedData", theEncryptedData), currentHashCode, theEncryptedData);
        }
        {
            String theClearValue;
            theClearValue = this.getClearValue();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "clearValue", theClearValue), currentHashCode, theClearValue);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ProtectedByteArrayType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ProtectedByteArrayType that = ((ProtectedByteArrayType) object);
        {
            EncryptedDataType lhsEncryptedData;
            lhsEncryptedData = this.getEncryptedData();
            EncryptedDataType rhsEncryptedData;
            rhsEncryptedData = that.getEncryptedData();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "encryptedData", lhsEncryptedData), LocatorUtils.property(thatLocator, "encryptedData", rhsEncryptedData), lhsEncryptedData, rhsEncryptedData)) {
                return false;
            }
        }
        {
            String lhsClearValue;
            lhsClearValue = this.getClearValue();
            String rhsClearValue;
            rhsClearValue = that.getClearValue();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "clearValue", lhsClearValue), LocatorUtils.property(thatLocator, "clearValue", rhsClearValue), lhsClearValue, rhsClearValue)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = new DomAwareEqualsStrategy();
        return equals(null, null, object, strategy);
    }

}
