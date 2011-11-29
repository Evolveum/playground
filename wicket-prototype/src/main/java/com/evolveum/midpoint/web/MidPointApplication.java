package com.evolveum.midpoint.web;

import com.evolveum.midpoint.spring.SomeService;
import com.evolveum.midpoint.web.admin.user.PageUser;
import org.apache.wicket.protocol.http.WebApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lazyman
 */
@Component("midpointApplication")
public class MidPointApplication extends WebApplication {

    @Autowired(required = true)
    private SomeService service;

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

    public SomeService getService() {
        return service;
    }

    public void setService(SomeService service) {
        this.service = service;
    }
}
