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

package com.evolveum.midpoint.forms.web.forms.ui;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

/**
 * @author lazyman
 */
public final class UiFactory {

    private UiFactory() {
    }

    public static Label createErrorLabel(String id, IModel<String> model) {
        Label label = new Label(id, model);
        label.add(new AttributeModifier("class", "UiFormError"));

        return label;
    }

    public static <T> IModel<T> createReadOnlyModel(final T object) {
        return new AbstractReadOnlyModel<T>() {

            @Override
            public T getObject() {
                return object;
            }
        };
    }
}
