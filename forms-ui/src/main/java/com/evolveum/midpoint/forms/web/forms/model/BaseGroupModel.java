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

import com.evolveum.midpoint.forms.web.forms.object.*;
import com.evolveum.midpoint.prism.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lazyman
 */
public class BaseGroupModel<M extends BaseGroupModel, T extends Token>
        extends BaseModel<M, T> {

    private List<DisplayableModel> fields;

    public BaseGroupModel(M parentModel, T token, Map<String, Item> objects) {
        super(parentModel, token, objects);
        initialize();
    }

    private void initialize() {
        List<BaseFieldToken> fields;
        Token token = getToken();
        if (token instanceof FormToken) {
            fields = ((FormToken) token).getFields();
        } else if (token instanceof BaseGroupFieldToken) {
            fields = ((BaseGroupFieldToken) token).getFields();
        } else {
            throw new IllegalArgumentException("Token is not instance of '" + FormToken.class.getSimpleName()
                    + "' or '" + BaseGroupFieldToken.class.getSimpleName() + "', can't find children (fields).");
        }
        for (BaseFieldToken fieldToken : fields) {
            DisplayableModel model = createDisplayableFieldModel(this, fieldToken, getObjects());
            if (model == null) {
                //todo log warning or something
                continue;
            }
            getFields().add(model);
        }
    }

    public List<DisplayableModel> getFields() {
        if (fields == null) {
            fields = new ArrayList<DisplayableModel>();
        }
        return fields;
    }

    private DisplayableModel createDisplayableFieldModel(BaseGroupModel parent, BaseFieldToken token,
                                                         Map<String, Item> objects) {
        if (token instanceof FieldRefToken) {
            FieldRefToken ref = (FieldRefToken) token;
            token = ref.getReferencedToken();
        }

        if (token instanceof FieldToken) {
            return new FieldModel(parent, (FieldToken) token, objects);
        } else if (token instanceof FieldGroupToken) {
            return new FieldGroupModel(parent, (FieldGroupToken) token, objects);
        } else if (token instanceof FieldLoopToken) {
            return new FieldLoopModel(parent, (FieldLoopToken) token, objects);
        }

        return null;
    }

    public List<LineModel> getLines() {
        List<LineModel> lines = new ArrayList<LineModel>();

        LineModel line;
        for (DisplayableModel displayable : getFields()) {
            line = new LineModel(this);
            line.addBaseFieldModel(displayable);
            //todo implement properly
            lines.add(line);
        }

        return lines;
    }
}
