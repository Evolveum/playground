package com.evolveum.demo.modifyUser;

import java.io.Serializable;

import com.evolveum.demo.model.OrgType;
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
	private String orgpath;
	private String responsibility;

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
		orgpath = user.getOrgType();
		responsibility = user.getResponsibility();

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

		Label employeeResponsibilityLabel = new Label("employeeResponsibilityLabel",
				new StringResourceModel("employeeResponsibilityLabel", this, null));
		addRegisterForm.add(employeeResponsibilityLabel);

		TextField<String> employeeResponsibilityField = new TextField<String>("responsibility");
		employeeResponsibilityField.add(StringValidator.maximumLength(100));
		employeeResponsibilityField.add(StringValidator.minimumLength(1)).setRequired(false);
		addRegisterForm.add(employeeResponsibilityField);

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

		Label orgPathLabel = new Label("orgPathLabel", new StringResourceModel(
				"orgPathLabel", this, null));
		addRegisterForm.add(orgPathLabel);

		Select orgPathSelect = new Select("orgPathSelect",
				new PropertyModel<String>(this, "orgpath"));
		addRegisterForm.add(orgPathSelect);

		orgPathSelect.add(new SelectOption<String>("OrgType1",
				//new Model<String>(OrgType.ApprenticeArmory.toString())));
				new Model<String>(OrgType.ApprenticeArmory.name())));
		orgPathSelect.add(new SelectOption<String>("OrgType2",
				new Model<String>(OrgType.ApprenticeWeapons.name())));
		orgPathSelect.add(new SelectOption<String>("OrgType3",
				new Model<String>(OrgType.ApprenticeBuildings.name())));
		orgPathSelect.add(new SelectOption<String>("OrgType4",
				new Model<String>(OrgType.ApprenticeArtefacts.name())));
		orgPathSelect.add(new SelectOption<String>("OrgType5",
				new Model<String>(OrgType.MasterArmory.name())));
		orgPathSelect.add(new SelectOption<String>("OrgType6",
				new Model<String>(OrgType.MasterWeapons.name())));
		orgPathSelect.add(new SelectOption<String>("OrgType7",
				new Model<String>(OrgType.MasterBuildings.name())));
		orgPathSelect.add(new SelectOption<String>("OrgType8",
				new Model<String>(OrgType.MasterArtefacts.name())));
		orgPathSelect.add(new SelectOption<String>("OrgType9",
				new Model<String>(OrgType.MasterMilitary.name())));
		orgPathSelect.add(new SelectOption<String>("OrgType10",
				new Model<String>(OrgType.MasterCivil.name())));
		orgPathSelect.add(new SelectOption<String>("OrgType11",
				new Model<String>(OrgType.GrandMaster.name())));
		orgPathSelect.add(new SelectOption<String>("OrgType12",
				new Model<String>(" ")));

		Button submitButton = new Button("submitButton") {
			@Override
			public void onSubmit() {
				user.setFirstname(firstname);
				user.setSurname(surname);
				user.setEmptype(emptype);
				user.setEmployeeNumber(employeeNumber);
				user.setArtname(artname);
				user.setOrgType(orgpath);
				user.setResponsibility(responsibility);

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
