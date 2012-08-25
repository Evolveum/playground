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

package com.evolveum.midpoint.forms.web.page.dto;

import com.evolveum.midpoint.forms.web.forms.interpreter.FormResolver;
import com.evolveum.midpoint.forms.web.forms.util.StructuredFormUtils;
import com.evolveum.midpoint.forms.xml.FormType;
import com.evolveum.midpoint.prism.Item;
import com.evolveum.midpoint.prism.PrismObject;
import com.evolveum.midpoint.xml.ns._public.common.common_2.UserType;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author lazyman
 */
public class EditorFormResolver implements FormResolver {

    private List<FormDto> editors;

    public EditorFormResolver(List<FormDto> editors) {
        Validate.notNull(editors, "Editor list must not be null.");
        this.editors = editors;
    }

    @Override
    public FormType loadForm(String identifier, PrismObject<UserType> user, Map<String, Item> objects) {
        for (EditorDto editor : editors) {
            if (identifier.equals(editor.getName())) {
                return loadForm(editor.getXml());
            }
        }

        return null;
    }

    @Override
    public FormType loadForm(PrismObject<UserType> user, Map<String, Item> objects) {
        for (FormDto editor : editors) {
            if (editor.isMain()) {
                return loadForm(editor.getName(), user, objects);
            }
        }

        return null;
    }

    private FormType loadForm(String xml) {
        if (StringUtils.isEmpty(xml)) {
            return null;
        }

        try {
            InputStream is = new ByteArrayInputStream(xml.getBytes("utf-8"));
            return StructuredFormUtils.loadForm(is);
        } catch (Exception ex) {
            //todo exception handling
            throw new RuntimeException("Couldn't parse file.", ex);
        }
    }
}
