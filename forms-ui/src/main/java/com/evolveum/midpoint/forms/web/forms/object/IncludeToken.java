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

import com.evolveum.midpoint.forms.web.forms.FormModel;
import com.evolveum.midpoint.forms.web.forms.interpreter.InterpreterException;
import com.evolveum.midpoint.forms.web.forms.util.StructuredFormUtils;
import com.evolveum.midpoint.forms.xml.FormType;
import com.evolveum.midpoint.forms.xml.IncludeType;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

import java.io.File;

/**
 * @author lazyman
 */
public class IncludeToken implements Token {

    private IncludeType include;

    //included form type
    private FormType formType;

    public IncludeToken(IncludeType include) {
        Validate.notNull(include, "Include must not be null.");
        this.include = include;
    }

    @Override
    public Component interpret(String componentId, IModel<FormModel> formModel, FormToken token)
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

        File formFile = new File(filePath);
        if (!formFile.isAbsolute()) {
            File parent = new File(".");    //todo fix parent path, should be ${midpoint.home}/forms

            formFile = new File(parent, filePath);
        }

        if (!formFile.exists() || !formFile.canRead()) {
            throw new InterpreterException("Include with alias '" + alias + "' with path '"
                    + formFile.getAbsolutePath() + "' points to file which doesn't exist or can't be read.");
        }

        try {
            formType = StructuredFormUtils.loadForm(formFile);
        } catch (Exception ex) {
            throw new InterpreterException("Couldn't load structured form from file '" + formFile.getAbsolutePath()
                    + "' defined in <include> with alias '" + alias + "', reason: " + ex.getMessage(), ex);
        }

        return null;
    }

    String getAlias() {
        return include.getAlias();
    }

    FormType getForm() {
        return formType;
    }
}
