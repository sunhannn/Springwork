package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardService = (BoardService) container.getBean("boardService");
//		      BoardDAODBCP boardService = (BoardDAODBCP) container.getBean("boardDAODBCP");

		BoardVO vo = new BoardVO();
		vo.setSeq(13);
		vo.setTitle("Spring jdbcTemplet 테스트3");
		vo.setWriter("관리자");
		vo.setContent("Spring jdbcTemplet 테스트3");
		try {
			boardService.insertBoard(vo);
		} catch (Exception e) {
			System.out.println("에러내용: " + e.getMessage());
		}

		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("-------->" + board.toString());
		}
		container.close();
	}
}