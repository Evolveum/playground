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

package com.evolveum.midpoint.web.component.wizard.resource;

import com.evolveum.midpoint.web.component.wizard.WizardPanel;
import com.evolveum.midpoint.xml.ns._public.common.common_1.ResourceType;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author lazyman
 */
public class SynchronizationPanel extends WizardPanel<ResourceType> {

    public SynchronizationPanel(String id, IModel<ResourceType> wizardModel) {
        super(id, wizardModel);

        initLayout();
    }

    @Override
    public IModel<String> getBreadcrumbsTitle() {
        return createStringResource("SynchronizationPanel.breadcrumbs", this);
    }

    @Override
    public IModel<String> getTitle() {
        return createStringResource("SynchronizationPanel.title", this);
    }

    private void initLayout() {
        CheckBox enabled = new CheckBox("enabled", new Model<Boolean>());
        add(enabled);

        TextArea<String> correlation = new TextArea<String>("correlation", new Model<String>());
        add(correlation);

        TextArea<String> confirmation = new TextArea<String>("confirmation", new Model<String>());
        add(confirmation);

        //todo synchronization situations
    }


}
