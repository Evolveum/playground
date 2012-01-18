package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.List;


/**
 * A role that implies assignments.
 * The role may "grant" accounts on resources, attributes and
 * entitlements for such accounts. The role can also assign
 * organizational units, other roles or various IDM objects
 * that can be assigned directly to user. Role is in fact just
 * a named set of assignments.
 * <p/>
 * The speicific roles are also called technical role or IT role,
 * however this definition is an abstract definition of concept
 * that can span wide area of intepretation.
 * <p/>
 * This is the basic building blog of role-based access
 * contol (RBAC) in the provisioning system. It defines what
 * rights (e.g. accounts) should be given to user, how they
 * should look like (attributes) and what groups or native
 * roles to assign to them (entitlements).
 * <p/>
 * This role definition is quite simplistic now. It does not
 * support rule-derived values or any other advanced dynamics.
 * Yet. It will be extended later in the development.
 * <p/>
 * <p/>
 * <p>Java class for RoleType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
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
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoleType", propOrder = {
        "assignment"
})
public class RoleType
        extends ExtensibleObjectType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "RoleType");
    public final static QName F_ASSIGNMENT = new QName(SchemaConstants.NS_COMMON, "assignment");

    public List<AssignmentType> getAssignment() {
        return getPropertyValues(F_ASSIGNMENT, AssignmentType.class);
    }

}
