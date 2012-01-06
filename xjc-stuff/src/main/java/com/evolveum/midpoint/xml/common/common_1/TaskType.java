
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 * <p>Java class for TaskType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaskType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExtensibleObjectType">
 *       &lt;sequence>
 *         &lt;element name="taskIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ownerRef" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectReferenceType"/>
 *         &lt;element name="executionStatus" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}TaskExecutionStatusType"/>
 *         &lt;element name="exclusivityStatus" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}TaskExclusivityStatusType"/>
 *         &lt;element name="node" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="claimExpirationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="handlerUri" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="otherHandlersUriStack" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}UriStack" minOccurs="0"/>
 *         &lt;element name="result" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}OperationResultType" minOccurs="0"/>
 *         &lt;element name="objectRef" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectReferenceType" minOccurs="0"/>
 *         &lt;element name="lastRunStartTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lastRunFinishTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="progress" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="recurrence" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}TaskRecurrenceType"/>
 *         &lt;element name="binding" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}TaskBindingType" minOccurs="0"/>
 *         &lt;element name="schedule" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ScheduleType" minOccurs="0"/>
 *         &lt;element name="modelOperationState" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ModelOperationStateType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaskType", propOrder = {
    "taskIdentifier",
    "ownerRef",
    "executionStatus",
    "exclusivityStatus",
    "node",
    "claimExpirationTimestamp",
    "handlerUri",
    "otherHandlersUriStack",
    "result",
    "objectRef",
    "lastRunStartTimestamp",
    "lastRunFinishTimestamp",
    "progress",
    "recurrence",
    "binding",
    "schedule",
    "modelOperationState"
})
public class TaskType
    extends ExtensibleObjectType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected String taskIdentifier;
    @XmlElement(required = true)
    protected ObjectReferenceType ownerRef;
    @XmlElement(required = true)
    protected TaskExecutionStatusType executionStatus;
    @XmlElement(required = true)
    protected TaskExclusivityStatusType exclusivityStatus;
    protected String node;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar claimExpirationTimestamp;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String handlerUri;
    protected UriStack otherHandlersUriStack;
    protected OperationResultType result;
    protected ObjectReferenceType objectRef;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastRunStartTimestamp;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastRunFinishTimestamp;
    protected BigInteger progress;
    @XmlElement(required = true)
    protected TaskRecurrenceType recurrence;
    protected TaskBindingType binding;
    protected ScheduleType schedule;
    protected ModelOperationStateType modelOperationState;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "TaskType");

    /**
     * Gets the value of the taskIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskIdentifier() {
        return taskIdentifier;
    }

    /**
     * Sets the value of the taskIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskIdentifier(String value) {
        this.taskIdentifier = value;
    }

    /**
     * Gets the value of the ownerRef property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectReferenceType }
     *     
     */
    public ObjectReferenceType getOwnerRef() {
        return ownerRef;
    }

    /**
     * Sets the value of the ownerRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectReferenceType }
     *     
     */
    public void setOwnerRef(ObjectReferenceType value) {
        this.ownerRef = value;
    }

    /**
     * Gets the value of the executionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link TaskExecutionStatusType }
     *     
     */
    public TaskExecutionStatusType getExecutionStatus() {
        return executionStatus;
    }

    /**
     * Sets the value of the executionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskExecutionStatusType }
     *     
     */
    public void setExecutionStatus(TaskExecutionStatusType value) {
        this.executionStatus = value;
    }

    /**
     * Gets the value of the exclusivityStatus property.
     * 
     * @return
     *     possible object is
     *     {@link TaskExclusivityStatusType }
     *     
     */
    public TaskExclusivityStatusType getExclusivityStatus() {
        return exclusivityStatus;
    }

    /**
     * Sets the value of the exclusivityStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskExclusivityStatusType }
     *     
     */
    public void setExclusivityStatus(TaskExclusivityStatusType value) {
        this.exclusivityStatus = value;
    }

    /**
     * Gets the value of the node property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNode() {
        return node;
    }

    /**
     * Sets the value of the node property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNode(String value) {
        this.node = value;
    }

    /**
     * Gets the value of the claimExpirationTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getClaimExpirationTimestamp() {
        return claimExpirationTimestamp;
    }

    /**
     * Sets the value of the claimExpirationTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setClaimExpirationTimestamp(XMLGregorianCalendar value) {
        this.claimExpirationTimestamp = value;
    }

    /**
     * Gets the value of the handlerUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHandlerUri() {
        return handlerUri;
    }

    /**
     * Sets the value of the handlerUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHandlerUri(String value) {
        this.handlerUri = value;
    }

    /**
     * Gets the value of the otherHandlersUriStack property.
     * 
     * @return
     *     possible object is
     *     {@link UriStack }
     *     
     */
    public UriStack getOtherHandlersUriStack() {
        return otherHandlersUriStack;
    }

    /**
     * Sets the value of the otherHandlersUriStack property.
     * 
     * @param value
     *     allowed object is
     *     {@link UriStack }
     *     
     */
    public void setOtherHandlersUriStack(UriStack value) {
        this.otherHandlersUriStack = value;
    }

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link OperationResultType }
     *     
     */
    public OperationResultType getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationResultType }
     *     
     */
    public void setResult(OperationResultType value) {
        this.result = value;
    }

    /**
     * Gets the value of the objectRef property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectReferenceType }
     *     
     */
    public ObjectReferenceType getObjectRef() {
        return objectRef;
    }

    /**
     * Sets the value of the objectRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectReferenceType }
     *     
     */
    public void setObjectRef(ObjectReferenceType value) {
        this.objectRef = value;
    }

    /**
     * Gets the value of the lastRunStartTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastRunStartTimestamp() {
        return lastRunStartTimestamp;
    }

    /**
     * Sets the value of the lastRunStartTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastRunStartTimestamp(XMLGregorianCalendar value) {
        this.lastRunStartTimestamp = value;
    }

    /**
     * Gets the value of the lastRunFinishTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastRunFinishTimestamp() {
        return lastRunFinishTimestamp;
    }

    /**
     * Sets the value of the lastRunFinishTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastRunFinishTimestamp(XMLGregorianCalendar value) {
        this.lastRunFinishTimestamp = value;
    }

    /**
     * Gets the value of the progress property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getProgress() {
        return progress;
    }

    /**
     * Sets the value of the progress property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setProgress(BigInteger value) {
        this.progress = value;
    }

    /**
     * Gets the value of the recurrence property.
     * 
     * @return
     *     possible object is
     *     {@link TaskRecurrenceType }
     *     
     */
    public TaskRecurrenceType getRecurrence() {
        return recurrence;
    }

    /**
     * Sets the value of the recurrence property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskRecurrenceType }
     *     
     */
    public void setRecurrence(TaskRecurrenceType value) {
        this.recurrence = value;
    }

    /**
     * Gets the value of the binding property.
     * 
     * @return
     *     possible object is
     *     {@link TaskBindingType }
     *     
     */
    public TaskBindingType getBinding() {
        return binding;
    }

    /**
     * Sets the value of the binding property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskBindingType }
     *     
     */
    public void setBinding(TaskBindingType value) {
        this.binding = value;
    }

    /**
     * Gets the value of the schedule property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleType }
     *     
     */
    public ScheduleType getSchedule() {
        return schedule;
    }

    /**
     * Sets the value of the schedule property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleType }
     *     
     */
    public void setSchedule(ScheduleType value) {
        this.schedule = value;
    }

    /**
     * Gets the value of the modelOperationState property.
     * 
     * @return
     *     possible object is
     *     {@link ModelOperationStateType }
     *     
     */
    public ModelOperationStateType getModelOperationState() {
        return modelOperationState;
    }

    /**
     * Sets the value of the modelOperationState property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelOperationStateType }
     *     
     */
    public void setModelOperationState(ModelOperationStateType value) {
        this.modelOperationState = value;
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
        int currentHashCode = super.hashCode(locator, strategy);
        {
            String theTaskIdentifier;
            theTaskIdentifier = this.getTaskIdentifier();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "taskIdentifier", theTaskIdentifier), currentHashCode, theTaskIdentifier);
        }
        {
            ObjectReferenceType theOwnerRef;
            theOwnerRef = this.getOwnerRef();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ownerRef", theOwnerRef), currentHashCode, theOwnerRef);
        }
        {
            TaskExecutionStatusType theExecutionStatus;
            theExecutionStatus = this.getExecutionStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "executionStatus", theExecutionStatus), currentHashCode, theExecutionStatus);
        }
        {
            TaskExclusivityStatusType theExclusivityStatus;
            theExclusivityStatus = this.getExclusivityStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "exclusivityStatus", theExclusivityStatus), currentHashCode, theExclusivityStatus);
        }
        {
            String theNode;
            theNode = this.getNode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "node", theNode), currentHashCode, theNode);
        }
        {
            XMLGregorianCalendar theClaimExpirationTimestamp;
            theClaimExpirationTimestamp = this.getClaimExpirationTimestamp();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "claimExpirationTimestamp", theClaimExpirationTimestamp), currentHashCode, theClaimExpirationTimestamp);
        }
        {
            String theHandlerUri;
            theHandlerUri = this.getHandlerUri();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "handlerUri", theHandlerUri), currentHashCode, theHandlerUri);
        }
        {
            UriStack theOtherHandlersUriStack;
            theOtherHandlersUriStack = this.getOtherHandlersUriStack();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otherHandlersUriStack", theOtherHandlersUriStack), currentHashCode, theOtherHandlersUriStack);
        }
        {
            OperationResultType theResult;
            theResult = this.getResult();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "result", theResult), currentHashCode, theResult);
        }
        {
            ObjectReferenceType theObjectRef;
            theObjectRef = this.getObjectRef();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "objectRef", theObjectRef), currentHashCode, theObjectRef);
        }
        {
            XMLGregorianCalendar theLastRunStartTimestamp;
            theLastRunStartTimestamp = this.getLastRunStartTimestamp();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lastRunStartTimestamp", theLastRunStartTimestamp), currentHashCode, theLastRunStartTimestamp);
        }
        {
            XMLGregorianCalendar theLastRunFinishTimestamp;
            theLastRunFinishTimestamp = this.getLastRunFinishTimestamp();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lastRunFinishTimestamp", theLastRunFinishTimestamp), currentHashCode, theLastRunFinishTimestamp);
        }
        {
            BigInteger theProgress;
            theProgress = this.getProgress();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "progress", theProgress), currentHashCode, theProgress);
        }
        {
            TaskRecurrenceType theRecurrence;
            theRecurrence = this.getRecurrence();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recurrence", theRecurrence), currentHashCode, theRecurrence);
        }
        {
            TaskBindingType theBinding;
            theBinding = this.getBinding();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "binding", theBinding), currentHashCode, theBinding);
        }
        {
            ScheduleType theSchedule;
            theSchedule = this.getSchedule();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "schedule", theSchedule), currentHashCode, theSchedule);
        }
        {
            ModelOperationStateType theModelOperationState;
            theModelOperationState = this.getModelOperationState();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "modelOperationState", theModelOperationState), currentHashCode, theModelOperationState);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TaskType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final TaskType that = ((TaskType) object);
        {
            String lhsTaskIdentifier;
            lhsTaskIdentifier = this.getTaskIdentifier();
            String rhsTaskIdentifier;
            rhsTaskIdentifier = that.getTaskIdentifier();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "taskIdentifier", lhsTaskIdentifier), LocatorUtils.property(thatLocator, "taskIdentifier", rhsTaskIdentifier), lhsTaskIdentifier, rhsTaskIdentifier)) {
                return false;
            }
        }
        {
            ObjectReferenceType lhsOwnerRef;
            lhsOwnerRef = this.getOwnerRef();
            ObjectReferenceType rhsOwnerRef;
            rhsOwnerRef = that.getOwnerRef();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ownerRef", lhsOwnerRef), LocatorUtils.property(thatLocator, "ownerRef", rhsOwnerRef), lhsOwnerRef, rhsOwnerRef)) {
                return false;
            }
        }
        {
            TaskExecutionStatusType lhsExecutionStatus;
            lhsExecutionStatus = this.getExecutionStatus();
            TaskExecutionStatusType rhsExecutionStatus;
            rhsExecutionStatus = that.getExecutionStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "executionStatus", lhsExecutionStatus), LocatorUtils.property(thatLocator, "executionStatus", rhsExecutionStatus), lhsExecutionStatus, rhsExecutionStatus)) {
                return false;
            }
        }
        {
            TaskExclusivityStatusType lhsExclusivityStatus;
            lhsExclusivityStatus = this.getExclusivityStatus();
            TaskExclusivityStatusType rhsExclusivityStatus;
            rhsExclusivityStatus = that.getExclusivityStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "exclusivityStatus", lhsExclusivityStatus), LocatorUtils.property(thatLocator, "exclusivityStatus", rhsExclusivityStatus), lhsExclusivityStatus, rhsExclusivityStatus)) {
                return false;
            }
        }
        {
            String lhsNode;
            lhsNode = this.getNode();
            String rhsNode;
            rhsNode = that.getNode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "node", lhsNode), LocatorUtils.property(thatLocator, "node", rhsNode), lhsNode, rhsNode)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsClaimExpirationTimestamp;
            lhsClaimExpirationTimestamp = this.getClaimExpirationTimestamp();
            XMLGregorianCalendar rhsClaimExpirationTimestamp;
            rhsClaimExpirationTimestamp = that.getClaimExpirationTimestamp();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "claimExpirationTimestamp", lhsClaimExpirationTimestamp), LocatorUtils.property(thatLocator, "claimExpirationTimestamp", rhsClaimExpirationTimestamp), lhsClaimExpirationTimestamp, rhsClaimExpirationTimestamp)) {
                return false;
            }
        }
        {
            String lhsHandlerUri;
            lhsHandlerUri = this.getHandlerUri();
            String rhsHandlerUri;
            rhsHandlerUri = that.getHandlerUri();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "handlerUri", lhsHandlerUri), LocatorUtils.property(thatLocator, "handlerUri", rhsHandlerUri), lhsHandlerUri, rhsHandlerUri)) {
                return false;
            }
        }
        {
            UriStack lhsOtherHandlersUriStack;
            lhsOtherHandlersUriStack = this.getOtherHandlersUriStack();
            UriStack rhsOtherHandlersUriStack;
            rhsOtherHandlersUriStack = that.getOtherHandlersUriStack();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "otherHandlersUriStack", lhsOtherHandlersUriStack), LocatorUtils.property(thatLocator, "otherHandlersUriStack", rhsOtherHandlersUriStack), lhsOtherHandlersUriStack, rhsOtherHandlersUriStack)) {
                return false;
            }
        }
        {
            OperationResultType lhsResult;
            lhsResult = this.getResult();
            OperationResultType rhsResult;
            rhsResult = that.getResult();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "result", lhsResult), LocatorUtils.property(thatLocator, "result", rhsResult), lhsResult, rhsResult)) {
                return false;
            }
        }
        {
            ObjectReferenceType lhsObjectRef;
            lhsObjectRef = this.getObjectRef();
            ObjectReferenceType rhsObjectRef;
            rhsObjectRef = that.getObjectRef();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "objectRef", lhsObjectRef), LocatorUtils.property(thatLocator, "objectRef", rhsObjectRef), lhsObjectRef, rhsObjectRef)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsLastRunStartTimestamp;
            lhsLastRunStartTimestamp = this.getLastRunStartTimestamp();
            XMLGregorianCalendar rhsLastRunStartTimestamp;
            rhsLastRunStartTimestamp = that.getLastRunStartTimestamp();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lastRunStartTimestamp", lhsLastRunStartTimestamp), LocatorUtils.property(thatLocator, "lastRunStartTimestamp", rhsLastRunStartTimestamp), lhsLastRunStartTimestamp, rhsLastRunStartTimestamp)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsLastRunFinishTimestamp;
            lhsLastRunFinishTimestamp = this.getLastRunFinishTimestamp();
            XMLGregorianCalendar rhsLastRunFinishTimestamp;
            rhsLastRunFinishTimestamp = that.getLastRunFinishTimestamp();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lastRunFinishTimestamp", lhsLastRunFinishTimestamp), LocatorUtils.property(thatLocator, "lastRunFinishTimestamp", rhsLastRunFinishTimestamp), lhsLastRunFinishTimestamp, rhsLastRunFinishTimestamp)) {
                return false;
            }
        }
        {
            BigInteger lhsProgress;
            lhsProgress = this.getProgress();
            BigInteger rhsProgress;
            rhsProgress = that.getProgress();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "progress", lhsProgress), LocatorUtils.property(thatLocator, "progress", rhsProgress), lhsProgress, rhsProgress)) {
                return false;
            }
        }
        {
            TaskRecurrenceType lhsRecurrence;
            lhsRecurrence = this.getRecurrence();
            TaskRecurrenceType rhsRecurrence;
            rhsRecurrence = that.getRecurrence();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "recurrence", lhsRecurrence), LocatorUtils.property(thatLocator, "recurrence", rhsRecurrence), lhsRecurrence, rhsRecurrence)) {
                return false;
            }
        }
        {
            TaskBindingType lhsBinding;
            lhsBinding = this.getBinding();
            TaskBindingType rhsBinding;
            rhsBinding = that.getBinding();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "binding", lhsBinding), LocatorUtils.property(thatLocator, "binding", rhsBinding), lhsBinding, rhsBinding)) {
                return false;
            }
        }
        {
            ScheduleType lhsSchedule;
            lhsSchedule = this.getSchedule();
            ScheduleType rhsSchedule;
            rhsSchedule = that.getSchedule();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "schedule", lhsSchedule), LocatorUtils.property(thatLocator, "schedule", rhsSchedule), lhsSchedule, rhsSchedule)) {
                return false;
            }
        }
        {
            ModelOperationStateType lhsModelOperationState;
            lhsModelOperationState = this.getModelOperationState();
            ModelOperationStateType rhsModelOperationState;
            rhsModelOperationState = that.getModelOperationState();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "modelOperationState", lhsModelOperationState), LocatorUtils.property(thatLocator, "modelOperationState", rhsModelOperationState), lhsModelOperationState, rhsModelOperationState)) {
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
