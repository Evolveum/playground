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

package com.evolveum.midpoint.web.component.wizard;

import org.apache.commons.lang.Validate;
import org.apache.wicket.model.IModel;

/**
 * @author lazyman
 */
public class Breadcrumb<T extends WizardPanel> {

    private Class<T> panelClass;
    private IModel<String> text;

    public Breadcrumb(IModel<String> text, Class<T> panelClass) {
        Validate.notNull(text, "Model with text must not be null.");
        this.text = text;
        this.panelClass = panelClass;
    }

    public IModel<String> getText() {
        return text;
    }

    public Class<T> getPanelClass() {
        return panelClass;
    }
}
