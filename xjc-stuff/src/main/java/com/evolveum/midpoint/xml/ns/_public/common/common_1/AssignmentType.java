package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Generic assignments of one object to another object.
 * This will usually be assignment of a role to a user, assignment of an
 * organizational unit, team or whatever. It may also be used to assing
 * role to another role, creating a role hierarchy.
 * <p/>
 * Assignment is an abstract concept. It can be anything that
 * gives the "receptor" object additional access rights, privileges,
 * capabilities or similar ability or right. But it may also constraint
 * the object with policy, e.g. to impelemt separation of duties. Roles,
 * organizations and privileges in IDM system are examples of assignments.
 * <p/>
 * The assignemtn may target either existing IDM object (such as a role)
 * or abstract resource account that may or may not exist. In case of resource
 * objects it is constrained to accounts, as accoutns are the only resource objects
 * that can be assigned to a user. Other resource objects (entitlements) can
 * be assigned to accounts, but not to users.
 * <p/>
 * TODO: constraints
 * <p/>
 * <p/>
 * <p/>
 * <p>Java class for AssignmentType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AssignmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="target" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectType"/>
 *           &lt;element name="targetRef" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectReferenceType"/>
 *           &lt;element name="accountConstruction" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}AccountConstructionType"/>
 *         &lt;/choice>
 *         &lt;element name="activation" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ActivationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssignmentType", propOrder = {
        "target",
        "targetRef",
        "accountConstruction",
        "activation"
})
public class AssignmentType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected ObjectType target;
    protected ObjectReferenceType targetRef;
    protected AccountConstructionType accountConstruction;
    protected ActivationType activation;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "AssignmentType");
    public final static QName F_TARGET = new QName(SchemaConstants.NS_COMMON, "target");
    public final static QName F_TARGET_REF = new QName(SchemaConstants.NS_COMMON, "targetRef");
    public final static QName F_ACCOUNT_CONSTRUCTION = new QName(SchemaConstants.NS_COMMON, "accountConstruction");
    public final static QName F_ACTIVATION = new QName(SchemaConstants.NS_COMMON, "activation");

    /**
     * Gets the value of the target property.
     *
     * @return possible object is
     *         {@link ObjectType }
     */
    public ObjectType getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     *
     * @param value allowed object is
     *              {@link ObjectType }
     */
    public void setTarget(ObjectType value) {
        this.target = value;
    }

    /**
     * Gets the value of the targetRef property.
     *
     * @return possible object is
     *         {@link ObjectReferenceType }
     */
    public ObjectReferenceType getTargetRef() {
        return targetRef;
    }

    /**
     * Sets the value of the targetRef property.
     *
     * @param value allowed object is
     *              {@link ObjectReferenceType }
     */
    public void setTargetRef(ObjectReferenceType value) {
        this.targetRef = value;
    }

    /**
     * Gets the value of the accountConstruction property.
     *
     * @return possible object is
     *         {@link AccountConstructionType }
     */
    public AccountConstructionType getAccountConstruction() {
        return accountConstruction;
    }

    /**
     * Sets the value of the accountConstruction property.
     *
     * @param value allowed object is
     *              {@link AccountConstructionType }
     */
    public void setAccountConstruction(AccountConstructionType value) {
        this.accountConstruction = value;
    }

    /**
     * Gets the value of the activation property.
     *
     * @return possible object is
     *         {@link ActivationType }
     */
    public ActivationType getActivation() {
        return activation;
    }

    /**
     * Sets the value of the activation property.
     *
     * @param value allowed object is
     *              {@link ActivationType }
     */
    public void setActivation(ActivationType value) {
        this.activation = value;
    }

}
