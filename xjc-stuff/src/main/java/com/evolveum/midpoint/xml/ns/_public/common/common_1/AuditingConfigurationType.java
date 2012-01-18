package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Auditing configuration
 * UNSTABLE. THIS WILL CHANGE IN THE FUTURE.
 * <p/>
 * <p/>
 * <p>Java class for AuditingConfigurationType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AuditingConfigurationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="appender" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditingConfigurationType", propOrder = {
        "enabled",
        "appender"
})
public class AuditingConfigurationType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(defaultValue = "true")
    protected Boolean enabled;
    protected List<String> appender;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "AuditingConfigurationType");
    public final static QName F_ENABLED = new QName(SchemaConstants.NS_COMMON, "enabled");
    public final static QName F_APPENDER = new QName(SchemaConstants.NS_COMMON, "appender");

    /**
     * Gets the value of the enabled property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setEnabled(Boolean value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the appender property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appender property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppender().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getAppender() {
        if (appender == null) {
            appender = new ArrayList<String>();
        }
        return this.appender;
    }

}
