package com.evolveum.playground.idmatch.operations;

import com.evolveum.playground.idmatch.operations.auth.AuthenticationProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientSuper {


    public HttpClient httpClient(AuthenticationProvider authenticationProvider) {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(authenticationProvider.provider())
                .build();

        return httpClient;
    }

}
