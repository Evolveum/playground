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

import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import com.evolveum.midpoint.web.component.xml.ace.AceEditor;

/**
 * @author lazyman
 */
public class PageRoles extends PageAdmin {
	private String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><query xmlns:yahoo=\"http://www.yahooapis.com/v1/base.rng\"yahoo:count=\"7\" yahoo:created=\"2011-10-11T08:40:23Z\" yahoo:lang=\"en-US\"><diagnostics><publiclyCallable>true</publiclyCallable><urlexecution-start-time=\"0\"execution-stop-time=\"25\"execution-time=\"25\"><![CDATA[http://where.yahooapis.com/v1/continents;start=0;count=10]]></url><user-time>26</user-time><service-time>25</service-time><build-version>21978</build-version></diagnostics><results><placexmlns=\"http://where.yahooapis.com/v1/schema.rng\"xml:lang=\"en-US\"yahoo:uri=\"http://where.yahooapis.com/v1/place/24865670\"><woeid>24865670</woeid><placeTypeNamecode=\"29\">Continent</placeTypeName><name>Africa</name></place><placexmlns=\"http://where.yahooapis.com/v1/schema.rng\"xml:lang=\"en-US\"yahoo:uri=\"http://where.yahooapis.com/v1/place/24865675\">woeid>24865675</woeid><placeTypeNamecode=\"29\">Continent</placeTypeName><name>Europe</name></place><placexmlns=\"http://where.yahooapis.com/v1/schema.rng\"xml:lang=\"en-US\"yahoo:uri=\"http://where.yahooapis.com/v1/place/24865673\"><woeid>24865673</woeid><placeTypeNamecode=\"29\"Continent</placeTypeName><name>SouthAmerica</name></place><placexmlns=\"http://where.yahooapis.com/v1/schema.rng\"xml:lang=\"en-US\"yahoo:uri=\"http://where.yahooapis.com/v1/place28289421\"><woeid>28289421</woeid><placeTypeNamecode=\"29\">Continent</placeTypeName><name>Antarctic</name></place><placexmlns=\"http://where.yahooapis.com/v1/schema.rng\"xml:lang=\"en-US\"yahoo:uri=\"http://where.yahooapis.com/v1/place/24865671\"><woeid>24865671</woeid><placeTypeNamecode=\"29\">Continent</placeTypeName><name>Asia</name></place><placexmlns=\"http://where.yahooapis.com/v1/schema.rng\"xml:lang=\"en-US\"yahoo:uri=\"http://where.yahooapis.com/v1/place/24865672\"><woeid>24865672</woeid><placeTypeNamecode=\"29\">Continent</placeTypeName><name>NorthAmerica</name></place><placexmlns=\"http://where.yahooapis.com/v1/schema.rng\"xml:lang=\"en-US\"yahoo:uri=\"http://where.yahooapis.com/v1/place/55949070\"><woeid>55949070</woeid><placeTypeNamecode=\"29\">Continent</placeTypeName><name>Australia</name></place></results></query>";
	IModel<String> model = new AbstractReadOnlyModel<String>() {

		@Override
        public String getObject() {
        	return getXml();
        }
    };
	
	
    public PageRoles() {
    	add(new BookmarkablePageLink<Void>("submit", PageSubmit.class));
    	final AceEditor<String> editor = new AceEditor<String>("aceEditor", model);
    	//add(editor);
    }

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}
    
    
   
}
