package com.evolveum.midpoint;

import org.apache.wicket.request.cycle.RequestCycle;


/**
 * service locator class for contacts database
 * 
 * @author igor
 * 
 */
public class DatabaseLocator
{
    /**
     * @return contacts database
     */
    public static ContactsDatabase getDatabase()
    {
		RepeaterApplication app = (RepeaterApplication)RequestCycle.get().getApplication();
    	return app.getContactsDB();
    }
}

