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

import com.evolveum.midpoint.forms.web.forms.object.FieldLoopToken;
import com.evolveum.midpoint.forms.xml.DisplayType;
import com.evolveum.midpoint.forms.xml.FieldDisplayType;
import com.evolveum.midpoint.prism.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lazyman
 */
public class FieldLoopModel extends BaseModel<BaseGroupModel, FieldLoopToken> implements DisplayableModel<FieldDisplayType> {

    public FieldLoopModel(BaseGroupModel parentModel, FieldLoopToken token, Map<String, Item> objects) {
        super(parentModel, token, objects);

        initialize();
    }

    private void initialize() {
        //todo implement
    }

    @Override
    public FieldDisplayType getDisplay() {
        return null;
    }
}
