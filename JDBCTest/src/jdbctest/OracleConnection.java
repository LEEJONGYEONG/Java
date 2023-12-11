package jdbctest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class OracleConnection {

	// 데이터베이스 연결 인터페이스
	private static Connection conn;
	private static Properties prop;
	
	static {
		prop = new Properties();
		try {
			prop.load(new FileReader(
					new File("C:/Users/admin/git/githubTest/JDBCTest/src/prop/dbconn.properties"))
			);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	// Oracle JDBC URL : 연결할 오라클 데이터베이스의 경로
	// 형식 > jdbc:oracle:thin:@오라클 서버 아이피:오라클 포트번호:SID
	private static final String JDBC_URL
		= prop.getProperty("JDBC_URL");
	
	// 오라클 데이터베이스 드라이버 클래스명
	private static final String JDBC_DRIVER
		= prop.getProperty("JDBC_DRIVER");
	
	// 계정명
	private static final String JDBC_USER
		= prop.getProperty("JDBC_USER");
	
	// 계정 비밀번호
	private static final String JDBC_PWD
		= prop.getProperty("JDBC_PWD");	
			
	public static Connection getConnection() {
	
		try {
			// 데이터베이스 드라이버클래스를 메모리에 로딩
			Class.forName(JDBC_DRIVER);
			
			// 데이터베이스 커넥션 획득 (conn이 null이 아니면 접속된것!)
			conn = DriverManager.getConnection
					(JDBC_URL, JDBC_USER, JDBC_PWD);
			
			/*
			// 데이터베이스에 보낼 퀴리문 (sql 쓸때 앞뒤 공백 꼭 넣어주기 (오류방지)
			String sql = " select employee_id, emp_name from employees ";
			
			// 쿼리 인테페이스
			Statement stmt = conn.createStatement();
			
			// 퀴리문을 수행한 결과행집합에 대한 커서 획득
			ResultSet rs = stmt.executeQuery(sql);
			
			// 커서를 한행 한행 이동시키면서 결과를 가져옴
			// 데이터베이스의 데이터타입과 자바의 데이터타입을 적절히 맞춰서 가져와야함
			while (rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String empName = rs.getString("emp_name");
				System.out.println(employeeId + ", " + empName);
			}
			*/
			
			return conn;
			
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return null;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		} 
	}// getConnection
	
	public static void closeConnection(
			Connection conn, Statement stmt, ResultSet rs) {
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		
		if (stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		
	} // closeConnection
	
}// class
