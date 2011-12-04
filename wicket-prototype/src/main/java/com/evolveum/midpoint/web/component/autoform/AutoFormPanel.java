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

        final ListView<FormAttribute> panel = new ListView<FormAttribute>("list",
                new PropertyModel<List<FormAttribute>>(model, FormObject.F_ATTRIBUTES)) {

            private static final long serialVersionUID = 2288187916579143616L;

            @Override
            protected void populateItem(ListItem<FormAttribute> item) {
                AutoFormPanel.this.populateItem(item);
            }
        };
        panel.setOutputMarkupId(true);
        add(panel);

        AjaxCheckBox showEmpty = new AjaxCheckBox("showEmpty", new PropertyModel<Boolean>(this, "showEmpty")) {

            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                target.add(AutoFormPanel.this);
            }
        };

        add(showEmpty);
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
        FormAttribute attribute = item.getModel().getObject();
        item.add(new Label("label", new PropertyModel<Object>(item.getModel(), "definition.displayName")));
        item.add(populateValues(attribute, item.getModel()));
        item.setVisible(showEmpty || (!attribute.getValues().isEmpty() && attribute.getValues().get(0) != null));
    }

    private Component populateValues(final FormAttribute attribute, final IModel<FormAttribute> model) {
        final WebMarkupContainer container = new WebMarkupContainer("container");
        container.setOutputMarkupId(true);

        ListView<FormValue> ulList = new ListView<FormValue>("attributes", new PropertyModel<List<FormValue>>(model, "values")) {

            @Override
            protected void populateItem(final ListItem<FormValue> item) {
                item.add(createValueField(attribute, model, item.getIndex()));
                //add buttons
                AjaxLink<String> addLink = new AjaxLink<String>("addButton") {

                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        System.out.println("add");
                        attribute.getValues().add(null);

                        target.add(container);
                    }

                    @Override
                    public boolean isVisible() {
                        FormAttribute<FormValue<? extends Serializable>> attribute = model.getObject();

                        return super.isVisible() && attribute.canAddValue() &&
                                ((attribute.getValuesSize() == 1) || (attribute.getValuesSize() == item.getIndex() + 1));
                    }
                };
                item.add(addLink);
                AjaxLink<String> removeLink = new AjaxLink<String>("removeButton") {

                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        System.out.println("remove");
                        attribute.getValues().remove(item.getIndex());

                        target.add(container);
                    }

                    @Override
                    public boolean isVisible() {
                        FormAttribute<FormValue<? extends Serializable>> attribute = model.getObject();

                        return super.isVisible() && attribute.canRemoveValue();
                    }
                };
                item.add(removeLink);
            }
        };
        container.add(ulList);

        return container;
    }

    private Component createValueField(FormAttribute attribute, IModel<FormAttribute> model, int index) {
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
