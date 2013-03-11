package com.evolveum.demo.registerUser;

import java.sql.SQLException;

import org.apache.wicket.extensions.markup.html.form.select.Select;
import org.apache.wicket.extensions.markup.html.form.select.SelectOption;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.apache.wicket.validation.validator.StringValidator;

import com.evolveum.demo.connector.UserService;
import com.evolveum.demo.errorHandling.UserAlreadyExistsException;
import com.evolveum.demo.hr.HomePage;
import com.evolveum.demo.showUsers.ShowUsers;

public class RegisterUser extends HomePage {
	private String firstname;
	private String surname;
	private String emailAddress;
	private Integer employeeNumber;
	private String artname;
	private String emptype;
	
	UserService userService = UserService.getInstance();
	
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
        
        Label artNameLabel = new Label("artnameLabel", new StringResourceModel("artnameLabel", this, null));
        addRegisterForm.add(artNameLabel);
        
        TextField<String> artNameField = new TextField<String>("artname");
        artNameField.add(StringValidator.maximumLength(255));
        artNameField.add(StringValidator.minimumLength(2)).setRequired(true);
        addRegisterForm.add(artNameField);
        
        
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
        
        Label empTypeLabel = new Label("empTypeLabel", new StringResourceModel("empTypeLabel", this, null));
        addRegisterForm.add(empTypeLabel);
        
        Select empSelect = new Select("empSelect", new PropertyModel<String>(this, "emptype"));
        addRegisterForm.add(empSelect);
        
        empSelect.add(new SelectOption<String>("EmpType1", new Model<String>("FTE")));
        empSelect.add(new SelectOption<String>("EmpType2", new Model<String>("PTE")));
        empSelect.add(new SelectOption<String>("EmpType3", new Model<String>("CONTRACTOR")));
        empSelect.add(new SelectOption<String>("EmpType4", new Model<String>("RETIRED")));
        
        Button submitButton = new Button("submitButton") { 
            @Override
            public void onSubmit() {
            	try {
					userService.registerUser(firstname, surname, emailAddress, employeeNumber, artname, emptype);
					setResponsePage(ShowUsers.class);
				} catch (SQLException e) {
					//throw new RestartResponseException(new Error("sql eception" + e.toString()));
					error("Sql exception" + e.toString());
					log.error(e.toString());
				} catch (UserAlreadyExistsException e) {
					error("User already exists, try another name or email");
					log.error(e.toString());
				}
            }
        };
        addRegisterForm.add(submitButton);
	}
}