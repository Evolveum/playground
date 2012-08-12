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

import com.evolveum.midpoint.forms.web.forms.object.FieldToken;
import com.evolveum.midpoint.forms.xml.DisplayType;
import com.evolveum.midpoint.prism.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lazyman
 */
public class FieldModel extends BaseModel<BaseModel, FieldToken> implements DisplayableModel {

    private List<ValueModel> values;
    private ValueStatus status;

    public FieldModel(BaseModel parentModel, FieldToken token, Map<String, Item> objects) {
        super(parentModel, token, objects);
    }

    public List<ValueModel> getValueModels() {
        if (values == null) {
            values = new ArrayList<ValueModel>();
        }
        return values;
    }

    @Override
    public DisplayType getDisplay() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
