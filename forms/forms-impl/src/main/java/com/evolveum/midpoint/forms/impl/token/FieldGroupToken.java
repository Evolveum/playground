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
import com.evolveum.midpoint.forms.impl.util.ItemDefinitionComparator;
import com.evolveum.midpoint.prism.*;
import com.evolveum.midpoint.prism.path.ItemPath;
import com.evolveum.midpoint.prism.path.NameItemPathSegment;
import com.evolveum.midpoint.schema.holder.XPathHolder;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import com.evolveum.midpoint.xml.ns._public.gui.form_1.BaseFieldType;
import com.evolveum.midpoint.xml.ns._public.gui.form_1.FieldGroupType;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBElement;
import java.util.*;

/**
 * @author lazyman
 */
public class FieldGroupToken extends BaseGroupFieldToken<FieldGroupType> {

    private static final Trace LOGGER = TraceManager.getTrace(FieldGroupToken.class);
    private PrismContainer container;
    private PrismContainerDefinition definition;

    public FieldGroupToken(Token parent, FieldGroupType field) {
        super(parent, field);

        for (JAXBElement<? extends BaseFieldType> element : field.getItem()) {
            BaseFieldType item = element.getValue();
            BaseFieldToken token = TokenUtils.createItemToken(this, item);
            getFields().add(token);
        }
    }

    private FieldGroupToken(Token parent, PrismContainer container, PrismContainerDefinition definition,
                            Set<ItemDefinition> exclusions) {
        super(parent, new FieldGroupType());

        Validate.notNull(definition, "Prism container definition must no be null.");
        this.container = container;
        this.definition = definition;

        createChildren(container, definition, exclusions);
    }

    @Override
    public void interpret(InterpreterContext interpreterContext, StructuredFormContext context) throws InterpreterException {
        LOGGER.debug("interpret {}", new Object[]{this});

        FieldGroupType group = getField();
        if (group.getRef() != null) {
            interpretReferencedGroup(interpreterContext, context);
        } else {
            for (BaseFieldToken token : getFields()) {
                token.interpret(interpreterContext, context);
            }
        }
    }

    @Override
    public String toString() {
        Element element = getField().getRef();
        ReferenceToken ref = element != null ? new ReferenceToken(element) : null;

        return "FieldGroupToken{name=" + getField().getName() + ", ref=" + ref + '}';
    }

    private void interpretReferencedGroup(InterpreterContext interpreterContext, StructuredFormContext context) throws InterpreterException {
        FieldGroupType group = getField();

        LOGGER.debug("Found ref in field group, ignoring children.");
        ReferenceToken ref = validateReference(group.getRef(), false);
        String key = ref.getKey();

        if (StringUtils.isEmpty(key) && (getParent() instanceof FieldLoopItemToken)) {
            // it's in field loop, therefore custom "ref" handling - ref doesn't have key,
            // it's used key and base path from field loop
            interpretGroupInFieldLoop(interpreterContext, context, ref);
        } else if (StringUtils.isEmpty(key)) {
            throw new InterpreterException("Reference '" + ref + "' doesn't have key defined or it's empty.");
        } else {
            interpretGroup(context, ref);
        }

        if (definition == null) {
            throw new InterpreterException("Prism container definition was not found for referenced item '" +
                    this + "'.");
        }

        Set<ItemDefinition> exclusions = createExclusions(definition);
        createChildren(container, definition, exclusions);
    }

    private void interpretGroupInFieldLoop(InterpreterContext interpreterContext, StructuredFormContext context,
                                           ReferenceToken ref) throws InterpreterException {

        FieldLoopItemToken loopItemToken = (FieldLoopItemToken) getParent();
        FieldLoopToken loopToken = loopItemToken.getParent();
        PrismContainer loopContainer = loopToken.getContainer();

        PrismContainerValue value = (PrismContainerValue) loopContainer.getValue(loopItemToken.getIndex());
        PrismContainerDefinition parentDef = value.getParent().getDefinition();
        if (!ref.getPath().isEmpty()) {
            ItemPath path = ref.getPath();
            Item item = value.findItem(path);
            //todo field loop can point to PrismReference
            if (item == null) {
                item = new PrismContainer(((NameItemPathSegment)path.last()).getName());
                item.revive(interpreterContext.getPrismContext());
            } else if (!(item instanceof PrismContainer)) {
                throw new InterpreterException("Item referenced by '" + ref + "' must be PrismContainer, but it's '"
                        + (item != null ? item.getClass().getSimpleName() : null) + "'.");
            }
            this.container = (PrismContainer) item;
            this.definition = parentDef.findContainerDefinition(path);
        } else {
            //todo ??? field group with empty ref key is probably not usable in field loop. Or?
            throw new InterpreterException("not properly implemented yet...[todo]");
//            this.container = parent;
//            this.definition = parent.getDefinition();
        }
    }

    private void interpretGroup(StructuredFormContext context, ReferenceToken ref) throws InterpreterException {
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
            //todo field group can point to PrismReference...
            this.container = parent.findContainer(path);

            PrismContainerDefinition parentDef = parent.getDefinition();
            this.definition = parentDef.findContainerDefinition(path);
        } else {
            this.container = parent;
            this.definition = parent.getDefinition();
        }
    }

    private Set<ItemDefinition> createExclusions(PrismContainerDefinition definition) {
        Set<ItemDefinition> exclusions = new HashSet<ItemDefinition>();

        List<Element> elements;
        if (getField().getExclusions() != null) {
            elements = getField().getExclusions().getExclusion();
        } else {
            return exclusions;
        }

        for (Element element : elements) {
            ItemPath path = new XPathHolder(element).toPropertyPath();
            ItemDefinition def = definition.findItemDefinition(path);
            if (def != null) {
                exclusions.add(def);
            }
        }

        return exclusions;
    }

    private void createChildren(PrismContainer container, PrismContainerDefinition definition, Set<ItemDefinition> exclusions) {

        List<ItemDefinition> definitions;
        if (definition.getDefinitions() != null) {
            definitions = new ArrayList<ItemDefinition>();
            definitions.addAll(definition.getDefinitions());

            Collections.sort(definitions, new ItemDefinitionComparator());
        } else {
            return;
        }

        for (ItemDefinition itemDefinition : definitions) {
            if (exclusions.contains(itemDefinition)) {
                LOGGER.trace("Ignoring {} based on group exclusions.", new Object[]{itemDefinition.dump()});
                continue;
            }

            if (itemDefinition instanceof PrismPropertyDefinition) {
                PrismProperty property = container != null ? container.findProperty(itemDefinition.getName()) : null;

                getFields().add(new FieldToken(this, property, (PrismPropertyDefinition) itemDefinition));
            } else if (itemDefinition instanceof PrismContainerDefinition) {
                PrismContainer prismContainer = container != null ?
                        container.findContainer(itemDefinition.getName()) : null;

                getFields().add(new FieldGroupToken(this, prismContainer,
                        (PrismContainerDefinition) itemDefinition, exclusions));
            } else if (itemDefinition instanceof PrismReferenceDefinition) {
                //todo implement later
                LOGGER.warn("Ignoring reference {} (not implemented yet).", new Object[]{itemDefinition.getName()});
            }
        }
    }

    public PrismContainerDefinition getDefinition() {
        return definition;
    }
}
