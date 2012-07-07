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

import com.evolveum.midpoint.forms.web.forms.interpreter.InterpreterException;
import com.evolveum.midpoint.forms.xml.*;
import com.evolveum.midpoint.util.exception.SystemException;
import org.apache.commons.lang.Validate;

import javax.xml.bind.JAXBElement;
import java.util.List;

/**
 * @author lazyman
 */
public class FormToken implements Token {

    private List<IncludeToken> includes;
    private List<ItemToken> items;

    public FormToken(FormType form) {
        Validate.notNull(form, "Form must not be null.");

        //initialize include tokens
        for (IncludeType include : form.getInclude()) {
            includes.add(new IncludeToken(include));
        }

        //initialize field, fieldGroup, fieldRef tokens
        for (JAXBElement<? extends FormItemType> element : form.getItem()) {
            FormItemType item = element.getValue();
            if (item instanceof FieldType) {
                items.add(new FieldToken((FieldType) item));
            } else if (item instanceof FieldGroupType) {
                items.add(new FieldGroupToken((FieldGroupType) item));
            } else if (item instanceof FieldReferenceType) {
                items.add(new FieldRefToken((FieldReferenceType) item));
            } else {
                throw new SystemException("Unsupported token type '" + item.getClass().getName() + "'.");
            }
        }
    }

    @Override
    public void interpret(FormToken form) throws InterpreterException {

    }
}
