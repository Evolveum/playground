
package com.evolveum.midpoint.xml.common.common_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaskExclusivityStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaskExclusivityStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="claimed"/>
 *     &lt;enumeration value="released"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaskExclusivityStatusType")
@XmlEnum
public enum TaskExclusivityStatusType {

    @XmlEnumValue("claimed")
    CLAIMED("claimed"),
    @XmlEnumValue("released")
    RELEASED("released");
    private final String value;

    TaskExclusivityStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TaskExclusivityStatusType fromValue(String v) {
        for (TaskExclusivityStatusType c: TaskExclusivityStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
