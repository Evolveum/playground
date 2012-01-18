package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for PropertySimpleValueFilterType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PropertySimpleValueFilterType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}FilterType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}property"/>
 *         &lt;choice>
 *           &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *           &lt;element name="valueExpression" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExpressionType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertySimpleValueFilterType", propOrder = {
        "property",
        "value",
        "valueExpression"
})
public class PropertySimpleValueFilterType
        extends FilterType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlAnyElement
    protected Element property;
    protected Object value;
    protected ExpressionType valueExpression;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "PropertySimpleValueFilterType");
    public final static QName F_PROPERTY = new QName(SchemaConstants.NS_COMMON, "property");
    public final static QName F_VALUE = new QName(SchemaConstants.NS_COMMON, "value");
    public final static QName F_VALUE_EXPRESSION = new QName(SchemaConstants.NS_COMMON, "valueExpression");

    /**
     * XPath to the property being queried.
     * It is mandatory, as there is no reasonable
     * default as in the case of path.
     *
     * @return possible object is
     *         {@link Element }
     */
    public Element getProperty() {
        return property;
    }

    /**
     * Sets the value of the property property.
     *
     * @param value allowed object is
     *              {@link Element }
     */
    public void setProperty(Element value) {
        this.property = value;
    }

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     *         {@link Object }
     */
    public Object getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link Object }
     */
    public void setValue(Object value) {
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

}
