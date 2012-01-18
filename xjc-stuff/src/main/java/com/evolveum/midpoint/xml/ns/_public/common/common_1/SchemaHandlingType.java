package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Specification of handling details for resource
 * schema. E.g. read-only or read-write attributes,
 * account object classes, etc.
 * <p/>
 * TODO: more details
 * <p/>
 * This element belongs to ResourceType and should
 * not be used elsewhere. This is a top-level
 * element to make the implementation
 * (JAXB marshall/unmarshall) easier.
 * <p/>
 * <p/>
 * <p>Java class for SchemaHandlingType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
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
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SchemaHandlingType", propOrder = {
        "accountType",
        "entitlementType"
})
public class SchemaHandlingType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected List<ResourceAccountTypeDefinitionType> accountType;
    protected List<SchemaHandlingType.EntitlementType> entitlementType;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "SchemaHandlingType");
    public final static QName F_ACCOUNT_TYPE = new QName(SchemaConstants.NS_COMMON, "accountType");
    public final static QName F_ENTITLEMENT_TYPE = new QName(SchemaConstants.NS_COMMON, "entitlementType");

    /**
     * Gets the value of the accountType property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountType property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountType().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceAccountTypeDefinitionType }
     */
    public List<ResourceAccountTypeDefinitionType> getAccountType() {
        if (accountType == null) {
            accountType = new ArrayList<ResourceAccountTypeDefinitionType>();
        }
        return this.accountType;
    }

    /**
     * Gets the value of the entitlementType property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entitlementType property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntitlementType().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link SchemaHandlingType.EntitlementType }
     */
    public List<SchemaHandlingType.EntitlementType> getEntitlementType() {
        if (entitlementType == null) {
            entitlementType = new ArrayList<SchemaHandlingType.EntitlementType>();
        }
        return this.entitlementType;
    }


    /**
     * <p>Java class for anonymous complex type.
     * <p/>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p/>
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
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "name",
            "objectClass",
            "assignmentProperty"
    })
    public static class EntitlementType
            implements Serializable {

        private final static long serialVersionUID = 201105211233L;
        protected String name;
        @XmlElement(required = true)
        protected QName objectClass;
        @XmlElement(required = true)
        protected SchemaHandlingType.EntitlementType.AssignmentProperty assignmentProperty;
        @XmlAttribute(name = "id")
        protected String id;

        /**
         * Human readable name for the object class.
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
         * Gets the value of the assignmentProperty property.
         *
         * @return possible object is
         *         {@link SchemaHandlingType.EntitlementType.AssignmentProperty }
         */
        public SchemaHandlingType.EntitlementType.AssignmentProperty getAssignmentProperty() {
            return assignmentProperty;
        }

        /**
         * Sets the value of the assignmentProperty property.
         *
         * @param value allowed object is
         *              {@link SchemaHandlingType.EntitlementType.AssignmentProperty }
         */
        public void setAssignmentProperty(SchemaHandlingType.EntitlementType.AssignmentProperty value) {
            this.assignmentProperty = value;
        }

        /**
         * Gets the value of the id property.
         *
         * @return possible object is
         *         {@link String }
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setId(String value) {
            this.id = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * <p/>
         * <p>The following schema fragment specifies the expected content contained within this class.
         * <p/>
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
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class AssignmentProperty
                implements Serializable {

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
             * @return possible object is
             *         {@link QName }
             */
            public QName getRef() {
                return ref;
            }

            /**
             * Sets the value of the ref property.
             *
             * @param value allowed object is
             *              {@link QName }
             */
            public void setRef(QName value) {
                this.ref = value;
            }

            /**
             * Gets the value of the minOccurs property.
             *
             * @return possible object is
             *         {@link String }
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
             * @param value allowed object is
             *              {@link String }
             */
            public void setMinOccurs(String value) {
                this.minOccurs = value;
            }

            /**
             * Gets the value of the maxOccurs property.
             *
             * @return possible object is
             *         {@link String }
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
             * @param value allowed object is
             *              {@link String }
             */
            public void setMaxOccurs(String value) {
                this.maxOccurs = value;
            }

        }

    }

}
