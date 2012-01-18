package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.List;


/**
 * TODO
 * <p/>
 * Experimental object. MOST LIKELY WILL CHANGE.
 * <p/>
 * TODO: type???
 * <p/>
 * Defines hierarchical objects - or more exactly nested.
 * <p/>
 * may contain other entitlements. Such a containing object,
 * when assigned to user, is equivalent to the union of all
 * contained objects(and objects contained in the contained
 * objects, ad infinutum). There is no constrain that the containing
 * and contained objects must be of the same type.
 * Therefore it should be possible to create a "business role" that
 * will contain a set of "IT roles" that specify access to resources
 * and a set of "IDM roles" that gives user administrator privileges
 * in midPoint system.
 * <p/>
 * <p/>
 * <p>Java class for ProtoStructureType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
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
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProtoStructureType", propOrder = {
        "containedObjectOrContainedObjectRef"
})
public abstract class ProtoStructureType
        extends ExtensibleObjectType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ProtoStructureType");
    public final static QName F_CONTAINED_OBJECT_OR_CONTAINED_OBJECT_REF = new QName(SchemaConstants.NS_COMMON, "containedObjectOrContainedObjectRef");

    @XmlElements({
            @XmlElement(name = "containedObjectRef", type = ObjectReferenceType.class),
            @XmlElement(name = "containedObject", type = ObjectType.class)
    })
    public List<Serializable> getContainedObjectOrContainedObjectRef() {
        return getPropertyValues(F_CONTAINED_OBJECT_OR_CONTAINED_OBJECT_REF, Serializable.class);
    }

}
