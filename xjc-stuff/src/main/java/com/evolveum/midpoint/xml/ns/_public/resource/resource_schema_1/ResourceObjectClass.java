package com.evolveum.midpoint.xml.ns._public.resource.resource_schema_1;

import com.evolveum.midpoint.schema.SchemaConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * Common supertype for all resource objects.  Every Object Class
 * should be derived from this type.
 * <p/>
 * Any non-abstract subtype of this type should have following
 * XSD annotations:
 * identifier - mandatory
 * secondaryIdentifier - optional
 * displayName - optional
 * descriptionAttribute - optional
 * nativeObjectClass - optional, but strongly encouraged
 * accountType - optional
 * <p/>
 * Question: How to define shchema for these annotations?
 * <p/>
 * This may not be strictly necessary, but may come useful and it
 * is not any extra weight to the system.
 * <p/>
 * <p/>
 * <p>Java class for ResourceObjectClass complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ResourceObjectClass">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceObjectClass")
public abstract class ResourceObjectClass implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_RESOURCE, "ResourceObjectClass");

}
