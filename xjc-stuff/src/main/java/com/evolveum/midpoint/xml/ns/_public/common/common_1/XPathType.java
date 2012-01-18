package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Defines a type for XPath pointer. It points to a specific part
 * of the XML tree. Only a path expressions should be used in
 * this type, as it is used as an l-value, i.e. pointing to a
 * part of XML where an value can be assigned.
 * <p/>
 * cf. ExpressionType
 * <p/>
 * <p/>
 * <p>Java class for XPathType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="XPathType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XPathType", propOrder = {
        "content"
})
public class XPathType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlValue
    protected String content;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "XPathType");
    public final static QName F_CONTENT = new QName(SchemaConstants.NS_COMMON, "content");

    /**
     * Defines a type for XPath pointer. It points to a specific part
     * of the XML tree. Only a path expressions should be used in
     * this type, as it is used as an l-value, i.e. pointing to a
     * part of XML where an value can be assigned.
     * <p/>
     * cf. ExpressionType
     *
     * @return possible object is
     *         {@link String }
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setContent(String value) {
        this.content = value;
    }

}
