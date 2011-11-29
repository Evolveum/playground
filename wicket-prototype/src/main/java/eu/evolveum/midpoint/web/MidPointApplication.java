package eu.evolveum.midpoint.web;

import eu.evolveum.midpoint.web.admin.user.PageUser;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 *
 * @see eu.evolveum.midpoint.web.Start#main(String[])
 */
public class MidPointApplication extends WebApplication {
    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<PageUser> getHomePage() {
        return PageUser.class;
    }

    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init() {
        super.init();

        getMarkupSettings().setStripWicketTags(true);
        getResourceSettings().setThrowExceptionOnMissingResource(false);
    }
}
