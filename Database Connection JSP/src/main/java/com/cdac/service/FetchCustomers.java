package com.cdac.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchCustomers {

	public static void main(String args[])
	{
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "cdac");
	    stmt = conn.prepareStatement("select id,name,email from customer");
	    rs=stmt.executeQuery();
		while(rs.next())
		{
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String email=rs.getString("email");
			
			System.out.println(id+" ! "+name+" ! "+email);
			
		
			
		}

	}
	catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace(); //rather we should throw some user defined exception
	}
	finally {
		try { conn.close(); } catch(Exception e) { }
	}
}
}
