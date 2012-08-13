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
import com.evolveum.midpoint.forms.web.forms.object.ReferenceType;
import com.evolveum.midpoint.forms.xml.FieldDisplayType;
import com.evolveum.midpoint.prism.*;
import com.evolveum.midpoint.schema.holder.XPathHolder;
import com.evolveum.prism.xml.ns._public.types_2.XPathType;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lazyman
 */
public class FieldModel extends BaseModel<BaseModel, FieldToken> implements DisplayableModel<FieldDisplayType> {

    private List<ValueModel> values;
    private ModelStatus status;

    public FieldModel(BaseModel parentModel, FieldToken token, Map<String, Item> objects) {
        super(parentModel, token, objects);

        initialize();
    }

    private void initialize() {
        Map<String, Item> objects = getObjects();
        FieldToken token = getToken();

        Element element = token.getField().getRef();
        ReferenceType ref = new ReferenceType(element);
        Item item = objects.get(ref.getKey());

        if ((item instanceof PrismContainer) && StringUtils.isNotEmpty(ref.getValue())) {
            XPathType xpathType = new XPathType();
            xpathType.setContent(ref.getValue());

            XPathHolder holder = new XPathHolder(element);
            PropertyPath path = holder.toPropertyPath();

            PrismContainer container = (PrismContainer)item;
            item = container.findItem(path);
        }

        if (item == null || !(item instanceof PrismProperty)) {
            //todo something :)))
            return;
        }

        PrismProperty property = (PrismProperty) item;
        List<PrismPropertyValue> values = property.getValues();
        for (PrismPropertyValue value : values) {
            getValues().add(new ValueModel(this, value));
        }
    }

    public List<ValueModel> getValues() {
        if (values == null) {
            values = new ArrayList<ValueModel>();
        }
        return values;
    }

    @Override
    public FieldDisplayType getDisplay() {
        FieldToken token = getToken();
        return token.getField().getDisplay();
    }

    @Override
    public FieldDisplayType getDefaultDisplay() {
        //todo implement defaults computing
        return getDisplay();
    }
}
