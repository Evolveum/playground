package com.evolveum.midpoint.xml.ns._public.resource.capabilities_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import com.evolveum.midpoint.xml.ns._public.common.common_1.ScriptHostType;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Describes capability to execute scripts (short pieces of program) on the connector or resource.
 * <p/>
 * <p/>
 * <p>Java class for ScriptCapabilityType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ScriptCapabilityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="host" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="type" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ScriptHostType"/>
 *                   &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "ScriptCapabilityType", propOrder = {
        "host"
})
public class ScriptCapabilityType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected List<ScriptCapabilityType.Host> host;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_CAPABILITIES, "ScriptCapabilityType");
    public final static QName F_HOST = new QName(SchemaConstants.NS_CAPABILITIES, "host");

    /**
     * Gets the value of the host property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the host property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHost().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ScriptCapabilityType.Host }
     */
    public List<ScriptCapabilityType.Host> getHost() {
        if (host == null) {
            host = new ArrayList<ScriptCapabilityType.Host>();
        }
        return this.host;
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
     *         &lt;element name="type" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ScriptHostType"/>
     *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "type",
            "language"
    })
    public static class Host
            implements Serializable {

        private final static long serialVersionUID = 201105211233L;
        @XmlElement(required = true)
        protected ScriptHostType type;
        @XmlSchemaType(name = "anyURI")
        protected List<String> language;

        /**
         * Gets the value of the type property.
         *
         * @return possible object is
         *         {@link ScriptHostType }
         */
        public ScriptHostType getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         *
         * @param value allowed object is
         *              {@link ScriptHostType }
         */
        public void setType(ScriptHostType value) {
            this.type = value;
        }

        /**
         * Gets the value of the language property.
         * <p/>
         * <p/>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the language property.
         * <p/>
         * <p/>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLanguage().add(newItem);
         * </pre>
         * <p/>
         * <p/>
         * <p/>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         */
        public List<String> getLanguage() {
            if (language == null) {
                language = new ArrayList<String>();
            }
            return this.language;
        }

    }

}
