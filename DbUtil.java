package com.capgemini.bankapplication.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	
	private static final String DB_URL = "jdbc:mysql://85.10.205.173:3306/clud2_na";
	private static final String USERNAME = "cloud2_na";
	private static final String PASSWORD = "cloud2_na";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
