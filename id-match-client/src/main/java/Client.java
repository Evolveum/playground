import API_Operations.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

import java.util.Scanner;


public class Client {


    public static final String URL_PREFIX_PUT_POST_GET = "http://localhost:8070/match/api/2/v1/people/";
    public static final String URL_MATCH_REQUEST_PENDING = "http://localhost:8070/match/api/2/v1/matchRequests?status=pending";
    public static final String URL_MATCH_REQUEST_RESOLVED = "http://localhost:8070/match/api/2/v1/matchRequests?status=resolved";
    public static final String URL_PREFIX_GET_MATCH_REQUEST_MATCH_ID = "http://localhost:8070/match/api/2/v1/matchRequests/";
    public static final String URL_PREFIX_GET_MATCH_REQUEST_REFERENCE_ID = "http://localhost:8070/match/api/2/v1/matchRequests?referenceId=";

    public static final String ADMIN_NAME = "admin";
    public static final String ADMIN_PASSWORD = "5254";

    public static void main(String[] args) throws IOException, CsvValidationException {

        HttpConnect httpConnect = new HttpConnect();
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

        Context context;
        HttpURLConnection httpURLConnection;
        String URL_SUFFIX;

        int selected = Integer.parseInt(scanner.nextLine());

        switch (selected) {
            case 1 -> {
                context = new Context(new PutRequest());

                List<String[]> csvData = csvReader.getCsvDataFromInput("src/main/resources/data.csv");

                List<UserDataStructure> userDataStructureList = userDataFilling.setUserDataList(csvData);

                List<JsonListStructure> jsonList = jsonListGenerator.generateJsonString(userDataStructureList);

                for (JsonListStructure jsonListStructure : jsonList) {
                    URL_SUFFIX = jsonListStructure.sorLabel + "/" + jsonListStructure.sorId; // sorLabel/sorId
                    String JSON_STRING = jsonListStructure.objectToSend;
                    System.out.println(JSON_STRING);
                    httpURLConnection = httpConnect.connect(URL_PREFIX_PUT_POST_GET, ADMIN_NAME, ADMIN_PASSWORD, URL_SUFFIX);
                    context.executeRequest(httpURLConnection, JSON_STRING);
                }
            }
            case 2 -> {
                context = new Context(new PostRequest());

                List<String[]> csvData = csvReader.getCsvDataFromInput("src/main/resources/data.csv");

                List<UserDataStructure> userDataStructureList = userDataFilling.setUserDataList(csvData);

                List<JsonListStructure> jsonList = jsonListGenerator.generateJsonString(userDataStructureList);

                for (JsonListStructure jsonListStructure : jsonList) {
                    URL_SUFFIX = jsonListStructure.sorLabel + "/" + jsonListStructure.sorId; // sorLabel/sorId
                    String JSON_STRING = jsonListStructure.objectToSend;
                    httpURLConnection = httpConnect.connect(URL_PREFIX_PUT_POST_GET, ADMIN_NAME, ADMIN_PASSWORD, URL_SUFFIX);
                    context.executeRequest(httpURLConnection, JSON_STRING);
                }
            }
            case 3 -> {
                context = new Context(new GetRequest());
                URL_SUFFIX = "hrms"; // sorLabel
                HttpURLConnection httpURLConnection3 = httpConnect.connect(URL_PREFIX_PUT_POST_GET, ADMIN_NAME, ADMIN_PASSWORD, URL_SUFFIX);
                context.executeRequest(httpURLConnection3, "");
            }
            case 4 -> {
                context = new Context(new GetRequest());
                URL_SUFFIX = "hrms/1"; // sorLabel/sorId
                httpURLConnection = httpConnect.connect(URL_PREFIX_PUT_POST_GET, ADMIN_NAME, ADMIN_PASSWORD, URL_SUFFIX);
                context.executeRequest(httpURLConnection, "");
            }
            case 5 -> {
                context = new Context(new GetRequest());
                URL_SUFFIX = "25"; // match id
                httpURLConnection = httpConnect.connect(URL_PREFIX_GET_MATCH_REQUEST_MATCH_ID, ADMIN_NAME, ADMIN_PASSWORD, URL_SUFFIX);
                context.executeRequest(httpURLConnection, "");
            }
            case 6 -> {
                context = new Context(new GetRequest());
                URL_SUFFIX = "74388b01-e1e7-4878-bf8e-24178c16facf"; // referenceId
                httpURLConnection = httpConnect.connect(URL_PREFIX_GET_MATCH_REQUEST_REFERENCE_ID, ADMIN_NAME, ADMIN_PASSWORD, URL_SUFFIX);
                context.executeRequest(httpURLConnection, "");
            }
            case 7 -> {
                context = new Context(new GetRequest());
                URL_SUFFIX = ""; // empty
                httpURLConnection = httpConnect.connect(URL_MATCH_REQUEST_RESOLVED, ADMIN_NAME, ADMIN_PASSWORD, URL_SUFFIX);
                context.executeRequest(httpURLConnection, "");
            }
            case 8 -> {
                context = new Context(new GetRequest());
                URL_SUFFIX = ""; // empty
                httpURLConnection = httpConnect.connect(URL_MATCH_REQUEST_PENDING, ADMIN_NAME, ADMIN_PASSWORD, URL_SUFFIX);
                context.executeRequest(httpURLConnection, "");
            }
            case 9 -> {
                context = new Context(new DeleteRequest());
                URL_SUFFIX = "hrms/1"; // sorLabel/sorId
                httpURLConnection = httpConnect.connect(URL_PREFIX_PUT_POST_GET, ADMIN_NAME, ADMIN_PASSWORD, URL_SUFFIX);
                context.executeRequest(httpURLConnection, "");
            }
        }

    }
}
