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
 * Configuration of the logger: the facility that
 * collects log messages from subsystem code.
 * <p/>
 * <p/>
 * <p>Java class for SubSystemLoggerConfigurationType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SubSystemLoggerConfigurationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="level" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}LoggingLevelType"/>
 *         &lt;element name="component" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}LoggingComponentType"/>
 *         &lt;element name="appender" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubSystemLoggerConfigurationType", propOrder = {
        "level",
        "component",
        "appender"
})
public class SubSystemLoggerConfigurationType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected LoggingLevelType level;
    @XmlElement(required = true)
    protected LoggingComponentType component;
    protected List<String> appender;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "SubSystemLoggerConfigurationType");
    public final static QName F_LEVEL = new QName(SchemaConstants.NS_COMMON, "level");
    public final static QName F_COMPONENT = new QName(SchemaConstants.NS_COMMON, "component");
    public final static QName F_APPENDER = new QName(SchemaConstants.NS_COMMON, "appender");

    /**
     * Gets the value of the level property.
     *
     * @return possible object is
     *         {@link LoggingLevelType }
     */
    public LoggingLevelType getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     *
     * @param value allowed object is
     *              {@link LoggingLevelType }
     */
    public void setLevel(LoggingLevelType value) {
        this.level = value;
    }

    /**
     * Gets the value of the component property.
     *
     * @return possible object is
     *         {@link LoggingComponentType }
     */
    public LoggingComponentType getComponent() {
        return component;
    }

    /**
     * Sets the value of the component property.
     *
     * @param value allowed object is
     *              {@link LoggingComponentType }
     */
    public void setComponent(LoggingComponentType value) {
        this.component = value;
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
