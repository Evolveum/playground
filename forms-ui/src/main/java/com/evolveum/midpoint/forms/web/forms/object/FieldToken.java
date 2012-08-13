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

import com.evolveum.midpoint.forms.web.forms.StructuredFormContext;
import com.evolveum.midpoint.forms.web.forms.interpreter.InterpreterException;
import com.evolveum.midpoint.forms.xml.FieldType;
import com.evolveum.midpoint.forms.xml.ReferenceType;
import com.evolveum.midpoint.prism.Item;

import java.util.Map;

/**
 * @author lazyman
 */
public class FieldToken extends BaseDisplayableFieldToken<FieldType> {

    public FieldToken(Token parent, FieldType field) {
        super(parent, field);
    }

    @Override
    public void interpret(StructuredFormContext context) throws InterpreterException {
        super.interpret(context);

        Map<String, Item> objects = context.getObjects();
//        ReferenceType ref = getField().getRef();
//        Item item = objects.get(ref.getKey());
//
//        if (item == null) {
//            //todo warn, ref is broken
//        }

        //todo implement
    }
}
