import java.util.ArrayList;
import java.util.List;

public class UserDataFilling {


    public List<UserDataStructure> setUserDataList(List<String[]> csvData) {

        List<UserDataStructure> dataList = new ArrayList<>();

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

                String object = csvData.get(rowPosition)[columnPosition];

                if (objectName.equalsIgnoreCase("sor")) {
                    sorLabel = object;
                } else if (objectName.equalsIgnoreCase("sorid")) {
                    sorId = object;
                } else {
                    singleUserData.add(new UserSpecParameter(objectGroup, objectName, objectType, object));
                }

            }
            dataList.add(new UserDataStructure(sorLabel, sorId, singleUserData));
        }
        return dataList;
    }


}
