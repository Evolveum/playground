package com.evolveum.midpoint.xml.ns._public.common.common_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ModelOperationStageType.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="ModelOperationStageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="primary"/>
 *     &lt;enumeration value="secondary"/>
 *     &lt;enumeration value="execute"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "ModelOperationStageType")
@XmlEnum
public enum ModelOperationStageType {

    @XmlEnumValue("primary")
    PRIMARY("primary"),
    @XmlEnumValue("secondary")
    SECONDARY("secondary"),
    @XmlEnumValue("execute")
    EXECUTE("execute");
    private final String value;

    ModelOperationStageType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ModelOperationStageType fromValue(String v) {
        for (ModelOperationStageType c : ModelOperationStageType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
