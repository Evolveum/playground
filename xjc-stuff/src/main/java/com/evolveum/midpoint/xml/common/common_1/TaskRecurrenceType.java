
package com.evolveum.midpoint.xml.common.common_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaskRecurrenceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaskRecurrenceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="single"/>
 *     &lt;enumeration value="recurring"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaskRecurrenceType")
@XmlEnum
public enum TaskRecurrenceType {

    @XmlEnumValue("single")
    SINGLE("single"),
    @XmlEnumValue("recurring")
    RECURRING("recurring");
    private final String value;

    TaskRecurrenceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TaskRecurrenceType fromValue(String v) {
        for (TaskRecurrenceType c: TaskRecurrenceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
