package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Property container reference. Selects exactly one XML element
 * that holds properties. Subtypes of property container
 * reference describe properties in the object instances, but they
 * use native reference to the specific property (e.g.
 * QName or XML elements using xsd:any type).
 * For example by describing change to the
 * property, available values for the property, etc.
 * <p/>
 * <p/>
 * <p>Java class for PropertyContainerReferenceType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PropertyContainerReferenceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}path" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyContainerReferenceType", propOrder = {
        "path"
})
@XmlSeeAlso({
        PropertyModificationType.class
})
public class PropertyContainerReferenceType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlAnyElement
    protected Element path;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "PropertyContainerReferenceType");
    public final static QName F_PATH = new QName(SchemaConstants.NS_COMMON, "path");

    /**
     * Gets the value of the path property.
     *
     * @return possible object is
     *         {@link Element }
     */
    public Element getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     *
     * @param value allowed object is
     *              {@link Element }
     */
    public void setPath(Element value) {
        this.path = value;
    }

}
