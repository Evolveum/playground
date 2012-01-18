package com.evolveum.midpoint.xml.ns._public.communication.workflow_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * This is a command used to start a new process instance.
 * <p/>
 * <p/>
 * <p>Java class for WfStartProcessInstanceCommandType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="WfStartProcessInstanceCommandType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/communication/workflow-1.xsd}WfProcessVariable" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="wfProcessName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="midpointTaskOid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sendStartConfirmation" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WfStartProcessInstanceCommandType", propOrder = {
        "wfProcessVariable"
})
public class WfStartProcessInstanceCommandType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(name = "WfProcessVariable")
    protected List<WfProcessVariable> wfProcessVariable;
    @XmlAttribute(name = "wfProcessName", required = true)
    protected String wfProcessName;
    @XmlAttribute(name = "midpointTaskOid", required = true)
    protected String midpointTaskOid;
    @XmlAttribute(name = "sendStartConfirmation")
    protected Boolean sendStartConfirmation;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_WORKFLOW, "WfStartProcessInstanceCommandType");
    public final static QName F_WF_PROCESS_VARIABLE = new QName(SchemaConstants.NS_WORKFLOW, "wfProcessVariable");
    public final static QName F_WF_PROCESS_NAME = new QName(SchemaConstants.NS_WORKFLOW, "wfProcessName");
    public final static QName F_MIDPOINT_TASK_OID = new QName(SchemaConstants.NS_WORKFLOW, "midpointTaskOid");
    public final static QName F_SEND_START_CONFIRMATION = new QName(SchemaConstants.NS_WORKFLOW, "sendStartConfirmation");

    /**
     * A list of process instance variables that should be set at its start.
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
     * Gets the value of the wfProcessName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getWfProcessName() {
        return wfProcessName;
    }

    /**
     * Sets the value of the wfProcessName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setWfProcessName(String value) {
        this.wfProcessName = value;
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

    /**
     * Gets the value of the sendStartConfirmation property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public boolean isSendStartConfirmation() {
        if (sendStartConfirmation == null) {
            return false;
        } else {
            return sendStartConfirmation;
        }
    }

    /**
     * Sets the value of the sendStartConfirmation property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setSendStartConfirmation(Boolean value) {
        this.sendStartConfirmation = value;
    }

}
