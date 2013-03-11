package com.evolveum.demo.connector;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.evolveum.demo.model.User;

public class UserService implements Serializable{
	Connection connection;
	
	public UserService(Connection connection ){
		this.connection = connection;
	}


	public void registerNewUser(String firstname, String surname, String email, Integer number) throws Exception{
		Statement st = null; 
		ResultSet rs = null;
    	
    	Random generator = new Random();
    	int id = generator.nextInt(300);
		
		if (connection !=  null){
			if(checkIfUserExists(firstname, surname, email)){
					PreparedStatement ps = connection.prepareStatement("INSERT INTO users(id, fullName, givenName, emailAddress, employeeNumber) VALUES (?, ?, ?, ?, ?);");
					ps.setString(2, firstname);
					ps.setString(3, surname);
					ps.setString(4, email);
					ps.setInt(5 , number );
					ps.setInt(1, id);
					
					Integer i = ps.executeUpdate();
					System.out.println(i.toString());
			}
			else{
				throw new Exception();
			}
		}
	}
	
	public void updateUser(String firstname, String surname, String email, Integer number, Integer id){
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE users SET fullname=?, givenname=?, emailaddress=?, employeenumber=? WHERE id = ? ");
			ps.setString(1, firstname);
			ps.setString(2, surname);
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
	
	public ArrayList<User> listAllUsers() throws SQLException{
		ResultSet rs = null;
		ArrayList users = new ArrayList<User>();
		
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM users");
		rs = ps.executeQuery();
			
		while(rs.next()){
			User u = new User(rs.getString("fullName"), rs.getString("givenName"),rs.getString("emailAddress"),rs.getInt("employeeNumber"), rs.getInt("id"));
			users.add(u);
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
	
	public boolean checkIfUserExists(String firstname, String surname, String emailAddress){
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE fullName = ? AND givenName = ? OR emailAddress = ?");
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



