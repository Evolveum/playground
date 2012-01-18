package com.evolveum.midpoint.xml.ns._public.common.annotation_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * TODO
 * <p/>
 * <p/>
 * <p>Java class for ExtensionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ExtensionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtensionType")
public class ExtensionType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlAttribute(name = "ref")
    protected QName ref;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_ANNOTATION, "ExtensionType");
    public final static QName F_REF = new QName(SchemaConstants.NS_ANNOTATION, "ref");

    /**
     * Gets the value of the ref property.
     *
     * @return possible object is
     *         {@link QName }
     */
    public QName getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     *
     * @param value allowed object is
     *              {@link QName }
     */
    public void setRef(QName value) {
        this.ref = value;
    }

}
