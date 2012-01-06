
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import com.evolveum.midpoint.schema.DomAwareEqualsStrategy;
import com.evolveum.midpoint.schema.DomAwareHashCodeStrategy;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * 
 *                 TODO
 *             
 * 
 * <p>Java class for OperationResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
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
 * 
 * 
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
public class OperationResultType
    implements Serializable, Equals, HashCode
{

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
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "OperationResultType");

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperation(String value) {
        this.operation = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link OperationResultStatusType }
     *     
     */
    public OperationResultStatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationResultStatusType }
     *     
     */
    public void setStatus(OperationResultStatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the params property.
     * 
     * @return
     *     possible object is
     *     {@link ParamsType }
     *     
     */
    public ParamsType getParams() {
        return params;
    }

    /**
     * Sets the value of the params property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParamsType }
     *     
     */
    public void setParams(ParamsType value) {
        this.params = value;
    }

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setToken(Long value) {
        this.token = value;
    }

    /**
     * Gets the value of the messageCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageCode() {
        return messageCode;
    }

    /**
     * Sets the value of the messageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageCode(String value) {
        this.messageCode = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the localizedMessage property.
     * 
     * @return
     *     possible object is
     *     {@link LocalizedMessageType }
     *     
     */
    public LocalizedMessageType getLocalizedMessage() {
        return localizedMessage;
    }

    /**
     * Sets the value of the localizedMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalizedMessageType }
     *     
     */
    public void setLocalizedMessage(LocalizedMessageType value) {
        this.localizedMessage = value;
    }

    /**
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetails(String value) {
        this.details = value;
    }

    /**
     * Gets the value of the partialResults property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partialResults property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartialResults().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OperationResultType }
     * 
     * 
     */
    public List<OperationResultType> getPartialResults() {
        if (partialResults == null) {
            partialResults = new ArrayList<OperationResultType>();
        }
        return this.partialResults;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theOperation;
            theOperation = this.getOperation();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "operation", theOperation), currentHashCode, theOperation);
        }
        {
            OperationResultStatusType theStatus;
            theStatus = this.getStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "status", theStatus), currentHashCode, theStatus);
        }
        {
            ParamsType theParams;
            theParams = this.getParams();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "params", theParams), currentHashCode, theParams);
        }
        {
            Long theToken;
            theToken = this.getToken();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "token", theToken), currentHashCode, theToken);
        }
        {
            String theMessageCode;
            theMessageCode = this.getMessageCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "messageCode", theMessageCode), currentHashCode, theMessageCode);
        }
        {
            String theMessage;
            theMessage = this.getMessage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "message", theMessage), currentHashCode, theMessage);
        }
        {
            LocalizedMessageType theLocalizedMessage;
            theLocalizedMessage = this.getLocalizedMessage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "localizedMessage", theLocalizedMessage), currentHashCode, theLocalizedMessage);
        }
        {
            String theDetails;
            theDetails = this.getDetails();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "details", theDetails), currentHashCode, theDetails);
        }
        {
            List<OperationResultType> thePartialResults;
            thePartialResults = (((this.partialResults!= null)&&(!this.partialResults.isEmpty()))?this.getPartialResults():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "partialResults", thePartialResults), currentHashCode, thePartialResults);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof OperationResultType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final OperationResultType that = ((OperationResultType) object);
        {
            String lhsOperation;
            lhsOperation = this.getOperation();
            String rhsOperation;
            rhsOperation = that.getOperation();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "operation", lhsOperation), LocatorUtils.property(thatLocator, "operation", rhsOperation), lhsOperation, rhsOperation)) {
                return false;
            }
        }
        {
            OperationResultStatusType lhsStatus;
            lhsStatus = this.getStatus();
            OperationResultStatusType rhsStatus;
            rhsStatus = that.getStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "status", lhsStatus), LocatorUtils.property(thatLocator, "status", rhsStatus), lhsStatus, rhsStatus)) {
                return false;
            }
        }
        {
            ParamsType lhsParams;
            lhsParams = this.getParams();
            ParamsType rhsParams;
            rhsParams = that.getParams();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "params", lhsParams), LocatorUtils.property(thatLocator, "params", rhsParams), lhsParams, rhsParams)) {
                return false;
            }
        }
        {
            Long lhsToken;
            lhsToken = this.getToken();
            Long rhsToken;
            rhsToken = that.getToken();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "token", lhsToken), LocatorUtils.property(thatLocator, "token", rhsToken), lhsToken, rhsToken)) {
                return false;
            }
        }
        {
            String lhsMessageCode;
            lhsMessageCode = this.getMessageCode();
            String rhsMessageCode;
            rhsMessageCode = that.getMessageCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "messageCode", lhsMessageCode), LocatorUtils.property(thatLocator, "messageCode", rhsMessageCode), lhsMessageCode, rhsMessageCode)) {
                return false;
            }
        }
        {
            String lhsMessage;
            lhsMessage = this.getMessage();
            String rhsMessage;
            rhsMessage = that.getMessage();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "message", lhsMessage), LocatorUtils.property(thatLocator, "message", rhsMessage), lhsMessage, rhsMessage)) {
                return false;
            }
        }
        {
            LocalizedMessageType lhsLocalizedMessage;
            lhsLocalizedMessage = this.getLocalizedMessage();
            LocalizedMessageType rhsLocalizedMessage;
            rhsLocalizedMessage = that.getLocalizedMessage();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "localizedMessage", lhsLocalizedMessage), LocatorUtils.property(thatLocator, "localizedMessage", rhsLocalizedMessage), lhsLocalizedMessage, rhsLocalizedMessage)) {
                return false;
            }
        }
        {
            String lhsDetails;
            lhsDetails = this.getDetails();
            String rhsDetails;
            rhsDetails = that.getDetails();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "details", lhsDetails), LocatorUtils.property(thatLocator, "details", rhsDetails), lhsDetails, rhsDetails)) {
                return false;
            }
        }
        {
            List<OperationResultType> lhsPartialResults;
            lhsPartialResults = (((this.partialResults!= null)&&(!this.partialResults.isEmpty()))?this.getPartialResults():null);
            List<OperationResultType> rhsPartialResults;
            rhsPartialResults = (((that.partialResults!= null)&&(!that.partialResults.isEmpty()))?that.getPartialResults():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "partialResults", lhsPartialResults), LocatorUtils.property(thatLocator, "partialResults", rhsPartialResults), lhsPartialResults, rhsPartialResults)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = new DomAwareEqualsStrategy();
        return equals(null, null, object, strategy);
    }

}
