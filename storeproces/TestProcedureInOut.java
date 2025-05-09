
package storeproces;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestProcedureInOut {

	/**
	 * 
	 *       -> DELIMITER &&
	       CREATE PROCEDURE empInOut(IN idd INT, OUT s INT)
	         BEGIN 
	            SELECT salary INTO s FROM emp WHERE id = idd;
	       END &&
	 *     
	 */
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		CallableStatement callStmt = conn.prepareCall("{CALL empInOut(?,?)}");

		callStmt.setInt(1, 4);

		callStmt.registerOutParameter(2, Types.INTEGER);

		callStmt.execute();

		System.out.println(callStmt.getInt(2));

	}

}
