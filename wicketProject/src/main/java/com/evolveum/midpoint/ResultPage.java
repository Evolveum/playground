package com.evolveum.midpoint;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

public class ResultPage extends WebPage {
	private static final long serialVersionUID = 1L;
	String username = null;

	public ResultPage(PageParameters parameters) {
		String username = null;

		if (parameters.getNamedKeys().contains("msg")) {
			StringValue svValue = parameters.get("msg");
			username = svValue.toOptionalString();
		}

		final Label result = new Label("msg", "Username : " + username);
		add(result);
	}
}
