package com.qbryx.managers;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;

public class ConnectionManager {

	public static Connection getConnection(){
		
		Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", "root");
	    connectionProps.put("password", "password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");	   
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/qbryx?user=root&password=root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return conn;
	}
	
	public static PreparedStatement prepareStatement(String query){
		
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return preparedStatement;
	}
	
	public static void closeConnection(){
		try {
			getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
