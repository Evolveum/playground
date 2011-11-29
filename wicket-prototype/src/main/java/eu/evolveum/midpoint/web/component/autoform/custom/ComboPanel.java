package eu.evolveum.midpoint.web.component.autoform.custom;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import java.util.List;

public class ComboPanel<T> extends Panel {

    public ComboPanel(String id, IModel<T> model, IModel<List<T>> choices) {
        super(id);
        add(new DropDownChoice<T>("input", model, choices));
    }
}
