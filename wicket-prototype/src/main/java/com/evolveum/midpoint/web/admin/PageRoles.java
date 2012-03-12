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

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.PropertyModel;

import com.evolveum.midpoint.web.component.xml.ace.AceEditor;

/**
 * @author lazyman
 */
public class PageRoles extends PageAdmin {
	private String xml = "aaaaaaaaaaa";
	
    public PageRoles() {
    	add(new BookmarkablePageLink<Void>("submit", PageSubmit.class));
    	add(new AceEditor<String>("aceEditor", new PropertyModel<String>(this, "xml")));
    }
    
    
   
}
