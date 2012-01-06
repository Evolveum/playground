
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
 *                 Configuration of logging levels, categories, log
 *                 files, etc.
 *             
 * 
 * <p>Java class for LoggingConfigurationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
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
 * 
 * 
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
public class LoggingConfigurationType
    implements Serializable, Equals, HashCode
{

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
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "LoggingConfigurationType");

    /**
     * Gets the value of the subSystemLogger property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subSystemLogger property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubSystemLogger().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubSystemLoggerConfigurationType }
     * 
     * 
     */
    public List<SubSystemLoggerConfigurationType> getSubSystemLogger() {
        if (subSystemLogger == null) {
            subSystemLogger = new ArrayList<SubSystemLoggerConfigurationType>();
        }
        return this.subSystemLogger;
    }

    /**
     * Gets the value of the classLogger property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classLogger property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassLogger().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClassLoggerConfigurationType }
     * 
     * 
     */
    public List<ClassLoggerConfigurationType> getClassLogger() {
        if (classLogger == null) {
            classLogger = new ArrayList<ClassLoggerConfigurationType>();
        }
        return this.classLogger;
    }

    /**
     * Gets the value of the appender property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appender property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppender().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AppenderConfigurationType }
     * 
     * 
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
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRootLoggerAppender() {
        return rootLoggerAppender;
    }

    /**
     * Sets the value of the rootLoggerAppender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRootLoggerAppender(String value) {
        this.rootLoggerAppender = value;
    }

    /**
     * Gets the value of the rootLoggerLevel property.
     * 
     * @return
     *     possible object is
     *     {@link LoggingLevelType }
     *     
     */
    public LoggingLevelType getRootLoggerLevel() {
        return rootLoggerLevel;
    }

    /**
     * Sets the value of the rootLoggerLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoggingLevelType }
     *     
     */
    public void setRootLoggerLevel(LoggingLevelType value) {
        this.rootLoggerLevel = value;
    }

    /**
     * Gets the value of the auditing property.
     * 
     * @return
     *     possible object is
     *     {@link AuditingConfigurationType }
     *     
     */
    public AuditingConfigurationType getAuditing() {
        return auditing;
    }

    /**
     * Sets the value of the auditing property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditingConfigurationType }
     *     
     */
    public void setAuditing(AuditingConfigurationType value) {
        this.auditing = value;
    }

    /**
     * Gets the value of the advanced property.
     * 
     * @return
     *     possible object is
     *     {@link AdvancedLoggingConfigurationType }
     *     
     */
    public AdvancedLoggingConfigurationType getAdvanced() {
        return advanced;
    }

    /**
     * Sets the value of the advanced property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdvancedLoggingConfigurationType }
     *     
     */
    public void setAdvanced(AdvancedLoggingConfigurationType value) {
        this.advanced = value;
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
            List<SubSystemLoggerConfigurationType> theSubSystemLogger;
            theSubSystemLogger = (((this.subSystemLogger!= null)&&(!this.subSystemLogger.isEmpty()))?this.getSubSystemLogger():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "subSystemLogger", theSubSystemLogger), currentHashCode, theSubSystemLogger);
        }
        {
            List<ClassLoggerConfigurationType> theClassLogger;
            theClassLogger = (((this.classLogger!= null)&&(!this.classLogger.isEmpty()))?this.getClassLogger():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "classLogger", theClassLogger), currentHashCode, theClassLogger);
        }
        {
            List<AppenderConfigurationType> theAppender;
            theAppender = (((this.appender!= null)&&(!this.appender.isEmpty()))?this.getAppender():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "appender", theAppender), currentHashCode, theAppender);
        }
        {
            String theRootLoggerAppender;
            theRootLoggerAppender = this.getRootLoggerAppender();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "rootLoggerAppender", theRootLoggerAppender), currentHashCode, theRootLoggerAppender);
        }
        {
            LoggingLevelType theRootLoggerLevel;
            theRootLoggerLevel = this.getRootLoggerLevel();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "rootLoggerLevel", theRootLoggerLevel), currentHashCode, theRootLoggerLevel);
        }
        {
            AuditingConfigurationType theAuditing;
            theAuditing = this.getAuditing();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "auditing", theAuditing), currentHashCode, theAuditing);
        }
        {
            AdvancedLoggingConfigurationType theAdvanced;
            theAdvanced = this.getAdvanced();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "advanced", theAdvanced), currentHashCode, theAdvanced);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof LoggingConfigurationType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final LoggingConfigurationType that = ((LoggingConfigurationType) object);
        {
            List<SubSystemLoggerConfigurationType> lhsSubSystemLogger;
            lhsSubSystemLogger = (((this.subSystemLogger!= null)&&(!this.subSystemLogger.isEmpty()))?this.getSubSystemLogger():null);
            List<SubSystemLoggerConfigurationType> rhsSubSystemLogger;
            rhsSubSystemLogger = (((that.subSystemLogger!= null)&&(!that.subSystemLogger.isEmpty()))?that.getSubSystemLogger():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "subSystemLogger", lhsSubSystemLogger), LocatorUtils.property(thatLocator, "subSystemLogger", rhsSubSystemLogger), lhsSubSystemLogger, rhsSubSystemLogger)) {
                return false;
            }
        }
        {
            List<ClassLoggerConfigurationType> lhsClassLogger;
            lhsClassLogger = (((this.classLogger!= null)&&(!this.classLogger.isEmpty()))?this.getClassLogger():null);
            List<ClassLoggerConfigurationType> rhsClassLogger;
            rhsClassLogger = (((that.classLogger!= null)&&(!that.classLogger.isEmpty()))?that.getClassLogger():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "classLogger", lhsClassLogger), LocatorUtils.property(thatLocator, "classLogger", rhsClassLogger), lhsClassLogger, rhsClassLogger)) {
                return false;
            }
        }
        {
            List<AppenderConfigurationType> lhsAppender;
            lhsAppender = (((this.appender!= null)&&(!this.appender.isEmpty()))?this.getAppender():null);
            List<AppenderConfigurationType> rhsAppender;
            rhsAppender = (((that.appender!= null)&&(!that.appender.isEmpty()))?that.getAppender():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "appender", lhsAppender), LocatorUtils.property(thatLocator, "appender", rhsAppender), lhsAppender, rhsAppender)) {
                return false;
            }
        }
        {
            String lhsRootLoggerAppender;
            lhsRootLoggerAppender = this.getRootLoggerAppender();
            String rhsRootLoggerAppender;
            rhsRootLoggerAppender = that.getRootLoggerAppender();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "rootLoggerAppender", lhsRootLoggerAppender), LocatorUtils.property(thatLocator, "rootLoggerAppender", rhsRootLoggerAppender), lhsRootLoggerAppender, rhsRootLoggerAppender)) {
                return false;
            }
        }
        {
            LoggingLevelType lhsRootLoggerLevel;
            lhsRootLoggerLevel = this.getRootLoggerLevel();
            LoggingLevelType rhsRootLoggerLevel;
            rhsRootLoggerLevel = that.getRootLoggerLevel();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "rootLoggerLevel", lhsRootLoggerLevel), LocatorUtils.property(thatLocator, "rootLoggerLevel", rhsRootLoggerLevel), lhsRootLoggerLevel, rhsRootLoggerLevel)) {
                return false;
            }
        }
        {
            AuditingConfigurationType lhsAuditing;
            lhsAuditing = this.getAuditing();
            AuditingConfigurationType rhsAuditing;
            rhsAuditing = that.getAuditing();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "auditing", lhsAuditing), LocatorUtils.property(thatLocator, "auditing", rhsAuditing), lhsAuditing, rhsAuditing)) {
                return false;
            }
        }
        {
            AdvancedLoggingConfigurationType lhsAdvanced;
            lhsAdvanced = this.getAdvanced();
            AdvancedLoggingConfigurationType rhsAdvanced;
            rhsAdvanced = that.getAdvanced();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "advanced", lhsAdvanced), LocatorUtils.property(thatLocator, "advanced", rhsAdvanced), lhsAdvanced, rhsAdvanced)) {
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
