package com.evolveum.demo.hr;

import java.util.Random;
import java.util.TimeZone;

import org.apache.wicket.RestartResponseException;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.apache.wicket.validation.validator.StringValidator;

import com.evolveum.demo.connector.Clock;
import com.evolveum.demo.connector.PostgresConnector;
import com.evolveum.demo.connector.UserService;

public class RegisterUser extends HomePage {
	private String fullName;
	private String givenName;
	private String emailAddress;
	private Integer employeeNumber;
	
	public RegisterUser() {
		
		
		Form<RegisterUser> addRegisterForm = new Form<RegisterUser>("addRegisterForm", new CompoundPropertyModel<RegisterUser>(this));  // (1)
        add(addRegisterForm);
        
        Label nameLabel = new Label("fullNameLabel", "User name");
        addRegisterForm.add(nameLabel);
        
        TextField<String> nameField = new TextField<String>("fullName");
        nameField.add(StringValidator.maximumLength(255));
        nameField.add(StringValidator.minimumLength(5)).setRequired(true);
        addRegisterForm.add(nameField);
        
        Label givenNameLabel = new Label("givenNameLabel", "Given name"); 
        addRegisterForm.add(givenNameLabel);
        
        
        TextField<String> givenNameField = new TextField<String>("givenName");
        givenNameField.add(StringValidator.maximumLength(255));
        givenNameField.add(StringValidator.minimumLength(5)).setRequired(true);
        addRegisterForm.add(givenNameField);
        
        Label emailAddressLabel = new Label("emailAddressLabel", "Email address");
        addRegisterForm.add(emailAddressLabel);
        
        TextField<String> emailAddressField = new TextField<String>("emailAddress");
        emailAddressField.add(StringValidator.maximumLength(255));
        emailAddressField.add(StringValidator.minimumLength(5)).setRequired(true);
        emailAddressField.add(EmailAddressValidator.getInstance());
        addRegisterForm.add(emailAddressField);
        
        Label employeeNumberLabel = new Label("employeeNumberLabel", "Emp. num");
        addRegisterForm.add(employeeNumberLabel);
        
        TextField<Integer> employeeNumberField = new TextField<Integer>("employeeNumber");
        employeeNumberField.setRequired(true);
        addRegisterForm.add(employeeNumberField);
        
		
        add(new FeedbackPanel("feedbackPanel"));
        
        
        Button submitButton = new Button("submitButton") { 
            @Override
            public void onSubmit() {
            	PostgresConnector pgc = new PostgresConnector();
        		UserService userService = new UserService(pgc.connect());
            	
            	Random generator = new Random();
            	int id = generator.nextInt(300);
            	userService.registerNewUser(fullName, givenName, emailAddress, employeeNumber, id);
            	
            	
                System.out.println("OnSubmit, name = " + fullName + givenName + emailAddress );
                throw new RestartResponseException(ShowUsers.class);
            }
        };
        addRegisterForm.add(submitButton);
	}
}