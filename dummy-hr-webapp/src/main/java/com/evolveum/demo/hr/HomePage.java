package com.evolveum.demo.hr;

import java.util.TimeZone;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

import com.evolveum.demo.connector.Clock;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage() {
		add(new BookmarkablePageLink("register", RegisterUser.class));
		add(new BookmarkablePageLink("show", ShowUsers.class));
		add(new Label("footer", "midpoint"));


		Clock clock = new Clock("clock", TimeZone.getTimeZone("America/Los_Angeles"));
        add(clock);
    }
	
}
