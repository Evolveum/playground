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

package com.evolveum.midpoint.forms.impl.ui.widget;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.validator.AbstractValidator;

/**
 * @author lazyman
 */
public class PasswordWidgetValidator extends AbstractValidator {

    private PasswordTextField p1;
    private PasswordTextField p2;

    public PasswordWidgetValidator(PasswordTextField p1, PasswordTextField p2) {
        Validate.notNull(p1, "Password field one must not be null.");
        Validate.notNull(p2, "Password field two must not be null.");

        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    protected void onValidate(IValidatable validatable) {
        String s1 = p1.getValue();
        String s2 = p2.getValue();

        if (StringUtils.isEmpty(s1) && StringUtils.isEmpty(s2)) {
            return;
        }

        boolean equal = s1 != null ? s1.equals(s2) : s2 == null;
        if (!equal) {
            error(p1.newValidatable(), "passwordPanel.error");
        }
    }
}
