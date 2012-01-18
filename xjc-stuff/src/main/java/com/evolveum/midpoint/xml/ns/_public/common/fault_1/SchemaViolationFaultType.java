package com.evolveum.midpoint.xml.ns._public.common.fault_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Provided object does not conform to the internal schema.
 * <p/>
 * <p/>
 * <p>Java class for SchemaViolationFaultType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SchemaViolationFaultType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl}ObjectAccessFaultType">
 *       &lt;sequence>
 *         &lt;element name="violatingPropertyName" type="{http://www.w3.org/2001/XMLSchema}QName" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SchemaViolationFaultType", propOrder = {
        "violatingPropertyName"
})
public class SchemaViolationFaultType
        extends ObjectAccessFaultType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected List<QName> violatingPropertyName;
    public final static QName COMPLEX_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "SchemaViolationFaultType");
    public final static QName F_VIOLATING_PROPERTY_NAME = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "violatingPropertyName");

    /**
     * Gets the value of the violatingPropertyName property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the violatingPropertyName property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getViolatingPropertyName().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link QName }
     */
    public List<QName> getViolatingPropertyName() {
        if (violatingPropertyName == null) {
            violatingPropertyName = new ArrayList<QName>();
        }
        return this.violatingPropertyName;
    }

}
