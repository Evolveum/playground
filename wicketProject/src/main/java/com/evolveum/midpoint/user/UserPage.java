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

package com.evolveum.midpoint.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByBorder;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.evolveum.midpoint.HomePage;
import com.evolveum.midpoint.menu.common.MenuItem;

public class UserPage extends HomePage {
	private static final long serialVersionUID = 1L;

	public UserPage() {
		super();
		SortableContactDataProvider dp = new SortableContactDataProvider();

		final DataView<Contact> dataView = new DataView<Contact>("sorting", dp) {
			private static final long serialVersionUID = 1L;
			PageParameters pageParameters;

			@SuppressWarnings("deprecation")
			@Override
			protected void populateItem(final Item<Contact> item) {
				final Contact contact = item.getModelObject();
				item.add(new Link<Contact>("test", item.getModel()) {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						pageParameters = new PageParameters();
						pageParameters.add("user", String.valueOf(contact.getId()));
						setResponsePage(ResultPage.class, pageParameters);
					}
				}.add(new Label("linkTest", contact.getFirstName() + " " + contact.getLastName())));

				item.add(new Label("contactid", String.valueOf(contact.getId())));
				item.add(new Label("firstname", contact.getFirstName()));
				item.add(new Label("lastname", contact.getLastName()));
				item.add(new Label("homephone", contact.getHomePhone()));
				item.add(new Label("cellphone", contact.getCellPhone()));

				item.add(new AttributeModifier("class", true, new AbstractReadOnlyModel<String>() {
					private static final long serialVersionUID = 1L;

					@Override
					public String getObject() {
						return (item.getIndex() % 2 == 1) ? "even" : "odd";
					}
				}));
			}
		};

		dataView.setItemsPerPage(10);

		add(new OrderByBorder("orderByFirstName", "firstName", dp) {
			static final long serialVersionUID = 1L;

			@Override
			protected void onSortChanged() {
				dataView.setCurrentPage(dataView.getCurrentPage());
			}
		});

		add(new OrderByBorder("orderByLastName", "lastName", dp) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSortChanged() {
				dataView.setCurrentPage(dataView.getCurrentPage());
			}
		});

		add(dataView);
		add(new PagingNavigator("navigator", dataView));

		setPrimaryMenuList(menu());
		setPageTitle("Users");
		setTitle("Users");
	}

	private List<MenuItem> menu() {
		MenuItem primaryMenu1 = new MenuItem("Configuration", HomePage.class);
		MenuItem primaryMenu2 = new MenuItem("Debugging", HomePage.class);
		MenuItem primaryMenu3 = new MenuItem("Import and Export", HomePage.class);

		MenuItem menu11 = new MenuItem("Basic Configuration", UserPage.class);
		MenuItem menu12 = new MenuItem("Encryption", UserPage.class);
		MenuItem menu13 = new MenuItem("Logging Management", UserPage.class);

		MenuItem menu21 = new MenuItem("View/Edit Object", HomePage.class);
		MenuItem menu22 = new MenuItem("List Objects", HomePage.class);
		MenuItem menu23 = new MenuItem("XPath Debug", HomePage.class);

		MenuItem menu231 = new MenuItem("XPath Debug 1", HomePage.class);
		MenuItem menu232 = new MenuItem("XPath Debug 2", HomePage.class);

		MenuItem menu31 = new MenuItem("Import objects", UserPage.class);

		// Create a List which contains the primary menu items in it.
		List<MenuItem> primaryMenuList = new ArrayList<MenuItem>();
		List<MenuItem> subMenuList1 = new ArrayList<MenuItem>();
		List<MenuItem> subMenuList2 = new ArrayList<MenuItem>();
		List<MenuItem> subMenuList3 = new ArrayList<MenuItem>();
		List<MenuItem> subMenuList23 = new ArrayList<MenuItem>();

		primaryMenuList.add(primaryMenu1);
		primaryMenuList.add(primaryMenu2);
		primaryMenuList.add(primaryMenu3);

		subMenuList1.add(menu11);
		subMenuList1.add(menu12);
		subMenuList1.add(menu13);

		subMenuList2.add(menu21);
		subMenuList2.add(menu22);
		subMenuList2.add(menu23);

		subMenuList23.add(menu231);
		subMenuList23.add(menu232);

		subMenuList3.add(menu31);

		primaryMenu1.setSubMenuItemList(subMenuList1);
		primaryMenu2.setSubMenuItemList(subMenuList2);
		primaryMenu3.setSubMenuItemList(subMenuList3);
		menu23.setSubMenuItemList(subMenuList23);

		return primaryMenuList;
	}

}
