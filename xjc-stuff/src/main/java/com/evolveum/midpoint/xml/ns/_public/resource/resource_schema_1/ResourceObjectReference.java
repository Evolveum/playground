package com.evolveum.midpoint.xml.ns._public.resource.resource_schema_1;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="targetObjectClass" type="{http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd}ObjectClassReferenceType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "targetObjectClass"
})
@XmlRootElement(name = "resourceObjectReference")
public class ResourceObjectReference
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected ObjectClassReferenceType targetObjectClass;

    /**
     * Gets the value of the targetObjectClass property.
     *
     * @return possible object is
     *         {@link ObjectClassReferenceType }
     */
    public ObjectClassReferenceType getTargetObjectClass() {
        return targetObjectClass;
    }

    /**
     * Sets the value of the targetObjectClass property.
     *
     * @param value allowed object is
     *              {@link ObjectClassReferenceType }
     */
    public void setTargetObjectClass(ObjectClassReferenceType value) {
        this.targetObjectClass = value;
    }

}
