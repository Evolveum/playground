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
import com.evolveum.midpoint.web.component.util.VisibleEnableBehaviour;
import org.apache.commons.lang.Validate;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.request.resource.PackageResourceReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lazyman
 */
public abstract class WizardForm<T extends Serializable> extends Panel {

    public static final String WIZARD_PANEL_ID = "wizardPanel";
    private IModel<T> wizardModel;
    private List<WizardPanel> panels;
    private boolean showTitle = true;
    private int index = 0;
    private Form form;

    public WizardForm(String id) {
        this(id, null);
    }

    public WizardForm(String id, IModel<T> model) {
        super(id);
        this.wizardModel = model;
        setOutputMarkupId(true);
        setOutputMarkupPlaceholderTag(false);

        panels = initPanels();
        Validate.notNull(panels, "List with wizard panels must not be null.");
        if (panels.isEmpty()) {
            throw new IllegalArgumentException("List with wizard panels must not be null.");
        }

        initComponents();
    }

    public IModel<T> getWizardModel() {
        return wizardModel;
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
        form = new Form("wizard");
        add(form);
        //breadcrumbs
        initBreadcrumbs(form);
        //title
        Label title = new Label("title", new LoadableDetachableModel() {

            @Override
            protected Object load() {
                return getSelectedPanel().getTitle().getObject();
            }
        });
        title.setVisible(showTitle);
        form.add(title);
        //content
        form.add(getSelectedPanel());
        //buttons
        initButtons(form);
    }

    private void initBreadcrumbs(Form form) {
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
//                    label.add(new AttributeAppender("class", new Model<String>("selected"), " "));
                    item.add(new AttributeAppender("class", new Model<String>("selected"), " "));
                }
            }
        };
        form.add(breadcrumbs);
    }

    private StringResourceModel createStringResource(String resourceKey) {
        return new StringResourceModel(resourceKey, this, null, null, null);
    }

    private void initButtons(Form form) {
        //cancel
        AjaxLinkButton button = new AjaxLinkButton("cancelButton", createStringResource("button.cancel")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                cancelPerformed(target);
            }
        };
        button.add(new VisibleEnableBehaviour() {

            @Override
            public boolean isEnabled() {
                return isCancelEnabled();
            }

            @Override
            public boolean isVisible() {
                return isCancelVisible();
            }
        });
        form.add(button);
        //previous
        button = new AjaxLinkButton("previousButton", createStringResource("button.previous")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                previousPerformed(target);
            }
        };
        button.add(new VisibleEnableBehaviour() {

            @Override
            public boolean isEnabled() {
                return isPreviousEnabled();
            }

            @Override
            public boolean isVisible() {
                return isPreviousVisible();
            }
        });
        form.add(button);
        //next
        button = new AjaxLinkButton("nextButton", createStringResource("button.next")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                nextPerformed(target);
            }
        };
        button.add(new VisibleEnableBehaviour() {

            @Override
            public boolean isEnabled() {
                return isNextEnabled();
            }

            @Override
            public boolean isVisible() {
                return isNextVisible();
            }
        });
        form.add(button);
        //finish
        button = new AjaxLinkButton("finishButton", createStringResource("button.finish")) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                finishPerformed(target);
            }
        };
        button.add(new VisibleEnableBehaviour() {

            @Override
            public boolean isEnabled() {
                return isFinishEnabled();
            }

            @Override
            public boolean isVisible() {
                return isFinishVisible();
            }
        });
        form.add(button);
    }

    private WizardPanel getSelectedPanel() {
        return panels.get(index);
    }

    private boolean isCancelEnabled() {
        return true;            //todo implement
    }

    private boolean isPreviousEnabled() {
        return true;            //todo implement
    }

    private boolean isNextEnabled() {
        return true;            //todo implement
    }

    private boolean isFinishEnabled() {
        return true;            //todo implement
    }

    private boolean isCancelVisible() {
        return true;            //todo implement
    }

    private boolean isPreviousVisible() {
        if (index == 0) {
            return false;
        }

        return true;
    }

    private boolean isNextVisible() {
        if (index + 1 >= panels.size()) {
            return false;
        }
        return true;
    }

    private boolean isFinishVisible() {
        if (index + 1 >= panels.size()) {
            return true;
        }
        return false;
    }

    private void updateContent(AjaxRequestTarget target) {
        form.addOrReplace(getSelectedPanel());

        target.add(this);
    }

    private void cancelPerformed(AjaxRequestTarget target) {
        getSelectedPanel().performAfterCancel(target);

        index = 0;
        updateContent(target);
    }

    private void previousPerformed(AjaxRequestTarget target) {
        getSelectedPanel().performAfterPrevious(target);

        index--;
        updateContent(target);
    }

    private void nextPerformed(AjaxRequestTarget target) {
        getSelectedPanel().performAfterNext(target);

        index++;
        updateContent(target);
    }

    private void finishPerformed(AjaxRequestTarget target) {
        getSelectedPanel().performAfterFinish(target);

        index = 0;
        updateContent(target);
    }
}
