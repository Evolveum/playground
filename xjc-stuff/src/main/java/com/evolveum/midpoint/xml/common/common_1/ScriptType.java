
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *                 Specifies how and when a script is executed during
 *                 provisioning.
 *             
 * 
 * <p>Java class for ScriptType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScriptType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="operation" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}OperationTypeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="order" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ScriptOrderType"/>
 *         &lt;element name="host" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ScriptHostType" minOccurs="0"/>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="argument" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ScriptArgumentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScriptType", propOrder = {
    "operation",
    "order",
    "host",
    "language",
    "argument",
    "code"
})
public class ScriptType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected List<OperationTypeType> operation;
    @XmlElement(required = true)
    protected ScriptOrderType order;
    @XmlElement(defaultValue = "resource")
    protected ScriptHostType host;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String language;
    protected List<ScriptArgumentType> argument;
    @XmlElement(required = true)
    protected String code;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ScriptType");

    /**
     * Gets the value of the operation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OperationTypeType }
     * 
     * 
     */
    public List<OperationTypeType> getOperation() {
        if (operation == null) {
            operation = new ArrayList<OperationTypeType>();
        }
        return this.operation;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link ScriptOrderType }
     *     
     */
    public ScriptOrderType getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScriptOrderType }
     *     
     */
    public void setOrder(ScriptOrderType value) {
        this.order = value;
    }

    /**
     * Gets the value of the host property.
     * 
     * @return
     *     possible object is
     *     {@link ScriptHostType }
     *     
     */
    public ScriptHostType getHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScriptHostType }
     *     
     */
    public void setHost(ScriptHostType value) {
        this.host = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the argument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the argument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArgument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScriptArgumentType }
     * 
     * 
     */
    public List<ScriptArgumentType> getArgument() {
        if (argument == null) {
            argument = new ArrayList<ScriptArgumentType>();
        }
        return this.argument;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
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
            List<OperationTypeType> theOperation;
            theOperation = (((this.operation!= null)&&(!this.operation.isEmpty()))?this.getOperation():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "operation", theOperation), currentHashCode, theOperation);
        }
        {
            ScriptOrderType theOrder;
            theOrder = this.getOrder();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "order", theOrder), currentHashCode, theOrder);
        }
        {
            ScriptHostType theHost;
            theHost = this.getHost();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "host", theHost), currentHashCode, theHost);
        }
        {
            String theLanguage;
            theLanguage = this.getLanguage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "language", theLanguage), currentHashCode, theLanguage);
        }
        {
            List<ScriptArgumentType> theArgument;
            theArgument = (((this.argument!= null)&&(!this.argument.isEmpty()))?this.getArgument():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "argument", theArgument), currentHashCode, theArgument);
        }
        {
            String theCode;
            theCode = this.getCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "code", theCode), currentHashCode, theCode);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ScriptType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ScriptType that = ((ScriptType) object);
        {
            List<OperationTypeType> lhsOperation;
            lhsOperation = (((this.operation!= null)&&(!this.operation.isEmpty()))?this.getOperation():null);
            List<OperationTypeType> rhsOperation;
            rhsOperation = (((that.operation!= null)&&(!that.operation.isEmpty()))?that.getOperation():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "operation", lhsOperation), LocatorUtils.property(thatLocator, "operation", rhsOperation), lhsOperation, rhsOperation)) {
                return false;
            }
        }
        {
            ScriptOrderType lhsOrder;
            lhsOrder = this.getOrder();
            ScriptOrderType rhsOrder;
            rhsOrder = that.getOrder();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "order", lhsOrder), LocatorUtils.property(thatLocator, "order", rhsOrder), lhsOrder, rhsOrder)) {
                return false;
            }
        }
        {
            ScriptHostType lhsHost;
            lhsHost = this.getHost();
            ScriptHostType rhsHost;
            rhsHost = that.getHost();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "host", lhsHost), LocatorUtils.property(thatLocator, "host", rhsHost), lhsHost, rhsHost)) {
                return false;
            }
        }
        {
            String lhsLanguage;
            lhsLanguage = this.getLanguage();
            String rhsLanguage;
            rhsLanguage = that.getLanguage();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "language", lhsLanguage), LocatorUtils.property(thatLocator, "language", rhsLanguage), lhsLanguage, rhsLanguage)) {
                return false;
            }
        }
        {
            List<ScriptArgumentType> lhsArgument;
            lhsArgument = (((this.argument!= null)&&(!this.argument.isEmpty()))?this.getArgument():null);
            List<ScriptArgumentType> rhsArgument;
            rhsArgument = (((that.argument!= null)&&(!that.argument.isEmpty()))?that.getArgument():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "argument", lhsArgument), LocatorUtils.property(thatLocator, "argument", rhsArgument), lhsArgument, rhsArgument)) {
                return false;
            }
        }
        {
            String lhsCode;
            lhsCode = this.getCode();
            String rhsCode;
            rhsCode = that.getCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "code", lhsCode), LocatorUtils.property(thatLocator, "code", rhsCode), lhsCode, rhsCode)) {
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
