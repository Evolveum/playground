package com.evolveum.midpoint.schema;

import javax.xml.namespace.QName;

public class SchemaConstants {

    public final static String NS_ANNOTATION = "http://midpoint.evolveum.com/xml/ns/public/common/annotation-1.xsd";
    public final static String NS_CAPABILITIES = "http://midpoint.evolveum.com/xml/ns/public/resource/capabilities-1.xsd";
    public final static String NS_COMMON = "http://midpoint.evolveum.com/xml/ns/public/common/common-1.xsd";
    public final static String NS_ICF_RESOURCE = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/resource-schema-1.xsd";
    public final static String NS_ICF_SCHEMA = "http://midpoint.evolveum.com/xml/ns/public/connector/icf-1/connector-schema-1.xsd";
    public final static String NS_RESOURCE = "http://midpoint.evolveum.com/xml/ns/public/resource/resource-schema-1.xsd";
    public final static String NS_SITUATION = "http://midpoint.evolveum.com/xml/ns/public/model/situation-1.xsd";
    public final static String NS_WORKFLOW = "http://midpoint.evolveum.com/xml/ns/public/communication/workflow-1.xsd";
    public final static String NS_XML_DSIG = "http://www.w3.org/2000/09/xmldsig#";
    public final static String NS_XML_ENC = "http://www.w3.org/2001/04/xmlenc#";
    public final static String NS_XSD = "http://www.w3.org/2001/XMLSchema";
    public final static QName A_EXTENSION = new QName(NS_ANNOTATION, "extension");
    public final static QName A_MID_POINT_CONTAINER = new QName(NS_ANNOTATION, "midPointContainer");
    public final static QName A_PROPERTY_CONTAINER = new QName(NS_ANNOTATION, "propertyContainer");
    public final static QName C_ACCESS = new QName(NS_COMMON, "access");
    public final static QName C_ACCOUNT = new QName(NS_COMMON, "account");
    public final static QName C_AND = new QName(NS_COMMON, "and");
    public final static QName C_AS_IS = new QName(NS_COMMON, "asIs");
    public final static QName C_ASSIGNMENT = new QName(NS_COMMON, "assignment");
    public final static QName C_CACHING_METADATA = new QName(NS_COMMON, "cachingMetadata");
    public final static QName C_CONDITION = new QName(NS_COMMON, "condition");
    public final static QName C_CONNECTOR = new QName(NS_COMMON, "connector");
    public final static QName C_CONNECTOR_HOST = new QName(NS_COMMON, "connectorHost");
    public final static QName C_CREDENTIALS = new QName(NS_COMMON, "credentials");
    public final static QName C_DESCRIPTION = new QName(NS_COMMON, "description");
    public final static QName C_DISPLAY_NAME = new QName(NS_COMMON, "displayName");
    public final static QName C_EQUAL = new QName(NS_COMMON, "equal");
    public final static QName C_EXPRESSION = new QName(NS_COMMON, "expression");
    public final static QName C_FILTER = new QName(NS_COMMON, "filter");
    public final static QName C_GENERATE = new QName(NS_COMMON, "generate");
    public final static QName C_GENERIC_OBJECT = new QName(NS_COMMON, "genericObject");
    public final static QName C_GREATER_OR_EQUAL = new QName(NS_COMMON, "greaterOrEqual");
    public final static QName C_IGNORE = new QName(NS_COMMON, "ignore");
    public final static QName C_LESS_OR_EQUAL = new QName(NS_COMMON, "lessOrEqual");
    public final static QName C_MODIFICATION = new QName(NS_COMMON, "modification");
    public final static QName C_NAME = new QName(NS_COMMON, "name");
    public final static QName C_NOT = new QName(NS_COMMON, "not");
    public final static QName C_OBJECT = new QName(NS_COMMON, "object");
    public final static QName C_OBJECT_MODIFICATION = new QName(NS_COMMON, "objectModification");
    public final static QName C_OBJECT_REF = new QName(NS_COMMON, "objectRef");
    public final static QName C_OPERATION_RESULT = new QName(NS_COMMON, "operationResult");
    public final static QName C_OR = new QName(NS_COMMON, "or");
    public final static QName C_PASSWORD_POLICY = new QName(NS_COMMON, "passwordPolicy");
    public final static QName C_PATH = new QName(NS_COMMON, "path");
    public final static QName C_PRESENT = new QName(NS_COMMON, "present");
    public final static QName C_PROPERTY = new QName(NS_COMMON, "property");
    public final static QName C_PROPERTY_MODIFICATION = new QName(NS_COMMON, "propertyModification");
    public final static QName C_QUERY = new QName(NS_COMMON, "query");
    public final static QName C_RESOURCE = new QName(NS_COMMON, "resource");
    public final static QName C_RESOURCE_ATTRIBUTE_DEFINITION = new QName(NS_COMMON, "resourceAttributeDefinition");
    public final static QName C_RESOURCE_OBJECT_SHADOW = new QName(NS_COMMON, "resourceObjectShadow");
    public final static QName C_ROLE = new QName(NS_COMMON, "role");
    public final static QName C_SCHEMA = new QName(NS_COMMON, "schema");
    public final static QName C_SCHEMA_HANDLING = new QName(NS_COMMON, "schemaHandling");
    public final static QName C_SCRIPTS = new QName(NS_COMMON, "scripts");
    public final static QName C_STRING_FILTER = new QName(NS_COMMON, "stringFilter");
    public final static QName C_SUBSTRING = new QName(NS_COMMON, "substring");
    public final static QName C_SYNCHRONIZATION = new QName(NS_COMMON, "synchronization");
    public final static QName C_SYSTEM_CONFIGURATION = new QName(NS_COMMON, "systemConfiguration");
    public final static QName C_TASK = new QName(NS_COMMON, "task");
    public final static QName C_TRUE = new QName(NS_COMMON, "true");
    public final static QName C_TYPE = new QName(NS_COMMON, "type");
    public final static QName C_UNKNOWN_JAVA_OBJECT = new QName(NS_COMMON, "unknownJavaObject");
    public final static QName C_USER = new QName(NS_COMMON, "user");
    public final static QName C_USER_TEMPLATE = new QName(NS_COMMON, "userTemplate");
    public final static QName C_VALUE = new QName(NS_COMMON, "value");
    public final static QName C_VALUE_CONSTRUCTION = new QName(NS_COMMON, "valueConstruction");
    public final static QName C_VALUE_CONSTRUCTOR = new QName(NS_COMMON, "valueConstructor");
    public final static QName C_VALUE_FILTER = new QName(NS_COMMON, "valueFilter");
    public final static QName DSIG_CANONICALIZATION_METHOD = new QName(NS_XML_DSIG, "CanonicalizationMethod");
    public final static QName DSIG_DIGEST_METHOD = new QName(NS_XML_DSIG, "DigestMethod");
    public final static QName DSIG_DIGEST_VALUE = new QName(NS_XML_DSIG, "DigestValue");
    public final static QName DSIG_DSA_KEY_VALUE = new QName(NS_XML_DSIG, "DSAKeyValue");
    public final static QName DSIG_KEY_INFO = new QName(NS_XML_DSIG, "KeyInfo");
    public final static QName DSIG_KEY_NAME = new QName(NS_XML_DSIG, "KeyName");
    public final static QName DSIG_KEY_VALUE = new QName(NS_XML_DSIG, "KeyValue");
    public final static QName DSIG_MANIFEST = new QName(NS_XML_DSIG, "Manifest");
    public final static QName DSIG_MGMT_DATA = new QName(NS_XML_DSIG, "MgmtData");
    public final static QName DSIG_OBJECT = new QName(NS_XML_DSIG, "Object");
    public final static QName DSIG_PGP_DATA = new QName(NS_XML_DSIG, "PGPData");
    public final static QName DSIG_REFERENCE = new QName(NS_XML_DSIG, "Reference");
    public final static QName DSIG_RETRIEVAL_METHOD = new QName(NS_XML_DSIG, "RetrievalMethod");
    public final static QName DSIG_RSA_KEY_VALUE = new QName(NS_XML_DSIG, "RSAKeyValue");
    public final static QName DSIG_SIGNATURE = new QName(NS_XML_DSIG, "Signature");
    public final static QName DSIG_SIGNATURE_METHOD = new QName(NS_XML_DSIG, "SignatureMethod");
    public final static QName DSIG_SIGNATURE_PROPERTIES = new QName(NS_XML_DSIG, "SignatureProperties");
    public final static QName DSIG_SIGNATURE_PROPERTY = new QName(NS_XML_DSIG, "SignatureProperty");
    public final static QName DSIG_SIGNATURE_VALUE = new QName(NS_XML_DSIG, "SignatureValue");
    public final static QName DSIG_SIGNED_INFO = new QName(NS_XML_DSIG, "SignedInfo");
    public final static QName DSIG_SPKI_DATA = new QName(NS_XML_DSIG, "SPKIData");
    public final static QName DSIG_TRANSFORM = new QName(NS_XML_DSIG, "Transform");
    public final static QName DSIG_TRANSFORMS = new QName(NS_XML_DSIG, "Transforms");
    public final static QName DSIG_X_509_DATA = new QName(NS_XML_DSIG, "X509Data");
    public final static QName ENC_AGREEMENT_METHOD = new QName(NS_XML_ENC, "AgreementMethod");
    public final static QName ENC_CIPHER_DATA = new QName(NS_XML_ENC, "CipherData");
    public final static QName ENC_CIPHER_REFERENCE = new QName(NS_XML_ENC, "CipherReference");
    public final static QName ENC_ENCRYPTED_DATA = new QName(NS_XML_ENC, "EncryptedData");
    public final static QName ENC_ENCRYPTED_KEY = new QName(NS_XML_ENC, "EncryptedKey");
    public final static QName ENC_ENCRYPTION_PROPERTIES = new QName(NS_XML_ENC, "EncryptionProperties");
    public final static QName ENC_ENCRYPTION_PROPERTY = new QName(NS_XML_ENC, "EncryptionProperty");
    public final static QName ICF_C_CONNECTOR_POOL_CONFIGURATION = new QName(NS_ICF_SCHEMA, "connectorPoolConfiguration");
    public final static QName ICF_C_PRODUCER_BUFFER_SIZE = new QName(NS_ICF_SCHEMA, "producerBufferSize");
    public final static QName ICF_C_TIMEOUTS = new QName(NS_ICF_SCHEMA, "timeouts");
    public final static QName ICF_S_CURRENT_PASSWORD = new QName(NS_ICF_RESOURCE, "currentPassword");
    public final static QName ICF_S_DESCRIPTION = new QName(NS_ICF_RESOURCE, "description");
    public final static QName ICF_S_DISABLE_DATE = new QName(NS_ICF_RESOURCE, "disableDate");
    public final static QName ICF_S_ENABLE = new QName(NS_ICF_RESOURCE, "enable");
    public final static QName ICF_S_ENABLE_DATE = new QName(NS_ICF_RESOURCE, "enableDate");
    public final static QName ICF_S_GROUPS = new QName(NS_ICF_RESOURCE, "groups");
    public final static QName ICF_S_LAST_LOGIN_DATE = new QName(NS_ICF_RESOURCE, "lastLoginDate");
    public final static QName ICF_S_LAST_PASSWORD_CHANGE_DATE = new QName(NS_ICF_RESOURCE, "lastPasswordChangeDate");
    public final static QName ICF_S_LOCK_OUT = new QName(NS_ICF_RESOURCE, "lockOut");
    public final static QName ICF_S_NAME = new QName(NS_ICF_RESOURCE, "name");
    public final static QName ICF_S_PASSWORD = new QName(NS_ICF_RESOURCE, "password");
    public final static QName ICF_S_PASSWORD_CHANGE_INTERVAL = new QName(NS_ICF_RESOURCE, "passwordChangeInterval");
    public final static QName ICF_S_PASSWORD_EXPIRATION_DATE = new QName(NS_ICF_RESOURCE, "passwordExpirationDate");
    public final static QName ICF_S_PASSWORD_EXPIRED = new QName(NS_ICF_RESOURCE, "passwordExpired");
    public final static QName ICF_S_SHORT_NAME = new QName(NS_ICF_RESOURCE, "shortName");
    public final static QName ICF_S_UID = new QName(NS_ICF_RESOURCE, "uid");
    public final static QName R_ACCOUNT_TYPE = new QName(NS_RESOURCE, "accountType");
    public final static QName R_ATTRIBUTE_DISPLAY_NAME = new QName(NS_RESOURCE, "attributeDisplayName");
    public final static QName R_ATTRIBUTE_FLAG = new QName(NS_RESOURCE, "attributeFlag");
    public final static QName R_CAP_ACTIVATION = new QName(NS_CAPABILITIES, "activation");
    public final static QName R_CAP_CREDENTIALS = new QName(NS_CAPABILITIES, "credentials");
    public final static QName R_CAP_LIVE_SYNC = new QName(NS_CAPABILITIES, "liveSync");
    public final static QName R_CAP_SCRIPT = new QName(NS_CAPABILITIES, "script");
    public final static QName R_CAP_TEST_CONNECTION = new QName(NS_CAPABILITIES, "testConnection");
    public final static QName R_CLASSIFIED_ATTRIBUTE = new QName(NS_RESOURCE, "classifiedAttribute");
    public final static QName R_COMPOSITE_IDENTIFIER = new QName(NS_RESOURCE, "compositeIdentifier");
    public final static QName R_CONTAINER = new QName(NS_RESOURCE, "container");
    public final static QName R_DESCRIPTION_ATTRIBUTE = new QName(NS_RESOURCE, "descriptionAttribute");
    public final static QName R_DISPLAY_NAME = new QName(NS_RESOURCE, "displayName");
    public final static QName R_IDENTIFIER = new QName(NS_RESOURCE, "identifier");
    public final static QName R_NAMING_ATTRIBUTE = new QName(NS_RESOURCE, "namingAttribute");
    public final static QName R_NATIVE_ATTRIBUTE_NAME = new QName(NS_RESOURCE, "nativeAttributeName");
    public final static QName R_NATIVE_OBJECT_CLASS = new QName(NS_RESOURCE, "nativeObjectClass");
    public final static QName R_OBJECT_CLASS_ATTRIBUTE = new QName(NS_RESOURCE, "objectClassAttribute");
    public final static QName R_OPERATION = new QName(NS_RESOURCE, "operation");
    public final static QName R_RESOURCE_OBJECT = new QName(NS_RESOURCE, "resourceObject");
    public final static QName R_SECONDARY_IDENTIFIER = new QName(NS_RESOURCE, "secondaryIdentifier");
    public final static QName W_WF_PROCESS_INSTANCE_EVENT = new QName(NS_WORKFLOW, "WfProcessInstanceEvent");
    public final static QName W_WF_PROCESS_INSTANCE_FINISHED_EVENT = new QName(NS_WORKFLOW, "WfProcessInstanceFinishedEvent");
    public final static QName W_WF_PROCESS_INSTANCE_STARTED_EVENT = new QName(NS_WORKFLOW, "WfProcessInstanceStartedEvent");
    public final static QName W_WF_QUERY_PROCESS_INSTANCE_COMMAND = new QName(NS_WORKFLOW, "WfQueryProcessInstanceCommand");
    public final static QName W_WF_START_PROCESS_INSTANCE_COMMAND = new QName(NS_WORKFLOW, "WfStartProcessInstanceCommand");

}
