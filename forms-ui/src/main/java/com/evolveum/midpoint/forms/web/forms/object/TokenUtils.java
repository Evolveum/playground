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

package com.evolveum.midpoint.forms.web.forms.object;

import com.evolveum.midpoint.forms.web.forms.ui.UiRegistry;
import com.evolveum.midpoint.forms.xml.*;
import com.evolveum.midpoint.prism.PrismPropertyDefinition;
import com.evolveum.midpoint.util.DOMUtil;
import com.evolveum.midpoint.util.exception.SystemException;
import com.evolveum.midpoint.xml.ns._public.common.common_2.ProtectedStringType;

/**
 * @author lazyman
 */
public class TokenUtils {

    public static BaseFieldToken createItemToken(Token parent, BaseFieldType item) {
        BaseFieldToken token;
        if (item instanceof FieldType) {
            token = new FieldToken(parent, (FieldType) item);
        } else if (item instanceof FieldGroupType) {
            token = new FieldGroupToken(parent, (FieldGroupType) item);
        } else if (item instanceof FieldReferenceType) {
            token = new FieldRefToken(parent, (FieldReferenceType) item);
        } else if (item instanceof FieldLoopType) {
            token = new FieldLoopToken(parent, (FieldLoopType) item);
        } else {
            throw new SystemException("Unsupported token type '" + item.getClass().getName() + "'.");
        }

        return token;
    }

    public static String getDefaultWidget(PrismPropertyDefinition definition) {
        if (DOMUtil.XSD_DATETIME.equals(definition.getTypeName())) {
            return UiRegistry.WIDGET_DATE;
        } else if (ProtectedStringType.COMPLEX_TYPE.equals(definition.getTypeName())) {
            return UiRegistry.WIDGET_PASSWORD;
        } else if (DOMUtil.XSD_BOOLEAN.equals(definition.getTypeName())) {
            return UiRegistry.WIDGET_CHECKBOX;
        }

        return UiRegistry.WIDGET_DEFAULT;
    }
}
