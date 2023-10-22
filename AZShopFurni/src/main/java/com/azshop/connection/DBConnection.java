package com.azshop.connection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
	public static final String DB_URL = "jdbc:mysql://google/AZShop?cloudSqlInstance=mysql-web:asia-southeast1:mysql-web-project"
										+ "&socketFactory=com.google.cloud.sql.mysql.SocketFactory"
										+ "&useSSL=false";
	private static String USER_NAME = "admin";
	private static String PASSWORD = "admin";

	private static Connection con;
	
	public static Connection getConnection() throws IOException {
		con = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = (Connection) DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
		} catch (Exception ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
		return (con);
	}
	
}

