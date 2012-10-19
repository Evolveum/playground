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

import com.evolveum.midpoint.forms.impl.token.FieldToken;
import com.evolveum.midpoint.forms.impl.util.StructuredFormUtils;
import com.evolveum.midpoint.xml.ns._public.gui.form_1.FieldDisplayType;
import com.evolveum.midpoint.prism.PrismProperty;
import com.evolveum.midpoint.prism.PrismPropertyDefinition;
import com.evolveum.midpoint.prism.PrismPropertyValue;
import com.evolveum.midpoint.prism.polystring.PolyString;
import com.evolveum.midpoint.schema.constants.SchemaConstants;
import com.evolveum.midpoint.xml.ns._public.common.common_2.ProtectedStringType;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazyman
 */
public class FieldModel extends BaseModel<BaseModel, FieldToken> implements DisplayableModel<FieldDisplayType> {

    private List<ValueModel> values;
    private ValueStatus status;

    public FieldModel(BaseModel parentModel, FieldToken token) {
        super(parentModel, token);

        initialize();
    }

    private void initialize() {
        FieldToken token = getToken();
        PrismProperty property = token.getProperty();
        if (property == null) {
            property = token.getDefinition().instantiate();
            status = ValueStatus.ADDED;
        } else {
            status = ValueStatus.EXISTING;
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
        PrismPropertyDefinition definition = getToken().getDefinition();

        if (ProtectedStringType.COMPLEX_TYPE.equals(definition.getTypeName())) {
            values.add(new ValueModel(this, new PrismPropertyValue(new ProtectedStringType()),
                    new PrismPropertyValue(new ProtectedStringType()), ValueStatus.ADDED));
        } else if (SchemaConstants.T_POLY_STRING_TYPE.equals(definition.getTypeName())) {
            values.add(new ValueModel(this, new PrismPropertyValue(new PolyString(null)),
                    new PrismPropertyValue(new PolyString(null)), ValueStatus.ADDED));
        } else if (isThisPropertyActivationEnabled()) {
            values.add(new ValueModel(this, new PrismPropertyValue(true),
                    new PrismPropertyValue(null), ValueStatus.ADDED));
        } else {
            getValues().add(new ValueModel(this, new PrismPropertyValue(null), ValueStatus.ADDED));
        }
    }

    private boolean isThisPropertyActivationEnabled() {
        //todo how to get this information until tri-state checkbox is available?
        return false;
    }

    public void removeValue(ValueModel model) {
        if (ValueStatus.ADDED.equals(model.getStatus())) {
            getValues().remove(model);
        } else {
            model.setStatus(ValueStatus.DELETED);
        }
    }

    public List<ValueModel> getValues() {
        if (values == null) {
            values = new ArrayList<ValueModel>();
        }
        return values;
    }

    public ValueStatus getStatus() {
        return status;
    }

    public List<ValueModel> getVisibleValues() {
        List<ValueModel> visibleValues = new ArrayList<ValueModel>();
        for (ValueModel model : getValues()) {
            if (ValueStatus.DELETED.equals(model.getStatus())) {
                continue;
            }
            visibleValues.add(model);
        }

        return visibleValues;
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

        if (defaultDisplay.getMinOccurs() == null) {
            defaultDisplay.setMinOccurs(definition.getMinOccurs());
        }

        if (defaultDisplay.getMaxOccurs() == null) {
            defaultDisplay.setMaxOccurs(definition.getMaxOccurs());
        }

        return defaultDisplay;
    }
}
