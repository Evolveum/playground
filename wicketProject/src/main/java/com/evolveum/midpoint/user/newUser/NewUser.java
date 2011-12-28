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

package com.evolveum.midpoint.user.newUser;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

import com.evolveum.midpoint.HomePage;
import com.evolveum.midpoint.menu.common.MenuItem;
import com.evolveum.midpoint.user.UserPage;

public class NewUser extends HomePage {
	private static final long serialVersionUID = 1L;
	final FeedbackPanel feedback = new FeedbackPanel("feedback");

	public NewUser() {
		super();

		add(new TextField<String>("userName").setRequired(true));
		add(new TextField<String>("userGivenName").setRequired(true));
		add(new TextField<String>("userFamilyName").setRequired(true));
		add(new TextField<String>("userFullName").setRequired(true));
		add(new TextField<String>("userEmail").setRequired(false));
		add(new TextField<String>("userLocality").setRequired(false));
		add(new PasswordTextField("userPassword").setRequired(true));
		add(new PasswordTextField("userConfirmPassword").setRequired(true));
		add(new CheckBox("userEnable"));
		add(new CheckBox("userWebAccess"));

		add(new Button("cancelButton") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				setResponsePage(UserPage.class);
			}
		}.setDefaultFormProcessing(false));

		add(new Button("createButton") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				setResponsePage(UserPage.class);
			}
		}.setDefaultFormProcessing(false));

		setPrimaryMenuList(menu());
		setPageTitle("New user");
		setTitle("New user");
		add(feedback);
	}

	private List<MenuItem> menu() {
		MenuItem primaryMenu1 = new MenuItem("List user", UserPage.class);
		MenuItem primaryMenu2 = new MenuItem("New user", NewUser.class);

		// Create a List which contains the primary menu items in it.
		List<MenuItem> primaryMenuList = new ArrayList<MenuItem>();

		primaryMenuList.add(primaryMenu1);
		primaryMenuList.add(primaryMenu2);

		return primaryMenuList;
	}

}
