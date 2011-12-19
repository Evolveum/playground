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

package com.evolveum.midpoint;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.mapper.MountedMapper;
import org.odlabs.wiquery.core.WiQuerySettings;
import org.springframework.stereotype.Component;
import com.evolveum.midpoint.pretty.MidPointPageParametersEncoder;
import com.evolveum.midpoint.user.ContactsDatabase;
import com.evolveum.midpoint.user.ResultPage;
import com.evolveum.midpoint.user.UserPage;

/**
 * @author lazyman
 */
@Component("midpointApplication")
public class MidPointApplication extends WebApplication {
	private final ContactsDatabase contactsDB = new ContactsDatabase(50);

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();
		
		getMarkupSettings().setStripWicketTags(true);
		getResourceSettings().setThrowExceptionOnMissingResource(false);
		getDebugSettings().setDevelopmentUtilitiesEnabled(true);

		// pretty url
		MidPointPageParametersEncoder encoder = new MidPointPageParametersEncoder();
		mount(new MountedMapper("/home", HomePage.class, encoder));
		mount(new MountedMapper("/result", ResultPage.class, encoder));
		mount(new MountedMapper("/users", UserPage.class, encoder));
	}
	
	public ContactsDatabase getContactsDB() {
		return contactsDB;
	}

	public WiQuerySettings getWiQuerySettings() {
		WiQuerySettings settings = new WiQuerySettings();
		settings.setEnableWiqueryResourceManagement(true);
		return settings;
	}
}
