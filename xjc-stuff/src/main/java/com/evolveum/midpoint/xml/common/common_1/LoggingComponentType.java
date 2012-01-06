
package com.evolveum.midpoint.xml.common.common_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoggingComponentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LoggingComponentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALL"/>
 *     &lt;enumeration value="MODEL"/>
 *     &lt;enumeration value="PROVISIONING"/>
 *     &lt;enumeration value="REPOSITORY"/>
 *     &lt;enumeration value="WEB"/>
 *     &lt;enumeration value="TASKMANAGER"/>
 *     &lt;enumeration value="RESOURCEOBJECTCHANGELISTENER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LoggingComponentType")
@XmlEnum
public enum LoggingComponentType {

    ALL("ALL"),
    MODEL("MODEL"),
    PROVISIONING("PROVISIONING"),
    REPOSITORY("REPOSITORY"),
    @XmlEnumValue("WEB")
    GUI("WEB"),
    TASKMANAGER("TASKMANAGER"),
    RESOURCEOBJECTCHANGELISTENER("RESOURCEOBJECTCHANGELISTENER");
    private final String value;

    LoggingComponentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LoggingComponentType fromValue(String v) {
        for (LoggingComponentType c: LoggingComponentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
