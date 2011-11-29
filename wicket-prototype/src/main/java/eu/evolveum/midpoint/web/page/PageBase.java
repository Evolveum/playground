package eu.evolveum.midpoint.web.page;

import eu.evolveum.midpoint.web.component.menu.top.TopMenu;
import eu.evolveum.midpoint.web.component.menu.top.TopMenuItem;
import org.apache.wicket.markup.html.WebPage;

import java.util.List;

public abstract class PageBase extends WebPage {

    public PageBase() {
        List<TopMenuItem> topMenuItems = getTopMenuItems();
        if (topMenuItems == null) {
            throw new IllegalArgumentException("Top menu item list must not be null.");
        }
        add(new TopMenu("topMenu", topMenuItems));
    }

    public abstract List<TopMenuItem> getTopMenuItems();
}
