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
import org.apache.wicket.model.IModel;

/**
 * @author lazyman
 */
public abstract class BaseWizardPanel extends WizardPanel {

    public BaseWizardPanel(String id) {
        super(id);
    }

    @Override
    public IModel<String> getBreadcrumbsTitle() {
        return getTitle();
    }

    @Override
    public boolean showNext() {
        return false;
    }

    @Override
    public boolean showPrevious() {
        return false;
    }

    @Override
    public boolean showCancel() {
        return false;
    }

    @Override
    public boolean showFinish() {
        return false;
    }

    @Override
    public void performAfterNext(AjaxRequestTarget target) {
    }

    @Override
    public void performAfterPrevious(AjaxRequestTarget target) {
    }

    @Override
    public void performAfterCancel(AjaxRequestTarget target) {
    }

    @Override
    public void performAfterFinish(AjaxRequestTarget target) {
    }
}
