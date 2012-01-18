package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for UriFilterType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UriFilterType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}FilterType">
 *       &lt;attribute name="uri" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UriFilterType")
public class UriFilterType
        extends FilterType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected String uri;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "UriFilterType");
    public final static QName F_URI = new QName(SchemaConstants.NS_COMMON, "uri");

    /**
     * Gets the value of the uri property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUri(String value) {
        this.uri = value;
    }

}
