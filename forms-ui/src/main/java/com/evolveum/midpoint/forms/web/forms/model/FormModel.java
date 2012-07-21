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

import com.evolveum.midpoint.forms.web.forms.object.FormToken;
import com.evolveum.midpoint.forms.web.forms.object.ItemToken;
import com.evolveum.midpoint.prism.Item;
import org.apache.commons.lang.Validate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lazyman
 */
public class FormModel extends BaseModel<FormModel> {

    private FormToken formToken;
    private Map<String, Item> objects;

    private List<BaseFieldModel> baseFieldModels = new ArrayList<BaseFieldModel>();

    public FormModel(FormToken token, Map<String, Item> objects) {
        super(null);
        Validate.notNull(token, "Form token must not be null.");
        Validate.notNull(objects, "Map with objects must not be null.");

        this.formToken = token;
        this.objects = objects;

        initialize();
    }

    private void initialize() {
        for (ItemToken token : formToken.getItems()) {

            //todo implement
            baseFieldModels.add(new FieldModel(this));
        }
    }

    public List<BaseFieldModel> getBaseFieldModels() {
        return baseFieldModels;
    }
}
