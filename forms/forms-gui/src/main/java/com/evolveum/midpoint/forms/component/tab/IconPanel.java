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

package com.evolveum.midpoint.forms.component.tab;

import com.evolveum.midpoint.forms.web.page.component.BasePanel;
import com.evolveum.midpoint.forms.web.page.dto.EditorDto;
import com.evolveum.midpoint.forms.web.page.dto.FormDto;
import com.evolveum.midpoint.forms.web.page.dto.VariableDto;
import com.evolveum.midpoint.forms.web.resource.img.ImgResources;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.request.resource.SharedResourceReference;

/**
 * @author lazyman
 */
public class IconPanel extends BasePanel<String> {

    private IModel<EditorDto> tabModel;

    public IconPanel(String id, IModel<String> model, IModel<EditorDto> tabModel) {
        super(id, model);
        this.tabModel = tabModel;
    }

    @Override
    protected void initLayout() {
        add(new Image("image", createIconModel()));

        add(new Label("label", getModel()));
    }

    private IModel<ResourceReference> createIconModel() {
        return new AbstractReadOnlyModel<ResourceReference>() {

            @Override
            public ResourceReference getObject() {
                String image = "report.png";
                EditorDto dto = tabModel.getObject();
                if (dto instanceof FormDto) {
                    image = "report.png";
                } else if (dto instanceof VariableDto) {
                    image = "page.png";
                }

                return new SharedResourceReference(ImgResources.class, image);
            }
        };
    }
}
