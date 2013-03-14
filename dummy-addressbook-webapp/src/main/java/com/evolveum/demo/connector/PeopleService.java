package com.evolveum.demo.connector;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.evolveum.demo.model.People;

public class PeopleService implements Serializable{
	private static PeopleService peopleService;
	private static Configuration config;
	private static Connection connection = connect();
	
	
	public static synchronized PeopleService getInstance() {
		if(peopleService == null){
			peopleService = new PeopleService();
		}
		return peopleService;
	}

	public void UserService(){
		//connection = this.connect();
	}
	
	public static Connection connect() {
		 Connection connection = null;
		 try {
			config = new PropertiesConfiguration("application.properties");
		} catch (ConfigurationException e1) {
			e1.printStackTrace();
		}
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(
					config.getProperty("dbHost").toString(), 
					config.getProperty("dbUsername").toString(),
					config.getProperty("dbPassword").toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (connection != null) {
			//System.out.println("You made it, take control your database now!");
			return connection;
			
		} else {
			//System.out.println("Failed to make connection!");
		}
		return connection != null ? connection : null ;

	}
	
	public ArrayList<People> listAllUsers() throws SQLException{
		ResultSet rs = null;
		ArrayList people = new ArrayList<People>();
		
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM people");
		rs = ps.executeQuery();
			
		while(rs.next()){
			Integer id = rs.getInt("id");
			String username = rs.getString("username");
			String first_name = rs.getString("first_name");
			String last_name = rs.getString("last_name");
			String tel_number = rs.getString("tel_number");
			String fax_number = rs.getString("fax_number");
			String office_id = rs.getString("office_id");
			Integer floor = rs.getInt("floor");
			String street_address = rs.getString("street_address");
			String city = rs.getString("city");
			String country = rs.getString("country");
			String postal_code = rs.getString("postal_code");
			boolean validity = rs.getBoolean("validity");
			Date created = rs.getTimestamp("created");
			Date modified = rs.getTimestamp("modified");
			String password = rs.getString("password");
			
			People p = new People(id, username, first_name, last_name, tel_number, fax_number, office_id, floor, street_address, city, country, postal_code, 
		            validity, created, modified, password);
			people.add(p);

		}
		return people;
	}
}