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

package com.evolveum.midpoint.forms.web.forms.ui.field;

import com.evolveum.midpoint.forms.web.forms.ui.InputField;
import org.apache.wicket.markup.html.form.TextField;

/**
 * @author lazyman
 */
public class InputTextField extends InputField {

    public InputTextField(String id) {
        super(id);

        initLayout();
    }

    private void initLayout() {
        TextField text = new TextField("input");
        add(text);

        //todo impl text value, style, etc...
    }
}
