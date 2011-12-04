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

import org.apache.commons.lang.Validate;

import javax.xml.namespace.QName;
import java.io.Serializable;

/**
 * @author lazyman
 */
public class Change<T> implements Serializable {

    public static enum Type {ADD, MODIFY, DELETE}

    ;

    private QName qname;
    private Type type;
    private T oldValue;
    private T newValue;

    public Change(QName qname, Type type, T oldValue, T newValue) {
        Validate.notNull(qname, "QName must not be null.");
        Validate.notNull(type, "Change type must not be null.");

        this.qname = qname;
        this.type = type;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public QName getQname() {
        return qname;
    }

    public Type getType() {
        return type;
    }

    public T getOldValue() {
        return oldValue;
    }

    public T getNewValue() {
        return newValue;
    }
}
