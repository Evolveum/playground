package com.evolveum.demo.exporter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.evolveum.demo.model.OrgType;
import com.evolveum.demo.model.User;
import com.evolveum.demo.model.UserJpa;

/*added new column 'orgpath' and 'responsibility'*/
////////////////////////////////////////////////////////////////////////////////////////

public class CsvWriter {

	public CsvWriter(ArrayList<UserJpa> users, String path) throws IOException {
		final FileWriter fw = new FileWriter(path);
		//String csvStr;

		fw.write("\"empnum\",\"firstname\",\"lastname\",\"artname\",\"emptype\",\"orgpath\",\"responsibility\""
				+ "\n");

		for (UserJpa c : users) {

			String savedOrg = c.getOrgType();
			String fullOrg = null;
			if (savedOrg != null) {
				fullOrg = OrgType.getFullOrg(savedOrg);
			}

			String savedResp = c.getResponsibility();
			String fullResp = null;
			if (savedResp != null) {
				fullResp = savedResp;
			}

			StringBuilder sb = new StringBuilder();
			sb.append('"').append(c.getEmployeeNumber().toString().trim())
					.append('"').append(",").append('"')
					.append(c.getFirstname().trim()).append('"').append(",")
					.append('"').append(c.getSurname().trim()).append('"')
					.append(",").append('"').append(c.getArtname().trim())
					.append('"').append(",").append('"')
					.append(c.getEmptype().trim()).append('"').append(",");					
			
			if (fullOrg != null) {
				   sb.append('"').append(fullOrg).append('"');
				}
			sb.append(",");
			
			if (fullOrg != null) {
				   sb.append('"').append(fullResp).append('"');
				}
			
			/*
			 * csvStr = '"' + c.getEmployeeNumber().toString().trim() + '"' +
			 * "," + '"' + c.getFirstname().trim() + '"' + "," + '"' +
			 * c.getSurname().trim() + '"' + "," + '"' + c.getArtname().trim() +
			 * '"' + "," + '"' + c.getEmptype().trim() + '"' + "," + '"' +
			 * fullOrg + '"' + "," + '"' + fullResp + '"';
			 */

			fw.write(sb + "\n");
		}
		fw.close();
	}
}

/* old variant without new column 'orgpath' */
// //////////////////////////////////////////////////////////////////////////////////////
/*
 * public class CsvWriter {
 * 
 * public CsvWriter(ArrayList<UserJpa> users, String path) throws IOException {
 * final FileWriter fw = new FileWriter(path); String csvStr;
 * 
 * fw.write("\"empnum\",\"firstname\",\"lastname\",\"artname\",\"emptype\"" +
 * "\n");
 * 
 * for (UserJpa c : users) { csvStr = '"' +
 * c.getEmployeeNumber().toString().trim() + '"' + "," + '"' +
 * c.getFirstname().trim() + '"' + "," + '"' + c.getSurname().trim() + '"' + ","
 * + '"' + c.getArtname().trim() + '"' + "," + '"' + c.getEmptype().trim() +
 * '"'; fw.write(csvStr + "\n"); }
 * 
 * fw.close(); } }
 */
