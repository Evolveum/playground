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

package com.evolveum.midpoint.forms.web.forms.ui.widget;

import com.evolveum.midpoint.util.MiscUtil;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;

/**
 * @author lazyman
 */
public class DateWidget extends UiWidget {

    private static final Trace LOGGER = TraceManager.getTrace(DateWidget.class);
    private static final String ID_INPUT = "input";

    public DateWidget(String id, IModel iModel) {
        super(id, iModel);
    }

    @Override
    public FormComponent getBaseFormComponent() {
        return (FormComponent) get(ID_INPUT);
    }

    @Override
    protected void initLayout() {
        DateTextField date = DateTextField.forDatePattern("input", createDateModel(), "dd/MMM/yyyy");
        date.add(new DatePicker());
        add(date);
    }

    private IModel<Date> createDateModel() {
        final IModel<XMLGregorianCalendar> model = getModel();

        return new Model<Date>() {

            @Override
            public Date getObject() {
                XMLGregorianCalendar calendar = model.getObject();
                if (calendar == null) {
                    return null;
                }
                return MiscUtil.asDate(calendar);
            }

            @Override
            public void setObject(Date object) {
                if (object == null) {
                    model.setObject(null);
                } else {
                    model.setObject(MiscUtil.asXMLGregorianCalendar(object));
                }
            }
        };
    }
}
