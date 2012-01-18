package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for PropertyNoValueFilterType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PropertyNoValueFilterType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}FilterType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}property"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyNoValueFilterType", propOrder = {
        "property"
})
public class PropertyNoValueFilterType
        extends FilterType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlAnyElement
    protected Element property;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "PropertyNoValueFilterType");
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
