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

import com.evolveum.midpoint.prism.Item;
import org.apache.commons.lang.Validate;
import org.apache.wicket.model.AbstractReadOnlyModel;

/**
 * @author lazyman
 */
public class PathModel<V, T extends Item<?>> extends AbstractReadOnlyModel<T> {

    private String path;
    private Item item;

    public PathModel(Item item, String path) {
        Validate.notNull(item, "Item must not be null.");
        Validate.notEmpty(path, "Path must not be empty.");

        this.item = item;
        this.path = path;
    }

    @Override
    public T getObject() {
        //todo implement
        return null;
    }
}
