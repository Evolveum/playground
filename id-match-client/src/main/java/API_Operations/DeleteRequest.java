package API_Operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

public class DeleteRequest implements ApiRequest{

    @Override
    public void doRequest(HttpURLConnection httpURLConnection, String jsonString) {

        try {
            httpURLConnection.setRequestMethod("DELETE");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }


        try {
            int responseCode = httpURLConnection.getResponseCode();
            System.out.println(responseCode);

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            if (httpURLConnection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + httpURLConnection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        httpURLConnection.disconnect();

    }
}
