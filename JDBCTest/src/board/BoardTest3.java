package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbctest.OracleConnection;

public class BoardTest3 {
	
	public static void main(String[] args) {
		
		Connection conn = OracleConnection.getConnection();
		PreparedStatement pstmt = null;
		Statement stmt= null;
		ResultSet rs = null;
		String sql = null;
		int result = 0;

		/*
		// 1. insert 
		try {
			sql = " insert into board values (seq_board.nextval, ?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  "유관순");
			pstmt.setString(2,  "제목");
			pstmt.setString(3,  "내용");
			result = pstmt.executeUpdate();
			if (result > 0) System.out.println("입력 성공!");
			*/
		
		// 2. update
		try {
			sql = " update board set bwriter=?, btitle=?, bcontent=? ";
			sql += " where bid=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  "수정된 유관순");
			pstmt.setString(2,  "수정된 제목");
			pstmt.setString(3,  "수정된 내용");
			pstmt.setInt(4, 32);
			result = pstmt.executeUpdate();
			if (result > 0) System.out.println("입력 성공!");
			
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			OracleConnection.closeConnection(conn, stmt, rs);
		}
		
	}// main

}// class
