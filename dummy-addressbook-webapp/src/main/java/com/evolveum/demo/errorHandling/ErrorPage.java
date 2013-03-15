package com.evolveum.demo.errorHandling;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class ErrorPage extends WebPage{

	public ErrorPage(String errorMessage){
		add(new Label("error", errorMessage));
	}

}
