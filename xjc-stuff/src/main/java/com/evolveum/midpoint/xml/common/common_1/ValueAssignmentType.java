
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
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
import org.w3c.dom.Element;


/**
 * 
 *                 Defines an assignment of value from one place (or
 *                 expression) to
 *                 another place.
 *                 This is supposed to
 *                 be a
 *                 general-purpose
 *                 construct.
 *                 TODO: merging options
 * 
 *                 This type is marked with jaxb:dom
 *                 annotation, which will avoid
 *                 JAXB parsing of
 *                 it. This is a workaround
 *                 to a JAXB limitation,
 *                 which cannot handle more than one "any"
 *                 elements in a
 *                 type.
 *                 See
 *                 http://java.net/jira/browse/JAXB-798
 *             
 * 
 * <p>Java class for ValueAssignmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValueAssignmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}description" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}valueFilter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="source" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExpressionType" minOccurs="0"/>
 *         &lt;element name="target" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}XPathType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValueAssignmentType", propOrder = {
    "description",
    "valueFilter",
    "source",
    "target"
})
public class ValueAssignmentType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected String description;
    protected List<ValueFilterType> valueFilter;
    protected ExpressionType source;
    @XmlAnyElement
    protected Element target;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ValueAssignmentType");

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * 
     *                         List of filters that will be applied to the
     *                         value before
     *                         it even gets processed by this
     *                         assignment. The
     *                         filters
     *                         will
     *                         get applied even before the expression.
     * 
     *                         The filters will be
     *                         executed in chain in the
     *                         order as
     *                         specified here.
     * 
     *                         The
     *                         filters are
     *                         supposed to "clean up" or transcode
     *                         the value to comply with usual
     *                         XML
     *                         standards.
     *                         (but see the note in
     *                         ValueFilterType documentation)
     *                     Gets the value of the valueFilter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valueFilter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValueFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValueFilterType }
     * 
     * 
     */
    public List<ValueFilterType> getValueFilter() {
        if (valueFilter == null) {
            valueFilter = new ArrayList<ValueFilterType>();
        }
        return this.valueFilter;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionType }
     *     
     */
    public ExpressionType getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionType }
     *     
     */
    public void setSource(ExpressionType value) {
        this.source = value;
    }

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link Element }
     *     
     */
    public Element getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link Element }
     *     
     */
    public void setTarget(Element value) {
        this.target = value;
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
            String theDescription;
            theDescription = this.getDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "description", theDescription), currentHashCode, theDescription);
        }
        {
            List<ValueFilterType> theValueFilter;
            theValueFilter = (((this.valueFilter!= null)&&(!this.valueFilter.isEmpty()))?this.getValueFilter():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "valueFilter", theValueFilter), currentHashCode, theValueFilter);
        }
        {
            ExpressionType theSource;
            theSource = this.getSource();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "source", theSource), currentHashCode, theSource);
        }
        {
            Element theTarget;
            theTarget = this.getTarget();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "target", theTarget), currentHashCode, theTarget);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ValueAssignmentType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ValueAssignmentType that = ((ValueAssignmentType) object);
        {
            String lhsDescription;
            lhsDescription = this.getDescription();
            String rhsDescription;
            rhsDescription = that.getDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "description", lhsDescription), LocatorUtils.property(thatLocator, "description", rhsDescription), lhsDescription, rhsDescription)) {
                return false;
            }
        }
        {
            List<ValueFilterType> lhsValueFilter;
            lhsValueFilter = (((this.valueFilter!= null)&&(!this.valueFilter.isEmpty()))?this.getValueFilter():null);
            List<ValueFilterType> rhsValueFilter;
            rhsValueFilter = (((that.valueFilter!= null)&&(!that.valueFilter.isEmpty()))?that.getValueFilter():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "valueFilter", lhsValueFilter), LocatorUtils.property(thatLocator, "valueFilter", rhsValueFilter), lhsValueFilter, rhsValueFilter)) {
                return false;
            }
        }
        {
            ExpressionType lhsSource;
            lhsSource = this.getSource();
            ExpressionType rhsSource;
            rhsSource = that.getSource();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "source", lhsSource), LocatorUtils.property(thatLocator, "source", rhsSource), lhsSource, rhsSource)) {
                return false;
            }
        }
        {
            Element lhsTarget;
            lhsTarget = this.getTarget();
            Element rhsTarget;
            rhsTarget = that.getTarget();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "target", lhsTarget), LocatorUtils.property(thatLocator, "target", rhsTarget), lhsTarget, rhsTarget)) {
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
