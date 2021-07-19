package API_Operations;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

public class Context {

    private ApiRequest apiRequest;

    public Context(ApiRequest apiRequest) {
        this.apiRequest = apiRequest;
    }

    public void executeRequest(HttpURLConnection httpURLConnection, String jsonString){
        try {
            apiRequest.doRequest(httpURLConnection, jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
