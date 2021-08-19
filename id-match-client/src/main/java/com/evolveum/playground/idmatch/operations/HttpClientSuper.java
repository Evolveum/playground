package com.evolveum.playground.idmatch.operations;

import com.evolveum.playground.idmatch.operations.auth.AuthenticationProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class HttpClientSuper {


    AuthenticationProvider authenticationProvider;
    CloseableHttpClient httpClient;


    public HttpClientSuper(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }


    public HttpClient httpClient() {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(authenticationProvider.provider())
                .build();

        return httpClient;
    }


    public void clientClose() {
        try {
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
