package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * TODO
 * <p/>
 * <p/>
 * <p>Java class for HookListType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="HookListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hook" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}HookType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HookListType", propOrder = {
        "hook"
})
public class HookListType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected HookType hook;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "HookListType");
    public final static QName F_HOOK = new QName(SchemaConstants.NS_COMMON, "hook");

    /**
     * Gets the value of the hook property.
     *
     * @return possible object is
     *         {@link HookType }
     */
    public HookType getHook() {
        return hook;
    }

    /**
     * Sets the value of the hook property.
     *
     * @param value allowed object is
     *              {@link HookType }
     */
    public void setHook(HookType value) {
        this.hook = value;
    }

}
