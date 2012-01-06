
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
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
 * <p>Java class for ResourceActivationDefinitionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourceActivationDefinitionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enabled" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ResourceActivationEnableDefinitionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceActivationDefinitionType", propOrder = {
    "enabled"
})
public class ResourceActivationDefinitionType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected ResourceActivationEnableDefinitionType enabled;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ResourceActivationDefinitionType");

    /**
     * Gets the value of the enabled property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceActivationEnableDefinitionType }
     *     
     */
    public ResourceActivationEnableDefinitionType getEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceActivationEnableDefinitionType }
     *     
     */
    public void setEnabled(ResourceActivationEnableDefinitionType value) {
        this.enabled = value;
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
            ResourceActivationEnableDefinitionType theEnabled;
            theEnabled = this.getEnabled();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "enabled", theEnabled), currentHashCode, theEnabled);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ResourceActivationDefinitionType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ResourceActivationDefinitionType that = ((ResourceActivationDefinitionType) object);
        {
            ResourceActivationEnableDefinitionType lhsEnabled;
            lhsEnabled = this.getEnabled();
            ResourceActivationEnableDefinitionType rhsEnabled;
            rhsEnabled = that.getEnabled();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "enabled", lhsEnabled), LocatorUtils.property(thatLocator, "enabled", rhsEnabled), lhsEnabled, rhsEnabled)) {
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
