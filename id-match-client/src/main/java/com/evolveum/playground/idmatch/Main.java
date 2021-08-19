package com.evolveum.playground.idmatch;

import com.evolveum.playground.idmatch.constants.MatchStatus;
import com.evolveum.playground.idmatch.data.CsvReader;
import com.evolveum.playground.idmatch.data.JsonListGenerator;
import com.evolveum.playground.idmatch.data.UserDataFilling;
import com.evolveum.playground.idmatch.data.structure.JsonListStructure;
import com.evolveum.playground.idmatch.data.structure.UserDataStructure;
import com.evolveum.playground.idmatch.operations.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static final String username = "admin";
    public static final String password = "5254";
    public static final String urlPrefix = "http://localhost:8070";


    public static void main(String[] args) throws IOException {

        UserDataFilling userDataFilling = new UserDataFilling();
        CsvReader csvReader = new CsvReader();
        JsonListGenerator jsonListGenerator = new JsonListGenerator();


        Client client = new Client(urlPrefix, username, password);


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

        String sorLabel;
        String sorId;
        String object;
        String matchRequestId;
        String referenceId;


        int selected = Integer.parseInt(scanner.nextLine());

        switch (selected) {
            case 1 -> {


                List<String[]> csvData = csvReader.getCsvDataFromInput("src/main/resources/data2.csv");

                List<UserDataStructure> userDataStructureList = userDataFilling.setUserDataList(csvData);

                List<JsonListStructure> jsonList = jsonListGenerator.generateJsonString(userDataStructureList);


                for (JsonListStructure jsonListStructure : jsonList) {

                    sorLabel = jsonListStructure.getSorLabel();
                    sorId = jsonListStructure.getSorId();
                    object = jsonListStructure.getObjectToSend();

                    client.peoplePut(sorLabel, sorId, object);

                }
            }
            case 2 -> {

                List<String[]> csvData = csvReader.getCsvDataFromInput("src/main/resources/data.csv");

                List<UserDataStructure> userDataStructureList = userDataFilling.setUserDataList(csvData);

                List<JsonListStructure> jsonList = jsonListGenerator.generateJsonString(userDataStructureList);


                for (JsonListStructure jsonListStructure : jsonList) {

                    sorLabel = jsonListStructure.getSorLabel();
                    sorId = jsonListStructure.getSorId();
                    object = jsonListStructure.getObjectToSend();

                    client.peoplePost(sorLabel, sorId, object);
                }
            }

            case 3 -> {
                sorLabel = "hrms";

                client.listPeople(sorLabel);
            }
            case 4 -> {
                sorLabel = "hrms";
                sorId = "1";

                client.peopleById(sorLabel, sorId);
            }
            case 5 -> {
                matchRequestId = "94";

                client.getMatchRequest(matchRequestId);
            }
            case 6 -> {
                referenceId = "92f8b68c-5ce8-4536-bd1c-e50f4ab0bb83"; // referenceId

                client.searchMatchRequestsByReferenceId(referenceId);
            }
            case 7 -> {
                client.listMatchRequest(MatchStatus.RESOLVED);
            }
            case 8 -> {
                client.listMatchRequest(MatchStatus.PENDING);
            }
            case 9 -> {
                sorLabel = "hrms";
                sorId = "7";

                client.deletePeople(sorLabel, sorId);
            }

        }


    }

}
