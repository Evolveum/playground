package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Describe available or proposed values of an attribute.
 * <p/>
 * <p/>
 * <p>Java class for PropertyAvailableValuesType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PropertyAvailableValuesType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}PropertyReferenceType">
 *       &lt;sequence>
 *         &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="closed" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyAvailableValuesType", propOrder = {
        "any"
})
public class PropertyAvailableValuesType
        extends PropertyReferenceType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlAnyElement
    protected List<Element> any;
    @XmlAttribute(name = "closed")
    protected Boolean closed;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "PropertyAvailableValuesType");
    public final static QName F_ANY = new QName(SchemaConstants.NS_COMMON, "any");
    public final static QName F_CLOSED = new QName(SchemaConstants.NS_COMMON, "closed");

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

    /**
     * Gets the value of the closed property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isClosed() {
        return closed;
    }

    /**
     * Sets the value of the closed property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setClosed(Boolean value) {
        this.closed = value;
    }

}
