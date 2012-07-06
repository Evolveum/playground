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

package com.evolveum.midpoint.forms.web.forms;

import com.evolveum.midpoint.model.security.api.PrincipalUser;
import com.evolveum.midpoint.prism.Item;
import com.evolveum.midpoint.web.security.SecurityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lazyman
 */
public class FormModel {

    private PrincipalUser editor;
    private Map<String, Item> objects = new HashMap<String, Item>();

    private FormModel() {
        this(null);
    }

    private FormModel(Map<String, Item> objects) {
        if (objects != null) {
            this.objects.putAll(objects);
        }
    }

    public Item getObject(String key) {
        return objects.get(key);
    }

    public PrincipalUser getEditor() {
        if (editor == null) {
            editor = SecurityUtils.getPrincipalUser();
        }
        return editor;
    }
}
