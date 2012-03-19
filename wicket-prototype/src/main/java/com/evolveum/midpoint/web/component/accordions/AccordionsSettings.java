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

public class AccordionsSettings {
	
	private static boolean parentExpanded = false;
    private static boolean parentMultipleSelect = true;
    private static int parentOpenedPanel = -1;
    private static boolean nestedExpanded = false;
    private static boolean nestedMultipleSelect = true;
    private static int nestedOpenedPanel = -1;
    private static boolean nested = false;
	
    public AccordionsSettings(Boolean parentExpanded, Boolean parentMultipleSelect, Integer parentOpenedPanel, Boolean nestedExpanded, Boolean nestedMultipleSelect, Integer nestedOpenedPanel, Boolean containsNested){
    	setParentExpanded(parentExpanded);
    	setParentMultipleSelect(parentMultipleSelect);
    	setParentOpenedPanel(parentOpenedPanel);
    	setNestedExpanded(nestedExpanded);
    	setNestedMultipleSelect(nestedMultipleSelect);
    	setNestedOpenedPanel(nestedOpenedPanel);
    	setNested(containsNested);
    }

    public void setParentExpanded(Boolean parentExpanded) {
        if (parentExpanded == null) {
            throw new IllegalArgumentException("Parent expanded must not be null. Must be set to true or false.");
        }
        AccordionsSettings.parentExpanded = parentExpanded;
    }
    
	public void setParentMultipleSelect(Boolean parentMultipleSelect) {
        if (parentMultipleSelect == null) {
            throw new IllegalArgumentException("Parent multiple select must not be null. Must be set to true or false.");
        }
        AccordionsSettings.parentMultipleSelect = parentMultipleSelect;
    }
    
    public void setParentOpenedPanel(Integer parentOpenedPanel) {
        if (parentOpenedPanel == null) {
            throw new IllegalArgumentException("Parent opened panel must not be null.");
        }
        AccordionsSettings.parentOpenedPanel = parentOpenedPanel;
    }
    
    public void setNestedExpanded(Boolean nestedExpanded) {
        if (nestedExpanded == null) {
            throw new IllegalArgumentException("Nested expanded must not be null. Must be set to true or false.");
        }
        AccordionsSettings.nestedExpanded = nestedExpanded;
    }
    
    public void setNestedMultipleSelect(Boolean nestedMultipleSelect) {
        if (nestedMultipleSelect == null) {
            throw new IllegalArgumentException("Nested multiple select must not be null. Must be set to true or false.");
        }
        AccordionsSettings.nestedMultipleSelect = nestedMultipleSelect;
    }
    
    public void setNestedOpenedPanel(Integer nestedOpenedPanel) {
        if (nestedOpenedPanel == null) {
            throw new IllegalArgumentException("Nested opened panel must not be null.");
        }
        AccordionsSettings.nestedOpenedPanel = nestedOpenedPanel;
    }
    
    public void setNested(Boolean nested) {
        AccordionsSettings.nested = nested;
    }
    
    public Boolean getParentExpanded(){
    	return AccordionsSettings.parentExpanded;
    }
    
    public Integer getParentMultipleSelect(){
    	if(parentMultipleSelect) return 1;
    	return 0;
    }
    
    public Integer getParentOpenedPanel(){
    	return AccordionsSettings.parentOpenedPanel;
    }
    
    public Boolean getNestedExpanded(){
    	return AccordionsSettings.nestedExpanded;
    }
    
    public Integer getNestedMultipleSelect(){
    	if(nestedMultipleSelect) return 1;
    	return 0;
    }
    
    public Integer getNestedOpenedPanel(){
    	return AccordionsSettings.nestedOpenedPanel;
    }
    
    public boolean getNested(){
    	return AccordionsSettings.nested;
    }
}
