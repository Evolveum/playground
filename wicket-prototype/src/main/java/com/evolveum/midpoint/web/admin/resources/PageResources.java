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

package com.evolveum.midpoint.web.admin.resources;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.evolveum.midpoint.web.admin.PageAdmin;
import com.evolveum.midpoint.web.admin.PageImportFromFile;
import com.evolveum.midpoint.web.admin.PageImportFromXml;
import com.evolveum.midpoint.web.admin.PageLogging;
import com.evolveum.midpoint.web.admin.PageTasks;
import com.evolveum.midpoint.web.admin.home.PageHome;
import com.evolveum.midpoint.web.component.menu.left.LeftMenuItem;
import com.evolveum.midpoint.web.component.menu.top2.BottomMenuItem;

/**
 * @author lazyman
 */
public class PageResources extends PageAdmin {
    
	
	public PageResources() {
		add(new BookmarkablePageLink<Void>("tasks", PageLogging.class));
	}
	
	
    @Override
    public List<LeftMenuItem> getLeftMenuItems() {
        return new ArrayList<LeftMenuItem>();
    }
    
    @Override
    public List<BottomMenuItem> getBottomMenuItems() {
    	List<BottomMenuItem> items = new ArrayList<BottomMenuItem>();

        items.add(new BottomMenuItem("pageAdmin.users.importFromXml", PageImportFromXml.class));
        items.add(new BottomMenuItem("pageAdmin.users.importFromFile", PageImportFromFile.class));

        return items;
        
    }
   
}
