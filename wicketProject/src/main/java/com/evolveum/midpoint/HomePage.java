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

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
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

	public HomePage() {
		Accordion accordion = new Accordion("wiAccordion");
		List<String> carNamelList = getList();

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
