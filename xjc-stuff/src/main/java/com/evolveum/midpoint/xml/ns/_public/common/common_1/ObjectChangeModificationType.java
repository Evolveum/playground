package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Describes object modification (operation "modify").
 * <p/>
 * <p/>
 * <p>Java class for ObjectChangeModificationType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ObjectChangeModificationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectChangeType">
 *       &lt;sequence>
 *         &lt;element name="objectModification" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectModificationType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObjectChangeModificationType", propOrder = {
        "objectModification"
})
public class ObjectChangeModificationType
        extends ObjectChangeType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected ObjectModificationType objectModification;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ObjectChangeModificationType");
    public final static QName F_OBJECT_MODIFICATION = new QName(SchemaConstants.NS_COMMON, "objectModification");

    /**
     * Gets the value of the objectModification property.
     *
     * @return possible object is
     *         {@link ObjectModificationType }
     */
    public ObjectModificationType getObjectModification() {
        return objectModification;
    }

    /**
     * Sets the value of the objectModification property.
     *
     * @param value allowed object is
     *              {@link ObjectModificationType }
     */
    public void setObjectModification(ObjectModificationType value) {
        this.objectModification = value;
    }

}
