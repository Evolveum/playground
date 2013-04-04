package com.evolveum.demo.login;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.evolveum.demo.hr.HomePage;

public class LoginPage extends WebPage{
	@SpringBean(name = "authenticationManager")
	private static AuthenticationManager authenticationManager;
	
	public LoginPage() {
		final LoginForm form = new LoginForm("loginForm");
		add(form);
	}

	private static class LoginForm extends StatelessForm {

		private static final long serialVersionUID = -6826853507535977683L;

		private String username;
		private String password;

		public LoginForm(String id) {
			super(id);
			
			setModel(new CompoundPropertyModel(this));
			add(new Label("usernameLabel", getString("login.username.label",null, "Username")));
			add(new RequiredTextField("username"));
			add(new Label("passwordLabel", getString("login.password.label",null, "Username")));
			add(new PasswordTextField("password"));
			add(new FeedbackPanel("feedback"));

		}

		@Override
		protected void onSubmit() {
//			AuthenticatedWebSession session = AuthenticatedWebSession.get();
//			if (session.signIn(username, password)) {
//				setDefaultResponsePageIfNecessary();
//			} else {
//				error(getString("login.failed.badcredentials"));
//			}
			
			Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	        if (authenticate.isAuthenticated()) {
	            SecurityContextHolder.getContext().setAuthentication(authenticate);  
	            setDefaultResponsePageIfNecessary();
	            
	        }
	        else {
	        	error(getString("login.failed.badcredentials"));
			}
		}

		private void setDefaultResponsePageIfNecessary() {
				setResponsePage(HomePage.class);
		}
	}
}
