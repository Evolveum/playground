
package com.evolveum.midpoint.xml.common.common_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SynchronizationSituationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SynchronizationSituationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="deleted"/>
 *     &lt;enumeration value="unmatched"/>
 *     &lt;enumeration value="disputed"/>
 *     &lt;enumeration value="linked"/>
 *     &lt;enumeration value="unlinked"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SynchronizationSituationType")
@XmlEnum
public enum SynchronizationSituationType {

    @XmlEnumValue("deleted")
    DELETED("deleted"),
    @XmlEnumValue("unmatched")
    UNMATCHED("unmatched"),
    @XmlEnumValue("disputed")
    DISPUTED("disputed"),
    @XmlEnumValue("linked")
    LINKED("linked"),
    @XmlEnumValue("unlinked")
    UNLINKED("unlinked");
    private final String value;

    SynchronizationSituationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SynchronizationSituationType fromValue(String v) {
        for (SynchronizationSituationType c: SynchronizationSituationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
