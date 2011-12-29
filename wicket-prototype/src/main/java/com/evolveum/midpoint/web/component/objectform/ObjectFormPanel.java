/*
 * Copyright (c) 2011 Evolveum
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
 * Portions Copyrighted 2011 [name of copyright owner]
 */

package com.evolveum.midpoint.web.component.objectform;

import com.evolveum.midpoint.schema.processor.*;
import com.evolveum.midpoint.web.component.util.LoadableModel;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.PackageResourceReference;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author lazyman
 */
public class ObjectFormPanel extends Panel {

    private IModel<PropertyContainer> model;
    private boolean isNewObject;
    private boolean showEmptyProperties;

    public ObjectFormPanel(String id, IModel<PropertyContainer> model) {
        this(id, model, false);
    }

    public ObjectFormPanel(String id, IModel<PropertyContainer> model, boolean isNewObject) {
        super(id);
        Validate.notNull(model, "Model with property container must not be null.");

        this.model = model;
        this.isNewObject = isNewObject;
        initLayout();
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.renderCSSReference(new PackageResourceReference(ObjectFormPanel.class, "ObjectFormPanel.css"));
    }

    public boolean isShowEmptyProperties() {
        return showEmptyProperties;
    }

    public void setShowEmptyProperties(boolean showEmptyProperties) {
        this.showEmptyProperties = showEmptyProperties;
    }

    private void initLayout() {
        //title
        Label title = new Label("title", createItemNameModel(model));
        //todo title value and visibility
        add(title);
        //attributes
        ListView<Property> attributes = new ListView<Property>("attributes", createAttributesModel()) {

            @Override
            protected void populateItem(ListItem<Property> listItem) {
                populateListItem(listItem);

                if (!showEmptyProperties && isEmpty(listItem)) {
                    listItem.setVisible(false);
                }
            }
        };
        add(attributes);
    }

    private boolean isEmpty(ListItem<Property> attribute) {
        //todo set list item visibility
        return false;
    }

    private void populateListItem(ListItem<Property> listItem) {
        final IModel<Property> propertyModel = listItem.getModel();
        Label name = new Label("name", createItemNameModel(propertyModel));
        listItem.add(name);


        IModel<List<PropertyValue>> valuesModel = new LoadableModel<List<PropertyValue>>() {

            @Override
            protected List<PropertyValue> load() {
                List<PropertyValue> values = new ArrayList<PropertyValue>();
                Property property = propertyModel.getObject();
                for (PropertyValue value : property.getValues()) {
                    values.add(value);
                }

                if (values.isEmpty()) {
                    values.add(new PropertyValue(""));
                }

                return values;
            }
        };

        ListView<PropertyValue> values = new ListView<PropertyValue>("values", valuesModel) {

            @Override
            protected void populateItem(ListItem<PropertyValue> listItem) {
                listItem.setRenderBodyOnly(true);

                ValueFormPanel value = new ValueFormPanel("value", listItem.getModel());
                listItem.add(value);
            }
        };
        listItem.add(values);
    }

    private <T extends Item> IModel<String> createItemNameModel(final IModel<T> model) {
        return new LoadableModel<String>() {

            @Override
            protected String load() {
                T item = model.getObject();
                Validate.notNull(item, "Property must not be null.");

                String displayName = item.getDisplayName();
                if (StringUtils.isEmpty(displayName)) {
                    QName name = item.getName();
                    if (name != null) {
                        displayName = name.getLocalPart();
                    } else {
                        displayName = item.getDefinition().getTypeName().getLocalPart();
                    }
                }

                return displayName;
            }
        };
    }

    private IModel<List<Property>> createAttributesModel() {
        return new LoadableModel<List<Property>>() {

            @Override
            protected List<Property> load() {
                List<SomeUnknownClassName<Property, PropertyDefinition>> attributes =
                        new ArrayList<SomeUnknownClassName<Property, PropertyDefinition>>();

                PropertyContainer container = model.getObject();
                PropertyContainerDefinition definition = container.getDefinition();
                Set<PropertyDefinition> propertyDefinitions = definition.getPropertyDefinitions();
                for (PropertyDefinition def : propertyDefinitions) {
                    attributes.add(new SomeUnknownClassName(container.findProperty(def), def));
                }
                Collections.sort(attributes);

                List<Property> properties = new ArrayList<Property>();
                for (SomeUnknownClassName<Property, PropertyDefinition> attribute : attributes) {
                    if (attribute.getItem() == null) {
                        //todo create model, don't create property right now
                        properties.add(attribute.getDefinition().instantiate());
                    } else {
                        properties.add(attribute.getItem());
                    }
                }

                return properties;
            }
        };
    }
}
