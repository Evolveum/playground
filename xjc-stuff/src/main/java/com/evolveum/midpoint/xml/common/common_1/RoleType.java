
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
 *                 A role that implies assignments.
 *                 The role may "grant" accounts on resources, attributes and
 *                 entitlements for such accounts. The role can also assign
 *                 organizational units, other roles or various IDM objects
 *                 that can be assigned directly to user. Role is in fact just
 *                 a named set of assignments.
 * 
 *                 The speicific roles are also called technical role or IT role,
 *                 however this definition is an abstract definition of concept
 *                 that can span wide area of intepretation.
 * 
 *                 This is the basic building blog of role-based access
 *                 contol (RBAC) in the provisioning system. It defines what
 *                 rights (e.g. accounts) should be given to user, how they
 *                 should look like (attributes) and what groups or native
 *                 roles to assign to them (entitlements).
 * 
 *                 This role definition is quite simplistic now. It does not
 *                 support rule-derived values or any other advanced dynamics.
 *                 Yet. It will be extended later in the development.
 *             
 * 
 * <p>Java class for RoleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoleType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExtensibleObjectType">
 *       &lt;sequence>
 *         &lt;element name="assignment" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}AssignmentType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoleType", propOrder = {
    "assignment"
})
public class RoleType
    extends ExtensibleObjectType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected List<AssignmentType> assignment;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "RoleType");

    /**
     * Gets the value of the assignment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assignment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssignment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssignmentType }
     * 
     * 
     */
    public List<AssignmentType> getAssignment() {
        if (assignment == null) {
            assignment = new ArrayList<AssignmentType>();
        }
        return this.assignment;
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
            List<AssignmentType> theAssignment;
            theAssignment = (((this.assignment!= null)&&(!this.assignment.isEmpty()))?this.getAssignment():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "assignment", theAssignment), currentHashCode, theAssignment);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof RoleType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final RoleType that = ((RoleType) object);
        {
            List<AssignmentType> lhsAssignment;
            lhsAssignment = (((this.assignment!= null)&&(!this.assignment.isEmpty()))?this.getAssignment():null);
            List<AssignmentType> rhsAssignment;
            rhsAssignment = (((that.assignment!= null)&&(!that.assignment.isEmpty()))?that.getAssignment():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "assignment", lhsAssignment), LocatorUtils.property(thatLocator, "assignment", rhsAssignment), lhsAssignment, rhsAssignment)) {
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
