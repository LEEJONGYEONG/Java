/*
*Transaction : 작업 단위(묶음), 트랜잭션은 Commit 전까지가 하나의 트랜잭션
*Commit : 데이터베이스에 Transaction 작업을 반영
*	1. DDL (create, alter, drop, truncate ...) : 수행 즉 커밋됨 (RollBack 불가)
*	2. DML (select, insert, update, delete, merge ...)
*				: 커밋하지 전까지는 트랜잭션이 완료되지않음 (데이터베이스에 반영되지 않음)
*RollBack : 현재 Transaction 을 초기화 (데이터베이스에 작업을 반영하지 않음)
*Auto Commit : SQL구문을 수행할때마다 즉시 커밋 (DML이라고해도)
*
*데이터베이스 트랜잭션 처리
*1) conn.setAutoCommit(false); : 오토커밋 방지
*2) DML 구문들을 작성/ 수행시킴, 필요하면 SavePoint 지정
*3) 문제가 없으면 Commit, 문제가 있으면 RollBack 
*/
package board;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

import jdbctest.OracleConnection;

public class BoardTest7 {
	
	private Connection conn;
	private Savepoint sp1;
	private Savepoint sp2;
	
	public BoardTest7() {
		BoardTest5 bt5 = new BoardTest5();
		conn = bt5.getConnection();
		try {
			
			// autocommit 여부 확인
			System.out.println(conn.getAutoCommit());
			
			// 1. 트랜잭션 처리를 위해 autocommit을 false로 설정
			conn.setAutoCommit(false);
			
			// 2. 필요한 sql 구문들을 수행
			Board board = new Board(0, "작성자", "제목", "내용");
			bt5.insertBoard(board);
			
			// 롤백 특정지점 설정
			sp1 = conn.setSavepoint("sp1");
						
			// btitle은 not null인데 null값을 입력해서 강제로 
			Board board2 = new Board(1000, "수정작성자", "수정제목", "수정내용");
			bt5.updateBoard(board2);
			
			sp2 = conn.setSavepoint("sp2");
			
			bt5.deleteBoard(46);
			
			// 3. 커밋
			conn.commit();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			try {
				// 4. 만약 작업중에 예외가 발생하면 롤백 
				conn.rollback();
				// conn.rollback(sp2); 특정 지점으로 롤백
			} catch (SQLException sqle2) {
				sqle2.printStackTrace();
			}
		} finally {
			try {
				// 5. setAutoCommit ture로 설정
				conn.setAutoCommit(true);
			} catch (SQLException sqle) {
			sqle.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new BoardTest7();
	}

}
