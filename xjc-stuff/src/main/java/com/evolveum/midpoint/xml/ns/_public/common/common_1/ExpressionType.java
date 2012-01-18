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
 * Generic expression. The purpose of the expression is to return
 * a value. The expression must produce something that is a piece
 * of XML, which means that it may produce either string value,
 * XML node or a list of XML nodes.
 * <p/>
 * The expression may use variables or arguments. However, such
 * variables or arguments passed to the expression will be different
 * for each invocation. It should be documented in each case this type is used.
 * <p/>
 * <p/>
 * <p>Java class for ExpressionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ExpressionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}description" minOccurs="0"/>
 *         &lt;element name="ref" type="{http://www.w3.org/2001/XMLSchema}QName" minOccurs="0"/>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="variable" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}VariableDefinitionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="returnType" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExpressionReturnTypeType" minOccurs="0"/>
 *         &lt;element name="code" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExpressionCodeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExpressionType", propOrder = {
        "description",
        "ref",
        "language",
        "variable",
        "returnType",
        "code"
})
public class ExpressionType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected String description;
    protected QName ref;
    @XmlElement(defaultValue = "http://www.w3.org/TR/xpath/")
    @XmlSchemaType(name = "anyURI")
    protected String language;
    protected List<VariableDefinitionType> variable;
    protected ExpressionReturnTypeType returnType;
    @XmlAnyElement
    protected Element code;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ExpressionType");
    public final static QName F_DESCRIPTION = new QName(SchemaConstants.NS_COMMON, "description");
    public final static QName F_REF = new QName(SchemaConstants.NS_COMMON, "ref");
    public final static QName F_LANGUAGE = new QName(SchemaConstants.NS_COMMON, "language");
    public final static QName F_VARIABLE = new QName(SchemaConstants.NS_COMMON, "variable");
    public final static QName F_RETURN_TYPE = new QName(SchemaConstants.NS_COMMON, "returnType");
    public final static QName F_CODE = new QName(SchemaConstants.NS_COMMON, "code");

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
     * Gets the value of the language property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the variable property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variable property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVariable().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link VariableDefinitionType }
     */
    public List<VariableDefinitionType> getVariable() {
        if (variable == null) {
            variable = new ArrayList<VariableDefinitionType>();
        }
        return this.variable;
    }

    /**
     * Gets the value of the returnType property.
     *
     * @return possible object is
     *         {@link ExpressionReturnTypeType }
     */
    public ExpressionReturnTypeType getReturnType() {
        return returnType;
    }

    /**
     * Sets the value of the returnType property.
     *
     * @param value allowed object is
     *              {@link ExpressionReturnTypeType }
     */
    public void setReturnType(ExpressionReturnTypeType value) {
        this.returnType = value;
    }

    /**
     * Gets the value of the code property.
     *
     * @return possible object is
     *         {@link Element }
     */
    public Element getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     *
     * @param value allowed object is
     *              {@link Element }
     */
    public void setCode(Element value) {
        this.code = value;
    }

}
