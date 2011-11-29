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

package com.evolveum.midpoint.web;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.StringValidator;

public class PageLogin extends WebPage {

    private static final long serialVersionUID = 1058369214134285993L;
    private TextField<String> username;
    private PasswordTextField password;
    private DtoLogin dtoLogin = new DtoLogin();

    public PageLogin() {
        Form<DtoLogin> form = new Form<DtoLogin>("form", new PropertyModel<DtoLogin>(this, "dtoLogin"));
        add(form);

        username = new TextField<String>("username", new PropertyModel<String>(form.getModel(), DtoLogin.F_USERNAME));
        username.add(StringValidator.minimumLength(1));
        form.add(username);

        password = new PasswordTextField("password", new PropertyModel<String>(form.getModel(), DtoLogin.F_PASSWORD));
        password.add(StringValidator.minimumLength(1));
        form.add(password);

        form.add(new AjaxButton("loginButton", new Model<String>("Login")) {

            private static final long serialVersionUID = -5025942974532782915L;

            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> paramForm) {
                System.out.println(getDtoLogin());
                setResponsePage(PageTest.class);
            }

            @Override
            protected void onError(AjaxRequestTarget target, Form<?> paramForm) {
                System.out.println("error");
            }
        });
    }

    public DtoLogin getDtoLogin() {
        return dtoLogin;
    }
}
