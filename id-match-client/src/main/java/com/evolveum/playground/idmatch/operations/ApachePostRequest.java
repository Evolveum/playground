package com.evolveum.playground.idmatch.operations;

import com.evolveum.playground.idmatch.operations.auth.AuthenticationProvider;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class ApachePostRequest implements ApacheApiRequest {


    @Override
    public void doRequest(AuthenticationProvider authenticationProvider, String channel, String jsonString, String urlSuffix) throws IOException {

        HttpPost request = new HttpPost(channel + urlSuffix);
        request.addHeader("content-type", "application/json");
        request.setEntity(new StringEntity(jsonString));

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(authenticationProvider.provider())
                .build();

        ResponseHandler<String> responseHandler = new ApacheResponseHandler();
        String httpResponse = httpClient.execute(request, responseHandler);
        System.out.println(httpResponse);

    }

}
