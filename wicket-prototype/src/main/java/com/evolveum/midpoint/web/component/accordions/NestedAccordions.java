/*
 * Copyright (c) 2011 Evolveum
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
 * Portions Copyrighted 2011 [name of copyright owner]
 */

package com.evolveum.midpoint.web.component.accordions;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.Loop;
import org.apache.wicket.markup.html.list.LoopItem;
import org.apache.wicket.markup.html.panel.Panel;

public class NestedAccordions extends Panel {
	private static final long serialVersionUID = 7554515215048790384L;
    
    private List<AccordionsNestedItem> accordionsNestedItem;

    public NestedAccordions(String id, List<AccordionsNestedItem> accordionsNestedItem) {
        super(id);

        if (accordionsNestedItem == null || accordionsNestedItem.isEmpty()) {
            throw new IllegalArgumentException("List with accordions items must not be null.");
        }
        this.accordionsNestedItem = accordionsNestedItem;
        add(new Loop("nestedList", accordionsNestedItem.size()) {
			@Override
			protected void populateItem(LoopItem loopNestedItem) {
	            final AccordionsNestedItem item = NestedAccordions.this.accordionsNestedItem.get(loopNestedItem.getIndex());
            	loopNestedItem.add(new Label("nestedHeaderText", item.getHeaderText()).setEscapeModelStrings(false));
            	loopNestedItem.add(new Label("nestedContent", item.getContent()).setEscapeModelStrings(false));
			}
        }); 
    }
}
