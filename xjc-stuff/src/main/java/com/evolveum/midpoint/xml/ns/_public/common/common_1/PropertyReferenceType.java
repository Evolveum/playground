package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Property reference. Selects one or more properties in the
 * object instance documents. Subtypes of property reference
 * describe properties in the object instances. For example by
 * describing change to the property, available values
 * for the property, etc.
 * <p/>
 * <p/>
 * <p>Java class for PropertyReferenceType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PropertyReferenceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}property"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyReferenceType", propOrder = {
        "property"
})
@XmlSeeAlso({
        PropertyConstructionType.class,
        PropertyAvailableValuesType.class
})
public class PropertyReferenceType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlAnyElement
    protected Element property;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "PropertyReferenceType");
    public final static QName F_PROPERTY = new QName(SchemaConstants.NS_COMMON, "property");

    /**
     * Gets the value of the property property.
     *
     * @return possible object is
     *         {@link Element }
     */
    public Element getProperty() {
        return property;
    }

    /**
     * Sets the value of the property property.
     *
     * @param value allowed object is
     *              {@link Element }
     */
    public void setProperty(Element value) {
        this.property = value;
    }

}
