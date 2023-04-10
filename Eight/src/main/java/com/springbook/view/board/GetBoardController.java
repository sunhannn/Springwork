package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAOBCP;

public class GetBoardController implements Controller {
	@Autowired
	BoardDAOBCP boardDAO;

	@Override // 리퀘스트
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("글 상세 조회 처리");

//		1. 검색할 게시글 번호 추출
		String seq = request.getParameter("seq");

//			2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));

		BoardVO board = boardDAO.getBoard(vo);

			// 3. 검색결과를 세션에 저장하고
		ModelAndView mav = new ModelAndView();
		// request.setAttribute("boardList",boardList)
		mav.addObject("board", board);
		//jsp의 forward객체의 setPath("board/getBoardList")
		mav.setViewName("board/getBoard");
		return mav;
	}

}
