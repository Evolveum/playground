package com.evolveum.playground.idmatch.operations;

import com.evolveum.playground.idmatch.data.ListResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApacheResponseHandler implements ResponseHandler<List<ListResponse>> {

    String EXISTING = "EXISTING IDENTITIES";
    String CREATED = "CREATED";
    String ACCEPTED = "ACCEPTED";
    String NOT_FOUND = "NOT FOUND";
    String MULTIPLE_CHOICES = "MULTIPLE CHOICES RESPONSE";
    String CONFLICT = "DENIAL OF PROCESSING DUE TO DATA CONFLICTS";
    String UNAUTHORIZED = "UNAUTHORIZED";
    String UNEXPECTED_HEADER = "UNEXPECTED HEADER FOUND";
    String BAD_REQUEST = "BAD REQUEST";
    String NOT_IMPLEMENTED = "NOT IMPLEMENTED YET";


    public List<ListResponse> handleResponse(HttpResponse httpResponse) throws IOException {

        int status = httpResponse.getStatusLine().getStatusCode();

        final HttpEntity entity = httpResponse.getEntity();
        String message;

        List<ListResponse> listResponses = new ArrayList<>();

        switch (status) {
            case HttpStatus.SC_OK -> message = EXISTING;
            case HttpStatus.SC_CREATED -> message = CREATED;
            case HttpStatus.SC_ACCEPTED -> message = ACCEPTED;
            case HttpStatus.SC_BAD_REQUEST -> throw new IllegalStateException(BAD_REQUEST);
            case HttpStatus.SC_NOT_FOUND -> message = NOT_FOUND;
            case HttpStatus.SC_MULTIPLE_CHOICES -> message = MULTIPLE_CHOICES;
            case HttpStatus.SC_CONFLICT -> message = CONFLICT;
            case HttpStatus.SC_UNAUTHORIZED -> throw new IllegalStateException(UNAUTHORIZED + EntityUtils.toString(entity));
            case 250 -> throw new IllegalStateException(UNEXPECTED_HEADER + EntityUtils.toString(entity));
            default -> throw new UnsupportedOperationException(NOT_IMPLEMENTED + httpResponse);
        }


        if (entity != null) {
            listResponses.add(new ListResponse(message, EntityUtils.toString(entity), Integer.toString(status)));
        }
        return listResponses;

    }

}

