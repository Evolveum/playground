package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Defines a synchronization properties (configuration) for a
 * resource. This applies to all flavors of synchronization
 * (live sync, reconciliation, import, ...)
 * <p/>
 * <p/>
 * <p>Java class for SynchronizationType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SynchronizationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="correlation" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}QueryType" minOccurs="0"/>
 *         &lt;element name="confirmation" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExpressionType" minOccurs="0"/>
 *         &lt;element name="reconcileAttributes" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="reaction" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}description" minOccurs="0"/>
 *                   &lt;element name="situation" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}SynchronizationSituationType"/>
 *                   &lt;element name="action" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
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
@XmlType(name = "SynchronizationType", propOrder = {
        "enabled",
        "correlation",
        "confirmation",
        "reconcileAttributes",
        "reaction"
})
public class SynchronizationType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(defaultValue = "true")
    protected Boolean enabled;
    protected QueryType correlation;
    protected ExpressionType confirmation;
    protected Boolean reconcileAttributes;
    protected List<SynchronizationType.Reaction> reaction;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "SynchronizationType");
    public final static QName F_ENABLED = new QName(SchemaConstants.NS_COMMON, "enabled");
    public final static QName F_CORRELATION = new QName(SchemaConstants.NS_COMMON, "correlation");
    public final static QName F_CONFIRMATION = new QName(SchemaConstants.NS_COMMON, "confirmation");
    public final static QName F_RECONCILE_ATTRIBUTES = new QName(SchemaConstants.NS_COMMON, "reconcileAttributes");
    public final static QName F_REACTION = new QName(SchemaConstants.NS_COMMON, "reaction");

    /**
     * Gets the value of the enabled property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setEnabled(Boolean value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the correlation property.
     *
     * @return possible object is
     *         {@link QueryType }
     */
    public QueryType getCorrelation() {
        return correlation;
    }

    /**
     * Sets the value of the correlation property.
     *
     * @param value allowed object is
     *              {@link QueryType }
     */
    public void setCorrelation(QueryType value) {
        this.correlation = value;
    }

    /**
     * Gets the value of the confirmation property.
     *
     * @return possible object is
     *         {@link ExpressionType }
     */
    public ExpressionType getConfirmation() {
        return confirmation;
    }

    /**
     * Sets the value of the confirmation property.
     *
     * @param value allowed object is
     *              {@link ExpressionType }
     */
    public void setConfirmation(ExpressionType value) {
        this.confirmation = value;
    }

    /**
     * Gets the value of the reconcileAttributes property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isReconcileAttributes() {
        return reconcileAttributes;
    }

    /**
     * Sets the value of the reconcileAttributes property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setReconcileAttributes(Boolean value) {
        this.reconcileAttributes = value;
    }

    /**
     * Gets the value of the reaction property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reaction property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReaction().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link SynchronizationType.Reaction }
     */
    public List<SynchronizationType.Reaction> getReaction() {
        if (reaction == null) {
            reaction = new ArrayList<SynchronizationType.Reaction>();
        }
        return this.reaction;
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
     *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}description" minOccurs="0"/>
     *         &lt;element name="situation" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}SynchronizationSituationType"/>
     *         &lt;element name="action" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
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
    @XmlType(name = "", propOrder = {
            "description",
            "situation",
            "action"
    })
    public static class Reaction
            implements Serializable {

        private final static long serialVersionUID = 201105211233L;
        protected String description;
        @XmlElement(required = true)
        protected SynchronizationSituationType situation;
        protected List<SynchronizationType.Reaction.Action> action;

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
         * Gets the value of the situation property.
         *
         * @return possible object is
         *         {@link SynchronizationSituationType }
         */
        public SynchronizationSituationType getSituation() {
            return situation;
        }

        /**
         * Sets the value of the situation property.
         *
         * @param value allowed object is
         *              {@link SynchronizationSituationType }
         */
        public void setSituation(SynchronizationSituationType value) {
            this.situation = value;
        }

        /**
         * Gets the value of the action property.
         * <p/>
         * <p/>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the action property.
         * <p/>
         * <p/>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAction().add(newItem);
         * </pre>
         * <p/>
         * <p/>
         * <p/>
         * Objects of the following type(s) are allowed in the list
         * {@link SynchronizationType.Reaction.Action }
         */
        public List<SynchronizationType.Reaction.Action> getAction() {
            if (action == null) {
                action = new ArrayList<SynchronizationType.Reaction.Action>();
            }
            return this.action;
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
         *         &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "any"
        })
        public static class Action
                implements Serializable {

            private final static long serialVersionUID = 201105211233L;
            @XmlAnyElement(lax = true)
            protected List<Object> any;
            @XmlAttribute(name = "ref")
            @XmlSchemaType(name = "anyURI")
            protected String ref;

            /**
             * Gets the value of the any property.
             * <p/>
             * <p/>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the any property.
             * <p/>
             * <p/>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getAny().add(newItem);
             * </pre>
             * <p/>
             * <p/>
             * <p/>
             * Objects of the following type(s) are allowed in the list
             * {@link Object }
             * {@link Element }
             */
            public List<Object> getAny() {
                if (any == null) {
                    any = new ArrayList<Object>();
                }
                return this.any;
            }

            /**
             * Gets the value of the ref property.
             *
             * @return possible object is
             *         {@link String }
             */
            public String getRef() {
                return ref;
            }

            /**
             * Sets the value of the ref property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setRef(String value) {
                this.ref = value;
            }

        }

    }

}
