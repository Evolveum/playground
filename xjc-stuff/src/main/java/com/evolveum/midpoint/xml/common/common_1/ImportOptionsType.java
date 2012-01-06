
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
 *                 The options for import tasks. It specifies optional settings for import such as "overwrite" and "stop on
 *                 error".
 *             
 * 
 * <p>Java class for ImportOptionsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImportOptionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="overwrite" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="keepOid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="stopAfterErrors" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="summarizeSucceses" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="summarizeErrors" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="referentialIntegrity" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="validateStaticSchema" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="validateDynamicSchema" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="encryptProtectedValues" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="fetchResourceSchema" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImportOptionsType", propOrder = {
    "overwrite",
    "keepOid",
    "stopAfterErrors",
    "summarizeSucceses",
    "summarizeErrors",
    "referentialIntegrity",
    "validateStaticSchema",
    "validateDynamicSchema",
    "encryptProtectedValues",
    "fetchResourceSchema"
})
public class ImportOptionsType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected Boolean overwrite;
    protected Boolean keepOid;
    protected Integer stopAfterErrors;
    @XmlElement(defaultValue = "true")
    protected Boolean summarizeSucceses;
    @XmlElement(defaultValue = "false")
    protected Boolean summarizeErrors;
    @XmlElement(defaultValue = "false")
    protected Boolean referentialIntegrity;
    @XmlElement(defaultValue = "true")
    protected Boolean validateStaticSchema;
    @XmlElement(defaultValue = "true")
    protected Boolean validateDynamicSchema;
    @XmlElement(defaultValue = "true")
    protected Boolean encryptProtectedValues;
    @XmlElement(defaultValue = "false")
    protected Boolean fetchResourceSchema;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ImportOptionsType");

    /**
     * Gets the value of the overwrite property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOverwrite() {
        return overwrite;
    }

    /**
     * Sets the value of the overwrite property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOverwrite(Boolean value) {
        this.overwrite = value;
    }

    /**
     * Gets the value of the keepOid property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isKeepOid() {
        return keepOid;
    }

    /**
     * Sets the value of the keepOid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setKeepOid(Boolean value) {
        this.keepOid = value;
    }

    /**
     * Gets the value of the stopAfterErrors property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStopAfterErrors() {
        return stopAfterErrors;
    }

    /**
     * Sets the value of the stopAfterErrors property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStopAfterErrors(Integer value) {
        this.stopAfterErrors = value;
    }

    /**
     * Gets the value of the summarizeSucceses property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSummarizeSucceses() {
        return summarizeSucceses;
    }

    /**
     * Sets the value of the summarizeSucceses property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSummarizeSucceses(Boolean value) {
        this.summarizeSucceses = value;
    }

    /**
     * Gets the value of the summarizeErrors property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSummarizeErrors() {
        return summarizeErrors;
    }

    /**
     * Sets the value of the summarizeErrors property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSummarizeErrors(Boolean value) {
        this.summarizeErrors = value;
    }

    /**
     * Gets the value of the referentialIntegrity property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReferentialIntegrity() {
        return referentialIntegrity;
    }

    /**
     * Sets the value of the referentialIntegrity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReferentialIntegrity(Boolean value) {
        this.referentialIntegrity = value;
    }

    /**
     * Gets the value of the validateStaticSchema property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isValidateStaticSchema() {
        return validateStaticSchema;
    }

    /**
     * Sets the value of the validateStaticSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setValidateStaticSchema(Boolean value) {
        this.validateStaticSchema = value;
    }

    /**
     * Gets the value of the validateDynamicSchema property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isValidateDynamicSchema() {
        return validateDynamicSchema;
    }

    /**
     * Sets the value of the validateDynamicSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setValidateDynamicSchema(Boolean value) {
        this.validateDynamicSchema = value;
    }

    /**
     * Gets the value of the encryptProtectedValues property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEncryptProtectedValues() {
        return encryptProtectedValues;
    }

    /**
     * Sets the value of the encryptProtectedValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEncryptProtectedValues(Boolean value) {
        this.encryptProtectedValues = value;
    }

    /**
     * Gets the value of the fetchResourceSchema property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFetchResourceSchema() {
        return fetchResourceSchema;
    }

    /**
     * Sets the value of the fetchResourceSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFetchResourceSchema(Boolean value) {
        this.fetchResourceSchema = value;
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
            Boolean theOverwrite;
            theOverwrite = this.isOverwrite();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "overwrite", theOverwrite), currentHashCode, theOverwrite);
        }
        {
            Boolean theKeepOid;
            theKeepOid = this.isKeepOid();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "keepOid", theKeepOid), currentHashCode, theKeepOid);
        }
        {
            Integer theStopAfterErrors;
            theStopAfterErrors = this.getStopAfterErrors();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "stopAfterErrors", theStopAfterErrors), currentHashCode, theStopAfterErrors);
        }
        {
            Boolean theSummarizeSucceses;
            theSummarizeSucceses = this.isSummarizeSucceses();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "summarizeSucceses", theSummarizeSucceses), currentHashCode, theSummarizeSucceses);
        }
        {
            Boolean theSummarizeErrors;
            theSummarizeErrors = this.isSummarizeErrors();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "summarizeErrors", theSummarizeErrors), currentHashCode, theSummarizeErrors);
        }
        {
            Boolean theReferentialIntegrity;
            theReferentialIntegrity = this.isReferentialIntegrity();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "referentialIntegrity", theReferentialIntegrity), currentHashCode, theReferentialIntegrity);
        }
        {
            Boolean theValidateStaticSchema;
            theValidateStaticSchema = this.isValidateStaticSchema();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validateStaticSchema", theValidateStaticSchema), currentHashCode, theValidateStaticSchema);
        }
        {
            Boolean theValidateDynamicSchema;
            theValidateDynamicSchema = this.isValidateDynamicSchema();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validateDynamicSchema", theValidateDynamicSchema), currentHashCode, theValidateDynamicSchema);
        }
        {
            Boolean theEncryptProtectedValues;
            theEncryptProtectedValues = this.isEncryptProtectedValues();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "encryptProtectedValues", theEncryptProtectedValues), currentHashCode, theEncryptProtectedValues);
        }
        {
            Boolean theFetchResourceSchema;
            theFetchResourceSchema = this.isFetchResourceSchema();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fetchResourceSchema", theFetchResourceSchema), currentHashCode, theFetchResourceSchema);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ImportOptionsType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ImportOptionsType that = ((ImportOptionsType) object);
        {
            Boolean lhsOverwrite;
            lhsOverwrite = this.isOverwrite();
            Boolean rhsOverwrite;
            rhsOverwrite = that.isOverwrite();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "overwrite", lhsOverwrite), LocatorUtils.property(thatLocator, "overwrite", rhsOverwrite), lhsOverwrite, rhsOverwrite)) {
                return false;
            }
        }
        {
            Boolean lhsKeepOid;
            lhsKeepOid = this.isKeepOid();
            Boolean rhsKeepOid;
            rhsKeepOid = that.isKeepOid();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "keepOid", lhsKeepOid), LocatorUtils.property(thatLocator, "keepOid", rhsKeepOid), lhsKeepOid, rhsKeepOid)) {
                return false;
            }
        }
        {
            Integer lhsStopAfterErrors;
            lhsStopAfterErrors = this.getStopAfterErrors();
            Integer rhsStopAfterErrors;
            rhsStopAfterErrors = that.getStopAfterErrors();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "stopAfterErrors", lhsStopAfterErrors), LocatorUtils.property(thatLocator, "stopAfterErrors", rhsStopAfterErrors), lhsStopAfterErrors, rhsStopAfterErrors)) {
                return false;
            }
        }
        {
            Boolean lhsSummarizeSucceses;
            lhsSummarizeSucceses = this.isSummarizeSucceses();
            Boolean rhsSummarizeSucceses;
            rhsSummarizeSucceses = that.isSummarizeSucceses();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "summarizeSucceses", lhsSummarizeSucceses), LocatorUtils.property(thatLocator, "summarizeSucceses", rhsSummarizeSucceses), lhsSummarizeSucceses, rhsSummarizeSucceses)) {
                return false;
            }
        }
        {
            Boolean lhsSummarizeErrors;
            lhsSummarizeErrors = this.isSummarizeErrors();
            Boolean rhsSummarizeErrors;
            rhsSummarizeErrors = that.isSummarizeErrors();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "summarizeErrors", lhsSummarizeErrors), LocatorUtils.property(thatLocator, "summarizeErrors", rhsSummarizeErrors), lhsSummarizeErrors, rhsSummarizeErrors)) {
                return false;
            }
        }
        {
            Boolean lhsReferentialIntegrity;
            lhsReferentialIntegrity = this.isReferentialIntegrity();
            Boolean rhsReferentialIntegrity;
            rhsReferentialIntegrity = that.isReferentialIntegrity();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "referentialIntegrity", lhsReferentialIntegrity), LocatorUtils.property(thatLocator, "referentialIntegrity", rhsReferentialIntegrity), lhsReferentialIntegrity, rhsReferentialIntegrity)) {
                return false;
            }
        }
        {
            Boolean lhsValidateStaticSchema;
            lhsValidateStaticSchema = this.isValidateStaticSchema();
            Boolean rhsValidateStaticSchema;
            rhsValidateStaticSchema = that.isValidateStaticSchema();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "validateStaticSchema", lhsValidateStaticSchema), LocatorUtils.property(thatLocator, "validateStaticSchema", rhsValidateStaticSchema), lhsValidateStaticSchema, rhsValidateStaticSchema)) {
                return false;
            }
        }
        {
            Boolean lhsValidateDynamicSchema;
            lhsValidateDynamicSchema = this.isValidateDynamicSchema();
            Boolean rhsValidateDynamicSchema;
            rhsValidateDynamicSchema = that.isValidateDynamicSchema();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "validateDynamicSchema", lhsValidateDynamicSchema), LocatorUtils.property(thatLocator, "validateDynamicSchema", rhsValidateDynamicSchema), lhsValidateDynamicSchema, rhsValidateDynamicSchema)) {
                return false;
            }
        }
        {
            Boolean lhsEncryptProtectedValues;
            lhsEncryptProtectedValues = this.isEncryptProtectedValues();
            Boolean rhsEncryptProtectedValues;
            rhsEncryptProtectedValues = that.isEncryptProtectedValues();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "encryptProtectedValues", lhsEncryptProtectedValues), LocatorUtils.property(thatLocator, "encryptProtectedValues", rhsEncryptProtectedValues), lhsEncryptProtectedValues, rhsEncryptProtectedValues)) {
                return false;
            }
        }
        {
            Boolean lhsFetchResourceSchema;
            lhsFetchResourceSchema = this.isFetchResourceSchema();
            Boolean rhsFetchResourceSchema;
            rhsFetchResourceSchema = that.isFetchResourceSchema();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fetchResourceSchema", lhsFetchResourceSchema), LocatorUtils.property(thatLocator, "fetchResourceSchema", rhsFetchResourceSchema), lhsFetchResourceSchema, rhsFetchResourceSchema)) {
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
