package com.BridgeLabs.day34;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class DatabaseConnectivity {
	public static void main(String[] args)  {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeepayroll_service? user=root & password=raju");
			System.out.println("Connection established with dbserver");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(connection!=null){
				try{
					connection.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
