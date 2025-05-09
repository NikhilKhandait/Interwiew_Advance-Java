package com.rays.storeproces;

import java.lang.invoke.CallSite;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class StoreProcesorIN {
	public static void main(String[] args) throws Exception {

		/*
		 * delimiter && create processor empIn(in int c) begin select * from emp where
		 * id = c; end &&
		 */

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");
		
		CallableStatement Callcstm = conn.prepareCall("{CALL EmpIn(?)}");
		
		Callcstm.setInt(1, 7);
		Callcstm.execute();
		
		ResultSet rs = Callcstm.getResultSet();
		
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
		}
	}
}
