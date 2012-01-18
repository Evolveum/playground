package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * TODO
 * <p/>
 * <p/>
 * <p>Java class for OperationResultType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="OperationResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="operation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}OperationResultStatusType"/>
 *         &lt;element name="params" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ParamsType" minOccurs="0"/>
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="messageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="localizedMessage" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}LocalizedMessageType" minOccurs="0"/>
 *         &lt;element name="details" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partialResults" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}OperationResultType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationResultType", propOrder = {
        "operation",
        "status",
        "params",
        "token",
        "messageCode",
        "message",
        "localizedMessage",
        "details",
        "partialResults"
})
public class OperationResultType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected String operation;
    @XmlElement(required = true)
    protected OperationResultStatusType status;
    protected ParamsType params;
    protected Long token;
    protected String messageCode;
    protected String message;
    protected LocalizedMessageType localizedMessage;
    protected String details;
    protected List<OperationResultType> partialResults;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "OperationResultType");
    public final static QName F_OPERATION = new QName(SchemaConstants.NS_COMMON, "operation");
    public final static QName F_STATUS = new QName(SchemaConstants.NS_COMMON, "status");
    public final static QName F_PARAMS = new QName(SchemaConstants.NS_COMMON, "params");
    public final static QName F_TOKEN = new QName(SchemaConstants.NS_COMMON, "token");
    public final static QName F_MESSAGE_CODE = new QName(SchemaConstants.NS_COMMON, "messageCode");
    public final static QName F_MESSAGE = new QName(SchemaConstants.NS_COMMON, "message");
    public final static QName F_LOCALIZED_MESSAGE = new QName(SchemaConstants.NS_COMMON, "localizedMessage");
    public final static QName F_DETAILS = new QName(SchemaConstants.NS_COMMON, "details");
    public final static QName F_PARTIAL_RESULTS = new QName(SchemaConstants.NS_COMMON, "partialResults");

    /**
     * Gets the value of the operation property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOperation(String value) {
        this.operation = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is
     *         {@link OperationResultStatusType }
     */
    public OperationResultStatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is
     *              {@link OperationResultStatusType }
     */
    public void setStatus(OperationResultStatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the params property.
     *
     * @return possible object is
     *         {@link ParamsType }
     */
    public ParamsType getParams() {
        return params;
    }

    /**
     * Sets the value of the params property.
     *
     * @param value allowed object is
     *              {@link ParamsType }
     */
    public void setParams(ParamsType value) {
        this.params = value;
    }

    /**
     * Gets the value of the token property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setToken(Long value) {
        this.token = value;
    }

    /**
     * Gets the value of the messageCode property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getMessageCode() {
        return messageCode;
    }

    /**
     * Sets the value of the messageCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMessageCode(String value) {
        this.messageCode = value;
    }

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
     * Gets the value of the localizedMessage property.
     *
     * @return possible object is
     *         {@link LocalizedMessageType }
     */
    public LocalizedMessageType getLocalizedMessage() {
        return localizedMessage;
    }

    /**
     * Sets the value of the localizedMessage property.
     *
     * @param value allowed object is
     *              {@link LocalizedMessageType }
     */
    public void setLocalizedMessage(LocalizedMessageType value) {
        this.localizedMessage = value;
    }

    /**
     * Gets the value of the details property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDetails(String value) {
        this.details = value;
    }

    /**
     * Gets the value of the partialResults property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partialResults property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartialResults().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link OperationResultType }
     */
    public List<OperationResultType> getPartialResults() {
        if (partialResults == null) {
            partialResults = new ArrayList<OperationResultType>();
        }
        return this.partialResults;
    }

}
