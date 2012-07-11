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

package com.evolveum.midpoint.forms.web.forms.object;

import com.evolveum.midpoint.forms.web.forms.FormModel;
import com.evolveum.midpoint.forms.web.forms.interpreter.InterpreterException;
import com.evolveum.midpoint.forms.xml.FieldReferenceType;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

/**
 * @author lazyman
 */
public class FieldRefToken extends ItemToken<FieldReferenceType> {

    private ItemToken referencedToken;

    public FieldRefToken(FieldReferenceType ref) {
        super(ref);
    }

    @Override
    public void interpret(IModel<FormModel> formModel, FormToken form) throws InterpreterException {
        //todo validate ref element

        //todo check recursion in here, resolve referenced token

        referencedToken = form.getFormItem(getItem().getAlias());
        if (referencedToken == null) {
            //todo exception
        }
    }

    public ItemToken getReferencedToken() {
        return referencedToken;
    }
}
