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
import com.evolveum.midpoint.forms.web.forms.interpreter.FormResolverException;
import com.evolveum.midpoint.forms.web.forms.interpreter.InterpreterException;
import com.evolveum.midpoint.forms.web.forms.model.FormModel;
import com.evolveum.midpoint.forms.web.forms.ui.UiFactory;
import com.evolveum.midpoint.forms.web.forms.ui.UiForm;
import com.evolveum.midpoint.forms.web.forms.ui.UiRegistry;
import com.evolveum.midpoint.forms.xml.DisplayType;
import com.evolveum.midpoint.forms.xml.FormType;
import com.evolveum.midpoint.util.logging.LoggingUtils;
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
import java.lang.reflect.InvocationTargetException;

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
        StringBuilder errorMessage = new StringBuilder();

        Component uiForm = null;
        try {
            uiForm = initForm();
        } catch (Exception ex) {
            //todo remove sysout !!!, print error to label and logs...
            createMessage(ex, errorMessage);
            LoggingUtils.logException(LOGGER, "Couldn't create form", ex);
        }

        if (uiForm == null) {
            uiForm = createErrorLabel(getString(StructuredForm.class.getSimpleName() + ".formError")
                    + " " + errorMessage.toString());
        }

        add(uiForm);
    }

    private Component initForm() throws FormResolverException, InterpreterException, NoSuchMethodException,
            IllegalAccessException, InstantiationException, InvocationTargetException {

        StructuredFormContext context = model.getObject();
        LOGGER.trace("Available form context {}.", new Object[]{(context != null ? context.toString() : null)});
        if (context == null) {
            return createErrorLabel("Structured form context must not be null."); //todo i18n
        }

        FormResolver resolver = context.getResolver();
        if (resolver == null) {
            return createErrorLabel("Form resolver in form context must not be null."); //todo i18n
        }

        FormType form = resolver.loadForm(context.getUser(), context.getObjects());
        if (form == null) {
            return createErrorLabel("Main form must not be null (was not found)."); //todo i18n
        }

        FormInterpreter interpreter = new FormInterpreter();
        FormModel formModel = interpreter.interpret(form, context);

        DisplayType formDisplay = form.getDisplay();
        String formType = formDisplay != null ? formDisplay.getType() : null;
        LOGGER.debug("Using {} as form type.", new Object[]{formType});

        Class<?> formClass = UiRegistry.getForm(formType);
        if (formClass == null) {
            return createErrorLabel("Form class '" + formType + "' was not found."); //todo i18n
        }

        Constructor<UiForm> constructor = (Constructor<UiForm>) formClass.getConstructor(String.class, IModel.class);
        return constructor.newInstance(COMPONENT_ID_FORM, new Model<FormModel>(formModel));
    }

    private Component createErrorLabel(final String message) {
        Component label = UiFactory.createErrorLabel(COMPONENT_ID_FORM, new AbstractReadOnlyModel<String>() {

            @Override
            public String getObject() {
                return message;
            }
        });

        label.add(new AttributeModifier("style", "color: #f00;"));

        return label;
    }

    private String createMessage(Throwable ex, StringBuilder builder) {
        builder.append("Caused by: \"");
        builder.append(ex.getMessage());
        builder.append("\" ");

        if (ex.getCause() != null) {
            createMessage(ex.getCause(), builder);
        }

        return builder.toString();
    }
}
