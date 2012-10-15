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

package com.evolveum.midpoint.forms.impl.ui.widget;

import com.evolveum.midpoint.forms.xml.PropertyType;
import org.apache.commons.lang.Validate;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lazyman
 */
public abstract class UiWidget<T> extends Panel {

    private boolean initialized;

    private IModel<T> model;
    private List<PropertyType> properties;

    public UiWidget(String id, IModel<T> model) {
        super(id);

        Validate.notNull(model, "Model must not be null.");
        this.model = model;
    }

    @Override
    protected void onBeforeRender() {
        super.onBeforeRender();

        if (initialized) {
            return;
        }

        initLayout();
        initialized = true;
    }

    public IModel<T> getModel() {
        return model;
    }

    public List<PropertyType> getProperties() {
        if (properties == null) {
            properties = new ArrayList<PropertyType>();
        }
        return properties;
    }

    public void setProperties(List<PropertyType> properties) {
        this.properties = properties;
    }

    public List<FormComponent> getFormComponents() {
        return Arrays.asList(getBaseFormComponent());
    }

    protected abstract void initLayout();

    public abstract FormComponent getBaseFormComponent();
}
