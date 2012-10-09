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

import com.evolveum.midpoint.forms.web.forms.StructuredFormContext;
import com.evolveum.midpoint.forms.web.forms.interpreter.InterpreterContext;
import com.evolveum.midpoint.forms.web.forms.interpreter.InterpreterException;
import com.evolveum.midpoint.forms.xml.FieldReferenceType;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import org.apache.commons.lang.StringUtils;

/**
 * @author lazyman
 */
public class FieldRefToken extends BaseFieldToken<FieldReferenceType> {

    private static final Trace LOGGER = TraceManager.getTrace(FieldRefToken.class);
    private BaseFieldToken referencedToken;

    public FieldRefToken(Token parent, FieldReferenceType ref) {
        super(parent, ref);
    }

    @Override
    public void interpret(InterpreterContext interpreterContext, StructuredFormContext context) throws InterpreterException {
        LOGGER.debug("interpret {}", new Object[]{this});

        FieldReferenceType reference = getField();
        if (StringUtils.isEmpty(reference.getAlias())) {
            throw new InterpreterException("Field reference alias is empty or not defined.");
        }

        if (StringUtils.isNotEmpty(reference.getInclude())) {
            LOGGER.trace("Looking for include with alias {}.", new Object[]{reference.getInclude()});
            IncludeToken include = getFormToken().getInclude(reference.getInclude());
            if (include == null) {
                throw new InterpreterException("Include with alias '" + reference.getInclude()
                        + "' was not found in form.");
            }
            FormToken includedForm = include.getIncludedFormToken();
            if (includedForm == null) {
                LOGGER.trace("Interpreting included form.");
                include.interpret(interpreterContext, context);
                includedForm = include.getIncludedFormToken();
            }
            LOGGER.trace("Looking for field with name {}.", new Object[]{reference.getAlias()});
            referencedToken = includedForm.getFormItem(reference.getAlias());
        } else {
            LOGGER.trace("Looking for referenced field in current form.");
            referencedToken = getFormToken().getFormItem(reference.getAlias());
        }

        if (referencedToken == null) {
            throw new InterpreterException("Referenced field '" + reference.getAlias() + "' by include '"
                    + reference.getAlias() + "' was not found in included form.");
        }

        LOGGER.debug("Interpreting referenced token '{}'.", new Object[]{referencedToken});

        //todo use overriding "ref" element if it's available
        referencedToken.interpret(interpreterContext, context);
    }

    public BaseFieldToken getReferencedToken() {
        return referencedToken;
    }

    @Override
    public String toString() {
        FieldReferenceType reference = getField();

        StringBuilder builder = new StringBuilder();
        builder.append("FieldRefToken{include=");
        builder.append(reference.getInclude());
        builder.append(", alias=");
        builder.append(reference.getAlias());
        builder.append(", ref=");
        builder.append(reference.getRef() != null ? new ReferenceType(reference.getRef()) : "null");
        builder.append('}');

        return builder.toString();
    }
}
