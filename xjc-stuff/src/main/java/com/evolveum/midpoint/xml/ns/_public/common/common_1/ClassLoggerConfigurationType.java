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
 * collects log messages from the code.
 * <p/>
 * <p/>
 * <p>Java class for ClassLoggerConfigurationType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
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
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassLoggerConfigurationType", propOrder = {
        "level",
        "_package",
        "appender"
})
public class ClassLoggerConfigurationType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected LoggingLevelType level;
    @XmlElement(name = "package", required = true)
    protected String _package;
    protected List<String> appender;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ClassLoggerConfigurationType");
    public final static QName F_LEVEL = new QName(SchemaConstants.NS_COMMON, "level");
    public final static QName F__PACKAGE = new QName(SchemaConstants.NS_COMMON, "_package");
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
     * Gets the value of the package property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPackage() {
        return _package;
    }

    /**
     * Sets the value of the package property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPackage(String value) {
        this._package = value;
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
