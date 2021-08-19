package com.evolveum.playground.idmatch.operations;

import com.evolveum.playground.idmatch.data.ListResponse;

import java.io.IOException;
import java.util.List;

public interface ApacheApiRequest {

    void doRequest(String urlPrefix, String urlSuffix, String jsonString) throws IOException;

    List<ListResponse> listResponse();
}
