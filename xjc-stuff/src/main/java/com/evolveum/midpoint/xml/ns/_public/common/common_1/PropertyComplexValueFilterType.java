package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for PropertyComplexValueFilterType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PropertyComplexValueFilterType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}FilterType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}path" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="value">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="valueExpression" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExpressionType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyComplexValueFilterType", propOrder = {
        "path",
        "value",
        "valueExpression"
})
public class PropertyComplexValueFilterType
        extends FilterType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlAnyElement
    protected Element path;
    protected PropertyComplexValueFilterType.Value value;
    protected ExpressionType valueExpression;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "PropertyComplexValueFilterType");
    public final static QName F_PATH = new QName(SchemaConstants.NS_COMMON, "path");
    public final static QName F_VALUE = new QName(SchemaConstants.NS_COMMON, "value");
    public final static QName F_VALUE_EXPRESSION = new QName(SchemaConstants.NS_COMMON, "valueExpression");

    /**
     * XPath to the containing XML element for the queried propoerty.
     * If not specified, defatults to "." (which is also the most usual value).
     *
     * @return possible object is
     *         {@link Element }
     */
    public Element getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     *
     * @param value allowed object is
     *              {@link Element }
     */
    public void setPath(Element value) {
        this.path = value;
    }

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     *         {@link PropertyComplexValueFilterType.Value }
     */
    public PropertyComplexValueFilterType.Value getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link PropertyComplexValueFilterType.Value }
     */
    public void setValue(PropertyComplexValueFilterType.Value value) {
        this.value = value;
    }

    /**
     * Gets the value of the valueExpression property.
     *
     * @return possible object is
     *         {@link ExpressionType }
     */
    public ExpressionType getValueExpression() {
        return valueExpression;
    }

    /**
     * Sets the value of the valueExpression property.
     *
     * @param value allowed object is
     *              {@link ExpressionType }
     */
    public void setValueExpression(ExpressionType value) {
        this.valueExpression = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * <p/>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "any"
    })
    public static class Value
            implements Serializable {

        private final static long serialVersionUID = 201105211233L;
        @XmlAnyElement
        protected List<Element> any;

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
         * {@link Element }
         */
        public List<Element> getAny() {
            if (any == null) {
                any = new ArrayList<Element>();
            }
            return this.any;
        }

    }

}
