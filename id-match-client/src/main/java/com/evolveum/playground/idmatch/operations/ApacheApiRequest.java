package com.evolveum.playground.idmatch.operations;

import com.evolveum.playground.idmatch.operations.auth.AuthenticationProvider;

import java.io.IOException;

public interface ApacheApiRequest {
     void doRequest(AuthenticationProvider authenticationProvider, String urlPrefix, String jsonString, String urlSuffix) throws IOException;

}
