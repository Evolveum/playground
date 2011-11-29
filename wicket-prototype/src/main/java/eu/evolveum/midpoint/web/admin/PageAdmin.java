package eu.evolveum.midpoint.web.admin;

import eu.evolveum.midpoint.web.PageTest;
import eu.evolveum.midpoint.web.admin.home.PageHome;
import eu.evolveum.midpoint.web.admin.user.PageUser;
import eu.evolveum.midpoint.web.component.menu.top.TopMenuItem;
import eu.evolveum.midpoint.web.page.PageBase;

import java.util.ArrayList;
import java.util.List;

public class PageAdmin extends PageBase {

    @Override
    public List<TopMenuItem> getTopMenuItems() {
        List<TopMenuItem> items = new ArrayList<TopMenuItem>();
        items.add(new TopMenuItem("pageAdmin.home", "pageAdmin.home.description", PageHome.class));
        items.add(new TopMenuItem("pageAdmin.workItems", "pageAdmin.workItems.description", PageHome.class));
        items.add(new TopMenuItem("pageAdmin.accounts", "pageAdmin.accounts.description", PageUser.class));
        items.add(new TopMenuItem("pageAdmin.serverTasks", "pageAdmin.serverTasks.description", PageHome.class));
        items.add(new TopMenuItem("pageAdmin.roles", "pageAdmin.roles.description", PageHome.class));
        items.add(new TopMenuItem("pageAdmin.resources", "pageAdmin.resources.description", PageHome.class));
        items.add(new TopMenuItem("pageAdmin.reports", "pageAdmin.reports.description", PageHome.class));
        items.add(new TopMenuItem("pageAdmin.configuration", "pageAdmin.configuration.description", PageTest.class));

        return items;
    }
}
