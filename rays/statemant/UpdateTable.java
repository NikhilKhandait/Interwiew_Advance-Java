package com.rays.statemant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateTable {
public static void main(String[] args) throws Exception {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");
	Statement stmt = conn.createStatement();
	int i = stmt.executeUpdate("update user set num=555 where id = 4");
	
	System.out.println("update.....");
}
}
