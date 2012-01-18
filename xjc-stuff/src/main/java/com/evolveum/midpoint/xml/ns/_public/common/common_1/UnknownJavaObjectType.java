package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Type used to represent Java objects that are otherwise unknown to the system and cannot be
 * represented in "canonical" XML form. This must be used only in diagnostics messages intended
 * to be displayed to the human user. It must not be used in places indended for computer processing.
 * <p/>
 * <p/>
 * <p>Java class for UnknownJavaObjectType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UnknownJavaObjectType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="toString" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnknownJavaObjectType", propOrder = {
        "clazz",
        "toString"
})
public class UnknownJavaObjectType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(name = "class", required = true)
    protected String clazz;
    @XmlElement(required = true)
    protected String toString;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "UnknownJavaObjectType");
    public final static QName F_CLAZZ = new QName(SchemaConstants.NS_COMMON, "clazz");
    public final static QName F_TO_STRING = new QName(SchemaConstants.NS_COMMON, "toString");

    /**
     * Gets the value of the clazz property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the toString property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getToString() {
        return toString;
    }

    /**
     * Sets the value of the toString property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setToString(String value) {
        this.toString = value;
    }

}
