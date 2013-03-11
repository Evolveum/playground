package com.evolveum.demo.exporter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.evolveum.demo.model.User;

public class CsvWriter {


	public CsvWriter(ArrayList<User> users, String path) throws IOException {
		final FileWriter fw = new FileWriter(path);
		String csvStr;

		for (User c : users) {
			csvStr = c.getId().toString() + ";" + c.getFirstname().trim() + ";" + c.getSurname().trim() +  ";" + c.getEmailAddress().trim() + ";" + c.getEmployeeNumber().toString() + ";";
			fw.write(csvStr + "\n");
		}
		
		fw.close();
	}

}
