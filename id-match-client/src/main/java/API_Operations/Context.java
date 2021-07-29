package API_Operations;

import java.io.IOException;
import java.net.HttpURLConnection;


public class Context {

    public ApiRequest apiRequest;

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
