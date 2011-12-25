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
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.IModel;

/**
 * @author lazyman
 */
public class NamePanel extends BaseWizardPanel {

    public NamePanel(String id) {
        super(id);

        initLayout(null);
    }

    @Override
    public IModel<String> getTitle() {
        return createStringResource("NamePanel.title", this);
    }

    @Override
    public void initLayout(IModel<Wizard> wizardModel) {
        RequiredTextField<String> name = new RequiredTextField<String>("name");
        add(name);

        DropDownChoice<String> type = new DropDownChoice<String>("type");
        add(type);

        DropDownChoice<String> version = new DropDownChoice<String>("version");
        add(version);
    }
}
