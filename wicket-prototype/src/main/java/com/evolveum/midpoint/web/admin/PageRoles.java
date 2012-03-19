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

package com.evolveum.midpoint.web.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.evolveum.midpoint.web.component.accordions.Accordions;
import com.evolveum.midpoint.web.component.accordions.AccordionsNestedItem;
import com.evolveum.midpoint.web.component.accordions.AccordionsParentItem;
import com.evolveum.midpoint.web.component.accordions.AccordionsSettings;

/**
 * @author mserbak
 */
public class PageRoles extends PageAdmin {
	
    public PageRoles() {
    	AccordionsSettings accSettings = new AccordionsSettings(false, true, -1, false, false, -1, true);
    	List<AccordionsParentItem> itemsParent = new ArrayList<AccordionsParentItem>();
    	List<AccordionsNestedItem> itemsNested = new ArrayList<AccordionsNestedItem>();
    	
    	itemsNested.add(new AccordionsNestedItem("nesteeed", "<b>asdasdasd</b>"));
    	itemsNested.add(new AccordionsNestedItem("nesteeedasdasd", "<b>asdasdasd</b>"));
    	itemsNested.add(new AccordionsNestedItem("nesteeedasasd", "<b>asdaddsdasd</b>"));
    	
    	itemsParent.add(new AccordionsParentItem("aaaaaaaaaaaaa", "<b>aaa</b>", new ArrayList<AccordionsNestedItem>()));
    	itemsParent.add(new AccordionsParentItem("aaaaaaaaaaaaa", "bbbbbbbbbb", itemsNested));
    	itemsParent.add(new AccordionsParentItem("aaaaaaaaaaaaa", "bbbbbbbbbb", new ArrayList<AccordionsNestedItem>()));
    	itemsParent.add(new AccordionsParentItem("aaaaaaaaaaaaa", "bbbbbbbbbb", new ArrayList<AccordionsNestedItem>()));
    	itemsParent.add(new AccordionsParentItem("aaaaaaaaaaaaa", "bbbbbbbbbb", new ArrayList<AccordionsNestedItem>()));
    	itemsParent.add(new AccordionsParentItem("aaaaaaaaaaaaa", "bbbbbbbbbb", new ArrayList<AccordionsNestedItem>()));
    	
    	Accordions acc = new Accordions("accordions", itemsParent, accSettings);
    	add(acc);
    	
    	add(new BookmarkablePageLink<Void>("submit", PageSubmit.class));
    }
 
}
