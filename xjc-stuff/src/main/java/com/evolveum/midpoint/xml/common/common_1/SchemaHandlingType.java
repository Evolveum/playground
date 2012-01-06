
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * 
 *                 Specification of handling details for resource
 *                 schema. E.g. read-only or read-write attributes,
 *                 account
 *                 object
 *                 classes, etc.
 * 
 *                 TODO: more details
 * 
 *                 This element belongs to ResourceType
 *                 and should
 *                 not be used elsewhere.
 *                 This is a top-level
 *                 element to make
 *                 the implementation
 *                 (JAXB marshall/unmarshall) easier.
 *             
 * 
 * <p>Java class for SchemaHandlingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SchemaHandlingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountType" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ResourceAccountTypeDefinitionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="entitlementType" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}name" minOccurs="0"/>
 *                   &lt;element name="objectClass" type="{http://www.w3.org/2001/XMLSchema}QName"/>
 *                   &lt;element name="assignmentProperty">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *                           &lt;attribute name="minOccurs" type="{http://www.w3.org/2001/XMLSchema}string" default="1" />
 *                           &lt;attribute name="maxOccurs" type="{http://www.w3.org/2001/XMLSchema}string" default="1" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SchemaHandlingType", propOrder = {
    "accountType",
    "entitlementType"
})
public class SchemaHandlingType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected List<ResourceAccountTypeDefinitionType> accountType;
    protected List<SchemaHandlingType.EntitlementType> entitlementType;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "SchemaHandlingType");

    /**
     * Gets the value of the accountType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceAccountTypeDefinitionType }
     * 
     * 
     */
    public List<ResourceAccountTypeDefinitionType> getAccountType() {
        if (accountType == null) {
            accountType = new ArrayList<ResourceAccountTypeDefinitionType>();
        }
        return this.accountType;
    }

    /**
     * Gets the value of the entitlementType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entitlementType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntitlementType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SchemaHandlingType.EntitlementType }
     * 
     * 
     */
    public List<SchemaHandlingType.EntitlementType> getEntitlementType() {
        if (entitlementType == null) {
            entitlementType = new ArrayList<SchemaHandlingType.EntitlementType>();
        }
        return this.entitlementType;
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
            List<ResourceAccountTypeDefinitionType> theAccountType;
            theAccountType = (((this.accountType!= null)&&(!this.accountType.isEmpty()))?this.getAccountType():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accountType", theAccountType), currentHashCode, theAccountType);
        }
        {
            List<SchemaHandlingType.EntitlementType> theEntitlementType;
            theEntitlementType = (((this.entitlementType!= null)&&(!this.entitlementType.isEmpty()))?this.getEntitlementType():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entitlementType", theEntitlementType), currentHashCode, theEntitlementType);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new com.evolveum.midpoint.schema.DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SchemaHandlingType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SchemaHandlingType that = ((SchemaHandlingType) object);
        {
            List<ResourceAccountTypeDefinitionType> lhsAccountType;
            lhsAccountType = (((this.accountType!= null)&&(!this.accountType.isEmpty()))?this.getAccountType():null);
            List<ResourceAccountTypeDefinitionType> rhsAccountType;
            rhsAccountType = (((that.accountType!= null)&&(!that.accountType.isEmpty()))?that.getAccountType():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "accountType", lhsAccountType), LocatorUtils.property(thatLocator, "accountType", rhsAccountType), lhsAccountType, rhsAccountType)) {
                return false;
            }
        }
        {
            List<SchemaHandlingType.EntitlementType> lhsEntitlementType;
            lhsEntitlementType = (((this.entitlementType!= null)&&(!this.entitlementType.isEmpty()))?this.getEntitlementType():null);
            List<SchemaHandlingType.EntitlementType> rhsEntitlementType;
            rhsEntitlementType = (((that.entitlementType!= null)&&(!that.entitlementType.isEmpty()))?that.getEntitlementType():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "entitlementType", lhsEntitlementType), LocatorUtils.property(thatLocator, "entitlementType", rhsEntitlementType), lhsEntitlementType, rhsEntitlementType)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = new com.evolveum.midpoint.schema.DomAwareEqualsStrategy();
        return equals(null, null, object, strategy);
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}name" minOccurs="0"/>
     *         &lt;element name="objectClass" type="{http://www.w3.org/2001/XMLSchema}QName"/>
     *         &lt;element name="assignmentProperty">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}QName" />
     *                 &lt;attribute name="minOccurs" type="{http://www.w3.org/2001/XMLSchema}string" default="1" />
     *                 &lt;attribute name="maxOccurs" type="{http://www.w3.org/2001/XMLSchema}string" default="1" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "name",
        "objectClass",
        "assignmentProperty"
    })
    public static class EntitlementType
        implements Serializable, Equals, HashCode
    {

        private final static long serialVersionUID = 201105211233L;
        protected String name;
        @XmlElement(required = true)
        protected QName objectClass;
        @XmlElement(required = true)
        protected SchemaHandlingType.EntitlementType.AssignmentProperty assignmentProperty;
        @XmlAttribute(name = "id")
        protected String id;

        /**
         * 
         *                                     Human readable name for
         *                                     the object class.
         *                                 
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the objectClass property.
         * 
         * @return
         *     possible object is
         *     {@link QName }
         *     
         */
        public QName getObjectClass() {
            return objectClass;
        }

        /**
         * Sets the value of the objectClass property.
         * 
         * @param value
         *     allowed object is
         *     {@link QName }
         *     
         */
        public void setObjectClass(QName value) {
            this.objectClass = value;
        }

        /**
         * Gets the value of the assignmentProperty property.
         * 
         * @return
         *     possible object is
         *     {@link SchemaHandlingType.EntitlementType.AssignmentProperty }
         *     
         */
        public SchemaHandlingType.EntitlementType.AssignmentProperty getAssignmentProperty() {
            return assignmentProperty;
        }

        /**
         * Sets the value of the assignmentProperty property.
         * 
         * @param value
         *     allowed object is
         *     {@link SchemaHandlingType.EntitlementType.AssignmentProperty }
         *     
         */
        public void setAssignmentProperty(SchemaHandlingType.EntitlementType.AssignmentProperty value) {
            this.assignmentProperty = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
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
                String theName;
                theName = this.getName();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "name", theName), currentHashCode, theName);
            }
            {
                QName theObjectClass;
                theObjectClass = this.getObjectClass();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "objectClass", theObjectClass), currentHashCode, theObjectClass);
            }
            {
                SchemaHandlingType.EntitlementType.AssignmentProperty theAssignmentProperty;
                theAssignmentProperty = this.getAssignmentProperty();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "assignmentProperty", theAssignmentProperty), currentHashCode, theAssignmentProperty);
            }
            {
                String theId;
                theId = this.getId();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = new com.evolveum.midpoint.schema.DomAwareHashCodeStrategy();
            return this.hashCode(null, strategy);
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof SchemaHandlingType.EntitlementType)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final SchemaHandlingType.EntitlementType that = ((SchemaHandlingType.EntitlementType) object);
            {
                String lhsName;
                lhsName = this.getName();
                String rhsName;
                rhsName = that.getName();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "name", lhsName), LocatorUtils.property(thatLocator, "name", rhsName), lhsName, rhsName)) {
                    return false;
                }
            }
            {
                QName lhsObjectClass;
                lhsObjectClass = this.getObjectClass();
                QName rhsObjectClass;
                rhsObjectClass = that.getObjectClass();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "objectClass", lhsObjectClass), LocatorUtils.property(thatLocator, "objectClass", rhsObjectClass), lhsObjectClass, rhsObjectClass)) {
                    return false;
                }
            }
            {
                SchemaHandlingType.EntitlementType.AssignmentProperty lhsAssignmentProperty;
                lhsAssignmentProperty = this.getAssignmentProperty();
                SchemaHandlingType.EntitlementType.AssignmentProperty rhsAssignmentProperty;
                rhsAssignmentProperty = that.getAssignmentProperty();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "assignmentProperty", lhsAssignmentProperty), LocatorUtils.property(thatLocator, "assignmentProperty", rhsAssignmentProperty), lhsAssignmentProperty, rhsAssignmentProperty)) {
                    return false;
                }
            }
            {
                String lhsId;
                lhsId = this.getId();
                String rhsId;
                rhsId = that.getId();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "id", lhsId), LocatorUtils.property(thatLocator, "id", rhsId), lhsId, rhsId)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object object) {
            final EqualsStrategy strategy = new com.evolveum.midpoint.schema.DomAwareEqualsStrategy();
            return equals(null, null, object, strategy);
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}QName" />
         *       &lt;attribute name="minOccurs" type="{http://www.w3.org/2001/XMLSchema}string" default="1" />
         *       &lt;attribute name="maxOccurs" type="{http://www.w3.org/2001/XMLSchema}string" default="1" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class AssignmentProperty
            implements Serializable, Equals, HashCode
        {

            private final static long serialVersionUID = 201105211233L;
            @XmlAttribute(name = "ref")
            protected QName ref;
            @XmlAttribute(name = "minOccurs")
            protected String minOccurs;
            @XmlAttribute(name = "maxOccurs")
            protected String maxOccurs;

            /**
             * Gets the value of the ref property.
             * 
             * @return
             *     possible object is
             *     {@link QName }
             *     
             */
            public QName getRef() {
                return ref;
            }

            /**
             * Sets the value of the ref property.
             * 
             * @param value
             *     allowed object is
             *     {@link QName }
             *     
             */
            public void setRef(QName value) {
                this.ref = value;
            }

            /**
             * Gets the value of the minOccurs property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMinOccurs() {
                if (minOccurs == null) {
                    return "1";
                } else {
                    return minOccurs;
                }
            }

            /**
             * Sets the value of the minOccurs property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMinOccurs(String value) {
                this.minOccurs = value;
            }

            /**
             * Gets the value of the maxOccurs property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMaxOccurs() {
                if (maxOccurs == null) {
                    return "1";
                } else {
                    return maxOccurs;
                }
            }

            /**
             * Sets the value of the maxOccurs property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMaxOccurs(String value) {
                this.maxOccurs = value;
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
                    QName theRef;
                    theRef = this.getRef();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ref", theRef), currentHashCode, theRef);
                }
                {
                    String theMinOccurs;
                    theMinOccurs = this.getMinOccurs();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "minOccurs", theMinOccurs), currentHashCode, theMinOccurs);
                }
                {
                    String theMaxOccurs;
                    theMaxOccurs = this.getMaxOccurs();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "maxOccurs", theMaxOccurs), currentHashCode, theMaxOccurs);
                }
                return currentHashCode;
            }

            public int hashCode() {
                final HashCodeStrategy strategy = new com.evolveum.midpoint.schema.DomAwareHashCodeStrategy();
                return this.hashCode(null, strategy);
            }

            public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
                if (!(object instanceof SchemaHandlingType.EntitlementType.AssignmentProperty)) {
                    return false;
                }
                if (this == object) {
                    return true;
                }
                final SchemaHandlingType.EntitlementType.AssignmentProperty that = ((SchemaHandlingType.EntitlementType.AssignmentProperty) object);
                {
                    QName lhsRef;
                    lhsRef = this.getRef();
                    QName rhsRef;
                    rhsRef = that.getRef();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "ref", lhsRef), LocatorUtils.property(thatLocator, "ref", rhsRef), lhsRef, rhsRef)) {
                        return false;
                    }
                }
                {
                    String lhsMinOccurs;
                    lhsMinOccurs = this.getMinOccurs();
                    String rhsMinOccurs;
                    rhsMinOccurs = that.getMinOccurs();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "minOccurs", lhsMinOccurs), LocatorUtils.property(thatLocator, "minOccurs", rhsMinOccurs), lhsMinOccurs, rhsMinOccurs)) {
                        return false;
                    }
                }
                {
                    String lhsMaxOccurs;
                    lhsMaxOccurs = this.getMaxOccurs();
                    String rhsMaxOccurs;
                    rhsMaxOccurs = that.getMaxOccurs();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "maxOccurs", lhsMaxOccurs), LocatorUtils.property(thatLocator, "maxOccurs", rhsMaxOccurs), lhsMaxOccurs, rhsMaxOccurs)) {
                        return false;
                    }
                }
                return true;
            }

            public boolean equals(Object object) {
                final EqualsStrategy strategy = new com.evolveum.midpoint.schema.DomAwareEqualsStrategy();
                return equals(null, null, object, strategy);
            }

        }

    }

}
