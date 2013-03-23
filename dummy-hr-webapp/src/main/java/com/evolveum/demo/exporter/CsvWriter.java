package com.evolveum.demo.exporter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.evolveum.demo.model.User;
import com.evolveum.demo.model.UserJpa;

public class CsvWriter {


	public CsvWriter(ArrayList<UserJpa> users, String path) throws IOException {
		final FileWriter fw = new FileWriter(path);
		String csvStr;
		
		fw.write("\"empnum\",\"firstname\",\"lastname\",\"artname\",\"emptype\"" + "\n");
		
		for (UserJpa c : users) {
			csvStr = 
					'"'+ c.getEmployeeNumber().toString().trim() + '"' + ","+
					'"'+ c.getFirstname().trim() + '"' +","+
					'"'+ c.getSurname().trim() + '"' +","+
					'"'+ c.getArtname().trim() + '"' +","+
					'"'+ c.getEmptype().trim() + '"' ;
					fw.write(csvStr + "\n");
		}
		
		fw.close();
	}

}
