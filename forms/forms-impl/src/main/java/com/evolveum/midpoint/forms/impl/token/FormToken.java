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

package com.evolveum.midpoint.forms.impl.token;

import com.evolveum.midpoint.forms.impl.StructuredFormContext;
import com.evolveum.midpoint.forms.impl.interpreter.InterpreterContext;
import com.evolveum.midpoint.forms.impl.interpreter.InterpreterException;
import com.evolveum.midpoint.xml.ns._public.gui.form_1.*;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

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
    private List<BaseFieldToken> fields = new ArrayList<BaseFieldToken>();

    public FormToken(FormType form) {
        Validate.notNull(form, "Form must not be null.");
        this.form = form;

        //initialize include tokens
        for (IncludeType include : form.getInclude()) {
            includes.add(new IncludeToken(this, include));
        }

        //initialize field, fieldGroup, fieldRef tokens
        for (JAXBElement<? extends BaseFieldType> element : form.getItem()) {
            BaseFieldType item = element.getValue();

            BaseFieldToken token = TokenUtils.createItemToken(this, item);
            if (token == null) {
                continue;
            }
            fields.add(token);
        }
    }

    @Override
    public Token getParent() {
        return null;
    }

    @Override
    public void interpret(InterpreterContext interpreterContext, StructuredFormContext context) throws InterpreterException {
        LOGGER.debug("interpret");
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
            include.interpret(interpreterContext, context);
        }

        //interpret field, fieldGroup, fieldRef
        for (BaseFieldToken item : fields) {
            item.interpret(interpreterContext, context);
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

    public List<BaseFieldToken> getFields() {
        return fields;
    }

    public BaseFieldToken getFormItem(String name) {
        return getFormItem(name, fields);
    }

    private BaseFieldToken getFormItem(String name, List<BaseFieldToken> items) {
        for (BaseFieldToken token : items) {
            if (token instanceof FieldRefToken) {
                continue;
            }

            BaseDisplayableFieldToken<BaseDisplayableFieldType> displayableToken = (BaseDisplayableFieldToken) token;
            BaseDisplayableFieldType fieldType = displayableToken.getField();
            if (name.equals(fieldType.getName())) {
                return displayableToken;
            }

            if (token instanceof BaseGroupFieldToken) {
                BaseGroupFieldToken groupToken = (BaseGroupFieldToken) token;

                BaseFieldToken result = getFormItem(name, groupToken.getFields());
                if (result != null) {
                    return result;
                }
            }
        }

        return null;
    }

    public String getFormName() {
        return form.getName();
    }

    public FormDisplayType getDisplay() {
        return form.getDisplay();
    }
}
