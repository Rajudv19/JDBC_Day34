package com.BridgeLabs.day34;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatingData {
	public static void main(String[] args)  {
		String query = "update employee_payroll set salary=15000 where name='Raju'";
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeepayroll_service? user=root & password=raju");
			System.out.println("Connection established with db server");
			statement = connection.createStatement();
			System.out.println("platform created");
			statement.executeUpdate(query);
			System.out.println("Data updated to DB");
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
