package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Local copy of any object on the provisioning resource that is related to provisioning.
 * It may be account, group, role (on the target system), privilege, security label,
 * organizational unit or anything else that is worth managing in identity management.
 * <p/>
 * This XML object provides a representation of the resource object in the IDM system, in
 * the LOCAL REPOSITORY. It may represents a minimal data structure in IDM repository
 * that contains only identifier and nothing else. It may also represent a rich structure
 * with a lot of cached or fetched data. The actual content of this object depends on usage:
 * on the specific interface and operation used and even on the system state and configuration.
 * <p/>
 * <p/>
 * <p>Java class for ResourceObjectShadowType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ResourceObjectShadowType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExtensibleObjectType">
 *       &lt;sequence>
 *         &lt;element name="resourceRef" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectReferenceType" minOccurs="0"/>
 *         &lt;element name="resource" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ResourceType" minOccurs="0"/>
 *         &lt;element name="result" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}OperationResultType" minOccurs="0"/>
 *         &lt;element name="objectChange" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectChangeType" minOccurs="0"/>
 *         &lt;element name="attemptNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="failedOperationType" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}FailedOperationTypeType" minOccurs="0"/>
 *         &lt;element name="objectClass" type="{http://www.w3.org/2001/XMLSchema}QName"/>
 *         &lt;element name="attributes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceObjectShadowType", propOrder = {
        "resourceRef",
        "resource",
        "result",
        "objectChange",
        "attemptNumber",
        "failedOperationType",
        "objectClass",
        "attributes"
})
@XmlSeeAlso({
        AccountShadowType.class
})
public class ResourceObjectShadowType
        extends ExtensibleObjectType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected ResourceType resource;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ResourceObjectShadowType");
    public final static QName F_RESOURCE_REF = new QName(SchemaConstants.NS_COMMON, "resourceRef");
    public final static QName F_RESOURCE = new QName(SchemaConstants.NS_COMMON, "resource");
    public final static QName F_RESULT = new QName(SchemaConstants.NS_COMMON, "result");
    public final static QName F_OBJECT_CHANGE = new QName(SchemaConstants.NS_COMMON, "objectChange");
    public final static QName F_ATTEMPT_NUMBER = new QName(SchemaConstants.NS_COMMON, "attemptNumber");
    public final static QName F_FAILED_OPERATION_TYPE = new QName(SchemaConstants.NS_COMMON, "failedOperationType");
    public final static QName F_OBJECT_CLASS = new QName(SchemaConstants.NS_COMMON, "objectClass");
    public final static QName F_ATTRIBUTES = new QName(SchemaConstants.NS_COMMON, "attributes");

    /**
     * Gets the value of the resource property.
     *
     * @return possible object is
     *         {@link ResourceType }
     */
    public ResourceType getResource() {
        return resource;
    }

    public ObjectReferenceType getResourceRef() {
        return getPropertyValue(F_RESOURCE_REF, ObjectReferenceType.class);
    }

    public void setResourceRef(ObjectReferenceType value) {
        setPropertyValue(F_RESOURCE_REF, value);
    }

    public void setResource(ResourceType value) {
        //todo do not use setValue but remove container from parent property container, update if user set/remove method
        this.resource = value;
        if (value == null) {
            setPropertyValue(F_RESOURCE, null);
        } else {
            setPropertyValue(F_RESOURCE, value.getContainer());
        }
    }

    public OperationResultType getResult() {
        return getPropertyValue(F_RESULT, OperationResultType.class);
    }

    public void setResult(OperationResultType value) {
        setPropertyValue(F_RESULT, value);
    }

    public ObjectChangeType getObjectChange() {
        return getPropertyValue(F_OBJECT_CHANGE, ObjectChangeType.class);
    }

    public void setObjectChange(ObjectChangeType value) {
        setPropertyValue(F_OBJECT_CHANGE, value);
    }

    public Integer getAttemptNumber() {
        return getPropertyValue(F_ATTEMPT_NUMBER, Integer.class);
    }

    public void setAttemptNumber(Integer value) {
        setPropertyValue(F_ATTEMPT_NUMBER, value);
    }

    public FailedOperationTypeType getFailedOperationType() {
        return getPropertyValue(F_FAILED_OPERATION_TYPE, FailedOperationTypeType.class);
    }

    public void setFailedOperationType(FailedOperationTypeType value) {
        setPropertyValue(F_FAILED_OPERATION_TYPE, value);
    }

    @XmlElement(required = true)
    public QName getObjectClass() {
        return getPropertyValue(F_OBJECT_CLASS, QName.class);
    }

    public void setObjectClass(QName value) {
        setPropertyValue(F_OBJECT_CLASS, value);
    }

    @XmlElement(required = true)
    public ResourceObjectShadowType.Attributes getAttributes() {
        return getPropertyValue(F_ATTRIBUTES, ResourceObjectShadowType.Attributes.class);
    }

    public void setAttributes(ResourceObjectShadowType.Attributes value) {
        setPropertyValue(F_ATTRIBUTES, value);
    }


    /**
     * <p>Java class for anonymous complex type.
     * <p/>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "any"
    })
    public static class Attributes implements Serializable {

        private final static long serialVersionUID = 201105211233L;
        @XmlAnyElement(lax = true)
        protected List<Object> any;

        /**
         * Gets the value of the any property.
         * <p/>
         * <p/>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the any property.
         * <p/>
         * <p/>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         * <p/>
         * <p/>
         * <p/>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         * {@link Element }
         */
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }

    }

}
