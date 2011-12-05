package com.evolveum.midpoint.login;

import com.evolveum.midpoint.HomePage;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.protocol.https.RequireHttps;
import org.apache.wicket.request.mapper.parameter.PageParameters;

@RequireHttps
public class SecureLoginPage extends WebPage {

	private static final long serialVersionUID = 1L;
	private static final String WICKET_ID_HOMEPAGE_LINK = "homepageLink";
    private static final String WICKET_ID_LOGINFORM = "loginForm";

    public SecureLoginPage(PageParameters parameters) {
        super(parameters);
        init();
    }

    protected void init() {
        add(new BookmarkablePageLink(WICKET_ID_HOMEPAGE_LINK, HomePage.class));
        add(new LoginForm(WICKET_ID_LOGINFORM));
    }
}
