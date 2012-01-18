package com.evolveum.midpoint.xml.ns._public.common.common_1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Object list, to be used in import files and
 * examples.
 * <p/>
 * <p/>
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}object" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "object"
})
@XmlRootElement(name = "objects")
public class Objects
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElementRef(name = "object", namespace = "http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", type = JAXBElement.class)
    protected List<JAXBElement<? extends ObjectType>> object;

    /**
     * Gets the value of the object property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the object property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObject().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link RoleType }{@code >}
     * {@link JAXBElement }{@code <}{@link TaskType }{@code >}
     * {@link JAXBElement }{@code <}{@link ConnectorHostType }{@code >}
     * {@link JAXBElement }{@code <}{@link UserType }{@code >}
     * {@link JAXBElement }{@code <}{@link AccountShadowType }{@code >}
     * {@link JAXBElement }{@code <}{@link GenericObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link ConnectorType }{@code >}
     * {@link JAXBElement }{@code <}{@link ResourceObjectShadowType }{@code >}
     * {@link JAXBElement }{@code <}{@link UserTemplateType }{@code >}
     * {@link JAXBElement }{@code <}{@link ObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link ResourceType }{@code >}
     */
    public List<JAXBElement<? extends ObjectType>> getObject() {
        if (object == null) {
            object = new ArrayList<JAXBElement<? extends ObjectType>>();
        }
        return this.object;
    }

}
