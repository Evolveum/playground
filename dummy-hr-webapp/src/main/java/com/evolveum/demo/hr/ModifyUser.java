package com.evolveum.demo.hr;

import org.apache.wicket.RestartResponseException;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.apache.wicket.validation.validator.StringValidator;

import com.evolveum.demo.connector.PostgresConnector;
import com.evolveum.demo.connector.UserService;
import com.evolveum.demo.model.User;

public class ModifyUser extends HomePage{
	private String fullName;
	private String givenName;
	private String emailAddress;
	private Integer employeeNumber;
	private Integer id;
	
	PostgresConnector pgc = new PostgresConnector();
	UserService userService = new UserService(pgc.connect());
	
	public ModifyUser(Integer i){
		User u = userService.showUser(i);
		fullName = u.getFullName();
		givenName = u.getGivenName();
		emailAddress = u.getEmailAddress();
		employeeNumber = u.getEmployeeNumber();
		id = u.getId();

		
		Form<ModifyUser> addRegisterForm = new Form<ModifyUser>("addLocationForm", new CompoundPropertyModel<ModifyUser>(this));  // (1)
        add(addRegisterForm);
        
        
        Label nameLabel = new Label("fullNameLabel", "User name");
        addRegisterForm.add(nameLabel);
        
        TextField<String> nameField = new TextField<String>("fullName",new PropertyModel(this, "fullName"));
        nameField.add(StringValidator.maximumLength(255));
        nameField.add(StringValidator.minimumLength(5)).setRequired(true);;
        nameField.setConvertEmptyInputStringToNull(false);
        addRegisterForm.add(nameField);
        
        Label givenNameLabel = new Label("givenNameLabel", "Given name"); 
        addRegisterForm.add(givenNameLabel);
        
        TextField<String> givenNameField = new TextField<String>("givenName",new PropertyModel(this, "givenName")); 
        givenNameField.add(StringValidator.maximumLength(255));
        givenNameField.add(StringValidator.minimumLength(5)).setRequired(true);;
        addRegisterForm.add(givenNameField);
        
        Label emailAddressLabel = new Label("emailAddressLabel", "Email address");
        addRegisterForm.add(emailAddressLabel);
        
        TextField<String> emailAddressField = new TextField<String>("emailAddress",new PropertyModel(this, "emailAddress"));
        emailAddressField.add(StringValidator.maximumLength(255));
        emailAddressField.add(StringValidator.minimumLength(5));
        emailAddressField.add(EmailAddressValidator.getInstance());
        emailAddressField.setRequired(true);
        addRegisterForm.add(emailAddressField);
        
        Label employeeNumberLabel = new Label("employeeNumberLabel", "Emp. num");
        addRegisterForm.add(employeeNumberLabel);
        
        TextField<Integer> employeeNumberField = new TextField<Integer>("employeeNumber",new PropertyModel(this, "employeeNumber"));
        employeeNumberField.setRequired(true);
        addRegisterForm.add(employeeNumberField);
        
        add(new FeedbackPanel("feedbackPanel"));
        
        Button submitButton = new Button("submitButton") { 
            @Override
            public void onSubmit() {
            	userService.updateUser(fullName, givenName, emailAddress, employeeNumber, id);
            	throw new RestartResponseException(ShowUsers.class);
            }
        };
        addRegisterForm.add(submitButton);
        
        Button deleteButton = new Button("deleteButton") { 
            @Override
            public void onSubmit() {
            	userService.deleteUser(id);
            	throw new RestartResponseException(ShowUsers.class);
            }
        };
        addRegisterForm.add(deleteButton);
	
	}
	
}
