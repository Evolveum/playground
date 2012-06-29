package com.evolveum.midpoint.forms.web;

import com.evolveum.midpoint.forms.web.page.PageHome;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.springframework.stereotype.Component;

/**
 * @author lazyman
 */
@Component("midpointApplication")
public class MidPointApplication extends WebApplication {

    @Override
    protected void init() {
        super.init();

    }

    @Override
    public Class<? extends Page> getHomePage() {
        return PageHome.class;
    }
}
