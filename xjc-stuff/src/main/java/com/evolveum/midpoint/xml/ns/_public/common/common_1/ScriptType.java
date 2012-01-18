package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Specifies how and when a script is executed during provisioning.
 * <p/>
 * <p/>
 * <p>Java class for ScriptType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ScriptType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="operation" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}OperationTypeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="order" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ScriptOrderType"/>
 *         &lt;element name="host" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ScriptHostType" minOccurs="0"/>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="argument" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ScriptArgumentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScriptType", propOrder = {
        "operation",
        "order",
        "host",
        "language",
        "argument",
        "code"
})
public class ScriptType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected List<OperationTypeType> operation;
    @XmlElement(required = true)
    protected ScriptOrderType order;
    @XmlElement(defaultValue = "resource")
    protected ScriptHostType host;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String language;
    protected List<ScriptArgumentType> argument;
    @XmlElement(required = true)
    protected String code;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ScriptType");
    public final static QName F_OPERATION = new QName(SchemaConstants.NS_COMMON, "operation");
    public final static QName F_ORDER = new QName(SchemaConstants.NS_COMMON, "order");
    public final static QName F_HOST = new QName(SchemaConstants.NS_COMMON, "host");
    public final static QName F_LANGUAGE = new QName(SchemaConstants.NS_COMMON, "language");
    public final static QName F_ARGUMENT = new QName(SchemaConstants.NS_COMMON, "argument");
    public final static QName F_CODE = new QName(SchemaConstants.NS_COMMON, "code");

    /**
     * Gets the value of the operation property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operation property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperation().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link OperationTypeType }
     */
    public List<OperationTypeType> getOperation() {
        if (operation == null) {
            operation = new ArrayList<OperationTypeType>();
        }
        return this.operation;
    }

    /**
     * Gets the value of the order property.
     *
     * @return possible object is
     *         {@link ScriptOrderType }
     */
    public ScriptOrderType getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     *
     * @param value allowed object is
     *              {@link ScriptOrderType }
     */
    public void setOrder(ScriptOrderType value) {
        this.order = value;
    }

    /**
     * Gets the value of the host property.
     *
     * @return possible object is
     *         {@link ScriptHostType }
     */
    public ScriptHostType getHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     *
     * @param value allowed object is
     *              {@link ScriptHostType }
     */
    public void setHost(ScriptHostType value) {
        this.host = value;
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
     * Gets the value of the argument property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the argument property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArgument().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ScriptArgumentType }
     */
    public List<ScriptArgumentType> getArgument() {
        if (argument == null) {
            argument = new ArrayList<ScriptArgumentType>();
        }
        return this.argument;
    }

    /**
     * Gets the value of the code property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCode(String value) {
        this.code = value;
    }

}
