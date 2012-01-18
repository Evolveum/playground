package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * TODO
 * <p/>
 * <p/>
 * <p>Java class for ModelHooksType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ModelHooksType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="change" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}HookListType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModelHooksType", propOrder = {
        "change"
})
public class ModelHooksType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected HookListType change;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ModelHooksType");
    public final static QName F_CHANGE = new QName(SchemaConstants.NS_COMMON, "change");

    /**
     * Gets the value of the change property.
     *
     * @return possible object is
     *         {@link HookListType }
     */
    public HookListType getChange() {
        return change;
    }

    /**
     * Sets the value of the change property.
     *
     * @param value allowed object is
     *              {@link HookListType }
     */
    public void setChange(HookListType value) {
        this.change = value;
    }

}
