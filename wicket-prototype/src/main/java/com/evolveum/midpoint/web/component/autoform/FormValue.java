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

/**
 * @author lazyman
 */
public class FormValue<T extends Serializable> implements Serializable {

    private T value;
    private FormValueStatus status;

    public FormValue() {
        this(null, FormValueStatus.PLACEHOLDER);
    }

    public FormValue(T value) {
        this(value, FormValueStatus.NOT_CHANGED);
    }

    public FormValue(T value, FormValueStatus status) {
        this.value = value;
        this.status = status;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public FormValueStatus getStatus() {
        return status;
    }

    public void setStatus(FormValueStatus status) {
        this.status = status;
    }
}
