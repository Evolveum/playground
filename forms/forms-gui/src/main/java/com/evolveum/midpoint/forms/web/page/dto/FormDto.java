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

package com.evolveum.midpoint.forms.web.page.dto;

/**
 * @author lazyman
 */
public class FormDto extends EditorDto {

    @Deprecated
    private boolean main;

    public FormDto(String name) {
        super(name);
    }

    public FormDto(String name, String xml) {
        super(name, xml);
    }

    @Deprecated
    public boolean isMain() {
        return main;
    }

    @Deprecated
    public void setMain(boolean main) {
        this.main = main;
    }
}
