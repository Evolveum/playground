package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for PasswordPolicyType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PasswordPolicyType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectType">
 *       &lt;sequence>
 *         &lt;element name="lifetime" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}PasswordLifeTimeType"/>
 *         &lt;element name="stringPolicy" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}StringPolicyType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PasswordPolicyType", propOrder = {
        "lifetime",
        "stringPolicy"
})
public class PasswordPolicyType
        extends ObjectType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "PasswordPolicyType");
    public final static QName F_LIFETIME = new QName(SchemaConstants.NS_COMMON, "lifetime");
    public final static QName F_STRING_POLICY = new QName(SchemaConstants.NS_COMMON, "stringPolicy");

    @XmlElement(required = true)
    public PasswordLifeTimeType getLifetime() {
        return getPropertyValue(F_LIFETIME, PasswordLifeTimeType.class);
    }

    public void setLifetime(PasswordLifeTimeType value) {
        setPropertyValue(F_LIFETIME, value);
    }

    @XmlElement(required = true)
    public StringPolicyType getStringPolicy() {
        return getPropertyValue(F_STRING_POLICY, StringPolicyType.class);
    }

    public void setStringPolicy(StringPolicyType value) {
        setPropertyValue(F_STRING_POLICY, value);
    }

}
