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
 * System configuration object.
 * <p/>
 * Holds global system configuration setting. There will be just one object of
 * this type in the system. It will have a well-known OID.
 * <p/>
 * <p/>
 * <p>Java class for SystemConfigurationType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SystemConfigurationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ExtensibleObjectType">
 *       &lt;sequence>
 *         &lt;element name="globalAccountSynchronizationSettings" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}AccountSynchronizationSettingsType" minOccurs="0"/>
 *         &lt;element name="modelHooks" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ModelHooksType" minOccurs="0"/>
 *         &lt;element name="logging" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}LoggingConfigurationType" minOccurs="0"/>
 *         &lt;element name="defaultUserTemplate" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}UserTemplateType" minOccurs="0"/>
 *         &lt;element name="defaultUserTemplateRef" type="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}ObjectReferenceType" minOccurs="0"/>
 *         &lt;element name="connectorFramework" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="configuration" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}extension" minOccurs="0"/>
 *                             &lt;element name="connectorPath" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SystemConfigurationType", propOrder = {
        "globalAccountSynchronizationSettings",
        "modelHooks",
        "logging",
        "defaultUserTemplate",
        "defaultUserTemplateRef",
        "connectorFramework"
})
public class SystemConfigurationType
        extends ExtensibleObjectType
        implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    protected UserTemplateType defaultUserTemplate;
    public final static QName COMPLEX_TYPE = new QName(SchemaConstants.NS_COMMON, "SystemConfigurationType");
    public final static QName F_GLOBAL_ACCOUNT_SYNCHRONIZATION_SETTINGS = new QName(SchemaConstants.NS_COMMON, "globalAccountSynchronizationSettings");
    public final static QName F_MODEL_HOOKS = new QName(SchemaConstants.NS_COMMON, "modelHooks");
    public final static QName F_LOGGING = new QName(SchemaConstants.NS_COMMON, "logging");
    public final static QName F_DEFAULT_USER_TEMPLATE = new QName(SchemaConstants.NS_COMMON, "defaultUserTemplate");
    public final static QName F_DEFAULT_USER_TEMPLATE_REF = new QName(SchemaConstants.NS_COMMON, "defaultUserTemplateRef");
    public final static QName F_CONNECTOR_FRAMEWORK = new QName(SchemaConstants.NS_COMMON, "connectorFramework");

    /**
     * Gets the value of the defaultUserTemplate property.
     *
     * @return possible object is
     *         {@link UserTemplateType }
     */
    public UserTemplateType getDefaultUserTemplate() {
        return defaultUserTemplate;
    }

    public AccountSynchronizationSettingsType getGlobalAccountSynchronizationSettings() {
        return getPropertyValue(F_GLOBAL_ACCOUNT_SYNCHRONIZATION_SETTINGS, AccountSynchronizationSettingsType.class);
    }

    public void setGlobalAccountSynchronizationSettings(AccountSynchronizationSettingsType value) {
        setPropertyValue(F_GLOBAL_ACCOUNT_SYNCHRONIZATION_SETTINGS, value);
    }

    public ModelHooksType getModelHooks() {
        return getPropertyValue(F_MODEL_HOOKS, ModelHooksType.class);
    }

    public void setModelHooks(ModelHooksType value) {
        setPropertyValue(F_MODEL_HOOKS, value);
    }

    public LoggingConfigurationType getLogging() {
        return getPropertyValue(F_LOGGING, LoggingConfigurationType.class);
    }

    public void setLogging(LoggingConfigurationType value) {
        setPropertyValue(F_LOGGING, value);
    }

    public void setDefaultUserTemplate(UserTemplateType value) {
        //todo do not use setValue but remove container from parent property container, update if user set/remove method
        this.defaultUserTemplate = value;
        if (value == null) {
            setPropertyValue(F_DEFAULT_USER_TEMPLATE, null);
        } else {
            setPropertyValue(F_DEFAULT_USER_TEMPLATE, value.getContainer());
        }
    }

    public ObjectReferenceType getDefaultUserTemplateRef() {
        return getPropertyValue(F_DEFAULT_USER_TEMPLATE_REF, ObjectReferenceType.class);
    }

    public void setDefaultUserTemplateRef(ObjectReferenceType value) {
        setPropertyValue(F_DEFAULT_USER_TEMPLATE_REF, value);
    }

    public SystemConfigurationType.ConnectorFramework getConnectorFramework() {
        return getPropertyValue(F_CONNECTOR_FRAMEWORK, SystemConfigurationType.ConnectorFramework.class);
    }

    public void setConnectorFramework(SystemConfigurationType.ConnectorFramework value) {
        setPropertyValue(F_CONNECTOR_FRAMEWORK, value);
    }


    /**
     * <p>Java class for anonymous complex type.
     * <p/>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="configuration" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}extension" minOccurs="0"/>
     *                   &lt;element name="connectorPath" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "configuration"
    })
    public static class ConnectorFramework implements Serializable {

        private final static long serialVersionUID = 201105211233L;
        protected List<SystemConfigurationType.ConnectorFramework.Configuration> configuration;

        /**
         * Gets the value of the configuration property.
         * <p/>
         * <p/>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the configuration property.
         * <p/>
         * <p/>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getConfiguration().add(newItem);
         * </pre>
         * <p/>
         * <p/>
         * <p/>
         * Objects of the following type(s) are allowed in the list
         * {@link SystemConfigurationType.ConnectorFramework.Configuration }
         */
        public List<SystemConfigurationType.ConnectorFramework.Configuration> getConfiguration() {
            if (configuration == null) {
                configuration = new ArrayList<SystemConfigurationType.ConnectorFramework.Configuration>();
            }
            return this.configuration;
        }


        /**
         * <p>Java class for anonymous complex type.
         * <p/>
         * <p>The following schema fragment specifies the expected content contained within this class.
         * <p/>
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element ref="{http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd}extension" minOccurs="0"/>
         *         &lt;element name="connectorPath" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "extension",
                "connectorPath"
        })
        public static class Configuration
                implements Serializable {

            private final static long serialVersionUID = 201105211233L;
            protected Extension extension;
            protected List<String> connectorPath;

            /**
             * This element may contain any framework-specific global
             * configuration.
             *
             * @return possible object is
             *         {@link Extension }
             */
            public Extension getExtension() {
                return extension;
            }

            /**
             * Sets the value of the extension property.
             *
             * @param value allowed object is
             *              {@link Extension }
             */
            public void setExtension(Extension value) {
                this.extension = value;
            }

            /**
             * Gets the value of the connectorPath property.
             * <p/>
             * <p/>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the connectorPath property.
             * <p/>
             * <p/>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getConnectorPath().add(newItem);
             * </pre>
             * <p/>
             * <p/>
             * <p/>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             */
            public List<String> getConnectorPath() {
                if (connectorPath == null) {
                    connectorPath = new ArrayList<String>();
                }
                return this.connectorPath;
            }

        }

    }

}
