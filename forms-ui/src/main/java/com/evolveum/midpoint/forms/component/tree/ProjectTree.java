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

package com.evolveum.midpoint.forms.component.tree;

import org.apache.wicket.markup.html.tree.LinkTree;
import org.apache.wicket.model.IModel;

import javax.swing.tree.TreeModel;

/**
 * @author lazyman
 */
public class ProjectTree extends LinkTree {

    public ProjectTree(String id, IModel<? extends TreeModel> model) {
        super(id, model);
    }
}
