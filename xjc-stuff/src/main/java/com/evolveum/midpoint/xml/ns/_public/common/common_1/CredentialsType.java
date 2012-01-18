package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import com.evolveum.midpoint.schema.processorFake.PropertyContainer;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * This is a container type for various credentials types: passwords, public keys, one-time password
 * scheme identifiers, etc. However, we expect that password will be the most widely used credential
 * type and that's actually also the only supported type.
 * <p/>
 * The reason to "formalize" this structure is the ability to synchronize credentials. If the password
 * would be just an ordinary attribute, we cannot automatically synchronize user and account passwords.
 * Similarly as other credential types.
 * Note: marking password with a special attribute type will not be enough. There may be numerous passwords
 * with various meanings, we need to distinguish the "primary" one to synchronize. We also need to store
 * user password somewhere.
 * <p/>
 * This is not perfect. It may change in the future.
 * <p/>
 * TODO: support for "old password", e.g. some resource need it to change password.
 * <p/>
 * <p/>
 * <p>Java class for CredentialsType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="CredentialsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="password" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}PasswordType" minOccurs="0"/>
 *         &lt;element name="allowedIdmAdminGuiAccess" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
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

    /**
     * Gets the value of the password property.
     *
     * @return possible object is
     *         {@link PasswordType }
     */
    public PasswordType getPassword() {
        return password;
    }

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

    public void setPassword(PasswordType value) {
        //todo do not use setValue but remove container from parent property container, update if user set/remove method
        this.password = value;
        if (value == null) {
            setPropertyValue(F_PASSWORD, null);
        } else {
            setPropertyValue(F_PASSWORD, value.getContainer());
        }
    }

    @XmlElement(defaultValue = "false")
    public Boolean isAllowedIdmAdminGuiAccess() {
        return getPropertyValue(F_ALLOWED_IDM_ADMIN_GUI_ACCESS, Boolean.class);
    }

    public void setAllowedIdmAdminGuiAccess(Boolean value) {
        setPropertyValue(F_ALLOWED_IDM_ADMIN_GUI_ACCESS, value);
    }

}
