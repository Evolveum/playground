package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import com.evolveum.midpoint.schema.processorFake.PropertyContainer;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.math.BigInteger;


/**
 * <p>Java class for PasswordType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PasswordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="protectedString" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ProtectedStringType"/>
 *         &lt;element name="failedLogins" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="lastFailedLoginTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PasswordType", propOrder = {
        "protectedString",
        "failedLogins",
        "lastFailedLoginTimestamp"
})
public class PasswordType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "PasswordType");
    public final static QName F_PROTECTED_STRING = new QName(SchemaConstants.NS_COMMON, "protectedString");
    public final static QName F_FAILED_LOGINS = new QName(SchemaConstants.NS_COMMON, "failedLogins");
    public final static QName F_LAST_FAILED_LOGIN_TIMESTAMP = new QName(SchemaConstants.NS_COMMON, "lastFailedLoginTimestamp");
    @XmlTransient
    private PropertyContainer container;

    /**
     * DO NOT USE! For testing purposes only.
     */
    @Deprecated
    public PropertyContainer getContainer() {
        if (container == null) {
            container = new PropertyContainer(COMPLEX_TYPE);
        }
        return container;
    }

    /**
     * DO NOT USE! For testing purposes only.
     */
    @Deprecated
    public void setContainer(PropertyContainer container) {
        if (container == null) {
            container = null;
            return;
        }
        if (!COMPLEX_TYPE.equals(container.getName())) {
            throw new IllegalArgumentException((((("Container qname '" + container.getName()) + "' doesn't equals to '") + COMPLEX_TYPE) + "'."));
        }
        this.container = container;
    }

    @XmlElement(required = true)
    public ProtectedStringType getProtectedString() {
        return getPropertyValue(F_PROTECTED_STRING, ProtectedStringType.class);
    }

    public void setProtectedString(ProtectedStringType value) {
        setPropertyValue(F_PROTECTED_STRING, value);
    }

    public BigInteger getFailedLogins() {
        return getPropertyValue(F_FAILED_LOGINS, BigInteger.class);
    }

    public void setFailedLogins(BigInteger value) {
        setPropertyValue(F_FAILED_LOGINS, value);
    }

    @XmlSchemaType(name = "dateTime")
    public XMLGregorianCalendar getLastFailedLoginTimestamp() {
        return getPropertyValue(F_LAST_FAILED_LOGIN_TIMESTAMP, XMLGregorianCalendar.class);
    }

    public void setLastFailedLoginTimestamp(XMLGregorianCalendar value) {
        setPropertyValue(F_LAST_FAILED_LOGIN_TIMESTAMP, value);
    }

}
