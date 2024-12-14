package com.group11.moviebooking.util;




import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDBUtil {
	private static String DB_URL = "jdbc:mysql://localhost:3306/moviebooking_data";
	private static String USER = "root";
	private static String PASS = "truong22022004";
	
	public static Connection ConnectToDB () {
		try {
			System.out.println("kết nối thàng công");
			return DriverManager.getConnection(DB_URL, USER, PASS);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("kết nối thất bại");
		}
		return null;
	}
}