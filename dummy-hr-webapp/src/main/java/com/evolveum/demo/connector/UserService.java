package com.evolveum.demo.connector;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.evolveum.demo.errorHandling.UserAlreadyExistsException;
import com.evolveum.demo.model.User;

public class UserService implements Serializable {
	private static UserService userService;
	private static Configuration config;
	private static Connection connection;

	public static synchronized UserService getInstance()
			throws ClassNotFoundException, ConfigurationException, SQLException {
		if (userService == null) {
			userService = new UserService();
			connection = connect();
		}
		return userService;
	}

	public void UserService() {
	}

	public static Connection connect() throws ClassNotFoundException,
			SQLException, ConfigurationException {
		Connection connection = null;
		config = new PropertiesConfiguration("application.properties");

		Class.forName("org.postgresql.Driver");

		connection = DriverManager.getConnection(config.getProperty("dbHost")
				.toString(), config.getProperty("dbUsername").toString(),
				config.getProperty("dbPassword").toString());

		if (connection != null) {
			// System.out.println("You made it, take control your database now!");
			return connection;

		} else {
			// System.out.println("Failed to make connection!");
		}
		return connection != null ? connection : null;

	}

	/* added new column 'orgpath' and 'responsibility' */
	// //////////////////////////////////////////////////////////////////////////////////////

	public void registerUser(String firstname, String surname, Integer number,
							 String status, String locality, String ou,
							 String artname, String emptype, String orgpath,
							 String responsibility, String job) throws SQLException, UserAlreadyExistsException {
		Statement st = null;
		ResultSet rs = null;

		Random generator = new Random();
		int id = generator.nextInt(300);

		if (connection != null) {
			if (checkIfUserExists(firstname, surname)) {
				PreparedStatement ps = connection
						.prepareStatement("INSERT INTO usershr(id, firstname, surname, emailAddress," +
								" employeeNumber, artname, emptype, orgpath, responsibility, job, status, locality, ou)" +
								" VALUES (?, ?, ?, ?, ? ,?, ?, ?, ?);");
				ps.setInt(1, id);
				ps.setString(2, firstname.trim());
				ps.setString(3, surname.trim());
				ps.setString(4, ""); // ps.setString(4, emailAddress);
				ps.setInt(5, number); // ps.setString(5, employeeNumber);
				ps.setString(6, artname.trim());
				ps.setString(7, emptype);
				ps.setString(8, orgpath);
				ps.setString(9, responsibility);
				ps.setString(10, job);
				ps.setString(11, status);
				ps.setString(12, locality);
				ps.setString(13, ou);

				Integer i = ps.executeUpdate();
				System.out.println(i.toString());
			} else {
				throw new UserAlreadyExistsException();
			}
		}
	}

	public void modifyUser(String firstname, String surname, Integer number,
						   String status, String locality, String ou,
						   Integer id, String artname, String emptype,
						   String orgpath, String responsibility, String job) throws SQLException {
		ResultSet rs = null;

		PreparedStatement ps = connection
				.prepareStatement("UPDATE usershr SET firstname=?, surname=?, emailaddress=?, employeenumber=?," +
						" artname=?, emptype= CAST(? AS emp), orgpath= CAST(? AS org)," +
						" responsibility= CAST(? AS resp), job=?, status= CAST(? AS sus), locality=?," +
						" ou=?  WHERE id = ? ");

		ps.setString(1, firstname);
		ps.setString(2, surname);
		ps.setString(3, ""); // ps.setString(3, emailAddress);
		ps.setInt(4, number); // ps.setString(4, employeeNumber);
		ps.setString(5, artname);
		ps.setString(6, emptype.toString());
		ps.setString(7, orgpath.toString());
		ps.setString(8, responsibility.toString());
		ps.setString(9, job);
		ps.setString(10, status);
		ps.setString(11, locality);
		ps.setString(12, ou);
		ps.setInt(13, id);

		ps.executeUpdate();
	}

	public void deleteUser(Integer id) {
		ResultSet rs = null;

		try {
			PreparedStatement ps = connection
					.prepareStatement("DELETE FROM usershr WHERE id = ? ");
			ps.setInt(1, id);

			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<User> listAllUsers() throws SQLException {
		ResultSet rs = null;
		ArrayList users = new ArrayList<User>();

		PreparedStatement ps = connection
				.prepareStatement("SELECT * FROM usershr");
		rs = ps.executeQuery();

		while (rs.next()) {
			User u = new User(rs.getString("firstname"),
					rs.getString("surname"), rs.getInt("employeeNumber"),
					rs.getInt("id"), rs.getString("artname"),
					rs.getString("emptype"),rs.getString("status"),
					rs.getString("locality"),rs.getString("ou"),
					rs.getString("orgpath"),rs.getString("responsibility")
					,rs.getString("job"));
			users.add(u);
		}
		return users;
	}

	public User showUser(Integer id) throws Exception {
		ResultSet rs = null;
		User user = null;

		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM usershr WHERE id = ?");
			ps.setInt(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				user = new User(rs.getString("firstname").trim(), rs.getString(
						"surname").trim(), rs.getInt("employeeNumber"),
						rs.getInt("id"), rs.getString("artname").trim(),
						rs.getString("emptype"),rs.getString("status"),
						rs.getString("locality") ,rs.getString("ou"),
						rs.getString("orgpath"),rs.getString("responsibility")
						,rs.getString("job"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean checkIfUserExists(String firstname, String surname) {
		ResultSet rs = null;

		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM usershr WHERE firstname = ? AND surname = ?");
			ps.setString(1, firstname);
			ps.setString(2, surname);

			rs = ps.executeQuery();

			if (!rs.isBeforeFirst()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
