package com.evolveum.playground.idmatch.operations;

import com.evolveum.playground.idmatch.data.ListResponse;
import com.evolveum.playground.idmatch.operations.auth.AuthenticationProvider;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ApacheGetRequest extends HttpClientSuper implements ApacheApiRequest {


    List<ListResponse> httpResponse = new ArrayList<>();

    public ApacheGetRequest(AuthenticationProvider authenticationProvider) {
        super(authenticationProvider);
    }


    @Override
    public void doRequest(String channel, String jsonString, String urlSuffix) throws IOException {

        HttpGet request = new HttpGet(channel + urlSuffix);

        ResponseHandler<List<ListResponse>> responseHandler = new ApacheResponseHandler();
        setHttpResponse(httpClient(authenticationProvider).execute(request, responseHandler));

    }


    @Override
    public List<ListResponse> listResponse() {
        return httpResponse;
    }


    public void setHttpResponse(List<ListResponse> httpResponse) {
        this.httpResponse = httpResponse;
    }

}
