package com.evolveum.midpoint.web.component.accordions;

import java.io.Serializable;

public class AccordionsNestedItem implements Serializable {
	private String headerText;
    private String content;
    
    public AccordionsNestedItem(String headerText, String content) {
        if (headerText == null || headerText.isEmpty()) {
            throw new IllegalArgumentException("Header text must not be null or empty.");
        }
       
        if (content == null) {
            throw new IllegalArgumentException("Object must not be null.");
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
}
