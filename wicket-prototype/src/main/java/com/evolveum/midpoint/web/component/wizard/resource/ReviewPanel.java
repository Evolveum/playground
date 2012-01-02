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
import org.apache.wicket.model.IModel;

/**
 * @author lazyman
 */
public class ReviewPanel extends WizardPanel<ResourceType> {

    public ReviewPanel(String id, IModel<ResourceType> wizardModel) {
        super(id, wizardModel);
        initLayout();
    }

    @Override
    public IModel<String> getTitle() {
        return createStringResource("ReviewPanel.title", this);
    }

    private void initLayout() {
        //todo add xml editor with full resource xml
    }
}
