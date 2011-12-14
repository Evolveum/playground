package com.evolveum.midpoint;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Created by <a href="mailto:claudiu.dumitrescu@gmail.com">Claudiu Dumitrescu</a>
 */
public abstract class ActionPanel extends Panel {
	private static final long serialVersionUID = 1L;

	/**
     * @param id    component id
     * @param model model for contact
     */
    public ActionPanel(String id, final IModel<?> model) {
        super(id, model);
        add(new Link<Object>("test") {
			private static final long serialVersionUID = 1L;
			PageParameters pageParameters = new PageParameters();
			
			public void onClick() {
                doAction(getParent().getDefaultModelObject());
                pageParameters.add("model", model.getObject());
                setResponsePage(ResultPage.class, pageParameters);
                //CharSequence url = urlFor(ResultPage.class, pageParameters);
            }
        });
    }

    public abstract void doAction(Object modelObject);
}