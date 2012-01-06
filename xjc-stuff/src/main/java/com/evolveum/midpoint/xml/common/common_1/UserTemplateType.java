
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
 *                 The user template used to create new users.
 *                 It
 *                 contains fixed values or expressions that can set-up
 *                 a new
 *                 user
 *                 obejct. It is used only during user creation in the
 *                 synchronization
 *                 code, but will be most likely used also
 *                 on other
 *                 places
 *                 later.
 * 
 *                 The goal
 *                 is to make this a kind of "policy" how the use object
 *                 should look
 *                 like and check it on
 *                 every user modification.
 *             
 * 
 * <p>Java class for UserTemplateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserTemplateType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExtensibleObjectType">
 *       &lt;sequence>
 *         &lt;element name="propertyConstruction" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}PropertyConstructionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="accountConstruction" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}AccountConstructionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserTemplateType", propOrder = {
    "propertyConstruction",
    "accountConstruction"
})
public class UserTemplateType
    extends ExtensibleObjectType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected List<PropertyConstructionType> propertyConstruction;
    protected List<AccountConstructionType> accountConstruction;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "UserTemplateType");

    /**
     * Gets the value of the propertyConstruction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propertyConstruction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropertyConstruction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyConstructionType }
     * 
     * 
     */
    public List<PropertyConstructionType> getPropertyConstruction() {
        if (propertyConstruction == null) {
            propertyConstruction = new ArrayList<PropertyConstructionType>();
        }
        return this.propertyConstruction;
    }

    /**
     * Gets the value of the accountConstruction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountConstruction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountConstruction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountConstructionType }
     * 
     * 
     */
    public List<AccountConstructionType> getAccountConstruction() {
        if (accountConstruction == null) {
            accountConstruction = new ArrayList<AccountConstructionType>();
        }
        return this.accountConstruction;
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
            List<PropertyConstructionType> thePropertyConstruction;
            thePropertyConstruction = (((this.propertyConstruction!= null)&&(!this.propertyConstruction.isEmpty()))?this.getPropertyConstruction():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "propertyConstruction", thePropertyConstruction), currentHashCode, thePropertyConstruction);
        }
        {
            List<AccountConstructionType> theAccountConstruction;
            theAccountConstruction = (((this.accountConstruction!= null)&&(!this.accountConstruction.isEmpty()))?this.getAccountConstruction():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accountConstruction", theAccountConstruction), currentHashCode, theAccountConstruction);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof UserTemplateType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final UserTemplateType that = ((UserTemplateType) object);
        {
            List<PropertyConstructionType> lhsPropertyConstruction;
            lhsPropertyConstruction = (((this.propertyConstruction!= null)&&(!this.propertyConstruction.isEmpty()))?this.getPropertyConstruction():null);
            List<PropertyConstructionType> rhsPropertyConstruction;
            rhsPropertyConstruction = (((that.propertyConstruction!= null)&&(!that.propertyConstruction.isEmpty()))?that.getPropertyConstruction():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "propertyConstruction", lhsPropertyConstruction), LocatorUtils.property(thatLocator, "propertyConstruction", rhsPropertyConstruction), lhsPropertyConstruction, rhsPropertyConstruction)) {
                return false;
            }
        }
        {
            List<AccountConstructionType> lhsAccountConstruction;
            lhsAccountConstruction = (((this.accountConstruction!= null)&&(!this.accountConstruction.isEmpty()))?this.getAccountConstruction():null);
            List<AccountConstructionType> rhsAccountConstruction;
            rhsAccountConstruction = (((that.accountConstruction!= null)&&(!that.accountConstruction.isEmpty()))?that.getAccountConstruction():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "accountConstruction", lhsAccountConstruction), LocatorUtils.property(thatLocator, "accountConstruction", rhsAccountConstruction), lhsAccountConstruction, rhsAccountConstruction)) {
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
