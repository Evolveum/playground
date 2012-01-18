package com.evolveum.midpoint.xml.ns._public.common.common;

import com.evolveum.midpoint.schema.SchemaConstants;
import com.evolveum.midpoint.schema.XmlUtil;
import com.evolveum.midpoint.schema.processor.PropertyContainer;
import com.evolveum.midpoint.xml.ns._public.common.common_1.ProtectedStringType;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.math.BigInteger;

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

    public PropertyContainer getContainer() {
        if (container == null) {
            container = new PropertyContainer(COMPLEX_TYPE);
        }
        return container;
    }

    public void setContainer(PropertyContainer container) {
        if (container == null) {
            container = null;
            return;
        }
        if (!COMPLEX_TYPE.equals(container.getName())) {
            throw new IllegalArgumentException((((("Container qname '" + container.getName())
                    + "' doesn't equals to '") + COMPLEX_TYPE) + "'."));
        }
        this.container = container;
    }

    @XmlElement(required = true)
    public ProtectedStringType getProtectedString() {
        return XmlUtil.getPropertyValue(getContainer(), F_PROTECTED_STRING, ProtectedStringType.class);
    }

    public void setProtectedString(ProtectedStringType value) {
        XmlUtil.setPropertyValue(getContainer(), F_PROTECTED_STRING, value);
    }

    public BigInteger getFailedLogins() {
        return XmlUtil.getPropertyValue(getContainer(), F_FAILED_LOGINS, BigInteger.class);
    }

    public void setFailedLogins(BigInteger value) {
        XmlUtil.setPropertyValue(getContainer(), F_FAILED_LOGINS, value);
    }

    @XmlSchemaType(name = "dateTime")
    public XMLGregorianCalendar getLastFailedLoginTimestamp() {
        return XmlUtil.getPropertyValue(getContainer(), F_LAST_FAILED_LOGIN_TIMESTAMP, XMLGregorianCalendar.class);
    }

    public void setLastFailedLoginTimestamp(XMLGregorianCalendar value) {
        XmlUtil.setPropertyValue(getContainer(), F_LAST_FAILED_LOGIN_TIMESTAMP, value);
    }

}
