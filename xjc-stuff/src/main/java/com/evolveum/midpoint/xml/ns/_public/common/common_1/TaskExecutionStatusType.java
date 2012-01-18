package com.evolveum.midpoint.xml.ns._public.common.common_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaskExecutionStatusType.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="TaskExecutionStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="running"/>
 *     &lt;enumeration value="waiting"/>
 *     &lt;enumeration value="suspended"/>
 *     &lt;enumeration value="closed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "TaskExecutionStatusType")
@XmlEnum
public enum TaskExecutionStatusType {

    @XmlEnumValue("running")
    RUNNING("running"),
    @XmlEnumValue("waiting")
    WAITING("waiting"),
    @XmlEnumValue("suspended")
    SUSPENDED("suspended"),
    @XmlEnumValue("closed")
    CLOSED("closed");
    private final String value;

    TaskExecutionStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TaskExecutionStatusType fromValue(String v) {
        for (TaskExecutionStatusType c : TaskExecutionStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
