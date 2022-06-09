package com.BridgeLabs.day34;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrievingDataFromDB {
	public static void main(String[] args)  {
		String query = "select * from employee_payroll";
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeepayroll_service? user=root & password=raju");
			System.out.println("Connection established with db server");
			statement = connection.createStatement();
			System.out.println("platform created");
			statement.executeQuery(query);
			System.out.println("Data selected form DB");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(statement!=null){
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
