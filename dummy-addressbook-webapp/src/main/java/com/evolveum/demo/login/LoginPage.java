package com.evolveum.demo.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.protocol.http.servlet.ServletWebRequest;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.security.authentication.AuthenticationManager;

public class LoginPage extends WebPage{
	@SpringBean(name = "authenticationManager")
	private static AuthenticationManager authenticationManager; 
	   
	
	public LoginPage() {
		add(new Label("usernameLabel", getString("login.username.label",null, "Username")));
		add(new Label("passwordLabel", getString("login.password.label",null, "Username")));
		add(new FeedbackPanel("feedback"));
		
		 String message = getSpringSecurityExceptionMessageAndRemoveException();
	     Label reasonLabel = new Label("reason", message);
	     reasonLabel.setVisible(message != null);
	     add(reasonLabel);
        
	}
	
	protected String getSpringSecurityExceptionMessageAndRemoveException() {
        HttpServletRequest request = (HttpServletRequest) getRequest().getContainerRequest();   

        HttpSession session = request.getSession(false);
        Object ex = null;
        if (session != null) {
                ex = session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
                if (ex != null) {
                        session.removeAttribute("SPRING_SECURITY_LAST_EXCEPTION");
                }
        }
        
        String result = null;
        if (ex != null) {
            result = "username or password value you entered is incorrect.";
        }
                return result;
    }


}
