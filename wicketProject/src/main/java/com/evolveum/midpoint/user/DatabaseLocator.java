package com.evolveum.midpoint.user;

import org.apache.wicket.ThreadContext;

import com.evolveum.midpoint.MidPointApplication;


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

