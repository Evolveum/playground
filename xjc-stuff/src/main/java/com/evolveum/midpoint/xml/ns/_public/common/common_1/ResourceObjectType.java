package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import com.evolveum.midpoint.schema.processorFake.PropertyContainer;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.List;


/**
 * <p>Java class for ResourceObjectType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ResourceObjectType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceObjectType", propOrder = {
        "any"
})
public class ResourceObjectType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ResourceObjectType");
    public final static QName F_ANY = new QName(SchemaConstants.NS_COMMON, "any");
    @XmlTransient
    private PropertyContainer container;

    /**
     * DO NOT USE! For testing purposes only.
     */
    @Deprecated
    public PropertyContainer getContainer() {
        if (container == null) {
            container = new PropertyContainer(COMPLEX_TYPE);
        }
        return container;
    }

    /**
     * DO NOT USE! For testing purposes only.
     */
    @Deprecated
    public void setContainer(PropertyContainer container) {
        if (container == null) {
            container = null;
            return;
        }
        if (!COMPLEX_TYPE.equals(container.getName())) {
            throw new IllegalArgumentException((((("Container qname '" + container.getName()) + "' doesn't equals to '") + COMPLEX_TYPE) + "'."));
        }
        this.container = container;
    }

    @XmlAnyElement
    public List<Element> getAny() {
        return getPropertyValues(F_ANY, Element.class);
    }

}
