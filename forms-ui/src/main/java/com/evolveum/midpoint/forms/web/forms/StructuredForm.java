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

package com.evolveum.midpoint.forms.web.forms;

import com.evolveum.midpoint.forms.web.forms.interpreter.DefaultFormResolver;
import com.evolveum.midpoint.forms.web.forms.interpreter.FormInterpreter;
import com.evolveum.midpoint.forms.web.forms.interpreter.FormResolver;
import com.evolveum.midpoint.forms.web.forms.object.FormToken;
import com.evolveum.midpoint.forms.web.forms.object.ItemToken;
import com.evolveum.midpoint.forms.web.forms.ui.UiRegistry;
import com.evolveum.midpoint.util.logging.LoggingUtils;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import org.apache.commons.lang.Validate;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazyman
 */
public class StructuredForm extends Panel {

    private static final Trace LOGGER = TraceManager.getTrace(StructuredForm.class);
    private FormResolver formResolver;
    private IModel<FormToken> formToken;

    private IModel<FormModel> model;

    private boolean initialized;

    public StructuredForm(String id, IModel<FormModel> model) {
        super(id);
        Validate.notNull(model, "Form model must not be null.");
        this.model = model;
    }

    public FormResolver getFormResolver() {
        return formResolver;
    }

    public void setFormResolver(FormResolver formResolver) {
        this.formResolver = formResolver;
    }

    @Override
    protected void onBeforeRender() {
        super.onBeforeRender();

        if (initialized) {
            return;
        }

        //validate and updated form loaded from XML
        try {
            FormResolver resolver = new DefaultFormResolver(
                    "/home/lazyman/Work/evolveum/midpoint/playground/forms-ui/src/main/webapp/WEB-INF/forms/userForm.xml");
            //todo user class resolver
            FormInterpreter interpreter = new FormInterpreter(this, model);
            FormToken formToken = interpreter.interpret(resolver);

            this.formToken = new Model<FormToken>(formToken);

            initialized = true;
        } catch (Exception ex) {
            LoggingUtils.logException(LOGGER, "Error occurred during form loading", ex);
        }


        ListView<ItemToken> items = new ListView<ItemToken>("items", new AbstractReadOnlyModel() {

            @Override
            public List<ItemToken> getObject() {
                if (formToken == null || formToken.getObject() == null) {
                    return new ArrayList<ItemToken>();
                }

                FormToken form = formToken.getObject();
                return form.getItems();
            }
        }) {

            @Override
            protected void populateItem(ListItem<ItemToken> listItem) {
                //method for populating list with fields/field groups in main form (root)
                Component item = UiRegistry.createUiItem("item", listItem.getModel(), model);
                if (item == null) {
                    item = new Label("item");//todo add some warn stuff here
                }
                listItem.add(item);
            }
        };
        add(items);
    }
}
