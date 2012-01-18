package com.evolveum.midpoint.xml.ns._public.common.common_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccessType.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="AccessType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="read"/>
 *     &lt;enumeration value="update"/>
 *     &lt;enumeration value="create"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "AccessType")
@XmlEnum
public enum AccessType {

    @XmlEnumValue("read")
    READ("read"),
    @XmlEnumValue("update")
    UPDATE("update"),
    @XmlEnumValue("create")
    CREATE("create");
    private final String value;

    AccessType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AccessType fromValue(String v) {
        for (AccessType c : AccessType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
