package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Describe a change to a single attribute.
 * In this case the path expression used in the "property"
 * attribute must select exactly one property.
 * <p/>
 * <p/>
 * <p>Java class for PropertyModificationType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PropertyModificationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}PropertyContainerReferenceType">
 *       &lt;sequence>
 *         &lt;element name="value">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="modificationType" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}PropertyModificationTypeType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyModificationType", propOrder = {
        "value"
})
public class PropertyModificationType
        extends PropertyContainerReferenceType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected PropertyModificationType.Value value;
    @XmlAttribute(name = "modificationType")
    protected PropertyModificationTypeType modificationType;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "PropertyModificationType");
    public final static QName F_VALUE = new QName(SchemaConstants.NS_COMMON, "value");
    public final static QName F_MODIFICATION_TYPE = new QName(SchemaConstants.NS_COMMON, "modificationType");

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     *         {@link PropertyModificationType.Value }
     */
    public PropertyModificationType.Value getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link PropertyModificationType.Value }
     */
    public void setValue(PropertyModificationType.Value value) {
        this.value = value;
    }

    /**
     * Gets the value of the modificationType property.
     *
     * @return possible object is
     *         {@link PropertyModificationTypeType }
     */
    public PropertyModificationTypeType getModificationType() {
        return modificationType;
    }

    /**
     * Sets the value of the modificationType property.
     *
     * @param value allowed object is
     *              {@link PropertyModificationTypeType }
     */
    public void setModificationType(PropertyModificationTypeType value) {
        this.modificationType = value;
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
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "any"
    })
    public static class Value
            implements Serializable {

        private final static long serialVersionUID = 201105211233L;
        @XmlAnyElement(lax = true)
        protected List<Object> any;

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

    }

}
