package com.evolveum.midpoint.xml.ns._public.common.common;

import com.evolveum.midpoint.schema.SchemaConstants;
import com.evolveum.midpoint.schema.XmlUtil;
import com.evolveum.midpoint.schema.processor.PropertyContainer;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CredentialsType", propOrder = {
        "password",
        "allowedIdmAdminGuiAccess"
})
public class CredentialsType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected PasswordType password;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "CredentialsType");
    public final static QName F_PASSWORD = new QName(SchemaConstants.NS_COMMON, "password");
    public final static QName F_ALLOWED_IDM_ADMIN_GUI_ACCESS = new QName(SchemaConstants.NS_COMMON, "allowedIdmAdminGuiAccess");
    @XmlTransient
    private PropertyContainer container;

    public PasswordType getPassword() {
        return password;
    }

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

    public void setPassword(PasswordType value) {
        //todo do not use setValue but remove container from parent property container, update if user set/remove method
        this.password = value;
        if (value == null) {
            XmlUtil.setPropertyValue(getContainer(), F_PASSWORD, null);
        } else {
            XmlUtil.setPropertyValue(getContainer(), F_PASSWORD, value.getContainer());
        }
    }

    @XmlElement(defaultValue = "false")
    public Boolean isAllowedIdmAdminGuiAccess() {
        return XmlUtil.getPropertyValue(getContainer(), F_ALLOWED_IDM_ADMIN_GUI_ACCESS, Boolean.class);
    }

    public void setAllowedIdmAdminGuiAccess(Boolean value) {
        XmlUtil.setPropertyValue(getContainer(), F_ALLOWED_IDM_ADMIN_GUI_ACCESS, value);
    }

}
