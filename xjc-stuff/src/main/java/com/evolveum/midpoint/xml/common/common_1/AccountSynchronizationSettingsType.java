
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
 * 
 *                 TODO
 *             
 * 
 * <p>Java class for AccountSynchronizationSettingsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountSynchronizationSettingsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="assignmentPolicyEnforcement" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}AssignmentPolicyEnforcementType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountSynchronizationSettingsType", propOrder = {
    "assignmentPolicyEnforcement"
})
public class AccountSynchronizationSettingsType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected AssignmentPolicyEnforcementType assignmentPolicyEnforcement;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "AccountSynchronizationSettingsType");

    /**
     * Gets the value of the assignmentPolicyEnforcement property.
     * 
     * @return
     *     possible object is
     *     {@link AssignmentPolicyEnforcementType }
     *     
     */
    public AssignmentPolicyEnforcementType getAssignmentPolicyEnforcement() {
        return assignmentPolicyEnforcement;
    }

    /**
     * Sets the value of the assignmentPolicyEnforcement property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssignmentPolicyEnforcementType }
     *     
     */
    public void setAssignmentPolicyEnforcement(AssignmentPolicyEnforcementType value) {
        this.assignmentPolicyEnforcement = value;
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
            AssignmentPolicyEnforcementType theAssignmentPolicyEnforcement;
            theAssignmentPolicyEnforcement = this.getAssignmentPolicyEnforcement();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "assignmentPolicyEnforcement", theAssignmentPolicyEnforcement), currentHashCode, theAssignmentPolicyEnforcement);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AccountSynchronizationSettingsType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AccountSynchronizationSettingsType that = ((AccountSynchronizationSettingsType) object);
        {
            AssignmentPolicyEnforcementType lhsAssignmentPolicyEnforcement;
            lhsAssignmentPolicyEnforcement = this.getAssignmentPolicyEnforcement();
            AssignmentPolicyEnforcementType rhsAssignmentPolicyEnforcement;
            rhsAssignmentPolicyEnforcement = that.getAssignmentPolicyEnforcement();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "assignmentPolicyEnforcement", lhsAssignmentPolicyEnforcement), LocatorUtils.property(thatLocator, "assignmentPolicyEnforcement", rhsAssignmentPolicyEnforcement), lhsAssignmentPolicyEnforcement, rhsAssignmentPolicyEnforcement)) {
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
