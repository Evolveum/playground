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
 * <p>Java class for UnaryLogicalOperatorFilterType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UnaryLogicalOperatorFilterType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}LogicalOperatorFilterType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}filter"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnaryLogicalOperatorFilterType", propOrder = {
        "filter"
})
public class UnaryLogicalOperatorFilterType
        extends LogicalOperatorFilterType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlAnyElement
    protected Element filter;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "UnaryLogicalOperatorFilterType");
    public final static QName F_FILTER = new QName(SchemaConstants.NS_COMMON, "filter");

    /**
     * Gets the value of the filter property.
     *
     * @return possible object is
     *         {@link Element }
     */
    public Element getFilter() {
        return filter;
    }

    /**
     * Sets the value of the filter property.
     *
     * @param value allowed object is
     *              {@link Element }
     */
    public void setFilter(Element value) {
        this.filter = value;
    }

}
