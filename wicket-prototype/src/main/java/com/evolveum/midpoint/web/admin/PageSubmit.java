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
import com.evolveum.midpoint.web.component.objectform.ContainerStatus;
import com.evolveum.midpoint.web.component.objectform.ObjectFormPanel;
import com.evolveum.midpoint.web.component.objectform.PropertyContainerWrapper;
import com.evolveum.midpoint.web.component.util.LoadableModel;
import com.evolveum.midpoint.xml.ns._public.common.common_1.ResourceType;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
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
public class PageSubmit extends PageAdmin {

    public PageSubmit() {
    	
    }
    
    @Override
    public List<LeftMenuItem> getLeftMenuItems() {
        return new ArrayList<LeftMenuItem>();
    }
}
