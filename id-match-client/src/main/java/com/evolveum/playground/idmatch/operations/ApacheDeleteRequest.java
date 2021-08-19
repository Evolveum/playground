package com.evolveum.playground.idmatch.operations;


import com.evolveum.playground.idmatch.data.ListResponse;
import com.evolveum.playground.idmatch.operations.auth.AuthenticationProvider;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class ApacheDeleteRequest extends HttpClientSuper implements ApacheApiRequest {


    List<ListResponse> httpResponse = new ArrayList<>();

    public ApacheDeleteRequest(AuthenticationProvider authenticationProvider) {
        super(authenticationProvider);
    }


    @Override
    public void doRequest(String channel, String jsonString, String urlSuffix) throws IOException {

        HttpDelete request = new HttpDelete(channel + urlSuffix);

        ResponseHandler<List<ListResponse>> responseHandler = new ApacheResponseHandler();
        setHttpResponse(httpClient().execute(request, responseHandler));
    }


    @Override
    public List<ListResponse> listResponse() {
        return httpResponse;
    }


    public void setHttpResponse(List<ListResponse> httpResponse) {
        this.httpResponse = httpResponse;
    }

}
