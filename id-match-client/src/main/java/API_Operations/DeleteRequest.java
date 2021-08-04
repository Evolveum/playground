package API_Operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

public class DeleteRequest implements ApiRequest{

    @Override
    public void doRequest(HttpURLConnection httpURLConnection, String jsonString) throws IOException {

        try {
            httpURLConnection.setRequestMethod("DELETE");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }


        System.out.println("Method: "+httpURLConnection.getRequestMethod());
        System.out.println("Response code: "+httpURLConnection.getResponseCode());
        System.out.println("Response message: "+httpURLConnection.getResponseMessage());


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
