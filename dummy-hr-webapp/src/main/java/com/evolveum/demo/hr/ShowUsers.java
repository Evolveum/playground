package com.evolveum.demo.hr;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.xml.stream.Location;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.protocol.http.WebApplication;

import com.evolveum.demo.connector.PostgresConnector;
import com.evolveum.demo.connector.UserService;
import com.evolveum.demo.exporter.CsvWriter;
import com.evolveum.demo.model.User;

public class ShowUsers extends HomePage {
	
	public ShowUsers() {
		PostgresConnector pgc = new PostgresConnector();
		
		UserService userService = new UserService(pgc.connect());
		ArrayList<User> users = userService.listAllUsers();
		
	        ListView<User> userList = new ListView<User>("users", users) { 
				@Override
	            protected void populateItem(ListItem<User> item) {             
					
					Link view = new Link("view", item.getModel()) {
	                    public void onClick() {
	                        User c = (User) getModelObject();
	                        setResponsePage(new ModifyUser(c.getId()));
	                    }
	                };
	                
	                //view.add(new Label("id", new PropertyModel<Location>(item.getModel(), "id")));
					
					item.add(view);
					
	                item.add(new Label("givenName", new PropertyModel<Location>(item.getModel(), "givenName"))); 
	                item.add(new Label("fullName", new PropertyModel<Location>(item.getModel(), "fullName")));
	                item.add(new Label("emailAddress", new PropertyModel<Location>(item.getModel(), "emailAddress")));
	                item.add(new Label("employeeNumber", new PropertyModel<Location>(item.getModel(), "employeeNumber")));
	                item.add(new Label("id", new PropertyModel<Location>(item.getModel(), "id")));
	            }
	        };
	 
	        add(userList);
	        
	       
	        
	        //String path =  this.getPath();

	        	ServletContext servletContext = WebApplication.get().getServletContext();
	        	String contextPath = servletContext.getContextPath();
	        	
				try {
					CsvWriter exporter = new CsvWriter(users);
				} catch (IOException e) {
					e.printStackTrace();
				}
			

	}
}
