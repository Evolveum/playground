package com.evolveum.midpoint;

import com.evolveum.midpoint.login.LogoutLink;
import com.evolveum.midpoint.login.SecureLoginPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.*;
import org.apache.wicket.model.util.MapModel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Petri Kainulainen
 */
public class UserPanel extends Panel {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE_KEY_GREETING_MESSAGE = "greeting.message";
    private static final String MESSAGE_KEY_LINK_LOGIN = "link.login";
    private static final String VALUE_KEY_USERNAME = "username";


    private static final String USERNAME_ANONYMOUS = "Anynomous";

    private static final String WICKET_ID_GREETING = "greeting";
    private static final String WICKET_ID_LINK = "link";
    private static final String WICKET_ID_LINK_LABEL = "linkLabel";

    public UserPanel(String id) {
        super(id);
        init();
    }

    public UserPanel(String id, IModel<?> model) {
        super(id, model);
        init();
    }

    private void init() {
        Map<String, String> greetingInformation = constructGreetingInformation();

        add(new Label(WICKET_ID_GREETING, new StringResourceModel(MESSAGE_KEY_GREETING_MESSAGE, this, new MapModel(greetingInformation))));
        addLinks();
    }

    private Map<String, String> constructGreetingInformation() {
        String username = getUsername();
        Map<String, String> greetingInformation = new HashMap<String, String>();
        greetingInformation.put(VALUE_KEY_USERNAME, username);
        return greetingInformation;
    }

    private String getUsername() {
        WicketHttpsSession currentSession = WicketHttpsSession.get();
        String username = currentSession.getAuthenticatedUsername();
        if (username != null) {
            return username;
        } else {
            return USERNAME_ANONYMOUS;
        }
    }

    private void addLinks() {
        WicketHttpsSession currentSession = WicketHttpsSession.get();
        String username = currentSession.getAuthenticatedUsername();
        if (username != null) {
            addLogoutLink();
        } else {
            addLoginLink();
        }
    }

    private void addLogoutLink() {
        add(new LogoutLink(WICKET_ID_LINK));
    }

    private void addLoginLink() {
        BookmarkablePageLink loginLink = new BookmarkablePageLink(WICKET_ID_LINK, SecureLoginPage.class);
        loginLink.add(new Label(WICKET_ID_LINK_LABEL, new ResourceModel(MESSAGE_KEY_LINK_LOGIN)));
        add(loginLink);
    }
}
