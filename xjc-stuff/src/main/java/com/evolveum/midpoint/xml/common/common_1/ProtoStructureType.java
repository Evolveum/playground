
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *                 TODO
 * 
 *                 Experimental object. MOST LIKELY WILL CHANGE.
 * 
 *                 TODO: type???
 * 
 *                 Defines hierarchical objects - or
 *                 more
 *                 exactly nested.
 * 
 *                 may contain other entitlements. Such a containing
 *                 object, when
 *                 assigned to user, is equivalent to
 *                 the union
 *                 of
 *                 all contained objects
 *                 (and objects contained in the
 *                 contained objects, ad infinutum). There
 *                 is no
 *                 constrain that
 *                 the containing
 *                 and contained objects must be of
 *                 the same type.
 *                 Therefore it should be possible to
 *                 create a "business
 *                 role" that
 *                 will contain a
 *                 set of "IT roles" that specify access to
 *                 resources
 *                 and a set of "IDM
 *                 roles" that gives user administrator
 *                 privileges in midPoint
 *                 system.
 *             
 * 
 * <p>Java class for ProtoStructureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProtoStructureType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExtensibleObjectType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="containedObject" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectType"/>
 *           &lt;element name="containedObjectRef" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectReferenceType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProtoStructureType", propOrder = {
    "containedObjectOrContainedObjectRef"
})
public abstract class ProtoStructureType
    extends ExtensibleObjectType
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    @XmlElements({
        @XmlElement(name = "containedObject", type = ObjectType.class),
        @XmlElement(name = "containedObjectRef", type = ObjectReferenceType.class)
    })
    protected List<Serializable> containedObjectOrContainedObjectRef;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "ProtoStructureType");

    /**
     * Gets the value of the containedObjectOrContainedObjectRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the containedObjectOrContainedObjectRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContainedObjectOrContainedObjectRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObjectType }
     * {@link ObjectReferenceType }
     * 
     * 
     */
    public List<Serializable> getContainedObjectOrContainedObjectRef() {
        if (containedObjectOrContainedObjectRef == null) {
            containedObjectOrContainedObjectRef = new ArrayList<Serializable>();
        }
        return this.containedObjectOrContainedObjectRef;
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
            List<Serializable> theContainedObjectOrContainedObjectRef;
            theContainedObjectOrContainedObjectRef = (((this.containedObjectOrContainedObjectRef!= null)&&(!this.containedObjectOrContainedObjectRef.isEmpty()))?this.getContainedObjectOrContainedObjectRef():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "containedObjectOrContainedObjectRef", theContainedObjectOrContainedObjectRef), currentHashCode, theContainedObjectOrContainedObjectRef);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ProtoStructureType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final ProtoStructureType that = ((ProtoStructureType) object);
        {
            List<Serializable> lhsContainedObjectOrContainedObjectRef;
            lhsContainedObjectOrContainedObjectRef = (((this.containedObjectOrContainedObjectRef!= null)&&(!this.containedObjectOrContainedObjectRef.isEmpty()))?this.getContainedObjectOrContainedObjectRef():null);
            List<Serializable> rhsContainedObjectOrContainedObjectRef;
            rhsContainedObjectOrContainedObjectRef = (((that.containedObjectOrContainedObjectRef!= null)&&(!that.containedObjectOrContainedObjectRef.isEmpty()))?that.getContainedObjectOrContainedObjectRef():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "containedObjectOrContainedObjectRef", lhsContainedObjectOrContainedObjectRef), LocatorUtils.property(thatLocator, "containedObjectOrContainedObjectRef", rhsContainedObjectOrContainedObjectRef), lhsContainedObjectOrContainedObjectRef, rhsContainedObjectOrContainedObjectRef)) {
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
