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

import com.evolveum.midpoint.forms.web.forms.interpreter.FormInterpreter;
import com.evolveum.midpoint.forms.web.forms.interpreter.FormResolver;
import com.evolveum.midpoint.forms.web.forms.model.FormModel;
import com.evolveum.midpoint.forms.web.forms.ui.UiFactory;
import com.evolveum.midpoint.forms.web.forms.ui.UiForm;
import com.evolveum.midpoint.forms.web.forms.ui.UiRegistry;
import com.evolveum.midpoint.forms.xml.DisplayType;
import com.evolveum.midpoint.forms.xml.FormType;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import org.apache.commons.lang.Validate;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.lang.reflect.Constructor;

/**
 * @author lazyman
 */
public class StructuredForm extends Panel {

    private static final Trace LOGGER = TraceManager.getTrace(StructuredForm.class);
    private static final String COMPONENT_ID_FORM = "form";
    private IModel<StructuredFormContext> model;
    private boolean initialized;

    public StructuredForm(String id, IModel<StructuredFormContext> model) {
        super(id);
        Validate.notNull(model, "Structured form context model must not be null.");

        this.model = model;
    }

    @Override
    protected void onBeforeRender() {
        super.onBeforeRender();

        if (initialized) {
            return;
        }

        initLayout();
        initialized = true;
    }

    private void initLayout() {
        final StringBuilder errorMessage = new StringBuilder();

        Component uiForm = null;
        try {
            StructuredFormContext context = model.getObject();
            LOGGER.debug("Available form context {}.", new Object[]{context.toString()});
            //todo remove validate
            Validate.notNull(context, "Structured form context must not be null.");
            FormResolver resolver = context.getResolver();
            //todo remove validate
            Validate.notNull(resolver, "Form resolver in form context must not be null.");

            FormType form = resolver.loadForm(context.getUser(), context.getObjects());
            //todo remove validate
            Validate.notNull(form, "Main form must not be null (was not found).");
            //check ci nie je form null...

            FormInterpreter interpreter = new FormInterpreter();
            FormModel formModel = interpreter.interpret(form, context);

            DisplayType formDisplay = form.getDisplay();
            String formType = formDisplay != null ? formDisplay.getType() : null;
            Class<?> formClass = UiRegistry.getForm(formType);
            if (formClass == null || (UiForm.class.isAssignableFrom(formClass))) {
                //todo write some error about bad FormType-> type attribute...
            }

            LOGGER.debug("Using {} as form type.", new Object[]{formClass.getName()});
            Constructor<UiForm> constructor = (Constructor<UiForm>) formClass.getConstructor(String.class, IModel.class);
            uiForm = constructor.newInstance(COMPONENT_ID_FORM, new Model<FormModel>(formModel));
        } catch (Exception ex) {
            //todo remove sysout !!!, print error to label and logs...
            ex.printStackTrace();
            createMessage(ex, errorMessage);
        }

        if (uiForm == null) {
            uiForm = UiFactory.createErrorLabel(COMPONENT_ID_FORM, new AbstractReadOnlyModel<String>() {

                @Override
                public String getObject() {
                    return getString(StructuredForm.class.getSimpleName() + ".formError")
                            + " " + errorMessage.toString();
                }
            });
            uiForm.add(new AttributeModifier("class", "UiFormError"));
        }
        add(uiForm);
    }

    private String createMessage(Throwable ex, StringBuilder builder) {
        builder.append(ex.getMessage());

        if (ex.getCause() != null) {
            builder.append("Cause by: ");
            builder.append(createMessage(ex.getCause(), builder));
            builder.append(" ");
        }

        return builder.toString();
    }
}
