package com.evolveum.midpoint.login;

import com.evolveum.midpoint.HomePage;
import com.evolveum.midpoint.WicketHttpsSession;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;

public class LogoutLink extends Link {

    private static final String MESSAGE_KEY_LINK_LOGOUT = "link.logout";
    private static final String WICKET_ID_LINK_LABEL = "linkLabel";

    public LogoutLink(String id) {
        super(id);
        init();
    }

    public LogoutLink(String id, IModel iModel) {
        super(id, iModel);
        init();
    }

    private void init() {
        add(new Label(WICKET_ID_LINK_LABEL, new ResourceModel(MESSAGE_KEY_LINK_LOGOUT)));
    }

    @Override
    public void onClick() {
        WicketHttpsSession session = WicketHttpsSession.get();
        session.invalidate();
        this.setResponsePage(HomePage.class);
    }
}
