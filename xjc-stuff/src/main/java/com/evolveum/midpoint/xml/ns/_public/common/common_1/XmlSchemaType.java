package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * This element contains the XSD-formatted definition of schema.
 * <p/>
 * The schema available in this definition is expeceted to comply
 * to the usual midPoint schema structure (properties, property
 * containers), although it should not contain objects (persistent
 * objects identified by OID).
 * <p/>
 * Note: This schema is considered to be available only in run-time.
 * Therefore code-generation methods such as JAXB cannot be applied
 * here.
 * <p/>
 * Note: xsd:any is here, but maybe a stricter type would be preferable.
 * However xsd:any seems to be a common practice (e.g. SPML, WSDL).
 * <p/>
 * <p/>
 * <p>Java class for XmlSchemaType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="XmlSchemaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}cachingMetadata" minOccurs="0"/>
 *         &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlSchemaType", propOrder = {
        "cachingMetadata",
        "any"
})
public class XmlSchemaType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected CachingMetadata cachingMetadata;
    @XmlAnyElement
    protected List<Element> any;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "XmlSchemaType");
    public final static QName F_CACHING_METADATA = new QName(SchemaConstants.NS_COMMON, "cachingMetadata");
    public final static QName F_ANY = new QName(SchemaConstants.NS_COMMON, "any");

    /**
     * Gets the value of the cachingMetadata property.
     *
     * @return possible object is
     *         {@link CachingMetadata }
     */
    public CachingMetadata getCachingMetadata() {
        return cachingMetadata;
    }

    /**
     * Sets the value of the cachingMetadata property.
     *
     * @param value allowed object is
     *              {@link CachingMetadata }
     */
    public void setCachingMetadata(CachingMetadata value) {
        this.cachingMetadata = value;
    }

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
     * {@link Element }
     */
    public List<Element> getAny() {
        if (any == null) {
            any = new ArrayList<Element>();
        }
        return this.any;
    }

}
