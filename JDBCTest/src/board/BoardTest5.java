package board;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jdbctest.OracleConnection;

public class BoardTest5 {
	
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Properties prop;
	
	BoardTest5() {
		conn = OracleConnection.getConnection();
		prop = new Properties();
		try {
			prop.load(new FileReader(
					new File("C:/Users/admin/git/githubTest/JDBCTest/src/prop/sql.properties"))
					);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public static void main(String[] args) {
		try {
			BoardTest5 bt5 = new BoardTest5();
			
			List<Board> boardList = bt5.listBoard(); // list
			
			Board board = bt5.selectBoard(11); // select
			
			int result1 = bt5.insertBoard(
				new Board(0, "작성자", "제목", "내용")
			); // insert
			
			int result2 = bt5.updateBoard(
				new Board(11, "수정작성자", "수정제목", "수정내용")
			); // update
			
			int result3 = bt5.deleteBoard(11); // delete
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			OracleConnection.closeConnection(conn, pstmt, rs);
		}
		
	}// main
	
	// 1. list
	List<Board> listBoard() throws SQLException {
		pstmt = conn.prepareStatement(prop.getProperty("LIST_SQL"));
		rs = pstmt.executeQuery();
		List<Board> boardList = new ArrayList<Board>();
		while (rs.next()) {
			Board board = new Board();
			board.setBid(rs.getInt("bid"));
			board.setBwriter(rs.getString("bwriter"));
			board.setBtitle(rs.getString("btitle"));
			board.setBcontent(rs.getString("bcontent"));
			boardList.add(board);
		}
		
		return boardList;
	}
	
	// 2. select
	Board selectBoard(int bid) throws SQLException {
		pstmt = conn.prepareStatement(prop.getProperty("SELECT_SQL"));
		pstmt.setInt(1, bid);
		rs = pstmt.executeQuery();
		Board board = new Board();;
		if (rs.next()) {
			board.setBid(rs.getInt("bid"));
			board.setBwriter(rs.getString("bwriter"));
			board.setBtitle(rs.getString("btitle"));
			board.setBcontent(rs.getString("bcontent"));
		}
		
		return board;
	}
	
	// 3. insert
	int insertBoard(Board board) throws SQLException {
		pstmt = conn.prepareStatement(prop.getProperty("INSERT_SQL"));
		pstmt.setString(1,  board.getBwriter());
		pstmt.setString(2,  board.getBtitle());
		pstmt.setString(3,  board.getBcontent());
		
		return pstmt.executeUpdate();
	}
	
	// 4. update
	int updateBoard(Board board) throws SQLException {
		pstmt = conn.prepareStatement(prop.getProperty("UPDATE_SQL"));
		pstmt.setString(1,  board.getBwriter());
		pstmt.setString(2,  board.getBtitle());
		pstmt.setString(3,  board.getBcontent());
		pstmt.setInt(4, board.getBid());
		
		return pstmt.executeUpdate();
	}
	
	// 5. delete
	int deleteBoard(int bid) throws SQLException {
		pstmt = conn.prepareStatement(prop.getProperty("DELETE_SQL"));
		pstmt.setInt(1, bid);
		
		return pstmt.executeUpdate();
	}

}// class
