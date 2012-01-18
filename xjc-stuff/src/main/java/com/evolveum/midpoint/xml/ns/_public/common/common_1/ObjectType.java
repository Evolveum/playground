package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.List;


/**
 * Common supertype for all identity objects.
 * <p/>
 * Defines basic properties that each object must have to live in
 * our system (identifier, name).
 * <p/>
 * Objects consists of identifier and name (see definition below)
 * and a set of properties represented as XML elements in the
 * object's body. The properties are represented as first-level
 * XML elements (tags) of the object XML representation and may
 * be also contained in other tags (e.g. extension, attributes)
 * that are marked by a propertyContainer annotation. The QName
 * (namespace and local name) of the element holding the property
 * is considered to be a property name.
 * <p/>
 * Single-value properties must appear as a none or one instance
 * of the XML element holding the value.
 * <p/>
 * Multi-value properties must appear as none or more instances of
 * the same XML element. Multi-valued properties are regarded as
 * unordered sets. Duplicate values are allowed, but duplicates
 * should not be preserved by the implementations. The implementations
 * should reduce duplicate values to a single value if it is
 * possible and efficient.
 * <p/>
 * If an element for a specific property does not appear in the
 * object it means that the property value is undefined (property
 * does not exists). This is a different state as compared to
 * passing an empty XML element. Empty XML element means that the
 * property exists, but has an empty (null) value. Implementations
 * must be able to handle undefined (non-existent) properties, but
 * may NOT be able to handle empty (null) values. The use of empty
 * (null) values is DISCOURADGED.
 * <p/>
 * It is not mandated by this specification how to pass ordered
 * lists and multi-value properties with duplicates. However it is
 * recommended to use single value properties with appropriate complex
 * XML data structures to hold such data.
 * <p/>
 * The following XML snippet is an example of the object (omitting
 * namespace definitions, but assuming default namespace to be the
 * target namespace of this schema definition):
 * <p/>
 * <p/>
 * <p/>
 * The above example describes an object with identifier "d3adm3a4",
 * name "foobar" and type defined by its top-level element User that
 * corresponds to URI "http://midpoint.evolveum.com/xml/ns/identity/1#User".
 * The object has 7 properties. Three of them are standard
 * properties defined by this schema:
 * <p/>
 * Standard properties "fullName", "givenName" and "familyName"
 * in default namespace. These are single-valued string properties.
 * <p/>
 * All the other properties are non-standard "extended" properties,
 * but they are considered equal to the standard attributes. They are
 * quarantined in the <extension> tag only to avoid XSD unique
 * particle attribution (UPA) problems. In the above example the
 * non-standard properties are:
 * <p/>
 * Property "geekName" in namespace defined by "foo" prefix. This is also
 * single-valued string property.
 * <p/>
 * Multi-valued non-standard property "guild". It is a string property
 * with multiple values. Multiple values are represented by providing
 * multiple instances of XML elements in the document.
 * Such properties are typically used for roles, groups, etc.
 * <p/>
 * Complex property "pet". This property is defined by
 * complex XML type, using XML sub-elements to
 * represent structured data. Note that the use of XML attributes
 * is discouraged in the properties, although it might be possible in
 * some cases. This is also multi-valued property.
 * <p/>
 * Complex property "shoppingPreferences". This property is using
 * complex XML type to form a structure of XML elements to
 * represent data. This is a single-valued property.
 * Note that the sub-elements "tShirt" and "tie" are NOT considered
 * to be properties.
 * <p/>
 * QName-URI mapping:
 * <p/>
 * For the purpose of this schema and all components that are using it,
 * URIs and QNames are considered equivalent. This is required by WWW
 * architecture and also helps avoid some drawbacks and bugs in XML-related
 * implementations that usually do not deal QNames well.
 * <p/>
 * The QNames are mapped to URIs by concatenating namespace URI and a local
 * name. If URI does not end with slash (/) or hash (#) character, slash is
 * concatenated to the URI before adding the local name. The URI-QName
 * mapping is the reverse process.
 * <p/>
 * <p/>
 * <p/>
 * <p>Java class for ObjectType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ObjectType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}name" minOccurs="0"/>
 *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}description" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="oid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObjectType", propOrder = {
        "name",
        "description"
})
@XmlSeeAlso({
        PasswordPolicyType.class,
        ExtensibleObjectType.class
})
public abstract class ObjectType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ObjectType");
    public final static QName F_NAME = new QName(SchemaConstants.NS_COMMON, "name");
    public final static QName F_DESCRIPTION = new QName(SchemaConstants.NS_COMMON, "description");
    public final static QName F_VERSION = new QName(SchemaConstants.NS_COMMON, "version");
    @XmlTransient
    private MidpointObject container;

    /**
     * DO NOT USE! For testing purposes only.
     */
    @Deprecated
    public MidpointObject getContainer() {
        if (container == null) {
            container = new MidpointObject(COMPLEX_TYPE);
        }
        return container;
    }

    /**
     * DO NOT USE! For testing purposes only.
     */
    @Deprecated
    public void setContainer(MidpointObject container) {
        if (container == null) {
            container = null;
            return;
        }
        if (!COMPLEX_TYPE.equals(container.getName())) {
            throw new IllegalArgumentException((((("Container qname '" + container.getName()) + "' doesn't equals to '") + COMPLEX_TYPE) + "'."));
        }
        this.container = container;
    }

    /**
     * DO NOT USE! For testing purposes only.
     */
    @Deprecated
    <T> List<T> getPropertyValues(QName name, Class<T> clazz) {
        //todo implement in xjc processing with using XmlUtil
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    /**
     * DO NOT USE! For testing purposes only.
     */
    @Deprecated
    <T> T getPropertyValue(QName name, Class<T> clazz) {
        //todo implement in xjc processing with using XmlUtil
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    /**
     * DO NOT USE! For testing purposes only.
     */
    @Deprecated
    <T> void setPropertyValue(QName name, T value) {
        //todo implement in xjc processing with using XmlUtil
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    public String getName() {
        return getPropertyValue(F_NAME, String.class);
    }

    public void setName(String value) {
        setPropertyValue(F_NAME, value);
    }

    public String getDescription() {
        return getPropertyValue(F_DESCRIPTION, String.class);
    }

    public void setDescription(String value) {
        setPropertyValue(F_DESCRIPTION, value);
    }

    @XmlAttribute(name = "oid")
    public String getOid() {
        return getContainer().getOid();
    }

    public void setOid(String value) {
        getContainer().setOid(value);
    }

    @XmlAttribute(name = "version")
    public String getVersion() {
        return getPropertyValue(F_VERSION, String.class);
    }

    public void setVersion(String value) {
        setPropertyValue(F_VERSION, value);
    }

}
