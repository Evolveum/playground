package com.evolveum.midpoint.xml.ns._public.common.common_1;

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
 * Describes a change of attributes of a specific object.
 * All changes are expected to happen atomically, but
 * there may be exceptions. Please check with the
 * documentation of the interface using this type for
 * more details.
 * <p/>
 * This should probably go to some kind of common schema.
 * <p/>
 * <p/>
 * <p>Java class for ObjectModificationType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ObjectModificationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}propertyModification" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObjectModificationType", propOrder = {
        "oid",
        "propertyModification"
})
public class ObjectModificationType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected String oid;
    @XmlElement(required = true)
    protected List<PropertyModificationType> propertyModification;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ObjectModificationType");
    public final static QName F_PROPERTY_MODIFICATION = new QName(SchemaConstants.NS_COMMON, "propertyModification");

    /**
     * Gets the value of the oid property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getOid() {
        return oid;
    }

    /**
     * Sets the value of the oid property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOid(String value) {
        this.oid = value;
    }

    /**
     * Describe a change to a single attribute of an object.
     * Gets the value of the propertyModification property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propertyModification property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropertyModification().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyModificationType }
     */
    public List<PropertyModificationType> getPropertyModification() {
        if (propertyModification == null) {
            propertyModification = new ArrayList<PropertyModificationType>();
        }
        return this.propertyModification;
    }

}
