package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Generic object for storing unknown (unexpected) object types.
 * <p/>
 * The generic object should be used if there is a need to
 * store a custom object (e.g KangarooType) at deployment-time
 * and the XML type relacement extensibility cannot be used.
 * The properties of such custom objects are to be placed in the
 * extension part of this object. The schema is not checked or
 * enforced for this type of objects if technically possible.
 * <p/>
 * <p/>
 * <p>Java class for GenericObjectType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GenericObjectType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExtensibleObjectType">
 *       &lt;sequence>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericObjectType", propOrder = {
        "objectType"
})
public class GenericObjectType
        extends ExtensibleObjectType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "GenericObjectType");
    public final static QName F_OBJECT_TYPE = new QName(SchemaConstants.NS_COMMON, "objectType");

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    public String getObjectType() {
        return getPropertyValue(F_OBJECT_TYPE, String.class);
    }

    public void setObjectType(String value) {
        setPropertyValue(F_OBJECT_TYPE, value);
    }

}
