package API_Operations;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

public class PutRequest implements ApiRequest {


    @Override
    public void doRequest(HttpURLConnection httpURLConnection, String jsonString) {

        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);

        try {
            httpURLConnection.setRequestMethod("PUT");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        try {
            OutputStream os = httpURLConnection.getOutputStream();
            os.write(jsonString.getBytes());
            os.flush();


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


        httpURLConnection.disconnect();

    }

}
