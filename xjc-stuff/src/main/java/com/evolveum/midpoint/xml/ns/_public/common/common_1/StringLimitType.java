package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Definition of valid single string limitation
 * <p/>
 * <p/>
 * <p>Java class for StringLimitType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="StringLimitType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minOccurs" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxOccurs" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="mustBeFirst" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="characterClass" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}CharacterClassType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StringLimitType", propOrder = {
        "description",
        "minOccurs",
        "maxOccurs",
        "mustBeFirst",
        "characterClass"
})
public class StringLimitType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected String description;
    @XmlElement(defaultValue = "0")
    protected Integer minOccurs;
    @XmlElement(defaultValue = "-1")
    protected Integer maxOccurs;
    @XmlElement(defaultValue = "false")
    protected Boolean mustBeFirst;
    protected CharacterClassType characterClass;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "StringLimitType");
    public final static QName F_DESCRIPTION = new QName(SchemaConstants.NS_COMMON, "description");
    public final static QName F_MIN_OCCURS = new QName(SchemaConstants.NS_COMMON, "minOccurs");
    public final static QName F_MAX_OCCURS = new QName(SchemaConstants.NS_COMMON, "maxOccurs");
    public final static QName F_MUST_BE_FIRST = new QName(SchemaConstants.NS_COMMON, "mustBeFirst");
    public final static QName F_CHARACTER_CLASS = new QName(SchemaConstants.NS_COMMON, "characterClass");

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the minOccurs property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getMinOccurs() {
        return minOccurs;
    }

    /**
     * Sets the value of the minOccurs property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMinOccurs(Integer value) {
        this.minOccurs = value;
    }

    /**
     * Gets the value of the maxOccurs property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getMaxOccurs() {
        return maxOccurs;
    }

    /**
     * Sets the value of the maxOccurs property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMaxOccurs(Integer value) {
        this.maxOccurs = value;
    }

    /**
     * Gets the value of the mustBeFirst property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isMustBeFirst() {
        return mustBeFirst;
    }

    /**
     * Sets the value of the mustBeFirst property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setMustBeFirst(Boolean value) {
        this.mustBeFirst = value;
    }

    /**
     * Gets the value of the characterClass property.
     *
     * @return possible object is
     *         {@link CharacterClassType }
     */
    public CharacterClassType getCharacterClass() {
        return characterClass;
    }

    /**
     * Sets the value of the characterClass property.
     *
     * @param value allowed object is
     *              {@link CharacterClassType }
     */
    public void setCharacterClass(CharacterClassType value) {
        this.characterClass = value;
    }

}
