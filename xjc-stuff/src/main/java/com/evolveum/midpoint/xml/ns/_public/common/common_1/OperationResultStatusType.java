package com.evolveum.midpoint.xml.ns._public.common.common_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OperationResultStatusType.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="OperationResultStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="success"/>
 *     &lt;enumeration value="warning"/>
 *     &lt;enumeration value="partial_error"/>
 *     &lt;enumeration value="fatal_error"/>
 *     &lt;enumeration value="not_applicable"/>
 *     &lt;enumeration value="in_progress"/>
 *     &lt;enumeration value="unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "OperationResultStatusType")
@XmlEnum
public enum OperationResultStatusType {

    @XmlEnumValue("success")
    SUCCESS("success"),
    @XmlEnumValue("warning")
    WARNING("warning"),
    @XmlEnumValue("partial_error")
    PARTIAL_ERROR("partial_error"),
    @XmlEnumValue("fatal_error")
    FATAL_ERROR("fatal_error"),
    @XmlEnumValue("not_applicable")
    NOT_APPLICABLE("not_applicable"),
    @XmlEnumValue("in_progress")
    IN_PROGRESS("in_progress"),
    @XmlEnumValue("unknown")
    UNKNOWN("unknown");
    private final String value;

    OperationResultStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OperationResultStatusType fromValue(String v) {
        for (OperationResultStatusType c : OperationResultStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
