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

import com.evolveum.midpoint.xml.ns._public.gui.form_1.BaseGroupFieldType;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazyman
 */
public abstract class BaseGroupFieldToken<T extends BaseGroupFieldType> extends BaseDisplayableFieldToken<T> {

    private static final Trace LOGGER = TraceManager.getTrace(BaseGroupFieldToken.class);
    private List<BaseFieldToken> fields = new ArrayList<BaseFieldToken>();

    public BaseGroupFieldToken(Token parent, T field) {
        super(parent, field);
    }

    public List<BaseFieldToken> getFields() {
        return fields;
    }
}
