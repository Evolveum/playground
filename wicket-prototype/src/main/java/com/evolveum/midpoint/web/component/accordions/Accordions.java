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

package com.evolveum.midpoint.web.component.accordions;

import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.request.resource.PackageResourceReference;

public class Accordions extends Border {
    private static final long serialVersionUID = 7554515215048790384L;

    private AccordionsSettings accSettings;

    public Accordions(String id, AccordionsSettings accSettings) {
        super(id);
        this.accSettings = accSettings;
        WebMarkupContainer parent = new WebMarkupContainer("parent");
        parent.setOutputMarkupId(true);
        addToBorder(parent);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.renderJavaScriptReference(new PackageResourceReference(Accordions.class, "Accordions.js"));
        response.renderCSSReference(new PackageResourceReference(Accordions.class, "Accordions.css"));
        response.renderJavaScriptReference(new PackageResourceReference(Accordions.class, "ScriptAppender.js")); 
        
        response.renderOnLoadJavaScript("AppendAccordionScript('"+getMarkupId()+","+accSettings.getExpanded()+","+accSettings.getMultipleSelect()+","+accSettings.getOpenedPanel()+"')");
    }
}
