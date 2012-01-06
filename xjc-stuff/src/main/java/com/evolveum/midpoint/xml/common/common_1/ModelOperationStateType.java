
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
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
 *                 A state of a (possibly long-running) operation within the model.
 * 
 *                 The purpose of this data structure is to keep a state of a possibly long-running operation
 *                 at the level of the model. It is expected to be stored within a task, and used by ModelController to
 *                 (1) remember its state between invocation of various hooks, which may interrupt the operation
 *                 execution and defer it until some event occurs (e.g. the workflow hook, which may request
 *                 a user approval in order to the operation be continued)
 *                 (2) *MAYBE* transfer information between ModelControl and its hooks
 * 
 *                 EXPERIMENTAL. This type may change.
 *             
 * 
 * <p>Java class for ModelOperationStateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
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
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModelOperationStateType", propOrder = {
    "kindOfOperation",
    "stage",
    "operationData"
})
public class ModelOperationStateType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected ModelOperationKindType kindOfOperation;
    @XmlElement(required = true)
    protected ModelOperationStageType stage;
    protected String operationData;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ModelOperationStateType");

    /**
     * Gets the value of the kindOfOperation property.
     * 
     * @return
     *     possible object is
     *     {@link ModelOperationKindType }
     *     
     */
    public ModelOperationKindType getKindOfOperation() {
        return kindOfOperation;
    }

    /**
     * Sets the value of the kindOfOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelOperationKindType }
     *     
     */
    public void setKindOfOperation(ModelOperationKindType value) {
        this.kindOfOperation = value;
    }

    /**
     * Gets the value of the stage property.
     * 
     * @return
     *     possible object is
     *     {@link ModelOperationStageType }
     *     
     */
    public ModelOperationStageType getStage() {
        return stage;
    }

    /**
     * Sets the value of the stage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelOperationStageType }
     *     
     */
    public void setStage(ModelOperationStageType value) {
        this.stage = value;
    }

    /**
     * Gets the value of the operationData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationData() {
        return operationData;
    }

    /**
     * Sets the value of the operationData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationData(String value) {
        this.operationData = value;
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
            ModelOperationKindType theKindOfOperation;
            theKindOfOperation = this.getKindOfOperation();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "kindOfOperation", theKindOfOperation), currentHashCode, theKindOfOperation);
        }
        {
            ModelOperationStageType theStage;
            theStage = this.getStage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "stage", theStage), currentHashCode, theStage);
        }
        {
            String theOperationData;
            theOperationData = this.getOperationData();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "operationData", theOperationData), currentHashCode, theOperationData);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ModelOperationStateType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ModelOperationStateType that = ((ModelOperationStateType) object);
        {
            ModelOperationKindType lhsKindOfOperation;
            lhsKindOfOperation = this.getKindOfOperation();
            ModelOperationKindType rhsKindOfOperation;
            rhsKindOfOperation = that.getKindOfOperation();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "kindOfOperation", lhsKindOfOperation), LocatorUtils.property(thatLocator, "kindOfOperation", rhsKindOfOperation), lhsKindOfOperation, rhsKindOfOperation)) {
                return false;
            }
        }
        {
            ModelOperationStageType lhsStage;
            lhsStage = this.getStage();
            ModelOperationStageType rhsStage;
            rhsStage = that.getStage();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "stage", lhsStage), LocatorUtils.property(thatLocator, "stage", rhsStage), lhsStage, rhsStage)) {
                return false;
            }
        }
        {
            String lhsOperationData;
            lhsOperationData = this.getOperationData();
            String rhsOperationData;
            rhsOperationData = that.getOperationData();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "operationData", lhsOperationData), LocatorUtils.property(thatLocator, "operationData", rhsOperationData), lhsOperationData, rhsOperationData)) {
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
