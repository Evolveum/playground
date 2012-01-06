
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
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
 *                 Defines how a value of a property (or attribute) should be
 *                 constructed. The value may be static or constructed as an
 *                 result of evaluating an expression.
 * 
 *                 This strucuture also defines a method how to merge several value
 *                 construction definitions, how to behave if a property already
 *                 has a value, etc.
 * 
 *                 This is reusable data structure, used in schemaHandling, roles
 *                 and it may also be used in may other places.
 * 
 *                 Motivation: We need to construct attribute or property values on
 *                 many places in midPoint. E.g. we need that in roles to generate
 *                 dynamic account attribute values, we need that to define "templates"
 *                 for identifiers and default values for attributes when creating a
 *                 new account. We also need that to specify values when creating a
 *                 new user (user templates). Having the same data structure for all of
 *                 these cases may simplify the code, as it all can be handled by a
 *                 generic library reused in many places throught the system.
 *             
 * 
 * <p>Java class for ValueConstructionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValueConstructionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}description" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}extension" minOccurs="0"/>
 *         &lt;element name="ref" type="{http://www.w3.org/2001/XMLSchema}QName" minOccurs="0"/>
 *         &lt;element name="authoritative" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="exclusive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="initial" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}stringFilter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}valueConstructor"/>
 *           &lt;element name="sequence">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}valueConstructor" maxOccurs="unbounded"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}condition" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValueConstructionType", propOrder = {
    "description",
    "extension",
    "ref",
    "authoritative",
    "exclusive",
    "initial",
    "stringFilter",
    "valueConstructor",
    "sequence",
    "condition"
})
@XmlSeeAlso({
    ScriptArgumentType.class,
    EntitlementConstructionType.class
})
public class ValueConstructionType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected String description;
    protected Extension extension;
    protected QName ref;
    @XmlElement(defaultValue = "false")
    protected Boolean authoritative;
    @XmlElement(defaultValue = "false")
    protected Boolean exclusive;
    @XmlElement(defaultValue = "false")
    protected Boolean initial;
    protected List<StringFilterType> stringFilter;
    @XmlElementRef(name = "valueConstructor", namespace = "http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", type = JAXBElement.class)
    protected JAXBElement<?> valueConstructor;
    protected ValueConstructionType.Sequence sequence;
    protected ExpressionType condition;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ValueConstructionType");

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
     * Gets the value of the authoritative property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAuthoritative() {
        return authoritative;
    }

    /**
     * Sets the value of the authoritative property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAuthoritative(Boolean value) {
        this.authoritative = value;
    }

    /**
     * Gets the value of the exclusive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExclusive() {
        return exclusive;
    }

    /**
     * Sets the value of the exclusive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExclusive(Boolean value) {
        this.exclusive = value;
    }

    /**
     * Gets the value of the initial property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInitial() {
        return initial;
    }

    /**
     * Sets the value of the initial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInitial(Boolean value) {
        this.initial = value;
    }

    /**
     * Gets the value of the stringFilter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stringFilter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStringFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StringFilterType }
     * 
     * 
     */
    public List<StringFilterType> getStringFilter() {
        if (stringFilter == null) {
            stringFilter = new ArrayList<StringFilterType>();
        }
        return this.stringFilter;
    }

    /**
     * Gets the value of the valueConstructor property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExpressionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AsIsValueConstructorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GenerateValueConstructorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getValueConstructor() {
        return valueConstructor;
    }

    /**
     * Sets the value of the valueConstructor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExpressionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AsIsValueConstructorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GenerateValueConstructorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setValueConstructor(JAXBElement<?> value) {
        this.valueConstructor = ((JAXBElement<?> ) value);
    }

    /**
     * Gets the value of the sequence property.
     * 
     * @return
     *     possible object is
     *     {@link ValueConstructionType.Sequence }
     *     
     */
    public ValueConstructionType.Sequence getSequence() {
        return sequence;
    }

    /**
     * Sets the value of the sequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueConstructionType.Sequence }
     *     
     */
    public void setSequence(ValueConstructionType.Sequence value) {
        this.sequence = value;
    }

    /**
     * Gets the value of the condition property.
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
            QName theRef;
            theRef = this.getRef();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ref", theRef), currentHashCode, theRef);
        }
        {
            Boolean theAuthoritative;
            theAuthoritative = this.isAuthoritative();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "authoritative", theAuthoritative), currentHashCode, theAuthoritative);
        }
        {
            Boolean theExclusive;
            theExclusive = this.isExclusive();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "exclusive", theExclusive), currentHashCode, theExclusive);
        }
        {
            Boolean theInitial;
            theInitial = this.isInitial();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "initial", theInitial), currentHashCode, theInitial);
        }
        {
            List<StringFilterType> theStringFilter;
            theStringFilter = (((this.stringFilter!= null)&&(!this.stringFilter.isEmpty()))?this.getStringFilter():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "stringFilter", theStringFilter), currentHashCode, theStringFilter);
        }
        {
            JAXBElement<?> theValueConstructor;
            theValueConstructor = this.getValueConstructor();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "valueConstructor", theValueConstructor), currentHashCode, theValueConstructor);
        }
        {
            ValueConstructionType.Sequence theSequence;
            theSequence = this.getSequence();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sequence", theSequence), currentHashCode, theSequence);
        }
        {
            ExpressionType theCondition;
            theCondition = this.getCondition();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "condition", theCondition), currentHashCode, theCondition);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new com.evolveum.midpoint.schema.DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ValueConstructionType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ValueConstructionType that = ((ValueConstructionType) object);
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
            QName lhsRef;
            lhsRef = this.getRef();
            QName rhsRef;
            rhsRef = that.getRef();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ref", lhsRef), LocatorUtils.property(thatLocator, "ref", rhsRef), lhsRef, rhsRef)) {
                return false;
            }
        }
        {
            Boolean lhsAuthoritative;
            lhsAuthoritative = this.isAuthoritative();
            Boolean rhsAuthoritative;
            rhsAuthoritative = that.isAuthoritative();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "authoritative", lhsAuthoritative), LocatorUtils.property(thatLocator, "authoritative", rhsAuthoritative), lhsAuthoritative, rhsAuthoritative)) {
                return false;
            }
        }
        {
            Boolean lhsExclusive;
            lhsExclusive = this.isExclusive();
            Boolean rhsExclusive;
            rhsExclusive = that.isExclusive();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "exclusive", lhsExclusive), LocatorUtils.property(thatLocator, "exclusive", rhsExclusive), lhsExclusive, rhsExclusive)) {
                return false;
            }
        }
        {
            Boolean lhsInitial;
            lhsInitial = this.isInitial();
            Boolean rhsInitial;
            rhsInitial = that.isInitial();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "initial", lhsInitial), LocatorUtils.property(thatLocator, "initial", rhsInitial), lhsInitial, rhsInitial)) {
                return false;
            }
        }
        {
            List<StringFilterType> lhsStringFilter;
            lhsStringFilter = (((this.stringFilter!= null)&&(!this.stringFilter.isEmpty()))?this.getStringFilter():null);
            List<StringFilterType> rhsStringFilter;
            rhsStringFilter = (((that.stringFilter!= null)&&(!that.stringFilter.isEmpty()))?that.getStringFilter():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "stringFilter", lhsStringFilter), LocatorUtils.property(thatLocator, "stringFilter", rhsStringFilter), lhsStringFilter, rhsStringFilter)) {
                return false;
            }
        }
        {
            JAXBElement<?> lhsValueConstructor;
            lhsValueConstructor = this.getValueConstructor();
            JAXBElement<?> rhsValueConstructor;
            rhsValueConstructor = that.getValueConstructor();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "valueConstructor", lhsValueConstructor), LocatorUtils.property(thatLocator, "valueConstructor", rhsValueConstructor), lhsValueConstructor, rhsValueConstructor)) {
                return false;
            }
        }
        {
            ValueConstructionType.Sequence lhsSequence;
            lhsSequence = this.getSequence();
            ValueConstructionType.Sequence rhsSequence;
            rhsSequence = that.getSequence();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sequence", lhsSequence), LocatorUtils.property(thatLocator, "sequence", rhsSequence), lhsSequence, rhsSequence)) {
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
     *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}valueConstructor" maxOccurs="unbounded"/>
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
        "valueConstructor"
    })
    public static class Sequence
        implements Serializable, Equals, HashCode
    {

        private final static long serialVersionUID = 201105211233L;
        @XmlElementRef(name = "valueConstructor", namespace = "http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", type = JAXBElement.class)
        protected List<JAXBElement<?>> valueConstructor;

        /**
         * Gets the value of the valueConstructor property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the valueConstructor property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getValueConstructor().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link JAXBElement }{@code <}{@link Object }{@code >}
         * {@link JAXBElement }{@code <}{@link ExpressionType }{@code >}
         * {@link JAXBElement }{@code <}{@link AsIsValueConstructorType }{@code >}
         * {@link JAXBElement }{@code <}{@link GenerateValueConstructorType }{@code >}
         * {@link JAXBElement }{@code <}{@link Object }{@code >}
         * 
         * 
         */
        public List<JAXBElement<?>> getValueConstructor() {
            if (valueConstructor == null) {
                valueConstructor = new ArrayList<JAXBElement<?>>();
            }
            return this.valueConstructor;
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
                List<JAXBElement<?>> theValueConstructor;
                theValueConstructor = (((this.valueConstructor!= null)&&(!this.valueConstructor.isEmpty()))?this.getValueConstructor():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "valueConstructor", theValueConstructor), currentHashCode, theValueConstructor);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = new com.evolveum.midpoint.schema.DomAwareHashCodeStrategy();
            return this.hashCode(null, strategy);
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof ValueConstructionType.Sequence)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final ValueConstructionType.Sequence that = ((ValueConstructionType.Sequence) object);
            {
                List<JAXBElement<?>> lhsValueConstructor;
                lhsValueConstructor = (((this.valueConstructor!= null)&&(!this.valueConstructor.isEmpty()))?this.getValueConstructor():null);
                List<JAXBElement<?>> rhsValueConstructor;
                rhsValueConstructor = (((that.valueConstructor!= null)&&(!that.valueConstructor.isEmpty()))?that.getValueConstructor():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "valueConstructor", lhsValueConstructor), LocatorUtils.property(thatLocator, "valueConstructor", rhsValueConstructor), lhsValueConstructor, rhsValueConstructor)) {
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
