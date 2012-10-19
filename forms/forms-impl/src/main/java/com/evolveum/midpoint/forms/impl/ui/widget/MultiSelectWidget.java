package com.evolveum.midpoint.forms.impl.ui.widget;

import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.ListMultipleChoice;
import org.apache.wicket.model.IModel;

/**
 * @author lazyman
 */
public class MultiSelectWidget extends UiWidget {

    private static final String ID_INPUT = "input";

    public MultiSelectWidget(String id, IModel iModel) {
        super(id, iModel);
    }

    @Override
    public FormComponent getBaseFormComponent() {
        return (FormComponent) get(ID_INPUT);
    }

    @Override
    protected void initLayout() {
        ListMultipleChoice input = new ListMultipleChoice(ID_INPUT);
        add(input);
    }
}
