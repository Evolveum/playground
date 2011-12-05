package com.evolveum.midpoint;


import org.apache.wicket.Session;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.https.HttpsConfig;
import org.apache.wicket.protocol.https.HttpsRequestCycleProcessor;
import org.apache.wicket.request.IRequestCycleProcessor;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 */
public class WicketApplication  extends WebApplication
{    	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		// add your configuration here
	}


    protected IRequestCycleProcessor newRequestCycleProcessor() {
        HttpsConfig config = new HttpsConfig();
        config.setHttpPort(8080);
        config.setHttpsPort(8443);

        return new HttpsRequestCycleProcessor(config);
    }

    @Override
    public Session newSession(Request request, Response response) {
        return new WicketHttpsSession(request);
    }
}
