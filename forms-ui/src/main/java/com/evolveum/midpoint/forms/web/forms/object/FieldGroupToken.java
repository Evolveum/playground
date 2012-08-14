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
import com.evolveum.midpoint.forms.web.forms.util.StructuredFormUtils;
import com.evolveum.midpoint.forms.xml.BaseFieldType;
import com.evolveum.midpoint.forms.xml.FieldGroupType;
import com.evolveum.midpoint.forms.xml.FieldType;
import com.evolveum.midpoint.prism.*;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import org.apache.commons.lang.StringUtils;

import javax.xml.bind.JAXBElement;
import java.util.Collection;
import java.util.Map;

/**
 * @author lazyman
 */
public class FieldGroupToken extends BaseGroupFieldToken<FieldGroupType> {

    private static final Trace LOGGER = TraceManager.getTrace(FieldGroupToken.class);

    public FieldGroupToken(Token parent, FieldGroupType field) {
        super(parent, field);
    }

    @Override
    public void interpret(StructuredFormContext context) throws InterpreterException {
        super.interpret(context);

        FieldGroupType group = getField();
        if (group.getRef() != null) {
            interpretReferencedGroup(context, group);
        } else {
            for (JAXBElement<? extends BaseFieldType> element : group.getItem()) {
                BaseFieldType item = element.getValue();
                getFields().add(StructuredFormUtils.createItemToken(this, item));
            }
        }

        for (BaseFieldToken token : getFields()) {
            token.interpret(context);
        }
    }

    private void interpretReferencedGroup(StructuredFormContext context, FieldGroupType group) throws InterpreterException {
        LOGGER.debug("Found ref in field group (name={}), ignoring children.", new Object[]{group.getName()});
        ReferenceType ref = validateReference(group.getRef(), false);
        String key = ref.getKey();

        Map<String, Item> objects = context.getObjects();
        Item item = objects.get(key);
        if (item == null) {
            //todo maybe it can be only warn and show only empty group...
            throw new InterpreterException("Item with key '" + key + "' was not found in context.");
        }

        if (!(item instanceof PrismContainer)) {
            //todo maybe it can be only warn and show only empty group...
            throw new InterpreterException("Item with key '" + key + "' is not instance of "
                    + PrismContainer.class.getSimpleName() + ".");
        }

        PrismContainer container = (PrismContainer)item;
        PrismContainerDefinition definition = container.getDefinition();
        Collection<ItemDefinition> definitions = definition.getDefinitions();

        for (ItemDefinition itemDefinition : definitions) {
            if (itemDefinition instanceof PrismPropertyDefinition) {
                FieldType field = new FieldType();
                //todo add ref to field
                getFields().add(new FieldToken(this, field));
            } else if (itemDefinition instanceof PrismContainerDefinition) {
                FieldGroupType field = new FieldGroupType();
                //todo add ref to field

                getFields().add(new FieldGroupToken(this, field));
            } else if (itemDefinition instanceof PrismReferenceDefinition) {
                LOGGER.warn("Ignoring reference {} (not implemented yet).", new Object[]{itemDefinition.getName()});
                //todo implement later
            }
        }
    }
}
