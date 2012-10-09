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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lazyman
 */
public class SampleDto implements Serializable, Comparable<SampleDto> {

    private String name;
    private String description;
    private String samplePath;

    private String mainForm;
    private List<String> forms;
    private Map<String, String> variables;

    public String getSamplePath() {
        return samplePath;
    }

    public void setSamplePath(String samplePath) {
        this.samplePath = samplePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getForms() {
        if (forms == null) {
            forms = new ArrayList<String>();
        }
        return forms;
    }

    public void setForms(List<String> forms) {
        this.forms = forms;
    }

    public String getMainForm() {
        return mainForm;
    }

    public void setMainForm(String mainForm) {
        this.mainForm = mainForm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getVariables() {
        if (variables == null) {
            variables = new HashMap<String, String>();
        }
        return variables;
    }

    public void setVariables(Map<String, String> variables) {
        this.variables = variables;
    }

    @Override
    public int compareTo(SampleDto other) {
        return String.CASE_INSENSITIVE_ORDER.compare(getName(), other.getName());
    }
}
