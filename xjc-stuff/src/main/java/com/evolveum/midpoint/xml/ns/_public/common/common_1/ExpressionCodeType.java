package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * The expression code is supposed to be in the contect of this type. The content ix "mixed"
 * which allows both XML and non-XML languages.
 * <p/>
 * The expression may use variables or arguments. However, such variables or arguments passed
 * to the expression will be different for each invocation. It should be documented in each
 * case this type is used.
 * <p/>
 * <p/>
 * <p>Java class for ExpressionCodeType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ExpressionCodeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExpressionCodeType", propOrder = {
        "content"
})
public class ExpressionCodeType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlValue
    protected String content;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ExpressionCodeType");
    public final static QName F_CONTENT = new QName(SchemaConstants.NS_COMMON, "content");

    /**
     * The expression code is supposed to be in the contect of this type. The content ix "mixed"
     * which allows both XML and non-XML languages.
     * <p/>
     * The expression may use variables or arguments. However, such variables or arguments passed
     * to the expression will be different for each invocation. It should be documented in each
     * case this type is used.
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
