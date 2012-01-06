
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import com.evolveum.midpoint.schema.DomAwareEqualsStrategy;
import com.evolveum.midpoint.schema.DomAwareHashCodeStrategy;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for AccountConstructionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
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
 * 
 * 
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
public class AccountConstructionType
    implements Serializable, Equals, HashCode
{

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
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "AccountConstructionType");

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the extension property.
     * 
     * @return
     *     possible object is
     *     {@link Extension }
     *     
     */
    public Extension getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extension }
     *     
     */
    public void setExtension(Extension value) {
        this.extension = value;
    }

    /**
     * Gets the value of the resourceRef property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectReferenceType }
     *     
     */
    public ObjectReferenceType getResourceRef() {
        return resourceRef;
    }

    /**
     * Sets the value of the resourceRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectReferenceType }
     *     
     */
    public void setResourceRef(ObjectReferenceType value) {
        this.resourceRef = value;
    }

    /**
     * Gets the value of the resource property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceType }
     *     
     */
    public ResourceType getResource() {
        return resource;
    }

    /**
     * Sets the value of the resource property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceType }
     *     
     */
    public void setResource(ResourceType value) {
        this.resource = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the typeExpression property.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionType }
     *     
     */
    public ExpressionType getTypeExpression() {
        return typeExpression;
    }

    /**
     * Sets the value of the typeExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionType }
     *     
     */
    public void setTypeExpression(ExpressionType value) {
        this.typeExpression = value;
    }

    /**
     * 
     *                         The account is implied only if the condition is
     *                         evaluated to true.
     *                         If condition is not present, it
     *                         is
     *                         assumed to be
     *                         true.
     *                     
     * 
     * @return
     *     possible object is
     *     {@link ExpressionType }
     *     
     */
    public ExpressionType getCondition() {
        return condition;
    }

    /**
     * Sets the value of the condition property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionType }
     *     
     */
    public void setCondition(ExpressionType value) {
        this.condition = value;
    }

    /**
     * Gets the value of the attribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValueConstructionType }
     * 
     * 
     */
    public List<ValueConstructionType> getAttribute() {
        if (attribute == null) {
            attribute = new ArrayList<ValueConstructionType>();
        }
        return this.attribute;
    }

    /**
     * Gets the value of the entitlement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entitlement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntitlement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntitlementConstructionType }
     * 
     * 
     */
    public List<EntitlementConstructionType> getEntitlement() {
        if (entitlement == null) {
            entitlement = new ArrayList<EntitlementConstructionType>();
        }
        return this.entitlement;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theDescription;
            theDescription = this.getDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "description", theDescription), currentHashCode, theDescription);
        }
        {
            Extension theExtension;
            theExtension = this.getExtension();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "extension", theExtension), currentHashCode, theExtension);
        }
        {
            ObjectReferenceType theResourceRef;
            theResourceRef = this.getResourceRef();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resourceRef", theResourceRef), currentHashCode, theResourceRef);
        }
        {
            ResourceType theResource;
            theResource = this.getResource();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resource", theResource), currentHashCode, theResource);
        }
        {
            String theType;
            theType = this.getType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "type", theType), currentHashCode, theType);
        }
        {
            ExpressionType theTypeExpression;
            theTypeExpression = this.getTypeExpression();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "typeExpression", theTypeExpression), currentHashCode, theTypeExpression);
        }
        {
            ExpressionType theCondition;
            theCondition = this.getCondition();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "condition", theCondition), currentHashCode, theCondition);
        }
        {
            List<ValueConstructionType> theAttribute;
            theAttribute = (((this.attribute!= null)&&(!this.attribute.isEmpty()))?this.getAttribute():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "attribute", theAttribute), currentHashCode, theAttribute);
        }
        {
            List<EntitlementConstructionType> theEntitlement;
            theEntitlement = (((this.entitlement!= null)&&(!this.entitlement.isEmpty()))?this.getEntitlement():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entitlement", theEntitlement), currentHashCode, theEntitlement);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AccountConstructionType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AccountConstructionType that = ((AccountConstructionType) object);
        {
            String lhsDescription;
            lhsDescription = this.getDescription();
            String rhsDescription;
            rhsDescription = that.getDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "description", lhsDescription), LocatorUtils.property(thatLocator, "description", rhsDescription), lhsDescription, rhsDescription)) {
                return false;
            }
        }
        {
            Extension lhsExtension;
            lhsExtension = this.getExtension();
            Extension rhsExtension;
            rhsExtension = that.getExtension();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "extension", lhsExtension), LocatorUtils.property(thatLocator, "extension", rhsExtension), lhsExtension, rhsExtension)) {
                return false;
            }
        }
        {
            ObjectReferenceType lhsResourceRef;
            lhsResourceRef = this.getResourceRef();
            ObjectReferenceType rhsResourceRef;
            rhsResourceRef = that.getResourceRef();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "resourceRef", lhsResourceRef), LocatorUtils.property(thatLocator, "resourceRef", rhsResourceRef), lhsResourceRef, rhsResourceRef)) {
                return false;
            }
        }
        {
            ResourceType lhsResource;
            lhsResource = this.getResource();
            ResourceType rhsResource;
            rhsResource = that.getResource();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "resource", lhsResource), LocatorUtils.property(thatLocator, "resource", rhsResource), lhsResource, rhsResource)) {
                return false;
            }
        }
        {
            String lhsType;
            lhsType = this.getType();
            String rhsType;
            rhsType = that.getType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "type", lhsType), LocatorUtils.property(thatLocator, "type", rhsType), lhsType, rhsType)) {
                return false;
            }
        }
        {
            ExpressionType lhsTypeExpression;
            lhsTypeExpression = this.getTypeExpression();
            ExpressionType rhsTypeExpression;
            rhsTypeExpression = that.getTypeExpression();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "typeExpression", lhsTypeExpression), LocatorUtils.property(thatLocator, "typeExpression", rhsTypeExpression), lhsTypeExpression, rhsTypeExpression)) {
                return false;
            }
        }
        {
            ExpressionType lhsCondition;
            lhsCondition = this.getCondition();
            ExpressionType rhsCondition;
            rhsCondition = that.getCondition();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "condition", lhsCondition), LocatorUtils.property(thatLocator, "condition", rhsCondition), lhsCondition, rhsCondition)) {
                return false;
            }
        }
        {
            List<ValueConstructionType> lhsAttribute;
            lhsAttribute = (((this.attribute!= null)&&(!this.attribute.isEmpty()))?this.getAttribute():null);
            List<ValueConstructionType> rhsAttribute;
            rhsAttribute = (((that.attribute!= null)&&(!that.attribute.isEmpty()))?that.getAttribute():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "attribute", lhsAttribute), LocatorUtils.property(thatLocator, "attribute", rhsAttribute), lhsAttribute, rhsAttribute)) {
                return false;
            }
        }
        {
            List<EntitlementConstructionType> lhsEntitlement;
            lhsEntitlement = (((this.entitlement!= null)&&(!this.entitlement.isEmpty()))?this.getEntitlement():null);
            List<EntitlementConstructionType> rhsEntitlement;
            rhsEntitlement = (((that.entitlement!= null)&&(!that.entitlement.isEmpty()))?that.getEntitlement():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "entitlement", lhsEntitlement), LocatorUtils.property(thatLocator, "entitlement", rhsEntitlement), lhsEntitlement, rhsEntitlement)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = new DomAwareEqualsStrategy();
        return equals(null, null, object, strategy);
    }

}
