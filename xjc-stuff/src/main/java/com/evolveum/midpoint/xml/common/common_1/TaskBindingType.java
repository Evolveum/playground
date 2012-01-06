
package com.evolveum.midpoint.xml.common.common_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaskBindingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaskBindingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="loose"/>
 *     &lt;enumeration value="tight"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaskBindingType")
@XmlEnum
public enum TaskBindingType {

    @XmlEnumValue("loose")
    LOOSE("loose"),
    @XmlEnumValue("tight")
    TIGHT("tight");
    private final String value;

    TaskBindingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TaskBindingType fromValue(String v) {
        for (TaskBindingType c: TaskBindingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
