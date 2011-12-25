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

package com.evolveum.midpoint.web.admin;

import com.evolveum.midpoint.schema.util.JAXBUtil;
import com.evolveum.midpoint.web.component.button.AjaxLinkButton;
import com.evolveum.midpoint.web.component.wizard.resource.ResourceWizard;
import com.evolveum.midpoint.xml.ns._public.common.common_1.ResourceType;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author lazyman
 */
public class PageWizard extends PageAdmin {

    public PageWizard() {
        initLayout();
    }

    private void initLayout() {
        final IModel<ResourceType> resource = new AbstractReadOnlyModel<ResourceType>() {

            ResourceType object = new ResourceType();

            @Override
            public ResourceType getObject() {
                return object;
            }
        };

        ResourceWizard wizard = new ResourceWizard("resourceWizard", resource);
        add(wizard);

        IModel<String> model = new AbstractReadOnlyModel<String>() {

            @Override
            public String getObject() {
                try {
                    return JAXBUtil.marshalWrap(resource.getObject());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                return null;
            }
        };
        final TextArea<String> editor = new TextArea<String>("createdResource", model);
        editor.setOutputMarkupId(true);
        add(editor);

        AjaxLinkButton refresh = new AjaxLinkButton("refresh", new Model<String>("Refresh")) {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.add(editor);
            }
        };
        add(refresh);
    }
}
