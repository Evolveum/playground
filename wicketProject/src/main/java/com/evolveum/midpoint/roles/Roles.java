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

package com.evolveum.midpoint.roles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.wicket.markup.html.link.ResourceLink;
import org.apache.wicket.protocol.http.WebApplication;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import com.evolveum.midpoint.HomePage;
import com.evolveum.midpoint.jasper.JasperReports;
import com.evolveum.midpoint.menu.common.MenuItem;
import com.evolveum.midpoint.xml.ns._public.common.common_2.LoggingComponentType;

public class Roles extends HomePage {
	private static final long serialVersionUID = 1L;
	public static final HashMap<String, String> parameterMap = new HashMap<String, String>();
	
	public Roles() {
		super();

		setPrimaryMenuList(menu());
		setPageTitle("Roles");
		setTitle("Available roles");
		
		ServletContext context = ((WebApplication) getApplication()).getServletContext();
		
		parameterMap.put("paramName", "Janko Hraško");
		
		JasperDesign design;
		JasperReport report = null;
		JasperPrint jasperPrint = null;
		
		try {

			design = JRXmlLoader.load(context.getRealPath("/reports/Report.jrxml"));
			report = JasperCompileManager.compileReport(design);
			jasperPrint = JasperFillManager.fillReport(report, parameterMap, new JREmptyDataSource());

		} catch (JRException e) {

			e.printStackTrace();
		}
		
		JasperReports jr = new JasperReports(jasperPrint);

		add(new ResourceLink("linkToPdf", jr));
	}

	private List<MenuItem> menu() {
		MenuItem primaryMenu1 = new MenuItem("Available roles", Roles.class);
		MenuItem primaryMenu2 = new MenuItem("Create role", HomePage.class);

		// Create a List which contains the primary menu items in it.
		List<MenuItem> primaryMenuList = new ArrayList<MenuItem>();

		primaryMenuList.add(primaryMenu1);
		primaryMenuList.add(primaryMenu2);

		return primaryMenuList;
	}

}
