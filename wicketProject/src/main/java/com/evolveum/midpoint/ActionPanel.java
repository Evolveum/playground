package com.evolveum.midpoint;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * Created by <a href="mailto:claudiu.dumitrescu@gmail.com">Claudiu Dumitrescu</a>
 */
public abstract class ActionPanel extends Panel {
    /**
     * @param id    component id
     * @param model model for contact
     */
    public ActionPanel(String id, IModel model) {
        super(id, model);
        add(new Link("select") {
            public void onClick() {
                doAction(getParent().getDefaultModelObject());
            }
        });
    }

    public abstract void doAction(Object modelObject);
}