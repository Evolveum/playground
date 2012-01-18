package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Describes object addition (creation, operation "add").
 * <p/>
 * <p/>
 * <p>Java class for ObjectChangeAdditionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ObjectChangeAdditionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectChangeType">
 *       &lt;sequence>
 *         &lt;element name="object" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObjectChangeAdditionType", propOrder = {
        "object"
})
public class ObjectChangeAdditionType
        extends ObjectChangeType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected ObjectType object;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ObjectChangeAdditionType");
    public final static QName F_OBJECT = new QName(SchemaConstants.NS_COMMON, "object");

    /**
     * Gets the value of the object property.
     *
     * @return possible object is
     *         {@link ObjectType }
     */
    public ObjectType getObject() {
        return object;
    }

    /**
     * Sets the value of the object property.
     *
     * @param value allowed object is
     *              {@link ObjectType }
     */
    public void setObject(ObjectType value) {
        this.object = value;
    }

}
