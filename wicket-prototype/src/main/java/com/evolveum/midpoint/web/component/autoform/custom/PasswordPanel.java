package com.evolveum.midpoint.web.component.autoform.custom;

import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class PasswordPanel extends Panel {

    public PasswordPanel(String id, IModel model) {
        super(id);
        add(new PasswordTextField("password", model));
    }
}
