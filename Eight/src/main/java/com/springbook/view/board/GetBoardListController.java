package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAOBCP;

public class GetBoardListController implements Controller {
	@Autowired
	BoardDAOBCP boardDAO;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글 목록 입력 처리");
//		request.setCharacterEncoding("utf-8");

		// 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
		// 2 .DB 연동 처리

		BoardVO vo = new BoardVO();
		String keyword, condition = null;
		if (request.getParameter("searchKeyword") == null)
			keyword = "";
		else
			keyword = request.getParameter("searchKeyword");

		if (request.getParameter("searchCondition") == null)
			keyword = "";
		else
			keyword = request.getParameter("searchCondition");

		if (condition.equals("TITLE")) {
			vo.setTitle(keyword);
			vo.setContent("");
		} else {
			vo.setTitle("");
			vo.setContent(keyword);
		}
		System.out.println("condition : "+ condition);
		System.out.println("keyword : "+ keyword);
		System.out.println("vo.getContent : "+vo.getContent());
		System.out.println("vo.getTitle : "+vo.getTitle());
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo, keyword, condition);
		
		//3. 검색 결과를 세션에 저장하고 목록 화면을 리턴한다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList",boardList);
		mav.setViewName("board/getBoardList");
		return mav;

	}

}
