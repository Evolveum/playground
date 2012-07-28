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

package com.evolveum.midpoint.forms.web.forms.model;

import com.evolveum.midpoint.forms.web.forms.object.FieldGroupToken;
import com.evolveum.midpoint.forms.web.forms.object.ItemToken;
import com.evolveum.midpoint.prism.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lazyman
 */
public class FieldGroupModel extends BaseGroupModel<BaseModel, FieldGroupToken> {

    private List<BaseGroupModel> baseFieldModels = new ArrayList<BaseGroupModel>();

    public FieldGroupModel(BaseModel parentModel, FieldGroupToken token, Map<String, Item> objects) {
        super(parentModel, token, objects);

        initialize();
    }

    private void initialize() {
        for (ItemToken token : getToken().getItems()) {
            BaseGroupModel model = BaseModel.createBaseFieldModel(this, token, getObjects());
            if (model == null) {
                //todo log warning or something
                continue;
            }
            baseFieldModels.add(model);
        }
    }

    public List<BaseGroupModel> getBaseFieldModels() {
        return baseFieldModels;
    }
}
