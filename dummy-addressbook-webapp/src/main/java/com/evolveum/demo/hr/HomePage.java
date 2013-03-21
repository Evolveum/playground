package com.evolveum.demo.hr;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TimeZone;

import javax.xml.stream.Location;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.evolveum.demo.connector.Clock;
import com.evolveum.demo.connector.HelloWorldService;
import com.evolveum.demo.connector.PeopleService;
import com.evolveum.demo.errorHandling.ErrorPage;
import com.evolveum.demo.model.People;

@AuthorizeInstantiation("ROLE_ADMIN")
public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	public static transient Configuration config ;
	public static Logger log = Logger.getLogger(HomePage.class.getName());
	
	
	public static transient PeopleService peopleService = PeopleService.getInstance();
	ArrayList<People> people;
	
	@SpringBean
	private HelloWorldService helloWorldService;
	
	public HomePage() {
        
        try {
			config = new PropertiesConfiguration("application.properties");
		} catch (ConfigurationException e) {
			e.printStackTrace();
			log.error(e.toString());
		}
        
        try {
        	people = peopleService.listAllUsers();
		} catch (SQLException e1) {
			redirectToInterceptPage(new ErrorPage("from SQL " + e1.getMessage()));
		}
        
        initGui();
    }
	
	private void initGui(){
		System.out.println(helloWorldService.sayHello());
		
		add(new BookmarkablePageLink("home", HomePage.class));
        add(new Label("footer", new StringResourceModel("footer", this, null)));
        add(new FeedbackPanel("feedbackPanel"));

		Clock clock = new Clock("clock", TimeZone.getTimeZone("America/Los_Angeles"));
        add(clock);
        
        PageableListView<People> userList = new PageableListView<People>("people", people, 10) {
        	
			@Override
			protected void populateItem(ListItem<People> item) {

					item.add(new Label("username", new PropertyModel<Location>(item.getModel(),  new StringResourceModel("username", this, null).getString()))); 
					item.add(new Label("first_name", new PropertyModel<Location>(item.getModel(),  new StringResourceModel("first_name", this, null).getString()))); 
					item.add(new Label("last_name", new PropertyModel<Location>(item.getModel(),  new StringResourceModel("last_name", this, null).getString()))); 
					item.add(new Label("tel_number", new PropertyModel<Location>(item.getModel(),  new StringResourceModel("tel_number", this, null).getString()))); 
					item.add(new Label("fax_number", new PropertyModel<Location>(item.getModel(),  new StringResourceModel("fax_number", this, null).getString()))); 
					item.add(new Label("office_id", new PropertyModel<Location>(item.getModel(),  new StringResourceModel("office_id", this, null).getString()))); 
					item.add(new Label("floor", new PropertyModel<Location>(item.getModel(),  new StringResourceModel("floor", this, null).getString()))); 
					item.add(new Label("street_address", new PropertyModel<Location>(item.getModel(),  new StringResourceModel("street_address", this, null).getString()))); 
					item.add(new Label("city", new PropertyModel<Location>(item.getModel(),  new StringResourceModel("city", this, null).getString()))); 
					item.add(new Label("country", new PropertyModel<Location>(item.getModel(),  new StringResourceModel("country", this, null).getString()))); 
					item.add(new Label("postal_code", new PropertyModel<Location>(item.getModel(),  new StringResourceModel("postal_code", this, null).getString()))); 
					item.add(new Label("validity", new PropertyModel<Location>(item.getModel(),  new StringResourceModel("validity", this, null).getString()))); 
					item.add(new Label("created", new PropertyModel<Location>(item.getModel(),  new StringResourceModel("created", this, null).getString()))); 
					item.add(new Label("modified", new PropertyModel<Location>(item.getModel(),  new StringResourceModel("modified", this, null).getString()))); 
					item.add(new Label("password", new PropertyModel<Location>(item.getModel(),  new StringResourceModel("password", this, null).getString()))); 
				
	            }
	        };
	        add(userList);
	        add(new AjaxPagingNavigator("navigator", userList));
	}
	
}
