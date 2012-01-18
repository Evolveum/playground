package com.evolveum.midpoint.xml.ns._public.communication.workflow_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * This is a data structure that describes a general event
 * sent from WfMS to midPoint, which concerns a process instance.
 * It is either generated at process instance start (WfProcessInstanceStartedEventType),
 * at its end (WfProcessInstanceFinishedEventType), or at other place, during process
 * execution (WfProcessInstanceEventType). The first two are subtypes of the third one.
 * <p/>
 * <p/>
 * <p>Java class for WfProcessInstanceEventType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="WfProcessInstanceEventType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/communication/workflow-1.xsd}WfProcessVariable" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="wfProcessInstanceId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="wfStateDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="wfAnswer" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="answerToQuery" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="midpointTaskOid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WfProcessInstanceEventType", propOrder = {
        "wfProcessVariable"
})
@XmlSeeAlso({
        WfProcessInstanceStartedEventType.class,
        WfProcessInstanceFinishedEventType.class
})
public class WfProcessInstanceEventType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(name = "WfProcessVariable")
    protected List<WfProcessVariable> wfProcessVariable;
    @XmlAttribute(name = "wfProcessInstanceId", required = true)
    protected String wfProcessInstanceId;
    @XmlAttribute(name = "wfStateDescription")
    protected String wfStateDescription;
    @XmlAttribute(name = "wfAnswer")
    protected String wfAnswer;
    @XmlAttribute(name = "answerToQuery")
    protected Boolean answerToQuery;
    @XmlAttribute(name = "midpointTaskOid", required = true)
    protected String midpointTaskOid;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_WORKFLOW, "WfProcessInstanceEventType");
    public final static QName F_WF_PROCESS_VARIABLE = new QName(SchemaConstants.NS_WORKFLOW, "wfProcessVariable");
    public final static QName F_WF_PROCESS_INSTANCE_ID = new QName(SchemaConstants.NS_WORKFLOW, "wfProcessInstanceId");
    public final static QName F_WF_STATE_DESCRIPTION = new QName(SchemaConstants.NS_WORKFLOW, "wfStateDescription");
    public final static QName F_WF_ANSWER = new QName(SchemaConstants.NS_WORKFLOW, "wfAnswer");
    public final static QName F_ANSWER_TO_QUERY = new QName(SchemaConstants.NS_WORKFLOW, "answerToQuery");
    public final static QName F_MIDPOINT_TASK_OID = new QName(SchemaConstants.NS_WORKFLOW, "midpointTaskOid");

    /**
     * A list of process instance variables.
     * Gets the value of the wfProcessVariable property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wfProcessVariable property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWfProcessVariable().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link WfProcessVariable }
     */
    public List<WfProcessVariable> getWfProcessVariable() {
        if (wfProcessVariable == null) {
            wfProcessVariable = new ArrayList<WfProcessVariable>();
        }
        return this.wfProcessVariable;
    }

    /**
     * Gets the value of the wfProcessInstanceId property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getWfProcessInstanceId() {
        return wfProcessInstanceId;
    }

    /**
     * Sets the value of the wfProcessInstanceId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setWfProcessInstanceId(String value) {
        this.wfProcessInstanceId = value;
    }

    /**
     * Gets the value of the wfStateDescription property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getWfStateDescription() {
        return wfStateDescription;
    }

    /**
     * Sets the value of the wfStateDescription property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setWfStateDescription(String value) {
        this.wfStateDescription = value;
    }

    /**
     * Gets the value of the wfAnswer property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getWfAnswer() {
        return wfAnswer;
    }

    /**
     * Sets the value of the wfAnswer property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setWfAnswer(String value) {
        this.wfAnswer = value;
    }

    /**
     * Gets the value of the answerToQuery property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public boolean isAnswerToQuery() {
        if (answerToQuery == null) {
            return false;
        } else {
            return answerToQuery;
        }
    }

    /**
     * Sets the value of the answerToQuery property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setAnswerToQuery(Boolean value) {
        this.answerToQuery = value;
    }

    /**
     * Gets the value of the midpointTaskOid property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getMidpointTaskOid() {
        return midpointTaskOid;
    }

    /**
     * Sets the value of the midpointTaskOid property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMidpointTaskOid(String value) {
        this.midpointTaskOid = value;
    }

}
