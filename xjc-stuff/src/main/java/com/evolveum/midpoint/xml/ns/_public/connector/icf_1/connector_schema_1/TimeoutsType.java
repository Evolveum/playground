package com.evolveum.midpoint.xml.ns._public.connector.icf_1.connector_schema_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.math.BigInteger;


/**
 * Type that contains configuration of ICF operation timeouts.
 * <p/>
 * <p/>
 * <p>Java class for TimeoutsType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="TimeoutsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="create" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="get" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="update" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="delete" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="test" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="scriptOnConnector" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="scriptOnResource" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="authentication" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="search" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="validate" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="sync" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="schema" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeoutsType", propOrder = {
        "create",
        "get",
        "update",
        "delete",
        "test",
        "scriptOnConnector",
        "scriptOnResource",
        "authentication",
        "search",
        "validate",
        "sync",
        "schema"
})
public class TimeoutsType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected BigInteger create;
    protected BigInteger get;
    protected BigInteger update;
    protected BigInteger delete;
    protected BigInteger test;
    protected BigInteger scriptOnConnector;
    protected BigInteger scriptOnResource;
    protected BigInteger authentication;
    protected BigInteger search;
    protected BigInteger validate;
    protected BigInteger sync;
    protected BigInteger schema;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_ICF_SCHEMA, "TimeoutsType");
    public final static QName F_CREATE = new QName(SchemaConstants.NS_ICF_SCHEMA, "create");
    public final static QName F_GET = new QName(SchemaConstants.NS_ICF_SCHEMA, "get");
    public final static QName F_UPDATE = new QName(SchemaConstants.NS_ICF_SCHEMA, "update");
    public final static QName F_DELETE = new QName(SchemaConstants.NS_ICF_SCHEMA, "delete");
    public final static QName F_TEST = new QName(SchemaConstants.NS_ICF_SCHEMA, "test");
    public final static QName F_SCRIPT_ON_CONNECTOR = new QName(SchemaConstants.NS_ICF_SCHEMA, "scriptOnConnector");
    public final static QName F_SCRIPT_ON_RESOURCE = new QName(SchemaConstants.NS_ICF_SCHEMA, "scriptOnResource");
    public final static QName F_AUTHENTICATION = new QName(SchemaConstants.NS_ICF_SCHEMA, "authentication");
    public final static QName F_SEARCH = new QName(SchemaConstants.NS_ICF_SCHEMA, "search");
    public final static QName F_VALIDATE = new QName(SchemaConstants.NS_ICF_SCHEMA, "validate");
    public final static QName F_SYNC = new QName(SchemaConstants.NS_ICF_SCHEMA, "sync");
    public final static QName F_SCHEMA = new QName(SchemaConstants.NS_ICF_SCHEMA, "schema");

    /**
     * Gets the value of the create property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getCreate() {
        return create;
    }

    /**
     * Sets the value of the create property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setCreate(BigInteger value) {
        this.create = value;
    }

    /**
     * Gets the value of the get property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getGet() {
        return get;
    }

    /**
     * Sets the value of the get property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setGet(BigInteger value) {
        this.get = value;
    }

    /**
     * Gets the value of the update property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getUpdate() {
        return update;
    }

    /**
     * Sets the value of the update property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setUpdate(BigInteger value) {
        this.update = value;
    }

    /**
     * Gets the value of the delete property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getDelete() {
        return delete;
    }

    /**
     * Sets the value of the delete property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setDelete(BigInteger value) {
        this.delete = value;
    }

    /**
     * Gets the value of the test property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getTest() {
        return test;
    }

    /**
     * Sets the value of the test property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setTest(BigInteger value) {
        this.test = value;
    }

    /**
     * Gets the value of the scriptOnConnector property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getScriptOnConnector() {
        return scriptOnConnector;
    }

    /**
     * Sets the value of the scriptOnConnector property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setScriptOnConnector(BigInteger value) {
        this.scriptOnConnector = value;
    }

    /**
     * Gets the value of the scriptOnResource property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getScriptOnResource() {
        return scriptOnResource;
    }

    /**
     * Sets the value of the scriptOnResource property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setScriptOnResource(BigInteger value) {
        this.scriptOnResource = value;
    }

    /**
     * Gets the value of the authentication property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getAuthentication() {
        return authentication;
    }

    /**
     * Sets the value of the authentication property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setAuthentication(BigInteger value) {
        this.authentication = value;
    }

    /**
     * Gets the value of the search property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getSearch() {
        return search;
    }

    /**
     * Sets the value of the search property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setSearch(BigInteger value) {
        this.search = value;
    }

    /**
     * Gets the value of the validate property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getValidate() {
        return validate;
    }

    /**
     * Sets the value of the validate property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setValidate(BigInteger value) {
        this.validate = value;
    }

    /**
     * Gets the value of the sync property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getSync() {
        return sync;
    }

    /**
     * Sets the value of the sync property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setSync(BigInteger value) {
        this.sync = value;
    }

    /**
     * Gets the value of the schema property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getSchema() {
        return schema;
    }

    /**
     * Sets the value of the schema property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setSchema(BigInteger value) {
        this.schema = value;
    }

}
