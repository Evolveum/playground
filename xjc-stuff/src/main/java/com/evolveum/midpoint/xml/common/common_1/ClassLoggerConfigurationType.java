
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
 *                 Configuration of the logger: the facility that
 *                 collects log
 *                 messages from the code.
 *             
 * 
 * <p>Java class for ClassLoggerConfigurationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClassLoggerConfigurationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="level" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}LoggingLevelType"/>
 *         &lt;element name="package" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appender" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassLoggerConfigurationType", propOrder = {
    "level",
    "_package",
    "appender"
})
public class ClassLoggerConfigurationType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected LoggingLevelType level;
    @XmlElement(name = "package", required = true)
    protected String _package;
    protected List<String> appender;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ClassLoggerConfigurationType");

    /**
     * Gets the value of the level property.
     * 
     * @return
     *     possible object is
     *     {@link LoggingLevelType }
     *     
     */
    public LoggingLevelType getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoggingLevelType }
     *     
     */
    public void setLevel(LoggingLevelType value) {
        this.level = value;
    }

    /**
     * Gets the value of the package property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackage() {
        return _package;
    }

    /**
     * Sets the value of the package property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackage(String value) {
        this._package = value;
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
     * {@link String }
     * 
     * 
     */
    public List<String> getAppender() {
        if (appender == null) {
            appender = new ArrayList<String>();
        }
        return this.appender;
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
            LoggingLevelType theLevel;
            theLevel = this.getLevel();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "level", theLevel), currentHashCode, theLevel);
        }
        {
            String thePackage;
            thePackage = this.getPackage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "_package", thePackage), currentHashCode, thePackage);
        }
        {
            List<String> theAppender;
            theAppender = (((this.appender!= null)&&(!this.appender.isEmpty()))?this.getAppender():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "appender", theAppender), currentHashCode, theAppender);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ClassLoggerConfigurationType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ClassLoggerConfigurationType that = ((ClassLoggerConfigurationType) object);
        {
            LoggingLevelType lhsLevel;
            lhsLevel = this.getLevel();
            LoggingLevelType rhsLevel;
            rhsLevel = that.getLevel();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "level", lhsLevel), LocatorUtils.property(thatLocator, "level", rhsLevel), lhsLevel, rhsLevel)) {
                return false;
            }
        }
        {
            String lhsPackage;
            lhsPackage = this.getPackage();
            String rhsPackage;
            rhsPackage = that.getPackage();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "_package", lhsPackage), LocatorUtils.property(thatLocator, "_package", rhsPackage), lhsPackage, rhsPackage)) {
                return false;
            }
        }
        {
            List<String> lhsAppender;
            lhsAppender = (((this.appender!= null)&&(!this.appender.isEmpty()))?this.getAppender():null);
            List<String> rhsAppender;
            rhsAppender = (((that.appender!= null)&&(!that.appender.isEmpty()))?that.getAppender():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "appender", lhsAppender), LocatorUtils.property(thatLocator, "appender", rhsAppender), lhsAppender, rhsAppender)) {
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
