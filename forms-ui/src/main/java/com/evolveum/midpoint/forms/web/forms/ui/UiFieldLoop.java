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

import com.evolveum.midpoint.forms.web.forms.FormModel;
import com.evolveum.midpoint.forms.web.forms.object.FieldLoopToken;
import org.apache.commons.lang.Validate;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * @author lazyman
 */
public class UiFieldLoop extends Panel {

    private IModel<FieldLoopToken> fieldLoop;
    private IModel<FormModel> formModel;

    public UiFieldLoop(String id, IModel<FieldLoopToken> fieldLoop, IModel<FormModel> formModel) {
        super(id);
        Validate.notNull(fieldLoop, "Field loop token model must not be null.");
        Validate.notNull(formModel, "Form model must not be null.");

        this.fieldLoop = fieldLoop;
        this.formModel = formModel;
    }
}
