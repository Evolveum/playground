
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
 *                 Generic assignments of one object to another object.
 *                 This will usually be assignment of a role to a user, assignment of an
 *                 organizational unit, team or whatever. It may also be used to assing
 *                 role to another role, creating a role hierarchy.
 * 
 *                 Assignment is an abstract concept. It can be anything that
 *                 gives the "receptor" object additional access rights, privileges,
 *                 capabilities or similar ability or right. But it may also constraint
 *                 the object with policy, e.g. to impelemt separation of duties. Roles,
 *                 organizations and privileges in IDM system are examples of assignments.
 * 
 *                 The assignemtn may target either existing IDM object (such as a role)
 *                 or abstract resource account that may or may not exist. In case of resource
 *                 objects it is constrained to accounts, as accoutns are the only resource objects
 *                 that can be assigned to a user. Other resource objects (entitlements) can
 *                 be assigned to accounts, but not to users.
 * 
 *                 TODO: constraints
 * 
 *             
 * 
 * <p>Java class for AssignmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssignmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="target" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectType"/>
 *           &lt;element name="targetRef" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectReferenceType"/>
 *           &lt;element name="accountConstruction" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}AccountConstructionType"/>
 *         &lt;/choice>
 *         &lt;element name="activation" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ActivationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssignmentType", propOrder = {
    "target",
    "targetRef",
    "accountConstruction",
    "activation"
})
public class AssignmentType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected ObjectType target;
    protected ObjectReferenceType targetRef;
    protected AccountConstructionType accountConstruction;
    protected ActivationType activation;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "AssignmentType");

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectType }
     *     
     */
    public ObjectType getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectType }
     *     
     */
    public void setTarget(ObjectType value) {
        this.target = value;
    }

    /**
     * Gets the value of the targetRef property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectReferenceType }
     *     
     */
    public ObjectReferenceType getTargetRef() {
        return targetRef;
    }

    /**
     * Sets the value of the targetRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectReferenceType }
     *     
     */
    public void setTargetRef(ObjectReferenceType value) {
        this.targetRef = value;
    }

    /**
     * Gets the value of the accountConstruction property.
     * 
     * @return
     *     possible object is
     *     {@link AccountConstructionType }
     *     
     */
    public AccountConstructionType getAccountConstruction() {
        return accountConstruction;
    }

    /**
     * Sets the value of the accountConstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountConstructionType }
     *     
     */
    public void setAccountConstruction(AccountConstructionType value) {
        this.accountConstruction = value;
    }

    /**
     * Gets the value of the activation property.
     * 
     * @return
     *     possible object is
     *     {@link ActivationType }
     *     
     */
    public ActivationType getActivation() {
        return activation;
    }

    /**
     * Sets the value of the activation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivationType }
     *     
     */
    public void setActivation(ActivationType value) {
        this.activation = value;
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
            ObjectType theTarget;
            theTarget = this.getTarget();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "target", theTarget), currentHashCode, theTarget);
        }
        {
            ObjectReferenceType theTargetRef;
            theTargetRef = this.getTargetRef();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "targetRef", theTargetRef), currentHashCode, theTargetRef);
        }
        {
            AccountConstructionType theAccountConstruction;
            theAccountConstruction = this.getAccountConstruction();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accountConstruction", theAccountConstruction), currentHashCode, theAccountConstruction);
        }
        {
            ActivationType theActivation;
            theActivation = this.getActivation();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "activation", theActivation), currentHashCode, theActivation);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AssignmentType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AssignmentType that = ((AssignmentType) object);
        {
            ObjectType lhsTarget;
            lhsTarget = this.getTarget();
            ObjectType rhsTarget;
            rhsTarget = that.getTarget();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "target", lhsTarget), LocatorUtils.property(thatLocator, "target", rhsTarget), lhsTarget, rhsTarget)) {
                return false;
            }
        }
        {
            ObjectReferenceType lhsTargetRef;
            lhsTargetRef = this.getTargetRef();
            ObjectReferenceType rhsTargetRef;
            rhsTargetRef = that.getTargetRef();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "targetRef", lhsTargetRef), LocatorUtils.property(thatLocator, "targetRef", rhsTargetRef), lhsTargetRef, rhsTargetRef)) {
                return false;
            }
        }
        {
            AccountConstructionType lhsAccountConstruction;
            lhsAccountConstruction = this.getAccountConstruction();
            AccountConstructionType rhsAccountConstruction;
            rhsAccountConstruction = that.getAccountConstruction();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "accountConstruction", lhsAccountConstruction), LocatorUtils.property(thatLocator, "accountConstruction", rhsAccountConstruction), lhsAccountConstruction, rhsAccountConstruction)) {
                return false;
            }
        }
        {
            ActivationType lhsActivation;
            lhsActivation = this.getActivation();
            ActivationType rhsActivation;
            rhsActivation = that.getActivation();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "activation", lhsActivation), LocatorUtils.property(thatLocator, "activation", rhsActivation), lhsActivation, rhsActivation)) {
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
