package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.List;


/**
 * The user template used to create new users. It
 * contains fixed values or expressions that can set-up
 * a new user obejct. It is used only during user creation in the
 * synchronization code, but will be most likely used also
 * on other places later.
 * <p/>
 * The goal is to make this a kind of "policy" how the use object
 * should look like and check it on every user modification.
 * <p/>
 * <p/>
 * <p>Java class for UserTemplateType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UserTemplateType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExtensibleObjectType">
 *       &lt;sequence>
 *         &lt;element name="propertyConstruction" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}PropertyConstructionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="accountConstruction" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}AccountConstructionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserTemplateType", propOrder = {
        "propertyConstruction",
        "accountConstruction"
})
public class UserTemplateType
        extends ExtensibleObjectType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "UserTemplateType");
    public final static QName F_PROPERTY_CONSTRUCTION = new QName(SchemaConstants.NS_COMMON, "propertyConstruction");
    public final static QName F_ACCOUNT_CONSTRUCTION = new QName(SchemaConstants.NS_COMMON, "accountConstruction");

    public List<PropertyConstructionType> getPropertyConstruction() {
        return getPropertyValues(F_PROPERTY_CONSTRUCTION, PropertyConstructionType.class);
    }

    public List<AccountConstructionType> getAccountConstruction() {
        return getPropertyValues(F_ACCOUNT_CONSTRUCTION, AccountConstructionType.class);
    }

}
