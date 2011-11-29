package com.evolveum.midpoint.web.component.menu.top;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.Loop;
import org.apache.wicket.markup.html.list.LoopItem;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.request.resource.PackageResourceReference;

import java.util.List;

public class TopMenu extends Panel {

    private List<TopMenuItem> items;

    public TopMenu(String id, List<TopMenuItem> items) {
        super(id);
        if (items == null) {
            throw new IllegalArgumentException("List with top menu items must not be null.");
        }
        this.items = items;

        add(new Loop("list", items.size()) {

            @Override
            protected void populateItem(LoopItem loopItem) {
                final TopMenuItem item = TopMenu.this.items.get(loopItem.getIndex());
                AjaxLink<String> link = new AjaxLink<String>("link", new Model<String>(item.getLabel())) {

                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        setResponsePage(item.getPage());
                    }
                };
                link.add(new Label("label", new StringResourceModel(item.getLabel(), TopMenu.this, null)));
                link.add(new Label("description", new StringResourceModel(item.getDescription(), TopMenu.this, null)));

                Page page = TopMenu.this.getPage();
                if (page != null && page.getClass().isAssignableFrom(item.getPage())) {
                    link.add(new AttributeAppender("class", new Model("selected-top"), " "));
                }
                loopItem.add(link);
            }
        });
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.renderCSSReference(new PackageResourceReference(TopMenu.class, "TopMenu.css"));
    }


}
