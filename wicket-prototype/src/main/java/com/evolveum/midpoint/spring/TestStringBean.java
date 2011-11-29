package com.evolveum.midpoint.spring;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lazyman
 */
@Component
public class TestStringBean implements Serializable {

    private SomeService service;

    public List<String> getItems() {
        List<String> list = new ArrayList<String>();
        list.add("first item");
        list.add("second item");
        list.add("third item");

        return list;
    }

    public SomeService getService() {
        return service;
    }
}
