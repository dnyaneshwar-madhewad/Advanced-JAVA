package com.cdac.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * TODO: 
 * 1. copy mysql-connector-java-8.0.xx.jar to the src/main/webapp/WEB-INF/lib folder
 * 2. connect to mysql and create a table where we will store user information:
 * CREATE TABLE customer(id int primary key auto_increment, 
 						 name varchar(30),
 						 email varchar(50),
 						 username varchar(15),
 						 password varchar(25));
 * INSERT INTO customer(name, email, username, password) VALUES('Dnyaneshwar', 'dny@gmail.com', 'Dny', '123');
 * similarly insert few more records
 */
public class RegisterService {

	public void register(String name, String email, String username, String password) {
		
			
		Connection conn = null;
		PreparedStatement stmt = null;
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "cdac");
		    stmt = conn.prepareStatement("Insert into customer(name, email, username, password) VALUES(?,?,?,?)");
			stmt.setString(1, name); //substituting ? with the actual value
			stmt.setString(2, email);
			stmt.setString(3, username); //substituting ? with the actual value
			stmt.setString(4, password);
			stmt.executeUpdate();

		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); //rather we should throw some user defined exception
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

}
