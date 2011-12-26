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

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;

import java.io.Serializable;

/**
 * @author lazyman
 */
public abstract class WizardPanel<T extends Serializable> extends Panel {

    private IModel<T> wizardModel;

    public WizardPanel(String id) {
        super(id, null);
    }

    public WizardPanel(String id, IModel<T> wizardModel) {
        super(id);
        this.wizardModel = wizardModel;
    }

    public abstract IModel<String> getTitle();

    protected IModel<T> getWizardModel() {
        return wizardModel;
    }

    public IModel<String> getBreadcrumbsTitle() {
        return getTitle();
    }

    public boolean showNext() {
        return false;
    }

    public boolean showPrevious() {
        return false;
    }

    public boolean showCancel() {
        return false;
    }

    public boolean showFinish() {
        return false;
    }

    public boolean isNextEnabled() {
        return true;
    }

    public boolean isPreviousEnabled() {
        return true;
    }

    public boolean isCancelEnabled() {
        return true;
    }

    public boolean isFinishEnabled() {
        return true;
    }

    public void performAfterNext(AjaxRequestTarget target) {
    }

    public void performAfterPrevious(AjaxRequestTarget target) {
    }

    public void performAfterCancel(AjaxRequestTarget target) {
    }

    public void performAfterFinish(AjaxRequestTarget target) {
    }

    protected StringResourceModel createStringResource(String resourceKey, Component component) {
        return new StringResourceModel(resourceKey, component, null, null, null);
    }
}
