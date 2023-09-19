package com.evolveum.demo.exporter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.evolveum.demo.model.UserJpa;

public class CsvWriter {

	public CsvWriter(ArrayList<UserJpa> users, String path) throws IOException {
		final FileWriter fw = new FileWriter(path);
		//String csvStr;

		fw.write("\"empnum\",\"firstname\",\"surname\",\"artname\",\"emptype\",\"job\",\"status\",\"locality\",\"country\""
				+ "\n");

		for (UserJpa c : users) {

			StringBuilder sb = new StringBuilder();
			sb.append('"').append(c.getEmployeeNumber().toString().trim())
					.append('"').append(",").append('"')
					.append(c.getFirstname().trim()).append('"').append(",")
					.append('"').append(c.getSurname().trim()).append('"')
					.append(",").append('"').append(c.getArtname().trim())
					.append('"').append(",").append('"')
					.append(c.getEmptype().trim()).append('"').append(",");					
			

			sb.append('"').append(c.getJob()).append('"');
			sb.append(",");
			sb.append('"').append(c.getStatus()).append('"');
			sb.append(",");
			sb.append('"').append(c.getLocality()).append('"');
			sb.append(",");
			sb.append('"').append(c.getCountry()).append('"');


			fw.write(sb + "\n");
		}
		fw.close();
	}
}
