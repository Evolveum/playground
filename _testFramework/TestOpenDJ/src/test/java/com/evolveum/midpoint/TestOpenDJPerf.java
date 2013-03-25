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


import com.evolveum.midpoint.util.exception.ObjectAlreadyExistsException;
import com.evolveum.midpoint.xml.ns._public.common.api_types_2.ObjectListType;
import com.evolveum.midpoint.xml.ns._public.common.api_types_2.OperationOptionsType;
import com.evolveum.midpoint.xml.ns._public.common.common_2a.ObjectType;
import com.evolveum.midpoint.xml.ns._public.common.common_2a.OperationResultType;
import com.evolveum.midpoint.xml.ns._public.common.common_2a.UserType;
import com.evolveum.midpoint.xml.ns._public.common.fault_1_wsdl.FaultMessage;
import com.evolveum.prism.xml.ns._public.query_2.PagingType;
import com.evolveum.prism.xml.ns._public.query_2.QueryType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.ws.Holder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.AssertJUnit;

/**
 *      OpenDJ performance test Suite
 *
 * <p>
 *      This test suite is used to test midpoint performance abilities using
 *      webservice modelPort client. It has several interesting tests, which
 *      are working with randomly generated data package.
 *      Some tests work with many threads, so we also test
 *      midpoint ability to handle various requests in multiple threads.
 * </p>
 *
 * @author Erik Suta
 */

public class TestOpenDJPerf extends TestFrameworkUtil{

    private static List<String> randomUserOidList;
    private static Integer PERF_TESTS_NUMBER_OF_USERS = 1000;

    @BeforeClass
    public void initConfiguration() throws Exception{
        initSystem();
        LOGGER.info("OpenDJ performance test suite started.");
        modelPort = createModelPort();
        LOGGER.info("OpenDJtest: modelPort configured.");
        configurationType = getConfiguration(modelPort);
        LOGGER.info("OpenDJtest: Got system Configuration: " + configurationType);
    }

    @AfterClass
    public void stopResources() throws Exception{
        cleanRepository();
        LOGGER.info("OpenDJ test performance suite finished.");
    }

    /*====================================================================================*/
    /*                             Tests - Performance suite                              */
    /*====================================================================================*/

    /**
     *  openDJ_test013_addManyRandomUsers
     *
     *  First performance test in openDJ performance test suite. In this test, we add large number
     *  of randomly generated users to midpoint repository. The number of users is configurable.
     *  Afterwards we are doing check, if correct number of users was added and we test every single added
     *  user, if it's object was added correctly
     *
     * */
    @Test
    public void openDJ_test013_addManyRandomUsers() throws FaultMessage, ObjectAlreadyExistsException {
        randomUserOidList = new ArrayList<String>(PERF_TESTS_NUMBER_OF_USERS);
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();
        Holder<String> oidHolder = new Holder<String>();
        UserType newUser;
        OperationOptionsType options = new OperationOptionsType();
        Holder<ObjectType> objectHolder = new Holder<ObjectType>();

        Long startTime = System.nanoTime();
        for(int i = 0; i < PERF_TESTS_NUMBER_OF_USERS; i++){
            newUser = RandomUserGenerator.createRandomUser();
            modelPort.addObject(newUser, oidHolder, resultHolder);
            randomUserOidList.add(i, oidHolder.value);
        }
        Long estimatedTime = System.nanoTime() - startTime;

        LOGGER.info("OpenDJTest: #openDJ_test013_addManyRandomUsers statistics:");
        LOGGER.info("\t\tTime needed to add " + PERF_TESTS_NUMBER_OF_USERS + " users(ms): " + Double.parseDouble(estimatedTime.toString())/1000000 + ".");
        LOGGER.info("\t\tTime needed to add single user(ms): " + (Double.parseDouble((estimatedTime.toString()))/1000000)/PERF_TESTS_NUMBER_OF_USERS + ".");
        LOGGER.info("\t\tNumber of users added per second: " + PERF_TESTS_NUMBER_OF_USERS/(estimatedTime/1000000000) + ".");

        //check, if all users were added correctly
        if(randomUserOidList.size() < 1000)
            throw new IllegalStateException("OpenDJ performance test suite, openDJ_test013_addManyRandomUsers, only: " + randomUserOidList.size()+ "/" + PERF_TESTS_NUMBER_OF_USERS + " were added.");

        for(int i = 0; i < PERF_TESTS_NUMBER_OF_USERS; i++){
            modelPort.getObject(getTypeUri(UserType.class), randomUserOidList.get(i), options, objectHolder, resultHolder);
            AssertJUnit.assertNotNull(objectHolder.value);
            AssertJUnit.assertEquals(randomUserOidList.get(i), objectHolder.value.getOid());
        }
    }

    /**
     *  openDJ_test014_searchUserManyTimesInOneThread
     *
     *  In this test, we perform searchObjects modelPort operation in one thread many times, default count is 100,
     *  but it is configurable. The data package, on which search operation is performed, is created in previous
     *  test
     *
     * */
    @Test(threadPoolSize = 1, invocationCount = 100)
    public void openDJ_test014_searchUserManyTimesInOneThread() throws FaultMessage, ThreadDeath, SAXException, IOException {
        QueryType query = new QueryType();
        query.setFilter(MULTIPLE_THREAD_SEARCH_FILTER);
        OperationOptionsType options = new OperationOptionsType();
        Holder<ObjectListType> objectListHolder = new Holder<ObjectListType>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();

        Long startTime = System.nanoTime();
        modelPort.searchObjects(getTypeUri(UserType.class), query, options, objectListHolder, resultHolder);
        Long estimatedTime = System.nanoTime() - startTime;

        ObjectListType objectList = objectListHolder.value;
        List<ObjectType> objects = objectList.getObject();

        if(objects.isEmpty()){
            LOGGER.info("OpenDJtest: #openDJ_test014_searchUserByName: user with name: " + MULTIPLE_THREAD_USER_SEARCH_NAME + " not found in repository.");
        }else{
            LOGGER.info("OpenDJtest: #openDJ_test014_searchUserByName: Thread(" + Thread.currentThread().getId() + "): Found " + objects.size() + " Users in time(ms): " + Double.parseDouble(estimatedTime.toString())/1000000 + ".");
        }
    }

    /**
     *  openDJ_test015_searchUserManyTimesInManyThreads
     *
     *  This test is similar to previous test, but this time, we perform (default) 100 searches in (default)
     *  50 threads. The number of parallel threads causes search operations to go slowly, which is expected
     *  behaviour.
     *
     * */
    @Test(threadPoolSize = 50, invocationCount = 100)
    public void openDJ_test015_searchUserManyTimesInManyThreads() throws FaultMessage, ThreadDeath, SAXException, IOException {
        QueryType query = new QueryType();
        query.setFilter(MULTIPLE_THREAD_SEARCH_FILTER);
        OperationOptionsType options = new OperationOptionsType();
        Holder<ObjectListType> objectListHolder = new Holder<ObjectListType>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();

        Long startTime = System.nanoTime();
        modelPort.searchObjects(getTypeUri(UserType.class), query, options, objectListHolder, resultHolder);
        Long estimatedTime = System.nanoTime() - startTime;

        ObjectListType objectList = objectListHolder.value;
        List<ObjectType> objects = objectList.getObject();

        if(objects.isEmpty()){
            LOGGER.info("OpenDJtest: #openDJ_test015_searchUserByName: user with name: " + MULTIPLE_THREAD_USER_SEARCH_NAME + " not found in repository.");
        }else{
            LOGGER.info("OpenDJtest: #openDJ_test015_searchUserByName: Thread(" + Thread.currentThread().getId() + "): Found " + objects.size() + " Users in time(ms): " + Double.parseDouble(estimatedTime.toString())/1000000 + ".");
        }
    }

    /**
     *  openDJ_test016_listUsersInManyThreads
     *
     *  In this thread, we perform listObjects operation in (default) 50 invocations in (default) 50
     *  parallel threads
     *
     * */
    @Test(threadPoolSize = 50, invocationCount = 50)
    public void openDJ_test016_listUsersInManyThreads() throws FaultMessage, ThreadDeath {
        OperationOptionsType optionsType = new OperationOptionsType();
        Holder<ObjectListType> objectListHolder = new Holder<ObjectListType>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();
        PagingType paging = new PagingType();

        Long startTime = System.nanoTime();
        modelPort.listObjects(getTypeUri(UserType.class), paging, optionsType, objectListHolder, resultHolder);
        Long estimatedTime = System.nanoTime() - startTime;

        ObjectListType objectList = objectListHolder.value;
        List<ObjectType> objects = objectList.getObject();

        if(objects.isEmpty() || objects.size() < PERF_TESTS_NUMBER_OF_USERS ){
            LOGGER.error("OpenDJTest: #openDJ_test016_listUsersInManyThreads: Error, users not added correctly, test ends here.");
            throw new IllegalStateException("Error: #openDJ_test016_listUsersInManyThreads: Expected to find " + PERF_TESTS_NUMBER_OF_USERS + " or more users, found just " + objects.size() + " users.");
        }
        if(objects.size() >= PERF_TESTS_NUMBER_OF_USERS){
            LOGGER.info("OpenDJTest: #openDJ_test016_listUsersInManyThreads, Thread(" + Thread.currentThread().getId() + "): found: " + objects.size() + " users in repository in time (ms):" + Double.parseDouble(estimatedTime.toString())/1000000);
        }
    }

    /**
     *  openDJ_test017_RandomTaskPerformanceTest
     *
     *  This is a very special test. We launch (default) 10 threads and in every one of them, we perform one
     *  of the three possible operations (the choice of operation is based on randomly generated integer number).
     *  1. Search users in repository
     *  2. List users in repository
     *  3. add many users to repository and delete them afterwards
     *
     *  All these operations are performed in parallel threads and performance statistics are written to logfile.
     *
     * */
    @Test(threadPoolSize = 10, invocationCount = 10)
    public void openDJ_test017_RandomTaskPerformanceTest() throws FaultMessage, ThreadDeath, SAXException, IOException {
        OperationOptionsType optionsType = new OperationOptionsType();
        Holder<ObjectListType> objectListHolder = new Holder<ObjectListType>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();
        Holder<String> oidHolder = new Holder<String>();
        PagingType paging = new PagingType();
        QueryType query = new QueryType();
        query.setFilter(MULTIPLE_THREAD_SEARCH_FILTER);
        Integer numberOfUsers = 500;
        UserType newUser;
        int switcher = Math.abs(RandomUserGenerator.generateRandom(3));

        if((switcher%3) == 0){

            Long startTime = System.nanoTime();
            modelPort.listObjects(getTypeUri(UserType.class), paging, optionsType, objectListHolder, resultHolder);
            Long estimatedTime = System.nanoTime() - startTime;

            ObjectListType objectList = objectListHolder.value;
            List<ObjectType> objects = objectList.getObject();

            if(objects.isEmpty() || objects.size() < PERF_TESTS_NUMBER_OF_USERS){
                LOGGER.error("OpenDJTest: #openDJ_test017_RandomTaskPerformanceTest, Thread(" + Thread.currentThread().getId() + "): wrong number of users in repo. Test Failed!");
                throw new IllegalStateException("Error: #openDJ_test017_RandomTaskPerformanceTest, Thread(" + Thread.currentThread().getId() + "): Expected to find " + PERF_TESTS_NUMBER_OF_USERS + " or more users, found just " + objects.size() + " users.");
            }else{
                LOGGER.info("OpenDJTest: #openDJ_test017_RandomTaskPerformanceTest, Thread(" + Thread.currentThread().getId() + "), var. 1: found: " + objects.size() + " users in repository in time (ms):" + Double.parseDouble(estimatedTime.toString())/1000000);
            }

        }else if((switcher%3) == 1){
            Long startTime = System.nanoTime();
            modelPort.searchObjects(getTypeUri(UserType.class), query, optionsType, objectListHolder, resultHolder);
            Long estimatedTime = System.nanoTime() - startTime;

            ObjectListType objectList = objectListHolder.value;
            List<ObjectType> objects = objectList.getObject();

            if(objects.isEmpty()){
                LOGGER.info("OpenDJtest: #openDJ_test017_RandomTaskPerformanceTest: user with name: " + MULTIPLE_THREAD_USER_SEARCH_NAME + " not found in repository.");
            }else{
                LOGGER.info("OpenDJtest: #openDJ_test017_RandomTaskPerformanceTest: Thread(" + Thread.currentThread().getId() + "), var. 2: Found " + objects.size() + " Users in time(ms): " + Double.parseDouble(estimatedTime.toString())/1000000 + ".");
            }
        }else if((switcher%3) == 2){
            List<String> userOidList = new ArrayList<String>(numberOfUsers);

            Long startTimeAdd = System.nanoTime();
            for(int i = 0; i < numberOfUsers; i++){
                newUser = RandomUserGenerator.createRandomUser();
                modelPort.addObject(newUser, oidHolder, resultHolder);
                userOidList.add(i, oidHolder.value);
            }
            Long estimatedTimeAdd = System.nanoTime() - startTimeAdd;

            Long startTimeDelete = System.nanoTime();
            for (int i = 0; i < numberOfUsers; i++){
                modelPort.deleteObject(getTypeUri(UserType.class), userOidList.get(i));
            }
            Long estimatedTimeDelete = System.nanoTime() - startTimeDelete;
            userOidList.removeAll(userOidList);

            LOGGER.info("OpenDJTest: #openDJ_test017_RandomTaskPerformanceTest, Thread("+ Thread.currentThread().getId() +"), var. 3 statistics:");
            LOGGER.info("\t\tTime needed to add " + numberOfUsers + " users(ms): " + Double.parseDouble(estimatedTimeAdd.toString())/1000000 + ".");
            LOGGER.info("\t\tTime needed to add single user(ms): " + (Double.parseDouble((estimatedTimeAdd.toString()))/1000000)/numberOfUsers + ".");
            LOGGER.info("\t\tNumber of users added per second: " + numberOfUsers/(estimatedTimeAdd/1000000000) + ".");
            LOGGER.info("\t\tTime needed to delete " + numberOfUsers + " users(ms): " + Double.parseDouble(estimatedTimeDelete.toString())/1000000 + ".");
            LOGGER.info("\t\tTime needed to delete single user(ms): " + (Double.parseDouble((estimatedTimeDelete.toString()))/1000000)/numberOfUsers + ".");
            LOGGER.info("\t\tNumber of users deleted per second: " + numberOfUsers/(estimatedTimeDelete/1000000000) + ".");
        }
    }

    /**
     *  openDJ_test018_addSomeUsersInManyThreads
     *
     *  Aim of this test is midpoint handling with multiple thread requests. In this test, we fire requests to add
     *  users from many threads. Afterwards. we delete all users. The fact, that users are added in parallel thread
     *  causes very slow performance of requests, deleting one users using deleteObject modelPort operation
     *  can last even 1,5 - 2 seconds.
     *
     * */
    @Test(threadPoolSize = 20, invocationCount = 20)
    public void openDJ_test018_addSomeUsersInManyThreads() throws FaultMessage, ObjectAlreadyExistsException, ThreadDeath{
        List<String> userOidList = new ArrayList<String>();
        Holder<OperationResultType> resultHolder = new Holder<OperationResultType>();
        Holder<String> oidHolder = new Holder<String>();
        Integer numberOfUsers = 50;
        UserType user;

        Long startTimeAdd = System.nanoTime();
        for(int i = 0; i < numberOfUsers; i++){
            user = RandomUserGenerator.createRandomUser();
            modelPort.addObject(user, oidHolder, resultHolder);
            userOidList.add(i, oidHolder.value);
        }
        Long estimatedTimeAdd = System.nanoTime() - startTimeAdd;

        Long startTimeDelete = System.nanoTime();
        for (int i = 0; i < numberOfUsers; i++){
            modelPort.deleteObject(getTypeUri(UserType.class), userOidList.get(i));
        }
        Long estimatedTimeDelete = System.nanoTime() - startTimeDelete;
        userOidList.removeAll(userOidList);

        LOGGER.info("OpenDJTest: #openDJ_test018_addSomeUsersInManyThreads, Thread("+ Thread.currentThread().getId() +"), var. 3 statistics:");
        LOGGER.info("\t\tTime needed to add " + numberOfUsers + " users(ms): " + Double.parseDouble(estimatedTimeAdd.toString())/1000000 + ".");
        LOGGER.info("\t\tTime needed to add single user(ms): " + (Double.parseDouble((estimatedTimeAdd.toString()))/1000000)/numberOfUsers + ".");
        LOGGER.info("\t\tNumber of users added per second: " + numberOfUsers/(estimatedTimeAdd/1000000000) + ".");
        LOGGER.info("\t\tTime needed to delete " + numberOfUsers + " users(ms): " + Double.parseDouble(estimatedTimeDelete.toString())/1000000 + ".");
        LOGGER.info("\t\tTime needed to delete single user(ms): " + (Double.parseDouble((estimatedTimeDelete.toString()))/1000000)/numberOfUsers + ".");
        LOGGER.info("\t\tNumber of users deleted per second: " + numberOfUsers/(estimatedTimeDelete/1000000000) + ".");
    }

    /**
     *  openDJ_test019_deleteManyUsers
     *
     *  In this test, we simply delete data package, on what all performance tests were running. We
     *  also monitor the speed of deleting objects from midpoint repository via webservice interface.
     *
     * */
    @Test
    public void openDJ_test019_deleteManyUsers() throws FaultMessage {

        Long startTimeDelete = System.nanoTime();
        for (int i = 0; i < PERF_TESTS_NUMBER_OF_USERS; i++){
            modelPort.deleteObject(getTypeUri(UserType.class), randomUserOidList.get(i));
        }
        Long estimatedTimeDelete = System.nanoTime() - startTimeDelete;
        randomUserOidList.removeAll(randomUserOidList);

        LOGGER.info("OpenDJTest: #openDJ_test019_deleteManyUsers statistics:");
        LOGGER.info("\t\tTime needed to delete " + PERF_TESTS_NUMBER_OF_USERS + " users(ms): " + Double.parseDouble(estimatedTimeDelete.toString())/1000000 + ".");
        LOGGER.info("\t\tTime needed to delete single user(ms): " + (Double.parseDouble((estimatedTimeDelete.toString()))/1000000)/PERF_TESTS_NUMBER_OF_USERS + ".");
        LOGGER.info("\t\tNumber of users deleted per second: " + PERF_TESTS_NUMBER_OF_USERS/(estimatedTimeDelete/1000000000) + ".");
    }

}
