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

package com.evolveum.midpoint.forms.web.forms.model;

import com.evolveum.midpoint.forms.web.forms.object.FieldToken;
import com.evolveum.midpoint.prism.PrismPropertyValue;
import com.evolveum.midpoint.prism.PropertyPath;
import com.evolveum.midpoint.prism.delta.PropertyDelta;
import org.apache.commons.lang.Validate;

/**
 * @author lazyman
 */
public class ValueModel<T> {

    private FieldModel field;
    //whatever...? todo
    private PropertyPath path;
    //value for editing
    private PrismPropertyValue<T> value;
    private PrismPropertyValue<T> oldValue;
    //value status
    private ValueStatus status;

    public ValueModel(FieldModel fieldModel) {
        Validate.notNull(fieldModel, "Field model must not be null.");
        this.field = fieldModel;
    }

    public PropertyDelta<T> createPropertyDelta() {
        //todo implement
        return null;
    }
}
