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

package com.evolveum.midpoint.configuration;

import java.util.ArrayList;
import java.util.List;

import com.evolveum.midpoint.HomePage;
import com.evolveum.midpoint.menu.common.MenuItem;

public class Configuration extends HomePage {
	private static final long serialVersionUID = 1L;

	public Configuration() {
		super();

		setPrimaryMenuList(menu());
		setPageTitle("Configuration");
		setTitle("Basic configuration");
	}

	private List<MenuItem> menu() {
		MenuItem primaryMenu1 = new MenuItem("Configuration", Configuration.class);
		MenuItem primaryMenu2 = new MenuItem("Debugging", Configuration.class);
		MenuItem primaryMenu3 = new MenuItem("Import and Export", Configuration.class);

		MenuItem menu11 = new MenuItem("Basic Configuration", Configuration.class);
		MenuItem menu12 = new MenuItem("Encryption", Configuration.class);
		MenuItem menu13 = new MenuItem("Logging Management", Configuration.class);

		MenuItem menu21 = new MenuItem("View/Edit Object", Configuration.class);
		MenuItem menu22 = new MenuItem("List Objects", Configuration.class);
		MenuItem menu23 = new MenuItem("XPath Debug", Configuration.class);

		MenuItem menu231 = new MenuItem("XPath Debug 1", Configuration.class);
		MenuItem menu232 = new MenuItem("XPath Debug 2", Configuration.class);

		MenuItem menu31 = new MenuItem("Import objects", Configuration.class);

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
