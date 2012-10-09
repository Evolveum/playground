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

import com.evolveum.midpoint.prism.PrismContext;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lazyman
 */
public class InterpreterContext {

    private PrismContext prismContext;
    private Set<String> includePaths = new HashSet<String>();

    public PrismContext getPrismContext() {
        return prismContext;
    }

    public void addIncludePath(String path) {
        includePaths.add(path);
    }

    public boolean containsIncludePath(String path) {
        return includePaths.contains(path);
    }
}
