package com.rays.storeproces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

import com.mysql.cj.jdbc.CallableStatement;

public class StroreProcdureINOUT {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		CallableStatement callStmt = (CallableStatement) conn.prepareCall("{CALL empInOut(?,?)}");

		callStmt.setInt(1, 3);

		callStmt.registerOutParameter(2, Types.INTEGER);

		callStmt.execute();

		System.out.println(callStmt.getInt(2));
	}
}
