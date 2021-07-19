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


        OutputStream os = null;
        try {
            os = httpURLConnection.getOutputStream();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            if (os != null) {
                os.write(jsonString.getBytes());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            if (os != null) {
                os.flush();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


        System.out.println(httpURLConnection.getRequestMethod());
        try {
            System.out.println(httpURLConnection.getResponseCode());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            System.out.println(httpURLConnection.getResponseMessage());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        StringBuilder builtResponse = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        if(reader != null) {
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
        try {
            reader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        }
        httpURLConnection.disconnect();

    }
}
