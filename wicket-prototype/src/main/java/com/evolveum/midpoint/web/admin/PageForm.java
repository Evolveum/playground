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

/**
 * @author lazyman
 */
public class PageForm extends PageAdmin {

    public PageForm() {
        add(new org.apache.wicket.devutils.debugbar.DebugBar("debug"));

        IModel<PropertyContainerWrapper> model = new LoadableModel<PropertyContainerWrapper>() {

            @Override
            protected PropertyContainerWrapper load() {
                PropertyContainer container = null;
                try {
                    URL url = PageForm.class.getClassLoader().getResource("com/test/resource.xml");
                    File file = new File(url.toURI());
                    ResourceType resource = ((JAXBElement<ResourceType>) JAXBUtil.unmarshal(file)).getValue();

                    container = createObject(resource);

                    PropertyDefinition def = container.getDefinition().getPropertyDefinitions().iterator().next();
                    Property property = def.instantiate();
                    property.addValue(new PropertyValue("value1"));
                    property.addValue(new PropertyValue("value2"));
                    System.out.println(property.getName().getLocalPart());
                    container.add(property);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                return new PropertyContainerWrapper(container, ContainerStatus.MODIFYING);
            }
        };

        final Form form = new Form("form");
        add(form);

        form.add(new ObjectFormPanel("containerForm", model));
        form.add(new FeedbackPanel("feedback"));
        form.add(new AjaxSubmitLinkButton("submit", new Model<String>("submit")) {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                target.add(form);
                System.out.println("onSubmit");
            }

            @Override
            protected void onError(AjaxRequestTarget target, Form<?> form) {
                target.add(form);
                System.out.println("onError");
            }
        });
    }

    private PropertyContainer createObject(ResourceType resource) throws Exception {
        //todo
        QName accountType = new QName("http://midpoint.evolveum.com/xml/ns/public/" +
                "resource/instance/10000000-0000-0000-0000-000000000003", "AccountObjectClass");

        Schema schema = Schema.parse(resource.getSchema().getAny().get(0)); //ResourceTypeUtil.getResourceSchema(resource);
        // schema.updateSchemaAccess(resource.getXmlObject().getSchemaHandling());
        ResourceObjectDefinition definition = (ResourceObjectDefinition) schema
                .findContainerDefinitionByType(accountType);
        if (definition == null) {
            throw new SchemaException("Account definition for type '" + accountType + "' was not found.");
        }

        return definition.instantiate();
    }
}
