import org.apache.maven.internal.commons.io.input.BOMInputStream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {


    public List<String[]> getCsvDataFromInput(String csvFilePath) throws IOException {
        List<String[]> csvData = new ArrayList<>();

        BOMInputStream bis = new BOMInputStream(new FileInputStream(csvFilePath));
        BufferedReader br = new BufferedReader(new InputStreamReader(bis, StandardCharsets.UTF_8));

        String line;

        while ((line = br.readLine()) != null) {
            String[] string = line.split(";");
            csvData.add(string);
        }
        return csvData;
    }

}
