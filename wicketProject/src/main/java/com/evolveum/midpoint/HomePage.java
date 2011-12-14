/*
 * Copyright (c) 2011 Evolveum
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
 * Portions Copyrighted 2011 [name of copyright owner]
 */

package com.evolveum.midpoint;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByBorder;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.odlabs.wiquery.core.options.ArrayItemOptions;
import org.odlabs.wiquery.core.options.LiteralOption;
import org.odlabs.wiquery.ui.accordion.Accordion;
import org.odlabs.wiquery.ui.autocomplete.Autocomplete;
import org.odlabs.wiquery.ui.autocomplete.AutocompleteAjaxComponent;
import org.odlabs.wiquery.ui.autocomplete.AutocompleteComponent;
import org.odlabs.wiquery.ui.autocomplete.AutocompleteSource;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	private AutocompleteComponent<UserBean> autocompleteComponent;
	private AutocompleteAjaxComponent<String> autocompleteAjaxComponent;

	@SuppressWarnings("serial")
	public HomePage() {
		Accordion accordion = new Accordion("wiAccordion");
		List<String> carNamelList = getList();

		SortableContactDataProvider dp = new SortableContactDataProvider();

		final DataView<Contact> dataView = new DataView<Contact>("sorting", dp) {
			private static final long serialVersionUID = 1L;
			PageParameters pageParameters = new PageParameters();

			@SuppressWarnings("deprecation")
			@Override
			protected void populateItem(final Item<Contact> item) {
				final Contact contact = item.getModelObject();
				String name = contact.getFirstName() + " " + contact.getLastName();
				item.add(new Link<Contact>("test", item.getModel()) {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						pageParameters.add("model", contact);
						setResponsePage(ResultPage.class, pageParameters);
					}
				}.add(new Label("linkTest", name)));

				item.add(new Label("contactid", String.valueOf(contact.getId())));
				item.add(new Label("firstname", contact.getFirstName()));
				item.add(new Label("lastname", contact.getLastName()));
				item.add(new Label("homephone", contact.getHomePhone()));
				item.add(new Label("cellphone", contact.getCellPhone()));

				item.add(new AttributeModifier("class", true, new AbstractReadOnlyModel<String>() {

					@Override
					public String getObject() {
						return (item.getIndex() % 2 == 1) ? "even" : "odd";
					}
				}));
			}
		};

		dataView.setItemsPerPage(10);

		add(new OrderByBorder("orderByFirstName", "firstName", dp) {
			static final long serialVersionUID = 1L;

			@Override
			protected void onSortChanged() {
				dataView.setCurrentPage(dataView.getCurrentPage());
			}
		});

		add(new OrderByBorder("orderByLastName", "lastName", dp) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSortChanged() {
				dataView.setCurrentPage(dataView.getCurrentPage());
			}
		});

		final DataView<Contact> dataViewNormal = new DataView<Contact>("normal", dp) {
			private static final long serialVersionUID = 1L;
			PageParameters pageParameters = new PageParameters();

			@SuppressWarnings("deprecation")
			@Override
			protected void populateItem(final Item<Contact> item) {
				final Contact contact = item.getModelObject();

				item.add(new Link<Contact>("testNormal", item.getModel()) {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						pageParameters.add("model", contact);
						setResponsePage(ResultPage.class, pageParameters);
					}
				}.add(new Label("linkTestNormal", contact.getLastName() + " " + contact.getFirstName())));

				item.add(new Label("contactidNormal", String.valueOf(contact.getId())));
				item.add(new Label("firstnameNormal", contact.getFirstName()));
				item.add(new Label("lastnameNormal", contact.getLastName()));
				item.add(new Label("homephoneNormal", contact.getHomePhone()));
				item.add(new Label("cellphoneNormal", contact.getCellPhone()));

				item.add(new AttributeModifier("class", true, new AbstractReadOnlyModel<String>() {

					@Override
					public String getObject() {
						return (item.getIndex() % 2 == 1) ? "even" : "odd";
					}
				}));
			}
		};

		dataViewNormal.setItemsPerPage(10);

		add(new FeedbackPanel("feedback"));
		add(new Label("version", "This is version of wicket: "
				+ getApplication().getFrameworkSettings().getVersion()));

		// Autocomplete
		ArrayItemOptions<LiteralOption> array = new ArrayItemOptions<LiteralOption>();
		array.add(new LiteralOption("c++"));
		array.add(new LiteralOption("java"));
		array.add(new LiteralOption("php"));
		array.add(new LiteralOption("coldfusion"));
		array.add(new LiteralOption("javascript"));
		array.add(new LiteralOption("asp"));
		array.add(new LiteralOption("ruby"));
		array.add(new LiteralOption("python"));
		array.add(new LiteralOption("c"));
		array.add(new LiteralOption("scala"));
		array.add(new LiteralOption("groovy"));
		array.add(new LiteralOption("haskell"));
		array.add(new LiteralOption("perl"));

		final Autocomplete<String> autocomplete = new Autocomplete<String>("autocomplete");
		autocomplete.setSource(new AutocompleteSource(array));
		autocomplete.setRequired(true);

		final TextField<String> username = new TextField<String>("username", Model.of(""));
		username.setRequired(true);

		Form<?> form = new Form<Void>("userForm") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				final String usernameValue = username.getModelObject();

				PageParameters pageParameters = new PageParameters();
				pageParameters.add("msg", usernameValue);
				setResponsePage(ResultPage.class, pageParameters);
			}
		};

		@SuppressWarnings("unchecked")
		ListView accordionListView = new ListView("accordionListView", carNamelList) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem listItem) {
				String sectionName = (String) listItem.getModelObject();
				listItem.setRenderBodyOnly(true);
				listItem.add(new Label("sectionNameLbl", sectionName).setRenderBodyOnly(true));
			}
		};
		add(autocomplete);
		add(form);
		form.add(username);
		accordion.add(accordionListView);
		add(accordion);// Finally add it to the Page

		add(dataView);
		add(new PagingNavigator("navigator", dataView));

		add(dataViewNormal);
		add(new PagingNavigator("normalNavigator", dataViewNormal));

	}

	public class UserBean implements Serializable {
		// Constants
		/** Constant of serialization */
		private static final long serialVersionUID = 5835935588925589134L;

		// Properties
		private String name;
		private Integer age;

		public UserBean(String name, Integer age) {
			super();
			this.name = name;
			this.age = age;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof UserBean) {
				return ((UserBean) obj).getName().equalsIgnoreCase(this.name);
			}

			return false;
		}

		public Integer getAge() {
			return age;
		}

		public String getName() {
			return name;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public void setName(String name) {
			this.name = name;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return this.name;
		}
	}

	public List<String> getList() {
		List<String> list = new ArrayList<String>();

		list.add("Janko Hraško");
		list.add("Jožko Mrkvièka");
		list.add("aaaaaa aaaaaaaaaaa");
		list.add("bbbbb bbb");
		list.add("ccc cccccccccccc");

		return list;
	}

	private static final List<String> languages = new ArrayList<String>(
			Arrays.asList("asp", "c", "c++", "coldfusion", "groovy", "haskell", "java", "javascript", "perl",
					"php", "python", "ruby", "scala"));

}
