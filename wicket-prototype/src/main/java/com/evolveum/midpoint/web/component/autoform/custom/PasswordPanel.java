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

package com.evolveum.midpoint.web.component.autoform.custom;

import org.apache.commons.lang.Validate;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.wicketstuff.jslibraries.JSLib;
import org.wicketstuff.jslibraries.Library;
import org.wicketstuff.jslibraries.VersionDescriptor;

import java.io.Serializable;


public class PasswordPanel extends Panel {

    private Validation validation = new Validation("[a-z]{1}", "[A-Z{1}]", "[0-9]{1}");     //todo fix default validation

    public PasswordPanel(String id, IModel model, Validation validation) {
        super(id);
        this.validation = validation;

        PasswordTextField password = new PasswordTextField("input", model);
        password.setOutputMarkupId(true);
        add(password);
        Label icon = new Label("icon");
        icon.setOutputMarkupId(true);
        add(icon);
        Label label = new Label("label", new Model<String>("vilko"));
        label.setOutputMarkupId(true);
        add(label);

        password.add(new AttributeAppender("onKeyUp", true, new Model<String>(createScript(password.getMarkupId(),
                icon.getMarkupId(), label.getMarkupId())), " "));
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.renderJavaScriptReference(new PackageResourceReference(PasswordPanel.class, "PasswordPanel.js"));
        response.renderCSSReference(new PackageResourceReference(PasswordPanel.class, "PasswordPanel.css"));

        IHeaderContributor header = JSLib.getHeaderContribution(VersionDescriptor.alwaysLatest(Library.JQUERY));
        header.renderHead(response);
    }

    private String createScript(String passwordId, String iconId, String labelId) {
        StringBuilder builder = new StringBuilder();
        builder.append("updatePasswordValidator('");
        builder.append(passwordId);
        builder.append("', '");
        builder.append(iconId);
        builder.append("', '");
        builder.append(labelId);
        builder.append("', '");
        builder.append(validation.getBad());
        builder.append("', '");
        builder.append(validation.getMedium());
        builder.append("', '");
        builder.append(validation.getGood());
        builder.append("');");

        return builder.toString();
    }

    /**
     * Client javascript regular expressions for validator
     */
    public static class Validation implements Serializable {

        private String bad;
        private String medium;
        private String good;

        public Validation(String bad, String medium, String good) {
            Validate.notEmpty(bad, "Regexp for bad password must not be null or empty.");
            Validate.notEmpty(medium, "Regexp for medium password must not be null or empty.");
            Validate.notEmpty(good, "Regexp for good password must not be null or empty.");
            this.bad = bad;
            this.medium = medium;
            this.good = good;
        }

        public String getBad() {
            return bad;
        }

        public String getMedium() {
            return medium;
        }

        public String getGood() {
            return good;
        }
    }
}
