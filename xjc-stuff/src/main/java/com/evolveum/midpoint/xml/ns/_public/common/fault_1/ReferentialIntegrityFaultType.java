package com.evolveum.midpoint.xml.ns._public.common.fault_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Operation on an object would cause inconsistencies in referential
 * integrity. E.g. attempt to delete
 * an object that is a target of
 * existing reference.
 * <p/>
 * <p/>
 * <p>Java class for ReferentialIntegrityFaultType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ReferentialIntegrityFaultType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl}ObjectAccessFaultType">
 *       &lt;sequence>
 *         &lt;element name="referringObjectOid" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferentialIntegrityFaultType", propOrder = {
        "referringObjectOid"
})
public class ReferentialIntegrityFaultType
        extends ObjectAccessFaultType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected List<String> referringObjectOid;
    public final static QName COMPLEX_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "ReferentialIntegrityFaultType");
    public final static QName F_REFERRING_OBJECT_OID = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "referringObjectOid");

    /**
     * Gets the value of the referringObjectOid property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the referringObjectOid property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReferringObjectOid().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getReferringObjectOid() {
        if (referringObjectOid == null) {
            referringObjectOid = new ArrayList<String>();
        }
        return this.referringObjectOid;
    }

}
