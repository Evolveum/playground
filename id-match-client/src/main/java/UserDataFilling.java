import com.opencsv.exceptions.CsvValidationException;
import org.apache.maven.internal.commons.io.input.BOMInputStream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UserDataFilling {

    List<UserDataStructure> dataList = new ArrayList<>();

    List<String[]> csvData = new ArrayList<>();

    public void readCsv(String csvFilePath) throws IOException, CsvValidationException {

        BOMInputStream bis = new BOMInputStream(new FileInputStream(csvFilePath));
        BufferedReader br = new BufferedReader(new InputStreamReader(bis, StandardCharsets.UTF_8));

        String line;

        while ((line = br.readLine()) != null) {
            String[] string = line.split(";");
            csvData.add(string);
        }

    }


    public void setUserDataList(String csvPath) {
        try {
            readCsv(csvPath);
        } catch (IOException | CsvValidationException e) {
            System.out.println("Csv read failed");
        }

        int rowsSize = csvData.size();
        int columnsSize = csvData.get(0).length;

        for (int rowPosition = 3; rowPosition < rowsSize; rowPosition++) {
            String sorLabel = null;
            String sorId = null;
            List<UserSpecParameter> singleUserData = new ArrayList<>();

            for (int columnPosition = 0; columnPosition < columnsSize; columnPosition++) {

                String objectName = csvData.get(0)[columnPosition];
                String objectGroup = csvData.get(1)[columnPosition];
                String objectType = csvData.get(2)[columnPosition];

                System.out.println(objectName);
                String object = csvData.get(rowPosition)[columnPosition];

                if (objectName.equals("sor")) {
                    sorLabel = object;
                } else if (objectName.equals("sorid")) {
                    sorId = object;
                } else {
                    singleUserData.add(new UserSpecParameter(objectGroup, objectName, objectType, object));
                }

            }
            dataList.add(new UserDataStructure(sorLabel, sorId, singleUserData));
        }

    }


    public List<String[]> generateJsonString(String csvPath) {
        setUserDataList(csvPath);

        List<String[]> jsonList = new ArrayList<>();

        for (UserDataStructure userDataStructure : dataList) {
            StringBuilder jsonString = new StringBuilder();

            String SOR_ID = userDataStructure.getSorId();
            String SOR_LABEL = userDataStructure.getSorLabel();

            ArrayList<String> usedGroup = new ArrayList<>();
            jsonString.append("{" + "\"" + "sorAttributes" + "\":" + "{");
            for (int j = 0; j < userDataStructure.getObject().size(); j++) {
                String firstGroup = userDataStructure.getObject().get(j).getGroupName();
                if (!usedGroup.contains(firstGroup)) {
                    usedGroup.add(firstGroup);
                    String firstGroupObjectType = userDataStructure.getObject().get(j).getObjectType();

                    String firstGroupObjectName = userDataStructure.getObject().get(j).getObjectName();
                    String firstGroupObject = userDataStructure.getObject().get(j).getObject();

                    jsonString.append("\"").append(firstGroup).append("\":[\n").append("      {\n");
                    jsonString.append("\"").append(firstGroupObjectName).append("\":\"").append(firstGroupObject).append("\",\n");

                    for (int c = 1 + j; c < userDataStructure.getObject().size(); c++) {
                        String secondGroup = userDataStructure.getObject().get(c).getGroupName();
                        String secondGroupObjectName = userDataStructure.getObject().get(c).getObjectName();
                        String secondGroupObject = userDataStructure.getObject().get(c).getObject();

                        if (firstGroup.equals(secondGroup)) {
                            jsonString.append("\"").append(secondGroupObjectName).append("\":\"").append(secondGroupObject).append("\",\n");
                        } else {
                            c++;
                        }
                    }
                    jsonString.append("\"type\":\"").append(firstGroupObjectType).append("\"\n");

                    jsonString.append("""
                               }
                             ],
                            """);
                }
            }

            jsonString.replace(jsonString.length() - 2, jsonString.length(), "}\n}");

            String[] strings = new String[3];

            strings[0] = SOR_LABEL;
            strings[1] = SOR_ID;
            strings[2] = String.valueOf(jsonString);
            jsonList.add(strings);
        }
        return jsonList;

    }

}
