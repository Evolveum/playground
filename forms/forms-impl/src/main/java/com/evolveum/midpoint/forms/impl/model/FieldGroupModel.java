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

import com.evolveum.midpoint.forms.impl.token.FieldGroupToken;
import com.evolveum.midpoint.forms.impl.util.StructuredFormUtils;
import com.evolveum.midpoint.forms.xml.DisplayType;
import com.evolveum.midpoint.forms.xml.FieldDisplayType;
import com.evolveum.midpoint.prism.PrismContainerDefinition;
import org.apache.commons.lang.StringUtils;

/**
 * @author lazyman
 */
public class FieldGroupModel extends BaseGroupModel<BaseGroupModel, FieldGroupToken>
        implements DisplayableModel<DisplayType> {

    public FieldGroupModel(BaseGroupModel parentModel, FieldGroupToken token) {
        super(parentModel, token);
    }

    @Override
    public DisplayType getDisplay() {
        FieldGroupToken token = getToken();
        return token.getField().getDisplay();
    }

    @Override
    public DisplayType getDefaultDisplay() {
        DisplayType real = getDisplay();

        FieldDisplayType defaultDisplay = new FieldDisplayType();
        StructuredFormUtils.cloneDisplay(real, defaultDisplay);

        PrismContainerDefinition definition = getToken().getDefinition();
        if (definition == null) {
            return defaultDisplay;
        }

        if (StringUtils.isEmpty(defaultDisplay.getHelp())) {
            defaultDisplay.setHelp(definition.getHelp());
        }
        if (StringUtils.isEmpty(defaultDisplay.getLabel())) {
            String name = StringUtils.isNotEmpty(definition.getDisplayName()) ? definition.getDisplayName() :
                    definition.getName().getLocalPart();
            defaultDisplay.setLabel(name);
        }

        return defaultDisplay;
    }
}
