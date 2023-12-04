package board;

import board.dao.BoardDao;
import board.service.BoardService;

public class BoardMain extends BoardTemplate {
	
	static BoardService boardService = BoardDao.getInstance();
	
	public static void main(String[] args) {
		
		BoardTemplate bt = new BoardMain();
		bt.printList();
		
		/*
		boardService.deleteBoard(2);
		
		printMiddle();
		
		Board board4 = new Board(4, "제목4", "내용4");
		boardService.registBoard(board4);
		
		printMiddle();
		
		board4.setTitle("수정된제목4");
		board4.setContent("수정된내용4");
		boardService.updateBoard(board4);
		
		printMiddle();
		*/
		
	} //main
	
	@Override
	public void printTop() {
		System.out.println("### 리스트 출력시작");
	}
	
	@Override
	public void printMiddle() {
		// 람다식
		boardService.getBoardList().forEach(bl -> {
			System.out.println("제목 : " + bl.getTitle());
			System.out.println("제목 : " + bl.getContent());
		});
		
	}
	
	@Override
	public void printBottom() {
		System.out.println("### 리스트 출력 끝");
	}
		
} // class
