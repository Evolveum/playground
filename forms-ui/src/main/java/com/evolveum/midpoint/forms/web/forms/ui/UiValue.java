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

package com.evolveum.midpoint.forms.web.forms.ui;

import com.evolveum.midpoint.forms.web.forms.model.ValueModel;
import com.evolveum.midpoint.forms.web.forms.ui.widget.TextWidget;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author lazyman
 */
public class UiValue extends Panel {

    private IModel<ValueModel> model;
    private boolean initialized;

    public UiValue(String id, IModel<ValueModel> model) {
        super(id);
        this.model = model;
    }

    @Override
    protected void onBeforeRender() {
        super.onBeforeRender();

        if (!initialized) {
            initLayout();
            initialized = true;
        }
    }

    protected void initLayout() {
        model.getObject();

        IModel<String> label = new Model<String>("fullName");
        add(new Label("label", label));

        add(new TextWidget("widget", new Model<String>()));
    }
}
