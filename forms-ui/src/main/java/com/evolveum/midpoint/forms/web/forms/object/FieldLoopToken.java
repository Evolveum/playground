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
import com.evolveum.midpoint.forms.xml.FieldLoopType;
import com.evolveum.midpoint.prism.Item;
import com.evolveum.midpoint.prism.PrismContainer;
import com.evolveum.midpoint.prism.PrismContainerDefinition;
import com.evolveum.midpoint.prism.PropertyPath;
import com.evolveum.midpoint.schema.holder.XPathHolder;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import java.util.Map;

/**
 * @author lazyman
 */
public class FieldLoopToken extends BaseGroupFieldToken<FieldLoopType> {

    private static final Trace LOGGER = TraceManager.getTrace(FieldToken.class);
    private PrismContainer container;
    private PrismContainerDefinition definition;

    public FieldLoopToken(Token parent, FieldLoopType item) {
        super(parent, item);
    }

    @Override
    public String toString() {
        Element element = getField().getRef();
        ReferenceType ref = element != null ? new ReferenceType(element) : null;

        return "FieldLoopToken{name=" + getField().getName() + ", ref=" + ref + '}';
    }

    public PrismContainer getContainer() {
        return container;
    }

    public PrismContainerDefinition getDefinition() {
        return definition;
    }

    @Override
    public void interpret(InterpreterContext interpreterContext, StructuredFormContext context) throws InterpreterException {
        super.interpret(interpreterContext, context);
        LOGGER.debug("interpret {}", new Object[]{this});

        FieldLoopType loop = getField();
        ReferenceType ref = validateReference(loop.getRef(), false);
        String key = ref.getKey();

        Map<String, FormContextItem> objects = context.getObjects();
        FormContextItem contextItem = objects.get(key);
        //if item is not found in context, we can't create form
        if (contextItem == null) {
            //todo maybe it can be only warn and show only empty loop...
            throw new InterpreterException("Item with key '" + key + "' was not found in context.");
        }

        Item item = contextItem.getItem();
        if (!(item instanceof PrismContainer)) {
            //todo maybe it can be only warn and show only empty loop...
            throw new InterpreterException("Item with key '" + key + "' is not instance of "
                    + PrismContainer.class.getSimpleName() + ".");
        }

        PrismContainer parent = (PrismContainer) item;
        if (StringUtils.isNotEmpty(ref.getValue())) {
            XPathHolder holder = new XPathHolder(ref.getElement());
            PropertyPath path = holder.toPropertyPath();

            this.container = parent.findContainer(path);

            PrismContainerDefinition parentDef = parent.getDefinition();
            this.definition = parentDef.findContainerDefinition(path);
        } else {
            this.container = parent;
            this.definition = parent.getDefinition();
        }

        if (definition == null) {
            throw new InterpreterException("Prism container definition was not found for referenced item '" +
                    this + "'.");
        }

        //todo check if ref attribute points to list value
        //todo implement
    }
}
