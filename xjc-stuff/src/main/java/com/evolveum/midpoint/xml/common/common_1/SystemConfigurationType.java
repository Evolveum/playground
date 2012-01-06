
package com.evolveum.midpoint.xml.common.common_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * 
 *                 System configuration object.
 * 
 *                 Holds global system configuration setting. There will be just one object of
 *                 this type in the system. It will have a well-known OID.
 *             
 * 
 * <p>Java class for SystemConfigurationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
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
 * 
 * 
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
    implements Serializable, Equals, HashCode
{

    private final static long serialVersionUID = 201105211233L;
    protected AccountSynchronizationSettingsType globalAccountSynchronizationSettings;
    protected ModelHooksType modelHooks;
    protected LoggingConfigurationType logging;
    protected UserTemplateType defaultUserTemplate;
    protected ObjectReferenceType defaultUserTemplateRef;
    protected SystemConfigurationType.ConnectorFramework connectorFramework;
    public final static QName ELEMENT_TYPE = new QName("http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd", "SystemConfigurationType");

    /**
     * Gets the value of the globalAccountSynchronizationSettings property.
     * 
     * @return
     *     possible object is
     *     {@link AccountSynchronizationSettingsType }
     *     
     */
    public AccountSynchronizationSettingsType getGlobalAccountSynchronizationSettings() {
        return globalAccountSynchronizationSettings;
    }

    /**
     * Sets the value of the globalAccountSynchronizationSettings property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountSynchronizationSettingsType }
     *     
     */
    public void setGlobalAccountSynchronizationSettings(AccountSynchronizationSettingsType value) {
        this.globalAccountSynchronizationSettings = value;
    }

    /**
     * Gets the value of the modelHooks property.
     * 
     * @return
     *     possible object is
     *     {@link ModelHooksType }
     *     
     */
    public ModelHooksType getModelHooks() {
        return modelHooks;
    }

    /**
     * Sets the value of the modelHooks property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelHooksType }
     *     
     */
    public void setModelHooks(ModelHooksType value) {
        this.modelHooks = value;
    }

    /**
     * Gets the value of the logging property.
     * 
     * @return
     *     possible object is
     *     {@link LoggingConfigurationType }
     *     
     */
    public LoggingConfigurationType getLogging() {
        return logging;
    }

    /**
     * Sets the value of the logging property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoggingConfigurationType }
     *     
     */
    public void setLogging(LoggingConfigurationType value) {
        this.logging = value;
    }

    /**
     * Gets the value of the defaultUserTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link UserTemplateType }
     *     
     */
    public UserTemplateType getDefaultUserTemplate() {
        return defaultUserTemplate;
    }

    /**
     * Sets the value of the defaultUserTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserTemplateType }
     *     
     */
    public void setDefaultUserTemplate(UserTemplateType value) {
        this.defaultUserTemplate = value;
    }

    /**
     * Gets the value of the defaultUserTemplateRef property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectReferenceType }
     *     
     */
    public ObjectReferenceType getDefaultUserTemplateRef() {
        return defaultUserTemplateRef;
    }

    /**
     * Sets the value of the defaultUserTemplateRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectReferenceType }
     *     
     */
    public void setDefaultUserTemplateRef(ObjectReferenceType value) {
        this.defaultUserTemplateRef = value;
    }

    /**
     * Gets the value of the connectorFramework property.
     * 
     * @return
     *     possible object is
     *     {@link SystemConfigurationType.ConnectorFramework }
     *     
     */
    public SystemConfigurationType.ConnectorFramework getConnectorFramework() {
        return connectorFramework;
    }

    /**
     * Sets the value of the connectorFramework property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemConfigurationType.ConnectorFramework }
     *     
     */
    public void setConnectorFramework(SystemConfigurationType.ConnectorFramework value) {
        this.connectorFramework = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            AccountSynchronizationSettingsType theGlobalAccountSynchronizationSettings;
            theGlobalAccountSynchronizationSettings = this.getGlobalAccountSynchronizationSettings();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "globalAccountSynchronizationSettings", theGlobalAccountSynchronizationSettings), currentHashCode, theGlobalAccountSynchronizationSettings);
        }
        {
            ModelHooksType theModelHooks;
            theModelHooks = this.getModelHooks();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "modelHooks", theModelHooks), currentHashCode, theModelHooks);
        }
        {
            LoggingConfigurationType theLogging;
            theLogging = this.getLogging();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "logging", theLogging), currentHashCode, theLogging);
        }
        {
            UserTemplateType theDefaultUserTemplate;
            theDefaultUserTemplate = this.getDefaultUserTemplate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "defaultUserTemplate", theDefaultUserTemplate), currentHashCode, theDefaultUserTemplate);
        }
        {
            ObjectReferenceType theDefaultUserTemplateRef;
            theDefaultUserTemplateRef = this.getDefaultUserTemplateRef();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "defaultUserTemplateRef", theDefaultUserTemplateRef), currentHashCode, theDefaultUserTemplateRef);
        }
        {
            SystemConfigurationType.ConnectorFramework theConnectorFramework;
            theConnectorFramework = this.getConnectorFramework();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "connectorFramework", theConnectorFramework), currentHashCode, theConnectorFramework);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = new com.evolveum.midpoint.schema.DomAwareHashCodeStrategy();
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SystemConfigurationType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final SystemConfigurationType that = ((SystemConfigurationType) object);
        {
            AccountSynchronizationSettingsType lhsGlobalAccountSynchronizationSettings;
            lhsGlobalAccountSynchronizationSettings = this.getGlobalAccountSynchronizationSettings();
            AccountSynchronizationSettingsType rhsGlobalAccountSynchronizationSettings;
            rhsGlobalAccountSynchronizationSettings = that.getGlobalAccountSynchronizationSettings();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "globalAccountSynchronizationSettings", lhsGlobalAccountSynchronizationSettings), LocatorUtils.property(thatLocator, "globalAccountSynchronizationSettings", rhsGlobalAccountSynchronizationSettings), lhsGlobalAccountSynchronizationSettings, rhsGlobalAccountSynchronizationSettings)) {
                return false;
            }
        }
        {
            ModelHooksType lhsModelHooks;
            lhsModelHooks = this.getModelHooks();
            ModelHooksType rhsModelHooks;
            rhsModelHooks = that.getModelHooks();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "modelHooks", lhsModelHooks), LocatorUtils.property(thatLocator, "modelHooks", rhsModelHooks), lhsModelHooks, rhsModelHooks)) {
                return false;
            }
        }
        {
            LoggingConfigurationType lhsLogging;
            lhsLogging = this.getLogging();
            LoggingConfigurationType rhsLogging;
            rhsLogging = that.getLogging();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "logging", lhsLogging), LocatorUtils.property(thatLocator, "logging", rhsLogging), lhsLogging, rhsLogging)) {
                return false;
            }
        }
        {
            UserTemplateType lhsDefaultUserTemplate;
            lhsDefaultUserTemplate = this.getDefaultUserTemplate();
            UserTemplateType rhsDefaultUserTemplate;
            rhsDefaultUserTemplate = that.getDefaultUserTemplate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "defaultUserTemplate", lhsDefaultUserTemplate), LocatorUtils.property(thatLocator, "defaultUserTemplate", rhsDefaultUserTemplate), lhsDefaultUserTemplate, rhsDefaultUserTemplate)) {
                return false;
            }
        }
        {
            ObjectReferenceType lhsDefaultUserTemplateRef;
            lhsDefaultUserTemplateRef = this.getDefaultUserTemplateRef();
            ObjectReferenceType rhsDefaultUserTemplateRef;
            rhsDefaultUserTemplateRef = that.getDefaultUserTemplateRef();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "defaultUserTemplateRef", lhsDefaultUserTemplateRef), LocatorUtils.property(thatLocator, "defaultUserTemplateRef", rhsDefaultUserTemplateRef), lhsDefaultUserTemplateRef, rhsDefaultUserTemplateRef)) {
                return false;
            }
        }
        {
            SystemConfigurationType.ConnectorFramework lhsConnectorFramework;
            lhsConnectorFramework = this.getConnectorFramework();
            SystemConfigurationType.ConnectorFramework rhsConnectorFramework;
            rhsConnectorFramework = that.getConnectorFramework();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "connectorFramework", lhsConnectorFramework), LocatorUtils.property(thatLocator, "connectorFramework", rhsConnectorFramework), lhsConnectorFramework, rhsConnectorFramework)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = new com.evolveum.midpoint.schema.DomAwareEqualsStrategy();
        return equals(null, null, object, strategy);
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
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
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "configuration"
    })
    public static class ConnectorFramework
        implements Serializable, Equals, HashCode
    {

        private final static long serialVersionUID = 201105211233L;
        protected List<SystemConfigurationType.ConnectorFramework.Configuration> configuration;

        /**
         * Gets the value of the configuration property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the configuration property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getConfiguration().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SystemConfigurationType.ConnectorFramework.Configuration }
         * 
         * 
         */
        public List<SystemConfigurationType.ConnectorFramework.Configuration> getConfiguration() {
            if (configuration == null) {
                configuration = new ArrayList<SystemConfigurationType.ConnectorFramework.Configuration>();
            }
            return this.configuration;
        }

        /**
         * Generates a String representation of the contents of this type.
         * This is an extension method, produced by the 'ts' xjc plugin
         * 
         */
        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<SystemConfigurationType.ConnectorFramework.Configuration> theConfiguration;
                theConfiguration = (((this.configuration!= null)&&(!this.configuration.isEmpty()))?this.getConfiguration():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "configuration", theConfiguration), currentHashCode, theConfiguration);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = new com.evolveum.midpoint.schema.DomAwareHashCodeStrategy();
            return this.hashCode(null, strategy);
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof SystemConfigurationType.ConnectorFramework)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final SystemConfigurationType.ConnectorFramework that = ((SystemConfigurationType.ConnectorFramework) object);
            {
                List<SystemConfigurationType.ConnectorFramework.Configuration> lhsConfiguration;
                lhsConfiguration = (((this.configuration!= null)&&(!this.configuration.isEmpty()))?this.getConfiguration():null);
                List<SystemConfigurationType.ConnectorFramework.Configuration> rhsConfiguration;
                rhsConfiguration = (((that.configuration!= null)&&(!that.configuration.isEmpty()))?that.getConfiguration():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "configuration", lhsConfiguration), LocatorUtils.property(thatLocator, "configuration", rhsConfiguration), lhsConfiguration, rhsConfiguration)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object object) {
            final EqualsStrategy strategy = new com.evolveum.midpoint.schema.DomAwareEqualsStrategy();
            return equals(null, null, object, strategy);
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
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
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "extension",
            "connectorPath"
        })
        public static class Configuration
            implements Serializable, Equals, HashCode
        {

            private final static long serialVersionUID = 201105211233L;
            protected Extension extension;
            protected List<String> connectorPath;

            /**
             * 
             *                                                         This element may contain any framework-specific global
             *                                                         configuration.
             *                                                     
             * 
             * @return
             *     possible object is
             *     {@link Extension }
             *     
             */
            public Extension getExtension() {
                return extension;
            }

            /**
             * Sets the value of the extension property.
             * 
             * @param value
             *     allowed object is
             *     {@link Extension }
             *     
             */
            public void setExtension(Extension value) {
                this.extension = value;
            }

            /**
             * Gets the value of the connectorPath property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the connectorPath property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getConnectorPath().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getConnectorPath() {
                if (connectorPath == null) {
                    connectorPath = new ArrayList<String>();
                }
                return this.connectorPath;
            }

            /**
             * Generates a String representation of the contents of this type.
             * This is an extension method, produced by the 'ts' xjc plugin
             * 
             */
            @Override
            public String toString() {
                return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
            }

            public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
                int currentHashCode = 1;
                {
                    Extension theExtension;
                    theExtension = this.getExtension();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "extension", theExtension), currentHashCode, theExtension);
                }
                {
                    List<String> theConnectorPath;
                    theConnectorPath = (((this.connectorPath!= null)&&(!this.connectorPath.isEmpty()))?this.getConnectorPath():null);
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "connectorPath", theConnectorPath), currentHashCode, theConnectorPath);
                }
                return currentHashCode;
            }

            public int hashCode() {
                final HashCodeStrategy strategy = new com.evolveum.midpoint.schema.DomAwareHashCodeStrategy();
                return this.hashCode(null, strategy);
            }

            public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
                if (!(object instanceof SystemConfigurationType.ConnectorFramework.Configuration)) {
                    return false;
                }
                if (this == object) {
                    return true;
                }
                final SystemConfigurationType.ConnectorFramework.Configuration that = ((SystemConfigurationType.ConnectorFramework.Configuration) object);
                {
                    Extension lhsExtension;
                    lhsExtension = this.getExtension();
                    Extension rhsExtension;
                    rhsExtension = that.getExtension();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "extension", lhsExtension), LocatorUtils.property(thatLocator, "extension", rhsExtension), lhsExtension, rhsExtension)) {
                        return false;
                    }
                }
                {
                    List<String> lhsConnectorPath;
                    lhsConnectorPath = (((this.connectorPath!= null)&&(!this.connectorPath.isEmpty()))?this.getConnectorPath():null);
                    List<String> rhsConnectorPath;
                    rhsConnectorPath = (((that.connectorPath!= null)&&(!that.connectorPath.isEmpty()))?that.getConnectorPath():null);
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "connectorPath", lhsConnectorPath), LocatorUtils.property(thatLocator, "connectorPath", rhsConnectorPath), lhsConnectorPath, rhsConnectorPath)) {
                        return false;
                    }
                }
                return true;
            }

            public boolean equals(Object object) {
                final EqualsStrategy strategy = new com.evolveum.midpoint.schema.DomAwareEqualsStrategy();
                return equals(null, null, object, strategy);
            }

        }

    }

}
