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

import com.evolveum.midpoint.forms.web.forms.object.BaseFieldToken;
import com.evolveum.midpoint.forms.web.forms.object.BaseGroupFieldToken;
import com.evolveum.midpoint.prism.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lazyman
 */
public class BaseGroupModel<M extends BaseModel, T extends BaseGroupFieldToken> extends BaseModel<M, T> {

    private List<BaseModel> fields = new ArrayList<BaseModel>();

    public BaseGroupModel(M parentModel, T token, Map<String, Item> objects) {
        super(parentModel, token, objects);
        initialize();
    }

    private void initialize() {
        List<BaseFieldToken> fields = getToken().getFields();
        for (BaseFieldToken token : fields) {
            BaseModel model = BaseModel.createBaseFieldModel(this, token, getObjects());
            if (model == null) {
                //todo log warning or something
                continue;
            }
            this.fields.add(model);
        }
    }

    public List<BaseModel> getFields() {
        return fields;
    }
}
