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

import com.evolveum.midpoint.forms.web.forms.FormContextItem;
import com.evolveum.midpoint.forms.web.forms.StructuredFormContext;
import com.evolveum.midpoint.forms.web.forms.interpreter.InterpreterContext;
import com.evolveum.midpoint.forms.web.forms.interpreter.InterpreterException;
import com.evolveum.midpoint.forms.web.forms.util.StructuredFormUtils;
import com.evolveum.midpoint.forms.xml.FieldDisplayType;
import com.evolveum.midpoint.forms.xml.FieldType;
import com.evolveum.midpoint.prism.*;
import com.evolveum.midpoint.schema.holder.XPathHolder;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
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

        getField().setWidget(StructuredFormUtils.getDefaultWidget(definition));
    }

    @Override
    public void interpret(InterpreterContext interpreterContext, StructuredFormContext context) throws InterpreterException {
        super.interpret(interpreterContext, context);
        LOGGER.debug("interpret {}", new Object[]{this});

        FieldType field = getField();
        ReferenceType ref = validateReference(field.getRef(), false);
        String key = ref.getKey();

        Map<String, FormContextItem> objects = context.getObjects();
        FormContextItem contextItem = objects.get(key);
        //if item is not found in context, we can't create form
        if (contextItem == null) {
            throw new InterpreterException("Item with key '" + key + "' was not found in context.");
        }

        Item item = contextItem.getItem();
        //if path is null then item in map must be prism property
        if (StringUtils.isEmpty(ref.getValue()) && !(item instanceof PrismProperty)) {
            throw new InterpreterException("Reference doesn't have path defined, but item with key '"
                    + key + "' is not instance of PrismProperty.");
        }

        if (StringUtils.isEmpty(ref.getValue())) {
            property = (PrismProperty) item;
            definition = property.getDefinition();
        } else {
            //resolve property based on parent container and path defined in reference
            if (!(item instanceof PrismContainer)) {
                throw new InterpreterException("Item with key '" + key + "' is not instance of PrismContainer.");
            }

            PrismContainer container = (PrismContainer) item;
            XPathHolder holder = new XPathHolder(ref.getElement());
            PropertyPath path = holder.toPropertyPath();
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

        if (definition == null) {
            throw new InterpreterException("Definition for field '" + ref + "' was not found.");
        }
    }

    @Override
    public String toString() {
        Element element = getField().getRef();
        ReferenceType ref = element != null ? new ReferenceType(element) : null;

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
