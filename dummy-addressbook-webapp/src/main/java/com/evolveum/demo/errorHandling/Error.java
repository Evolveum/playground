package com.evolveum.demo.errorHandling;

import org.apache.wicket.markup.html.basic.Label;

import com.evolveum.demo.hr.HomePage;

public class Error extends HomePage{

	public Error(String errorMessage){
		add(new Label("error", errorMessage));
	}

}
