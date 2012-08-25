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

package com.evolveum.midpoint.forms.web.forms.ui;

import com.evolveum.midpoint.forms.web.forms.model.ValueModel;
import com.evolveum.midpoint.forms.web.forms.ui.widget.TextWidget;
import com.evolveum.midpoint.forms.web.forms.ui.widget.UiWidget;
import com.evolveum.midpoint.forms.xml.FieldDisplayType;
import com.evolveum.midpoint.forms.xml.PropertyType;
import org.apache.commons.lang.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.feedback.ComponentFeedbackMessageFilter;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.StringResourceModel;

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * @author lazyman
 */
public class UiValue extends Panel {

    private IModel<ValueModel> model;
    private boolean initialized;

    public UiValue(String id, IModel<ValueModel> model) {
        super(id);
        this.model = model;
    }

    @Override
    protected void onBeforeRender() {
        super.onBeforeRender();

        if (!initialized) {
            initLayout();
            initialized = true;
        }
    }

    protected void initLayout() {
        FieldDisplayType display = model.getObject().getDefaultDisplay();

        //todo help
        Label label = new Label("label", new StringResourceModel(display.getLabel(), null, display.getLabel()));
        if (StringUtils.isNotEmpty(display.getTooltip())) {
            label.add(new AttributeModifier("title",
                    new StringResourceModel(display.getTooltip(), null, display.getTooltip())));
        }
        add(label);

        UiWidget widget = initWidget(display.getType(), display.getProperty());
        add(widget);

        FeedbackPanel feedback = new FeedbackPanel("feedback");
        feedback.setFilter(new ComponentFeedbackMessageFilter(widget.getBaseFormComponent()));
        feedback.setOutputMarkupId(true);
        add(feedback);

    }

    private UiWidget initWidget(String type, List<PropertyType> properties) {
        try {
            Class<? extends UiWidget> clazz = UiRegistry.getWidget(type);
            Constructor<? extends UiWidget> constructor = clazz.getConstructor(String.class, IModel.class);

            return constructor.newInstance("widget", createValueModel());
        } catch (Exception ex) {
            //todo log exception
            ex.printStackTrace();
        }

        return new TextWidget("widget", new PropertyModel(model, "value.value"));
    }

    private IModel createValueModel() {
        //todo fix property model for polystring, password, etc..
        return new PropertyModel(model, "value.value");
    }
}
