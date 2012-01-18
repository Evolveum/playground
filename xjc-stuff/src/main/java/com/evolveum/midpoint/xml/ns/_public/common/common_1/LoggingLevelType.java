package com.evolveum.midpoint.xml.ns._public.common.common_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoggingLevelType.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="LoggingLevelType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALL"/>
 *     &lt;enumeration value="OFF"/>
 *     &lt;enumeration value="ERROR"/>
 *     &lt;enumeration value="WARN"/>
 *     &lt;enumeration value="INFO"/>
 *     &lt;enumeration value="DEBUG"/>
 *     &lt;enumeration value="TRACE"/>
 *     &lt;enumeration value="ALL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "LoggingLevelType")
@XmlEnum
public enum LoggingLevelType {

    ALL,
    OFF,
    ERROR,
    WARN,
    INFO,
    DEBUG,
    TRACE;

    public String value() {
        return name();
    }

    public static LoggingLevelType fromValue(String v) {
        return valueOf(v);
    }

}
