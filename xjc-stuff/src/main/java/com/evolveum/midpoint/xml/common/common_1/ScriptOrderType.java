
package com.evolveum.midpoint.xml.common.common_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ScriptOrderType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ScriptOrderType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="before"/>
 *     &lt;enumeration value="after"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ScriptOrderType")
@XmlEnum
public enum ScriptOrderType {

    @XmlEnumValue("before")
    BEFORE("before"),
    @XmlEnumValue("after")
    AFTER("after");
    private final String value;

    ScriptOrderType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ScriptOrderType fromValue(String v) {
        for (ScriptOrderType c: ScriptOrderType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
