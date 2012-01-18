package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Defines how a value of a property (or attribute) should be
 * constructed. The value may be static or constructed as an
 * result of evaluating an expression.
 * <p/>
 * This strucuture also defines a method how to merge several value
 * construction definitions, how to behave if a property already
 * has a value, etc.
 * <p/>
 * This is reusable data structure, used in schemaHandling, roles
 * and it may also be used in may other places.
 * <p/>
 * Motivation: We need to construct attribute or property values on
 * many places in midPoint. E.g. we need that in roles to generate
 * dynamic account attribute values, we need that to define "templates"
 * for identifiers and default values for attributes when creating a
 * new account. We also need that to specify values when creating a
 * new user (user templates). Having the same data structure for all of
 * these cases may simplify the code, as it all can be handled by a
 * generic library reused in many places throught the system.
 * <p/>
 * <p/>
 * <p>Java class for ValueConstructionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
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
public class ValueConstructionType implements Serializable {

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
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ValueConstructionType");
    public final static QName F_DESCRIPTION = new QName(SchemaConstants.NS_COMMON, "description");
    public final static QName F_EXTENSION = new QName(SchemaConstants.NS_COMMON, "extension");
    public final static QName F_REF = new QName(SchemaConstants.NS_COMMON, "ref");
    public final static QName F_AUTHORITATIVE = new QName(SchemaConstants.NS_COMMON, "authoritative");
    public final static QName F_EXCLUSIVE = new QName(SchemaConstants.NS_COMMON, "exclusive");
    public final static QName F_INITIAL = new QName(SchemaConstants.NS_COMMON, "initial");
    public final static QName F_STRING_FILTER = new QName(SchemaConstants.NS_COMMON, "stringFilter");
    public final static QName F_VALUE_CONSTRUCTOR = new QName(SchemaConstants.NS_COMMON, "valueConstructor");
    public final static QName F_SEQUENCE = new QName(SchemaConstants.NS_COMMON, "sequence");
    public final static QName F_CONDITION = new QName(SchemaConstants.NS_COMMON, "condition");

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
     * Gets the value of the authoritative property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isAuthoritative() {
        return authoritative;
    }

    /**
     * Sets the value of the authoritative property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setAuthoritative(Boolean value) {
        this.authoritative = value;
    }

    /**
     * Gets the value of the exclusive property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isExclusive() {
        return exclusive;
    }

    /**
     * Sets the value of the exclusive property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setExclusive(Boolean value) {
        this.exclusive = value;
    }

    /**
     * Gets the value of the initial property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isInitial() {
        return initial;
    }

    /**
     * Sets the value of the initial property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setInitial(Boolean value) {
        this.initial = value;
    }

    /**
     * Gets the value of the stringFilter property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stringFilter property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStringFilter().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link StringFilterType }
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
     * @return possible object is
     *         {@link JAXBElement }{@code <}{@link ExpressionType }{@code >}
     *         {@link JAXBElement }{@code <}{@link AsIsValueConstructorType }{@code >}
     *         {@link JAXBElement }{@code <}{@link Object }{@code >}
     *         {@link JAXBElement }{@code <}{@link Object }{@code >}
     *         {@link JAXBElement }{@code <}{@link GenerateValueConstructorType }{@code >}
     */
    public JAXBElement<?> getValueConstructor() {
        return valueConstructor;
    }

    /**
     * Sets the value of the valueConstructor property.
     *
     * @param value allowed object is
     *              {@link JAXBElement }{@code <}{@link ExpressionType }{@code >}
     *              {@link JAXBElement }{@code <}{@link AsIsValueConstructorType }{@code >}
     *              {@link JAXBElement }{@code <}{@link Object }{@code >}
     *              {@link JAXBElement }{@code <}{@link Object }{@code >}
     *              {@link JAXBElement }{@code <}{@link GenerateValueConstructorType }{@code >}
     */
    public void setValueConstructor(JAXBElement<?> value) {
        this.valueConstructor = ((JAXBElement<?>) value);
    }

    /**
     * Gets the value of the sequence property.
     *
     * @return possible object is
     *         {@link ValueConstructionType.Sequence }
     */
    public ValueConstructionType.Sequence getSequence() {
        return sequence;
    }

    /**
     * Sets the value of the sequence property.
     *
     * @param value allowed object is
     *              {@link ValueConstructionType.Sequence }
     */
    public void setSequence(ValueConstructionType.Sequence value) {
        this.sequence = value;
    }

    /**
     * Gets the value of the condition property.
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
     * <p>Java class for anonymous complex type.
     * <p/>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p/>
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
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "valueConstructor"
    })
    public static class Sequence
            implements Serializable {

        private final static long serialVersionUID = 201105211233L;
        @XmlElementRef(name = "valueConstructor", namespace = "http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", type = JAXBElement.class)
        protected List<JAXBElement<?>> valueConstructor;

        /**
         * Gets the value of the valueConstructor property.
         * <p/>
         * <p/>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the valueConstructor property.
         * <p/>
         * <p/>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getValueConstructor().add(newItem);
         * </pre>
         * <p/>
         * <p/>
         * <p/>
         * Objects of the following type(s) are allowed in the list
         * {@link JAXBElement }{@code <}{@link ExpressionType }{@code >}
         * {@link JAXBElement }{@code <}{@link AsIsValueConstructorType }{@code >}
         * {@link JAXBElement }{@code <}{@link Object }{@code >}
         * {@link JAXBElement }{@code <}{@link Object }{@code >}
         * {@link JAXBElement }{@code <}{@link GenerateValueConstructorType }{@code >}
         */
        public List<JAXBElement<?>> getValueConstructor() {
            if (valueConstructor == null) {
                valueConstructor = new ArrayList<JAXBElement<?>>();
            }
            return this.valueConstructor;
        }

    }

}
