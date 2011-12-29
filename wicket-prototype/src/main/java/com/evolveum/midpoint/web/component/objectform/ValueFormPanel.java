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

package com.evolveum.midpoint.web.component.objectform;

import com.evolveum.midpoint.schema.processor.PropertyValue;
import com.evolveum.midpoint.web.component.autoform.custom.TextPanel;
import org.apache.commons.lang.Validate;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * @author lazyman
 */
public class ValueFormPanel extends Panel {

    private IModel<PropertyValue> model;
    private boolean isNewObject;

    public ValueFormPanel(String id, IModel<PropertyValue> model) {
        this(id, model, false);
    }

    public ValueFormPanel(String id, IModel<PropertyValue> model, boolean isNewObject) {
        super(id);
        Validate.notNull(model, "Property value model must not be null.");

        this.model = model;
        this.isNewObject = isNewObject;

        initLayout();
    }

    private void initLayout() {
        //input
        add(new TextPanel<String>("input", new PropertyModel<String>(model, "value")));

        //buttons
        add(new AjaxLink("addButton") {

            @Override
            public void onClick(AjaxRequestTarget target) {
                addValue(target);
            }
        });
        add(new AjaxLink("removeButton") {

            @Override
            public void onClick(AjaxRequestTarget target) {
                removeValue(target);
            }
        });

        //feedback
        add(new FeedbackPanel("feedback"));
    }

    private void addValue(AjaxRequestTarget target) {

    }

    private void removeValue(AjaxRequestTarget target) {

    }
}
