package com.evolveum.demo.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresConnector {

	public Connection connect() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://37.205.10.91/midpoint", "tp04",
					"zelenaburina");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			return connection;
			
		} else {
			System.out.println("Failed to make connection!");
		}
		return connection != null ? connection : null ;

	}

}
