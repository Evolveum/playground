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

package com.evolveum.midpoint.web.admin;

import com.evolveum.midpoint.web.component.accordions.AccordionItem;
import com.evolveum.midpoint.web.component.accordions.Accordions;
import com.evolveum.midpoint.web.component.accordions.AccordionsSettings;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;

/**
 * @author mserbak
 */
public class PageRoles extends PageAdmin {

    public PageRoles() {
        Form form = new Form("form");
        add(form);
        AccordionsSettings accSettings = new AccordionsSettings(false, true, -1, false, false, -1, true);

        Accordions a = new Accordions("accordions", accSettings);
        form.add(a);
        AccordionItem aa = new AccordionItem("first", new Model<String>("some stuff"));
        a.getBodyContainer().add(aa);

        AccordionItem aa2 = new AccordionItem("second", new Model<String>("second accordion item"));
//        aa2.add(new AceEditor("editor", new Model<String>("<foo>bar</foo>")));
        a.getBodyContainer().add(aa2);


        /*List<AccordionsParentItem> itemsParent = new ArrayList<AccordionsParentItem>();
          List<AccordionsNestedItem> itemsNested = new ArrayList<AccordionsNestedItem>();

          itemsNested.add(new AccordionsNestedItem("nesteeed", "<b>asdasdasd</b>"));
          itemsNested.add(new AccordionsNestedItem("nesteeedasdasd", "<b>asdasdasd</b>"));
          itemsNested.add(new AccordionsNestedItem("nesteeedasasd", "<b>asdaddsdasd</b>"));

          itemsParent.add(new AccordionsParentItem("aaaaaaaaaaaaa", "<b>aaa</b>", new ArrayList<AccordionsNestedItem>()));
          itemsParent.add(new AccordionsParentItem("aaaaaaaaaaaaa", "bbbbbbbbbb", itemsNested));
          itemsParent.add(new AccordionsParentItem("aaaaaaaaaaaaa", "bbbbbbbbbb", new ArrayList<AccordionsNestedItem>()));
          itemsParent.add(new AccordionsParentItem("aaaaaaaaaaaaa", "bbbbbbbbbb", new ArrayList<AccordionsNestedItem>()));
          itemsParent.add(new AccordionsParentItem("aaaaaaaaaaaaa", "bbbbbbbbbb", new ArrayList<AccordionsNestedItem>()));
          itemsParent.add(new AccordionsParentItem("aaaaaaaaaaaaa", "bbbbbbbbbb", new ArrayList<AccordionsNestedItem>()));
          */
//    	Accordions acc = new Accordions("accordions", itemsParent, accSettings);
//    	add(acc);

        form.add(new BookmarkablePageLink<Void>("submit", PageSubmit.class));
    }
}
