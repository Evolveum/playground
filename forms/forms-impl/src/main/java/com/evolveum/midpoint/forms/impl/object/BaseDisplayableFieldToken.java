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

import com.evolveum.midpoint.forms.impl.StructuredFormContext;
import com.evolveum.midpoint.forms.impl.interpreter.InterpreterContext;
import com.evolveum.midpoint.forms.impl.interpreter.InterpreterException;
import com.evolveum.midpoint.forms.xml.BaseDisplayableFieldType;
import com.evolveum.midpoint.prism.Item;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import java.util.Map;

/**
 * @author lazyman
 */
public abstract class BaseDisplayableFieldToken<T extends BaseDisplayableFieldType> extends BaseFieldToken<T> {

    private static final Trace LOGGER = TraceManager.getTrace(BaseDisplayableFieldToken.class);

    public BaseDisplayableFieldToken(Token parent, T field) {
        super(parent, field);
    }

    protected ReferenceType validateReference(Element refElement, boolean canBeNull)
            throws InterpreterException {
        if (refElement == null && !canBeNull) {
            throw new InterpreterException("Reference element is not defined for displayable field.");
        }

        if (refElement == null) {
            return null;
        }

        return new ReferenceType(refElement);
    }
}
