package com.evolveum.midpoint;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
    private static final String WICKET_ID_GREETING_PANEL = "greetingPanel";

    public HomePage(final PageParameters parameters) {
		super(parameters);
        init();
    }

    private void init() {
        add(new UserPanel(WICKET_ID_GREETING_PANEL));
    }
}
