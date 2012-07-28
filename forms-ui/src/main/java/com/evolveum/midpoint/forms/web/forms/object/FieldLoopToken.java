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
import com.evolveum.midpoint.forms.web.forms.interpreter.InterpreterException;
import com.evolveum.midpoint.forms.xml.FieldLoopType;
import org.apache.commons.lang.StringUtils;

/**
 * @author lazyman
 */
public class FieldLoopToken extends BaseGroupFieldToken<FieldLoopType> {

    public FieldLoopToken(Token parent, FieldLoopType item) {
        super(parent, item);
    }

    @Override
    public void interpret(StructuredFormContext context) throws InterpreterException {
//        FieldLoopType loopType = getItem();
//        if (StringUtils.isEmpty(loopType.getRef())) {
//            throw new InterpreterException("Field loop type doesn't have ref attribute defined (or it's empty).");
//        }

        //todo check if ref attribute points to list value
        //todo implement
    }
}
