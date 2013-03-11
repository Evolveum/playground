package com.evolveum.demo.connector;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class PostgresConnector implements Serializable {
	Connection connection = null;
	Configuration config;
	
	public Connection connect() {
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

}
