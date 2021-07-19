package API_Operations;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

public interface ApiRequest {
     void doRequest(HttpURLConnection httpURLConnection, String jsonString) throws IOException;
}
