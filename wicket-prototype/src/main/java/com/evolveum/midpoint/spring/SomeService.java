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
