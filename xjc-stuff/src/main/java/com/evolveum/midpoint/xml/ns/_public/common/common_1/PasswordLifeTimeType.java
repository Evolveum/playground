package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for PasswordLifeTimeType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PasswordLifeTimeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="expiration" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="warnBeforeExpiration" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="lockAfterExpiration" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="minPasswordAge" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="passwordHistoryLength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PasswordLifeTimeType", propOrder = {
        "expiration",
        "warnBeforeExpiration",
        "lockAfterExpiration",
        "minPasswordAge",
        "passwordHistoryLength"
})
public class PasswordLifeTimeType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(defaultValue = "-1")
    protected Integer expiration;
    @XmlElement(defaultValue = "0")
    protected Integer warnBeforeExpiration;
    @XmlElement(defaultValue = "0")
    protected Integer lockAfterExpiration;
    @XmlElement(defaultValue = "0")
    protected Integer minPasswordAge;
    @XmlElement(defaultValue = "0")
    protected Integer passwordHistoryLength;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "PasswordLifeTimeType");
    public final static QName F_EXPIRATION = new QName(SchemaConstants.NS_COMMON, "expiration");
    public final static QName F_WARN_BEFORE_EXPIRATION = new QName(SchemaConstants.NS_COMMON, "warnBeforeExpiration");
    public final static QName F_LOCK_AFTER_EXPIRATION = new QName(SchemaConstants.NS_COMMON, "lockAfterExpiration");
    public final static QName F_MIN_PASSWORD_AGE = new QName(SchemaConstants.NS_COMMON, "minPasswordAge");
    public final static QName F_PASSWORD_HISTORY_LENGTH = new QName(SchemaConstants.NS_COMMON, "passwordHistoryLength");

    /**
     * Gets the value of the expiration property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getExpiration() {
        return expiration;
    }

    /**
     * Sets the value of the expiration property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setExpiration(Integer value) {
        this.expiration = value;
    }

    /**
     * Gets the value of the warnBeforeExpiration property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getWarnBeforeExpiration() {
        return warnBeforeExpiration;
    }

    /**
     * Sets the value of the warnBeforeExpiration property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setWarnBeforeExpiration(Integer value) {
        this.warnBeforeExpiration = value;
    }

    /**
     * Gets the value of the lockAfterExpiration property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getLockAfterExpiration() {
        return lockAfterExpiration;
    }

    /**
     * Sets the value of the lockAfterExpiration property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setLockAfterExpiration(Integer value) {
        this.lockAfterExpiration = value;
    }

    /**
     * Gets the value of the minPasswordAge property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getMinPasswordAge() {
        return minPasswordAge;
    }

    /**
     * Sets the value of the minPasswordAge property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMinPasswordAge(Integer value) {
        this.minPasswordAge = value;
    }

    /**
     * Gets the value of the passwordHistoryLength property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getPasswordHistoryLength() {
        return passwordHistoryLength;
    }

    /**
     * Sets the value of the passwordHistoryLength property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setPasswordHistoryLength(Integer value) {
        this.passwordHistoryLength = value;
    }

}
