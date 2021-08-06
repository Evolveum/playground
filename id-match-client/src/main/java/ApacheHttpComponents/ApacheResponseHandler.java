package ApacheHttpComponents;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ApacheResponseHandler implements ResponseHandler<String> {


    public String handleResponse(HttpResponse httpResponse) throws IOException {
        int status = httpResponse.getStatusLine().getStatusCode();
        if (status >= HttpStatus.SC_CONTINUE && status < HttpStatus.SC_EXPECTATION_FAILED) {
            final HttpEntity entity = httpResponse.getEntity();
            try {
                System.out.println("Response status:" + status);
                return entity != null ? EntityUtils.toString(entity) : null;
            } catch (final ParseException ex) {
                throw new ClientProtocolException(ex);
            }
        } else {
            throw new ClientProtocolException("Unexpected response status: " + status);
        }

    }
}
