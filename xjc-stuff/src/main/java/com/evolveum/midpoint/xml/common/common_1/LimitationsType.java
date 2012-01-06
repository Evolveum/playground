
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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


/**
 * Definition of complexity and string policy
 *             
 * 
 * <p>Java class for limitationsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="limitationsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="minLength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxLength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="minUniqueChars" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="checkAgainstDictionary" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="checkPattern" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="limit" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}StringLimitType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "limitationsType", propOrder = {
    "minLength",
    "maxLength",
    "minUniqueChars",
    "checkAgainstDictionary",
    "checkPattern",
    "limit"
})
public class LimitationsType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(defaultValue = "0")
    protected Integer minLength;
    @XmlElement(defaultValue = "-1")
    protected Integer maxLength;
    @XmlElement(defaultValue = "0")
    protected Integer minUniqueChars;
    @XmlElement(defaultValue = "false")
    protected Boolean checkAgainstDictionary;
    protected String checkPattern;
    protected List<StringLimitType> limit;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "limitationsType");

    /**
     * Gets the value of the minLength property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinLength() {
        return minLength;
    }

    /**
     * Sets the value of the minLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinLength(Integer value) {
        this.minLength = value;
    }

    /**
     * Gets the value of the maxLength property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the value of the maxLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxLength(Integer value) {
        this.maxLength = value;
    }

    /**
     * Gets the value of the minUniqueChars property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinUniqueChars() {
        return minUniqueChars;
    }

    /**
     * Sets the value of the minUniqueChars property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinUniqueChars(Integer value) {
        this.minUniqueChars = value;
    }

    /**
     * Gets the value of the checkAgainstDictionary property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCheckAgainstDictionary() {
        return checkAgainstDictionary;
    }

    /**
     * Sets the value of the checkAgainstDictionary property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCheckAgainstDictionary(Boolean value) {
        this.checkAgainstDictionary = value;
    }

    /**
     * Gets the value of the checkPattern property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckPattern() {
        return checkPattern;
    }

    /**
     * Sets the value of the checkPattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckPattern(String value) {
        this.checkPattern = value;
    }

    /**
     * Gets the value of the limit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the limit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLimit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StringLimitType }
     * 
     * 
     */
    public List<StringLimitType> getLimit() {
        if (limit == null) {
            limit = new ArrayList<StringLimitType>();
        }
        return this.limit;
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
            Integer theMinLength;
            theMinLength = this.getMinLength();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "minLength", theMinLength), currentHashCode, theMinLength);
        }
        {
            Integer theMaxLength;
            theMaxLength = this.getMaxLength();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "maxLength", theMaxLength), currentHashCode, theMaxLength);
        }
        {
            Integer theMinUniqueChars;
            theMinUniqueChars = this.getMinUniqueChars();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "minUniqueChars", theMinUniqueChars), currentHashCode, theMinUniqueChars);
        }
        {
            Boolean theCheckAgainstDictionary;
            theCheckAgainstDictionary = this.isCheckAgainstDictionary();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "checkAgainstDictionary", theCheckAgainstDictionary), currentHashCode, theCheckAgainstDictionary);
        }
        {
            String theCheckPattern;
            theCheckPattern = this.getCheckPattern();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "checkPattern", theCheckPattern), currentHashCode, theCheckPattern);
        }
        {
            List<StringLimitType> theLimit;
            theLimit = (((this.limit!= null)&&(!this.limit.isEmpty()))?this.getLimit():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "limit", theLimit), currentHashCode, theLimit);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof LimitationsType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final LimitationsType that = ((LimitationsType) object);
        {
            Integer lhsMinLength;
            lhsMinLength = this.getMinLength();
            Integer rhsMinLength;
            rhsMinLength = that.getMinLength();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "minLength", lhsMinLength), LocatorUtils.property(thatLocator, "minLength", rhsMinLength), lhsMinLength, rhsMinLength)) {
                return false;
            }
        }
        {
            Integer lhsMaxLength;
            lhsMaxLength = this.getMaxLength();
            Integer rhsMaxLength;
            rhsMaxLength = that.getMaxLength();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "maxLength", lhsMaxLength), LocatorUtils.property(thatLocator, "maxLength", rhsMaxLength), lhsMaxLength, rhsMaxLength)) {
                return false;
            }
        }
        {
            Integer lhsMinUniqueChars;
            lhsMinUniqueChars = this.getMinUniqueChars();
            Integer rhsMinUniqueChars;
            rhsMinUniqueChars = that.getMinUniqueChars();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "minUniqueChars", lhsMinUniqueChars), LocatorUtils.property(thatLocator, "minUniqueChars", rhsMinUniqueChars), lhsMinUniqueChars, rhsMinUniqueChars)) {
                return false;
            }
        }
        {
            Boolean lhsCheckAgainstDictionary;
            lhsCheckAgainstDictionary = this.isCheckAgainstDictionary();
            Boolean rhsCheckAgainstDictionary;
            rhsCheckAgainstDictionary = that.isCheckAgainstDictionary();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "checkAgainstDictionary", lhsCheckAgainstDictionary), LocatorUtils.property(thatLocator, "checkAgainstDictionary", rhsCheckAgainstDictionary), lhsCheckAgainstDictionary, rhsCheckAgainstDictionary)) {
                return false;
            }
        }
        {
            String lhsCheckPattern;
            lhsCheckPattern = this.getCheckPattern();
            String rhsCheckPattern;
            rhsCheckPattern = that.getCheckPattern();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "checkPattern", lhsCheckPattern), LocatorUtils.property(thatLocator, "checkPattern", rhsCheckPattern), lhsCheckPattern, rhsCheckPattern)) {
                return false;
            }
        }
        {
            List<StringLimitType> lhsLimit;
            lhsLimit = (((this.limit!= null)&&(!this.limit.isEmpty()))?this.getLimit():null);
            List<StringLimitType> rhsLimit;
            rhsLimit = (((that.limit!= null)&&(!that.limit.isEmpty()))?that.getLimit():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "limit", lhsLimit), LocatorUtils.property(thatLocator, "limit", rhsLimit), lhsLimit, rhsLimit)) {
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
