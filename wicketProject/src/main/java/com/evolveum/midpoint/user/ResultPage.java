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

package com.evolveum.midpoint.user;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

import com.evolveum.midpoint.HomePage;

public class ResultPage extends HomePage {
	private static final long serialVersionUID = 1L;
	String username = null;

	public ResultPage(PageParameters parameters) {
		super();
		String res = "";
		
		if (parameters.getNamedKeys().contains("msg")) {
			StringValue svValue = parameters.get("msg");
			res = "Username : " + svValue.toOptionalString();
		} else {
			
			StringValue svValue = parameters.get("user");
			res = "User id: " + svValue.toOptionalString();
		}
		final Label result = new Label("msg", res);
		add(result);
		setPageTitle("Result");
	}
}
