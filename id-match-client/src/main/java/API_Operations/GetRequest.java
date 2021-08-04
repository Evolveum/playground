package API_Operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;


public class GetRequest implements ApiRequest {


    @Override
    public void doRequest(HttpURLConnection httpURLConnection, String jsonString){

        try {
            httpURLConnection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        try {
            int responseCode = httpURLConnection.getResponseCode();

            if (httpURLConnection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + httpURLConnection.getResponseCode());
            }
            else{
                System.out.println("Method: "+httpURLConnection.getRequestMethod());
                System.out.println("Response code: "+httpURLConnection.getResponseCode());
                System.out.println("Response message: "+httpURLConnection.getResponseMessage());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder builtResponse = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        while (true) {
            try {
                assert reader != null;
                if ((reader.readLine()) == null) break;
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                builtResponse.append(reader.readLine());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        System.out.println(builtResponse);

        httpURLConnection.disconnect();

    }
}
