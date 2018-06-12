package com.netease.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class HelloJdbc {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/cloudstudy";
	static final String USER = "root";
	static final String PASSWORD = "zlf04180908";
	
	public static void helloword() throws ClassNotFoundException{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		//1.装载驱动程序
		Class.forName(JDBC_DRIVER);
		//2.建立数据库连接
		
		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			//3.执行sql语句
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select userName from user");
			//4.获取执行结果
			while (resultSet.next()) {
				System.out.println("Hello "+resultSet.getString("userName"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
					
				}
				if (resultSet != null) {
					resultSet.close();
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
			}
		}
		
		
	}
	public static void main(String[] args) throws ClassNotFoundException{
		helloword();
	} 

}
