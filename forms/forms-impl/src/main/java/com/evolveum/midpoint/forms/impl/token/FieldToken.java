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

import com.evolveum.midpoint.forms.impl.FormContextItem;
import com.evolveum.midpoint.forms.impl.StructuredFormContext;
import com.evolveum.midpoint.forms.impl.interpreter.InterpreterContext;
import com.evolveum.midpoint.forms.impl.interpreter.InterpreterException;
import com.evolveum.midpoint.prism.*;
import com.evolveum.midpoint.prism.path.ItemPath;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import com.evolveum.midpoint.xml.ns._public.gui.form_1.FieldType;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.w3c.dom.Element;

import java.util.Map;

/**
 * @author lazyman
 */
public class FieldToken extends BaseDisplayableFieldToken<FieldType> {

    private static final Trace LOGGER = TraceManager.getTrace(FieldToken.class);
    private PrismProperty property;
    private PrismPropertyDefinition definition;

    public FieldToken(Token parent, FieldType field) {
        super(parent, field);
    }

    public FieldToken(Token parent, PrismProperty property, PrismPropertyDefinition definition) {
        super(parent, new FieldType());

        Validate.notNull(definition, "Prism property definition must not be null.");
        this.property = property;
        this.definition = definition;

        getField().setWidget(TokenUtils.getDefaultWidget(definition));
    }

    @Override
    public void interpret(InterpreterContext interpreterContext, StructuredFormContext context) throws InterpreterException {
        LOGGER.debug("interpret {}", new Object[]{this});

        FieldType field = getField();
        ReferenceToken ref = validateReference(field.getRef(), false);
        String key = ref.getKey();

        if (StringUtils.isEmpty(key) && (getParent() instanceof FieldLoopItemToken)) {
            // it's in field loop, therefore custom "ref" handling - ref doesn't have key,
            // it's used key and base path from field loop
            interpretFieldInFieldLoop(interpreterContext, context, ref);
        } else if (StringUtils.isEmpty(key)) {
            throw new InterpreterException("Reference '" + ref + "' doesn't have key defined or it's empty.");
        } else {
            interpretField(interpreterContext, context, ref);
        }

        if (definition == null) {
            throw new InterpreterException("Definition for field '" + ref + "' was not found.");
        }

        if (StringUtils.isEmpty(field.getWidget())) {
            field.setWidget(TokenUtils.getDefaultWidget(definition));
        }
    }

    private FormContextItem getFormContextItem(Map<String, FormContextItem> objects, String key)
            throws InterpreterException {
        FormContextItem contextItem = objects.get(key);
        //if item is not found in context, we can't create form
        if (contextItem == null) {
            throw new InterpreterException("Item with key '" + key + "' was not found in context.");
        }

        return contextItem;
    }

    private void interpretField(InterpreterContext interpreterContext, StructuredFormContext context,
                                ReferenceToken ref) throws InterpreterException {
        String key = ref.getKey();
        FormContextItem contextItem = getFormContextItem(context.getObjects(), key);
        Item item = contextItem.getItem();
        //if path is null then item in map must be prism property
        if (ref.getPath().isEmpty() && !(item instanceof PrismProperty)) {
            throw new InterpreterException("Reference doesn't have path defined, but item with key '"
                    + key + "' is not instance of PrismProperty.");
        }

        if (ref.getPath().isEmpty()) {
            property = (PrismProperty) item;
            definition = property.getDefinition();
        } else {
            //resolve property based on parent container and path defined in reference
            if (!(item instanceof PrismContainer)) {
                throw new InterpreterException("Item with key '" + key + "' is not instance of PrismContainer.");
            }

            PrismContainer container = (PrismContainer) item;
            ItemPath path = ref.getPath();
            item = container.findItem(path);
            if (item != null && !(item instanceof PrismProperty)) {
                throw new InterpreterException("Referenced item " + ref + " is not instance of PrismProperty.");
            }

            property = (PrismProperty) item;
            if (property == null) {
                PrismContainerDefinition containerDefinition = container.getDefinition();
                definition = containerDefinition.findPropertyDefinition(path);
            } else {
                definition = property.getDefinition();
            }
        }
    }

    private void interpretFieldInFieldLoop(InterpreterContext interpreterContext, StructuredFormContext context,
                                           ReferenceToken fieldRef) throws InterpreterException {

        FieldLoopItemToken loopItemToken = (FieldLoopItemToken) getParent();
        FieldLoopToken loopToken = loopItemToken.getParent();
        PrismContainer loopContainer = loopToken.getContainer();

        PrismContainerValue value = (PrismContainerValue) loopContainer.getValue(loopItemToken.getIndex());

        ItemPath path = fieldRef.getPath();
        Item item = value.findItem(path);
        if (item != null && !(item instanceof PrismProperty)) {
            throw new InterpreterException("Referenced item " + fieldRef + " is not instance of PrismProperty.");
        }

        property = (PrismProperty) item;
        if (property == null) {
            PrismContainerDefinition containerDefinition = value.getParent().getDefinition();
            definition = containerDefinition.findPropertyDefinition(path);
        } else {
            definition = property.getDefinition();
        }

    }

    @Override
    public String toString() {
        Element element = getField().getRef();
        ReferenceToken ref = element != null ? new ReferenceToken(element) : null;

        return "FieldToken{name=" + getField().getName() + ", ref=" + ref + '}';
    }

    public String getWidget() {
        return getField().getWidget();
    }

    public PrismPropertyDefinition getDefinition() {
        return definition;
    }

    public PrismProperty getProperty() {
        return property;
    }
}
