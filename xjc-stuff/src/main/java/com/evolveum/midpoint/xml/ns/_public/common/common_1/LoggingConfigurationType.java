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
 * Configuration of logging levels, categories, log
 * files, etc.
 * <p/>
 * <p/>
 * <p>Java class for LoggingConfigurationType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="LoggingConfigurationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subSystemLogger" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}SubSystemLoggerConfigurationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="classLogger" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ClassLoggerConfigurationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="appender" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}AppenderConfigurationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="rootLoggerAppender" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rootLoggerLevel" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}LoggingLevelType"/>
 *         &lt;element name="auditing" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}AuditingConfigurationType" minOccurs="0"/>
 *         &lt;element name="advanced" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}AdvancedLoggingConfigurationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoggingConfigurationType", propOrder = {
        "subSystemLogger",
        "classLogger",
        "appender",
        "rootLoggerAppender",
        "rootLoggerLevel",
        "auditing",
        "advanced"
})
public class LoggingConfigurationType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected List<SubSystemLoggerConfigurationType> subSystemLogger;
    protected List<ClassLoggerConfigurationType> classLogger;
    protected List<AppenderConfigurationType> appender;
    @XmlElement(required = true)
    protected String rootLoggerAppender;
    @XmlElement(required = true)
    protected LoggingLevelType rootLoggerLevel;
    protected AuditingConfigurationType auditing;
    protected AdvancedLoggingConfigurationType advanced;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "LoggingConfigurationType");
    public final static QName F_SUB_SYSTEM_LOGGER = new QName(SchemaConstants.NS_COMMON, "subSystemLogger");
    public final static QName F_CLASS_LOGGER = new QName(SchemaConstants.NS_COMMON, "classLogger");
    public final static QName F_APPENDER = new QName(SchemaConstants.NS_COMMON, "appender");
    public final static QName F_ROOT_LOGGER_APPENDER = new QName(SchemaConstants.NS_COMMON, "rootLoggerAppender");
    public final static QName F_ROOT_LOGGER_LEVEL = new QName(SchemaConstants.NS_COMMON, "rootLoggerLevel");
    public final static QName F_AUDITING = new QName(SchemaConstants.NS_COMMON, "auditing");
    public final static QName F_ADVANCED = new QName(SchemaConstants.NS_COMMON, "advanced");

    /**
     * Gets the value of the subSystemLogger property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subSystemLogger property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubSystemLogger().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link SubSystemLoggerConfigurationType }
     */
    public List<SubSystemLoggerConfigurationType> getSubSystemLogger() {
        if (subSystemLogger == null) {
            subSystemLogger = new ArrayList<SubSystemLoggerConfigurationType>();
        }
        return this.subSystemLogger;
    }

    /**
     * Gets the value of the classLogger property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classLogger property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassLogger().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ClassLoggerConfigurationType }
     */
    public List<ClassLoggerConfigurationType> getClassLogger() {
        if (classLogger == null) {
            classLogger = new ArrayList<ClassLoggerConfigurationType>();
        }
        return this.classLogger;
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
     * {@link AppenderConfigurationType }
     */
    public List<AppenderConfigurationType> getAppender() {
        if (appender == null) {
            appender = new ArrayList<AppenderConfigurationType>();
        }
        return this.appender;
    }

    /**
     * Gets the value of the rootLoggerAppender property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getRootLoggerAppender() {
        return rootLoggerAppender;
    }

    /**
     * Sets the value of the rootLoggerAppender property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRootLoggerAppender(String value) {
        this.rootLoggerAppender = value;
    }

    /**
     * Gets the value of the rootLoggerLevel property.
     *
     * @return possible object is
     *         {@link LoggingLevelType }
     */
    public LoggingLevelType getRootLoggerLevel() {
        return rootLoggerLevel;
    }

    /**
     * Sets the value of the rootLoggerLevel property.
     *
     * @param value allowed object is
     *              {@link LoggingLevelType }
     */
    public void setRootLoggerLevel(LoggingLevelType value) {
        this.rootLoggerLevel = value;
    }

    /**
     * Gets the value of the auditing property.
     *
     * @return possible object is
     *         {@link AuditingConfigurationType }
     */
    public AuditingConfigurationType getAuditing() {
        return auditing;
    }

    /**
     * Sets the value of the auditing property.
     *
     * @param value allowed object is
     *              {@link AuditingConfigurationType }
     */
    public void setAuditing(AuditingConfigurationType value) {
        this.auditing = value;
    }

    /**
     * Gets the value of the advanced property.
     *
     * @return possible object is
     *         {@link AdvancedLoggingConfigurationType }
     */
    public AdvancedLoggingConfigurationType getAdvanced() {
        return advanced;
    }

    /**
     * Sets the value of the advanced property.
     *
     * @param value allowed object is
     *              {@link AdvancedLoggingConfigurationType }
     */
    public void setAdvanced(AdvancedLoggingConfigurationType value) {
        this.advanced = value;
    }

}
