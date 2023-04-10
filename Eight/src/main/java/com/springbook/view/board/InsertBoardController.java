package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAOBCP;

public class InsertBoardController implements Controller {

	@Autowired
	BoardDAOBCP boardDAO;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. ����� �Է� ���� ����
//		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);

		boardDAO.insertBoard(vo);

		// 3. ȭ�� �׺���̼�
		ModelAndView mav = new ModelAndView();
		// ������ �̵���� redirect ,viewResolve ��Ÿ�� �Ѵ�.
		mav.setViewName("redirect:getBoardList.do");
		return mav;

	}

}