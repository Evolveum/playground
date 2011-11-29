package eu.evolveum.midpoint.web.component.autoform;

import com.evolveum.midpoint.schema.constants.SchemaConstants;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

public enum AttributeType {

    INT(new QName(XMLConstants.W3C_XML_SCHEMA_NS_URI, "int")),

    INTEGER(new QName(XMLConstants.W3C_XML_SCHEMA_NS_URI, "integer")),

    INTEGER_NEGATIVE(new QName(XMLConstants.W3C_XML_SCHEMA_NS_URI, "negativeInteger")),

    INTEGER_NON_NEGATIVE(new QName(XMLConstants.W3C_XML_SCHEMA_NS_URI, "nonNegativeInteger")),

    INTEGER_NON_POSITIVE(new QName(XMLConstants.W3C_XML_SCHEMA_NS_URI, "nonPositiveInteger")),

    INTEGER_POSITIVE(new QName(XMLConstants.W3C_XML_SCHEMA_NS_URI, "positiveInteger")),

    BOOLEAN(new QName(XMLConstants.W3C_XML_SCHEMA_NS_URI, "boolean")),

    LONG(new QName(XMLConstants.W3C_XML_SCHEMA_NS_URI, "long")),

    SHORT(new QName(XMLConstants.W3C_XML_SCHEMA_NS_URI, "short")),

    ANY_URI(new QName(XMLConstants.W3C_XML_SCHEMA_NS_URI, "anyURI")),

    STRING(new QName(XMLConstants.W3C_XML_SCHEMA_NS_URI, "string")),

    DATE(new QName(XMLConstants.W3C_XML_SCHEMA_NS_URI, "date")),

//	ELEMENT(new QName("http://midpoint.evolveum.com", "element")),

    PASSWORD(SchemaConstants.R_PROTECTED_STRING_TYPE);

    private QName qname;

    private AttributeType(QName qname) {
        this.qname = qname;
    }

    public QName getQname() {
        return qname;
    }

    public static AttributeType getType(QName qname) {
        AttributeType[] values = values();
        for (AttributeType type : values) {
            if (type.qname.equals(qname)) {
                return type;
            }
        }

        return STRING;
    }
}
