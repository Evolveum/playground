package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.math.BigInteger;


/**
 * TODO
 * <p/>
 * <p/>
 * <p>Java class for TaskType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
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
 *         &lt;element name="nextRunStartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
        "nextRunStartTime",
        "progress",
        "recurrence",
        "binding",
        "schedule",
        "modelOperationState"
})
public class TaskType
        extends ExtensibleObjectType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "TaskType");
    public final static QName F_TASK_IDENTIFIER = new QName(SchemaConstants.NS_COMMON, "taskIdentifier");
    public final static QName F_OWNER_REF = new QName(SchemaConstants.NS_COMMON, "ownerRef");
    public final static QName F_EXECUTION_STATUS = new QName(SchemaConstants.NS_COMMON, "executionStatus");
    public final static QName F_EXCLUSIVITY_STATUS = new QName(SchemaConstants.NS_COMMON, "exclusivityStatus");
    public final static QName F_NODE = new QName(SchemaConstants.NS_COMMON, "node");
    public final static QName F_CLAIM_EXPIRATION_TIMESTAMP = new QName(SchemaConstants.NS_COMMON, "claimExpirationTimestamp");
    public final static QName F_HANDLER_URI = new QName(SchemaConstants.NS_COMMON, "handlerUri");
    public final static QName F_OTHER_HANDLERS_URI_STACK = new QName(SchemaConstants.NS_COMMON, "otherHandlersUriStack");
    public final static QName F_RESULT = new QName(SchemaConstants.NS_COMMON, "result");
    public final static QName F_OBJECT_REF = new QName(SchemaConstants.NS_COMMON, "objectRef");
    public final static QName F_LAST_RUN_START_TIMESTAMP = new QName(SchemaConstants.NS_COMMON, "lastRunStartTimestamp");
    public final static QName F_LAST_RUN_FINISH_TIMESTAMP = new QName(SchemaConstants.NS_COMMON, "lastRunFinishTimestamp");
    public final static QName F_NEXT_RUN_START_TIME = new QName(SchemaConstants.NS_COMMON, "nextRunStartTime");
    public final static QName F_PROGRESS = new QName(SchemaConstants.NS_COMMON, "progress");
    public final static QName F_RECURRENCE = new QName(SchemaConstants.NS_COMMON, "recurrence");
    public final static QName F_BINDING = new QName(SchemaConstants.NS_COMMON, "binding");
    public final static QName F_SCHEDULE = new QName(SchemaConstants.NS_COMMON, "schedule");
    public final static QName F_MODEL_OPERATION_STATE = new QName(SchemaConstants.NS_COMMON, "modelOperationState");

    @XmlElement(required = true)
    public String getTaskIdentifier() {
        return getPropertyValue(F_TASK_IDENTIFIER, String.class);
    }

    public void setTaskIdentifier(String value) {
        setPropertyValue(F_TASK_IDENTIFIER, value);
    }

    @XmlElement(required = true)
    public ObjectReferenceType getOwnerRef() {
        return getPropertyValue(F_OWNER_REF, ObjectReferenceType.class);
    }

    public void setOwnerRef(ObjectReferenceType value) {
        setPropertyValue(F_OWNER_REF, value);
    }

    @XmlElement(required = true)
    public TaskExecutionStatusType getExecutionStatus() {
        return getPropertyValue(F_EXECUTION_STATUS, TaskExecutionStatusType.class);
    }

    public void setExecutionStatus(TaskExecutionStatusType value) {
        setPropertyValue(F_EXECUTION_STATUS, value);
    }

    @XmlElement(required = true)
    public TaskExclusivityStatusType getExclusivityStatus() {
        return getPropertyValue(F_EXCLUSIVITY_STATUS, TaskExclusivityStatusType.class);
    }

    public void setExclusivityStatus(TaskExclusivityStatusType value) {
        setPropertyValue(F_EXCLUSIVITY_STATUS, value);
    }

    public String getNode() {
        return getPropertyValue(F_NODE, String.class);
    }

    public void setNode(String value) {
        setPropertyValue(F_NODE, value);
    }

    @XmlSchemaType(name = "dateTime")
    public XMLGregorianCalendar getClaimExpirationTimestamp() {
        return getPropertyValue(F_CLAIM_EXPIRATION_TIMESTAMP, XMLGregorianCalendar.class);
    }

    public void setClaimExpirationTimestamp(XMLGregorianCalendar value) {
        setPropertyValue(F_CLAIM_EXPIRATION_TIMESTAMP, value);
    }

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    public String getHandlerUri() {
        return getPropertyValue(F_HANDLER_URI, String.class);
    }

    public void setHandlerUri(String value) {
        setPropertyValue(F_HANDLER_URI, value);
    }

    public UriStack getOtherHandlersUriStack() {
        return getPropertyValue(F_OTHER_HANDLERS_URI_STACK, UriStack.class);
    }

    public void setOtherHandlersUriStack(UriStack value) {
        setPropertyValue(F_OTHER_HANDLERS_URI_STACK, value);
    }

    public OperationResultType getResult() {
        return getPropertyValue(F_RESULT, OperationResultType.class);
    }

    public void setResult(OperationResultType value) {
        setPropertyValue(F_RESULT, value);
    }

    public ObjectReferenceType getObjectRef() {
        return getPropertyValue(F_OBJECT_REF, ObjectReferenceType.class);
    }

    public void setObjectRef(ObjectReferenceType value) {
        setPropertyValue(F_OBJECT_REF, value);
    }

    @XmlSchemaType(name = "dateTime")
    public XMLGregorianCalendar getLastRunStartTimestamp() {
        return getPropertyValue(F_LAST_RUN_START_TIMESTAMP, XMLGregorianCalendar.class);
    }

    public void setLastRunStartTimestamp(XMLGregorianCalendar value) {
        setPropertyValue(F_LAST_RUN_START_TIMESTAMP, value);
    }

    @XmlSchemaType(name = "dateTime")
    public XMLGregorianCalendar getLastRunFinishTimestamp() {
        return getPropertyValue(F_LAST_RUN_FINISH_TIMESTAMP, XMLGregorianCalendar.class);
    }

    public void setLastRunFinishTimestamp(XMLGregorianCalendar value) {
        setPropertyValue(F_LAST_RUN_FINISH_TIMESTAMP, value);
    }

    @XmlSchemaType(name = "dateTime")
    public XMLGregorianCalendar getNextRunStartTime() {
        return getPropertyValue(F_NEXT_RUN_START_TIME, XMLGregorianCalendar.class);
    }

    public void setNextRunStartTime(XMLGregorianCalendar value) {
        setPropertyValue(F_NEXT_RUN_START_TIME, value);
    }

    public BigInteger getProgress() {
        return getPropertyValue(F_PROGRESS, BigInteger.class);
    }

    public void setProgress(BigInteger value) {
        setPropertyValue(F_PROGRESS, value);
    }

    @XmlElement(required = true)
    public TaskRecurrenceType getRecurrence() {
        return getPropertyValue(F_RECURRENCE, TaskRecurrenceType.class);
    }

    public void setRecurrence(TaskRecurrenceType value) {
        setPropertyValue(F_RECURRENCE, value);
    }

    public TaskBindingType getBinding() {
        return getPropertyValue(F_BINDING, TaskBindingType.class);
    }

    public void setBinding(TaskBindingType value) {
        setPropertyValue(F_BINDING, value);
    }

    public ScheduleType getSchedule() {
        return getPropertyValue(F_SCHEDULE, ScheduleType.class);
    }

    public void setSchedule(ScheduleType value) {
        setPropertyValue(F_SCHEDULE, value);
    }

    public ModelOperationStateType getModelOperationState() {
        return getPropertyValue(F_MODEL_OPERATION_STATE, ModelOperationStateType.class);
    }

    public void setModelOperationState(ModelOperationStateType value) {
        setPropertyValue(F_MODEL_OPERATION_STATE, value);
    }

}
