package com.evolveum.playground.idmatch.operations;

import com.evolveum.playground.idmatch.data.ListResponse;
import com.evolveum.playground.idmatch.operations.auth.AuthenticationProvider;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApachePostRequest extends HttpClientSuper  implements ApacheApiRequest {


    List<ListResponse> httpResponse = new ArrayList<>();


    @Override
    public void doRequest(AuthenticationProvider authenticationProvider, String channel, String jsonString, String urlSuffix) throws IOException {

        HttpPost request = new HttpPost(channel + urlSuffix);
        request.addHeader("content-type", "application/json");
        request.setEntity(new StringEntity(jsonString));

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
