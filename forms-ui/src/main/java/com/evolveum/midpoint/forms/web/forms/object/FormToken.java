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
import com.evolveum.midpoint.forms.xml.*;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.wicket.model.IModel;

import javax.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lazyman
 */
public class FormToken implements Token {

    private static final Trace LOGGER = TraceManager.getTrace(FormToken.class);

    private FormType form;

    private List<IncludeToken> includes = new ArrayList<IncludeToken>();
    private List<ItemToken> items = new ArrayList<ItemToken>();

    public FormToken(FormType form) {
        Validate.notNull(form, "Form must not be null.");
        this.form = form;

        //initialize include tokens
        for (IncludeType include : form.getInclude()) {
            includes.add(new IncludeToken(include));
        }

        //initialize field, fieldGroup, fieldRef tokens
        for (JAXBElement<? extends FormItemType> element : form.getItem()) {
            FormItemType item = element.getValue();

            ItemToken token = StructuredFormUtils.createItemToken(item, true);
            if (token == null) {
                continue;
            }
            items.add(token);
        }
    }

    @Override
    public void interpret(IModel<FormModel> formModel, FormToken form) throws InterpreterException {

        //include alias uniqueness check
        Set<String> aliases = new HashSet<String>();
        for (IncludeType include : this.form.getInclude()) {
            String alias = include.getAlias();
            if (StringUtils.isEmpty(alias)) {
                continue;
            }
            if (aliases.contains(alias)) {
                throw new InterpreterException("Form contains two includes with equal alias '" + alias + "'.");
            }
            aliases.add(alias);
        }

        //interpret includes
        for (IncludeToken include : includes) {
            include.interpret(formModel, form);
        }

        //interpret field, fieldGroup, fieldRef
        for (ItemToken item : items) {
            item.interpret(formModel, form);
        }
    }

    public IncludeToken getInclude(String alias) {
        Validate.notNull(alias, "Include alias must not be null.");
        for (IncludeToken include : includes) {
            if (alias.equals(include.getAlias())) {
                return include;
            }
        }

        return null;
    }

    public List<ItemToken> getItems() {
        return items;
    }

    public AbstractFieldToken getFormItem(String name) {
        return getFormItem(name, items);
    }

    private AbstractFieldToken getFormItem(String name, List<ItemToken> items) {
        for (ItemToken token : items) {
            if (token instanceof FieldRefToken) {
                continue;
            }

            AbstractFieldToken<AbstractFieldType> fieldToken = (AbstractFieldToken)token;
            AbstractFieldType fieldType = fieldToken.getItem();
            if (name.equals(fieldType.getName())) {
                return fieldToken;
            }

            if (token instanceof FieldGroupToken) {
                FieldGroupToken groupToken = (FieldGroupToken) token;

                AbstractFieldToken result = getFormItem(name, groupToken.getItems());
                if (result != null) {
                    return  result;
                }
            }
        }

        return null;
    }
}
