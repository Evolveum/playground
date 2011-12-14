package com.evolveum.midpoint;

import org.apache.wicket.ThreadContext;


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
		MidPointApplication app = (MidPointApplication)get().getApplication();
    	return app.getContactsDB();
    }
    
    public static ThreadContext get()
	{
		return ThreadContext.get(true);
	}
}

