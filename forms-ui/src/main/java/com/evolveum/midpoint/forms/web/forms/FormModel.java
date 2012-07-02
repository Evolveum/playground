package com.evolveum.midpoint.forms.web.forms;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lazyman
 */
public class FormModel {

    private Map<String, Serializable> objects = new HashMap<String, Serializable>();

    private FormModel() {
        this(null);
    }

    private FormModel(Map<String, Serializable> objects) {
        if (objects != null) {
            this.objects.putAll(objects);
        }
    }

    public Serializable getObject(String key) {
        return objects.get(key);
    }
}
