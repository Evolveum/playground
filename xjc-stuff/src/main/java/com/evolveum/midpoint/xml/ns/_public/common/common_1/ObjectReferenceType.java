package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Reference to an object. It contains OID of the object that it
 * refers to.
 * <p/>
 * <p/>
 * <p>Java class for ObjectReferenceType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ObjectReferenceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}description" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}filter" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="oid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObjectReferenceType", propOrder = {
        "description",
        "filter"
})
public class ObjectReferenceType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected String description;
    @XmlAnyElement
    protected Element filter;
    @XmlAttribute(name = "oid")
    protected String oid;
    @XmlAttribute(name = "type")
    protected QName type;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ObjectReferenceType");
    public final static QName F_DESCRIPTION = new QName(SchemaConstants.NS_COMMON, "description");
    public final static QName F_FILTER = new QName(SchemaConstants.NS_COMMON, "filter");
    public final static QName F_TYPE = new QName(SchemaConstants.NS_COMMON, "type");

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Filter that can be used to dynamically lookup the reference OID e.g. during imports.
     * It must not be used for normal operations and references with the filter must not
     * be stored in the repository.
     *
     * @return possible object is
     *         {@link Element }
     */
    public Element getFilter() {
        return filter;
    }

    /**
     * Sets the value of the filter property.
     *
     * @param value allowed object is
     *              {@link Element }
     */
    public void setFilter(Element value) {
        this.filter = value;
    }

    /**
     * Gets the value of the oid property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getOid() {
        return oid;
    }

    /**
     * Sets the value of the oid property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOid(String value) {
        this.oid = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     *         {@link QName }
     */
    public QName getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link QName }
     */
    public void setType(QName value) {
        this.type = value;
    }

}
