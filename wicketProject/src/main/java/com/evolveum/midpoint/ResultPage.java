package com.evolveum.midpoint;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

public class ResultPage extends WebPage {
	private static final long serialVersionUID = 1L;
	String username = null;

	public ResultPage(PageParameters parameters) {
		String res = "";
		ContactsDatabase cd = null;
		MidPointApplication mid = new MidPointApplication();
		
		if (parameters.getNamedKeys().contains("msg")) {
			StringValue svValue = parameters.get("msg");
			res = "Username : " + svValue.toOptionalString();
		} else {
			
			StringValue svValue = parameters.get("user");
			Long id = Long.valueOf(svValue.toOptionalString());
			
			@SuppressWarnings("null")
			Contact contact = cd.get(id);
			res = "User : ";
			res += "First name: " + contact.getFirstName(); 
		}
		final Label result = new Label("msg", res);
		add(result);
	}
}
