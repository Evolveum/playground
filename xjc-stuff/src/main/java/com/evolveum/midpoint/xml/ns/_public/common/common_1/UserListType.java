package com.evolveum.midpoint.xml.ns._public.common.common_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for UserListType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UserListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}UserType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserListType", propOrder = {
        "user"
})
public class UserListType implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected List<UserType> user;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "UserListType");
    public final static QName F_USER = new QName(SchemaConstants.NS_COMMON, "user");

    /**
     * Gets the value of the user property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the user property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUser().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link UserType }
     */
    public List<UserType> getUser() {
        if (user == null) {
            user = new ArrayList<UserType>();
        }
        return this.user;
    }

}
