package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for EntryType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="EntryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;any processContents='lax' minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="key" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntryType", propOrder = {
        "any"
})
public class EntryType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlAnyElement(lax = true)
    protected Object any;
    @XmlAttribute(name = "key", required = true)
    protected String key;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "EntryType");
    public final static QName F_ANY = new QName(SchemaConstants.NS_COMMON, "any");
    public final static QName F_KEY = new QName(SchemaConstants.NS_COMMON, "key");

    /**
     * Gets the value of the any property.
     *
     * @return possible object is
     *         {@link Object }
     *         {@link Element }
     */
    public Object getAny() {
        return any;
    }

    /**
     * Sets the value of the any property.
     *
     * @param value allowed object is
     *              {@link Object }
     *              {@link Element }
     */
    public void setAny(Object value) {
        this.any = value;
    }

    /**
     * Gets the value of the key property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setKey(String value) {
        this.key = value;
    }

}
