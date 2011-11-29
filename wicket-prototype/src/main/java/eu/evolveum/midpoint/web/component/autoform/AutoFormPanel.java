package eu.evolveum.midpoint.web.component.autoform;

import eu.evolveum.midpoint.web.component.autoform.custom.ComboPanel;
import eu.evolveum.midpoint.web.component.autoform.custom.PasswordPanel;
import eu.evolveum.midpoint.web.component.autoform.custom.TextPanel;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxCheckBox;
import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import java.util.Date;
import java.util.List;

public class AutoFormPanel extends Panel {

    private static final long serialVersionUID = 2174504322480554451L;
    private static final String COMPONENT_ID = "componentId";
    private boolean showEmpty = true;

    public AutoFormPanel(String id, IModel<FormObject> model) {
        super(id, model);

        final ListView<FormAttribute> panel = new ListView<FormAttribute>("list",
                new PropertyModel<List<FormAttribute>>(model, FormObject.F_ATTRIBUTES)) {

            private static final long serialVersionUID = 2288187916579143616L;

            @Override
            protected void populateItem(ListItem<FormAttribute> item) {
                AutoFormPanel.this.populateItem(item);
            }
        };
        panel.setOutputMarkupId(true);
        add(panel);

        AjaxCheckBox showEmpty = new AjaxCheckBox("showEmpty", new PropertyModel<Boolean>(this, "showEmpty")) {

            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                target.add(AutoFormPanel.this);
            }
        };

        add(showEmpty);
        add(new FeedbackPanel("feedback"));
        setOutputMarkupId(true);
    }

    public boolean isShowEmpty() {
        return showEmpty;
    }

    public void setShowEmpty(boolean showEmpty) {
        this.showEmpty = showEmpty;
    }

    private void populateItem(ListItem<FormAttribute> item) {
        FormAttribute attribute = item.getModel().getObject();
        item.add(new Label("label", new PropertyModel<Object>(item.getModel(), "definition.displayName")));
        item.add(populateValues(attribute, item.getModel()));
        item.setVisible(showEmpty || (!attribute.getValues().isEmpty() && attribute.getValues().get(0) != null));
    }

    private Component populateValues(final FormAttribute attribute, final IModel<FormAttribute> model) {
        final WebMarkupContainer container = new WebMarkupContainer("container");
        container.setOutputMarkupId(true);

        ListView<Object> ulList = new ListView<Object>("attributes", new PropertyModel<List<Object>>(model, "values")) {

            @Override
            protected void populateItem(final ListItem<Object> item) {
                item.add(createValueField(attribute, model, item.getIndex()));
                //add buttons
                AjaxLink<String> addLink = new AjaxLink<String>("addButton") {

                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        System.out.println("add");
                        attribute.getValues().add(null);

                        target.add(container);
                    }
                };
                item.add(addLink);
                AjaxLink<String> removeLink = new AjaxLink<String>("removeButton") {

                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        System.out.println("remove");
                        attribute.getValues().remove(item.getIndex());

                        target.add(container);
                    }
                };
                item.add(removeLink);
            }
        };
        container.add(ulList);

        return container;
    }

    private Component createValueField(FormAttribute attribute, IModel<FormAttribute> model, int index) {
        if (attribute.getDefinition().getAvailableValues() != null) {
            return new ComboPanel(COMPONENT_ID, new PropertyModel<String>(model, "values[" + index + "]"),
                    new PropertyModel<List<String>>(model, "definition.availableValues"));
        }

        Component component = null;
        switch (attribute.getDefinition().getType()) {
            case DATE:
                DateTextField date = DateTextField.forDatePattern(COMPONENT_ID,
                        new PropertyModel<Date>(model, "values[" + index + "]"), "dd/MMM/YYY");
                date.add(new DatePicker());
                component = date;
                break;
            case PASSWORD:
                component = new PasswordPanel(COMPONENT_ID, new PropertyModel<String>(model, "values[" + index + "]"));
                break;
            default:
                component = new TextPanel<String>(COMPONENT_ID, new PropertyModel<String>(model, "values[" + index + "]"));
        }

        return component;
    }
}