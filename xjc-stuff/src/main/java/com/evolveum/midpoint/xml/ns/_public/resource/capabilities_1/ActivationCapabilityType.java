package com.evolveum.midpoint.xml.ns._public.resource.capabilities_1;

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
 * Describes capability to process activation data, which means
 * enable/disable of accounts, dates for scheduled enable/disable
 * and similar things related to make the account active.
 * <p/>
 * <p/>
 * <p>Java class for ActivationCapabilityType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ActivationCapabilityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enableDisable">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="attribute" type="{http://www.w3.org/2001/XMLSchema}QName" minOccurs="0"/>
 *                   &lt;element name="enableValue" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="disableValue" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "ActivationCapabilityType", propOrder = {
        "enableDisable"
})
public class ActivationCapabilityType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected ActivationCapabilityType.EnableDisable enableDisable;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_CAPABILITIES, "ActivationCapabilityType");
    public final static QName F_ENABLE_DISABLE = new QName(SchemaConstants.NS_CAPABILITIES, "enableDisable");

    /**
     * Gets the value of the enableDisable property.
     *
     * @return possible object is
     *         {@link ActivationCapabilityType.EnableDisable }
     */
    public ActivationCapabilityType.EnableDisable getEnableDisable() {
        return enableDisable;
    }

    /**
     * Sets the value of the enableDisable property.
     *
     * @param value allowed object is
     *              {@link ActivationCapabilityType.EnableDisable }
     */
    public void setEnableDisable(ActivationCapabilityType.EnableDisable value) {
        this.enableDisable = value;
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
     *         &lt;element name="attribute" type="{http://www.w3.org/2001/XMLSchema}QName" minOccurs="0"/>
     *         &lt;element name="enableValue" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="disableValue" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "attribute",
            "enableValue",
            "disableValue"
    })
    public static class EnableDisable
            implements Serializable {

        private final static long serialVersionUID = 201105211233L;
        protected QName attribute;
        protected List<String> enableValue;
        protected List<String> disableValue;

        /**
         * Gets the value of the attribute property.
         *
         * @return possible object is
         *         {@link QName }
         */
        public QName getAttribute() {
            return attribute;
        }

        /**
         * Sets the value of the attribute property.
         *
         * @param value allowed object is
         *              {@link QName }
         */
        public void setAttribute(QName value) {
            this.attribute = value;
        }

        /**
         * Gets the value of the enableValue property.
         * <p/>
         * <p/>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the enableValue property.
         * <p/>
         * <p/>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEnableValue().add(newItem);
         * </pre>
         * <p/>
         * <p/>
         * <p/>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         */
        public List<String> getEnableValue() {
            if (enableValue == null) {
                enableValue = new ArrayList<String>();
            }
            return this.enableValue;
        }

        /**
         * Gets the value of the disableValue property.
         * <p/>
         * <p/>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the disableValue property.
         * <p/>
         * <p/>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDisableValue().add(newItem);
         * </pre>
         * <p/>
         * <p/>
         * <p/>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         */
        public List<String> getDisableValue() {
            if (disableValue == null) {
                disableValue = new ArrayList<String>();
            }
            return this.disableValue;
        }

    }

}
