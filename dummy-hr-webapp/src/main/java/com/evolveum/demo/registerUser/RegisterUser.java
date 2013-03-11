package com.evolveum.demo.registerUser;

import java.sql.SQLException;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.apache.wicket.validation.validator.StringValidator;

import com.evolveum.demo.connector.PostgresConnector;
import com.evolveum.demo.connector.UserService;
import com.evolveum.demo.hr.HomePage;
import com.evolveum.demo.showUsers.ShowUsers;

public class RegisterUser extends HomePage {
	private String firstname;
	private String surname;
	private String emailAddress;
	private Integer employeeNumber;
	
	public RegisterUser() {     
        initGui();
	}
	
	private void initGui(){
		Form<RegisterUser> addRegisterForm = new Form<RegisterUser>("addRegisterForm", new CompoundPropertyModel<RegisterUser>(this));
        add(addRegisterForm);
        
        Label nameLabel = new Label("firstnameLabel", new StringResourceModel("firstnameLabel", this, null));
        addRegisterForm.add(nameLabel);
        
        TextField<String> firstnameField = new TextField<String>("firstname");
        firstnameField.add(StringValidator.maximumLength(255));
        firstnameField.add(StringValidator.minimumLength(5)).setRequired(true);
        addRegisterForm.add(firstnameField);
        
        Label givenNameLabel = new Label("surnameLabel", new StringResourceModel("surnameLabel", this, null)); 
        addRegisterForm.add(givenNameLabel);
        
        
        TextField<String> surnameField = new TextField<String>("surname");
        surnameField.add(StringValidator.maximumLength(255));
        surnameField.add(StringValidator.minimumLength(5)).setRequired(true);
        addRegisterForm.add(surnameField);
        
        Label emailAddressLabel = new Label("emailAddressLabel",new StringResourceModel("emailAddressLabel", this, null));
        addRegisterForm.add(emailAddressLabel);
        
        TextField<String> emailAddressField = new TextField<String>("emailAddress");
        emailAddressField.add(StringValidator.maximumLength(255));
        emailAddressField.add(StringValidator.minimumLength(5)).setRequired(true);
        emailAddressField.add(EmailAddressValidator.getInstance());
        addRegisterForm.add(emailAddressField);
        
        Label employeeNumberLabel = new Label("employeeNumberLabel", new StringResourceModel("employeeNumberLabel", this, null));
        addRegisterForm.add(employeeNumberLabel);
        
        TextField<Integer> employeeNumberField = new TextField<Integer>("employeeNumber");
        employeeNumberField.setRequired(true);
        addRegisterForm.add(employeeNumberField);
        
        Button submitButton = new Button("submitButton") { 
            @Override
            public void onSubmit() {
            	try {
					userService.registerNewUser(firstname, surname, emailAddress, employeeNumber);
					setResponsePage(ShowUsers.class);
				} catch (SQLException e) {
					//throw new RestartResponseException(new Error("sql eception" + e.toString()));
					error("Sql exception");
					log.error(e.toString());
				} catch (Exception e) {
					error("User already exists, try another name or email");
					log.error(e.toString());
				}
            }
        };
        addRegisterForm.add(submitButton);
	}
}