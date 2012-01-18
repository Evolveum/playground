package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Defines an assignment of value from one place (or
 * expression) to another place.
 * This is supposed to be a general-purpose construct.
 * TODO: merging options
 * <p/>
 * This type is marked with jaxb:dom annotation, which will avoid
 * JAXB parsing of it. This is a workaround to a JAXB limitation,
 * which cannot handle more than one "any" elements in a type.
 * See http://java.net/jira/browse/JAXB-798
 * <p/>
 * <p/>
 * <p>Java class for ValueAssignmentType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ValueAssignmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}description" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}valueFilter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="source" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExpressionType" minOccurs="0"/>
 *         &lt;element name="target" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}XPathType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValueAssignmentType", propOrder = {
        "description",
        "valueFilter",
        "source",
        "target"
})
public class ValueAssignmentType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected String description;
    protected List<ValueFilterType> valueFilter;
    protected ExpressionType source;
    @XmlAnyElement
    protected Element target;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ValueAssignmentType");
    public final static QName F_DESCRIPTION = new QName(SchemaConstants.NS_COMMON, "description");
    public final static QName F_VALUE_FILTER = new QName(SchemaConstants.NS_COMMON, "valueFilter");
    public final static QName F_SOURCE = new QName(SchemaConstants.NS_COMMON, "source");
    public final static QName F_TARGET = new QName(SchemaConstants.NS_COMMON, "target");

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
     * List of filters that will be applied to the value before
     * it even gets processed by this assignment. The filters
     * will get applied even before the expression.
     * <p/>
     * The filters will be executed in chain in the
     * order as specified here.
     * <p/>
     * The filters are supposed to "clean up" or transcode
     * the value to comply with usual XML standards.
     * (but see the note in ValueFilterType documentation)
     * Gets the value of the valueFilter property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valueFilter property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValueFilter().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ValueFilterType }
     */
    public List<ValueFilterType> getValueFilter() {
        if (valueFilter == null) {
            valueFilter = new ArrayList<ValueFilterType>();
        }
        return this.valueFilter;
    }

    /**
     * Gets the value of the source property.
     *
     * @return possible object is
     *         {@link ExpressionType }
     */
    public ExpressionType getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     *
     * @param value allowed object is
     *              {@link ExpressionType }
     */
    public void setSource(ExpressionType value) {
        this.source = value;
    }

    /**
     * Gets the value of the target property.
     *
     * @return possible object is
     *         {@link Element }
     */
    public Element getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     *
     * @param value allowed object is
     *              {@link Element }
     */
    public void setTarget(Element value) {
        this.target = value;
    }

}
