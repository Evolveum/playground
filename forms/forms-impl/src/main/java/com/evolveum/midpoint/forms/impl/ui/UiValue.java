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

package com.evolveum.midpoint.forms.impl.ui;

import com.evolveum.midpoint.forms.component.util.VisibleEnableBehaviour;
import com.evolveum.midpoint.forms.impl.model.FieldModel;
import com.evolveum.midpoint.forms.impl.model.ValueModel;
import com.evolveum.midpoint.forms.impl.object.FieldToken;
import com.evolveum.midpoint.forms.impl.ui.widget.TextWidget;
import com.evolveum.midpoint.forms.impl.ui.widget.UiWidget;
import com.evolveum.midpoint.forms.impl.util.StructuredFormUtils;
import com.evolveum.midpoint.forms.xml.FieldDisplayType;
import com.evolveum.midpoint.forms.xml.PropertyType;
import com.evolveum.midpoint.prism.PrismPropertyDefinition;
import com.evolveum.midpoint.schema.constants.SchemaConstants;
import com.evolveum.midpoint.util.logging.LoggingUtils;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import com.evolveum.midpoint.xml.ns._public.common.common_2.ProtectedStringType;
import org.apache.commons.lang.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.feedback.ComponentFeedbackMessageFilter;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.StringResourceModel;

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * @author lazyman
 */
public class UiValue extends Panel {

    private static final Trace LOGGER = TraceManager.getTrace(UiValue.class);
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
        final ValueModel valueModel = model.getObject();
        FieldDisplayType display = valueModel.getDefaultDisplay();

        //todo help
        Label label = new Label("label", new StringResourceModel(display.getLabel(), null, display.getLabel()));
        label.add(new AttributeModifier("style", new AbstractReadOnlyModel<String>() {

            @Override
            public String getObject() {
                if (valueModel.getVisibleValueIndex() > 0) {
                    return "visibility: hidden;";
                }
                return null;
            }
        }));

        if (StringUtils.isNotEmpty(display.getTooltip())) {
            label.add(new AttributeModifier("title",
                    new StringResourceModel(display.getTooltip(), null, display.getTooltip())));
        }
        add(label);

        FieldToken fieldToken = valueModel.getField().getToken();
        UiWidget widget = initWidget(fieldToken.getWidget(), display.getProperty());
        add(widget);

        FeedbackPanel feedback = new FeedbackPanel("feedback");
        feedback.setFilter(new ComponentFeedbackMessageFilter(widget.getBaseFormComponent()));
        feedback.setOutputMarkupId(true);
        add(feedback);

        AjaxLink addButton = new AjaxLink("addButton") {

            @Override
            public void onClick(AjaxRequestTarget target) {
                addValue(target);
            }
        };
        addButton.add(new VisibleEnableBehaviour() {

            @Override
            public boolean isVisible() {
                return valueModel.isAddButtonVisible();
            }
        });
        add(addButton);

        AjaxLink removeButton = new AjaxLink("removeButton") {

            @Override
            public void onClick(AjaxRequestTarget target) {
                removeValue(target);
            }
        };
        removeButton.add(new VisibleEnableBehaviour() {

            @Override
            public boolean isVisible() {
                return  valueModel.isRemoveButtonVisible();
            }
        });
        add(removeButton);
    }

    private UiWidget initWidget(String type, List<PropertyType> properties) {
        try {
            Class<? extends UiWidget> clazz = UiRegistry.getWidget(type);
            Constructor<? extends UiWidget> constructor = clazz.getConstructor(String.class, IModel.class);

            UiWidget widget = constructor.newInstance("widget", createValueModel());
            widget.setProperties(properties);

            return widget;
        } catch (Exception ex) {
            StringBuilder builder = new StringBuilder();
            StructuredFormUtils.createMessage(ex, builder);
            error(builder.toString());

            LoggingUtils.logException(LOGGER, "Couldn't create widget", ex);
        }

        return new TextWidget("widget", createValueModel());
    }

    /**
     * @return Returns proper {@link PropertyModel} based on different types like
     *         {@link com.evolveum.midpoint.prism.polystring.PolyString} or
     *         {@link com.evolveum.midpoint.xml.ns._public.common.common_2.ProtectedStringType}
     */
    private IModel createValueModel() {
        FieldToken token = model.getObject().getField().getToken();
        PrismPropertyDefinition definition = token.getDefinition();

        final String baseExpression = "value.value"; //pointing to prism property real value

        if (ProtectedStringType.COMPLEX_TYPE.equals(definition.getTypeName())) {
            return new PropertyModel<String>(model, baseExpression + ".clearValue");
        } else if (SchemaConstants.T_POLY_STRING_TYPE.equals(definition.getTypeName())) {
            return new PropertyModel<String>(model, baseExpression + ".orig");
        }

        return new PropertyModel(model, baseExpression);
    }

    private void addValue(AjaxRequestTarget target) {
        FieldModel fieldModel = model.getObject().getField();
        fieldModel.addValue();

        ListView listView = findParent(ListView.class);
        target.add(listView.getParent());
    }

    private void removeValue(AjaxRequestTarget target) {
        ValueModel valueModel = model.getObject();
        FieldModel fieldModel = valueModel.getField();
        fieldModel.removeValue(valueModel);

        ListView listView = findParent(ListView.class);
        target.add(listView.getParent());
    }
}
