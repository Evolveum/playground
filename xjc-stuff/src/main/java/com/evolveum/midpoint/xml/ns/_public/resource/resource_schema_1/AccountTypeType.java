package com.evolveum.midpoint.xml.ns._public.resource.resource_schema_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Type definition for an
 * annotation that marks object classes that are supposed to be used
 * for accounts. This should be considered a suggestion or a default
 * value for the account type definition in schema handling.
 * <p/>
 * This is supposed to be an annotation of an object class
 * (complexType in resource schema).
 * <p/>
 * <p/>
 * <p>Java class for AccountTypeType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AccountTypeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountTypeType")
public class AccountTypeType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlAttribute(name = "default")
    protected Boolean _default;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_RESOURCE, "AccountTypeType");
    public final static QName F__DEFAULT = new QName(SchemaConstants.NS_RESOURCE, "_default");

    /**
     * Gets the value of the default property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public boolean isDefault() {
        if (_default == null) {
            return false;
        } else {
            return _default;
        }
    }

    /**
     * Sets the value of the default property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setDefault(Boolean value) {
        this._default = value;
    }

}
