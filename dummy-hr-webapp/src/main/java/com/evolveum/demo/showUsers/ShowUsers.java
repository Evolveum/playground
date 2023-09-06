package com.evolveum.demo.showUsers;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.xml.stream.Location;

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

import com.evolveum.demo.errorHandling.ErrorPage;
import com.evolveum.demo.exporter.CsvWriter;
import com.evolveum.demo.hr.HomePage;
import com.evolveum.demo.model.User;
import com.evolveum.demo.model.UserJpa;
import com.evolveum.demo.modifyUser.ModifyUser;

public class ShowUsers extends HomePage {
	public ArrayList<UserJpa> users;

	public ShowUsers() {
		users = (ArrayList<UserJpa>) userService.listUsers();

		PageableListView<UserJpa> userList = new PageableListView<UserJpa>(
				"users", users, 10) {
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
				item.add(new Label("responsibility",
						new PropertyModel<Location>(item.getModel(),
								new StringResourceModel("responsibility", this,
										null).getString())));
				item.add(new Label("emptype", new PropertyModel<Location>(item
						.getModel(), new StringResourceModel("emptype", this,
						null).getString())));
				item.add(new Label("orgpath", new PropertyModel<Location>(item
						.getModel(), new StringResourceModel("orgpath", this,
						null).getString())));
			}
		};

		userList.setVisible(true);
		add(userList);

		add(new AjaxPagingNavigator("navigator", userList));

		final Label exportCheck = new Label("exportCheck",
				"Sucessfully exported");
		exportCheck.setVisible(Boolean.FALSE);
		add(exportCheck);

		add(new Label("totalUsersCount", String.valueOf(users.size())));
		add(new Label("exportPath", config.getProperty("exportPath").toString()));

		Form<ShowUsers> form = new Form<ShowUsers>("form",
				new CompoundPropertyModel<ShowUsers>(this));

		Button exportButton = new Button("exportButton") {
			@Override
			public void onSubmit() {
				ServletContext servletContext = WebApplication.get()
						.getServletContext();
				String contextPath = servletContext.getContextPath();

				try {
					CsvWriter exporter = new CsvWriter(users, config
							.getProperty("exportPath").toString());
					exportCheck.setVisible(Boolean.TRUE);
				} catch (Exception e) {
					error(e.toString());
				}
			}
		};
		form.add(exportButton);
		add(form);
	}
}
