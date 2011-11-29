package com.evolveum.midpoint.web.component.menu.top;

import org.apache.wicket.Page;

import java.io.Serializable;

public class TopMenuItem implements Serializable {

    private String label;
    private String description;
    private Class<? extends Page> page;

    public TopMenuItem(String label, String description, Class<? extends Page> page) {
        if (label == null || label.isEmpty()) {
            throw new IllegalArgumentException("Label must not be null or empty.");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException(("Description must not be null or empty."));
        }
        if (page == null) {
            throw new IllegalArgumentException("Page must not be null or empty.");
        }
        this.label = label;
        this.description = description;
        this.page = page;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public Class<? extends Page> getPage() {
        return page;
    }
}
