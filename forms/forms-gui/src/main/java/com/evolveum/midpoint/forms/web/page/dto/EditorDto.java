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

package com.evolveum.midpoint.forms.web.page.dto;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;


/**
 * @author lazyman
 */
public class EditorDto implements Serializable {

    public static final String F_NAME = "name";
    public static final String F_XML = "xml";

    private String name;
    private String xml;

    public EditorDto() {
        this(null);
    }

    public EditorDto(String name) {
        this(name, null);
    }

    public EditorDto(String name, String xml) {
        this.name = name;
        this.xml = xml;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public boolean isValid() {
        return StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(xml);
    }
}
