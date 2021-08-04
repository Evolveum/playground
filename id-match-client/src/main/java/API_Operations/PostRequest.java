package API_Operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

public class PostRequest implements ApiRequest {


    @Override
    public void doRequest(HttpURLConnection httpURLConnection, String jsonString) {

        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);

        try {
            httpURLConnection.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }


        try {
            OutputStream os = httpURLConnection.getOutputStream();
            os.write(jsonString.getBytes());
            os.flush();

            System.out.println("Method: " + httpURLConnection.getRequestMethod());
            System.out.println("Response code: " + httpURLConnection.getResponseCode());
            System.out.println("Response message: " + httpURLConnection.getResponseMessage());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


        StringBuilder builtResponse = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        } catch (IOException ioException) {
            System.out.println("No match found.");
        }
        if (reader != null) {
            while (true) {
                try {
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

            try {
                reader.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        httpURLConnection.disconnect();

    }
}
