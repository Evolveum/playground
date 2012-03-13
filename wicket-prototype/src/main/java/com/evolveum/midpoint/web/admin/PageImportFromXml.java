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

import com.evolveum.midpoint.schema.exception.SchemaException;
import com.evolveum.midpoint.schema.processor.*;
import com.evolveum.midpoint.schema.util.JAXBUtil;
import com.evolveum.midpoint.web.component.button.AjaxSubmitLinkButton;
import com.evolveum.midpoint.web.component.menu.left.LeftMenuItem;
import com.evolveum.midpoint.web.component.menu.top2.BottomMenuItem;
import com.evolveum.midpoint.web.component.objectform.ContainerStatus;
import com.evolveum.midpoint.web.component.objectform.ObjectFormPanel;
import com.evolveum.midpoint.web.component.objectform.PropertyContainerWrapper;
import com.evolveum.midpoint.web.component.util.LoadableModel;
import com.evolveum.midpoint.web.component.xml.ace.AceEditor;
import com.evolveum.midpoint.xml.ns._public.common.common_1.ResourceType;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;

/**
 * @author lazyman
 */
public class PageImportFromXml extends PageAdmin {
	private String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><query xmlns:yahoo=\"http://www.yahooapis.com/v1/base.rng\"yahoo:count=\"7\" yahoo:created=\"2011-10-11T08:40:23Z\" yahoo:lang=\"en-US\"><diagnostics><publiclyCallable>true</publiclyCallable><urlexecution-start-time=\"0\"execution-stop-time=\"25\"execution-time=\"25\"><![CDATA[http://where.yahooapis.com/v1/continents;start=0;count=10]]></url><user-time>26</user-time><service-time>25</service-time><build-version>21978</build-version></diagnostics><results><placexmlns=\"http://where.yahooapis.com/v1/schema.rng\"xml:lang=\"en-US\"yahoo:uri=\"http://where.yahooapis.com/v1/place/24865670\"><woeid>24865670</woeid><placeTypeNamecode=\"29\">Continent</placeTypeName><name>Africa</name></place><placexmlns=\"http://where.yahooapis.com/v1/schema.rng\"xml:lang=\"en-US\"yahoo:uri=\"http://where.yahooapis.com/v1/place/24865675\">woeid>24865675</woeid><placeTypeNamecode=\"29\">Continent</placeTypeName><name>Europe</name></place><placexmlns=\"http://where.yahooapis.com/v1/schema.rng\"xml:lang=\"en-US\"yahoo:uri=\"http://where.yahooapis.com/v1/place/24865673\"><woeid>24865673</woeid><placeTypeNamecode=\"29\"Continent</placeTypeName><name>SouthAmerica</name></place><placexmlns=\"http://where.yahooapis.com/v1/schema.rng\"xml:lang=\"en-US\"yahoo:uri=\"http://where.yahooapis.com/v1/place28289421\"><woeid>28289421</woeid><placeTypeNamecode=\"29\">Continent</placeTypeName><name>Antarctic</name></place><placexmlns=\"http://where.yahooapis.com/v1/schema.rng\"xml:lang=\"en-US\"yahoo:uri=\"http://where.yahooapis.com/v1/place/24865671\"><woeid>24865671</woeid><placeTypeNamecode=\"29\">Continent</placeTypeName><name>Asia</name></place><placexmlns=\"http://where.yahooapis.com/v1/schema.rng\"xml:lang=\"en-US\"yahoo:uri=\"http://where.yahooapis.com/v1/place/24865672\"><woeid>24865672</woeid><placeTypeNamecode=\"29\">Continent</placeTypeName><name>NorthAmerica</name></place><placexmlns=\"http://where.yahooapis.com/v1/schema.rng\"xml:lang=\"en-US\"yahoo:uri=\"http://where.yahooapis.com/v1/place/55949070\"><woeid>55949070</woeid><placeTypeNamecode=\"29\">Continent</placeTypeName><name>Australia</name></place></results></query>";

    public PageImportFromXml() {
    	IModel<String> model = new AbstractReadOnlyModel<String>() {

    		@Override
            public String getObject() {
            	return getXml();
            }
        };

    	final AceEditor<String> editor = new AceEditor<String>("aceEditor", model);
    	//add(editor);
    }
    
    public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
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
