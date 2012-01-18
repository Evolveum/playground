package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * <p>Java class for FileAppenderConfigurationType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
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
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected String fileName;
    @XmlElement(required = true)
    protected String filePattern;
    protected int maxHistory;
    @XmlElement(required = true)
    protected String maxFileSize;
    protected boolean append;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "FileAppenderConfigurationType");
    public final static QName F_FILE_NAME = new QName(SchemaConstants.NS_COMMON, "fileName");
    public final static QName F_FILE_PATTERN = new QName(SchemaConstants.NS_COMMON, "filePattern");
    public final static QName F_MAX_HISTORY = new QName(SchemaConstants.NS_COMMON, "maxHistory");
    public final static QName F_MAX_FILE_SIZE = new QName(SchemaConstants.NS_COMMON, "maxFileSize");
    public final static QName F_APPEND = new QName(SchemaConstants.NS_COMMON, "append");

    /**
     * Gets the value of the fileName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * Gets the value of the filePattern property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getFilePattern() {
        return filePattern;
    }

    /**
     * Sets the value of the filePattern property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFilePattern(String value) {
        this.filePattern = value;
    }

    /**
     * Gets the value of the maxHistory property.
     */
    public int getMaxHistory() {
        return maxHistory;
    }

    /**
     * Sets the value of the maxHistory property.
     */
    public void setMaxHistory(int value) {
        this.maxHistory = value;
    }

    /**
     * Gets the value of the maxFileSize property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getMaxFileSize() {
        return maxFileSize;
    }

    /**
     * Sets the value of the maxFileSize property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMaxFileSize(String value) {
        this.maxFileSize = value;
    }

    /**
     * Gets the value of the append property.
     */
    public boolean isAppend() {
        return append;
    }

    /**
     * Sets the value of the append property.
     */
    public void setAppend(boolean value) {
        this.append = value;
    }

}
