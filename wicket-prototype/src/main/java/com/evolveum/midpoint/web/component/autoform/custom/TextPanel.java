package com.evolveum.midpoint.web.component.autoform.custom;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class TextPanel<T> extends Panel {

    public TextPanel(String id, IModel<T> model) {
        super(id);
        add(new TextField<T>("text", model));
    }
}
