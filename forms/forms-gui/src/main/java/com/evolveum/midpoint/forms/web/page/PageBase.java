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

package com.evolveum.midpoint.forms.web.page;

import com.evolveum.midpoint.forms.web.MidPointApplication;
import com.evolveum.midpoint.prism.PrismContext;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import org.apache.wicket.devutils.debugbar.DebugBar;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.FeedbackMessages;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;

import java.util.Iterator;

/**
 * @author lazyman
 */
public abstract class PageBase extends WebPage {

    private static final Trace LOGGER = TraceManager.getTrace(PageBase.class);
    private boolean initialized;

    public PageBase() {
//        Injector.get().inject(this);
    }

    @Override
    protected void onBeforeRender() {
        super.onBeforeRender();

        if (initialized) {
            return;
        }

        initLayout();
        initialized = true;
    }

    protected void initLayout() {
        Label title = new Label("pageHeadTitle", createPageTitleModel());
        title.setRenderBodyOnly(true);
        add(title);

        DebugBar debugPanel = new DebugBar("debugPanel");
        add(debugPanel);

        add(new Label("pageTitle", createPageTitleModel()));

        FeedbackPanel feedback = new FeedbackPanel("feedback");
        feedback.setOutputMarkupId(true);
        add(feedback);
    }

    public WebMarkupContainer getFeedbackPanel() {
        return (WebMarkupContainer) get("feedback");
    }

    private void validateInjection(Object object, String message) {
        if (object == null) {
            throw new IllegalStateException(message);
        }
    }

    protected MidPointApplication getMidpointApplication() {
        return (MidPointApplication) getApplication();
    }

    protected PrismContext getPrismContext() {
        return getMidpointApplication().getPrismContext();
    }

    protected IModel<String> createPageTitleModel() {
        return createStringResource("page.title");
    }

    public String getString(String resourceKey, Object... objects) {
        return createStringResource(resourceKey, objects).getString();
    }

    public StringResourceModel createStringResource(String resourceKey, Object... objects) {
        return new StringResourceModel(resourceKey, this, null, resourceKey, objects);
    }

    public StringResourceModel createStringResource(Enum e) {
        String resourceKey = e.getDeclaringClass().getSimpleName() + "." + e.name();
        return createStringResource(resourceKey);
    }
}
