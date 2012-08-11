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

import com.evolveum.midpoint.forms.web.forms.interpreter.FormResolver;
import com.evolveum.midpoint.prism.Item;
import com.evolveum.midpoint.prism.PrismObject;
import com.evolveum.midpoint.xml.ns._public.common.common_2.UserType;
import org.apache.commons.lang.Validate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lazyman
 */
public class StructuredFormContext implements Serializable {

    private PrismObject<UserType> user;
    private Map<String, Item> objects;
    private FormResolver resolver;

    public StructuredFormContext(PrismObject<UserType> user, Map<String, Item> objects, FormResolver resolver) {
        Validate.notNull(user, "PrismObject user must not be null.");
        Validate.notNull(resolver, "Form resolver must not be null.");

        this.objects = objects;
        if (this.objects == null) {
            this.objects = new HashMap<String, Item>();
        }
        this.resolver = resolver;
        this.user = user;
    }

    public Map<String, Item> getObjects() {
        return objects;
    }

    public FormResolver getResolver() {
        return resolver;
    }

    public PrismObject<UserType> getUser() {
        return user;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("StructuredFormContext{user: ");
        builder.append(user != null ? user.toDebugName() : null);
        builder.append(", objects: ");
        builder.append(objects != null ? objects.toString() : null);
        builder.append(", resolver: ");
        builder.append(resolver != null ? resolver.getClass().getName() : null);
        builder.append("}");

        return builder.toString();
    }
}
