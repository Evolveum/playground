package com.evolveum.midpoint.forms.web.page;

import com.evolveum.midpoint.forms.web.forms.FormModel;
import com.evolveum.midpoint.forms.web.forms.StructuredForm;
import org.apache.wicket.devutils.debugbar.DebugBar;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.LoadableDetachableModel;

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

        Form mainForm = new Form("mainForm");
        add(mainForm);

        StructuredForm form = new StructuredForm("form", new LoadableDetachableModel<FormModel>() {

            @Override
            protected FormModel load() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        mainForm.add(form);
    }
}
