/*
 * Copyright (c) 2012 Evolveum
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://www.opensource.org/licenses/cddl1 or
 * CDDLv1.0.txt file in the source code distribution.
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 *
 * Portions Copyrighted 2012 [name of copyright owner]
 */

package com.evolveum.midpoint.web;

import com.evolveum.midpoint.repo.config.Service;
import com.evolveum.midpoint.spring.SomeService;
import com.evolveum.midpoint.web.admin.home.PageHome;
import com.evolveum.midpoint.web.admin.user.PageUser;
import com.evolveum.midpoint.web.page.error.PageForbidden;
import com.evolveum.midpoint.web.page.error.PageNotFound;
import com.evolveum.midpoint.web.page.error.PageServerError;
import com.evolveum.midpoint.web.page.error.PageUnauthorized;
import com.evolveum.midpoint.web.pretty.MidPointPageParametersEncoder;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.mapper.MountedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lazyman
 */
@Component("midpointApplication")
public class MidPointApplication extends WebApplication {

    @Autowired(required = true)
    SomeService service;
    @Autowired(required = true)
    Service repositoryService;

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

        //pretty url
        MidPointPageParametersEncoder encoder = new MidPointPageParametersEncoder();
        mount(new MountedMapper("/home", PageHome.class, encoder));
        mount(new MountedMapper("/user", PageUser.class, encoder));
        mount(new MountedMapper("/test", PageTest.class, encoder));

        //error pages
        mount(new MountedMapper("/error/401", PageUnauthorized.class, encoder));
        mount(new MountedMapper("/error/403", PageForbidden.class, encoder));
        mount(new MountedMapper("/error/404", PageNotFound.class, encoder));
        mount(new MountedMapper("/error/500", PageServerError.class, encoder));
    }

    public SomeService getService() {
        return service;
    }

    public Service getRepositoryService() {
        return repositoryService;
    }
}
