package callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import jdbctest.OracleConnection;

public class CallableTest2 {
	
	Connection conn;
	CallableStatement cstmt;
	
	CallableTest2 () {
		try {
			conn = OracleConnection.getConnection();
			// function의 경우 sql 문법
			// {?=call 함수명(파라미터수만큼?)}
			String sql = " {?=call FUNC_CALL(?, ?)} ";
			cstmt = conn.prepareCall(sql);
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setInt(2, 10);
			cstmt.setInt(3, 20);
			cstmt.executeUpdate();
			System.out.println(cstmt.getInt(1));
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new CallableTest2();
	}

} // class
