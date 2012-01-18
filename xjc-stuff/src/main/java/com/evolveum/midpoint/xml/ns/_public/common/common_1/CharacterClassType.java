package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition of valid characters in class. Default
 * value is ASCII printable characters (Codes 0x20
 * to 0x7E)
 * <p/>
 * <p/>
 * <p>Java class for CharacterClassType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="CharacterClassType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="characterClass" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}CharacterClassType" maxOccurs="unbounded"/>
 *           &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CharacterClassType", propOrder = {
        "characterClass",
        "value"
})
public class CharacterClassType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected List<CharacterClassType> characterClass;
    protected String value;
    @XmlAttribute(name = "ref")
    protected QName ref;
    @XmlAttribute(name = "name")
    protected QName name;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "CharacterClassType");
    public final static QName F_CHARACTER_CLASS = new QName(SchemaConstants.NS_COMMON, "characterClass");
    public final static QName F_VALUE = new QName(SchemaConstants.NS_COMMON, "value");
    public final static QName F_REF = new QName(SchemaConstants.NS_COMMON, "ref");
    public final static QName F_NAME = new QName(SchemaConstants.NS_COMMON, "name");

    /**
     * Gets the value of the characterClass property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the characterClass property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharacterClass().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link CharacterClassType }
     */
    public List<CharacterClassType> getCharacterClass() {
        if (characterClass == null) {
            characterClass = new ArrayList<CharacterClassType>();
        }
        return this.characterClass;
    }

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the ref property.
     *
     * @return possible object is
     *         {@link QName }
     */
    public QName getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     *
     * @param value allowed object is
     *              {@link QName }
     */
    public void setRef(QName value) {
        this.ref = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     *         {@link QName }
     */
    public QName getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link QName }
     */
    public void setName(QName value) {
        this.name = value;
    }

}
