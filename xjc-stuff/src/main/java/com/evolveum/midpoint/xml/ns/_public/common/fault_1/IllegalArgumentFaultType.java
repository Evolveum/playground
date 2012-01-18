package com.evolveum.midpoint.xml.ns._public.common.fault_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Argument provided to the operation is illegal.
 * E.g. mandatory argument is null or empty, the
 * argument does not
 * conform to the required format, etc.
 * <p/>
 * <p/>
 * <p>Java class for IllegalArgumentFaultType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="IllegalArgumentFaultType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl}FaultType">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IllegalArgumentFaultType")
public class IllegalArgumentFaultType
        extends FaultType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    public final static QName COMPLEX_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "IllegalArgumentFaultType");

}
