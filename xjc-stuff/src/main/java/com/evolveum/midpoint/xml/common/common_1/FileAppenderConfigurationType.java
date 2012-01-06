
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
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
 * <p>Java class for FileAppenderConfigurationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileAppenderConfigurationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}AppenderConfigurationType">
 *       &lt;sequence>
 *         &lt;element name="fileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="filePattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="maxHistory" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxFileSize" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="append" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileAppenderConfigurationType", propOrder = {
    "fileName",
    "filePattern",
    "maxHistory",
    "maxFileSize",
    "append"
})
public class FileAppenderConfigurationType
    extends AppenderConfigurationType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected String fileName;
    @XmlElement(required = true)
    protected String filePattern;
    protected int maxHistory;
    @XmlElement(required = true)
    protected String maxFileSize;
    protected boolean append;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "FileAppenderConfigurationType");

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * Gets the value of the filePattern property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilePattern() {
        return filePattern;
    }

    /**
     * Sets the value of the filePattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilePattern(String value) {
        this.filePattern = value;
    }

    /**
     * Gets the value of the maxHistory property.
     * 
     */
    public int getMaxHistory() {
        return maxHistory;
    }

    /**
     * Sets the value of the maxHistory property.
     * 
     */
    public void setMaxHistory(int value) {
        this.maxHistory = value;
    }

    /**
     * Gets the value of the maxFileSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxFileSize() {
        return maxFileSize;
    }

    /**
     * Sets the value of the maxFileSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxFileSize(String value) {
        this.maxFileSize = value;
    }

    /**
     * Gets the value of the append property.
     * 
     */
    public boolean isAppend() {
        return append;
    }

    /**
     * Sets the value of the append property.
     * 
     */
    public void setAppend(boolean value) {
        this.append = value;
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
        int currentHashCode = super.hashCode(locator, strategy);
        {
            String theFileName;
            theFileName = this.getFileName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fileName", theFileName), currentHashCode, theFileName);
        }
        {
            String theFilePattern;
            theFilePattern = this.getFilePattern();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "filePattern", theFilePattern), currentHashCode, theFilePattern);
        }
        {
            int theMaxHistory;
            theMaxHistory = (true?this.getMaxHistory(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "maxHistory", theMaxHistory), currentHashCode, theMaxHistory);
        }
        {
            String theMaxFileSize;
            theMaxFileSize = this.getMaxFileSize();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "maxFileSize", theMaxFileSize), currentHashCode, theMaxFileSize);
        }
        {
            boolean theAppend;
            theAppend = (true?this.isAppend():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "append", theAppend), currentHashCode, theAppend);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FileAppenderConfigurationType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final FileAppenderConfigurationType that = ((FileAppenderConfigurationType) object);
        {
            String lhsFileName;
            lhsFileName = this.getFileName();
            String rhsFileName;
            rhsFileName = that.getFileName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fileName", lhsFileName), LocatorUtils.property(thatLocator, "fileName", rhsFileName), lhsFileName, rhsFileName)) {
                return false;
            }
        }
        {
            String lhsFilePattern;
            lhsFilePattern = this.getFilePattern();
            String rhsFilePattern;
            rhsFilePattern = that.getFilePattern();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "filePattern", lhsFilePattern), LocatorUtils.property(thatLocator, "filePattern", rhsFilePattern), lhsFilePattern, rhsFilePattern)) {
                return false;
            }
        }
        {
            int lhsMaxHistory;
            lhsMaxHistory = (true?this.getMaxHistory(): 0);
            int rhsMaxHistory;
            rhsMaxHistory = (true?that.getMaxHistory(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "maxHistory", lhsMaxHistory), LocatorUtils.property(thatLocator, "maxHistory", rhsMaxHistory), lhsMaxHistory, rhsMaxHistory)) {
                return false;
            }
        }
        {
            String lhsMaxFileSize;
            lhsMaxFileSize = this.getMaxFileSize();
            String rhsMaxFileSize;
            rhsMaxFileSize = that.getMaxFileSize();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "maxFileSize", lhsMaxFileSize), LocatorUtils.property(thatLocator, "maxFileSize", rhsMaxFileSize), lhsMaxFileSize, rhsMaxFileSize)) {
                return false;
            }
        }
        {
            boolean lhsAppend;
            lhsAppend = (true?this.isAppend():false);
            boolean rhsAppend;
            rhsAppend = (true?that.isAppend():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "append", lhsAppend), LocatorUtils.property(thatLocator, "append", rhsAppend), lhsAppend, rhsAppend)) {
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
