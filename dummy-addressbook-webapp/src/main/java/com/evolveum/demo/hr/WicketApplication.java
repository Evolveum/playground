package com.evolveum.demo.hr;

import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import com.evolveum.demo.connector.SecureWicketAuthenticatedWebSession;
import com.evolveum.demo.login.LoginPage;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see com.mycompany.Start#main(String[])
 */
public class WicketApplication extends AuthenticatedWebApplication  
{    	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return LoginPage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
        // Integrate Spring with Wicket
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
 
		// add your configuration here
	}

	@Override
	public Class<? extends WebPage> getSignInPageClass() {
		return HomePage.class;
	}

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
		 return SecureWicketAuthenticatedWebSession.class;
	}
	
}
