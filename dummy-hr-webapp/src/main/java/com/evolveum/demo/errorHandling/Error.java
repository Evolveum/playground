package com.evolveum.demo.errorHandling;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class Error extends WebPage{

	public Error(String errorMessage){
		add(new Label("error", errorMessage));
	}

}
