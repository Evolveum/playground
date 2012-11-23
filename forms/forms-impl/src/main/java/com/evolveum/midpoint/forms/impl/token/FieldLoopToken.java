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
import com.evolveum.midpoint.prism.Item;
import com.evolveum.midpoint.prism.PrismContainer;
import com.evolveum.midpoint.prism.PrismContainerDefinition;
import com.evolveum.midpoint.prism.PrismContainerValue;
import com.evolveum.midpoint.prism.path.ItemPath;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import com.evolveum.midpoint.xml.ns._public.gui.form_1.FieldLoopType;
import org.w3c.dom.Element;

import java.util.List;
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
        ReferenceToken ref = element != null ? new ReferenceToken(element) : null;

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
        LOGGER.debug("interpret {}", new Object[]{this});

        FieldLoopType loop = getField();
        ReferenceToken ref = validateReference(loop.getRef(), false);
        String key = ref.getKey();

        Map<String, FormContextItem> objects = context.getObjects();
        FormContextItem contextItem = objects.get(key);
        //if item is not found in context, we can't create form
        if (contextItem == null) {
            throw new InterpreterException("Item with key '" + key + "' was not found in context.");
        }

        Item item = contextItem.getItem();
        if (!(item instanceof PrismContainer)) {
            throw new InterpreterException("Item with key '" + key + "' is not instance of PrismContainer.");
        }

        PrismContainer parent = (PrismContainer) item;
        if (!ref.getPath().isEmpty()) {
            ItemPath path = ref.getPath();

            //todo field loop can point to PrismReference...
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

        if (container == null) {
            //nothing to interpret, nothing to show.
            return;
        }

        List<PrismContainerValue> values = container.getValues();
        for (int i = 0; i < values.size(); i++) {
            FieldLoopItemToken loopItemToken = new FieldLoopItemToken(this, i);
            loopItemToken.interpret(interpreterContext, context);
            getFields().add(loopItemToken);
        }
    }

    public ReferenceToken getRef() {
        FieldLoopType loop = getField();
        return new ReferenceToken(loop.getRef());
    }
}
