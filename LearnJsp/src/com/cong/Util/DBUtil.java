package com.cong.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBUtil {
	public static final String className="com.mysql.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/adresslist";
	public static final String name="root";
	public static final String password = "88071024";
	
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url,name,password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
}
