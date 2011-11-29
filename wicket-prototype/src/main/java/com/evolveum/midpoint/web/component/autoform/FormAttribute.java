/*
 * Copyright (c) 2011 Evolveum
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
 * Portions Copyrighted 2011 [name of copyright owner]
 */

package com.evolveum.midpoint.web.component.autoform;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FormAttribute implements Serializable {

    private FormAttributeDefinition definition;
    private List<Object> values;

    public FormAttribute(FormAttributeDefinition definition) {
        this(definition, null);
    }

    public FormAttribute(FormAttributeDefinition definition, List<Object> values) {
        if (definition == null) {
            throw new IllegalArgumentException("Form attribute definition must not be null.");
        }
        this.definition = definition;
        this.values = values;
    }

    public FormAttributeDefinition getDefinition() {
        return definition;
    }

    public List<Object> getValues() {
        if (values == null) {
            values = new ArrayList<Object>();
        }
        if (values.isEmpty()) {
            values.add(null);
        }
        return values;
    }

    public int getValuesSize() {
        return getValues().size();
    }

    public boolean canAddValue() {
        if (definition.getMaxOccurs() == -1) {
            return true;
        }

        if (definition.getMaxOccurs() > getValuesSize()) {
            return true;
        }

        return false;
    }

    public boolean canRemoveValue() {
        if (definition.getMinOccurs() < getValuesSize()) {
            return true;
        }

        return false;
    }

//    public void addValue(ActionEvent evt) {
//        getValues().add(null);
//    }
//
//    public void removeValue(int index) {
//        getValues().remove(index);
//    }
//
//    public void clearEmptyValues() {
//        if (getValuesSize() == 0) {
//            return;
//        }
//        List<Object> toBeDeleted = new ArrayList<Object>();
//        toBeDeleted.add("");
//        toBeDeleted.add(null);
//        getValues().removeAll(toBeDeleted);
//    }
//
//    @Override
//    public String toString() {
//        return definition.getElementName() + ":" + values.size();
//    }
//
//    boolean isChanged() {
//        return change != null;
//    }
//
//    Change getChangeType() {
//        return change;
//    }
//
//    void clearChanges() {
//        change = null;
//    }
}
