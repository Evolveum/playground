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

package com.evolveum.midpoint.web.component.objectform.input;

import com.evolveum.midpoint.web.component.objectform.InputPanel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

public class TextPanel<T> extends InputPanel {

    public TextPanel(String id, IModel<T> model) {
        super(id);

        TextField<T> text = new TextField<T>("input", model);
//        text.add(new AjaxEventBehavior("onFocus") {
//
//            @Override
//            protected void onEvent(AjaxRequestTarget target) {
//                System.out.println("onFocus");
//            }
//        });
        text.add(new AjaxFormComponentUpdatingBehavior("onFocus") {

            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                System.out.println("onFocus");
            }
        });
        add(text);
    }

    @Override
    public FormComponent getComponent() {
        return (FormComponent) get("input");
    }
}
