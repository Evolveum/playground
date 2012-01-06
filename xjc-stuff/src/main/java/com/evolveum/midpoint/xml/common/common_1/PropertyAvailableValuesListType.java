
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *                 TODO
 *             
 * 
 * <p>Java class for PropertyAvailableValuesListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyAvailableValuesListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="availableValues" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}PropertyAvailableValuesType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyAvailableValuesListType", propOrder = {
    "availableValues"
})
public class PropertyAvailableValuesListType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected List<PropertyAvailableValuesType> availableValues;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "PropertyAvailableValuesListType");

    /**
     * Gets the value of the availableValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the availableValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvailableValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyAvailableValuesType }
     * 
     * 
     */
    public List<PropertyAvailableValuesType> getAvailableValues() {
        if (availableValues == null) {
            availableValues = new ArrayList<PropertyAvailableValuesType>();
        }
        return this.availableValues;
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
            List<PropertyAvailableValuesType> theAvailableValues;
            theAvailableValues = (((this.availableValues!= null)&&(!this.availableValues.isEmpty()))?this.getAvailableValues():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "availableValues", theAvailableValues), currentHashCode, theAvailableValues);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PropertyAvailableValuesListType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PropertyAvailableValuesListType that = ((PropertyAvailableValuesListType) object);
        {
            List<PropertyAvailableValuesType> lhsAvailableValues;
            lhsAvailableValues = (((this.availableValues!= null)&&(!this.availableValues.isEmpty()))?this.getAvailableValues():null);
            List<PropertyAvailableValuesType> rhsAvailableValues;
            rhsAvailableValues = (((that.availableValues!= null)&&(!that.availableValues.isEmpty()))?that.getAvailableValues():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "availableValues", lhsAvailableValues), LocatorUtils.property(thatLocator, "availableValues", rhsAvailableValues), lhsAvailableValues, rhsAvailableValues)) {
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
