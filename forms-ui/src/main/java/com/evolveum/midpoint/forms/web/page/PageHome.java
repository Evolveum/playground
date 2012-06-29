package com.evolveum.midpoint.forms.web.page;

import org.apache.wicket.devutils.debugbar.DebugBar;
import org.apache.wicket.markup.html.WebPage;

/**
 * @author lazyman
 */
public class PageHome extends WebPage {

    public PageHome() {
        initLayout();
    }

    private void initLayout() {
        DebugBar debugPanel = new DebugBar("debugPanel");
        add(debugPanel);
    }
}
