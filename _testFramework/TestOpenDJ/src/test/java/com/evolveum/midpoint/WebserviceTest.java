/*
 * Copyright (c) 2013 Evolveum
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://www.opensource.org/licenses/cddl1 or
 * CDDLv1.0.txt file in the source code distribution.
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 *
 * Portions Copyrighted 2013 [name of copyright owner]
 */

package com.evolveum.midpoint;

import com.evolveum.midpoint.util.exception.ObjectNotFoundException;
import com.evolveum.midpoint.xml.ns._public.common.api_types_2.ObjectListType;
import com.evolveum.midpoint.xml.ns._public.common.api_types_2.ObjectModificationType;
import com.evolveum.midpoint.xml.ns._public.common.api_types_2.OperationOptionsType;
import com.evolveum.midpoint.xml.ns._public.common.api_types_2.ResourceObjectShadowListType;
import com.evolveum.midpoint.xml.ns._public.common.common_2a.*;
import com.evolveum.midpoint.xml.ns._public.common.fault_1_wsdl.FaultMessage;
import com.evolveum.prism.xml.ns._public.query_2.PagingType;
import com.evolveum.prism.xml.ns._public.query_2.QueryType;
import org.testng.AssertJUnit;
import org.testng.annotations.*;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.ws.Holder;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 *  <p>
 *      This test suite purpose is to test functionality of midpoint webServices. In this suite,
 *      eleven help methods are provided (simple method for every provided operation of
 *      midpoint webService). Using this help methods, we test webService interaction with
 *      every midpoint object. This strategy leads to complex testing of every possible way
 *      to interact with webServices provided by midpoint, thus it should find all bugs and issues.
 *  </p>
 *  <p>
 *      Of course, the interaction of every midpoint object with every webService operation is not possible.
 *      Some operations are universal, some are closed. Universal operations are tested with every midpoint
 *      Object. Closed ones only with objects, with which they are designed to work with.
 *      Universal operations: </br>
 *      <ul>
 *          <li>deleteObject</li>
 *          <li>listObjects</li>
 *          <li>addObject</li>
 *          <li>searchObjects</li>
 *          <li>getObject</li>
 *          <li>modifyObject</li>
 *      </ul>
 *      Closed operations: </br>
 *      <ul>
 *          <li>listAccountShadowOwner - User and Account interaction</li>
 *          <li>listResourceObjectShadows - Resource and Accounts interaction</li>
 *          <li>importFromResource - Resource interaction</li>
 *          <li>listResourceObjects - Resource interaction</li>
 *          <li>testResouce - ResourceInteraction</li>
 *      </ul>
 *      Tested objects: </br>
 *      <ul>
 *          <li>ACCOUNT - AccountShadowType</li>
 *          <li>CONNECTOR - ConnectorType</li>
 *          <li>CONNECTOR_HOST - ConnectorHostType</li>
 *          <li>GENERIC_OBJECT - GenericObjectType</li>
 *          <li>RESOURCE - ResourceType</li>
 *          <li>USER - UserType</li>
 *          <li>USER_TEMPLATE - UserTemplateType</li>
 *          <li>SYSTEM_CONFIGURATION - SystemConfigurationType</li>
 *          <li>TASK - TaskType</li>
 *          <li>RESOURCE_OBJECT_SHADOW - ResourceObjectShadowType</li>
 *          <li>OBJECT - ObjectType</li>
 *          <li>ROLE - RoleType</li>
 *          <li>PASSWORD_POLICY - ValuePolicyType</li>
 *          <li>NODE - NodeType</li>
 *          <li>ORG - OrgType</li>
 *          <li>ABSTRACT_ROLE - AbstractRoleType</li>
 *      </ul>  *
 *  </p>
 *
 * @author Erik Suta
 *
 * */

public class WebserviceTest extends TestFrameworkUtil{

    private static final String PACKAGE_API_TYPES_2 = "com.evolveum.midpoint.xml.ns._public.common.api_types_2";
    private static final String PACKAGE_COMMON_2A = "com.evolveum.midpoint.xml.ns._public.common.common_2a";

    //TODO

    private static final String WEBSERVICE_DIR_NAME = "src/test/resources/webservice/";
    private static final String USER_ADD_FILENAME = "user_add.xml";
    private static final String USER_MODIFY_FILENAME = "user_modify.xml";

    private static final String ACCOUNT_ADD_FILENAME = "account_add.xml";
    private static final String ACCOUNT_MODIFY_FILENAME = "account_modify.xml";

    private static final String CONNECTOR_ADD_FILENAME = "connector_add.xml";
    private static final String CONNECTOR_MODIFY_FILENAME = "connector_modify.xml";

    private static final String CONNECTOR_HOST_ADD_FILENAME = "connector_host_add.xml";
    private static final String CONNECTOR_HOST_MODIFY_FILENAME = "connector_host_modify.xml";

    private static final String GENERIC_OBJECT_ADD_FILENAME = "generic_add.xml";
    private static final String GENERIC_OBJECT_MODIFY_FILENAME = "generic_modify.xml";

    private static final String USER_TEMPLATE_ADD_FILENAME = "user_template_add.xml";
    private static final String USER_TEMPLATE_MODIFY_FILENAME = "user_template_modify.xml";

    private static final String SYSTEM_CONFIG_ADD_FILENAME = "system_configuration_add.xml";
    private static final String SYSTEM_CONFIG_MODIFY_FILENAME = "system_configuration_modify.xml";

    private static final String TASK_ADD_FILENAME = "task_add.xml";
    private static final String TASK_MODIFY_FILENAME = "task_modify.xml";

    private static final String ROLE_ADD_FILENAME = "role_add.xml";
    private static final String ROLE_MODIFY_FILENAME = "role_modify.xml";

    private static final String PASSWORD_POLICY_ADD_FILENAME = "password_policy_add.xml";
    private static final String PASSWORD_POLICY_MODIFY_FILENAME = "password_policy_modify.xml";

    private static final String ORG_ADD_FILENAME = "org_add.xml";
    private static final String ORG_MODIFY_FILENAME = "org_modify.xml";

    private static String userOid = "c0c010c0-d34d-b33f-f00d-111111111111";
    private static String accountOid = "ef2bc95b-76e0-59e2-86d6-3d4f02d3aaaa";
    private static String connectorOid;
    private static String connectorHostOid;
    private static String genericObjectOid;
    private static String userTemplateOid = "10000000-0000-0000-0000-000000000222";
    private static String systemConfigOid = "00000000-3333-2222-1111-000000000001";
    private static String taskOid = "91919191-76e0-59e2-86d6-3d4f02d30000";
    private static String passwordPolicyOid = "81818181-76e0-59e2-8888-3d4f02d3fffd";
    private static String roleOid = "12345678-d34d-b33f-f00d-988888888889";
    private static String orgOid = "00000000-8888-6666-0000-100000000001";

    @BeforeMethod
    public void beforeTest(){}

    @AfterMethod
    public void afterTest(){}

    @BeforeClass
    public void beforeTestInit() throws FaultMessage{
        initSystem();
        modelPort = createModelPort();
        configurationType = getConfiguration(modelPort);
        LOGGER.info("WebService test: Inicialization complete, test suite starts now.");
    }

    @AfterClass
    public void afterTestCleanup(){
        LOGGER.info("WebService test: WebService test suite finished.");
    }

    /*=============================================================================================================*/
    /*                                       Help method for each ws operation                                     */
    /*=============================================================================================================*/

    /**
     *  Performs deleteObject operation
     *
     *  @return OperationResultType
     * */
    private OperationResultType deleteObjectTest(String objectType, String objectOid) throws FaultMessage{
        return modelPort.deleteObject(objectType, objectOid);
    }

    /**
     *  Performs listObjects operation and returns ObjectListType
     *
     *  @return ObjectListType or null, if empty
     * */
    private ObjectListType listObjectsTest(String objectType) throws FaultMessage{
        PagingType paging = new PagingType();
        OperationOptionsType options = new OperationOptionsType();
        Holder<ObjectListType> objectListHolder = new Holder<ObjectListType>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();

        modelPort.listObjects(objectType, paging, options, objectListHolder, resultHolder);

        return objectListHolder.value;
    }

    /**
     *  Performs listAccountShadowOwner
     *
     *  @return UserType or null(empty), if account has no owner
     * */
    private UserType listAccountShadowOwnerTest(String accountOid) throws FaultMessage{
        Holder<UserType> userHolder = new Holder<UserType>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();

        modelPort.listAccountShadowOwner(accountOid, userHolder, resultHolder);

        return userHolder.value;
    }

    /**
     *  Performs addObject operation
     *
     *  @return String
     * */
    private String addObjectTest(ObjectType object) throws FaultMessage{
        Holder<String> oidHolder = new Holder<String>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();

        modelPort.addObject(object, oidHolder, resultHolder);

        AssertJUnit.assertNotNull(getObjectTest(getTypeUri(ObjectType.class), oidHolder.value));

        return oidHolder.value;
    }

    /**
     *  Performs searchObjects operation
     *
     *  @return ObjectListType or null, if search results are empty
     *
     * */
    private ObjectListType searchObjectsTest(String objectType, QueryType query) throws FaultMessage{
        OperationOptionsType options = new OperationOptionsType();
        Holder<ObjectListType> objectListHolder = new Holder<ObjectListType>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();

        modelPort.searchObjects(objectType, query, options, objectListHolder, resultHolder);

        return objectListHolder.value;
    }

    /**
     *  Performs listResourceObjectShadows
     *
     *  @return ResourceObjectShadowListType
     * */
    private ResourceObjectShadowListType listResourceObjectShadows(String resourceOid, String resourceObjectType) throws FaultMessage{
        Holder<ResourceObjectShadowListType> objectListHolder = new Holder<ResourceObjectShadowListType>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();

        modelPort.listResourceObjectShadows(resourceOid, resourceObjectType, objectListHolder, resultHolder);

        return objectListHolder.value;
    }

    /**
     *  Performs importFromResource operation
     *
     *  TODO - needs more testing, not sure if fully functional
     *
     *  @return TaskType
     * */
    private TaskType importFromResourceTest(String resourceOid, String classType) throws FaultMessage, ObjectNotFoundException {
        QName objectClass = new QName(NS_COMMON, classType);
        TaskType task;

        task = modelPort.importFromResource(resourceOid ,objectClass);

        return task;
    }

    /**
     *  Performs listResourceObjects
     *
     *  TODO - needs more testing, not sure if fully functional
     *
     *  @return ObjectListType or null (empty list?), if resource is empty
     * */
    private ObjectListType listResourceObjectsTest(String resourceOid, String classType) throws FaultMessage{
        QName objectType = new QName(NS_COMMON, classType);
        PagingType paging = new PagingType();
        Holder<ObjectListType> objectListHolder = new Holder<ObjectListType>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();

        modelPort.listResourceObjects(resourceOid, objectType, paging, objectListHolder, resultHolder);

        return objectListHolder.value;
    }

    /**
     *  Performs getObject operation
     *
     *  @return ObjectType
     * */
    private ObjectType getObjectTest(String objectType, String objectOid) throws FaultMessage{
        OperationOptionsType options = new OperationOptionsType();
        Holder<ObjectType> objectHolder = new Holder<ObjectType>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();

        modelPort.getObject(objectType, objectOid, options, objectHolder, resultHolder);

        return objectHolder.value;
    }

    /**
     *  Performs modifyObject operation
     *
     *  @return OperationResultType
     * */
    private OperationResultType modifyObjectTest(String objectType, ObjectModificationType objectChange) throws FaultMessage{
        return modelPort.modifyObject(objectType, objectChange);
    }

    /**
     *  Performs testResource operation
     *
     *  @return OperationResultType
     * */
    private OperationResultType testResourceTest(String resourceOid) throws FaultMessage{
        return modelPort.testResource(resourceOid);
    }

    /**
     *  This method generates search query based on search filter sent as method parameter
     *
     *  @return QueryType
     * */
    private QueryType generateSearchQuery(String searchObjectName) throws SAXException, IOException{
        Element filter = parseElement(
                "<equal xmlns='http://prism.evolveum.com/xml/ns/public/query-2' xmlns:c='http://midpoint.evolveum.com/xml/ns/public/common/common-2a' >" +
                        "<path>c:name</path>" +
                        "<value>" + searchObjectName + "</value>" +
                        "</equal>"
        );

        QueryType query = new QueryType();
        query.setFilter(filter);
        return query;
    }

    /**
     *  Inicialize JAXBContext and perform unmarshall operation upon provided file.
     *
     *  returns Object - unmarshalled file
     * */
    private Object unmarshallFromFile(File file, String context) throws JAXBException{
        JAXBContext jaxbContext = JAXBContext.newInstance(context);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement jaxbElement = (JAXBElement)jaxbUnmarshaller.unmarshal(file);
        return jaxbElement.getValue();
    }

    /**
     *  Method checks results of searchObjectOperation
     * */
    private void checkSearchResults(ObjectListType objectList, String objectName, String testName){
        List<ObjectType> objects = objectList.getObject();
        if(objects.isEmpty()){
            throw new IllegalStateException(testName + " : Expected to find one " + objectName + ", found zero.");
        }
        if(objects.size() == 1){
            LOGGER.info(testName + ": Search operation was successful.");
            return;
        }
        throw new IllegalStateException(testName + ": Wrong search results.");
    }

    /**
     *  Method checks results of listObjectOperation
     * */
    private void checkListObjectsResults(ObjectListType objectList, int listSize, String testName){
        List<ObjectType> objects = objectList.getObject();

        if(objects.size() == listSize){
            LOGGER.info(testName + ": ListObjects operation performed correctly.");
        }else{
            LOGGER.error(testName + ": illegal objectList size.");
            throw new IllegalStateException(testName + ": illegal objectList size.");
        }
    }

    /*=============================================================================================================*/
    /*                                                   TESTS                                                     */
    /*=============================================================================================================*/

    /*=============================================ACCOUNT=========================================================*/

    //TODO - dorobit pridanie resource a usera, pred pridanim acc, inak nepujdze
    @Test
    public void wsTest_0101_accountAddObject()throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME+ACCOUNT_ADD_FILENAME);
        AccountShadowType account = (AccountShadowType)unmarshallFromFile(file, PACKAGE_COMMON_2A);

        accountOid = addObjectTest(account);

        //Check, if user was added correctly
        account = (AccountShadowType)getObjectTest(getTypeUri(AccountShadowType.class), accountOid);
        AssertJUnit.assertNotNull(account);
        AssertJUnit.assertEquals(account.getOid(), accountOid);

        LOGGER.info("wsTest_0101_accountAddObject: Account added correctly.");
    }

    @Test
    public void wsTest_0102_accountModifyObject() throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME + ACCOUNT_MODIFY_FILENAME);
        ObjectModificationType objectChange = (ObjectModificationType)unmarshallFromFile(file, PACKAGE_API_TYPES_2);

        modifyObjectTest(getTypeUri(AccountShadowType.class), objectChange);

        //Check, if changes were applied
        AccountShadowType account = (AccountShadowType)getObjectTest(getTypeUri(AccountShadowType.class), accountOid);
        AssertJUnit.assertNotNull(account);
        AssertJUnit.assertNotSame("Anakin", account.getName().getContent().get(1).toString());

        LOGGER.info("wsTest_0102_accountModifyObject: Modification applied correctly");
    }

    //todo - define resource in query
    @Test
    public void wsTest_0103_accountSearchObject() throws SAXException, IOException, FaultMessage{
        String connectorName = "Anakin After Change";
        QueryType query = generateSearchQuery(connectorName);

        ObjectListType objectList = searchObjectsTest(getTypeUri(AccountShadowType.class), query);
        checkSearchResults(objectList, "Account shadow type", "wsTest_0103_accountSearchObject");
    }

    //todo - define resource
    @Test
    public void wsTest_0104_accountListObjects() throws FaultMessage{
        ObjectListType objectList = listObjectsTest(getTypeUri(AccountShadowType.class));
        checkListObjectsResults(objectList, 1, "wsTest_0104_connectorListObjects");
    }

    @Test
    public void wsTest_0105_accountDeleteObject() throws FaultMessage{
        deleteObjectTest(getTypeUri(AccountShadowType.class), accountOid);
        LOGGER.info("wsTest_0105_accountDeleteObject: account shadow deleted correctly.");
    }

    /*=============================================CONNECTOR=======================================================*/

    @Test
    public void wsTest_0201_connectorAddObject()throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME+CONNECTOR_ADD_FILENAME);
        ConnectorType connector = (ConnectorType)unmarshallFromFile(file, PACKAGE_COMMON_2A);

        connectorOid = addObjectTest(connector);

        //Check, if user was added correctly
        connector = (ConnectorType)getObjectTest(getTypeUri(ConnectorType.class), connectorOid);
        AssertJUnit.assertNotNull(connector);
        AssertJUnit.assertEquals(connector.getOid(), connectorOid);

        LOGGER.info("wsTest_0201_connectorAddObject: Connector added correctly. ConnectorOid: " + connectorOid);
    }

    @Test
    public void wsTest_0202_connectorModifyObject() throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME + CONNECTOR_MODIFY_FILENAME);
        ObjectModificationType objectChange = (ObjectModificationType)unmarshallFromFile(file, PACKAGE_API_TYPES_2);

        modifyObjectTest(getTypeUri(ConnectorType.class), objectChange);

        //Check, if changes were applied
        ConnectorType connector = (ConnectorType)getObjectTest(getTypeUri(ConnectorType.class), connectorOid);
        AssertJUnit.assertNotNull(connector);
        AssertJUnit.assertNotSame("ICF org.identityconnectors.databasetable.DatabaseTableConnector", connector.getName().getContent().get(1).toString());

        LOGGER.info("wsTest_0202_connectorModifyObject: Modification applied correctly");
    }

    @Test
    public void wsTest_0203_connectorSearchObject() throws SAXException, IOException, FaultMessage{
        String connectorName = "ICF org.identityconnectors.databasetable.DatabaseTableConnectorAfterChange";
        QueryType query = generateSearchQuery(connectorName);

        ObjectListType objectList = searchObjectsTest(getTypeUri(ConnectorType.class), query);
        checkSearchResults(objectList, "connectorObject", "wsTest_0203_connectorSearchObject");
    }

    @Test
    public void wsTest_0204_connectorListObjects() throws FaultMessage{
        ObjectListType objectList = listObjectsTest(getTypeUri(ConnectorType.class));
        checkListObjectsResults(objectList, 4, "wsTest_0204_connectorListObjects");
    }

    @Test
    public void wsTest_0205_connectorDeleteObject() throws FaultMessage{
        deleteObjectTest(getTypeUri(ConnectorType.class), connectorOid);
        LOGGER.info("wsTest_0205_connectorDeleteObject: user deleted correctly.");
    }

    /*=============================================CONNECTOR_HOST==================================================*/

    @Test
    public void wsTest_0301_connectorHostAddObject()throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME+CONNECTOR_HOST_ADD_FILENAME);
        ConnectorHostType connectorHost = (ConnectorHostType)unmarshallFromFile(file, PACKAGE_COMMON_2A);

        connectorHostOid = addObjectTest(connectorHost);

        //Check, if user was added correctly
        connectorHost = (ConnectorHostType)getObjectTest(getTypeUri(ConnectorHostType.class), connectorHostOid);
        AssertJUnit.assertNotNull(connectorHost);
        AssertJUnit.assertEquals(connectorHost.getOid(), connectorHostOid);

        LOGGER.info("wsTest_0301_connectorHostAddObject: Connector Host added correctly. ConnectorHostOid: " + connectorHostOid);
    }

    @Test
    public void wsTest_0302_connectorHostModifyObject() throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME + CONNECTOR_HOST_MODIFY_FILENAME);
        ObjectModificationType objectChange = (ObjectModificationType)unmarshallFromFile(file, PACKAGE_API_TYPES_2);

        modifyObjectTest(getTypeUri(ConnectorHostType.class), objectChange);

        //Check, if changes were applied
        ConnectorHostType connectorHost = (ConnectorHostType)getObjectTest(getTypeUri(ConnectorHostType.class), connectorHostOid);
        AssertJUnit.assertNotNull(connectorHost);
        AssertJUnit.assertNotSame("ICF Connector server on localhost:8759", connectorHost.getName().getContent().get(1).toString());

        LOGGER.info("wsTest_0302_connectorHostModifyObject: Modification applied correctly");
    }

    @Test
    public void wsTest_0303_connectorHostSearchObject() throws SAXException, IOException, FaultMessage{
        String connectorHostName = "ICF Connector server on localhost:8759AfterChange";
        QueryType query = generateSearchQuery(connectorHostName);

        ObjectListType objectList = searchObjectsTest(getTypeUri(ConnectorHostType.class), query);
        checkSearchResults(objectList, "connectorHostObject", "wsTest_0303_connectorHostSearchObject");
    }

    @Test
    public void wsTest_0304_connectorListObjects() throws FaultMessage{
        ObjectListType objectList = listObjectsTest(getTypeUri(ConnectorHostType.class));
        checkListObjectsResults(objectList, 1, "wsTest_0304_connectorListObjects");
    }

    @Test
    public void wsTest_0305_connectorDeleteObject() throws FaultMessage{
        deleteObjectTest(getTypeUri(ConnectorHostType.class), connectorHostOid);
        LOGGER.info("wsTest_0305_connectorDeleteObject: user deleted correctly.");
    }

    /*=============================================GENERIC_OBJECT==================================================*/
    @Test
    public void wsTest_0401_genericObjectAddObject()throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME+GENERIC_OBJECT_ADD_FILENAME);
        GenericObjectType genericObject = (GenericObjectType)unmarshallFromFile(file, PACKAGE_COMMON_2A);

        genericObjectOid = addObjectTest(genericObject);

        //Check, if user was added correctly
        genericObject = (GenericObjectType)getObjectTest(getTypeUri(GenericObjectType.class), genericObjectOid);
        AssertJUnit.assertNotNull(genericObject);
        AssertJUnit.assertEquals(genericObject.getOid(), genericObjectOid);

        LOGGER.info("wsTest_0401_genericObjectAddObject: Generic Object added correctly. GenericObjectOid: " + genericObjectOid);
    }

    @Test
    public void wsTest_0402_genericObjectModifyObject() throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME + GENERIC_OBJECT_MODIFY_FILENAME);
        ObjectModificationType objectChange = (ObjectModificationType)unmarshallFromFile(file, PACKAGE_API_TYPES_2);

        modifyObjectTest(getTypeUri(GenericObjectType.class), objectChange);

        //Check, if changes were applied
        GenericObjectType genericObject = (GenericObjectType)getObjectTest(getTypeUri(GenericObjectType.class), genericObjectOid);
        AssertJUnit.assertNotNull(genericObject);
        AssertJUnit.assertNotSame("My Sample Config Object", genericObject.getName().getContent().get(1).toString());

        LOGGER.info("wsTest_0402_genericObjectModifyObject: Modification applied correctly");
    }

    @Test
    public void wsTest_0403_genericObjectSearchObject() throws SAXException, IOException, FaultMessage{
        String genericObjectName = "My Sample Config Object After Change";
        QueryType query = generateSearchQuery(genericObjectName);

        ObjectListType objectList = searchObjectsTest(getTypeUri(GenericObjectType.class), query);
        checkSearchResults(objectList, "genericObject", "wsTest_0403_genericObjectSearchObject");
    }

    @Test
    public void wsTest_0404_genericObjectlistObjects() throws FaultMessage{
        ObjectListType objectList = listObjectsTest(getTypeUri(GenericObjectType.class));
        checkListObjectsResults(objectList, 1, "wsTest_0404_genericObjectlistObjects");
    }

    @Test
    public void wsTest_0405_genericObjectDeleteObject() throws FaultMessage{
        deleteObjectTest(getTypeUri(GenericObjectType.class), genericObjectOid);
        LOGGER.info("wsTest_0405_genericObjectDeleteObject: user deleted correctly.");
    }

    /*=============================================RESOURCE========================================================*/

    //TODO - resource testy, this will be the hardest part
    //TODO - implement listAccountShadowOwner operation
    @Test
    public void wsTest_0501_resourceAddObject(){}

    /*=============================================USER============================================================*/

    @Test
    public void wsTest_0601_userAddObject()throws JAXBException, FaultMessage{
        File userFile = new File(WEBSERVICE_DIR_NAME+USER_ADD_FILENAME);
        UserType user = (UserType)unmarshallFromFile(userFile, PACKAGE_COMMON_2A);

        userOid = addObjectTest(user);

        //Check, if user was added correctly
        user = (UserType)getObjectTest(getTypeUri(UserType.class), userOid);
        AssertJUnit.assertNotNull(user);
        AssertJUnit.assertEquals(user.getOid(), userOid);

        LOGGER.info("wsTest_0601_userAddObject: User added correctly.");
    }

    @Test
    public void wsTest_0602_userModifyObject() throws JAXBException, FaultMessage{
        File changeFile = new File(WEBSERVICE_DIR_NAME + USER_MODIFY_FILENAME);
        ObjectModificationType objectChange = (ObjectModificationType)unmarshallFromFile(changeFile, PACKAGE_API_TYPES_2);

        modifyObjectTest(getTypeUri(UserType.class), objectChange);

        //Check, if changes were applied
        UserType user = (UserType)getObjectTest(getTypeUri(UserType.class), userOid);
        AssertJUnit.assertNotNull(user);
        AssertJUnit.assertNotSame("Anakin Skywalker", user.getFullName().getContent().get(1));
        AssertJUnit.assertNotSame("Jedi Enclave, Coruscant", user.getLocality().getContent().get(1));

        LOGGER.info("wsTest_0602_userModifyObject: Modification applied correctly");
    }

    @Test
    public void wsTest_0603_userSearchObject() throws SAXException, IOException, FaultMessage{
        String userName = "Anakin";
        QueryType query = generateSearchQuery(userName);

        ObjectListType objectList = searchObjectsTest(getTypeUri(UserType.class), query);
        checkSearchResults(objectList, "UserObject", "wsTest_0603_userSearchObject");
    }

    @Test
    public void wsTest_0604_userListObjects() throws FaultMessage{
        ObjectListType objectList = listObjectsTest(getTypeUri(UserType.class));
        checkListObjectsResults(objectList, 2, "wsTest_0604_userListObjects");
    }

    @Test
    public void wsTest_0605_userDeleteObject() throws FaultMessage{
        deleteObjectTest(getTypeUri(UserType.class), userOid);
        LOGGER.info("wsTest_0605_userDeleteObject: user deleted correctly.");
    }

    /*=============================================USER_TEMPLATE===================================================*/

    @Test
    public void wsTest_0701_userTemplateAddObject()throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME+USER_TEMPLATE_ADD_FILENAME);
        UserTemplateType userTemplate = (UserTemplateType)unmarshallFromFile(file, PACKAGE_COMMON_2A);

        userTemplateOid = addObjectTest(userTemplate);

        //Check, if user was added correctly
        userTemplate = (UserTemplateType)getObjectTest(getTypeUri(UserTemplateType.class), userTemplateOid);
        AssertJUnit.assertNotNull(userTemplate);
        AssertJUnit.assertEquals(userTemplate.getOid(), userTemplateOid);

        LOGGER.info("wsTest_0701_userTemplateAddObject: UserTemplate added correctly.");
    }

    @Test
    public void wsTest_0702_userTemplateModifyObject() throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME + USER_TEMPLATE_MODIFY_FILENAME);
        ObjectModificationType objectChange = (ObjectModificationType)unmarshallFromFile(file, PACKAGE_API_TYPES_2);

        modifyObjectTest(getTypeUri(UserTemplateType.class), objectChange);

        //Check, if changes were applied
        UserTemplateType userTemplate = (UserTemplateType)getObjectTest(getTypeUri(UserTemplateType.class), userTemplateOid);
        AssertJUnit.assertNotNull(userTemplate);
        AssertJUnit.assertNotSame("Complex User Template", userTemplate.getName().getContent().get(1).toString());

        LOGGER.info("wsTest_0702_userTemplateModifyObject: Modification applied correctly");
    }

    @Test
    public void wsTest_0703_userTemplateSearchObject() throws SAXException, IOException, FaultMessage{
        String name = "Complex User Template After Change";
        QueryType query = generateSearchQuery(name);

        ObjectListType objectList = searchObjectsTest(getTypeUri(UserTemplateType.class), query);
        checkSearchResults(objectList, "UserTemplateObject", "wsTest_0703_userTemplateSearchObject");
    }

    @Test
    public void wsTest_0704_userTemplateListObjects() throws FaultMessage{
        ObjectListType objectList = listObjectsTest(getTypeUri(UserTemplateType.class));
        checkListObjectsResults(objectList, 1, "wsTest_0704_userTemplateListObjects");
    }

    @Test
    public void wsTest_0705_userTemplateDeleteObject() throws FaultMessage{
        deleteObjectTest(getTypeUri(UserTemplateType.class), userTemplateOid);
        LOGGER.info("wsTest_0705_userTemplateDeleteObject: user template deleted correctly.");
    }

    /*=============================================SYSTEM_CONFIGURATION============================================*/

    @Test
    public void wsTest_0801_systemConfigAddObject()throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME+SYSTEM_CONFIG_ADD_FILENAME);
        SystemConfigurationType systemConfig = (SystemConfigurationType)unmarshallFromFile(file, PACKAGE_COMMON_2A);

        systemConfigOid = addObjectTest(systemConfig);

        //Check, if user was added correctly
        systemConfig = (SystemConfigurationType)getObjectTest(getTypeUri(SystemConfigurationType.class), systemConfigOid);
        AssertJUnit.assertNotNull(systemConfig);
        AssertJUnit.assertEquals(systemConfig.getOid(), systemConfigOid);

        LOGGER.info("wsTest_0801_systemConfigAddObject: System Configuration added correctly.");
    }

    @Test
    public void wsTest_0802_systemConfigModifyObject() throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME + SYSTEM_CONFIG_MODIFY_FILENAME);
        ObjectModificationType objectChange = (ObjectModificationType)unmarshallFromFile(file, PACKAGE_API_TYPES_2);

        modifyObjectTest(getTypeUri(SystemConfigurationType.class), objectChange);

        //Check, if changes were applied
        SystemConfigurationType systemConfig = (SystemConfigurationType)getObjectTest(getTypeUri(SystemConfigurationType.class), systemConfigOid);
        AssertJUnit.assertNotNull(systemConfig);
        AssertJUnit.assertNotSame("SystemConfigurationTest", systemConfig.getName().getContent().get(1).toString());

        LOGGER.info("wsTest_0802_systemConfigModifyObject: Modification applied correctly");
    }

    @Test
    public void wsTest_0803_systemConfigSearchObject() throws SAXException, IOException, FaultMessage{
        String name = "SystemConfigurationTestAfterChange";
        QueryType query = generateSearchQuery(name);

        ObjectListType objectList = searchObjectsTest(getTypeUri(SystemConfigurationType.class), query);
        checkSearchResults(objectList, "SystemConfigurationType", "wsTest_0803_systemConfigSearchObject");
    }

    @Test
    public void wsTest_0804_systemConfigListObjects() throws FaultMessage{
        ObjectListType objectList = listObjectsTest(getTypeUri(SystemConfigurationType.class));
        checkListObjectsResults(objectList, 2, "wsTest_0804_systemConfigListObjects");
    }

    @Test
    public void wsTest_0805_systemConfigDeleteObject() throws FaultMessage{
        deleteObjectTest(getTypeUri(SystemConfigurationType.class), systemConfigOid);
        LOGGER.info("wsTest_0805_systemConfigDeleteObject: system configuration deleted correctly.");
    }

    /*=============================================TASK============================================================*/

    @Test
    public void wsTest_0901_taskAddObject()throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME+TASK_ADD_FILENAME);
        TaskType task = (TaskType)unmarshallFromFile(file, PACKAGE_COMMON_2A);

        taskOid = addObjectTest(task);

        //Check, if user was added correctly
        task = (TaskType)getObjectTest(getTypeUri(TaskType.class), taskOid);
        AssertJUnit.assertNotNull(task);
        AssertJUnit.assertEquals(task.getOid(), taskOid);

        LOGGER.info("wsTest_0901_taskAddObject:  Task added correctly.");
    }

    @Test
    public void wsTest_0902_taskModifyObject() throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME + TASK_MODIFY_FILENAME);
        ObjectModificationType objectChange = (ObjectModificationType)unmarshallFromFile(file, PACKAGE_API_TYPES_2);

        modifyObjectTest(getTypeUri(TaskType.class), objectChange);

        //Check, if changes were applied
        TaskType task = (TaskType)getObjectTest(getTypeUri(TaskType.class), taskOid);
        AssertJUnit.assertNotNull(task);
        AssertJUnit.assertNotSame("Reconciliation: OpenDJ", task.getName().getContent().get(1).toString());

        LOGGER.info("wsTest_0902_taskModifyObject: Modification applied correctly");
    }

    @Test
    public void wsTest_0903_taskSearchObject() throws SAXException, IOException, FaultMessage{
        String name = "Reconciliation: OpenDJ After Change";
        QueryType query = generateSearchQuery(name);

        ObjectListType objectList = searchObjectsTest(getTypeUri(TaskType.class), query);
        checkSearchResults(objectList, "TaskType", "wsTest_0903_taskSearchObject");
    }

    @Test
    public void wsTest_0904_taskListObjects() throws FaultMessage{
        ObjectListType objectList = listObjectsTest(getTypeUri(TaskType.class));
        checkListObjectsResults(objectList, 1, "wsTest_0904_taskListObjects");
    }

    @Test
    public void wsTest_0905_taskDeleteObject() throws FaultMessage{
        deleteObjectTest(getTypeUri(TaskType.class), taskOid);
        LOGGER.info("wsTest_0905_taskDeleteObject: task deleted correctly.");
    }

    /*=============================================RESOURCE_OBJECT_SHADOW==========================================*/

    //TODO - Some ws operations (modify, delete, search, list) have problems with ResourceObjectShadowType
    @Test
    public void wsTest_1001_resourceObjectAddObject()throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME+ACCOUNT_ADD_FILENAME);
        ResourceObjectShadowType resourceObject = (ResourceObjectShadowType)unmarshallFromFile(file, PACKAGE_COMMON_2A);

        accountOid = addObjectTest(resourceObject);

        //Check, if user was added correctly
        resourceObject = (ResourceObjectShadowType)getObjectTest(getTypeUri(ResourceObjectShadowType.class), accountOid);
        AssertJUnit.assertNotNull(resourceObject);
        AssertJUnit.assertEquals(resourceObject.getOid(), accountOid);

        LOGGER.info("wsTest_1001_resourceObjectAddObject:  Resource Object added correctly.");
    }

    @Test
    public void wsTest_1002_resourceObjectModifyObject() throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME + ACCOUNT_MODIFY_FILENAME);
        ObjectModificationType objectChange = (ObjectModificationType)unmarshallFromFile(file, PACKAGE_API_TYPES_2);

        modifyObjectTest(getTypeUri(ResourceObjectShadowType.class), objectChange);

        //Check, if changes were applied
        ResourceObjectShadowType resourceObject = (ResourceObjectShadowType)getObjectTest(getTypeUri(ResourceObjectShadowType.class), accountOid);
        AssertJUnit.assertNotNull(resourceObject);
        AssertJUnit.assertNotSame("Anakin", resourceObject.getName().getContent().get(1).toString());

        LOGGER.info("wsTest_1002_resourceObjectModifyObject: Modification applied correctly");
    }

    //TODO - define resource in search query
    @Test
    public void wsTest_1003_resourceObjectSearchObject() throws SAXException, IOException, FaultMessage{
        String name = "Anakin After Change";
        QueryType query = generateSearchQuery(name);

        ObjectListType objectList = searchObjectsTest(getTypeUri(ResourceObjectShadowType.class), query);
        checkSearchResults(objectList, "ResourceObjectShadowType", "wsTest_1003_resourceObjectSearchObject");
    }

    //TODO - define resource in search query
    @Test
    public void wsTest_1004_resourceObjectListObjects() throws FaultMessage{
        ObjectListType objectList = listObjectsTest(getTypeUri(ResourceObjectShadowType.class));
        checkListObjectsResults(objectList, 1, "wsTest_1004_resourceObjectListObjects");
    }

    @Test
    public void wsTest_1005_taskDeleteObject() throws FaultMessage{
        deleteObjectTest(getTypeUri(ResourceObjectShadowType.class), accountOid);
        LOGGER.info("wsTest_1005_taskDeleteObject: Resource Object deleted correctly.");
    }

    /*=============================================OBJECT==========================================================*/

    //TODO - Problems with search and modify operations, other seems normal
    @Test
    public void wsTest_1101_objectAddObject()throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME+USER_ADD_FILENAME);
        ObjectType object = (ObjectType)unmarshallFromFile(file, PACKAGE_COMMON_2A);

        userOid = addObjectTest(object);

        //Check, if user was added correctly
        object = getObjectTest(getTypeUri(ObjectType.class), userOid);
        AssertJUnit.assertNotNull(object);
        AssertJUnit.assertEquals(object.getOid(), userOid);

        LOGGER.info("wsTest_1101_objectAddObject: Object added correctly.");
    }

    //TODO - Change modification file
    @Test
    public void wsTest_1102_objectModifyObject() throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME + USER_MODIFY_FILENAME);
        ObjectModificationType objectChange = (ObjectModificationType)unmarshallFromFile(file, PACKAGE_API_TYPES_2);

        modifyObjectTest(getTypeUri(ObjectType.class), objectChange);

        //Check, if changes were applied
        ObjectType object = getObjectTest(getTypeUri(ObjectType.class), userOid);
        AssertJUnit.assertNotNull(object);
        AssertJUnit.assertNotSame("Anakin Skywalker", object.getName().getContent().get(1).toString());

        LOGGER.info("wsTest_1102_objectModifyObject: Modification applied correctly");
    }

    @Test
    public void wsTest_1203_objectSearchObject() throws SAXException, IOException, FaultMessage{
        String userName = "Anakin";
        QueryType query = generateSearchQuery(userName);

        ObjectListType objectList = searchObjectsTest(getTypeUri(ObjectType.class), query);
        checkSearchResults(objectList, "Object", "wsTest_1203_objectSearchObject");
    }

    @Test
    public void wsTest_1204_objectListObjects() throws FaultMessage{
        ObjectListType objectList = listObjectsTest(getTypeUri(ObjectType.class));
        checkListObjectsResults(objectList, 8, "wsTest_1204_objectListObjects");
    }

    @Test
    public void wsTest_1205_userDeleteObject() throws FaultMessage{
        deleteObjectTest(getTypeUri(ObjectType.class), userOid);
        LOGGER.info("wsTest_1205_userDeleteObject: user deleted correctly.");
    }

    /*=============================================ROLE============================================================*/

    @Test
    public void wsTest_1201_roleAddObject()throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME+ROLE_ADD_FILENAME);
        RoleType role = (RoleType)unmarshallFromFile(file, PACKAGE_COMMON_2A);

        roleOid = addObjectTest(role);

        //Check, if user was added correctly
        role = (RoleType)getObjectTest(getTypeUri(RoleType.class), roleOid);
        AssertJUnit.assertNotNull(role);
        AssertJUnit.assertEquals(role.getOid(), roleOid);

        LOGGER.info("wsTest_1201_roleAddObject:  Task added correctly.");
    }

    @Test
    public void wsTest_1202_roleModifyObject() throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME + ROLE_MODIFY_FILENAME);
        ObjectModificationType objectChange = (ObjectModificationType)unmarshallFromFile(file, PACKAGE_API_TYPES_2);

        modifyObjectTest(getTypeUri(RoleType.class), objectChange);

        //Check, if changes were applied
        RoleType role = (RoleType)getObjectTest(getTypeUri(RoleType.class), roleOid);
        AssertJUnit.assertNotNull(role);
        AssertJUnit.assertNotSame("Pirate Lord", role.getName().getContent().get(1).toString());

        LOGGER.info("wsTest_1202_roleModifyObject: Modification applied correctly");
    }

    @Test
    public void wsTest_1203_taskSearchObject() throws SAXException, IOException, FaultMessage{
        String name = "Pirate Lord After Change";
        QueryType query = generateSearchQuery(name);

        ObjectListType objectList = searchObjectsTest(getTypeUri(RoleType.class), query);
        checkSearchResults(objectList, "RoleType", "wsTest_1203_taskSearchObject");
    }

    @Test
    public void wsTest_1204_taskListObjects() throws FaultMessage{
        ObjectListType objectList = listObjectsTest(getTypeUri(RoleType.class));
        checkListObjectsResults(objectList, 1, "wsTest_1204_taskListObjects");
    }

    @Test
    public void wsTest_1205_taskDeleteObject() throws FaultMessage{
        deleteObjectTest(getTypeUri(RoleType.class), roleOid);
        LOGGER.info("wsTest_1205_taskDeleteObject: role deleted correctly.");
    }

    /*=============================================PASSWORD_POLICY=================================================*/

    @Test
    public void wsTest_1301_passwordPolicyAddObject()throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME+PASSWORD_POLICY_ADD_FILENAME);
        ValuePolicyType passPolicy = (ValuePolicyType)unmarshallFromFile(file, PACKAGE_COMMON_2A);

        passwordPolicyOid = addObjectTest(passPolicy);

        //Check, if user was added correctly
        passPolicy = (ValuePolicyType)getObjectTest(getTypeUri(ValuePolicyType.class), passwordPolicyOid);
        AssertJUnit.assertNotNull(passPolicy);
        AssertJUnit.assertEquals(passPolicy.getOid(), passwordPolicyOid);

        LOGGER.info("wsTest_1301_passwordPolicyAddObject:  Password Policy added correctly.");
    }

    @Test
    public void wsTest_1302_passwordPolicyModifyObject() throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME + PASSWORD_POLICY_MODIFY_FILENAME);
        ObjectModificationType objectChange = (ObjectModificationType)unmarshallFromFile(file, PACKAGE_API_TYPES_2);

        modifyObjectTest(getTypeUri(ValuePolicyType.class), objectChange);

        //Check, if changes were applied
        ValuePolicyType passPolicy = (ValuePolicyType)getObjectTest(getTypeUri(ValuePolicyType.class), passwordPolicyOid);
        AssertJUnit.assertNotNull(passPolicy);
        AssertJUnit.assertNotSame("Alphanumeric Password Policy", passPolicy.getName().getContent().get(1).toString());

        LOGGER.info("wsTest_1302_passwordPolicyModifyObject: Modification applied correctly");
    }

    @Test
    public void wsTest_1303_passwordPolicySearchObject() throws SAXException, IOException, FaultMessage{
        String name = "Alphanumeric Password Policy After Change";
        QueryType query = generateSearchQuery(name);

        ObjectListType objectList = searchObjectsTest(getTypeUri(ValuePolicyType.class), query);
        checkSearchResults(objectList, "Password Policy", "wsTest_1303_passwordPolicySearchObject");
    }

    @Test
    public void wsTest_1304_taskListObjects() throws FaultMessage{
        ObjectListType objectList = listObjectsTest(getTypeUri(ValuePolicyType.class));
        checkListObjectsResults(objectList, 2, "wsTest_1304_taskListObjects");
    }

    @Test
    public void wsTest_1305_taskDeleteObject() throws FaultMessage{
        deleteObjectTest(getTypeUri(ValuePolicyType.class), passwordPolicyOid);
        LOGGER.info("wsTest_1305_taskDeleteObject: Password Policy deleted correctly.");
    }

    /*=============================================NODE============================================================*/

    /**
     *  Since nodes are generated by midpoint and there is no user interaction between nodes and midpoint, e. g.
     *  importing or editing Nodes, only test that makes any sense is getNodeObject, thus other tests are
     *  not implemented here
     *
     *  ListObjects and searchObject operation were added
     * */
    @Test
    public void wsTest_1401_nodeGetObject() throws FaultMessage, SAXException, IOException{
        String name = "DefaultNode";
        QueryType query = generateSearchQuery(name);
        ObjectListType objectList = searchObjectsTest(getTypeUri(NodeType.class), query);
        List<ObjectType> objects = objectList.getObject();
        String nodeOid = objects.get(0).getOid();

        NodeType node = (NodeType)getObjectTest(getTypeUri(NodeType.class), nodeOid);
        AssertJUnit.assertNotNull(node);
        AssertJUnit.assertEquals(nodeOid, node.getOid());
        LOGGER.info("wsTest_1401_nodeGetObject: searchObject and getObject operations performed correctly. Node oid: " + nodeOid);
    }

    @Test
    public void wsTest_1402_taskListObjects() throws FaultMessage{
        ObjectListType objectList = listObjectsTest(getTypeUri(NodeType.class));
        checkListObjectsResults(objectList, 1, "wsTest_1402_taskListObjects");
    }

    /*=============================================ORG=============================================================*/

    @Test
    public void wsTest_1501_orgAddObject()throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME+ORG_ADD_FILENAME);
        OrgType org = (OrgType)unmarshallFromFile(file, PACKAGE_COMMON_2A);

        orgOid = addObjectTest(org);

        //Check, if user was added correctly
        org = (OrgType)getObjectTest(getTypeUri(OrgType.class), orgOid);
        AssertJUnit.assertNotNull(org);
        AssertJUnit.assertEquals(org.getOid(), orgOid);

        LOGGER.info("wsTest_1501_orgAddObject:  Organisation unit added correctly.");
    }

    @Test
    public void wsTest_1502_orgModifyObject() throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME + ORG_MODIFY_FILENAME);
        ObjectModificationType objectChange = (ObjectModificationType)unmarshallFromFile(file, PACKAGE_API_TYPES_2);

        modifyObjectTest(getTypeUri(OrgType.class), objectChange);

        //Check, if changes were applied
        OrgType org = (OrgType)getObjectTest(getTypeUri(OrgType.class), orgOid);
        AssertJUnit.assertNotNull(org);
        AssertJUnit.assertNotSame("F0001", org.getName().getContent().get(1).toString());

        LOGGER.info("wsTest_1502_orgModifyObject: Modification applied correctly");
    }

    @Test
    public void wsTest_1503_orgSearchObject() throws SAXException, IOException, FaultMessage{
        String name = "F0001 After Change";
        QueryType query = generateSearchQuery(name);

        ObjectListType objectList = searchObjectsTest(getTypeUri(OrgType.class), query);
        checkSearchResults(objectList, "Organisation unit ", "wsTest_1503_orgSearchObject");
    }

    @Test
    public void wsTest_1504_orgListObjects() throws FaultMessage{
        ObjectListType objectList = listObjectsTest(getTypeUri(OrgType.class));
        checkListObjectsResults(objectList, 1, "wsTest_1504_taskListObjects");
    }

    @Test
    public void wsTest_1505_orgDeleteObject() throws FaultMessage{
        deleteObjectTest(getTypeUri(OrgType.class), orgOid);
        LOGGER.info("wsTest_1505_taskDeleteObject: Organisation unit deleted correctly.");
    }

    /*=============================================ABSTRACT_ROLE===================================================*/

    /**
     *  In these tests, we used same objects, as in tests with role, but in these tests, we use objects with type
     *  AbstractRoleType instead of RoleType, what is subclass of AbstractRoleType.
     *
     *  TODO - Some ws operations (modify, search, delete) seems to have problem with AbstractRoleType objects
     * */
    @Test
    public void wsTest_1601_abstractRoleAddObject()throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME+ROLE_ADD_FILENAME);
        AbstractRoleType abstractRole = (AbstractRoleType)unmarshallFromFile(file, PACKAGE_COMMON_2A);

        roleOid = addObjectTest(abstractRole);

        //Check, if user was added correctly
        abstractRole = (AbstractRoleType)getObjectTest(getTypeUri(AbstractRoleType.class), roleOid);
        AssertJUnit.assertNotNull(abstractRole);
        AssertJUnit.assertEquals(abstractRole.getOid(), roleOid);

        LOGGER.info("wsTest_1601_abstractRoleAddObject:  Abstract role added correctly.");
    }

    @Test
    public void wsTest_1602_abstractRoleModifyObject() throws JAXBException, FaultMessage{
        File file = new File(WEBSERVICE_DIR_NAME + ROLE_MODIFY_FILENAME);
        ObjectModificationType objectChange = (ObjectModificationType)unmarshallFromFile(file, PACKAGE_API_TYPES_2);

        modifyObjectTest(getTypeUri(AbstractRoleType.class), objectChange);

        //Check, if changes were applied
        AbstractRoleType abstractRole = (AbstractRoleType)getObjectTest(getTypeUri(AbstractRoleType.class), roleOid);
        AssertJUnit.assertNotNull(abstractRole);
        AssertJUnit.assertNotSame("Pirate Lord", abstractRole.getName().getContent().get(1).toString());

        LOGGER.info("wsTest_1602_abstractRoleModifyObject: Modification applied correctly");
    }

    @Test
    public void wsTest_1603_abstractRoleSearchObject() throws SAXException, IOException, FaultMessage{
        String name = "Pirate Lord After Change";
        QueryType query = generateSearchQuery(name);

        ObjectListType objectList = searchObjectsTest(getTypeUri(AbstractRoleType.class), query);
        checkSearchResults(objectList, "Abstract role ", "wsTest_1603_abstractRoleSearchObject");
    }

    @Test
    public void wsTest_1604_abstractRoleListObjects() throws FaultMessage{
        ObjectListType objectList = listObjectsTest(getTypeUri(AbstractRoleType.class));
        checkListObjectsResults(objectList, 1, "wsTest_1604_abstractRoleListObjects");
    }

    @Test
    public void wsTest_1605_abstractRoleDeleteObject() throws FaultMessage{
        deleteObjectTest(getTypeUri(AbstractRoleType.class), roleOid);
        LOGGER.info("wsTest_1605_abstractRoleDeleteObject: Abstract role deleted correctly.");
    }

}
