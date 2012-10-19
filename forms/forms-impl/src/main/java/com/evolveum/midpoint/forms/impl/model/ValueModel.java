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

package com.evolveum.midpoint.forms.impl.model;

import com.evolveum.midpoint.xml.ns._public.gui.form_1.FieldDisplayType;
import com.evolveum.midpoint.prism.PrismPropertyValue;
import com.evolveum.midpoint.prism.polystring.PolyString;
import org.apache.commons.lang.Validate;

import java.io.Serializable;

/**
 * @author lazyman
 */
public class ValueModel<T> implements Serializable {

    private FieldModel field;
    //value for editing
    private PrismPropertyValue<T> value;
    private PrismPropertyValue<T> oldValue;
    //value status
    private ItemStatus status;

    public ValueModel(FieldModel fieldModel, PrismPropertyValue<T> value, ItemStatus status) {
        this(fieldModel, value, null, status);
    }

    public ValueModel(FieldModel fieldModel, PrismPropertyValue<T> value, PrismPropertyValue<T> oldValue,
                      ItemStatus status) {
        Validate.notNull(fieldModel, "Field model must not be null.");
        Validate.notNull(value, "Prism property value must not be null.");
        this.field = fieldModel;
        this.value = value;
        this.status = status;

        //clone values, because we don't want to update original prism object that is used in main model.
        if (value != null) {
            T val = value.getValue();
            if (val instanceof PolyString) {
                PolyString poly = (PolyString) val;
                this.value = new PrismPropertyValue(new PolyString(poly.getOrig(), poly.getNorm()),
                        value.getOriginType(), value.getOriginObject());
            } else {
                this.value = value.clone();
            }
        }

        if (oldValue == null) {
            T val = this.value.getValue();
            if (val instanceof PolyString) {
                PolyString poly = (PolyString) val;
                val = (T) new PolyString(poly.getOrig(), poly.getNorm());
            }
            oldValue = new PrismPropertyValue<T>(val, this.value.getOriginType(), this.value.getOriginObject());
        }
        this.oldValue = oldValue;
    }

    public PrismPropertyValue<T> getOldValue() {
        return oldValue;
    }

    public PrismPropertyValue<T> getValue() {
        return value;
    }

    public FieldModel getField() {
        return field;
    }

    public FieldDisplayType getDefaultDisplay() {
        return field.getDefaultDisplay();
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    public int getVisibleValueIndex() {
        return field.getVisibleValues().indexOf(this);
    }

    public boolean isAddButtonVisible() {
        int size = field.getVisibleValues().size();
        FieldDisplayType display = field.getDefaultDisplay();
        if (display.getMaxOccurs() < 0) {
            return true;
        }

        if (size + 1 > display.getMaxOccurs()) {
            return false;
        }

        return true;
    }

    public boolean isRemoveButtonVisible() {
        int size = field.getVisibleValues().size();
        if (size == 1) {
            return false;
        }

        FieldDisplayType display = field.getDefaultDisplay();
        if (size - 1 < display.getMinOccurs()) {
            return false;
        }

        return true;
    }
}
