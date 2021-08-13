package com.evolveum.playground.idmatch.operations;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ApacheResponseHandler implements ResponseHandler<String> {


    public String handleResponse(HttpResponse httpResponse) throws IOException {

        int status = httpResponse.getStatusLine().getStatusCode();
        final HttpEntity entity = httpResponse.getEntity();

        switch (status) {
            case HttpStatus.SC_OK -> System.out.println("OK: Existing identities.");
            case HttpStatus.SC_CREATED -> System.out.println("Created.");
            case HttpStatus.SC_ACCEPTED -> System.out.println("Accepted");
            case HttpStatus.SC_BAD_REQUEST -> throw new IllegalStateException("Bad Request.");
            case HttpStatus.SC_NOT_FOUND -> System.out.println("Not found. ");
            case HttpStatus.SC_MULTIPLE_CHOICES -> System.out.println("Multiple Choices response. ");
            case HttpStatus.SC_CONFLICT -> System.out.println("Denial of processing due to data conflicts. ");
            case HttpStatus.SC_UNAUTHORIZED -> throw new IllegalStateException("Unauthorized" + EntityUtils.toString(entity));
            case 250 -> throw new IllegalStateException("Unexpected header found: " + EntityUtils.toString(entity));
            default -> throw new UnsupportedOperationException("Not implemented yet: " + httpResponse);
        }

        return entity != null ? EntityUtils.toString(entity) : null;

    }
}

