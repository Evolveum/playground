package com.evolveum.demo.hr;

import java.util.TimeZone;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.StringResourceModel;

import com.evolveum.demo.connector.Clock;
import com.evolveum.demo.connector.UserService;
import com.evolveum.demo.registerUser.RegisterUser;
import com.evolveum.demo.showUsers.ShowUsers;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	public static transient Configuration config ;
	public static Logger log = Logger.getLogger(HomePage.class.getName());
	
	public static transient UserService userService = UserService.getInstance();

	public HomePage() {
		initGui();
        
        try {
			config = new PropertiesConfiguration("application.properties");
		} catch (ConfigurationException e) {
			e.printStackTrace();
			log.error(e.toString());
		}
    }
	
	private void initGui(){
		add(new BookmarkablePageLink("register", RegisterUser.class));
		add(new BookmarkablePageLink("show", ShowUsers.class));
		add(new BookmarkablePageLink("home", HomePage.class));
        add(new Label("footer", new StringResourceModel("footer", this, null)));
        add(new FeedbackPanel("feedbackPanel"));

		Clock clock = new Clock("clock", TimeZone.getTimeZone("America/Los_Angeles"));
        add(clock);
	}
	
}
