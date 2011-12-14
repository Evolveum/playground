package com.evolveum.midpoint;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

public class SortableContactDataProvider extends SortableDataProvider<Contact> {
	private static final long serialVersionUID = 1L;

	public SortableContactDataProvider() {
		setSort("firstName", SortOrder.ASCENDING);
	}

	protected ContactsDatabase getContactsDB() {
		 return DatabaseLocator.getDatabase();
	}


	public Iterator<Contact> iterator(int first, int count) {
		SortParam sp = getSort();
		return getContactsDB().find(first, count, sp.getProperty(), sp.isAscending()).iterator();
	}

	public int size() {
		return getContactsDB().getCount();
	}

	/**
	 * @see org.apache.wicket.markup.repeater.data.IDataProvider#model(java.lang.Object)
	 */
	public IModel<Contact> model(Contact object) {
		return new DetachableContactModel(object);
	}

	@Override
	public void setSort(String property, SortOrder order) {
		// TODO Auto-generated method stub
		super.setSort(property, order);
	}
}
