package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * The options for import tasks. It specifies optional settings for import such as "overwrite" and "stop on
 * error".
 * <p/>
 * <p/>
 * <p>Java class for ImportOptionsType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
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
public class ImportOptionsType implements Serializable {

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
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ImportOptionsType");
    public final static QName F_OVERWRITE = new QName(SchemaConstants.NS_COMMON, "overwrite");
    public final static QName F_KEEP_OID = new QName(SchemaConstants.NS_COMMON, "keepOid");
    public final static QName F_STOP_AFTER_ERRORS = new QName(SchemaConstants.NS_COMMON, "stopAfterErrors");
    public final static QName F_SUMMARIZE_SUCCESES = new QName(SchemaConstants.NS_COMMON, "summarizeSucceses");
    public final static QName F_SUMMARIZE_ERRORS = new QName(SchemaConstants.NS_COMMON, "summarizeErrors");
    public final static QName F_REFERENTIAL_INTEGRITY = new QName(SchemaConstants.NS_COMMON, "referentialIntegrity");
    public final static QName F_VALIDATE_STATIC_SCHEMA = new QName(SchemaConstants.NS_COMMON, "validateStaticSchema");
    public final static QName F_VALIDATE_DYNAMIC_SCHEMA = new QName(SchemaConstants.NS_COMMON, "validateDynamicSchema");
    public final static QName F_ENCRYPT_PROTECTED_VALUES = new QName(SchemaConstants.NS_COMMON, "encryptProtectedValues");
    public final static QName F_FETCH_RESOURCE_SCHEMA = new QName(SchemaConstants.NS_COMMON, "fetchResourceSchema");

    /**
     * Gets the value of the overwrite property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isOverwrite() {
        return overwrite;
    }

    /**
     * Sets the value of the overwrite property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setOverwrite(Boolean value) {
        this.overwrite = value;
    }

    /**
     * Gets the value of the keepOid property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isKeepOid() {
        return keepOid;
    }

    /**
     * Sets the value of the keepOid property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setKeepOid(Boolean value) {
        this.keepOid = value;
    }

    /**
     * Gets the value of the stopAfterErrors property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getStopAfterErrors() {
        return stopAfterErrors;
    }

    /**
     * Sets the value of the stopAfterErrors property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setStopAfterErrors(Integer value) {
        this.stopAfterErrors = value;
    }

    /**
     * Gets the value of the summarizeSucceses property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isSummarizeSucceses() {
        return summarizeSucceses;
    }

    /**
     * Sets the value of the summarizeSucceses property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setSummarizeSucceses(Boolean value) {
        this.summarizeSucceses = value;
    }

    /**
     * Gets the value of the summarizeErrors property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isSummarizeErrors() {
        return summarizeErrors;
    }

    /**
     * Sets the value of the summarizeErrors property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setSummarizeErrors(Boolean value) {
        this.summarizeErrors = value;
    }

    /**
     * Gets the value of the referentialIntegrity property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isReferentialIntegrity() {
        return referentialIntegrity;
    }

    /**
     * Sets the value of the referentialIntegrity property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setReferentialIntegrity(Boolean value) {
        this.referentialIntegrity = value;
    }

    /**
     * Gets the value of the validateStaticSchema property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isValidateStaticSchema() {
        return validateStaticSchema;
    }

    /**
     * Sets the value of the validateStaticSchema property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setValidateStaticSchema(Boolean value) {
        this.validateStaticSchema = value;
    }

    /**
     * Gets the value of the validateDynamicSchema property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isValidateDynamicSchema() {
        return validateDynamicSchema;
    }

    /**
     * Sets the value of the validateDynamicSchema property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setValidateDynamicSchema(Boolean value) {
        this.validateDynamicSchema = value;
    }

    /**
     * Gets the value of the encryptProtectedValues property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isEncryptProtectedValues() {
        return encryptProtectedValues;
    }

    /**
     * Sets the value of the encryptProtectedValues property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setEncryptProtectedValues(Boolean value) {
        this.encryptProtectedValues = value;
    }

    /**
     * Gets the value of the fetchResourceSchema property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isFetchResourceSchema() {
        return fetchResourceSchema;
    }

    /**
     * Sets the value of the fetchResourceSchema property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setFetchResourceSchema(Boolean value) {
        this.fetchResourceSchema = value;
    }

}
