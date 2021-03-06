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

package com.evolveum.midpoint.server;

import java.util.ArrayList;
import java.util.List;

import com.evolveum.midpoint.HomePage;
import com.evolveum.midpoint.menu.common.MenuItem;

public class ServerTasks extends HomePage {
	private static final long serialVersionUID = 1L;

	public ServerTasks() {
		super();

		setPrimaryMenuList(menu());
		setPageTitle("Server tasks");
		setTitle("Server task list");
	}

	private List<MenuItem> menu() {
		MenuItem primaryMenu1 = new MenuItem("Server task list", ServerTasks.class);
		MenuItem primaryMenu2 = new MenuItem("Add task", ServerTasks.class);
		
		// Create a List which contains the primary menu items in it.
		List<MenuItem> primaryMenuList = new ArrayList<MenuItem>();

		primaryMenuList.add(primaryMenu1);
		primaryMenuList.add(primaryMenu2);

		return primaryMenuList;
	}

}
