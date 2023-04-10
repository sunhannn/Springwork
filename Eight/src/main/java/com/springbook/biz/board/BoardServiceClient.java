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
		vo.setTitle("Spring jdbcTemplet �׽�Ʈ3");
		vo.setWriter("������");
		vo.setContent("Spring jdbcTemplet �׽�Ʈ3");
		try {
			boardService.insertBoard(vo);
		} catch (Exception e) {
			System.out.println("��������: " + e.getMessage());
		}

		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("-------->" + board.toString());
		}
		container.close();
	}
}