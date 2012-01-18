package com.evolveum.midpoint.xml.ns._public.common.fault_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Object with specified criteria (OID) already exists in the
 * repository.
 * <p/>
 * <p/>
 * <p>Java class for ObjectAlreadyExistsFaultType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ObjectAlreadyExistsFaultType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl}ObjectAccessFaultType">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObjectAlreadyExistsFaultType")
public class ObjectAlreadyExistsFaultType
        extends ObjectAccessFaultType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    public final static QName COMPLEX_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "ObjectAlreadyExistsFaultType");

}
