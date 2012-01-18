package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Parameters limiting the number of returned
 * entries, offset, etc.
 * Used in the web service operations
 * such as list or search
 * <p/>
 * <p/>
 * <p>Java class for PagingType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PagingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderBy" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}PropertyReferenceType" minOccurs="0"/>
 *         &lt;element name="orderDirection" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}OrderDirectionType" minOccurs="0"/>
 *         &lt;element name="offset" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PagingType", propOrder = {
        "orderBy",
        "orderDirection",
        "offset",
        "maxSize"
})
public class PagingType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected PropertyReferenceType orderBy;
    @XmlElement(defaultValue = "ascending")
    protected OrderDirectionType orderDirection;
    @XmlElement(defaultValue = "0")
    protected Integer offset;
    @XmlElement(defaultValue = "2147483647")
    protected Integer maxSize;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "PagingType");
    public final static QName F_ORDER_BY = new QName(SchemaConstants.NS_COMMON, "orderBy");
    public final static QName F_ORDER_DIRECTION = new QName(SchemaConstants.NS_COMMON, "orderDirection");
    public final static QName F_OFFSET = new QName(SchemaConstants.NS_COMMON, "offset");
    public final static QName F_MAX_SIZE = new QName(SchemaConstants.NS_COMMON, "maxSize");

    /**
     * Gets the value of the orderBy property.
     *
     * @return possible object is
     *         {@link PropertyReferenceType }
     */
    public PropertyReferenceType getOrderBy() {
        return orderBy;
    }

    /**
     * Sets the value of the orderBy property.
     *
     * @param value allowed object is
     *              {@link PropertyReferenceType }
     */
    public void setOrderBy(PropertyReferenceType value) {
        this.orderBy = value;
    }

    /**
     * Gets the value of the orderDirection property.
     *
     * @return possible object is
     *         {@link OrderDirectionType }
     */
    public OrderDirectionType getOrderDirection() {
        return orderDirection;
    }

    /**
     * Sets the value of the orderDirection property.
     *
     * @param value allowed object is
     *              {@link OrderDirectionType }
     */
    public void setOrderDirection(OrderDirectionType value) {
        this.orderDirection = value;
    }

    /**
     * Gets the value of the offset property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * Sets the value of the offset property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setOffset(Integer value) {
        this.offset = value;
    }

    /**
     * Gets the value of the maxSize property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getMaxSize() {
        return maxSize;
    }

    /**
     * Sets the value of the maxSize property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMaxSize(Integer value) {
        this.maxSize = value;
    }

}
