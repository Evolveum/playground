package com.evolveum.midpoint.xml.ns._public.common.common;

import com.evolveum.midpoint.schema.SchemaConstants;
import com.evolveum.midpoint.schema.XmlUtil;
import com.evolveum.midpoint.schema.processor.PropertyContainer;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.io.Serializable;

@Entity
@Table(name = "activation")
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

    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Transient
    public PropertyContainer getContainer() {
        if (container == null) {
            container = new PropertyContainer(COMPLEX_TYPE);
        }
        return container;
    }

    public void setContainer(PropertyContainer container) {
        if (container == null) {
            container = null;
            return;
        }
        if (!COMPLEX_TYPE.equals(container.getName())) {
            throw new IllegalArgumentException((((("Container qname '" + container.getName())
                    + "' doesn't equals to '") + COMPLEX_TYPE) + "'."));
        }
        this.container = container;
    }

    public Boolean isEnabled() {
        return XmlUtil.getPropertyValue(getContainer(), F_ENABLED, Boolean.class);
    }

    public void setEnabled(Boolean value) {
        XmlUtil.setPropertyValue(getContainer(), F_ENABLED, value);
    }

    //    @Type(type = )
    @XmlSchemaType(name = "dateTime")
    public XMLGregorianCalendar getValidFrom() {
        return XmlUtil.getPropertyValue(getContainer(), F_VALID_FROM, XMLGregorianCalendar.class);
    }

    public void setValidFrom(XMLGregorianCalendar value) {
        XmlUtil.setPropertyValue(getContainer(), F_VALID_FROM, value);
    }

    @XmlSchemaType(name = "dateTime")
    public XMLGregorianCalendar getValidTo() {
        return XmlUtil.getPropertyValue(getContainer(), F_VALID_TO, XMLGregorianCalendar.class);
    }

    public void setValidTo(XMLGregorianCalendar value) {
        XmlUtil.setPropertyValue(getContainer(), F_VALID_TO, value);
    }

}
