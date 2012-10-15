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

package com.evolveum.midpoint.forms.impl.object;

import com.evolveum.midpoint.forms.xml.BaseFieldType;
import org.apache.commons.lang.Validate;

/**
 * @author lazyman
 */
public abstract class BaseFieldToken<T extends BaseFieldType> implements Token {

    private Token parent;
    private T field;

    public BaseFieldToken(Token parent, T field) {
        Validate.notNull(parent, "Parent token must not be null.");
        Validate.notNull(field, "Field type must not be null.");
        this.parent = parent;
        this.field = field;
    }

    @Override
    public Token getParent() {
        return parent;
    }

    public T getField() {
        return field;
    }

    protected FormToken getFormToken() {
        return getFormToken(this);
    }

    private FormToken getFormToken(Token token) {
        if (token instanceof FormToken) {
            return (FormToken)token;
        }

        return getFormToken(token.getParent());
    }
}
