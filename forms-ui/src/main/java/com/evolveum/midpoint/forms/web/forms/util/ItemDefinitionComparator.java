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

package com.evolveum.midpoint.forms.web.forms.util;

import com.evolveum.midpoint.prism.ItemDefinition;
import org.apache.commons.lang.StringUtils;

import java.util.Comparator;

/**
 * This class provides simple comparation for prism items using item definitions {@link ItemDefinition}.
 * At first it tries to sort through {@link com.evolveum.midpoint.prism.ItemDefinition#getDisplayOrder()},
 * otherwise algorithm uses {@link com.evolveum.midpoint.prism.ItemDefinition#getDisplayName()}. Display
 * name is compared without localization (e.g. in raw format - not translated).
 *
 * @author lazyman
 */
public class ItemDefinitionComparator implements Comparator<ItemDefinition> {

    @Override
    public int compare(ItemDefinition def1, ItemDefinition def2) {
        Integer index1 = def1.getDisplayOrder();
        Integer index2 = def2.getDisplayOrder();
        if (index1 != null && index2 != null) {
            return index1 - index2;
        } else if (index1 != null && index2 == null) {
            return -1;
        } else if (index1 == null && index2 != null) {
            return 1;
        }

        return String.CASE_INSENSITIVE_ORDER.compare(getDisplayName(def1), getDisplayName(def2));
    }

    private String getDisplayName(ItemDefinition def) {
        String displayName = def.getDisplayName();

        if (StringUtils.isNotEmpty(displayName)) {
            return displayName;
        }

        return def.getNameOrDefaultName().getLocalPart();
    }
}
