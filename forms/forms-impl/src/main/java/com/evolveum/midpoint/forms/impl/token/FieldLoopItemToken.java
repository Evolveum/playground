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

package com.evolveum.midpoint.forms.impl.token;

import com.evolveum.midpoint.forms.impl.StructuredFormContext;
import com.evolveum.midpoint.forms.impl.interpreter.InterpreterContext;
import com.evolveum.midpoint.forms.impl.interpreter.InterpreterException;
import com.evolveum.midpoint.xml.ns._public.gui.form_1.BaseFieldType;
import com.evolveum.midpoint.xml.ns._public.gui.form_1.FieldLoopType;
import com.evolveum.midpoint.prism.PrismContainer;

import javax.xml.bind.JAXBElement;

/**
 * @author lazyman
 */
public class FieldLoopItemToken extends BaseGroupFieldToken<FieldLoopType> {

    private int index;

    public FieldLoopItemToken(FieldLoopToken parent, int index) {
        super(parent, parent.getField());

        this.index = index;
    }

    @Override
    public void interpret(InterpreterContext interpreterContext, StructuredFormContext context) throws InterpreterException {
        FieldLoopToken parent = getParent();
        PrismContainer container = parent.getContainer();
        if (container == null) {
            throw new InterpreterException("Prism container referenced by field loop '" + parent + "' is null.");
        }

        if (container.getValues().size() <= index) {
            throw new InterpreterException("Value index out of bound for prism container, field loop '" + parent + "'.");
        }

        FieldLoopType fieldLoop = parent.getField();
        for (JAXBElement<? extends BaseFieldType> element : fieldLoop.getItem()) {
            BaseFieldType item = element.getValue();

            BaseFieldToken token = TokenUtils.createItemToken(this, item);
            getFields().add(token);
            token.interpret(interpreterContext, context);
        }
    }

    public int getIndex() {
        return index;
    }

    @Override
    public FieldLoopToken getParent() {
        //todo fix this through proper generics handling
        return (FieldLoopToken) super.getParent();
    }
}
