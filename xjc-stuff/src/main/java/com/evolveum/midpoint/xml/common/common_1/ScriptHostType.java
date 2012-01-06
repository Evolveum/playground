
package com.evolveum.midpoint.xml.common.common_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ScriptHostType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ScriptHostType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="connector"/>
 *     &lt;enumeration value="resource"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ScriptHostType")
@XmlEnum
public enum ScriptHostType {

    @XmlEnumValue("connector")
    CONNECTOR("connector"),
    @XmlEnumValue("resource")
    RESOURCE("resource");
    private final String value;

    ScriptHostType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ScriptHostType fromValue(String v) {
        for (ScriptHostType c: ScriptHostType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
