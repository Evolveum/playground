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

package com.evolveum.midpoint.forms.impl.model;

import com.evolveum.midpoint.forms.impl.token.BaseDisplayableFieldToken;
import org.apache.commons.lang.Validate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Model for one line in form/group.
 *
 * @author lazyman
 */
public class LineModel<M extends BaseGroupModel, T extends BaseDisplayableFieldToken>
        implements Serializable {

    public static final String F_FIELDS = "fields";

    private BaseGroupModel<M, T> parent;
    private List<DisplayableModel> fields = new ArrayList<DisplayableModel>();

    public LineModel(BaseGroupModel<M, T> parent) {
        this(parent, null);
    }

    public LineModel(BaseGroupModel<M, T> parent, List<DisplayableModel> fields) {
        Validate.notNull(parent, "Parent for line model must not be null.");

        this.parent = parent;
        if (fields != null) {
            this.fields = fields;
        }
    }

    public List<DisplayableModel> getFields() {
        return fields;
    }

    public BaseModel<M, T> getParent() {
        return parent;
    }

    void addBaseFieldModel(DisplayableModel model) {
        Validate.notNull(model, "Displayable field model must not be null.");
        fields.add(model);
    }
}
