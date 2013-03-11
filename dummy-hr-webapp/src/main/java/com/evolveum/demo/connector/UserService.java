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

public class UserService implements Serializable{
	private static UserService userService;
	private static Configuration config;
	private static Connection connection = connect();
	
	
	public static synchronized UserService getInstance() {
		if(userService == null){
			userService = new UserService();
		}
		return userService;
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


	public void registerUser(String firstname, String surname, String email, Integer number, String artname, String emptype) throws SQLException, UserAlreadyExistsException{
		Statement st = null; 
		ResultSet rs = null;
    	
    	Random generator = new Random();
    	int id = generator.nextInt(300);
		
		if (connection !=  null){
			if(checkIfUserExists(firstname, surname, email)){
					PreparedStatement ps = connection.prepareStatement("INSERT INTO usershr(id, firstname, surname, emailAddress, employeeNumber, artname, emptype) VALUES (?, ?, ?, ?, ? ,?, CAST(? AS emp));");
					ps.setString(2, firstname.trim());
					ps.setString(3, surname.trim());
					ps.setString(4, email.trim());
					ps.setInt(5 , number);
					ps.setInt(1, id);
					ps.setString(6, artname.trim());
					ps.setString(7, emptype);
					
					Integer i = ps.executeUpdate();
					System.out.println(i.toString());
			}
			else{
				throw new UserAlreadyExistsException();
			}
		}
	}
	
	public void modifyUser(String firstname, String surname, String email, Integer number, Integer id, String artname, String emptype) throws SQLException{
		ResultSet rs = null;
		
			PreparedStatement ps = connection.prepareStatement("UPDATE usershr SET firstname=?, surname=?, emailaddress=?, employeenumber=?, artname=?, emptype= CAST(? AS emp) WHERE id = ? ");
			ps.setString(1, firstname);
			ps.setString(2, surname);
			ps.setString(3, email);
			ps.setInt(4 , number );
			ps.setInt(7, id);
			ps.setString(5, artname);
			ps.setString(6, emptype.toString());
			
			ps.executeUpdate();
	}
	
	public void deleteUser(Integer id){
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM usershr WHERE id = ? ");
			ps.setInt(1, id);
			
			ps.execute();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<User> listAllUsers() throws SQLException{
		ResultSet rs = null;
		ArrayList users = new ArrayList<User>();
		
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM usershr");
		rs = ps.executeQuery();
			
		while(rs.next()){
			User u = new User(rs.getString("firstname"), rs.getString("surname"),rs.getString("emailAddress"),rs.getInt("employeeNumber"), rs.getInt("id"), rs.getString("artname"), rs.getString("emptype"));
			users.add(u);
		}
		return users;
	}
	
	public User showUser(Integer id) throws Exception{
		ResultSet rs = null;
		User user = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM usershr WHERE id = ?");
			ps.setInt(1, id );
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				user = new User(rs.getString("firstname").trim(), rs.getString("surname").trim(),rs.getString("emailAddress").trim(),rs.getInt("employeeNumber"), rs.getInt("id"),rs.getString("artname").trim(),rs.getString("emptype"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public boolean checkIfUserExists(String firstname, String surname, String emailAddress){
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM usershr WHERE firstname = ? AND surname = ? OR emailAddress = ?");
			ps.setString(1, firstname);
			ps.setString(2, surname);
			ps.setString(3, emailAddress);
			
			rs = ps.executeQuery();

			if (!rs.isBeforeFirst() ) { 
				 return true; 
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}