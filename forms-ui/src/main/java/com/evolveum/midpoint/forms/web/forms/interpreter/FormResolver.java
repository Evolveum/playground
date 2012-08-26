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

import com.evolveum.midpoint.forms.xml.FormType;
import com.evolveum.midpoint.prism.Item;
import com.evolveum.midpoint.prism.PrismObject;
import com.evolveum.midpoint.xml.ns._public.common.common_2.UserType;

import java.io.Serializable;
import java.util.Map;

/**
 * @author lazyman
 */
public interface FormResolver extends Serializable {

    FormType loadForm(PrismObject<UserType> user, Map<String, Item> objects) throws FormResolverException;

    FormType loadForm(String identifier, PrismObject<UserType> user, Map<String, Item> objects) throws FormResolverException;
}
