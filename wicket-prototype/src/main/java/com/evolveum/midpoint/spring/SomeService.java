package com.evolveum.midpoint.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lazyman
 */
@Service("someService")
public class SomeService {

//    @SpringBean(name="valueBean")
    @Autowired(required = true)
    @Resource(name = "valueBean")
    private String value;

    public SomeService() {System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA");}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        System.out.println("SETTING VALUEEEEE");
        this.value = value;
    }
}
