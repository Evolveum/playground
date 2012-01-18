package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for EntitlementConstructionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="EntitlementConstructionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ValueConstructionType">
 *       &lt;choice>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typeExpression" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExpressionType" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntitlementConstructionType", propOrder = {
        "type",
        "typeExpression"
})
public class EntitlementConstructionType
        extends ValueConstructionType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected String type;
    protected ExpressionType typeExpression;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "EntitlementConstructionType");
    public final static QName F_TYPE = new QName(SchemaConstants.NS_COMMON, "type");
    public final static QName F_TYPE_EXPRESSION = new QName(SchemaConstants.NS_COMMON, "typeExpression");

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

    /**
     * Gets the value of the typeExpression property.
     *
     * @return possible object is
     *         {@link ExpressionType }
     */
    public ExpressionType getTypeExpression() {
        return typeExpression;
    }

    /**
     * Sets the value of the typeExpression property.
     *
     * @param value allowed object is
     *              {@link ExpressionType }
     */
    public void setTypeExpression(ExpressionType value) {
        this.typeExpression = value;
    }

}
