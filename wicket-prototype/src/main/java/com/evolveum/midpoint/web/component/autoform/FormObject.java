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

package com.evolveum.midpoint.web.component.autoform;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

    public List<Change> getChanges() {
        List<Change> changes = new ArrayList<Change>();

        return changes;
    }

    /**
     * This method remove all changes from {@link FormObject}. That means all changed attributes will
     * be marked as unchanged.
     */
    public void cleanChanges() {
        for (FormAttribute<?> attribute : getAttributes()) {
            for (FormValue<?> value : attribute.getValues()) {
                switch (value.getStatus()) {
                    case ADDED:
                    case DELETED:
                    case CHANGED:
                        value.setStatus(FormValueStatus.NOT_CHANGED);
                        break;
                    default:
                }
            }
        }
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
