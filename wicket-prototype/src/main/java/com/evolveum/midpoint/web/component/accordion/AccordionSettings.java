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

package com.evolveum.midpoint.web.component.accordion;

import java.io.Serializable;

public class AccordionSettings implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean expanded = false;
    private boolean multipleSelect = true;
    private int openedPanel = -1;

    public AccordionSettings() {
    }

    public AccordionSettings(boolean expanded, boolean multipleSelect, int openedPanel) {
        setExpanded(expanded);
        setMultipleSelect(multipleSelect);
        setOpenedPanel(openedPanel);
    }

    void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    void setMultipleSelect(boolean multipleSelect) {
        this.multipleSelect = multipleSelect;
    }

    void setOpenedPanel(int openedPanel) {
        this.openedPanel = openedPanel;
    }

    Boolean getExpanded() {
        return expanded;
    }

    int getMultipleSelect() {
        if (multipleSelect) {
            return 1;
        }
        return 0;
    }

    int getOpenedPanel() {
        return openedPanel;
    }
}
