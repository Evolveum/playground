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
import com.evolveum.midpoint.forms.web.forms.util.StructuredFormUtils;
import com.evolveum.midpoint.forms.xml.FieldDisplayType;
import com.evolveum.midpoint.prism.Item;
import com.evolveum.midpoint.prism.PrismProperty;
import com.evolveum.midpoint.prism.PrismPropertyDefinition;
import com.evolveum.midpoint.prism.PrismPropertyValue;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lazyman
 */
public class FieldModel extends BaseModel<BaseModel, FieldToken> implements DisplayableModel<FieldDisplayType> {

    private List<ValueModel> values;
    private ValueStatus status;

    public FieldModel(BaseModel parentModel, FieldToken token, Map<String, Item> objects) {
        super(parentModel, token, objects);

        initialize();
    }

    private void initialize() {
        FieldToken token = getToken();
        PrismProperty property = token.getProperty();
        if (property == null) {
            property = token.getDefinition().instantiate();
            //todo set status to ADD
        } else {
            //todo set status to MODIFY
        }

        List<PrismPropertyValue> values = property.getValues();
        for (PrismPropertyValue value : values) {
            getValues().add(new ValueModel(this, value, ValueStatus.EXISTING));
        }

        if (getValues().isEmpty()) {
            addValue();
        }
    }

    public void addValue() {
        getValues().add(new ValueModel(this, new PrismPropertyValue(null), ValueStatus.ADDED));
    }

    public void removeValue(ValueModel model) {
        getValues().remove(model);
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
        FieldDisplayType real = getDisplay();

        FieldDisplayType defaultDisplay = new FieldDisplayType();
        StructuredFormUtils.cloneFieldDisplay(real, defaultDisplay);

        PrismPropertyDefinition definition = getToken().getDefinition();
        if (StringUtils.isEmpty(defaultDisplay.getHelp())) {
            defaultDisplay.setHelp(definition.getHelp());
        }
        if (StringUtils.isEmpty(defaultDisplay.getLabel())) {
            String name = StringUtils.isNotEmpty(definition.getDisplayName()) ? definition.getDisplayName() :
                    definition.getName().getLocalPart();
            defaultDisplay.setLabel(name);
        }
        //todo min/max occurs
//        definition.getMaxOccurs();
//        definition.getMinOccurs();

        return defaultDisplay;
    }
}
