package com.evolveum.playground.idmatch.data;

import com.evolveum.playground.idmatch.data.structure.JsonListStructure;
import com.evolveum.playground.idmatch.data.structure.UserDataStructure;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class JsonListGenerator {


    public List<JsonListStructure> generateJsonString(List<UserDataStructure> dataList) throws IOException {

        List<JsonListStructure> jsonList = new ArrayList<>();

        for (UserDataStructure userDataStructure : dataList) {

            ArrayList<String> usedGroup = new ArrayList<>();

            String SOR_ID = userDataStructure.getSorId();
            String SOR_LABEL = userDataStructure.getSorLabel();

            JsonFactory factory = new JsonFactory();
            StringWriter jsonString = new StringWriter();
            JsonGenerator generator = factory.createGenerator(jsonString);

            generator.useDefaultPrettyPrinter();
            generator.writeStartObject();
            generator.writeFieldName("sorAttributes");
            generator.writeStartObject();

            for (int firstGroupIndex = 0; firstGroupIndex < userDataStructure.getObject().size(); firstGroupIndex++) {
                String firstGroup = userDataStructure.getObject().get(firstGroupIndex).getGroupName();
                if (!usedGroup.contains(firstGroup)) {
                    usedGroup.add(firstGroup);
                    String firstGroupObjectType = userDataStructure.getObject().get(firstGroupIndex).getObjectType();

                    String firstGroupObjectName = userDataStructure.getObject().get(firstGroupIndex).getObjectName();
                    String firstGroupObject = userDataStructure.getObject().get(firstGroupIndex).getObject();

                    generator.writeFieldName(firstGroup);
                    generator.writeStartArray();
                    generator.writeStartObject();
                    generator.writeFieldName(firstGroupObjectName);
                    generator.writeString(firstGroupObject);

                    for (int secondGroupIndex = firstGroupIndex + 1; secondGroupIndex < userDataStructure.getObject().size(); secondGroupIndex++) {
                        String secondGroup = userDataStructure.getObject().get(secondGroupIndex).getGroupName();
                        String secondGroupObjectName = userDataStructure.getObject().get(secondGroupIndex).getObjectName();
                        String secondGroupObject = userDataStructure.getObject().get(secondGroupIndex).getObject();

                        if (firstGroup.equals(secondGroup)) {
                            generator.writeFieldName(secondGroupObjectName);
                            generator.writeString(secondGroupObject);
                        } else {
                            secondGroupIndex++;
                        }
                    }

                    generator.writeFieldName("type");
                    generator.writeString(firstGroupObjectType);
                    generator.writeEndObject();
                    generator.writeEndArray();

                }
            }

            generator.writeEndObject();
            generator.writeEndObject();
            generator.close();

            jsonList.add(new JsonListStructure(SOR_LABEL, SOR_ID, String.valueOf(jsonString)));

        }
        return jsonList;
    }

}
