package com.evolveum.demo.modifyUser;

import java.io.Serializable;

import org.apache.wicket.RestartResponseException;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.apache.wicket.validation.validator.StringValidator;

import com.evolveum.demo.connector.PostgresConnector;
import com.evolveum.demo.connector.UserService;
import com.evolveum.demo.hr.HomePage;
import com.evolveum.demo.model.User;
import com.evolveum.demo.showUsers.ShowUsers;

public class ModifyUser extends HomePage implements Serializable {
	private String firstname;
	private String surname;
	private String emailAddress;
	private Integer employeeNumber;
	private Integer id;
	
	public ModifyUser(Integer userId){
		initGui(userId);
	
	}
	
	private void initGui(Integer userId){
		User u = userService.showUser(userId);
		firstname = u.getFirstname();
		surname = u.getSurname();
		emailAddress = u.getEmailAddress();
		employeeNumber = u.getEmployeeNumber();
		id = u.getId();
		
		Form<ModifyUser> addRegisterForm = new Form<ModifyUser>("addLocationForm", new CompoundPropertyModel<ModifyUser>(this));
        add(addRegisterForm);
        
        
        Label nameLabel = new Label("firstnameLabel",new StringResourceModel("firstnameLabel", this, null));
        addRegisterForm.add(nameLabel);
        
        TextField<String> nameField = new TextField<String>("firstname",new PropertyModel(this, "firstname"));
        nameField.add(StringValidator.maximumLength(255));
        nameField.add(StringValidator.minimumLength(5)).setRequired(true);;
        nameField.setConvertEmptyInputStringToNull(false);
        addRegisterForm.add(nameField);
        
        Label givenNameLabel = new Label("surnameLabel", new StringResourceModel("surnameLabel", this, null)); 
        addRegisterForm.add(givenNameLabel);
        
        TextField<String> givenNameField = new TextField<String>("surname",new PropertyModel(this, "surname")); 
        givenNameField.add(StringValidator.maximumLength(255));
        givenNameField.add(StringValidator.minimumLength(5)).setRequired(true);;
        addRegisterForm.add(givenNameField);
        
        Label emailAddressLabel = new Label("emailAddressLabel", new StringResourceModel("emailAddressLabel", this, null));
        addRegisterForm.add(emailAddressLabel);
        
        TextField<String> emailAddressField = new TextField<String>("emailAddress",new PropertyModel(this, "emailAddress"));
        emailAddressField.add(StringValidator.maximumLength(255));
        emailAddressField.add(StringValidator.minimumLength(5));
        emailAddressField.add(EmailAddressValidator.getInstance());
        emailAddressField.setRequired(true);
        addRegisterForm.add(emailAddressField);
        
        Label employeeNumberLabel = new Label("employeeNumberLabel", new StringResourceModel("employeeNumberLabel", this, null));
        addRegisterForm.add(employeeNumberLabel);
        
        TextField<Integer> employeeNumberField = new TextField<Integer>("employeeNumber",new PropertyModel(this, "employeeNumber"));
        employeeNumberField.setRequired(true);
        addRegisterForm.add(employeeNumberField);
        
        
        Button submitButton = new Button("submitButton") { 
            @Override
            public void onSubmit() {
            	userService.updateUser(firstname, surname, emailAddress, employeeNumber, id);
            	setResponsePage(ShowUsers.class);
            }
        };
        addRegisterForm.add(submitButton);
        
        Button deleteButton = new Button("deleteButton") { 
            @Override
            public void onSubmit() {
            	userService.deleteUser(id);
            	setResponsePage(ShowUsers.class);
            }
        };
        addRegisterForm.add(deleteButton);
	}
	
}
