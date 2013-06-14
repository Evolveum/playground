package com.suta.profiler.gui.util;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *  NoProfilingRunning page
 *
 *  @author erik suta
 * */
public class NoProfilingActive extends ProfilingPage{

    /* Attributes */

    /* GUI attributes */

    /**
     *  Constructor
     * */
    public NoProfilingActive(final PageParameters parameters, String message){
        super(parameters);
        add(new Label("info", message));
    }   //Constructor end
}
