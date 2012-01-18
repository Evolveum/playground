package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.math.BigInteger;


/**
 * Task schedule. Specifies when and how often something should happen.
 * UNSTABLE. This type will most likely change. A lot.
 * <p/>
 * <p/>
 * <p>Java class for ScheduleType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ScheduleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="interval" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="cronLikePattern" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="missedScheduleTolerance" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScheduleType", propOrder = {
        "interval",
        "cronLikePattern",
        "missedScheduleTolerance"
})
public class ScheduleType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected BigInteger interval;
    protected String cronLikePattern;
    protected BigInteger missedScheduleTolerance;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ScheduleType");
    public final static QName F_INTERVAL = new QName(SchemaConstants.NS_COMMON, "interval");
    public final static QName F_CRON_LIKE_PATTERN = new QName(SchemaConstants.NS_COMMON, "cronLikePattern");
    public final static QName F_MISSED_SCHEDULE_TOLERANCE = new QName(SchemaConstants.NS_COMMON, "missedScheduleTolerance");

    /**
     * Gets the value of the interval property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setInterval(BigInteger value) {
        this.interval = value;
    }

    /**
     * Gets the value of the cronLikePattern property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCronLikePattern() {
        return cronLikePattern;
    }

    /**
     * Sets the value of the cronLikePattern property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCronLikePattern(String value) {
        this.cronLikePattern = value;
    }

    /**
     * Gets the value of the missedScheduleTolerance property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getMissedScheduleTolerance() {
        return missedScheduleTolerance;
    }

    /**
     * Sets the value of the missedScheduleTolerance property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setMissedScheduleTolerance(BigInteger value) {
        this.missedScheduleTolerance = value;
    }

}
