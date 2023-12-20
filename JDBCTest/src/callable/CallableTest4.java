package callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbctest.OracleConnection;
import oracle.jdbc.OracleTypes;

public class CallableTest4 {
	
	Connection conn;
	CallableStatement cstmt;
	ResultSet rs;
	
	CallableTest4() {
		conn = OracleConnection.getConnection();
		String sql = " {call PROC_CALL_CUR(?,?)} ";
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1,50);
			// 2번쨰 out parameter로 오라클커서를 받는다.
			// oracle.jdbc.OracleTypes.CURSOR 타입을 사용
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			// 쿼리실행
			cstmt.execute();
			// 결과로 받은 커서를 ResultSet으로 형변환
			rs = (ResultSet)cstmt.getObject(2);
			while (rs.next()) {
				System.out.println(
						rs.getInt("employee_id") + " " +
						rs.getString("first_name") + " " +
						rs.getString("last_name") + " "
				);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new CallableTest4();
	}
} // class
