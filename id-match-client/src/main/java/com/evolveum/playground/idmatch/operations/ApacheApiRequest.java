package com.evolveum.playground.idmatch.operations;

import com.evolveum.playground.idmatch.data.ListResponse;
import com.evolveum.playground.idmatch.operations.auth.AuthenticationProvider;

import java.io.IOException;
import java.util.List;

public interface ApacheApiRequest {

    void doRequest(AuthenticationProvider authenticationProvider, String urlPrefix, String jsonString, String urlSuffix) throws IOException;

    List<ListResponse> listResponse();
}
