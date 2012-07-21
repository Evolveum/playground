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

import com.evolveum.midpoint.forms.web.forms.interpreter.InterpreterException;
import com.evolveum.midpoint.forms.xml.FieldReferenceType;
import com.evolveum.midpoint.prism.Item;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * @author lazyman
 */
public class FieldRefToken extends ItemToken<FieldReferenceType> {

    private ItemToken referencedToken;

    public FieldRefToken(FieldReferenceType ref) {
        super(ref);
    }

    @Override
    public void interpret(FormToken form, Map<String, Item> objects) throws InterpreterException {
        FieldReferenceType reference = getItem();
        if (StringUtils.isEmpty(reference.getAlias())) {
            throw new InterpreterException("Field reference alias is empty or not defined.");
        }

        //todo check recursion in here

        if (StringUtils.isNotEmpty(reference.getInclude())) {
            IncludeToken include = form.getInclude(reference.getInclude());
            if (include == null) {
                throw new InterpreterException("Include with alias '" + reference.getInclude()
                        + "' was not found in form.");
            }
            referencedToken = include.getIncludedFormToken().getFormItem(reference.getAlias());
        } else {
            referencedToken = form.getFormItem(reference.getAlias());
        }

        if (referencedToken == null) {
            throw new InterpreterException("Referenced field '" + reference.getAlias() + "' by include '"
                    + reference.getAlias() + "' was not found in included form.");
        }
    }

    public ItemToken getReferencedToken() {
        return referencedToken;
    }
}
