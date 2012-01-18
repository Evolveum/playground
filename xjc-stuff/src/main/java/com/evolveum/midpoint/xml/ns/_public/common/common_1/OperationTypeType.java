package com.evolveum.midpoint.xml.ns._public.common.common_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OperationTypeType.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="OperationTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="get"/>
 *     &lt;enumeration value="add"/>
 *     &lt;enumeration value="modify"/>
 *     &lt;enumeration value="delete"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "OperationTypeType")
@XmlEnum
public enum OperationTypeType {

    @XmlEnumValue("get")
    GET("get"),
    @XmlEnumValue("add")
    ADD("add"),
    @XmlEnumValue("modify")
    MODIFY("modify"),
    @XmlEnumValue("delete")
    DELETE("delete");
    private final String value;

    OperationTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OperationTypeType fromValue(String v) {
        for (OperationTypeType c : OperationTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
