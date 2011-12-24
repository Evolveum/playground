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

import com.evolveum.midpoint.web.component.button.AjaxLinkButton;
import com.evolveum.midpoint.web.component.util.LoadableModel;
import org.apache.commons.lang.Validate;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.request.resource.PackageResourceReference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazyman
 */
public abstract class WizardForm extends Panel {

    public static final String WIZARD_PANEL_ID = "wizardPanel";
    private List<WizardPanel> panels;
    private boolean showTitle = true;

    public WizardForm(String id) {
        super(id);

        panels = initPanels();
        Validate.notNull(panels, "List with wizard panels must not be null.");

        initComponents();
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.renderCSSReference(new PackageResourceReference(WizardForm.class, "WizardForm.css"));
    }

    public boolean isShowTitle() {
        return showTitle;
    }

    public void setShowTitle(boolean showTitle) {
        this.showTitle = showTitle;
    }

    public abstract List<WizardPanel> initPanels();

    private void initComponents() {
        //breadcrumbs
        initBreadcrumbs();
        //title
        Label title = new Label("title", getSelectedPanel().getTitle());
        title.setVisible(showTitle);
        add(title);
        //content
        add(getSelectedPanel());
        //buttons
        initButtons();
    }

    private void initBreadcrumbs() {
        IModel<List<Breadcrumb>> crumbsModel = new LoadableModel<List<Breadcrumb>>() {

            @Override
            protected List<Breadcrumb> load() {
                List<Breadcrumb> list = new ArrayList<Breadcrumb>();
                for (WizardPanel panel : panels) {
                    list.add(new Breadcrumb(panel.getBreadcrumbsTitle(), panel.getClass()));
                }

                return list;
            }
        };

        ListView<Breadcrumb> breadcrumbs = new ListView<Breadcrumb>("breadcrumbs", crumbsModel) {

            @Override
            protected void populateItem(ListItem<Breadcrumb> item) {
                Breadcrumb breadcrumb = item.getModelObject();
                Label label = new Label("label", breadcrumb.getText());
                item.add(label);

                if (getSelectedPanel().getClass().equals(breadcrumb.getPanelClass())) {
                    label.add(new AttributeAppender("class", new Model<String>("selected"), " "));
                }
            }
        };
        add(breadcrumbs);
    }

    private StringResourceModel createStringResource(String resourceKey) {
        return new StringResourceModel(resourceKey, this, null, null, null);
    }

    private void initButtons() {
        //cancel
        AjaxLinkButton button = new AjaxLinkButton("cancelButton", createStringResource("button.cancel")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                cancelPerformed(target);
            }
        };
        add(button);
        //previous
        button = new AjaxLinkButton("previousButton", createStringResource("button.previous")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                previousPerformed(target);
            }
        };
        add(button);
        //next
        button = new AjaxLinkButton("nextButton", createStringResource("button.next")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                nextPerformed(target);
            }
        };
        add(button);
        //finish
        button = new AjaxLinkButton("finishButton", createStringResource("button.finish")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                finishPerformed(target);
            }
        };
        add(button);
    }

    private WizardPanel getSelectedPanel() {
        return panels.get(0);
    }

    private void cancelPerformed(AjaxRequestTarget target) {

    }

    private void previousPerformed(AjaxRequestTarget target) {

    }

    private void nextPerformed(AjaxRequestTarget target) {

    }

    private void finishPerformed(AjaxRequestTarget target) {

    }
}
