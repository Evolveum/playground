
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
 * <p>Java class for PasswordPolicyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PasswordPolicyType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectType">
 *       &lt;sequence>
 *         &lt;element name="lifetime" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}PasswordLifeTimeType"/>
 *         &lt;element name="stringPolicy" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}StringPolicyType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PasswordPolicyType", propOrder = {
    "lifetime",
    "stringPolicy"
})
public class PasswordPolicyType
    extends ObjectType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected PasswordLifeTimeType lifetime;
    @XmlElement(required = true)
    protected StringPolicyType stringPolicy;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "PasswordPolicyType");

    /**
     * Gets the value of the lifetime property.
     * 
     * @return
     *     possible object is
     *     {@link PasswordLifeTimeType }
     *     
     */
    public PasswordLifeTimeType getLifetime() {
        return lifetime;
    }

    /**
     * Sets the value of the lifetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link PasswordLifeTimeType }
     *     
     */
    public void setLifetime(PasswordLifeTimeType value) {
        this.lifetime = value;
    }

    /**
     * Gets the value of the stringPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link StringPolicyType }
     *     
     */
    public StringPolicyType getStringPolicy() {
        return stringPolicy;
    }

    /**
     * Sets the value of the stringPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link StringPolicyType }
     *     
     */
    public void setStringPolicy(StringPolicyType value) {
        this.stringPolicy = value;
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
            PasswordLifeTimeType theLifetime;
            theLifetime = this.getLifetime();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lifetime", theLifetime), currentHashCode, theLifetime);
        }
        {
            StringPolicyType theStringPolicy;
            theStringPolicy = this.getStringPolicy();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "stringPolicy", theStringPolicy), currentHashCode, theStringPolicy);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PasswordPolicyType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final PasswordPolicyType that = ((PasswordPolicyType) object);
        {
            PasswordLifeTimeType lhsLifetime;
            lhsLifetime = this.getLifetime();
            PasswordLifeTimeType rhsLifetime;
            rhsLifetime = that.getLifetime();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lifetime", lhsLifetime), LocatorUtils.property(thatLocator, "lifetime", rhsLifetime), lhsLifetime, rhsLifetime)) {
                return false;
            }
        }
        {
            StringPolicyType lhsStringPolicy;
            lhsStringPolicy = this.getStringPolicy();
            StringPolicyType rhsStringPolicy;
            rhsStringPolicy = that.getStringPolicy();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "stringPolicy", lhsStringPolicy), LocatorUtils.property(thatLocator, "stringPolicy", rhsStringPolicy), lhsStringPolicy, rhsStringPolicy)) {
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
