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

package com.evolveum.midpoint.forms.impl.interpreter;

import com.evolveum.midpoint.forms.impl.StructuredFormContext;
import com.evolveum.midpoint.forms.impl.model.FormModel;
import com.evolveum.midpoint.forms.impl.token.FormToken;
import com.evolveum.midpoint.xml.ns._public.gui.form_1.FormType;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;

/**
 * @author lazyman
 */
public class FormInterpreter {

    private static final Trace LOGGER = TraceManager.getTrace(FormInterpreter.class);

    public FormModel interpret(FormType form, InterpreterContext iContext, StructuredFormContext context) throws InterpreterException {
        LOGGER.debug("interpret::begin");
        FormToken formToken = new FormToken(form);
        formToken.interpret(iContext, context);
        LOGGER.debug("interpret:end");

        FormModel model = new FormModel(formToken);
//        context.setFormModel(model);

        return model;
    }
}
