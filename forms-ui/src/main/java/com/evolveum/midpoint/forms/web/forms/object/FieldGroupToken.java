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
import com.evolveum.midpoint.forms.web.forms.util.ItemDefinitionComparator;
import com.evolveum.midpoint.forms.web.forms.util.StructuredFormUtils;
import com.evolveum.midpoint.forms.xml.BaseFieldType;
import com.evolveum.midpoint.forms.xml.FieldGroupType;
import com.evolveum.midpoint.prism.*;
import com.evolveum.midpoint.schema.holder.XPathHolder;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
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
            getFields().add(StructuredFormUtils.createItemToken(this, item));
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
        super.interpret(interpreterContext, context);
        LOGGER.debug("interpret {}", new Object[]{this});

        FieldGroupType group = getField();
        if (group.getRef() != null) {
            interpretReferencedGroup(context);
        } else {
            for (BaseFieldToken token : getFields()) {
                token.interpret(interpreterContext, context);
            }
        }
    }

    @Override
    public String toString() {
        Element element = getField().getRef();
        ReferenceType ref = element != null ? new ReferenceType(element) : null;

        return "FieldGroupToken{name=" + getField().getName() + ", ref=" + ref + '}';
    }

    private void interpretReferencedGroup(StructuredFormContext context) throws InterpreterException {
        FieldGroupType group = getField();

        LOGGER.debug("Found ref in field group, ignoring children.");
        ReferenceType ref = validateReference(group.getRef(), false);
        String key = ref.getKey();

        Map<String, FormContextItem> objects = context.getObjects();
        FormContextItem contextItem = objects.get(key);
        //if item is not found in context, we can't create form
        if (contextItem == null) {
            //todo maybe it can be only warn and show only empty group...
            throw new InterpreterException("Item with key '" + key + "' was not found in context.");
        }

        Item item = contextItem.getItem();
        if (!(item instanceof PrismContainer)) {
            //todo maybe it can be only warn and show only empty group...
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

        Set<ItemDefinition> exclusions = createExclusions(definition);
        createChildren(container, definition, exclusions);
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
            PropertyPath path = new XPathHolder(element).toPropertyPath();
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
