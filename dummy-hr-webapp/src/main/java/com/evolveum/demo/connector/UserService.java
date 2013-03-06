package com.evolveum.demo.connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.evolveum.demo.model.User;

public class UserService {
	Connection connection;
	
	public UserService(Connection connection ){
		this.connection = connection;
	}


	public void registerNewUser(String fullName, String givenName, String email, Integer number, Integer id){
		Statement st = null; 
		ResultSet rs = null;
		
		if (connection !=  null){
			if(checkIfUserExists(fullName, givenName, email)){
				try {
					System.out.println("Hi!");
					PreparedStatement ps = connection.prepareStatement("INSERT INTO users(id, fullName, givenName, emailAddress, employeeNumber) VALUES (?, ?, ?, ?, ?);");
					ps.setString(2, fullName);
					ps.setString(3, givenName);
					ps.setString(4, email);
					ps.setInt(5 , number );
					ps.setInt(1, id);
					
					Integer i = ps.executeUpdate();
					System.out.println(i.toString());
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void updateUser(String fullName, String givenName, String email, Integer number, Integer id){
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE users SET fullname=?, givenname=?, emailaddress=?, employeenumber=? WHERE id = ? ");
			ps.setString(1, fullName);
			ps.setString(2, givenName);
			ps.setString(3, email);
			ps.setInt(4 , number );
			ps.setInt(5, id);
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(Integer id){
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM users WHERE id = ? ");
			ps.setInt(1, id);
			
			ps.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<User> listAllUsers(){
		ResultSet rs = null;
		ArrayList users = new ArrayList<User>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM users");
			rs = ps.executeQuery();
			
			while(rs.next()){
				User u = new User(rs.getString("fullName"), rs.getString("givenName"),rs.getString("emailAddress"),rs.getInt("employeeNumber"), rs.getInt("id"));
				users.add(u);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	public User showUser(Integer id){
		ResultSet rs = null;
		User user = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
			ps.setInt(1, id );
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				user = new User(rs.getString("fullName").trim(), rs.getString("givenName").trim(),rs.getString("emailAddress").trim(),rs.getInt("employeeNumber"), rs.getInt("id"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public boolean checkIfUserExists(String fullName, String givenName, String emailAddress){
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE fullName = ? AND givenName = ? OR emailAddress = ?");
			ps.setString(1, fullName);
			ps.setString(2, givenName);
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



