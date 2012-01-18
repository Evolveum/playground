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
 * <p>Java class for AccountConstructionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AccountConstructionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}description" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}extension" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="resourceRef" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectReferenceType" minOccurs="0"/>
 *           &lt;element name="resource" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ResourceType" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *           &lt;element name="typeExpression" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExpressionType" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}condition" minOccurs="0"/>
 *         &lt;element name="attribute" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ValueConstructionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="entitlement" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}EntitlementConstructionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountConstructionType", propOrder = {
        "description",
        "extension",
        "resourceRef",
        "resource",
        "type",
        "typeExpression",
        "condition",
        "attribute",
        "entitlement"
})
public class AccountConstructionType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected String description;
    protected Extension extension;
    protected ObjectReferenceType resourceRef;
    protected ResourceType resource;
    @XmlElement(defaultValue = "user")
    protected String type;
    protected ExpressionType typeExpression;
    protected ExpressionType condition;
    protected List<ValueConstructionType> attribute;
    protected List<EntitlementConstructionType> entitlement;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "AccountConstructionType");
    public final static QName F_DESCRIPTION = new QName(SchemaConstants.NS_COMMON, "description");
    public final static QName F_EXTENSION = new QName(SchemaConstants.NS_COMMON, "extension");
    public final static QName F_RESOURCE_REF = new QName(SchemaConstants.NS_COMMON, "resourceRef");
    public final static QName F_RESOURCE = new QName(SchemaConstants.NS_COMMON, "resource");
    public final static QName F_TYPE = new QName(SchemaConstants.NS_COMMON, "type");
    public final static QName F_TYPE_EXPRESSION = new QName(SchemaConstants.NS_COMMON, "typeExpression");
    public final static QName F_CONDITION = new QName(SchemaConstants.NS_COMMON, "condition");
    public final static QName F_ATTRIBUTE = new QName(SchemaConstants.NS_COMMON, "attribute");
    public final static QName F_ENTITLEMENT = new QName(SchemaConstants.NS_COMMON, "entitlement");

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
     * Gets the value of the extension property.
     *
     * @return possible object is
     *         {@link Extension }
     */
    public Extension getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     *
     * @param value allowed object is
     *              {@link Extension }
     */
    public void setExtension(Extension value) {
        this.extension = value;
    }

    /**
     * Gets the value of the resourceRef property.
     *
     * @return possible object is
     *         {@link ObjectReferenceType }
     */
    public ObjectReferenceType getResourceRef() {
        return resourceRef;
    }

    /**
     * Sets the value of the resourceRef property.
     *
     * @param value allowed object is
     *              {@link ObjectReferenceType }
     */
    public void setResourceRef(ObjectReferenceType value) {
        this.resourceRef = value;
    }

    /**
     * Gets the value of the resource property.
     *
     * @return possible object is
     *         {@link ResourceType }
     */
    public ResourceType getResource() {
        return resource;
    }

    /**
     * Sets the value of the resource property.
     *
     * @param value allowed object is
     *              {@link ResourceType }
     */
    public void setResource(ResourceType value) {
        this.resource = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the typeExpression property.
     *
     * @return possible object is
     *         {@link ExpressionType }
     */
    public ExpressionType getTypeExpression() {
        return typeExpression;
    }

    /**
     * Sets the value of the typeExpression property.
     *
     * @param value allowed object is
     *              {@link ExpressionType }
     */
    public void setTypeExpression(ExpressionType value) {
        this.typeExpression = value;
    }

    /**
     * The account is implied only if the condition is evaluated to true.
     * If condition is not present, it is assumed to be true.
     *
     * @return possible object is
     *         {@link ExpressionType }
     */
    public ExpressionType getCondition() {
        return condition;
    }

    /**
     * Sets the value of the condition property.
     *
     * @param value allowed object is
     *              {@link ExpressionType }
     */
    public void setCondition(ExpressionType value) {
        this.condition = value;
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
     * {@link ValueConstructionType }
     */
    public List<ValueConstructionType> getAttribute() {
        if (attribute == null) {
            attribute = new ArrayList<ValueConstructionType>();
        }
        return this.attribute;
    }

    /**
     * Gets the value of the entitlement property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entitlement property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntitlement().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link EntitlementConstructionType }
     */
    public List<EntitlementConstructionType> getEntitlement() {
        if (entitlement == null) {
            entitlement = new ArrayList<EntitlementConstructionType>();
        }
        return this.entitlement;
    }

}
