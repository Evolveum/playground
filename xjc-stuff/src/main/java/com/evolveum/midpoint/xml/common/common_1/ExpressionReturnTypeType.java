
package com.evolveum.midpoint.xml.common.common_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExpressionReturnTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExpressionReturnTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="scalar"/>
 *     &lt;enumeration value="list"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExpressionReturnTypeType")
@XmlEnum
public enum ExpressionReturnTypeType {

    @XmlEnumValue("scalar")
    SCALAR("scalar"),
    @XmlEnumValue("list")
    LIST("list");
    private final String value;

    ExpressionReturnTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExpressionReturnTypeType fromValue(String v) {
        for (ExpressionReturnTypeType c: ExpressionReturnTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
