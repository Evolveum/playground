package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import com.evolveum.midpoint.schema.processorFake.PropertyContainer;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Type that defines activation properties. Determines whether something is active
 * (and working) or inactive (e.g. disabled).
 * <p/>
 * It applies to several object types. It may apply to user, account, assignement, etc.
 * The data in this type define if the described concept is active, from when it is active
 * and until when. The "active" means that it works. If something is not active, it should
 * not work or not cause any effect. E.g. inactive user should not be able to log in or run
 * any tasks, the non-active role should not be assigned and if assigned it should not be
 * taken into account when computing the accounts.
 * <p/>
 * <p/>
 * <p>Java class for ActivationType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ActivationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="validFrom" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="validTo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivationType", propOrder = {
        "enabled",
        "validFrom",
        "validTo"
})
public class ActivationType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ActivationType");
    public final static QName F_ENABLED = new QName(SchemaConstants.NS_COMMON, "enabled");
    public final static QName F_VALID_FROM = new QName(SchemaConstants.NS_COMMON, "validFrom");
    public final static QName F_VALID_TO = new QName(SchemaConstants.NS_COMMON, "validTo");
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

    public Boolean isEnabled() {
        return getPropertyValue(F_ENABLED, Boolean.class);
    }

    public void setEnabled(Boolean value) {
        setPropertyValue(F_ENABLED, value);
    }

    @XmlSchemaType(name = "dateTime")
    public XMLGregorianCalendar getValidFrom() {
        return getPropertyValue(F_VALID_FROM, XMLGregorianCalendar.class);
    }

    public void setValidFrom(XMLGregorianCalendar value) {
        setPropertyValue(F_VALID_FROM, value);
    }

    @XmlSchemaType(name = "dateTime")
    public XMLGregorianCalendar getValidTo() {
        return getPropertyValue(F_VALID_TO, XMLGregorianCalendar.class);
    }

    public void setValidTo(XMLGregorianCalendar value) {
        setPropertyValue(F_VALID_TO, value);
    }

}
