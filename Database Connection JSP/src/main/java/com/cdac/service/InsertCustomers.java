package com.cdac.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertCustomers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
			
			Connection conn = null;
			PreparedStatement stmt = null;
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "cdac");
			    stmt = conn.prepareStatement("Insert into customer(name, email, username, password) VALUES(?,?,?,?)");
				
			    System.out.println("Enter your name");
			    String name=s.nextLine();
			    System.out.println("Enter your email");
			    String email=s.nextLine();
			    System.out.println("Enter your username");
			    String username=s.nextLine();
			    System.out.println("Enter your password");
			    String password=s.nextLine();
			    
			    
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

