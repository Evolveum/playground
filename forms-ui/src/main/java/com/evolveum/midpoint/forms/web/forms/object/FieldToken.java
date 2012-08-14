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
import com.evolveum.midpoint.prism.*;
import com.evolveum.midpoint.schema.holder.XPathHolder;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * @author lazyman
 */
public class FieldToken extends BaseDisplayableFieldToken<FieldType> {

    private PrismProperty property;
    private PrismPropertyDefinition definition;

    public FieldToken(Token parent, FieldType field) {
        super(parent, field);
    }

    @Override
    public void interpret(StructuredFormContext context) throws InterpreterException {
        super.interpret(context);

        FieldType field = getField();
        ReferenceType ref = validateReference(field.getRef(), false);
        String key = ref.getKey();

        Map<String, Item> objects = context.getObjects();
        Item item = objects.get(key);
        if (item == null) {
            throw new InterpreterException("Item with key '" + key + "' was not found in context.");
        }

        if (StringUtils.isEmpty(ref.getValue()) && !(item instanceof PrismProperty)) {
            throw new InterpreterException("Reference doesn't have path defined, but item with key '"
                    + key + "' is not instance of PrismProperty.");
        }

        PrismProperty referencedProperty;
        if (StringUtils.isEmpty(ref.getValue())) {
            referencedProperty = (PrismProperty) item;
            if (referencedProperty == null) {
                throw new InterpreterException("Referenced item doesn't exists.");
            }

            //todo what to do with that?
        } else {
            //resolve property based on parent container and path defined in reference
            if (!(item instanceof PrismContainer)) {
                throw new InterpreterException("Item with key '" + key + "' is not instance of PrismContainer.");
            }

            PrismContainer container = (PrismContainer) item;
            XPathHolder holder = new XPathHolder(ref.getElement());
            PropertyPath path = holder.toPropertyPath();
            item = container.findItem(path);
            if (!(item instanceof PrismProperty)) {
                throw new InterpreterException("Referenced item " + ref + " is not instance of PrismProperty.");
            }
            referencedProperty = (PrismProperty) item;
            if (referencedProperty == null) {
                //find definition, create new property
            } else {
                //????
            }
            //todo what to do with that?
        }


        //todo implement
    }
}
