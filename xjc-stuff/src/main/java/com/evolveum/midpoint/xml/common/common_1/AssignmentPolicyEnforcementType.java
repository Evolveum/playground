
package com.evolveum.midpoint.xml.common.common_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AssignmentPolicyEnforcementType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AssignmentPolicyEnforcementType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="mark"/>
 *     &lt;enumeration value="full"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AssignmentPolicyEnforcementType")
@XmlEnum
public enum AssignmentPolicyEnforcementType {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("mark")
    MARK("mark"),
    @XmlEnumValue("full")
    FULL("full");
    private final String value;

    AssignmentPolicyEnforcementType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AssignmentPolicyEnforcementType fromValue(String v) {
        for (AssignmentPolicyEnforcementType c: AssignmentPolicyEnforcementType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
