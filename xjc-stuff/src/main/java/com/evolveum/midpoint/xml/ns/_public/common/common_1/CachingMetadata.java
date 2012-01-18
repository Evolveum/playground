package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Metadata that record when a cache copy was retrieved, the identifiers (etags) of that
 * copy and possibly also other data. It is used to guide cache coherence policies and
 * cache management in general.
 * <p/>
 * <p/>
 * <p>Java class for CachingMetadata complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="CachingMetadata">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="retrievalTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="serialNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CachingMetadata", propOrder = {
        "retrievalTimestamp",
        "serialNumber"
})
public class CachingMetadata implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar retrievalTimestamp;
    @XmlElement(required = true)
    protected String serialNumber;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "CachingMetadata");
    public final static QName F_RETRIEVAL_TIMESTAMP = new QName(SchemaConstants.NS_COMMON, "retrievalTimestamp");
    public final static QName F_SERIAL_NUMBER = new QName(SchemaConstants.NS_COMMON, "serialNumber");

    /**
     * Gets the value of the retrievalTimestamp property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getRetrievalTimestamp() {
        return retrievalTimestamp;
    }

    /**
     * Sets the value of the retrievalTimestamp property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setRetrievalTimestamp(XMLGregorianCalendar value) {
        this.retrievalTimestamp = value;
    }

    /**
     * Gets the value of the serialNumber property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSerialNumber(String value) {
        this.serialNumber = value;
    }

}
