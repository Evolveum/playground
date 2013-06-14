package com.suta.profiler;

import com.suta.profiler.gui.home.Index;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 *
 */
public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage(){
		return Index.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init(){
		super.init();

        if (RuntimeConfigurationType.DEVELOPMENT.equals(getConfigurationType())) {
            getDebugSettings().setAjaxDebugModeEnabled(true);
            getDebugSettings().setDevelopmentUtilitiesEnabled(true);
        }
		// add your configuration here
        //TODO - create profilers filesystem
	}
}
