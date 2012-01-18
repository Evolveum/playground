package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Description of the attribute handling details, such as display name,
 * read/write access and value and synchronization expressions.
 * <p/>
 * This is supposed to be used in schemaHandling part and therefore
 * describe the decisions of the system administrator about the
 * way how that attribute is used in midPoint.
 * <p/>
 * This is supposed to be used only in schemaHandling. It is not a reusable
 * data structure now (composition).
 * <p/>
 * <p/>
 * <p>Java class for ResourceAttributeDefinitionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ResourceAttributeDefinitionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ref" type="{http://www.w3.org/2001/XMLSchema}QName"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}displayName" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}description" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ignore" minOccurs="0"/>
 *         &lt;element name="tolerant" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}access" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="outbound" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ValueConstructionType" minOccurs="0"/>
 *         &lt;element name="inbound" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ValueAssignmentType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceAttributeDefinitionType", propOrder = {
        "ref",
        "displayName",
        "description",
        "ignore",
        "tolerant",
        "access",
        "outbound",
        "inbound"
})
public class ResourceAttributeDefinitionType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected QName ref;
    protected String displayName;
    protected String description;
    @XmlElement(defaultValue = "true")
    protected Boolean ignore;
    @XmlElement(defaultValue = "true")
    protected Boolean tolerant;
    protected List<AccessType> access;
    protected ValueConstructionType outbound;
    @XmlAnyElement
    protected List<Element> inbound;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ResourceAttributeDefinitionType");
    public final static QName F_REF = new QName(SchemaConstants.NS_COMMON, "ref");
    public final static QName F_DISPLAY_NAME = new QName(SchemaConstants.NS_COMMON, "displayName");
    public final static QName F_DESCRIPTION = new QName(SchemaConstants.NS_COMMON, "description");
    public final static QName F_IGNORE = new QName(SchemaConstants.NS_COMMON, "ignore");
    public final static QName F_TOLERANT = new QName(SchemaConstants.NS_COMMON, "tolerant");
    public final static QName F_ACCESS = new QName(SchemaConstants.NS_COMMON, "access");
    public final static QName F_OUTBOUND = new QName(SchemaConstants.NS_COMMON, "outbound");
    public final static QName F_INBOUND = new QName(SchemaConstants.NS_COMMON, "inbound");

    /**
     * Gets the value of the ref property.
     *
     * @return possible object is
     *         {@link QName }
     */
    public QName getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     *
     * @param value allowed object is
     *              {@link QName }
     */
    public void setRef(QName value) {
        this.ref = value;
    }

    /**
     * Gets the value of the displayName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the value of the displayName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the ignore property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isIgnore() {
        return ignore;
    }

    /**
     * Sets the value of the ignore property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIgnore(Boolean value) {
        this.ignore = value;
    }

    /**
     * Gets the value of the tolerant property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isTolerant() {
        return tolerant;
    }

    /**
     * Sets the value of the tolerant property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setTolerant(Boolean value) {
        this.tolerant = value;
    }

    /**
     * Access to the attribute as defined by the system administrator or deployer.
     * This can constrain the access defined by resource schema annotations.
     * Specifying broader access that the resource connector can handle is an
     * error.
     * <p/>
     * If no access is specified, it defaults to access definition specified in the
     * resource schema annotations.
     * Gets the value of the access property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the access property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccess().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link AccessType }
     */
    public List<AccessType> getAccess() {
        if (access == null) {
            access = new ArrayList<AccessType>();
        }
        return this.access;
    }

    /**
     * Gets the value of the outbound property.
     *
     * @return possible object is
     *         {@link ValueConstructionType }
     */
    public ValueConstructionType getOutbound() {
        return outbound;
    }

    /**
     * Sets the value of the outbound property.
     *
     * @param value allowed object is
     *              {@link ValueConstructionType }
     */
    public void setOutbound(ValueConstructionType value) {
        this.outbound = value;
    }

    /**
     * Gets the value of the inbound property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inbound property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInbound().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     */
    public List<Element> getInbound() {
        if (inbound == null) {
            inbound = new ArrayList<Element>();
        }
        return this.inbound;
    }

}
