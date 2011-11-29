/*
 * Copyright (c) 2011 Evolveum
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
 * Portions Copyrighted 2011 [name of copyright owner]
 */

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
