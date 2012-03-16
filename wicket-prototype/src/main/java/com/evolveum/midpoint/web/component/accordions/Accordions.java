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

import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.Loop;
import org.apache.wicket.markup.html.list.LoopItem;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.request.resource.PackageResourceReference;

public class Accordions extends Panel  {
	private static final long serialVersionUID = 7554515215048790384L;
	private boolean parentExpanded = false;
    private boolean parentMultipleSelect = true;
    private int parentOpenedPanel = -1;
    
    private boolean nested = false;
    private boolean nestedExpanded = false;
    private boolean nestedMultipleSelect = true;
    private int nestedOpenedPanel = -1;
    
    private List<AccordionsParentItem> accordionsParentItem;

    public Accordions(String id, List<AccordionsParentItem> accordionsParentItem) {
        super(id);

        if (accordionsParentItem == null || accordionsParentItem.isEmpty()) {
            throw new IllegalArgumentException("List with accordions items must not be null.");
        }
        //System.out.println(">>>>>>"+accordionsParentItem.size());
        this.accordionsParentItem = accordionsParentItem;
        //createListItems(accordionsParentItem);
        
       
        add(new Loop("list", accordionsParentItem.size()) {
			@Override
			protected void populateItem(LoopItem loopParentItem) {
	                final AccordionsParentItem item = Accordions.this.accordionsParentItem.get(loopParentItem.getIndex());
	                
	                loopParentItem.add(new Label("headerText", item.getHeaderText()));
	                loopParentItem.add(new Label("content", item.getContent()));
			}
			
        });
    }
    
    private void createListItems(final List<?> accordionsItem){
    	add(new Loop("list", accordionsParentItem.size()) {
			private static final long serialVersionUID = 1L;

			protected void populateItem(LoopItem loopParentItem) {
                final AccordionsParentItem item = (AccordionsParentItem)accordionsItem.get(loopParentItem.getIndex());
                
                loopParentItem.add(new Label("label", new StringResourceModel(item.getHeaderText(), Accordions.this, null)));
                loopParentItem.add(new Label("content", new StringResourceModel(item.getContent(), Accordions.this, null)));
                /*if(!item.getAccordionsNestedItem().isEmpty()){
                	createListItems(id+"_nested", item.getAccordionsNestedItem());
                }*/
            }
        });
    }
    
    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.renderJavaScriptReference(new PackageResourceReference(Accordions.class, "Accordions.js"));
        response.renderCSSReference(new PackageResourceReference(Accordions.class, "Accordions.css"));
        
        response.renderOnLoadJavaScript(createOnLoadJavascript());
    }

    private String createOnLoadJavascript() {
        StringBuilder script = new StringBuilder();
        script.append("var parentAccordion = new TINY.accordion.slider('parentAccordion');");
        script.append("parentAccordion.init('acc','h3',").append(getParentMultipleSelect()).append(",")
        .append(getParentOpenedPanel()).append(",'acc-selected'");
        
        if(isNested()){
        	script.append("var nestedAccordion = new TINY.accordion.slider('nestedAccordion');");
            script.append("nestedAccordion.init('nested','h3',").append(getNestedMultipleSelect()).append(",")
            .append(getNestedOpenedPanel()).append(",'nested-selected'");
        }
        
        if(parentExpanded){
        	script.append("parentAccordion.pr(1);");
        }
        
        if(isNested() && nestedExpanded){
        	script.append("nestedAccordion.pr(1);");
        }
        return script.toString();
    }

    public Boolean isParentExpanded() {
        return parentExpanded;
    }

    public void setParentExpanded(Boolean parentExpanded) {
        if (parentExpanded == null) {
            throw new IllegalArgumentException("Parent expanded must not be null. Must be set to true or false.");
        }
        this.parentExpanded = parentExpanded;
    }
    
    public Boolean isParentMultipleSelect() {
        return parentMultipleSelect;
    }
    
    private Integer getParentMultipleSelect() {
    	if(parentMultipleSelect) return 1;
    	return 0;
    }

    public void setParentMultipleSelect(Boolean parentMultipleSelect) {
        if (parentMultipleSelect == null) {
            throw new IllegalArgumentException("Parent multiple select must not be null. Must be set to true or false.");
        }
        this.parentMultipleSelect = parentMultipleSelect;
    }

    public Integer getParentOpenedPanel() {
        return parentOpenedPanel;
    }

    public void setParentOpenedPanel(Integer parentOpenedPanel) {
        if (parentOpenedPanel == null) {
            throw new IllegalArgumentException("Parent opened panel must not be null.");
        }
        this.parentOpenedPanel = parentOpenedPanel;
    }

    public Boolean isNestedExpanded() {
        return nestedExpanded;
    }

    public void setNestedExpanded(Boolean nestedExpanded) {
        if (nestedExpanded == null) {
            throw new IllegalArgumentException("Nested expanded must not be null. Must be set to true or false.");
        }
        this.nestedExpanded = nestedExpanded;
    }
    
    public Boolean isNestedMultipleSelect() {
        return nestedMultipleSelect;
    }
    
    private Integer getNestedMultipleSelect() {
    	if(nestedMultipleSelect) return 1;
    	return 0;
    }
    
    public void setNestedMultipleSelect(Boolean nestedMultipleSelect) {
        if (nestedMultipleSelect == null) {
            throw new IllegalArgumentException("Nested multiple select must not be null. Must be set to true or false.");
        }
        this.nestedMultipleSelect = nestedMultipleSelect;
    }

    public Integer getNestedOpenedPanel() {
        return nestedOpenedPanel;
    }

    public void setNestedOpenedPanel(Integer nestedOpenedPanel) {
        if (nestedOpenedPanel == null) {
            throw new IllegalArgumentException("Nested opened panel must not be null.");
        }
        this.nestedOpenedPanel = nestedOpenedPanel;
    }

	public boolean isNested() {
		return nested;
	}

}
