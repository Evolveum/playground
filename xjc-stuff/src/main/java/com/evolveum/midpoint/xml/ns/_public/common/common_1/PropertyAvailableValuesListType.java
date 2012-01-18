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
 * <p>Java class for PropertyAvailableValuesListType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PropertyAvailableValuesListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="availableValues" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}PropertyAvailableValuesType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyAvailableValuesListType", propOrder = {
        "availableValues"
})
public class PropertyAvailableValuesListType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected List<PropertyAvailableValuesType> availableValues;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "PropertyAvailableValuesListType");
    public final static QName F_AVAILABLE_VALUES = new QName(SchemaConstants.NS_COMMON, "availableValues");

    /**
     * Gets the value of the availableValues property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the availableValues property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvailableValues().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyAvailableValuesType }
     */
    public List<PropertyAvailableValuesType> getAvailableValues() {
        if (availableValues == null) {
            availableValues = new ArrayList<PropertyAvailableValuesType>();
        }
        return this.availableValues;
    }

}
