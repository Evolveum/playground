
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import com.evolveum.midpoint.schema.DomAwareEqualsStrategy;
import com.evolveum.midpoint.schema.DomAwareHashCodeStrategy;
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
 *                 This element contains the XSD-formatted definition
 *                 of schema.
 * 
 *                 The schema available in this
 *                 definition is
 *                 expeceted to
 *                 comply
 *                 to the usual midPoint schema structure (properties,
 *                 property
 *                 containers), although it
 *                 should not contain
 *                 objects (persistent
 *                 objects identified by OID).
 * 
 *                 Note: This schema is considered to be
 *                 available
 *                 only in run-time.
 *                 Therefore
 *                 code-generation methods such as
 *                 JAXB cannot be
 *                 applied
 *                 here.
 * 
 *                 Note: xsd:any is here, but
 *                 maybe a stricter
 *                 type would be
 *                 preferable.
 *                 However xsd:any seems to be a common
 *                 practice
 *                 (e.g. SPML, WSDL).
 *             
 * 
 * <p>Java class for XmlSchemaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
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
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlSchemaType", propOrder = {
    "cachingMetadata",
    "any"
})
public class XmlSchemaType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected CachingMetadata cachingMetadata;
    @XmlAnyElement
    protected List<Element> any;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "XmlSchemaType");

    /**
     * Gets the value of the cachingMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link CachingMetadata }
     *     
     */
    public CachingMetadata getCachingMetadata() {
        return cachingMetadata;
    }

    /**
     * Sets the value of the cachingMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link CachingMetadata }
     *     
     */
    public void setCachingMetadata(CachingMetadata value) {
        this.cachingMetadata = value;
    }

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
     * 
     * 
     */
    public List<Element> getAny() {
        if (any == null) {
            any = new ArrayList<Element>();
        }
        return this.any;
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
            CachingMetadata theCachingMetadata;
            theCachingMetadata = this.getCachingMetadata();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cachingMetadata", theCachingMetadata), currentHashCode, theCachingMetadata);
        }
        {
            List<Element> theAny;
            theAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "any", theAny), currentHashCode, theAny);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof XmlSchemaType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final XmlSchemaType that = ((XmlSchemaType) object);
        {
            CachingMetadata lhsCachingMetadata;
            lhsCachingMetadata = this.getCachingMetadata();
            CachingMetadata rhsCachingMetadata;
            rhsCachingMetadata = that.getCachingMetadata();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cachingMetadata", lhsCachingMetadata), LocatorUtils.property(thatLocator, "cachingMetadata", rhsCachingMetadata), lhsCachingMetadata, rhsCachingMetadata)) {
                return false;
            }
        }
        {
            List<Element> lhsAny;
            lhsAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
            List<Element> rhsAny;
            rhsAny = (((that.any!= null)&&(!that.any.isEmpty()))?that.getAny():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "any", lhsAny), LocatorUtils.property(thatLocator, "any", rhsAny), lhsAny, rhsAny)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = new DomAwareEqualsStrategy();
        return equals(null, null, object, strategy);
    }

}
