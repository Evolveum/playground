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

import com.evolveum.midpoint.forms.web.forms.object.FormToken;
import com.evolveum.midpoint.forms.xml.FormDisplayType;
import com.evolveum.midpoint.prism.Item;
import com.evolveum.midpoint.prism.delta.ItemDelta;
import com.evolveum.midpoint.prism.delta.ObjectDelta;
import com.evolveum.midpoint.xml.ns._public.common.common_2.ObjectType;

import java.util.Map;

/**
 * @author lazyman
 */
public class FormModel extends BaseGroupModel<FormModel, FormToken> {

    public FormModel(FormToken token, Map<String, Item> objects) {
        super(null, token, objects);
    }

    public String getTheme() {
        FormToken token = getToken();
        FormDisplayType display = token.getDisplay();
        return display != null ? display.getTheme() : null;
    }

    public <T extends ObjectType> ObjectDelta<T> getObjectDelta(String object) {
        //todo implement
        return null;
    }

    public <T extends ItemDelta> T getItemDelta(String object, Class<T> deltaType) {
        //todo implement
        return null;
    }
}
