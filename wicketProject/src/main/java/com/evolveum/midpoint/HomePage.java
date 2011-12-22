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

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.PropertyModel;

import com.evolveum.midpoint.menu.common.MenuItem;
import com.evolveum.midpoint.menu.multiLevelCss.MultiLevelCssMenu;
import com.evolveum.midpoint.user.UserPage;

public class HomePage extends WebPage {
	private String pageTitle = "MidPoint wicket template";
	private String title = "Home page";
	List<MenuItem> primaryMenuList = null;
	private static final long serialVersionUID = 1L;

	public HomePage() {
		add(new Label("pageTitle", new PropertyModel<String>(this, "pageTitle")));
		add(new Label("title", new PropertyModel<String>(this, "title")));
		add(new BookmarkablePageLink<Void>("navigateHome", HomePage.class));
		add(new BookmarkablePageLink<Void>("navigateUsers", UserPage.class));
		add(new BookmarkablePageLink<Void>("navigateResources", HomePage.class));
		add(new BookmarkablePageLink<Void>("navigateServers", HomePage.class));

		if (primaryMenuList == null) {
			add(new MultiLevelCssMenu("multiLevelCssMenu", ""));
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public final String getPageTitle() {
		return pageTitle;
	}

	public final void setPageTitle(String title) {
		pageTitle = title + " - MidPoint wicket template";
	}

	public List<MenuItem> getPrimaryMenuList() {
		return primaryMenuList;
	}

	public void setPrimaryMenuList(List<MenuItem> primaryMenuList) {
		buildMenu(primaryMenuList);
	}

	private void buildMenu(List<MenuItem> primaryMenuList) {
		this.primaryMenuList = primaryMenuList;
		replace(new MultiLevelCssMenu("multiLevelCssMenu", primaryMenuList));
	}

}