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
		String res = "";
		
		if (parameters.getNamedKeys().contains("msg")) {
			StringValue svValue = parameters.get("msg");
			username = svValue.toOptionalString();
			res = "Username : " + username;
		} else if (parameters.getNamedKeys().contains("model")) {
			StringValue svValue = parameters.get("model");
			//username = svValue.toOptionalString();
			res = "User : " + svValue.toOptionalString();
		}
		final Label result = new Label("msg", res);
		add(result);
	}
}
