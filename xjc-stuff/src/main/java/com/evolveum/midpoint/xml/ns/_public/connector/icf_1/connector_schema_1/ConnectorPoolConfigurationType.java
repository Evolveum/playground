package com.evolveum.midpoint.xml.ns._public.connector.icf_1.connector_schema_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.math.BigInteger;


/**
 * Type that contains configuration of ICF connector pools. This configuration is common for all
 * ICF connectors, therefore it may be part of a static schema.
 * <p/>
 * <p/>
 * <p>Java class for ConnectorPoolConfigurationType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ConnectorPoolConfigurationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="minEvictableIdleTimeMillis" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="minIdle" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="maxIdle" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="maxObjects" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="maxWait" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConnectorPoolConfigurationType", propOrder = {
        "minEvictableIdleTimeMillis",
        "minIdle",
        "maxIdle",
        "maxObjects",
        "maxWait"
})
public class ConnectorPoolConfigurationType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected BigInteger minEvictableIdleTimeMillis;
    protected BigInteger minIdle;
    protected BigInteger maxIdle;
    protected BigInteger maxObjects;
    protected BigInteger maxWait;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_ICF_SCHEMA, "ConnectorPoolConfigurationType");
    public final static QName F_MIN_EVICTABLE_IDLE_TIME_MILLIS = new QName(SchemaConstants.NS_ICF_SCHEMA, "minEvictableIdleTimeMillis");
    public final static QName F_MIN_IDLE = new QName(SchemaConstants.NS_ICF_SCHEMA, "minIdle");
    public final static QName F_MAX_IDLE = new QName(SchemaConstants.NS_ICF_SCHEMA, "maxIdle");
    public final static QName F_MAX_OBJECTS = new QName(SchemaConstants.NS_ICF_SCHEMA, "maxObjects");
    public final static QName F_MAX_WAIT = new QName(SchemaConstants.NS_ICF_SCHEMA, "maxWait");

    /**
     * Gets the value of the minEvictableIdleTimeMillis property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    /**
     * Sets the value of the minEvictableIdleTimeMillis property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setMinEvictableIdleTimeMillis(BigInteger value) {
        this.minEvictableIdleTimeMillis = value;
    }

    /**
     * Gets the value of the minIdle property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getMinIdle() {
        return minIdle;
    }

    /**
     * Sets the value of the minIdle property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setMinIdle(BigInteger value) {
        this.minIdle = value;
    }

    /**
     * Gets the value of the maxIdle property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getMaxIdle() {
        return maxIdle;
    }

    /**
     * Sets the value of the maxIdle property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setMaxIdle(BigInteger value) {
        this.maxIdle = value;
    }

    /**
     * Gets the value of the maxObjects property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getMaxObjects() {
        return maxObjects;
    }

    /**
     * Sets the value of the maxObjects property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setMaxObjects(BigInteger value) {
        this.maxObjects = value;
    }

    /**
     * Gets the value of the maxWait property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getMaxWait() {
        return maxWait;
    }

    /**
     * Sets the value of the maxWait property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setMaxWait(BigInteger value) {
        this.maxWait = value;
    }

}
