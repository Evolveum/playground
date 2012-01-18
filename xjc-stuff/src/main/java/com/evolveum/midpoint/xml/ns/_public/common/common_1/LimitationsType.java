package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition of complexity and string policy
 * <p/>
 * <p/>
 * <p>Java class for limitationsType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
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
public class LimitationsType implements Serializable {

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
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "limitationsType");
    public final static QName F_MIN_LENGTH = new QName(SchemaConstants.NS_COMMON, "minLength");
    public final static QName F_MAX_LENGTH = new QName(SchemaConstants.NS_COMMON, "maxLength");
    public final static QName F_MIN_UNIQUE_CHARS = new QName(SchemaConstants.NS_COMMON, "minUniqueChars");
    public final static QName F_CHECK_AGAINST_DICTIONARY = new QName(SchemaConstants.NS_COMMON, "checkAgainstDictionary");
    public final static QName F_CHECK_PATTERN = new QName(SchemaConstants.NS_COMMON, "checkPattern");
    public final static QName F_LIMIT = new QName(SchemaConstants.NS_COMMON, "limit");

    /**
     * Gets the value of the minLength property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getMinLength() {
        return minLength;
    }

    /**
     * Sets the value of the minLength property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMinLength(Integer value) {
        this.minLength = value;
    }

    /**
     * Gets the value of the maxLength property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the value of the maxLength property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMaxLength(Integer value) {
        this.maxLength = value;
    }

    /**
     * Gets the value of the minUniqueChars property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getMinUniqueChars() {
        return minUniqueChars;
    }

    /**
     * Sets the value of the minUniqueChars property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMinUniqueChars(Integer value) {
        this.minUniqueChars = value;
    }

    /**
     * Gets the value of the checkAgainstDictionary property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isCheckAgainstDictionary() {
        return checkAgainstDictionary;
    }

    /**
     * Sets the value of the checkAgainstDictionary property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setCheckAgainstDictionary(Boolean value) {
        this.checkAgainstDictionary = value;
    }

    /**
     * Gets the value of the checkPattern property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCheckPattern() {
        return checkPattern;
    }

    /**
     * Sets the value of the checkPattern property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCheckPattern(String value) {
        this.checkPattern = value;
    }

    /**
     * Gets the value of the limit property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the limit property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLimit().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link StringLimitType }
     */
    public List<StringLimitType> getLimit() {
        if (limit == null) {
            limit = new ArrayList<StringLimitType>();
        }
        return this.limit;
    }

}
