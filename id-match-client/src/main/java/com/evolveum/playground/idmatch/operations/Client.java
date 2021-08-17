package com.evolveum.playground.idmatch.operations;

import com.evolveum.playground.idmatch.constants.Channel;
import com.evolveum.playground.idmatch.constants.MatchStatus;
import com.evolveum.playground.idmatch.data.ListResponse;
import com.evolveum.playground.idmatch.operations.auth.AuthenticationProvider;

import java.io.IOException;

public class Client {


    private final ApacheApiRequest apachePutRequest;
    private final ApacheApiRequest apachePostRequest;
    private final ApacheApiRequest apacheGetRequest;
    private final ApacheApiRequest apacheDeleteRequest;

    String urlPrefix;
    String username;
    String password;

    AuthenticationProvider authenticationProvider;

    ListResponse listResponse;

    String NO_RESPONSE_MESSAGES = "NO RESPONSE MESSAGES";

    public Client(String urlPrefix, String username, String password) {
        this.urlPrefix = urlPrefix;
        this.username = username;
        this.password = password;

        apachePutRequest = new ApachePutRequest();
        apachePostRequest = new ApachePostRequest();
        apacheGetRequest = new ApacheGetRequest();
        apacheDeleteRequest = new ApacheDeleteRequest();
        this.authenticationProvider = new AuthenticationProvider(username, password);

    }


    public void peoplePut(String sorLabel, String sorId, String object) {

        StringBuilder urlSuffix = new StringBuilder(sorLabel + "/" + sorId);
        StringBuilder url = new StringBuilder(urlPrefix + Channel.URL_PREFIX_MAIN_OPERATIONS.getUrl());


        try {
            apachePutRequest.doRequest(authenticationProvider, url.toString(), object, urlSuffix.toString());
            printResponses(apachePutRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void listPeople(String sorLabel) {

        StringBuilder url = new StringBuilder(urlPrefix + Channel.URL_PREFIX_MAIN_OPERATIONS.getUrl());
        try {
            apacheGetRequest.doRequest(authenticationProvider, url.toString(), "", sorLabel);
            printResponses(apacheGetRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void peopleById(String sorLabel, String sorId) {

        StringBuilder url = new StringBuilder(urlPrefix + Channel.URL_PREFIX_MAIN_OPERATIONS.getUrl());
        StringBuilder urlSuffix = new StringBuilder(sorLabel + "/" + sorId);

        try {
            apacheGetRequest.doRequest(authenticationProvider, url.toString(), "", urlSuffix.toString());
            printResponses(apacheGetRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void listMatchRequest(MatchStatus matchStatus) {

        StringBuilder urlSuffix = new StringBuilder(matchStatus.getUrl());

        try {
            apacheGetRequest.doRequest(authenticationProvider, urlPrefix, "", urlSuffix.toString());
            printResponses(apacheGetRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void getMatchRequest(String id) {

        StringBuilder url = new StringBuilder(urlPrefix + Channel.URL_PREFIX_GET_MATCH_REQUEST_MATCH_ID.getUrl());

        try {
            apacheGetRequest.doRequest(authenticationProvider, url.toString(), "", id);
            printResponses(apacheGetRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void searchMatchRequestsByReferenceId(String refId) {
        StringBuilder url = new StringBuilder(urlPrefix + Channel.URL_PREFIX_GET_MATCH_REQUEST_REFERENCE_ID.getUrl());

        try {
            apacheGetRequest.doRequest(authenticationProvider, url.toString(), "", refId);
            printResponses(apacheGetRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void peoplePost(String sorLabel, String sorId, String object) {

        StringBuilder urlSuffix = new StringBuilder(sorLabel + "/" + sorId);
        StringBuilder url = new StringBuilder(urlPrefix + Channel.URL_PREFIX_MAIN_OPERATIONS.getUrl());
        try {
            apachePostRequest.doRequest(authenticationProvider, url.toString(), object, urlSuffix.toString());
            printResponses(apachePostRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void deletePeople(String sorLabel, String sorId) {

        StringBuilder urlSuffix = new StringBuilder(sorLabel + "/" + sorId);
        StringBuilder url = new StringBuilder(urlPrefix + Channel.URL_PREFIX_MAIN_OPERATIONS.getUrl());
        try {
            apacheDeleteRequest.doRequest(authenticationProvider, url.toString(), "", urlSuffix.toString());
            printResponses(apacheDeleteRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printResponses(ApacheApiRequest apacheApiRequest) {
        if (!apacheApiRequest.listResponse().isEmpty()) {
            listResponse = apacheApiRequest.listResponse().get(0);
                System.out.printf("%s\n %s \n %s \n %n", "Response code: " + listResponse.getResponseCode(), "Message: " + listResponse.getMessage(), "Entity: " + listResponse.getEntity());
        } else System.out.println(NO_RESPONSE_MESSAGES);
    }


}
