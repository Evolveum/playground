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

package com.evolveum.midpoint.forms.impl.ui;

import com.evolveum.midpoint.forms.impl.model.FormModel;
import com.evolveum.midpoint.forms.impl.model.LineModel;
import org.apache.commons.lang.StringUtils;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

import java.util.List;

/**
 * @author lazyman
 */
public class UiForm extends UiComponent<FormModel> {

    private static final String THEME_DEFAULT = "UiCleanDevel"; //todo change to UiClean
    private static final String THEME_FOLDER = "theme/";

    public UiForm(String id, IModel<FormModel> model) {
        super(id, model);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        FormModel formModel = model.getObject();
        String theme = StringUtils.isNotEmpty(formModel.getTheme()) ? formModel.getTheme() : THEME_DEFAULT;

        ResourceReference ref = new PackageResourceReference(UiForm.class, THEME_FOLDER + theme + ".css");
        response.renderCSSReference(ref);
    }

    @Override
    protected void initLayout() {
        LineListView line = new LineListView("lines", createLineModel());
        add(line);
    }

    private IModel<List<LineModel>> createLineModel() {
        return new AbstractReadOnlyModel<List<LineModel>>() {

            @Override
            public List<LineModel> getObject() {
                FormModel formModel = model.getObject();

                return formModel.getLines();
            }
        };
    }
}
