package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * TODO
 * <p/>
 * <p/>
 * <p>Java class for AccountSynchronizationSettingsType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
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
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountSynchronizationSettingsType", propOrder = {
        "assignmentPolicyEnforcement"
})
public class AccountSynchronizationSettingsType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected AssignmentPolicyEnforcementType assignmentPolicyEnforcement;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "AccountSynchronizationSettingsType");
    public final static QName F_ASSIGNMENT_POLICY_ENFORCEMENT = new QName(SchemaConstants.NS_COMMON, "assignmentPolicyEnforcement");

    /**
     * Gets the value of the assignmentPolicyEnforcement property.
     *
     * @return possible object is
     *         {@link AssignmentPolicyEnforcementType }
     */
    public AssignmentPolicyEnforcementType getAssignmentPolicyEnforcement() {
        return assignmentPolicyEnforcement;
    }

    /**
     * Sets the value of the assignmentPolicyEnforcement property.
     *
     * @param value allowed object is
     *              {@link AssignmentPolicyEnforcementType }
     */
    public void setAssignmentPolicyEnforcement(AssignmentPolicyEnforcementType value) {
        this.assignmentPolicyEnforcement = value;
    }

}
