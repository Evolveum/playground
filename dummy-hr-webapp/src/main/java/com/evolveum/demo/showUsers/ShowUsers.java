package com.evolveum.demo.showUsers;
import java.util.Properties;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.xml.stream.Location;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.protocol.http.WebApplication;

import com.evolveum.demo.connector.PostgresConnector;
import com.evolveum.demo.connector.UserService;
import com.evolveum.demo.exporter.CsvWriter;
import com.evolveum.demo.hr.HomePage;
import com.evolveum.demo.model.User;
import com.evolveum.demo.modifyUser.ModifyUser;

public class ShowUsers extends HomePage {
	ArrayList<User> users = null;
	
	public ShowUsers() {	
		try {
			users = userService.listAllUsers();
		} catch (SQLException e1) {
			log.error(e1.toString());
			error("Sql exception");
		}
		
		ListView<User> userList = new ListView<User>("users", users) {
			@Override
			protected void populateItem(ListItem<User> item) {

				Link view = new Link("view", item.getModel()) {
					public void onClick() {
						User c = (User) getModelObject();
						setResponsePage(new ModifyUser(c.getId()));
					}
				};

				item.add(view);
					
	                item.add(new Label("surname", new PropertyModel<Location>(item.getModel(),  new StringResourceModel("surname", this, null).getString()))); 
	                item.add(new Label("firstname", new PropertyModel<Location>(item.getModel(), new StringResourceModel("firstname", this, null).getString())));
	                item.add(new Label("emailAddress", new PropertyModel<Location>(item.getModel(), new StringResourceModel("emailAddress", this, null).getString())));
	                item.add(new Label("employeeNumber", new PropertyModel<Location>(item.getModel(), new StringResourceModel("employeeNumber", this, null).getString())));
	                item.add(new Label("id", new PropertyModel<Location>(item.getModel(), new StringResourceModel("id", this, null).getString())));
	            }
	        };

	        add(new Label("totalUsersCount", String.valueOf(users.size()))); 
	 
	        add(userList);

	        //String path =  this.getPath();

		Form<ShowUsers> form = new Form<ShowUsers>("form",new CompoundPropertyModel<ShowUsers>(this));
		
		Button exportButton = new Button("exportButton") {
			@Override
			public void onSubmit() {
				ServletContext servletContext = WebApplication.get()
						.getServletContext();
				String contextPath = servletContext.getContextPath();
				System.out.println();

				try {
					CsvWriter exporter = new CsvWriter(users, new StringResourceModel("exportPath", this, null).getString());
					System.out.println(new StringResourceModel(config.getProperty("exportPath").toString(), this, null).getString());
				} catch (IOException e) {
					e.printStackTrace();
					log.error(e.toString());
				}
			}
		};
		form.add(exportButton);
		add(form);
	}
}
