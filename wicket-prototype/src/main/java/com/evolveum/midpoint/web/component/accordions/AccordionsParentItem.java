package com.evolveum.midpoint.web.component.accordions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AccordionsParentItem implements Serializable {
	private String headerText;
    private String content = "";
    private List<AccordionsNestedItem> accordionsNestedItem = new ArrayList<AccordionsNestedItem>();
    
    public AccordionsParentItem(String headerText, String content, List<AccordionsNestedItem> accordionsNestedItem) {
        if (headerText == null || headerText.isEmpty()) {
            throw new IllegalArgumentException("Header text must not be null or empty.");
        }
       
        /*if (content == null  || content.isEmpty()) {
            throw new IllegalArgumentException("Content must not be null or empty.");
        }*/
        
        if(!accordionsNestedItem.isEmpty()){
        	this.accordionsNestedItem = accordionsNestedItem;
        }
        this.headerText = headerText;
        this.content = content;
    }

    public String getHeaderText() {
        return headerText;
    }
    
    public String getContent() {
        return content;
    }
    
    public List<AccordionsNestedItem> getAccordionsNestedItem() {
        return accordionsNestedItem;
    }
}
