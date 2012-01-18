package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Script argument. It is subtype of Value Construction, therefore
 * the value may be static of dynamically constructed using an
 * expression. The "default" and "authoritative" flags are not
 * applicable here.
 * <p/>
 * <p/>
 * <p>Java class for ScriptArgumentType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ScriptArgumentType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ValueConstructionType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScriptArgumentType", propOrder = {
        "name"
})
public class ScriptArgumentType
        extends ValueConstructionType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlElement(required = true)
    protected String name;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "ScriptArgumentType");
    public final static QName F_NAME = new QName(SchemaConstants.NS_COMMON, "name");

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

}
