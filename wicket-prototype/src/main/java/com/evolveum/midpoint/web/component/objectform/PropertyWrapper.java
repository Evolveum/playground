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

package com.evolveum.midpoint.web.component.objectform;

import com.evolveum.midpoint.schema.processor.Property;
import com.evolveum.midpoint.schema.processor.PropertyDefinition;
import com.evolveum.midpoint.schema.processor.PropertyValue;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lazyman
 */
public class PropertyWrapper implements Serializable, Comparable<PropertyWrapper> {

    private Property property;
    private ValueStatus status;
    private List<PropertyValueWrapper> values;

    public PropertyWrapper(Property property) {
        this(property, ValueStatus.NOT_CHANGED);
    }

    public PropertyWrapper(Property property, ValueStatus status) {
        Validate.notNull(property, "Property must not be null.");
        this.property = property;
        this.status = status;
    }

    public Property getProperty() {
        return property;
    }

    public ValueStatus getStatus() {
        return status;
    }

    public List<PropertyValueWrapper> getPropertyValueWrappers() {
        if (values != null) {
            return values;
        }

        values = new ArrayList<PropertyValueWrapper>();
        for (PropertyValue value : property.getValues()) {
            values.add(new PropertyValueWrapper(this, value, ValueStatus.NOT_CHANGED));
        }

        if (values.isEmpty()) {
            values.add(new PropertyValueWrapper(this, new PropertyValue(null), ValueStatus.ADDED));
        }

        return values;
    }

    public String getDisplayName() {
        PropertyDefinition definition = property.getDefinition();
        String displayName = definition.getDisplayName();
        if (StringUtils.isEmpty(displayName)) {
            displayName = definition.getName().getLocalPart();
        }
        return displayName;
    }

    public int compareTo(PropertyWrapper other) {
        return String.CASE_INSENSITIVE_ORDER.compare(getDisplayName(), other.getDisplayName());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(property.getName().getLocalPart());
        builder.append(", ");
        builder.append(status);
        builder.append("\n");
        for (PropertyValueWrapper wrapper : getPropertyValueWrappers()) {
            builder.append("\t");
            builder.append(wrapper.toString());
            builder.append("\n");
        }

        return builder.toString();
    }
}
