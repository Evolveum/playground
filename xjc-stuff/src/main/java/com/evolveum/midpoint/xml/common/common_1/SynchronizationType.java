
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
import org.w3c.dom.Element;


/**
 * 
 *                 Defines a synchronization properties
 *                 (configuration) for a
 *                 resource.
 * 
 *                 TODO: add reconciliation setup
 *                 (later)
 *             
 * 
 * <p>Java class for SynchronizationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SynchronizationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="correlation" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}QueryType" minOccurs="0"/>
 *         &lt;element name="confirmation" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExpressionType" minOccurs="0"/>
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
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SynchronizationType", propOrder = {
    "enabled",
    "correlation",
    "confirmation",
    "reaction"
})
public class SynchronizationType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(defaultValue = "true")
    protected Boolean enabled;
    protected QueryType correlation;
    protected ExpressionType confirmation;
    protected List<SynchronizationType.Reaction> reaction;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "SynchronizationType");

    /**
     * Gets the value of the enabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnabled(Boolean value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the correlation property.
     * 
     * @return
     *     possible object is
     *     {@link QueryType }
     *     
     */
    public QueryType getCorrelation() {
        return correlation;
    }

    /**
     * Sets the value of the correlation property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryType }
     *     
     */
    public void setCorrelation(QueryType value) {
        this.correlation = value;
    }

    /**
     * Gets the value of the confirmation property.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionType }
     *     
     */
    public ExpressionType getConfirmation() {
        return confirmation;
    }

    /**
     * Sets the value of the confirmation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionType }
     *     
     */
    public void setConfirmation(ExpressionType value) {
        this.confirmation = value;
    }

    /**
     * Gets the value of the reaction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reaction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReaction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SynchronizationType.Reaction }
     * 
     * 
     */
    public List<SynchronizationType.Reaction> getReaction() {
        if (reaction == null) {
            reaction = new ArrayList<SynchronizationType.Reaction>();
        }
        return this.reaction;
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
            Boolean theEnabled;
            theEnabled = this.isEnabled();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "enabled", theEnabled), currentHashCode, theEnabled);
        }
        {
            QueryType theCorrelation;
            theCorrelation = this.getCorrelation();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "correlation", theCorrelation), currentHashCode, theCorrelation);
        }
        {
            ExpressionType theConfirmation;
            theConfirmation = this.getConfirmation();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "confirmation", theConfirmation), currentHashCode, theConfirmation);
        }
        {
            List<SynchronizationType.Reaction> theReaction;
            theReaction = (((this.reaction!= null)&&(!this.reaction.isEmpty()))?this.getReaction():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "reaction", theReaction), currentHashCode, theReaction);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new com.evolveum.midpoint.schema.DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SynchronizationType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SynchronizationType that = ((SynchronizationType) object);
        {
            Boolean lhsEnabled;
            lhsEnabled = this.isEnabled();
            Boolean rhsEnabled;
            rhsEnabled = that.isEnabled();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "enabled", lhsEnabled), LocatorUtils.property(thatLocator, "enabled", rhsEnabled), lhsEnabled, rhsEnabled)) {
                return false;
            }
        }
        {
            QueryType lhsCorrelation;
            lhsCorrelation = this.getCorrelation();
            QueryType rhsCorrelation;
            rhsCorrelation = that.getCorrelation();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "correlation", lhsCorrelation), LocatorUtils.property(thatLocator, "correlation", rhsCorrelation), lhsCorrelation, rhsCorrelation)) {
                return false;
            }
        }
        {
            ExpressionType lhsConfirmation;
            lhsConfirmation = this.getConfirmation();
            ExpressionType rhsConfirmation;
            rhsConfirmation = that.getConfirmation();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "confirmation", lhsConfirmation), LocatorUtils.property(thatLocator, "confirmation", rhsConfirmation), lhsConfirmation, rhsConfirmation)) {
                return false;
            }
        }
        {
            List<SynchronizationType.Reaction> lhsReaction;
            lhsReaction = (((this.reaction!= null)&&(!this.reaction.isEmpty()))?this.getReaction():null);
            List<SynchronizationType.Reaction> rhsReaction;
            rhsReaction = (((that.reaction!= null)&&(!that.reaction.isEmpty()))?that.getReaction():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "reaction", lhsReaction), LocatorUtils.property(thatLocator, "reaction", rhsReaction), lhsReaction, rhsReaction)) {
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
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "description",
        "situation",
        "action"
    })
    public static class Reaction
        implements Serializable, Equals, HashCode
    {

        private final static long serialVersionUID = 201105211233L;
        protected String description;
        @XmlElement(required = true)
        protected SynchronizationSituationType situation;
        protected List<SynchronizationType.Reaction.Action> action;

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
         * Gets the value of the situation property.
         * 
         * @return
         *     possible object is
         *     {@link SynchronizationSituationType }
         *     
         */
        public SynchronizationSituationType getSituation() {
            return situation;
        }

        /**
         * Sets the value of the situation property.
         * 
         * @param value
         *     allowed object is
         *     {@link SynchronizationSituationType }
         *     
         */
        public void setSituation(SynchronizationSituationType value) {
            this.situation = value;
        }

        /**
         * Gets the value of the action property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the action property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAction().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SynchronizationType.Reaction.Action }
         * 
         * 
         */
        public List<SynchronizationType.Reaction.Action> getAction() {
            if (action == null) {
                action = new ArrayList<SynchronizationType.Reaction.Action>();
            }
            return this.action;
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
                SynchronizationSituationType theSituation;
                theSituation = this.getSituation();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "situation", theSituation), currentHashCode, theSituation);
            }
            {
                List<SynchronizationType.Reaction.Action> theAction;
                theAction = (((this.action!= null)&&(!this.action.isEmpty()))?this.getAction():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "action", theAction), currentHashCode, theAction);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = new com.evolveum.midpoint.schema.DomAwareHashCodeStrategy();
            return this.hashCode(null, strategy);
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof SynchronizationType.Reaction)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final SynchronizationType.Reaction that = ((SynchronizationType.Reaction) object);
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
                SynchronizationSituationType lhsSituation;
                lhsSituation = this.getSituation();
                SynchronizationSituationType rhsSituation;
                rhsSituation = that.getSituation();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "situation", lhsSituation), LocatorUtils.property(thatLocator, "situation", rhsSituation), lhsSituation, rhsSituation)) {
                    return false;
                }
            }
            {
                List<SynchronizationType.Reaction.Action> lhsAction;
                lhsAction = (((this.action!= null)&&(!this.action.isEmpty()))?this.getAction():null);
                List<SynchronizationType.Reaction.Action> rhsAction;
                rhsAction = (((that.action!= null)&&(!that.action.isEmpty()))?that.getAction():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "action", lhsAction), LocatorUtils.property(thatLocator, "action", rhsAction), lhsAction, rhsAction)) {
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
         *         &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "any"
        })
        public static class Action
            implements Serializable, Equals, HashCode
        {

            private final static long serialVersionUID = 201105211233L;
            @XmlAnyElement(lax = true)
            protected List<Object> any;
            @XmlAttribute(name = "ref")
            @XmlSchemaType(name = "anyURI")
            protected String ref;

            /**
             * Gets the value of the any property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the any property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getAny().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Element }
             * {@link Object }
             * 
             * 
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
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRef() {
                return ref;
            }

            /**
             * Sets the value of the ref property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRef(String value) {
                this.ref = value;
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
                    List<Object> theAny;
                    theAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "any", theAny), currentHashCode, theAny);
                }
                {
                    String theRef;
                    theRef = this.getRef();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ref", theRef), currentHashCode, theRef);
                }
                return currentHashCode;
            }

            public int hashCode() {
                final HashCodeStrategy strategy = new com.evolveum.midpoint.schema.DomAwareHashCodeStrategy();
                return this.hashCode(null, strategy);
            }

            public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
                if (!(object instanceof SynchronizationType.Reaction.Action)) {
                    return false;
                }
                if (this == object) {
                    return true;
                }
                final SynchronizationType.Reaction.Action that = ((SynchronizationType.Reaction.Action) object);
                {
                    List<Object> lhsAny;
                    lhsAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
                    List<Object> rhsAny;
                    rhsAny = (((that.any!= null)&&(!that.any.isEmpty()))?that.getAny():null);
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "any", lhsAny), LocatorUtils.property(thatLocator, "any", rhsAny), lhsAny, rhsAny)) {
                        return false;
                    }
                }
                {
                    String lhsRef;
                    lhsRef = this.getRef();
                    String rhsRef;
                    rhsRef = that.getRef();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "ref", lhsRef), LocatorUtils.property(thatLocator, "ref", rhsRef), lhsRef, rhsRef)) {
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
