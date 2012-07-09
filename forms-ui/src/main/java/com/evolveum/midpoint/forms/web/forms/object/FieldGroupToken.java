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

package com.evolveum.midpoint.forms.web.forms.object;

import com.evolveum.midpoint.forms.web.forms.FormModel;
import com.evolveum.midpoint.forms.web.forms.interpreter.InterpreterException;
import com.evolveum.midpoint.forms.web.forms.ui.FieldGroup;
import com.evolveum.midpoint.forms.web.forms.ui.group.DefaultFieldGroup;
import com.evolveum.midpoint.forms.web.forms.util.StructuredFormUtils;
import com.evolveum.midpoint.forms.xml.DisplayType;
import com.evolveum.midpoint.forms.xml.FieldGroupType;
import com.evolveum.midpoint.forms.xml.FormItemType;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

import javax.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lazyman
 */
public class FieldGroupToken extends AbstractFieldToken<FieldGroupType> {

    private List<ItemToken> items = new ArrayList<ItemToken>();

    public FieldGroupToken(FieldGroupType field) {
        super(field);

        //initialize field, fieldGroup, fieldRef tokens
        for (JAXBElement<? extends FormItemType> element : field.getItem()) {
            FormItemType item = element.getValue();
            items.add(StructuredFormUtils.createItemToken(item, false));
        }
    }

    @Override
    public Component interpret(String componentId, IModel<FormModel> formModel, FormToken form)
            throws InterpreterException {

        DisplayType display = item.getDisplay();

        FieldGroup groupComponent;
        if (display == null) {
            groupComponent = new DefaultFieldGroup(componentId);
        } else {

        }


        for (ItemToken token : items) {
            token.interpret(componentId, formModel, form);
        }

        return null;
    }
}
