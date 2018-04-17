package com.cong.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author cong
 * @date 2018/4/17
 */
public class DBUtil {
    public static final String className = "com.mysql.cj.jdbc.Driver";
    public static final String url="jdbc:mysql://localhost:3306/product?useSSL=true";
    public static final String name = "root";
    public static final String password="980611";


    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(className);
            conn= DriverManager.getConnection(url,name,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
