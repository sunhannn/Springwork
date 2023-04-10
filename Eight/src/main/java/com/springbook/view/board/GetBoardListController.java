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

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("�� ��� �˻� ó��");

//      request.setCharacterEncoding("utf-8");

		// 1. ����� �Է� ���� ����(�˻� ����� ���߿� ����)
		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		String keyword, condition;
		if (request.getParameter("searchKeyword") == null) {
			keyword = "";
		} else {
			keyword = request.getParameter("searchKeyword");
		}
		if (request.getParameter("searchCondition") == null) {
			condition = "TITLE";
		} else {
			condition = request.getParameter("searchCondition");
		}
		if (condition.equals("TITLE")) {
			vo.setTitle(keyword);
			vo.setContent("");
		} else {
			vo.setTitle("");
			vo.setContent(keyword);
		}
		System.out.println("condition: " + condition);
		System.out.println("keyword: " + keyword);
		System.out.println("vo.getContent(): " + vo.getContent());
		System.out.println("vo.getTitle(): " + vo.getTitle());

		List<BoardVO> boardList = boardDAO.getBoardList(vo, keyword, condition);

		// 3. �˻� ����� ���ǿ� �����ϰ� ���ȭ���� �����Ѵ�.
		ModelAndView mav = new ModelAndView();
		// request.setAttribute�� ���� ����� �Ѵ�.
		mav.addObject("boardList", boardList);
		// forward ��ü�� setPath�� ����. ����������� �⺻���̸�, redirect:�������� ����� ��� �����̷�Ʈ�� ó���ȴ�.
		mav.setViewName("board/getBoardList");
		return mav;
	}
}