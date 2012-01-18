package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * TODO
 * <p/>
 * <p/>
 * <p>Java class for HookType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="HookType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ref" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HookType", propOrder = {
        "ref"
})
public class HookType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String ref;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "HookType");
    public final static QName F_REF = new QName(SchemaConstants.NS_COMMON, "ref");

    /**
     * Gets the value of the ref property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRef(String value) {
        this.ref = value;
    }

}
