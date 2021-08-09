package com.evolveum.playground.idmatch;

import com.evolveum.playground.idmatch.data.*;
import com.evolveum.playground.idmatch.data.structure.JsonListStructure;
import com.evolveum.playground.idmatch.data.structure.UserDataStructure;
import com.evolveum.playground.idmatch.operations.*;
import com.evolveum.playground.idmatch.operations.auth.AuthenticationProvider;
import com.evolveum.playground.idmatch.constants.Channel;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Main {


    public static final String ADMIN_NAME = "admin";
    public static final String ADMIN_PASSWORD = "5254";
    public static final String BASE_URL = "http://localhost:8070";


    public static void main(String[] args) throws IOException {


        AuthenticationProvider authenticationProvider = new AuthenticationProvider(ADMIN_NAME, ADMIN_PASSWORD);

        UserDataFilling userDataFilling = new UserDataFilling();
        CsvReader csvReader = new CsvReader();
        JsonListGenerator jsonListGenerator = new JsonListGenerator();


        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                1 - PUT    - requirements: sor label & sor id,
                2 - POST   - requirements: sor label & sor id,
                3 - GET    - requirements: sor - note: returns the sor id of all records label,
                4 - GET    - requirements: sor label & sor id- note: returns specific records,
                5 - GET    - requirements: match id,
                6 - GET    - requirements: reference id,
                7 - GET    - resolved match request,
                8 - GET    - pending match request,
                9 - DELETE - requirements: sor label & sor id.""".indent(1));

        ApacheContext apacheContext;
        String SOR_LABEL;
        String SOR_ID;
        String URL_SUFFIX;
        String JSON_STRING;


        int selected = Integer.parseInt(scanner.nextLine());

        switch (selected) {
            case 1 -> {
                apacheContext = new ApacheContext(new ApachePutRequest());

                List<String[]> csvData = csvReader.getCsvDataFromInput("src/main/resources/data.csv");

                List<UserDataStructure> userDataStructureList = userDataFilling.setUserDataList(csvData);

                List<JsonListStructure> jsonList = jsonListGenerator.generateJsonString(userDataStructureList);

                String URL_PREFIX = BASE_URL + Channel.URL_PREFIX_MAIN_OPERATIONS.getUrl();

                for (JsonListStructure jsonListStructure : jsonList) {

                    SOR_LABEL = jsonListStructure.getSorLabel();
                    SOR_ID = jsonListStructure.getSorId();
                    JSON_STRING = jsonListStructure.getObjectToSend();
                    URL_SUFFIX = SOR_LABEL + "/" + SOR_ID; // sorLabel/sorId

                    apacheContext.executeRequest(authenticationProvider, URL_PREFIX, JSON_STRING, URL_SUFFIX);
                }
            }
            case 2 -> {
                apacheContext = new ApacheContext(new ApachePostRequest());

                List<String[]> csvData = csvReader.getCsvDataFromInput("src/main/resources/data.csv");

                List<UserDataStructure> userDataStructureList = userDataFilling.setUserDataList(csvData);

                List<JsonListStructure> jsonList = jsonListGenerator.generateJsonString(userDataStructureList);

                String URL_PREFIX = BASE_URL + Channel.URL_PREFIX_MAIN_OPERATIONS.getUrl();

                for (JsonListStructure jsonListStructure : jsonList) {
                    SOR_LABEL = jsonListStructure.getSorLabel();
                    SOR_ID = jsonListStructure.getSorId();
                    JSON_STRING = jsonListStructure.getObjectToSend();

                    URL_SUFFIX = SOR_LABEL + "/" + SOR_ID; // sorLabel/sorId

                    apacheContext.executeRequest(authenticationProvider, URL_PREFIX, JSON_STRING, URL_SUFFIX);
                }
            }
            case 3 -> {
                apacheContext = new ApacheContext(new ApacheGetRequest());
                SOR_LABEL = "hrms";
                SOR_ID = "";
                String URL_PREFIX = BASE_URL + Channel.URL_PREFIX_MAIN_OPERATIONS.getUrl();
                URL_SUFFIX = SOR_LABEL + "/" + SOR_ID; // sorLabel/sorId

                apacheContext.executeRequest(authenticationProvider, URL_PREFIX, "", URL_SUFFIX);
            }
            case 4 -> {
                apacheContext = new ApacheContext(new ApacheGetRequest());
                SOR_LABEL = "hrms";
                SOR_ID = "1";
                String URL_PREFIX = BASE_URL + Channel.URL_PREFIX_MAIN_OPERATIONS.getUrl();
                URL_SUFFIX = SOR_LABEL + "/" + SOR_ID; // sorLabel/sorId

                apacheContext.executeRequest(authenticationProvider, URL_PREFIX, "", URL_SUFFIX);
            }
            case 5 -> {
                apacheContext = new ApacheContext(new ApacheGetRequest());
                URL_SUFFIX = "78"; // match id
                String URL_PREFIX = BASE_URL + Channel.URL_PREFIX_GET_MATCH_REQUEST_MATCH_ID.getUrl();

                apacheContext.executeRequest(authenticationProvider, URL_PREFIX, "", URL_SUFFIX);
            }
            case 6 -> {
                apacheContext = new ApacheContext(new ApacheGetRequest());
                URL_SUFFIX = "750cc41b-c3eb-4b78-89a3-d017ac50bca0"; // referenceId
                String URL_PREFIX = BASE_URL + Channel.URL_PREFIX_GET_MATCH_REQUEST_REFERENCE_ID.getUrl();

                apacheContext.executeRequest(authenticationProvider, URL_PREFIX, "", URL_SUFFIX);
            }
            case 7 -> {
                apacheContext = new ApacheContext(new ApacheGetRequest());
                URL_SUFFIX = ""; // empty
                String URL_PREFIX = BASE_URL + Channel.URL_MATCH_REQUEST_RESOLVED.getUrl();

                apacheContext.executeRequest(authenticationProvider, URL_PREFIX, "", URL_SUFFIX);
            }
            case 8 -> {
                apacheContext = new ApacheContext(new ApacheGetRequest());
                URL_SUFFIX = ""; // empty
                String URL_PREFIX = BASE_URL + Channel.URL_MATCH_REQUEST_PENDING.getUrl();

                apacheContext.executeRequest(authenticationProvider, URL_PREFIX, "", URL_SUFFIX);
            }
            case 9 -> {
                apacheContext = new ApacheContext(new ApacheDeleteRequest());
                URL_SUFFIX = "hrms/1"; // sorLabel/sorId
                String URL_PREFIX = BASE_URL + Channel.URL_PREFIX_MAIN_OPERATIONS.getUrl();

                apacheContext.executeRequest(authenticationProvider, URL_PREFIX, "", URL_SUFFIX);
            }
        }

    }
}
