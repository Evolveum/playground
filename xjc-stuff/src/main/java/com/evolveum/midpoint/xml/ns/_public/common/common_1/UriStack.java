package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * A stack of URIs (used e.g. for managing a stack of handlers to be called when a task is to be run).
 * Last URI is considered to be the top of the stack (i.e. the one that will be retrieved first).
 * EXPERIMENTAL. This type may change.
 * <p/>
 * <p/>
 * <p>Java class for UriStack complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UriStack">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UriStack", propOrder = {
        "uri"
})
public class UriStack implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlSchemaType(name = "anyURI")
    protected List<String> uri;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "UriStack");
    public final static QName F_URI = new QName(SchemaConstants.NS_COMMON, "uri");

    /**
     * Gets the value of the uri property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uri property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUri().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getUri() {
        if (uri == null) {
            uri = new ArrayList<String>();
        }
        return this.uri;
    }

}
