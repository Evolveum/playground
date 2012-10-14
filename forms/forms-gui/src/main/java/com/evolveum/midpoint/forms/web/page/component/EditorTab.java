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

package com.evolveum.midpoint.forms.web.page.component;

import com.evolveum.midpoint.forms.web.page.dto.EditorDto;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * @author lazyman
 */
public class EditorTab extends AbstractTab {

    private IModel<EditorDto> model;

    public EditorTab(IModel<EditorDto> model) {
        super(new PropertyModel<String>(model,  EditorDto.F_NAME));
        this.model = model;
    }

    @Override
    public WebMarkupContainer getPanel(String panelId) {
        EditorPanel panel = new EditorPanel(panelId, model);
        panel.setOutputMarkupId(true);

        return panel;
    }

    public IModel<EditorDto> getModel() {
        return model;
    }
}
