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
 * <p>Java class for NAryLogicalOperatorFilterType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="NAryLogicalOperatorFilterType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}LogicalOperatorFilterType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}filter" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NAryLogicalOperatorFilterType", propOrder = {
        "filter"
})
public class NAryLogicalOperatorFilterType
        extends LogicalOperatorFilterType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlAnyElement
    protected List<Element> filter;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "NAryLogicalOperatorFilterType");
    public final static QName F_FILTER = new QName(SchemaConstants.NS_COMMON, "filter");

    /**
     * Gets the value of the filter property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filter property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilter().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     */
    public List<Element> getFilter() {
        if (filter == null) {
            filter = new ArrayList<Element>();
        }
        return this.filter;
    }

}
