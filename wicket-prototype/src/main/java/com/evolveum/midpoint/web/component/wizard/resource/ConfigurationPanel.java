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

package com.evolveum.midpoint.web.component.wizard.resource;

import com.evolveum.midpoint.web.component.wizard.BaseWizardPanel;
import com.evolveum.midpoint.web.component.wizard.Wizard;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;

/**
 * @author lazyman
 */
public class ConfigurationPanel extends BaseWizardPanel {

    public ConfigurationPanel(String id) {
        super(id);
    }

    @Override
    public IModel<String> getTitle() {
        return new StringResourceModel("ConfigurationPanel.title", this, null, null, null);
    }

    @Override
    public void initLayout(IModel<Wizard> wizardModel) {

    }
}
