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

import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.mozilla.javascript.tools.debugger.Dim.SourceInfo;
import org.odlabs.wiquery.plugin.layout.Layout;
import org.odlabs.wiquery.plugin.layout.Layout.PanePositionEnum;
import org.odlabs.wiquery.ui.accordion.Accordion;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage() {
		Accordion accordion = new Accordion("wiAccordion");
		// A private method that returns a list of Strings getSections
		List<String> carNamelList = getList();

		add(new FeedbackPanel("feedback"));
		add(new Label("version", "This is version of wicket: "
				+ getApplication().getFrameworkSettings().getVersion()));

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

		ListView accordionListView = new ListView("accordionListView", carNamelList) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem listItem) {
				String sectionName = (String) listItem.getModelObject();
				listItem.setRenderBodyOnly(true);
				listItem.add(new Label("sectionNameLbl", sectionName).setRenderBodyOnly(true));
				listItem.add(new Label("sectionNameLbl", sectionName).setRenderBodyOnly(true));
			}
		};

		Layout layout = new Layout("layout", true) {
			private static final long serialVersionUID = 1L;

			@Override
			public Panel getLayoutWestComponent(String wicketId) {
				return new NavigationPanel(wicketId);
			}

			@Override
			public Panel getLayoutNorthComponent(String wicketId) {
				return new HeaderPanel(wicketId);
			}

			@Override
			public IndicatorPanel getLayoutCenterComponent(final String wicketId) {
				return new IndicatorPanel(wicketId, creaAyuda()) {
					@Override
					protected Component newContents(String id) {
						return HomePage.this.getLayoutCenterComponent(id);
					}
				};
			}
		};

		add(form);
		form.add(username);
		accordion.add(accordionListView);
		add(accordion);// Finally add it to the Page

		add(layout);
		layout.setResizable(PanePositionEnum.NORTH, false).setClosable(PanePositionEnum.NORTH, false)
				.setSpacingOpen(PanePositionEnum.NORTH, 0).setMinSize(PanePositionEnum.NORTH, 80)
				.setMaxSize(PanePositionEnum.NORTH, 82);

	}

	private List<SourceInfo> creaAyuda() {
		List<SourceInfo> codeInfos = new ArrayList<SourceInfo>();
		addThisSourceCode(codeInfos);
		addSourceCode(codeInfos);
		return codeInfos;
	}

	private void addThisSourceCode(List<SourceInfo> codeInfos) {
		codeInfos.add(new SourceInfo(HomePage.class));
		codeInfos.add(new SourceInfo(HomePage.class, FORMAT.HTML, "HomePage.html", "HomePage.html"));
	}

	protected void addSourceCode(List<SourceInfo> codeInfos) {

	}

	protected abstract Panel getLayoutCenterComponent(String wicketId);

	public List<String> getList() {
		List<String> list = new ArrayList<String>();

		list.add("Janko Hraško");
		list.add("Jožko Mrkvièka");
		list.add("aaaaaa aaaaaaaaaaa");
		list.add("bbbbb bbb");
		list.add("ccc cccccccccccc");

		return list;
	}

}
