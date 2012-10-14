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

import com.evolveum.midpoint.forms.component.ace.AceEditor;
import com.evolveum.midpoint.forms.web.page.dto.EditorDto;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * @author lazyman
 */
public class EditorPanel extends BasePanel<EditorDto> {

    public EditorPanel(String id, IModel<EditorDto> model) {
        super(id, model);
    }

    @Override
    protected void initLayout() {
        TextField text = new TextField("name", new PropertyModel(getModel(), EditorDto.F_NAME));
        add(text);

        AceEditor editor = new AceEditor("editor", new PropertyModel(getModel(), EditorDto.F_XML));
        editor.add(new AjaxFormComponentUpdatingBehavior("onblur") {

            @Override
            protected void onUpdate(AjaxRequestTarget target) {
            }
        });
        add(editor);
    }
}
