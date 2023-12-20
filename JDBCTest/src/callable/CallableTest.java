package callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import jdbctest.OracleConnection;

public class CallableTest {
	
	Connection conn;
	CallableStatement cstmt;
	ResultSet rs;
	
	public CallableTest() {
		conn = OracleConnection.getConnection();
		// CallableStatement의 sql형식
		// {call 프로시저 또는 함수명(인자개수만큼?)}
		String sql = " {call PROC_CALL(?,?)} ";
		try {
			cstmt = conn.prepareCall(sql);
			// java에서 1번 물음표에 100의 값을 송신
			// 즉 dbms는 100의 값을 수신
			cstmt.setInt(1, 100);
			// java에서 2번 place holder를 out파라미터로 등록, 등록할떄 타입을 잘 매핑
			// oracle 이라면......
			// number > Integer, Long
			// char, varchar2 > String
			// date > Timestamp
			cstmt.registerOutParameter(2, Types.INTEGER);
			// CallableStatement 실행
			cstmt.executeUpdate();
			// out parameter를 통해 값을 전달받음
			int deptId = cstmt.getInt(2);
			System.out.println(deptId);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}	
	} // constructor
	
	public static void main(String[] args) {
		new CallableTest();
	}
	
} // class
