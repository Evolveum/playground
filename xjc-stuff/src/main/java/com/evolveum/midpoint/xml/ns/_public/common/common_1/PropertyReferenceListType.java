package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * TODO
 * <p/>
 * <p/>
 * <p>Java class for PropertyReferenceListType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PropertyReferenceListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="property" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}PropertyReferenceType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyReferenceListType", propOrder = {
        "property"
})
public class PropertyReferenceListType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected List<PropertyReferenceType> property;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "PropertyReferenceListType");
    public final static QName F_PROPERTY = new QName(SchemaConstants.NS_COMMON, "property");

    /**
     * Gets the value of the property property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the property property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperty().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyReferenceType }
     */
    public List<PropertyReferenceType> getProperty() {
        if (property == null) {
            property = new ArrayList<PropertyReferenceType>();
        }
        return this.property;
    }

}
