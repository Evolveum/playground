package com.evolveum.midpoint.web.component.autoform;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FormObject implements Serializable {

    public static final String F_ATTRIBUTES = "attributes";
    private String displayName;
    private List<FormAttribute> attributes;

    public FormObject(List<FormAttribute> attributes, String displayName) {
        this.attributes = attributes;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<FormAttribute> getAttributes() {
        if (attributes == null) {
            attributes = new ArrayList<FormAttribute>();
        }
        return attributes;
    }
}
