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
import com.evolveum.midpoint.forms.web.forms.interpreter.FormResolver;
import com.evolveum.midpoint.forms.web.forms.interpreter.InterpreterException;
import com.evolveum.midpoint.forms.web.forms.util.StructuredFormUtils;
import com.evolveum.midpoint.forms.xml.FormType;
import com.evolveum.midpoint.forms.xml.IncludeType;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import java.io.File;

/**
 * @author lazyman
 */
public class IncludeToken implements Token {

    private FormToken parent;
    private IncludeType include;

    //included form type
    private FormToken includedFormToken;

    public IncludeToken(FormToken parent, IncludeType include) {
        Validate.notNull(parent, "Parent form token must not be null.");
        Validate.notNull(include, "Include must not be null.");
        this.parent = parent;
        this.include = include;
    }

    @Override
    public Token getParent() {
        return parent;
    }

    @Override
    public void interpret(StructuredFormContext context)
            throws InterpreterException {

        String alias = include.getAlias();
        if (StringUtils.isEmpty(alias)) {
            throw new InterpreterException("Include with path '" + include.getFile()
                    + "' doesn't have defined alias.");
        }

        String filePath = include.getFile();
        if (StringUtils.isEmpty(filePath)) {
            throw new InterpreterException("Include with alias '" + alias + "' doesn't have file path defined.");
        }

        try {
            FormResolver resolver = context.getResolver();
            FormType formType = resolver.loadForm(filePath, context.getUser(),  context.getObjects());
            includedFormToken = new FormToken(formType);
            includedFormToken.interpret(context);
        } catch (Exception ex) {
            throw new InterpreterException("Couldn't load structured form from file '" + filePath
                    + "' defined in <include> with alias '" + alias + "', reason: " + ex.getMessage(), ex);
        }
    }

    public String getAlias() {
        return include.getAlias();
    }

    public FormToken getIncludedFormToken() {
        return includedFormToken;
    }
}
