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

package com.evolveum.midpoint.forms.web.forms.ui;

import com.evolveum.midpoint.forms.web.forms.model.BaseFieldModel;
import com.evolveum.midpoint.forms.web.forms.model.BaseModel;
import org.apache.commons.lang.Validate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lazyman
 */
public class LineModel<T extends BaseModel> implements Serializable {

    private BaseModel<T> parent;
    private List<BaseFieldModel> baseFieldModels = new ArrayList<BaseFieldModel>();

    public LineModel(BaseModel<T> parent) {
        this(parent, null);
    }

    public LineModel(BaseModel<T> parent, List<BaseFieldModel> baseFieldModels) {
        Validate.notNull(parent, "Parent for line model must not be null.");

        this.parent = parent;
        if (baseFieldModels != null) {
            this.baseFieldModels = baseFieldModels;
        }
    }

    public List<BaseFieldModel> getBaseFieldModels() {
        return baseFieldModels;
    }

    public BaseModel<T> getParent() {
        return parent;
    }

    void addBaseFieldModel(BaseFieldModel model) {
        Validate.notNull(model, "Base field model must not be null.");
        baseFieldModels.add(model);
    }

    public static <T extends BaseModel> List<LineModel> createLineModels(BaseModel<T> parent,
                                                                         List<BaseFieldModel> baseFieldModels) {
        List<LineModel> models = new ArrayList<LineModel>();

        LineModel lineModel = null;
        for (BaseFieldModel model : baseFieldModels) {
            if (lineModel == null) {
                lineModel = new LineModel(parent);
            }
            if (model.isNewLine() && lineModel != null) {
                models.add(lineModel);

                lineModel = new LineModel(parent);
            }

            lineModel.addBaseFieldModel(model);
        }

        return models;
    }
}
