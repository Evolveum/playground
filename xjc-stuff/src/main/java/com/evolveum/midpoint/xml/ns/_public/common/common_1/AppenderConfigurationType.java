package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Configuration of the logger: the facility that
 * collects log messages from the code.
 * <p/>
 * TODO
 * <p/>
 * <p/>
 * <p>Java class for AppenderConfigurationType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AppenderConfigurationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppenderConfigurationType", propOrder = {
        "pattern"
})
@XmlSeeAlso({
        FileAppenderConfigurationType.class
})
public class AppenderConfigurationType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected String pattern;
    @XmlAttribute(name = "name")
    protected String name;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "AppenderConfigurationType");
    public final static QName F_PATTERN = new QName(SchemaConstants.NS_COMMON, "pattern");
    public final static QName F_NAME = new QName(SchemaConstants.NS_COMMON, "name");

    /**
     * Gets the value of the pattern property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * Sets the value of the pattern property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPattern(String value) {
        this.pattern = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

}
