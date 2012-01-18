package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Defiens a type from the resource schema (object class)
 * that can be used for creating accounts.
 * <p/>
 * <p/>
 * <p>Java class for ResourceAccountTypeDefinitionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ResourceAccountTypeDefinitionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}name"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}displayName" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}description" minOccurs="0"/>
 *         &lt;element name="default" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="objectClass" type="{http://www.w3.org/2001/XMLSchema}QName"/>
 *         &lt;element name="attribute" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ResourceAttributeDefinitionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="credentials" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ResourceCredentialsDefinitionType" minOccurs="0"/>
 *         &lt;element name="activation" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ResourceActivationDefinitionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceAccountTypeDefinitionType", propOrder = {
        "name",
        "displayName",
        "description",
        "_default",
        "objectClass",
        "attribute",
        "credentials",
        "activation"
})
public class ResourceAccountTypeDefinitionType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected String name;
    protected String displayName;
    protected String description;
    @XmlElement(name = "default", defaultValue = "false")
    protected Boolean _default;
    @XmlElement(required = true)
    protected QName objectClass;
    protected List<ResourceAttributeDefinitionType> attribute;
    protected ResourceCredentialsDefinitionType credentials;
    protected ResourceActivationDefinitionType activation;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ResourceAccountTypeDefinitionType");
    public final static QName F_NAME = new QName(SchemaConstants.NS_COMMON, "name");
    public final static QName F_DISPLAY_NAME = new QName(SchemaConstants.NS_COMMON, "displayName");
    public final static QName F_DESCRIPTION = new QName(SchemaConstants.NS_COMMON, "description");
    public final static QName F__DEFAULT = new QName(SchemaConstants.NS_COMMON, "_default");
    public final static QName F_OBJECT_CLASS = new QName(SchemaConstants.NS_COMMON, "objectClass");
    public final static QName F_ATTRIBUTE = new QName(SchemaConstants.NS_COMMON, "attribute");
    public final static QName F_CREDENTIALS = new QName(SchemaConstants.NS_COMMON, "credentials");
    public final static QName F_ACTIVATION = new QName(SchemaConstants.NS_COMMON, "activation");

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the displayName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the value of the displayName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the default property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isDefault() {
        return _default;
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

    /**
     * Gets the value of the objectClass property.
     *
     * @return possible object is
     *         {@link QName }
     */
    public QName getObjectClass() {
        return objectClass;
    }

    /**
     * Sets the value of the objectClass property.
     *
     * @param value allowed object is
     *              {@link QName }
     */
    public void setObjectClass(QName value) {
        this.objectClass = value;
    }

    /**
     * Gets the value of the attribute property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attribute property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttribute().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceAttributeDefinitionType }
     */
    public List<ResourceAttributeDefinitionType> getAttribute() {
        if (attribute == null) {
            attribute = new ArrayList<ResourceAttributeDefinitionType>();
        }
        return this.attribute;
    }

    /**
     * Gets the value of the credentials property.
     *
     * @return possible object is
     *         {@link ResourceCredentialsDefinitionType }
     */
    public ResourceCredentialsDefinitionType getCredentials() {
        return credentials;
    }

    /**
     * Sets the value of the credentials property.
     *
     * @param value allowed object is
     *              {@link ResourceCredentialsDefinitionType }
     */
    public void setCredentials(ResourceCredentialsDefinitionType value) {
        this.credentials = value;
    }

    /**
     * Gets the value of the activation property.
     *
     * @return possible object is
     *         {@link ResourceActivationDefinitionType }
     */
    public ResourceActivationDefinitionType getActivation() {
        return activation;
    }

    /**
     * Sets the value of the activation property.
     *
     * @param value allowed object is
     *              {@link ResourceActivationDefinitionType }
     */
    public void setActivation(ResourceActivationDefinitionType value) {
        this.activation = value;
    }

}
