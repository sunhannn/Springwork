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

	@Override // ������Ʈ
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("�� �� ��ȸ ó��");

//		1. �˻��� �Խñ� ��ȣ ����
		String seq = request.getParameter("seq");

//			2. DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));

		BoardVO board = boardDAO.getBoard(vo);

			// 3. �˻������ ���ǿ� �����ϰ�
		ModelAndView mav = new ModelAndView();
		// request.setAttribute("boardList",boardList)
		mav.addObject("board", board);
		//jsp�� forward��ü�� setPath("board/getBoardList")
		mav.setViewName("board/getBoard");
		return mav;
	}

}