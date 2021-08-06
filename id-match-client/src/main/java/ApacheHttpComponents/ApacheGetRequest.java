package ApacheHttpComponents;

import ApacheHttpComponents.auth.AuthenticationProvider;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;


public class ApacheGetRequest implements ApacheApiRequest {


    @Override
    public void doRequest(AuthenticationProvider authenticationProvider, String channel, String jsonString, String urlSuffix) throws IOException {

        HttpGet request = new HttpGet(channel + urlSuffix);

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(authenticationProvider.provider())
                .build();

        ResponseHandler<String> responseHandler = new ApacheResponseHandler();
        String httpResponse = httpClient.execute(request, responseHandler);
        System.out.println(httpResponse);

    }

}
