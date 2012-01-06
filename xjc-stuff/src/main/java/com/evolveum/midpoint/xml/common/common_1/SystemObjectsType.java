
package com.evolveum.midpoint.xml.common.common_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SystemObjectsType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SystemObjectsType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="00000000-0000-0000-0000-000000000001"/>
 *     &lt;enumeration value="00000000-0000-0000-0000-000000000002"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SystemObjectsType")
@XmlEnum
public enum SystemObjectsType {

    @XmlEnumValue("00000000-0000-0000-0000-000000000001")
    SYSTEM_CONFIGURATION("00000000-0000-0000-0000-000000000001"),
    @XmlEnumValue("00000000-0000-0000-0000-000000000002")
    USER_ADMINISTRATOR("00000000-0000-0000-0000-000000000002");
    private final String value;

    SystemObjectsType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SystemObjectsType fromValue(String v) {
        for (SystemObjectsType c: SystemObjectsType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
