/*
 * Copyright (c) 2012 Evolveum
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://www.opensource.org/licenses/cddl1 or
 * CDDLv1.0.txt file in the source code distribution.
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 *
 * Portions Copyrighted 2012 [name of copyright owner]
 */

package com.evolveum.midpoint.forms.web.page;

import org.apache.wicket.devutils.debugbar.DebugBar;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

/**
 * @author lazyman
 */
public class PageTest extends WebPage {

    public PageTest() {
        initLayout();
    }

    private void initLayout() {
        DebugBar debugPanel = new DebugBar("debugPanel");
        add(debugPanel);

        Form mainForm = new Form("mainForm");
        add(mainForm);


    }
}
