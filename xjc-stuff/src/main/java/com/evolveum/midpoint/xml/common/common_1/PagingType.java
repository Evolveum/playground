
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import com.evolveum.midpoint.schema.DomAwareEqualsStrategy;
import com.evolveum.midpoint.schema.DomAwareHashCodeStrategy;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * 
 *                 Parameters limiting the number of returned
 *                 entries, offset, etc.
 *                 Used in the web service operations
 *                 such as
 *                 list
 *                 or search
 *             
 * 
 * <p>Java class for PagingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
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
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PagingType", propOrder = {
    "orderBy",
    "orderDirection",
    "offset",
    "maxSize"
})
public class PagingType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected PropertyReferenceType orderBy;
    @XmlElement(defaultValue = "ascending")
    protected OrderDirectionType orderDirection;
    @XmlElement(defaultValue = "0")
    protected Integer offset;
    @XmlElement(defaultValue = "2147483647")
    protected Integer maxSize;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "PagingType");

    /**
     * Gets the value of the orderBy property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyReferenceType }
     *     
     */
    public PropertyReferenceType getOrderBy() {
        return orderBy;
    }

    /**
     * Sets the value of the orderBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyReferenceType }
     *     
     */
    public void setOrderBy(PropertyReferenceType value) {
        this.orderBy = value;
    }

    /**
     * Gets the value of the orderDirection property.
     * 
     * @return
     *     possible object is
     *     {@link OrderDirectionType }
     *     
     */
    public OrderDirectionType getOrderDirection() {
        return orderDirection;
    }

    /**
     * Sets the value of the orderDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderDirectionType }
     *     
     */
    public void setOrderDirection(OrderDirectionType value) {
        this.orderDirection = value;
    }

    /**
     * Gets the value of the offset property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * Sets the value of the offset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOffset(Integer value) {
        this.offset = value;
    }

    /**
     * Gets the value of the maxSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxSize() {
        return maxSize;
    }

    /**
     * Sets the value of the maxSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxSize(Integer value) {
        this.maxSize = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            PropertyReferenceType theOrderBy;
            theOrderBy = this.getOrderBy();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "orderBy", theOrderBy), currentHashCode, theOrderBy);
        }
        {
            OrderDirectionType theOrderDirection;
            theOrderDirection = this.getOrderDirection();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "orderDirection", theOrderDirection), currentHashCode, theOrderDirection);
        }
        {
            Integer theOffset;
            theOffset = this.getOffset();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "offset", theOffset), currentHashCode, theOffset);
        }
        {
            Integer theMaxSize;
            theMaxSize = this.getMaxSize();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "maxSize", theMaxSize), currentHashCode, theMaxSize);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PagingType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PagingType that = ((PagingType) object);
        {
            PropertyReferenceType lhsOrderBy;
            lhsOrderBy = this.getOrderBy();
            PropertyReferenceType rhsOrderBy;
            rhsOrderBy = that.getOrderBy();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "orderBy", lhsOrderBy), LocatorUtils.property(thatLocator, "orderBy", rhsOrderBy), lhsOrderBy, rhsOrderBy)) {
                return false;
            }
        }
        {
            OrderDirectionType lhsOrderDirection;
            lhsOrderDirection = this.getOrderDirection();
            OrderDirectionType rhsOrderDirection;
            rhsOrderDirection = that.getOrderDirection();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "orderDirection", lhsOrderDirection), LocatorUtils.property(thatLocator, "orderDirection", rhsOrderDirection), lhsOrderDirection, rhsOrderDirection)) {
                return false;
            }
        }
        {
            Integer lhsOffset;
            lhsOffset = this.getOffset();
            Integer rhsOffset;
            rhsOffset = that.getOffset();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "offset", lhsOffset), LocatorUtils.property(thatLocator, "offset", rhsOffset), lhsOffset, rhsOffset)) {
                return false;
            }
        }
        {
            Integer lhsMaxSize;
            lhsMaxSize = this.getMaxSize();
            Integer rhsMaxSize;
            rhsMaxSize = that.getMaxSize();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "maxSize", lhsMaxSize), LocatorUtils.property(thatLocator, "maxSize", rhsMaxSize), lhsMaxSize, rhsMaxSize)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = new DomAwareEqualsStrategy();
        return equals(null, null, object, strategy);
    }

}
