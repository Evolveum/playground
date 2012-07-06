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
import com.evolveum.midpoint.util.logging.LoggingUtils;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import org.apache.commons.lang.Validate;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * @author lazyman
 */
public class StructuredForm extends Panel {

    private static final Trace LOGGER = TraceManager.getTrace(StructuredForm.class);

    public StructuredForm(String id, IModel<FormModel> model) {
        super(id);
        Validate.notNull(model, "Form model must not be null.");

        try {
            FormInterpreter interpreter = new FormInterpreter(this, model);

        } catch (Exception ex) {
            LoggingUtils.logException(LOGGER, "Error occurred during form loading", ex);
        }
    }
}
