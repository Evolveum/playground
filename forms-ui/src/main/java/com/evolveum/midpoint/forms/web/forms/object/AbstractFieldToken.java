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

import com.evolveum.midpoint.forms.web.forms.interpreter.InterpreterException;
import com.evolveum.midpoint.forms.web.forms.ui.UiRegistry;
import com.evolveum.midpoint.forms.xml.AbstractFieldType;
import com.evolveum.midpoint.forms.xml.DisplayType;
import com.evolveum.midpoint.forms.xml.FieldGroupType;
import com.evolveum.midpoint.forms.xml.FieldType;
import com.evolveum.midpoint.prism.Item;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * @author lazyman
 */
public abstract class AbstractFieldToken<T extends AbstractFieldType> extends ItemToken<T> {

    protected AbstractFieldToken(T item) {
        super(item);
    }

    @Override
    public void interpret(FormToken form, Map<String, Item> objects) throws InterpreterException {
        AbstractFieldType abstractField = getItem();
        DisplayType display = abstractField.getDisplay();
        if (display == null) {
            display = new DisplayType();
            abstractField.setDisplay(display);
        }

        //if type and class is not defined, insert there default values
        if (StringUtils.isEmpty(display.getType()) && StringUtils.isEmpty(display.getClazz())) {
            if (abstractField instanceof FieldType) {
                display.setType(UiRegistry.FIELD_TEXT);
            } else if (abstractField instanceof FieldGroupType) {
                display.setType(UiRegistry.FIELD_GROUP_DEFAULT);
            }
        }

        if (abstractField.getEnabled() == null) {
            //todo implement some default
        }

        if (abstractField.getVisible() == null) {
            //todo implement some default
        }
    }
}
