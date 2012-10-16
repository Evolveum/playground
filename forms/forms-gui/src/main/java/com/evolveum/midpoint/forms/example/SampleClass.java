package com.evolveum.midpoint.forms.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazyman
 */
public class SampleClass {

    public static List<Object> getGroups() throws Exception {
        List<Object> groups = new ArrayList<Object>();
        groups.add("cn=group one,dc=example,dc=com");
        groups.add("cn=group two,dc=example,dc=com");
        groups.add("cn=other group,dc=example,dc=com");

        //you can do some ldap magic to create this list, or whatever you want...

        return groups;
    }
}
