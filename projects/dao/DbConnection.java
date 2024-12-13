package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnection {
	private static final String SCHEMA = "projects";
	private static final String USER = "projects";
	private static final String PASSWORD = "projects";
	private static final String HOST = "localhost";
	private static final int PORT = 3306;

	public static Connection getConnection() {
		String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER, PASSWORD);
		System.out.println("Connecting with URL = " + url);		
		
//		String url1 = "jdbc:mysql://localhost:3307/projects,\"projects\",\"projects\"";
//		System.out.println("Connecting with URL1 = " + url1);

		try {
			Connection conn = DriverManager.getConnection(url);
			System.out.println("Successfully obtained connection");
			return conn;
		} catch (SQLException e) {
			throw new DbException(e);
		}
	}

}
