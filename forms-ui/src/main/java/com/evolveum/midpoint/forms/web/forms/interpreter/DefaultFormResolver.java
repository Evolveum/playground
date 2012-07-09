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

package com.evolveum.midpoint.forms.web.forms.interpreter;

import com.evolveum.midpoint.forms.web.forms.FormModel;
import com.evolveum.midpoint.forms.web.forms.util.StructuredFormUtils;
import com.evolveum.midpoint.forms.xml.FormType;
import org.apache.commons.lang.Validate;
import org.apache.wicket.model.IModel;

import java.io.File;

/**
 * @author lazyman
 */
public class DefaultFormResolver implements FormResolver {

    private String filePath;

    public DefaultFormResolver(String filePath) {
        Validate.notEmpty(filePath, "Path to form xml file must not be empty.");
        this.filePath = filePath;
    }

    @Override
    public FormType loadForm(IModel<FormModel> formModel) {
        File file = new File(filePath);
        if (!file.exists() || !file.canRead()) {
            //todo exception handling
            throw new RuntimeException("File doesn't exist, or can't be read.");
        }

        try {
            FormType formType = StructuredFormUtils.loadForm(file);
            System.out.println();
            return formType;
        } catch (Exception ex) {
            //todo exception handling
            throw new RuntimeException("Couldn't parse file.", ex);
        }
    }
}
