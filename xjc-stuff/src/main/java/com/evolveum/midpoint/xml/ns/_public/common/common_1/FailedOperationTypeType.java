package com.evolveum.midpoint.xml.ns._public.common.common_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FailedOperationTypeType.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="FailedOperationTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="delete"/>
 *     &lt;enumeration value="add"/>
 *     &lt;enumeration value="modify"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "FailedOperationTypeType")
@XmlEnum
public enum FailedOperationTypeType {

    @XmlEnumValue("delete")
    DELETE("delete"),
    @XmlEnumValue("add")
    ADD("add"),
    @XmlEnumValue("modify")
    MODIFY("modify");
    private final String value;

    FailedOperationTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FailedOperationTypeType fromValue(String v) {
        for (FailedOperationTypeType c : FailedOperationTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
