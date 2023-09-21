package com.evolveum.demo.exporter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

import com.evolveum.demo.model.UserJpa;
import org.apache.log4j.Logger;

public class CsvWriter {
	public static Logger LOG = Logger.getLogger(CsvWriter.class.getName());
	public CsvWriter(ArrayList<UserJpa> users, String path) throws IOException {

		LOG.info("Initialization of csv writer.");

        if(!(path!=null && !path.isEmpty())){

            throw new IllegalArgumentException("Exception while writing csv file. File path argument is either null or empty.");
        }

		final FileWriter fw = new FileWriter(path);
		//String csvStr;
		LOG.info("Writing header information of the CSV file.");

		fw.write("\"empnum\",\"firstname\",\"surname\",\"artname\",\"emptype\",\"job\",\"status\",\"locality\",\"country\""
				+ "\n");

		if(users !=null && !users.isEmpty())
		{
		for (UserJpa c : users) {

			String aname = c.getArtname();
			String cntry = c.getCountry();
			String fname = c.getFirstname();
			String sname = c.getSurname();
			String etype = c.getEmptype();
			Integer enumber =c.getEmployeeNumber();

			StringBuilder sb = new StringBuilder();
			sb.append('"').append(validateAndReturnObject(enumber))
					.append('"').append(",").append('"')
					.append(validateAndReturnObject(fname)).append('"').append(",")
					.append('"').append(validateAndReturnObject(sname)).append('"')
					.append(",").append('"').append(validateAndReturnObject(aname))
					.append('"').append(",").append('"')
					.append(validateAndReturnObject(etype)).append('"').append(",");

			sb.append('"').append(c.getJob()).append('"');
			sb.append(",");
			sb.append('"').append(c.getStatus()).append('"');
			sb.append(",");
			sb.append('"').append(c.getLocality()).append('"');
			sb.append(",");
			sb.append('"').append(validateAndReturnObject(cntry)).append('"');


			fw.write(sb + "\n");
		}
		} else {

			LOG.info("No users found to export into csv file.");
		}
		fw.close();
	}

    private String validateAndReturnObject(Object o){

       if(o !=null){
           if(o instanceof String){

              if(!((String) o).isEmpty()){
                  return ((String) o).trim();
              } else {

                  return (String) o;
              }
           }

           if (o instanceof Integer){
               if (!o.toString().isEmpty()){

                   return o.toString().trim();
               } else {

                   return "";
               }
           }

           throw new IllegalArgumentException("Parameter is an incompatible type");
       } else {

           return "";
       }

    }
}
