package com.evolveum.midpoint;

import org.apache.wicket.request.Request;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;

/**
 * A session implementation of this secure form example. This implementation
 * is used to store the username of the authenticated user.
 * @author Petri Kainulainen
 */
public class WicketHttpsSession extends WebSession {
	private static final long serialVersionUID = 1L;
	private String authenticatedUsername;

    public WicketHttpsSession(Request request) {
        super(request);
    }

    public static WicketHttpsSession get() {
        return (WicketHttpsSession) Session.get();
    }

    public String getAuthenticatedUsername() {
        return authenticatedUsername;
    }

    public void setAuthenticatedUsername(String authenticatedUsername) {
        this.authenticatedUsername = authenticatedUsername;
    }
}
