package com.evolveum.midpoint.xml.ns._public.common.fault_1;

import com.evolveum.midpoint.xml.ns._public.common.common_1.OperationResultType;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for FaultType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="FaultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="operationResult" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}OperationResultType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaultType", propOrder = {
        "message",
        "operationResult"
})
@XmlSeeAlso({
        UnsupportedOperationFaultType.class,
        SystemFaultType.class,
        IllegalArgumentFaultType.class,
        ObjectAccessFaultType.class
})
public abstract class FaultType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected String message;
    @XmlElement(required = true)
    protected OperationResultType operationResult;
    public final static QName COMPLEX_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "FaultType");
    public final static QName F_MESSAGE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "message");
    public final static QName F_OPERATION_RESULT = new QName("http://midpoint.evolveum.com/xml/ns/public/common/fault-1.wsdl", "operationResult");

    /**
     * Gets the value of the message property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the operationResult property.
     *
     * @return possible object is
     *         {@link OperationResultType }
     */
    public OperationResultType getOperationResult() {
        return operationResult;
    }

    /**
     * Sets the value of the operationResult property.
     *
     * @param value allowed object is
     *              {@link OperationResultType }
     */
    public void setOperationResult(OperationResultType value) {
        this.operationResult = value;
    }

}
