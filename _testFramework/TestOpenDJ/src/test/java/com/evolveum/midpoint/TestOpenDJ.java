/*
 * Copyright (c) 2011 Evolveum
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
 * Portions Copyrighted 2011 [name of copyright owner]
 */

package com.evolveum.midpoint;
import com.evolveum.midpoint.common.crypto.EncryptionException;
import com.evolveum.midpoint.xml.ns._public.common.api_types_2.ObjectListType;
import com.evolveum.midpoint.xml.ns._public.common.api_types_2.ObjectModificationType;
import com.evolveum.midpoint.xml.ns._public.common.api_types_2.OperationOptionsType;
import com.evolveum.midpoint.xml.ns._public.common.common_2a.*;

import com.evolveum.midpoint.xml.ns._public.common.fault_1_wsdl.FaultMessage;
import com.evolveum.prism.xml.ns._public.query_2.PagingType;
import com.evolveum.prism.xml.ns._public.query_2.QueryType;
import com.evolveum.prism.xml.ns._public.types_2.ItemDeltaType;
import com.evolveum.prism.xml.ns._public.types_2.ModificationTypeType;

import org.testng.annotations.*;
import org.testng.AssertJUnit;

import org.w3c.dom.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.xml.sax.SAXException;

import javax.xml.ws.Holder;


/**
 *      OpenDJ test Suite
 *
 * <p>
 * This is a test suite aimed on testing midpoint cooperation
 * with LDAP server OpenDJ. This file is inspired by
 * TestSanity.java file written by Radovan Semancik, from
 * which most basic test cases are taken and implemented focused on
 * testing complex functionality of LDAP server OpenDJ.
 *
 * Name structure for tests: <resource_name>_<test_number>_<test_name>
 * This naming convention should and will be applied to all tests in
 * test framework
 * </p>
 *
 * @author Radovan Semancik
 * @author Erik Suta
 */


public class TestOpenDJ extends TestFrameworkUtil{

    private static final String REPO_DIR_NAME = "src/test/resources/repo/";
    private static final String REQUEST_DIR_NAME = "src/test/resources/request/";

    private static final String OPENDJ_RESOURCE_SCHEMA = "opendj-localhost-resource-sync-no-extension-advanced.xml";
    private static final String OPENDJ_RESOURCE_OBJECT = "opendj-localhost-resource-object.xml";
    private static final String OPENDJ_USER_ANAKIN = "opendj-user-anakin.xml";

    private static final String REQUEST_USER_MODIFY_ADD_ACCOUNT_OPENDJ_FILENAME = "user-modify-add-account.xml";
    private static final String REQUEST_USER_MODIFY_FULLNAME_LOCALITY_FILENAME = "user-anakin-modify-fullname-locality.xml";
    private static final String REQUEST_USER_MODIFY_PASSWORD = "user-anakin-modify-password.xml";

    private static final String OPENDJ_USER_ANAKIN_OID = "c0c010c0-d34d-b33f-f00d-111111111111";

    private static final String PACKAGE_API_TYPES_2 = "com.evolveum.midpoint.xml.ns._public.common.api_types_2";
    private static final String PACKAGE_COMMON_2A = "com.evolveum.midpoint.xml.ns._public.common.common_2a";

    private static String testUserOid;


    @BeforeMethod
    public void beforeMethod() throws Exception{}

    @AfterMethod
    public void afterMethod(){}

    /**
     *  Initialize embedded OpenDJ instance.
     */
    @BeforeClass
    public void initConfiguration() throws Exception{
        initSystem();
        LOGGER.info("OpenDJ basic test suite started.");
        modelPort = createModelPort();
        LOGGER.info("OpenDJtest: modelPort configured.");
        configurationType = getConfiguration(modelPort);
        LOGGER.info("OpenDJtest: Got system Configuration: " + configurationType);
    }

    @AfterClass
    public void stopResources() throws Exception{
        //cleanRepository();
        LOGGER.info("OpenDJ test basic suite finished.");
    }

    /*====================================================================================*/
    /*                                   Tests - Basic suite                              */
    /*====================================================================================*/

    /**
     *  openDJ_test001_addUserFromCode
     *
     *  In this test, simple user with few attributes is created and added to repository via web service modelPort.
     *  Afterwards, we check, if user was really added using getObject webservice method
     *
     * */
    @Test
    public void openDJ_test001_addUserFromCode() throws FaultMessage{
        Document doc = getDocument();
        OperationOptionsType options = new OperationOptionsType();
        UserType newUser = new UserType();
        Holder<String> oidHolder = new Holder<String>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();
        Holder<ObjectType> objectHolder = new Holder<ObjectType>();

        newUser.setName(createPolyStringType("Anakin", doc));
        newUser.setFullName(createPolyStringType("Anakin Skywalker", doc));
        newUser.setGivenName(createPolyStringType("Anakin", doc));
        newUser.setFamilyName(createPolyStringType("Skywalker", doc));
        newUser.setNickName(createPolyStringType("Vader", doc));
        newUser.setTitle(createPolyStringType("Darth", doc));
        newUser.setEmailAddress("LordVader@DeathStar.gi");
        newUser.setCredentials(createPasswordCredentials("5ecr3tp455w0rd"));

        modelPort.addObject(newUser, oidHolder, resultHolder);
        testUserOid = oidHolder.value;

        // check, if user was added correctly
        modelPort.getObject(getTypeUri(UserType.class), testUserOid, options, objectHolder, resultHolder);
        newUser = (UserType) objectHolder.value;
        AssertJUnit.assertNotNull(newUser);
        AssertJUnit.assertEquals(testUserOid, newUser.getOid());

        LOGGER.info("OpenDJtest: #openDJ_test001_addUserFromCode: User with oid: " + testUserOid + " added to repository.");
    }

    /**
     *  openDJ_test002_changeUserPassword
     *
     *  Using modelPort method modifyObject, we are going to modify password of user, whom we added
     *  in previous test. Afterwards, the check of password change is done
     * */
    @Test
    public void openDJ_test002_changeUserPassword() throws FaultMessage, EncryptionException {
        Document doc = getDocument();
        ObjectModificationType userDelta = new ObjectModificationType();
        String newPassword = "Luk3,1'mY0urF4th3r";
        ItemDeltaType passwordDelta = new ItemDeltaType();

        userDelta.setOid(testUserOid);

        passwordDelta.setModificationType(ModificationTypeType.REPLACE);
        passwordDelta.setPath(createPathElement("credentials/password", doc));
        ItemDeltaType.Value passwordValue = new ItemDeltaType.Value();
        passwordValue.getAny().add(toJaxbElement(COMMON_VALUE, createProtectedString(newPassword)));
        passwordDelta.setValue(passwordValue);
        userDelta.getModification().add(passwordDelta);
        modelPort.modifyObject(getTypeUri(UserType.class), userDelta);

        LOGGER.info("OpenDJtest: #openDJ_test002_changeUserPassword: User password changed to: " + passwordDelta.getValue().toString());

    }

    /**
     *  openDJ_test003_readUserObject
     *
     *  This test simple tries to retrieve user object added to midpoint repository in test 001 using
     *  getObject modelPort method.
     * */
    @Test
    public void openDJ_test003_readUserObject() throws FaultMessage{
        OperationOptionsType options = new OperationOptionsType();
        Holder<ObjectType> objectHolder = new Holder<ObjectType>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();

        modelPort.getObject(getTypeUri(UserType.class), testUserOid, options, objectHolder, resultHolder);
        UserType user = (UserType)objectHolder.value;

        //Neccessary check
        AssertJUnit.assertNotNull(user);
        AssertJUnit.assertEquals(testUserOid, user.getOid());

        LOGGER.info("OpenDJtest: #openDJ_test003_readUserObject: User with oid: " + user.getOid() + " found in repository.");

    }

    /**
     *  openDJ_test004_searchUserByName
     *
     *  In this test, we are searching for user Anakin in midpoint repository using Element filer and modelPort
     *  operation searchObjects. User was previously added, so we expect, that we will find just one user, any other
     *  result of search is considered as error state
     *
     * */
    @Test
    public void openDJ_test004_searchUserByName() throws SAXException, IOException, FaultMessage{
        String userName = "Anakin";

        Element filter = parseElement(
                "<equal xmlns='http://prism.evolveum.com/xml/ns/public/query-2' xmlns:c='http://midpoint.evolveum.com/xml/ns/public/common/common-2a' >" +
                        "<path>c:name</path>" +
                        "<value>" + userName + "</value>" +
                        "</equal>"
        );

        QueryType query = new QueryType();
        query.setFilter(filter);
        OperationOptionsType options = new OperationOptionsType();
        Holder<ObjectListType> objectListHolder = new Holder<ObjectListType>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();
        modelPort.searchObjects(getTypeUri(UserType.class), query, options, objectListHolder, resultHolder);

        ObjectListType objectList = objectListHolder.value;
        List<ObjectType> objects = objectList.getObject();

        if(objects.isEmpty()){
            throw new IllegalStateException("Expected to find a single user with username '" + userName + "' but found no-one.");
        }
        if(objects.size() == 1){
            LOGGER.info("OpenDJtest: #openDJ_test004_searchUserByName: User: " + userName + " found in repository!");
            return;
        }
        throw new IllegalStateException("Expected to find a single user with username '" + userName + "' but found " + objects.size() + " users instead");
    }

    /**
     *  openDJ_test005_deleteUser
     *
     *  In this test, we simply delete user added in tge first test. The check of this test consists of using
     *  searchObjects modelPort operation, expecting the return of empty list
     * */
    @Test
    public void openDJ_test005_deleteUser() throws FaultMessage, SAXException, IOException{
        String userName = "Anakin";

        Element filter = parseElement(
                "<equal xmlns='http://prism.evolveum.com/xml/ns/public/query-2' xmlns:c='http://midpoint.evolveum.com/xml/ns/public/common/common-2a' >" +
                        "<path>c:name</path>" +
                        "<value>" + userName + "</value>" +
                        "</equal>"
        );

        QueryType query = new QueryType();
        query.setFilter(filter);
        OperationOptionsType options = new OperationOptionsType();
        Holder<ObjectListType> objectListHolder = new Holder<ObjectListType>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();

        modelPort.deleteObject(getTypeUri(UserType.class), testUserOid);

        //check, if deleted user doesn't exist
        modelPort.searchObjects(getTypeUri(UserType.class), query, options, objectListHolder, resultHolder);
        ObjectListType objectList = objectListHolder.value;
        List<ObjectType> objects = objectList.getObject();

        if(objects.isEmpty()){
            LOGGER.info("OpenDJTest: #openDJ_test005_deleteUser: User with oid: " + testUserOid + " was deleted from repository.");
        }
        else
            throw new IllegalStateException("OpenDJTest: #openDJ_test005_deleteUser: User with oid: " + testUserOid + " was not deleted from repository.");
    }

    /**
     *  openDJ_test006_listUsers
     *
     *  In this test, we use modelPort operation listObjects to list midpoint users in repository.
     *  First, we add 5 users, then we list them and afterwards, we clean the repository.
     *
     * */
    @Test
    public void openDJ_test006_listUsers() throws FaultMessage{
        Document doc = getDocument();
        OperationOptionsType optionsType = new OperationOptionsType();
        Holder<String> oidHolder = new Holder<String>();
        Holder<ObjectListType> objectListHolder = new Holder<ObjectListType>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();
        PagingType paging = new PagingType();
        List<String> userOidList = new ArrayList<String>(6);

        //stage #1: add 5 users to midpoint repository
        for(int i = 0; i < 5; i++){
            UserType user = new UserType();
            user.setName(createPolyStringType("testUser"+i, doc));
            user.setFullName(createPolyStringType("testUserFullName"+i, doc));
            user.setCredentials(createPasswordCredentials("testUserPassword"+i));

            modelPort.addObject(user, oidHolder, resultHolder);
            userOidList.add(i, oidHolder.value);
        }

        //stage #2: list users
        modelPort.listObjects(getTypeUri(UserType.class), paging, optionsType, objectListHolder, resultHolder);

        ObjectListType objectList = objectListHolder.value;
        List<ObjectType> objects = objectList.getObject();

        if(objects.isEmpty() || objects.size() < 5){
            LOGGER.error("OpenDJTest: #openDJ_test006_listUsers: Error, users not added correctly, test ends here.");
            throw new IllegalStateException("Error: #openDJ_test006_listUsers: Expected to find 5 or more users, found just " + objects.size() + " users.");
        }
        if(objects.size() >= 5){
            for(Object o: objects){
                LOGGER.info("OpenDJTest: #openDJ_test006_listUsers: Found user with oid: " + ((UserType) o).getOid());
            }
        }

        //stage #3: delete users added in this test from repo
        for(int i = 0; i < 5; i++){
            //LOGGER.info("" + userOidList.);
            modelPort.deleteObject(getTypeUri(UserType.class), userOidList.get(i));
        }
        userOidList.removeAll(userOidList);
        LOGGER.info("OpenDJTest: #openDJ_test006_listUsers: UserList created correctly, test PASSED.");
    }

    /**
     *  openDJ_test007_importResource
     *
     *  In this test, we are trying to import ResourceObject to midpoint repository. This object is made out of 4
     *  different object - 2 UserTemplate-s, Task and Resource. ResourceObject is imported via modelPort and
     *  is unmarshalled from XML file using JAXB unmarshaller.
     *
     * */
    //TODO - este nejde
    @Test//(enabled = false)
    public void openDJ_test007_importResource() throws FaultMessage, JAXBException{
        Document doc = getDocument();
        File resourceFile = new File(REPO_DIR_NAME+OPENDJ_RESOURCE_SCHEMA);
        File resourceObjectFile = new File(REPO_DIR_NAME+OPENDJ_RESOURCE_OBJECT);
        JAXBContext jaxbContext = JAXBContext.newInstance(PACKAGE_API_TYPES_2);
        JAXBElement jaxbElement;
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();
        Holder<String> oidHolder = new Holder<String>();
        ResourceType resource;
        UserTemplateType userTemplate1;
        UserTemplateType userTemplate2;
        TaskType task;
        OperationOptionsType options = new OperationOptionsType();
        Holder<ObjectType> objectHolder = new Holder<ObjectType>();

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Objects resourceTypeObject =  (Objects)jaxbUnmarshaller.unmarshal(resourceFile);
        List<JAXBElement<? extends ObjectType>> objectList = resourceTypeObject.getObject();

        userTemplate1 = (UserTemplateType)objectList.get(0).getValue();
        userTemplate1.setName(createPolyStringType("Default User Template", doc));
        userTemplate2 = (UserTemplateType)objectList.get(1).getValue();
        userTemplate2.setName(createPolyStringType("Default User Template2", doc));
        task = (TaskType)objectList.get(2).getValue();
        task.setName(createPolyStringType("Synchronization: Embedded Test OpenDJ (no extensions schema)", doc));

        jaxbElement = (JAXBElement)jaxbUnmarshaller.unmarshal(resourceObjectFile);
        resource = (ResourceType)jaxbElement.getValue();
        resource.setName(createPolyStringType("Localhost OpenDJ (no extension schema)", doc));

        //Adding + checks
        modelPort.addObject(userTemplate1, oidHolder, resultHolder);

        modelPort.getObject(getTypeUri(UserTemplateType.class), oidHolder.value, options, objectHolder, resultHolder);
        AssertJUnit.assertNotNull(objectHolder.value);
        AssertJUnit.assertEquals(oidHolder.value, userTemplate1.getOid());

        modelPort.addObject(userTemplate2, oidHolder, resultHolder);

        modelPort.getObject(getTypeUri(UserTemplateType.class), oidHolder.value, options, objectHolder, resultHolder);
        AssertJUnit.assertNotNull(objectHolder.value);
        AssertJUnit.assertEquals(oidHolder.value, userTemplate2.getOid());

        modelPort.addObject(task, oidHolder, resultHolder);

        modelPort.getObject(getTypeUri(TaskType.class), oidHolder.value, options, objectHolder, resultHolder);
        AssertJUnit.assertNotNull(objectHolder.value);
        AssertJUnit.assertEquals(oidHolder.value, task.getOid());

        modelPort.addObject(resource, oidHolder, resultHolder);

        modelPort.getObject(getTypeUri(ResourceType.class), oidHolder.value, options, objectHolder, resultHolder);
        AssertJUnit.assertNotNull(objectHolder.value);
        AssertJUnit.assertEquals(oidHolder.value, resource.getOid());
    }

    /**
     *  openDJ_test008_addUserFromXML
     *
     *  This test uses addObject modelPort operation to add user extacted from XML file using
     *  JAXBunmarshaller.
     * */
    @Test
    public void openDJ_test008_addUserFromXML() throws FaultMessage, JAXBException, FileNotFoundException {
        File userFile = new File(REPO_DIR_NAME+OPENDJ_USER_ANAKIN);
        JAXBContext jaxbContext = JAXBContext.newInstance(UserType.class);
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();
        Holder<String> oidHolder = new Holder<String>();
        UserType user;
        OperationOptionsType options = new OperationOptionsType();
        Holder<ObjectType> objectHolder = new Holder<ObjectType>();

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement jaxbElement = (JAXBElement)jaxbUnmarshaller.unmarshal(userFile);
        user = (UserType)jaxbElement.getValue();

        modelPort.addObject(user, oidHolder, resultHolder);

        //Check, if user was added correctly
        modelPort.getObject(getTypeUri(UserType.class), oidHolder.value, options, objectHolder, resultHolder);
        AssertJUnit.assertNotNull(objectHolder.value);
        AssertJUnit.assertEquals(oidHolder.value, user.getOid());
    }

    /**
     *  openDJ_test009_addAccountToUserFromXML
     *
     *  In this test, we are trying to assign account to user added to midpoint repository in previous test.
     *  Account is assigned using ObjectModificationType, which is extracted from XML file using
     *  JAXB unmarshaller
     * */
    @Test
    public void openDJ_test009_addAccountToUserFromXML() throws FaultMessage, JAXBException, FileNotFoundException {
        ObjectModificationType objectChange;
        File userChangeFile = new File(REQUEST_DIR_NAME + REQUEST_USER_MODIFY_ADD_ACCOUNT_OPENDJ_FILENAME);
        JAXBContext jaxbContext = JAXBContext.newInstance(PACKAGE_COMMON_2A+":"+PACKAGE_API_TYPES_2);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement jaxbElement = (JAXBElement)jaxbUnmarshaller.unmarshal(userChangeFile);
        objectChange = (ObjectModificationType)jaxbElement.getValue();

        modelPort.modifyObject(getTypeUri(UserType.class),objectChange);
    }

    /**
     *  openDJ_test010_listAccountShadowOwner
     *
     *  using modelPort operation listAccountShadowOwner in this test, we are trying to retrieve
     *  the owner of midpoint Account added in previous test. The search result should be
     *  UserType exactly the same, as user added in test 008.
     *
     * */
    @Test
    public void openDJ_test010_listAccountShadowOwner() throws FaultMessage{
        OperationOptionsType options = new OperationOptionsType();
        Holder<ObjectType> objectHolder = new Holder<ObjectType>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();

        modelPort.getObject(getTypeUri(UserType.class), OPENDJ_USER_ANAKIN_OID, options, objectHolder, resultHolder);
        UserType userOld = (UserType)objectHolder.value;

        String accountOid = userOld.getAccountRef().get(0).getOid();
        LOGGER.info("TEST USER ANAKIN OID: " + accountOid);

        Holder<UserType> userHolder = new Holder<UserType>();

        modelPort.listAccountShadowOwner(accountOid, userHolder, resultHolder);

        UserType user = userHolder.value;

        //Check, if returned results are correct
        AssertJUnit.assertNotNull("Account has no owner", user);
        AssertJUnit.assertEquals(OPENDJ_USER_ANAKIN_OID, user.getOid());

        LOGGER.info("OpenDJTest: #openDJ_test010_listAccountShadowOwner: Account: " + accountOid + " has owner with oid: " + user.getOid());
    }

    /**
     *  openDJ_test011_modifyUserAndAccount
     *
     *  Using ObjectModificationType in this test, we are trying to apply some changes to previously added
     *  midpoint user. These changes should be applied also to accountObject linked to midpoint user, as well as on
     *  resource account on LDAP server OpenDJ
     *
     * */
    @Test
    public void openDJ_test011_modifyUserAndAccount() throws FaultMessage, FileNotFoundException, JAXBException{
        File changeFile = new File(REQUEST_DIR_NAME + REQUEST_USER_MODIFY_FULLNAME_LOCALITY_FILENAME);
        ObjectModificationType objectChange;
        JAXBContext jaxbContext = JAXBContext.newInstance(PACKAGE_API_TYPES_2);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        OperationOptionsType options = new OperationOptionsType();
        Holder<ObjectType> objectHolder = new Holder<ObjectType>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();

        JAXBElement jaxbElement = (JAXBElement)jaxbUnmarshaller.unmarshal(changeFile);
        objectChange = (ObjectModificationType)jaxbElement.getValue();

        modelPort.modifyObject(getTypeUri(UserType.class), objectChange);

        //Check, if changes were applied
        modelPort.getObject(getTypeUri(UserType.class), OPENDJ_USER_ANAKIN_OID, options, objectHolder, resultHolder);
        UserType user = (UserType)objectHolder.value;

        AssertJUnit.assertNotNull(user);
        AssertJUnit.assertNotSame("Anakin Skywalker", user.getFullName().getContent().get(1));
        AssertJUnit.assertNotSame("Jedi Enclave, Coruscant", user.getLocality().getContent().get(1));
    }

    /**
     *  openDJ_test012_changeUserPassword
     *
     *  In this test, we use ObjectModificationType object retrieved from XML file using JAXB
     *  unmarshaller to change midpoint user password. In the end of this test, we check, if password was
     *  correctly updated
     *
     * */
    @Test
    public void openDJ_test012_changeUserPassword() throws FaultMessage, JAXBException, FileNotFoundException{
         File changeFile = new File(REQUEST_DIR_NAME + REQUEST_USER_MODIFY_PASSWORD);
         ObjectModificationType objectChange;
         JAXBContext jaxbContext = JAXBContext.newInstance(PACKAGE_API_TYPES_2);
         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

         JAXBElement jaxbElement = (JAXBElement)jaxbUnmarshaller.unmarshal(changeFile);
         objectChange = (ObjectModificationType)jaxbElement.getValue();

         modelPort.modifyObject(getTypeUri(UserType.class), objectChange);
    }
 }
