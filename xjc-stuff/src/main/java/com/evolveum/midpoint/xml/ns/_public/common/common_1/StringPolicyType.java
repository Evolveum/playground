package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for StringPolicyType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="StringPolicyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="limitations" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}limitationsType" minOccurs="0"/>
 *         &lt;element name="characterClass" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}CharacterClassType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StringPolicyType", propOrder = {
        "description",
        "limitations",
        "characterClass"
})
public class StringPolicyType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected String description;
    protected LimitationsType limitations;
    protected CharacterClassType characterClass;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "StringPolicyType");
    public final static QName F_DESCRIPTION = new QName(SchemaConstants.NS_COMMON, "description");
    public final static QName F_LIMITATIONS = new QName(SchemaConstants.NS_COMMON, "limitations");
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
     * Gets the value of the limitations property.
     *
     * @return possible object is
     *         {@link LimitationsType }
     */
    public LimitationsType getLimitations() {
        return limitations;
    }

    /**
     * Sets the value of the limitations property.
     *
     * @param value allowed object is
     *              {@link LimitationsType }
     */
    public void setLimitations(LimitationsType value) {
        this.limitations = value;
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
