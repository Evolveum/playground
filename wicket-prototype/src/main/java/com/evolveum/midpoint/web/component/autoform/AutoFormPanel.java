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

package com.evolveum.midpoint.web.component.autoform;

import com.evolveum.midpoint.web.component.autoform.custom.ComboPanel;
import com.evolveum.midpoint.web.component.autoform.custom.DatePanel;
import com.evolveum.midpoint.web.component.autoform.custom.PasswordPanel;
import com.evolveum.midpoint.web.component.autoform.custom.TextPanel;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxCheckBox;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AutoFormPanel extends Panel {

    private static final long serialVersionUID = 2174504322480554451L;
    private static final String COMPONENT_ID = "componentId";
    private boolean showEmpty = true;

    public AutoFormPanel(String id, IModel<FormObject> model) {
        super(id, model);

        ListView<FormAttribute> attributesPanel = new ListView<FormAttribute>("list",
                new PropertyModel<List<FormAttribute>>(model, FormObject.F_ATTRIBUTES)) {

            @Override
            protected void populateItem(ListItem<FormAttribute> item) {
                AutoFormPanel.this.populateItem(item);
            }
        };
        attributesPanel.setOutputMarkupId(true);
        add(attributesPanel);

        add(new AjaxCheckBox("showEmpty", new PropertyModel<Boolean>(this, "showEmpty")) {

            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                target.add(AutoFormPanel.this);
            }
        });

        add(new FeedbackPanel("feedback"));
        setOutputMarkupId(true);
    }

    public boolean isShowEmpty() {
        return showEmpty;
    }

    public void setShowEmpty(boolean showEmpty) {
        this.showEmpty = showEmpty;
    }

    private void populateItem(ListItem<FormAttribute> item) {
        FormAttribute<FormValue> attribute = item.getModel().getObject();
        item.add(new Label("label", new PropertyModel<Object>(item.getModel(), "definition.displayName")));
        item.add(populateValues(item.getModel()));
        item.setVisible(showEmpty || (!attribute.getValues().isEmpty()
                && attribute.getValues().get(0).getStatus() != FormValueStatus.PLACEHOLDER));
    }

    private Component populateValues(final IModel<FormAttribute> model) {
        final WebMarkupContainer container = new WebMarkupContainer("container");
        container.setOutputMarkupId(true);

        ListView<FormValue> ulList = new ListView<FormValue>("attributes", new PropertyModel<List<FormValue>>(model, "values")) {

            @Override
            protected void populateItem(final ListItem<FormValue> item) {
                item.add(createValueField(model, item.getIndex()));
                //add buttons
                AjaxLink<String> addLink = new AjaxLink<String>("addButton") {

                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        addValuePerformed(target, container, model);
                    }

                    @Override
                    public boolean isVisible() {
                        return isAddValueLinkVisible(model, item.getIndex());
                    }
                };
                item.add(addLink);
                AjaxLink<String> removeLink = new AjaxLink<String>("removeButton") {

                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        removeValuePerformed(target, container, model, item.getIndex());
                    }

                    @Override
                    public boolean isVisible() {
                        return isRemoveValueLinkVisible(model, item.getIndex());
                    }
                };
                item.add(removeLink);

                boolean visible = !FormValueStatus.DELETED.equals(item.getModelObject().getStatus());
                item.setVisible(visible);
            }
        };
        container.add(ulList);

        return container;
    }

    public boolean isAddValueLinkVisible(IModel<FormAttribute> model, int index) {
        FormAttribute<FormValue<? extends Serializable>> attribute = model.getObject();

        return super.isVisible() && attribute.canAddValue() &&
                ((attribute.getValuesSize() == 1) || (attribute.getValuesSize() == index + 1));
    }

    public boolean isRemoveValueLinkVisible(IModel<FormAttribute> model, int index) {
        FormAttribute<FormValue<? extends Serializable>> attribute = model.getObject();

        return super.isVisible() && attribute.canRemoveValue();
    }

    private void addValuePerformed(AjaxRequestTarget target, WebMarkupContainer container,
                                   IModel<FormAttribute> model) {
        model.getObject().getValues().add(new FormValue(null, FormValueStatus.ADDED));

        target.add(container);
    }

    private void removeValuePerformed(AjaxRequestTarget target, WebMarkupContainer container,
                                      IModel<FormAttribute> model, int index) {
        FormAttribute<?> attribute = model.getObject();
        FormValue<?> value = attribute.getValues().get(index);
        value.setStatus(FormValueStatus.DELETED);

        target.add(container);
    }

    private Component createValueField(IModel<FormAttribute> model, int index) {
        FormAttribute attribute = model.getObject();

        if (attribute.getDefinition().getAvailableValues() != null) {
            return new ComboPanel(COMPONENT_ID, new PropertyModel<String>(model, "values[" + index + "]"),
                    new PropertyModel<List<String>>(model, "definition.availableValues"));
        }

        final String property = "values[" + index + "].value";
        Component component = null;
        switch (attribute.getDefinition().getType()) {
            case DATE:
                component = new DatePanel(COMPONENT_ID, new PropertyModel<Date>(model, property));
                break;
            case PASSWORD:
                component = new PasswordPanel(COMPONENT_ID, new PropertyModel<String>(model, property),
                        new PasswordPanel.Validation("[a-z]{1}", "[0-1]{1}", "[A-Z]{1}"));
                break;
            default:
                component = new TextPanel<String>(COMPONENT_ID, new PropertyModel<String>(model, property));
        }

        return component;
    }
}
