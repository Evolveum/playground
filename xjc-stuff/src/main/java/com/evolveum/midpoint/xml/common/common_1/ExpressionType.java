
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
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
import org.w3c.dom.Element;


/**
 * 
 *                 Generic expression. The purpose of the expression is to return
 *                 a value. The expression must produce something that is a piece
 *                 of XML, which means that it may produce either string value,
 *                 XML node or a list of XML nodes.
 * 
 *                 The expression may use variables or arguments. However, such
 *                 variables or arguments passed to the expression will be different
 *                 for each invocation. It should be documented in each case this type is used.
 *             
 * 
 * <p>Java class for ExpressionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExpressionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}description" minOccurs="0"/>
 *         &lt;element name="ref" type="{http://www.w3.org/2001/XMLSchema}QName" minOccurs="0"/>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="variable" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}VariableDefinitionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="returnType" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExpressionReturnTypeType" minOccurs="0"/>
 *         &lt;element name="code" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExpressionCodeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExpressionType", propOrder = {
    "description",
    "ref",
    "language",
    "variable",
    "returnType",
    "code"
})
public class ExpressionType implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected String description;
    protected QName ref;
    @XmlElement(defaultValue = "http://www.w3.org/TR/xpath/")
    @XmlSchemaType(name = "anyURI")
    protected String language;
    protected List<VariableDefinitionType> variable;
    protected ExpressionReturnTypeType returnType;
    @XmlAnyElement
    protected Element code;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ExpressionType");

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the ref property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setRef(QName value) {
        this.ref = value;
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
     * Gets the value of the variable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVariable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VariableDefinitionType }
     * 
     * 
     */
    public List<VariableDefinitionType> getVariable() {
        if (variable == null) {
            variable = new ArrayList<VariableDefinitionType>();
        }
        return this.variable;
    }

    /**
     * Gets the value of the returnType property.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionReturnTypeType }
     *     
     */
    public ExpressionReturnTypeType getReturnType() {
        return returnType;
    }

    /**
     * Sets the value of the returnType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionReturnTypeType }
     *     
     */
    public void setReturnType(ExpressionReturnTypeType value) {
        this.returnType = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link Element }
     *     
     */
    public Element getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link Element }
     *     
     */
    public void setCode(Element value) {
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
            String theDescription;
            theDescription = this.getDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "description", theDescription), currentHashCode, theDescription);
        }
        {
            QName theRef;
            theRef = this.getRef();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ref", theRef), currentHashCode, theRef);
        }
        {
            String theLanguage;
            theLanguage = this.getLanguage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "language", theLanguage), currentHashCode, theLanguage);
        }
        {
            List<VariableDefinitionType> theVariable;
            theVariable = (((this.variable!= null)&&(!this.variable.isEmpty()))?this.getVariable():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "variable", theVariable), currentHashCode, theVariable);
        }
        {
            ExpressionReturnTypeType theReturnType;
            theReturnType = this.getReturnType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "returnType", theReturnType), currentHashCode, theReturnType);
        }
        {
            Element theCode;
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
        if (!(object instanceof ExpressionType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExpressionType that = ((ExpressionType) object);
        {
            String lhsDescription;
            lhsDescription = this.getDescription();
            String rhsDescription;
            rhsDescription = that.getDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "description", lhsDescription), LocatorUtils.property(thatLocator, "description", rhsDescription), lhsDescription, rhsDescription)) {
                return false;
            }
        }
        {
            QName lhsRef;
            lhsRef = this.getRef();
            QName rhsRef;
            rhsRef = that.getRef();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ref", lhsRef), LocatorUtils.property(thatLocator, "ref", rhsRef), lhsRef, rhsRef)) {
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
            List<VariableDefinitionType> lhsVariable;
            lhsVariable = (((this.variable!= null)&&(!this.variable.isEmpty()))?this.getVariable():null);
            List<VariableDefinitionType> rhsVariable;
            rhsVariable = (((that.variable!= null)&&(!that.variable.isEmpty()))?that.getVariable():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "variable", lhsVariable), LocatorUtils.property(thatLocator, "variable", rhsVariable), lhsVariable, rhsVariable)) {
                return false;
            }
        }
        {
            ExpressionReturnTypeType lhsReturnType;
            lhsReturnType = this.getReturnType();
            ExpressionReturnTypeType rhsReturnType;
            rhsReturnType = that.getReturnType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "returnType", lhsReturnType), LocatorUtils.property(thatLocator, "returnType", rhsReturnType), lhsReturnType, rhsReturnType)) {
                return false;
            }
        }
        {
            Element lhsCode;
            lhsCode = this.getCode();
            Element rhsCode;
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
