package com.evolveum.demo.showUsers;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.ServletContext;
import javax.xml.stream.Location;
import org.apache.log4j.Logger;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.protocol.http.WebApplication;

import com.evolveum.demo.exporter.CsvWriter;
import com.evolveum.demo.hr.HomePage;
import com.evolveum.demo.model.UserJpa;
import com.evolveum.demo.modifyUser.ModifyUser;

public class ShowUsers extends HomePage {
	public ArrayList<UserJpa> users;

	public static Logger LOG = Logger.getLogger(ShowUsers.class.getName());

	public ShowUsers() {
		users = (ArrayList<UserJpa>) userService.listUsers();
		Integer itemsPerPage = 10;

		if(IS_TRAINING){
			itemsPerPage = 50;
		}
		PageableListView<UserJpa> userList = new PageableListView<UserJpa>(
				"users", users, itemsPerPage) {
			@Override
			protected void populateItem(ListItem<UserJpa> item) {

				Link view = new Link<>("view", item.getModel()) {
					public void onClick() {
						UserJpa c = (UserJpa) getModelObject();
						setResponsePage(new ModifyUser(c.getId()));
					}
				};

				item.add(view);

				item.add(new Label("surname", new PropertyModel<Location>(item
						.getModel(), new StringResourceModel("surname", this,
						null).getString())));
				item.add(new Label("firstname", new PropertyModel<Location>(
						item.getModel(), new StringResourceModel("firstname",
								this, null).getString())));
				item.add(new Label("artname", new PropertyModel<Location>(item
						.getModel(), new StringResourceModel("artname", this,
						null).getString())));
				item.add(new Label("employeeNumber",
						new PropertyModel<Location>(item.getModel(),
								new StringResourceModel("employeeNumber", this,
										null).getString())));
				item.add(new Label("id", new PropertyModel<Location>(item
						.getModel(), new StringResourceModel("id", this, null)
						.getString())));
				item.add(new Label("job", new PropertyModel<Location>(item
						.getModel(), new StringResourceModel("job", this,
						null).getString())));
				item.add(new Label("emptype", new PropertyModel<Location>(item
						.getModel(), new StringResourceModel("emptype", this,
						null).getString())));
				item.add(new Label("locality", new PropertyModel<Location>(item
						.getModel(), new StringResourceModel("locality", this,
						null).getString())));
				//TODO organizational unit for future trainings
//				item.add(new Label("ou", new PropertyModel<Location>(item
//						.getModel(), new StringResourceModel("ou", this,
//						null).getString())));
				item.add(new Label("country", new PropertyModel<Location>(item
						.getModel(), new StringResourceModel("country", this,
						null).getString())));
				item.add(new Label("status", new PropertyModel<Location>(item
						.getModel(), new StringResourceModel("status", this,
						null).getString())));
			}
		};

		userList.setVisible(true);
		add(userList);

		add(new AjaxPagingNavigator("navigator", userList));

		final Label exportCheck = new Label("exportCheck",
				"Successfully exported");
		exportCheck.setVisible(Boolean.FALSE);
		add(exportCheck);

		add(new Label("totalUsersCount", String.valueOf(users.size())));
		add(new Label("exportPath", config.getProperty("HR_EXPORT_FILE").toString()));

		Form<ShowUsers> form = new Form<ShowUsers>("form",
				new CompoundPropertyModel<ShowUsers>(this));

		Button exportButton = new Button("exportButton") {
			@Override
			public void onSubmit() {
				ServletContext servletContext = WebApplication.get()
						.getServletContext();
				String contextPath = servletContext.getContextPath();


				Object eFile = config.getProperty("HR_EXPORT_FILE");

				if(eFile !=null){
					LOG.info("Export file property is not null");

						if(!eFile.toString().isEmpty()){
							LOG.info("Export file property is not empty");
					try {
						LOG.info("Exporting data to export file");

						CsvWriter exporter = new CsvWriter(users, config
								.getProperty("HR_EXPORT_FILE").toString());
						exportCheck.setVisible(Boolean.TRUE);
					} catch (Exception e) {
						error(e.toString());
						throw new IllegalStateException("Exception while exporting HR data into '.csv' file: "
								+ e.getLocalizedMessage());
					}
						} else {

							throw new InvalidParameterException("The Export file path 'HR_EXPORT_FILE' is missing, please " +
									"append this parameter to the application property file or add this value as an environment " +
									"variable value");
						}
				} else {

				throw new InvalidParameterException("The Export file path 'HR_EXPORT_FILE' is missing, please " +
						"append this parameter to the application property file or add this value as an environment " +
						"variable value");
				}
			}
		};
		form.add(exportButton);
		add(form);
	}
}
