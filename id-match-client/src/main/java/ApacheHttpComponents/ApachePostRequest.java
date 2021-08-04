package ApacheHttpComponents;

import ApacheHttpComponents.auth.AuthenticationProvider;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ApachePostRequest implements ApacheApiRequest{



    @Override
    public void doRequest(AuthenticationProvider authenticationProvider, String channel, String jsonString, String urlSuffix) throws IOException {

        HttpPost request = new HttpPost(channel + urlSuffix);
        request.addHeader("content-type", "application/json");
        request.setEntity(new StringEntity(jsonString.toString()));

        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(authenticationProvider.provider())
                .build();
             CloseableHttpResponse response = httpClient.execute(request)) {


            System.out.println("Response code: " + response.getStatusLine().getStatusCode());

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }

        }

    }

}
