package com.evolveum.midpoint.forms.example;

import org.apache.wicket.markup.html.form.IChoiceRenderer;

/**
 * @author lazyman
 */
public class SampleComboRenderer implements IChoiceRenderer<Object> {

    /**
     * @see IChoiceRenderer#getDisplayValue(Object)
     */
    @Override
    public Object getDisplayValue(Object object) {
        //implement sample
        return null;
    }

    /**
     * @see IChoiceRenderer#getIdValue(Object, int)
     */
    @Override
    public String getIdValue(Object object, int index) {
        //implement sample
        return null;
    }
}
