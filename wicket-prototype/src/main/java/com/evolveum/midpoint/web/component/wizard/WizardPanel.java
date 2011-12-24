/*
 * Copyright (c) 2011 Evolveum
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
 * Portions Copyrighted 2011 [name of copyright owner]
 */

package com.evolveum.midpoint.web.component.wizard;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * @author lazyman
 */
public abstract class WizardPanel extends Panel {

    public WizardPanel(String id) {
        super(id);
    }

    public WizardPanel(String id, IModel model) {
        super(id, model);
    }

    public abstract IModel<String> getBreadcrumbsTitle();

    public abstract IModel<String> getTitle();

    public abstract void initLayout(IModel<Wizard> wizardModel);

    public abstract boolean showNext();

    public abstract boolean showPrevious();

    public abstract boolean showCancel();

    public abstract boolean showFinish();

    public abstract void performAfterNext(AjaxRequestTarget target);

    public abstract void performAfterPrevious(AjaxRequestTarget target);

    public abstract void performAfterCancel(AjaxRequestTarget target);

    public abstract void performAfterFinish(AjaxRequestTarget target);
}
