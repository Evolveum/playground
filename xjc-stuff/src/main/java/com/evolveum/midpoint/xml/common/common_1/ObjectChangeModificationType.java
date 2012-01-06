
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
 *                 Describes object modification (operation
 *                 "modify").
 *             
 * 
 * <p>Java class for ObjectChangeModificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObjectChangeModificationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectChangeType">
 *       &lt;sequence>
 *         &lt;element name="objectModification" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectModificationType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObjectChangeModificationType", propOrder = {
    "objectModification"
})
public class ObjectChangeModificationType
    extends ObjectChangeType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected ObjectModificationType objectModification;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ObjectChangeModificationType");

    /**
     * Gets the value of the objectModification property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectModificationType }
     *     
     */
    public ObjectModificationType getObjectModification() {
        return objectModification;
    }

    /**
     * Sets the value of the objectModification property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectModificationType }
     *     
     */
    public void setObjectModification(ObjectModificationType value) {
        this.objectModification = value;
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
        int currentHashCode = super.hashCode(locator, strategy);
        {
            ObjectModificationType theObjectModification;
            theObjectModification = this.getObjectModification();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "objectModification", theObjectModification), currentHashCode, theObjectModification);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ObjectChangeModificationType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final ObjectChangeModificationType that = ((ObjectChangeModificationType) object);
        {
            ObjectModificationType lhsObjectModification;
            lhsObjectModification = this.getObjectModification();
            ObjectModificationType rhsObjectModification;
            rhsObjectModification = that.getObjectModification();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "objectModification", lhsObjectModification), LocatorUtils.property(thatLocator, "objectModification", rhsObjectModification), lhsObjectModification, rhsObjectModification)) {
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
