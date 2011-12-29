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

package com.evolveum.midpoint.web.component.objectform;

import com.evolveum.midpoint.schema.processor.Item;
import com.evolveum.midpoint.schema.processor.ItemDefinition;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

/**
 * @author lazyman
 */
public class SomeUnknownClassName<I extends Item, D extends ItemDefinition>
        implements Comparable<SomeUnknownClassName> {

    private I item;
    private D definition;

    public SomeUnknownClassName(I item, D definition) {
        Validate.notNull(definition, "Definition must not be null.");

        this.item = item;
        this.definition = definition;
    }

    public String getDisplayName() {
        String displayName = definition.getDisplayName();
        if (StringUtils.isEmpty(displayName)) {
            displayName = definition.getName().getLocalPart();
        }
        return displayName;
    }

    public I getItem() {
        return item;
    }

    public D getDefinition() {
        return definition;
    }

    @Override
    public int compareTo(SomeUnknownClassName other) {
        return String.CASE_INSENSITIVE_ORDER.compare(getDisplayName(), other.getDisplayName());
    }
}
