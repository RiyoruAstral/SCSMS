package com.niit.util;

import java.sql.*;


public class JDBCUtil {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jsphomework";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnect(){
        Connection connection = null;
        try {
            //s1
            Class.forName("com.mysql.cj.jdbc.Driver");
            //s2
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("连接成功！");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    private static void closeConnection(Connection conn) {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeResource(ResultSet rs, Statement stmt) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
