package com.evolveum.demo.modifyUser;

import java.io.Serializable;

import com.evolveum.demo.model.Status;
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
import org.apache.wicket.validation.validator.StringValidator;

import com.evolveum.demo.hr.HomePage;
import com.evolveum.demo.model.UserJpa;
import com.evolveum.demo.showUsers.ShowUsers;

public class ModifyUser extends HomePage implements Serializable {
	private String firstname;
	private String surname;
	private Integer employeeNumber;
	private Integer id;
	private String artname;
	private String emptype;
	private String status;
	private String locality;
//	private String ou;
	private String country;
	private String job;

	UserJpa user;

	public ModifyUser(Integer userId) {
		initGui(userId);
	}

	private void initGui(Integer userId) {

		user = userService.getUser(userId);
		firstname = user.getFirstname();
		surname = user.getSurname();
		employeeNumber = user.getEmployeeNumber();
		id = user.getId();
		artname = user.getArtname();
		emptype = user.getEmptype();
		status = user.getStatus();
		locality = user.getLocality();
		country = user.getCountry();
		job = user.getJob();

		Form<ModifyUser> addRegisterForm = new Form<ModifyUser>(
				"addLocationForm", new CompoundPropertyModel<ModifyUser>(this));
		add(addRegisterForm);

		Label nameLabel = new Label("firstnameLabel", new StringResourceModel(
				"firstnameLabel", this, null));
		addRegisterForm.add(nameLabel);

		TextField<String> nameField = new TextField<String>("firstname",
				new PropertyModel(this, "firstname"));
		nameField.add(StringValidator.maximumLength(100));
		nameField.add(StringValidator.minimumLength(1)).setRequired(true);
		;
		nameField.setConvertEmptyInputStringToNull(false);
		addRegisterForm.add(nameField);

		Label givenNameLabel = new Label("surnameLabel",
				new StringResourceModel("surnameLabel", this, null));
		addRegisterForm.add(givenNameLabel);

		TextField<String> givenNameField = new TextField<String>("surname",
				new PropertyModel(this, "surname"));
		givenNameField.add(StringValidator.maximumLength(100));
		givenNameField.add(StringValidator.minimumLength(1)).setRequired(true);
		;
		addRegisterForm.add(givenNameField);

		Label artNameLabel = new Label("artnameLabel", new StringResourceModel(
				"artnameLabel", this, null));
		addRegisterForm.add(artNameLabel);

		TextField<String> artNameField = new TextField<String>("artname",
				new PropertyModel(this, "artname"));
		artNameField.add(StringValidator.maximumLength(100));
		artNameField.add(StringValidator.minimumLength(1)).setRequired(true);
		;
		addRegisterForm.add(artNameField);

		Label employeeNumberLabel = new Label("employeeNumberLabel",
				new StringResourceModel("employeeNumberLabel", this, null));
		addRegisterForm.add(employeeNumberLabel);

		TextField<Integer> employeeNumberField = new TextField<Integer>(
				"employeeNumber", new PropertyModel(this, "employeeNumber"));
		employeeNumberField.setRequired(true);
		addRegisterForm.add(employeeNumberField);

		Label jobLabel = new Label("jobLabel",
				new StringResourceModel("jobLabel", this, null));
		addRegisterForm.add(jobLabel);

		TextField<String> jobField = new TextField<String>("job");
		jobField.add(StringValidator.maximumLength(100));
		jobField.add(StringValidator.minimumLength(1)).setRequired(false);
		addRegisterForm.add(jobField);

		Label empTypeLabel = new Label("empTypeLabel", new StringResourceModel(
				"empTypeLabel", this, null));
		addRegisterForm.add(empTypeLabel);

		Select empSelect = new Select("empSelect", new PropertyModel<String>(
				this, "emptype"));
		addRegisterForm.add(empSelect);

		empSelect.add(new SelectOption<String>("EmpType1", new Model<String>(
				"FTE")));
		empSelect.add(new SelectOption<String>("EmpType2", new Model<String>(
				"PTE")));
		empSelect.add(new SelectOption<String>("EmpType3", new Model<String>(
				"CONTRACTOR")));
		empSelect.add(new SelectOption<String>("EmpType4", new Model<String>(
				"RETIRED")));

		Label localityLabel = new Label("localityLabel", new StringResourceModel(
				"localityLabel", this, null));
		addRegisterForm.add(localityLabel);

		TextField<String> localityField = new TextField<String>("locality");
		localityField.add(StringValidator.maximumLength(100));
		localityField.add(StringValidator.minimumLength(1)).setRequired(true);
		addRegisterForm.add(localityField);

//		Label ouLabel = new Label("ouLabel", new StringResourceModel(
//				"ouLabel", this, null));
//		addRegisterForm.add(ouLabel);
//
//		TextField<String> ouField = new TextField<String>("ou");
//		ouField.add(StringValidator.maximumLength(100));
//		ouField.add(StringValidator.minimumLength(1)).setRequired(true);
//		addRegisterForm.add(ouField);

		Label countryLabel = new Label("countryLabel", new StringResourceModel(
				"countryLabel", this, null));
		addRegisterForm.add(countryLabel);

		TextField<String> ouField = new TextField<String>("country");
		ouField.add(StringValidator.maximumLength(100));
		ouField.add(StringValidator.minimumLength(1)).setRequired(true);
		addRegisterForm.add(ouField);

		Label statusLabel = new Label("statusLabel", new StringResourceModel(
				"statusLabel", this, null));
		addRegisterForm.add(statusLabel);

		Select statusSelect = new Select("statusSelect", new PropertyModel<String>(
				this, "status"));
		addRegisterForm.add(statusSelect);

		Integer statusNo = 1;
		for(Status s : Status.values()){

			statusSelect.add(new SelectOption<String>("Status"+statusNo, new Model<String>(
					s.label)));
			statusNo++;
		}

		Button submitButton = new Button("submitButton") {
			@Override
			public void onSubmit() {
				user.setFirstname(firstname);
				user.setSurname(surname);
				user.setEmptype(emptype);
				user.setEmployeeNumber(employeeNumber);
				user.setArtname(artname);
				user.setStatus(status);
				user.setCountry(country);
				user.setLocality(locality);

				userService.modifyUser(user);
				setResponsePage(ShowUsers.class);
			}
		};
		addRegisterForm.add(submitButton);

		Button deleteButton = new Button("deleteButton") {
			@Override
			public void onSubmit() {
				userService.deleteUser(user);
				setResponsePage(ShowUsers.class);
			}
		};
		addRegisterForm.add(deleteButton);
	}
}
