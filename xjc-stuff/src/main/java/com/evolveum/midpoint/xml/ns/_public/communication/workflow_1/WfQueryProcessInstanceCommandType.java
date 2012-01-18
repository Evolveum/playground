package com.evolveum.midpoint.xml.ns._public.communication.workflow_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * This is a command used to query current status of an existing process instance.
 * <p/>
 * <p/>
 * <p>Java class for WfQueryProcessInstanceCommandType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="WfQueryProcessInstanceCommandType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="wfProcessInstanceId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="midpointTaskOid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WfQueryProcessInstanceCommandType")
public class WfQueryProcessInstanceCommandType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlAttribute(name = "wfProcessInstanceId", required = true)
    protected String wfProcessInstanceId;
    @XmlAttribute(name = "midpointTaskOid", required = true)
    protected String midpointTaskOid;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_WORKFLOW, "WfQueryProcessInstanceCommandType");
    public final static QName F_WF_PROCESS_INSTANCE_ID = new QName(SchemaConstants.NS_WORKFLOW, "wfProcessInstanceId");
    public final static QName F_MIDPOINT_TASK_OID = new QName(SchemaConstants.NS_WORKFLOW, "midpointTaskOid");

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
