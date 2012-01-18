package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Defines value filter. The value filters are supposed to take a
 * single value of a specific type and return a single value of
 * the same type. Filters are used to transforms values, e.g.
 * to clean up illegal characters, to do charset transcoding, etc.
 * <p/>
 * Note:
 * Strictly speaking, filters should be used for things like
 * transliteration of national characters, case conversions, etc.
 * They should not be used to "technical" transformations such as
 * character set conversions. Connector should do that and connector
 * should return nice, clean unicode strings. But some connectors
 * are faulty and the ability of filters to do "technical" things
 * may come handy.
 * <p/>
 * <p/>
 * <p>Java class for ValueFilterType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ValueFilterType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValueFilterType", propOrder = {
        "any"
})
public class ValueFilterType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "type")
    @XmlSchemaType(name = "anyURI")
    protected String type;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ValueFilterType");
    public final static QName F_ANY = new QName(SchemaConstants.NS_COMMON, "any");
    public final static QName F_TYPE = new QName(SchemaConstants.NS_COMMON, "type");

    /**
     * Gets the value of the any property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link Element }
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setType(String value) {
        this.type = value;
    }

}
