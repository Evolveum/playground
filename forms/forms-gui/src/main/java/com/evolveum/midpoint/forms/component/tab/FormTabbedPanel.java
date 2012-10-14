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

package com.evolveum.midpoint.forms.component.tab;

import com.evolveum.midpoint.forms.web.page.component.EditorTab;
import org.apache.wicket.Component;
import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * @author lazyman
 */
public class FormTabbedPanel extends AjaxTabbedPanel<EditorTab> {

    public FormTabbedPanel(String id, List<EditorTab> tabs) {
        super(id, tabs);
    }

    @Override
    protected Component newTitle(String titleId, IModel<?> titleModel, int index) {
        EditorTab tab = getTabs().get(index);

        return new IconPanel(titleId, (IModel) titleModel, tab.getModel());
    }
}
