package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * A state of a (possibly long-running) operation within the model.
 * <p/>
 * The purpose of this data structure is to keep a state of a possibly long-running operation
 * at the level of the model. It is expected to be stored within a task, and used by ModelController to
 * (1) remember its state between invocation of various hooks, which may interrupt the operation
 * execution and defer it until some event occurs (e.g. the workflow hook, which may request
 * a user approval in order to the operation be continued)
 * (2) *MAYBE* transfer information between ModelControl and its hooks
 * <p/>
 * EXPERIMENTAL. This type may change.
 * <p/>
 * <p/>
 * <p>Java class for ModelOperationStateType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ModelOperationStateType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kindOfOperation" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ModelOperationKindType"/>
 *         &lt;element name="stage" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ModelOperationStageType"/>
 *         &lt;element name="operationData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModelOperationStateType", propOrder = {
        "kindOfOperation",
        "stage",
        "operationData"
})
public class ModelOperationStateType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected ModelOperationKindType kindOfOperation;
    @XmlElement(required = true)
    protected ModelOperationStageType stage;
    protected String operationData;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ModelOperationStateType");
    public final static QName F_KIND_OF_OPERATION = new QName(SchemaConstants.NS_COMMON, "kindOfOperation");
    public final static QName F_STAGE = new QName(SchemaConstants.NS_COMMON, "stage");
    public final static QName F_OPERATION_DATA = new QName(SchemaConstants.NS_COMMON, "operationData");

    /**
     * Gets the value of the kindOfOperation property.
     *
     * @return possible object is
     *         {@link ModelOperationKindType }
     */
    public ModelOperationKindType getKindOfOperation() {
        return kindOfOperation;
    }

    /**
     * Sets the value of the kindOfOperation property.
     *
     * @param value allowed object is
     *              {@link ModelOperationKindType }
     */
    public void setKindOfOperation(ModelOperationKindType value) {
        this.kindOfOperation = value;
    }

    /**
     * Gets the value of the stage property.
     *
     * @return possible object is
     *         {@link ModelOperationStageType }
     */
    public ModelOperationStageType getStage() {
        return stage;
    }

    /**
     * Sets the value of the stage property.
     *
     * @param value allowed object is
     *              {@link ModelOperationStageType }
     */
    public void setStage(ModelOperationStageType value) {
        this.stage = value;
    }

    /**
     * Gets the value of the operationData property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getOperationData() {
        return operationData;
    }

    /**
     * Sets the value of the operationData property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOperationData(String value) {
        this.operationData = value;
    }

}
